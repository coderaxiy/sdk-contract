# Orders & Payments API — Frontend Integration Guide

Backend implementation of `04-orders-and-payments.md`. All paths below are
relative to the API base (`/api/v1`), e.g. `GET /api/v1/cart`. This is the
most operationally sensitive module so far — read the state-machine and
money-handling sections carefully before wiring checkout/refund UI.

## Auth

Same cookie-based auth as the rest of the app (`access_token` httpOnly
cookie — `credentials: 'include'` on every request).

- **Buyer** endpoints (`/cart`, `/checkout`, `/orders`, `/order-lines`,
  `/refund-requests`) require only a logged-in user — no seller/buyer role
  distinction exists; any authenticated user can shop.
- **Seller** endpoints require a `Seller` record and shop ownership
  (`403` otherwise).
- **Admin** endpoints require `orders:manage` (orders/refunds) or
  `finance:manage` (ledger/payouts) permissions — these are two separate
  permissions, so an admin role might have one without the other.

## Error shape

Same as the products API (`{"detail": "..."}` for `400`/`403`/`404`,
FastAPI's structured array for `422`). **One exception**: checkout price
mismatches return a structured `detail` object instead of a string —
handle this specifically (see §2 below).

---

## 1. Core concepts

### Cart → Checkout → Order, in one picture

```
Cart (active, one per buyer)
  └─ CartItem × N
        │  POST /checkout
        ▼
Order (pending_payment) ── created immediately, before payment succeeds
  │
  ├─ online payment (payme/click/uzcard): redirected to gateway,
  │    order stays pending_payment until the gateway webhook fires
  │
  └─ cash_on_delivery: finalized immediately, no redirect
        │
        ▼
Order (paid) ── OrderShopGroup × N created (one per shop in the cart)
                    └─ OrderLine × N (one per product/variant)
```

A single checkout can span multiple shops — the frontend deals with one
`Order`, but fulfillment, cancellation, and refunds all happen at the
**`OrderShopGroup`** level (per shop) and **`OrderLine`** level (per item).
Don't build UI that treats an order as having one fulfillment status — show
each shop's group separately on the order detail page.

### `Order.status` — buyer-visible rollup, not directly controlled

```
pending_payment ──(payment succeeds)──▶ paid ──▶ partially_fulfilled ──▶ completed
       │                                  │
       └──(payment fails/expires)──▶ payment_failed
                                          │
                                    (all groups cancelled)──▶ cancelled
```

This is **computed** from the child `OrderShopGroup` statuses — never set
directly. After any group-status action, re-fetch the order (or just trust
the group-level response) rather than assuming the top-level `status` field
you last saw is still accurate.

### `OrderShopGroup.status` — the real fulfillment state machine

```
pending ──▶ confirmed ──▶ preparing ──▶ shipped ──▶ delivered ──▶ return_requested ──▶ returned ──▶ refunded
   │            │              │                                        │
   └────────────┴──────────────┴──▶ cancelled (before shipping)         └──▶ delivered (return rejected, reverts)
```

- **Free buyer cancellation** (`POST /orders/{id}/groups/{group_id}/cancel`)
  only works while a group is `pending` or `confirmed` — once a seller marks
  it `preparing`, the buyer-facing cancel button should disable/disappear
  (the API returns `400` if you call it anyway, but don't rely on that —
  check `group.status` client-side to avoid a dead-end click).
- Sellers drive the rest of the fulfillment flow via
  `PATCH /seller/order-groups/{id}/status` — only forward transitions in the
  diagram above are valid; anything else is a `400`.

### `OrderLine.status`

Independent of the group's status — tracks per-line refund outcomes:
`active → returned` (physical item came back) or `active → refunded`
(direct refund, e.g. item never arrived — no physical return involved).

### Cash on Delivery is a first-class payment method with different timing

This is the one thing that's easy to get wrong in the UI: **for COD orders,
the seller's commission and payout ledger entries are not created until the
`OrderShopGroup` reaches `delivered`** — not at checkout, unlike every other
payment method. Buyer-facing UI doesn't need to care about this (the order
still shows `paid` immediately after COD checkout, same as online payment),
but if you're building **seller-facing earnings/ledger views**, be aware a
COD sale won't show up in the seller's ledger balance until the buyer
actually receives the item — this is expected, not a bug.

### Money fields are strings, not numbers

Every `Decimal` field (`price_snapshot`, `total_amount`, `subtotal`,
`unit_price`, `line_total`, `amount`, `refund_amount`, etc.) is serialized
as a **JSON string** (e.g. `"45000.00"`), same as the products API. Parse
before formatting; don't do arithmetic on the raw string.

### Return window

Buyers can only request a refund/return on a **delivered** line, within a
window that's **category-specific** (falls back to a 14-day platform
default if the category doesn't set one — this isn't exposed to the
frontend directly; the API just returns `400` with a clear message once the
window has passed). There's no endpoint to check the remaining window
in advance — if you want to show a countdown, you'd need the category's
`return_window_days` from `GET /seller/categories/{id}` /
`GET /admin/categories/{id}` (Doc 02/03 API) combined with the group's
delivery date, which isn't currently exposed on `OrderShopGroupRead` either
— flag to backend if the buyer order-detail page needs this.

---

## 2. Checkout flow — buyer-facing

1. Build the cart via `GET /cart` / `POST /cart/items` / `PATCH /cart/items/{id}` / `DELETE /cart/items/{id}`.
2. Collect shipping address (see `ShippingAddressIn` shape below) and let
   the buyer pick a payment method.
3. Call `POST /checkout` with `{ shipping_address, payment_method }`.
4. **Handle the price-mismatch case** — this is a `400` with a structured body:
   ```json
   {
     "detail": {
       "error": "price_changed",
       "items": [
         { "product_id": 12, "variant_id": null, "old_price": "45000.00", "new_price": "48000.00" }
       ]
     }
   }
   ```
   Show the buyer the old vs. new price for each affected item and let them
   confirm before retrying checkout (the server never silently charges a
   different price than what was in the cart). A plain stock-insufficient
   error is a normal string-detail `400` — handle it like any other error.
5. On success (`CheckoutResponse`):
   - `payment_method = cash_on_delivery` → `payment_redirect_url` is `null`.
     The order is already `paid`/confirmed — redirect straight to the order
     confirmation page using `order_id`/`order_number`.
   - Any other payment method → redirect the buyer to `payment_redirect_url`
     (currently a placeholder URL — **real gateway integration isn't built
     yet**, this is explicitly out of scope for this doc; don't wire real
     Payme/Click/Uzcard flows against it yet).
6. Reserved stock expires after **15 minutes** if payment isn't completed —
   show a countdown/timeout state on the payment-redirect page if you can;
   after expiry the order flips to `payment_failed` automatically.

### `ShippingAddressIn` shape

```ts
{
  full_name: string
  phone: string
  address_line: string
  city: string
  region?: string
  postal_code?: string
  notes?: string
}
```

This is a structured addition on top of the spec (which left the address
shape unspecified) — there's no address-book/saved-addresses feature, the
buyer re-enters this every checkout.

---

## 3. Endpoints

### 3.1 Buyer-facing

| Method | Path | Notes |
|---|---|---|
| GET | `/cart` | Creates an empty cart on first call |
| POST | `/cart/items` | `{ product_id, variant_id?, quantity }` — adding an existing item increments quantity |
| PATCH | `/cart/items/{id}` | `{ quantity }` |
| DELETE | `/cart/items/{id}` | `204` |
| POST | `/checkout` | See §2 |
| GET | `/orders` | Buyer's own orders, all shops |
| GET | `/orders/{id}` | Full detail incl. all shop groups |
| POST | `/orders/{id}/groups/{group_id}/cancel` | `{ reason }` — only while group is `pending`/`confirmed` |
| POST | `/order-lines/{id}/refund-request` | `{ reason_code, reason_text?, evidence_urls?, refund_amount? }` — line must belong to a `delivered` group, within the return window |
| GET | `/refund-requests/{id}` | Visible to the requester or the seller who owns the shop |
| POST | `/refund-requests/{id}/escalate` | Not in the original spec's endpoint table but required by the dispute flow — call this when a buyer disputes a seller's rejection (only valid on a `rejected` request) |

### 3.2 Seller-facing

| Method | Path | Notes |
|---|---|---|
| GET | `/seller/shops/{shop_id}/order-groups` | Query: `status` |
| GET | `/seller/order-groups/{id}` | |
| PATCH | `/seller/order-groups/{id}/status` | `{ status, reason? }` — `reason` is used for `cancelled`, ignored otherwise |
| GET | `/seller/shops/{shop_id}/refund-requests` | Query: `status` |
| PATCH | `/seller/refund-requests/{id}/approve` | `{ who_bears_cost, refund_amount }` |
| PATCH | `/seller/refund-requests/{id}/reject` | `{ reason }` |
| GET | `/seller/shops/{shop_id}/ledger` | Query (**required**): `period_start`, `period_end` (ISO datetimes) — returns entries + computed balance for that window |
| GET | `/seller/shops/{shop_id}/payouts` | Full history, all statuses |

### 3.3 Admin

RBAC as noted — `orders:manage` for the first group, `finance:manage` for the second.

| Method | Path | Purpose |
|---|---|---|
| GET | `/admin/orders` | Query: `status`, `shop_id`, `buyer_id`, `date_from`, `date_to` |
| GET | `/admin/orders/{id}` | Includes commission/payout fields (admin-only view) |
| GET | `/admin/refund-requests` | Query: `status` — use `status=escalated_to_admin` for the dispute queue |
| PATCH | `/admin/refund-requests/{id}/resolve` | `{ who_bears_cost, refund_amount, reason }` — same effect as a seller approval, just admin-triggered and final |
| GET | `/admin/ledger/{shop_id}` | Query (**required**): `period_start`, `period_end` |
| POST | `/admin/ledger/{shop_id}/manual-adjustment` | `{ amount, note }` — `note` required, heavily audited |
| GET | `/admin/payouts` | Query: `status`, `shop_id` |
| POST | `/admin/payouts/run` | `{ period_start, period_end }` — manually triggers a payout batch. **There is no automatic scheduler** — payouts only happen when an admin calls this (deliberate: money-movement batch jobs shouldn't run unattended without operational visibility). If you're building an admin payout page, this button is the only way payouts happen right now. |
| PATCH | `/admin/payouts/{id}/retry` | Only valid on a `failed` payout |

---

## 4. Response shapes (key fields)

### `CartRead`
```ts
{
  id: number
  buyer_id: number
  status: string  // "active" | "checked_out" | "abandoned"
  items: { id, product_id, variant_id, quantity, price_snapshot: string, added_at }[]
  created_at: string
  updated_at: string
}
```
`price_snapshot` is informational only — the real price is re-verified at
checkout (§2). Don't use it as the "current price" anywhere in the UI; refetch
product data for that.

### `OrderRead` (buyer-facing — no commission/payout fields)
```ts
{
  id: number
  buyer_id: number
  order_number: string          // "ORD-2026-000123"
  status: "pending_payment" | "paid" | "partially_fulfilled" | "completed" | "cancelled" | "payment_failed"
  total_amount: string
  shipping_address: { full_name, phone, address_line, city, region?, postal_code?, notes? }
  payment_method: "payme" | "click" | "uzcard" | "cash_on_delivery"
  payment_reference: string | null
  placed_at: string | null
  created_at: string
  updated_at: string
  groups: OrderShopGroupRead[]
}
```

### `OrderShopGroupRead` (buyer-facing)
```ts
{
  id: number
  order_id: number
  shop_id: number
  status: "pending" | "confirmed" | "preparing" | "shipped" | "delivered" | "cancelled" | "return_requested" | "returned" | "refunded"
  subtotal: string
  shipping_fee: string           // currently always "0.00" — shipping-fee calculation is a future logistics doc
  cancellation_reason: string | null
  lines: OrderLineRead[]
  created_at: string
  updated_at: string
}
```
Seller/admin views (`GET /seller/order-groups/{id}`, `GET /admin/orders/{id}`)
return the same shape **plus** `commission_total` and `payout_amount` —
never shown to buyers.

### `OrderLineRead` (buyer-facing)
```ts
{
  id: number
  product_id: number
  variant_id: number | null
  product_title_snapshot: string   // frozen at purchase — may differ from the live product now
  sku_snapshot: string
  unit_price: string
  quantity: number
  line_total: string
  status: "active" | "returned" | "refunded"
  created_at: string
}
```
Seller/admin lines additionally include `commission_rule_id` and
`commission_amount` (both `null` on a COD line until the group is
`delivered` — see §1).

### `RefundRequestRead`
```ts
{
  id, order_line_id, requested_by: "buyer" | "seller" | "admin", requester_user_id,
  reason_code: "defective" | "not_as_described" | "wrong_item" | "changed_mind" | "never_arrived" | "other",
  reason_text: string | null,
  status: "pending" | "approved" | "rejected" | "escalated_to_admin",
  refund_amount: string,
  who_bears_cost: "seller" | "platform" | "buyer" | null,  // null until resolved
  evidence_urls: string[] | null,
  resolved_by: number | null,
  resolved_at: string | null,
  created_at: string,
}
```

### `LedgerStatementRead` / `PayoutRead`
```ts
// GET /seller/shops/{id}/ledger and /admin/ledger/{id}
{
  shop_id: number
  period_start: string
  period_end: string
  balance: string              // sum of all entries ever, not just this period
  entries: {
    id, shop_id,
    entry_type: "sale_credit" | "commission_debit" | "refund_debit" | "refund_commission_reversal"
              | "platform_absorbed_refund" | "payout_debit" | "manual_adjustment",
    amount: string,             // positive = credit, negative = debit
    reference_type: string | null, reference_id: number | null,
    note: string | null, created_by: number | null, payout_id: number | null,
    created_at: string,
  }[]
}

// GET /seller/shops/{id}/payouts, /admin/payouts
{
  id, shop_id, bank_account_id, amount: string,
  status: "scheduled" | "processing" | "paid" | "failed",
  period_start: string, period_end: string,
  failure_reason: string | null, paid_at: string | null, created_at: string,
}
```
Note `balance` is a running total across the shop's **entire ledger history**,
not scoped to `period_start`/`period_end` — only `entries` is scoped to the
requested window. Don't sum `entries` yourself and expect it to equal
`balance`.

---

## 5. Suggested integration order

1. Cart pages (`GET /cart`, add/update/remove) — straightforward CRUD.
2. Checkout flow, including the price-mismatch confirmation dialog (§2) —
   this is the trickiest UI piece; test it by editing a product's price in
   another tab mid-checkout.
3. Buyer order list/detail pages, with per-group status display and the
   free-cancellation button (only while `pending`/`confirmed`).
4. Buyer refund-request flow (only enabled on `delivered` lines) + refund
   status tracking + the escalate action on a rejected request.
5. Seller order-group management (list, detail, status transitions).
6. Seller refund approve/reject queue.
7. Seller ledger/payout statement views (date-range pickers, since both
   endpoints require `period_start`/`period_end`).
8. Admin: order/refund oversight, then ledger/manual-adjustment, then the
   payout-run + retry tooling last (lowest traffic, highest care needed).

## 6. Known gaps / things not yet wired up

- No real payment gateway integration (Payme/Click/Uzcard) — `payment_redirect_url` is a placeholder.
- No automatic payout scheduler — `POST /admin/payouts/run` must be triggered manually (or by an external cron hitting it).
- No endpoint exposes a category's `return_window_days` or a group's remaining return-window time directly — only the pass/fail result when a refund is actually requested.
- Shipping fee is always `0` — logistics/rate calculation is a separate future doc.
