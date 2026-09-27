# Orders & Payments API — Frontend Integration Guide

Backend implementation of `04-orders-and-payments.md`. All paths below are
relative to the API base (`/api/v1`), e.g. `GET /api/v1/cart`. This is the
most operationally sensitive module so far — read the state-machine and
money-handling sections carefully before wiring checkout/refund UI.

## Auth

Same cookie-based auth as the rest of the app (`access_token` httpOnly
cookie — `credentials: 'include'` on every request).

- **Cart** endpoints (`/cart`, `/cart/items...`) work **without logging in**,
  through a guest cart (§3.1). An `access_token` that's sent but invalid or
  expired is still `401`.
- The other **buyer** endpoints (`/checkout`, `/orders`, `/order-lines`,
  `/refund-requests`) require a logged-in user. No seller/buyer role
  distinction exists; any authenticated user can shop. `POST /checkout` from a
  guest is `401` → send the buyer to log in, then back to checkout.
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
Cart (active, one per buyer — or per guest, merged into the buyer's on login)
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

Every order is collected by the buyer at the pickup point they chose at
checkout. Sellers bring goods to the platform's **central store**; warehouse
staff send them on to the pickup point.

```
pending ─▶ confirmed ─▶ preparing ─▶ at_warehouse ─▶ shipped ─▶ arrived_at_point ─▶ delivered
 seller     seller       seller      warehouse        warehouse   pickup point        buyer collects
   │           │            │         received it     sent it to  checked it in       (or partially_collected,
   └───────────┴────────────┴──▶ cancelled             the point                      rejected_by_buyer,
                                                                                      return_to_seller)

delivered ──(refund rollup, computed from the lines)──▶ return_requested | partially_refunded | refunded
```

- `at_warehouse`: the seller brought the goods and the central store received
  them (`warehouse_received_at` on the group).
- `shipped`: on the way from the central store to the buyer's pickup point.
- `arrived_at_point` onwards: see `docs/logistics-and-pickup-points-api.md`.

After `delivered`, the group status is **computed from its lines** every time a
refund changes one of them. Nobody sets it directly:

| Lines | Group status |
|---|---|
| any line `return_pending` | `return_requested` |
| otherwise, all lines `refunded` | `refunded` |
| otherwise, some lines `refunded` | `partially_refunded` |
| no refund activity | unchanged (`delivered`) |

A pending or rejected refund request doesn't change anything: the group stays
`delivered` until a refund is approved.

- **Free buyer cancellation** (`POST /orders/{id}/groups/{group_id}/cancel`)
  only works while a group is `pending` or `confirmed` — once a seller marks
  it `preparing`, the buyer-facing cancel button should disable/disappear
  (the API returns `400` if you call it anyway, but don't rely on that —
  check `group.status` client-side to avoid a dead-end click).
- Sellers use `PATCH /seller/order-groups/{id}/status` only up to
  `preparing`. It accepts **only** these transitions; anything else is `400`:

  | From | Seller may set |
  |---|---|
  | `pending` | `confirmed`, `cancelled` |
  | `confirmed` | `preparing`, `cancelled` |
  | `preparing` | `cancelled` |

  After `preparing` the seller brings the goods to the central store. Every
  later status is set by warehouse staff, pickup-point staff, the buyer's
  collection, or the refund rollup above. Sellers don't choose or see the
  pickup point.

### `OrderLine.status`

Set only by the refund flow:

```
active ──(refund approved, reason needs the item back)──▶ return_pending ──(seller confirms the item is back)──▶ refunded
active ──(refund approved, reason needs no return: never_arrived)──────────────────────────────────────────────▶ refunded
```

`physical_return_received_at` records when the seller confirmed the item back.
A pending or rejected refund request leaves the line `active`.

### Cash on Delivery is a first-class payment method with different timing

This is the one thing that's easy to get wrong in the UI: **for COD orders,
the seller's commission and payout ledger entries are not created until the
buyer collects and pays for each item at the pickup point** — per item, not at
checkout, unlike every other payment method. Buyer-facing UI doesn't need to
care about this (the order still shows `paid` immediately after COD checkout,
same as online payment), but if you're building **seller-facing
earnings/ledger views**, be aware a COD sale won't show up in the seller's
ledger balance until the buyer collects it — this is expected, not a bug.

### Money fields are strings, not numbers

Every `Decimal` field (`price_snapshot`, `total_amount`, `subtotal`,
`unit_price`, `line_total`, `amount`, `refund_amount`, etc.) is serialized
as a **JSON string** (e.g. `"45000.00"`), same as the products API. Parse
before formatting; don't do arithmetic on the raw string.

### Refunds are all-or-nothing, per product

A refund request covers one order line, and its `refund_amount` is always that
line's full `line_total`, fixed when the buyer creates the request. Nobody
sends an amount: not the buyer, the seller, or an admin. Approving refunds the
full price; rejecting refunds nothing. There's no partial approval.

**Money moves only once the item is back.** Whether a return is needed depends
on `reason_code`:

| `reason_code` | Item must come back? | Shipping refunded? |
|---|---|---|
| `defective` | yes | yes |
| `not_as_described` | yes | yes |
| `wrong_item` | yes | yes |
| `never_arrived` | no | yes |
| `changed_mind` | yes | no |
| `other` | yes | no |

- Approving a `never_arrived` request settles immediately: line → `refunded`,
  ledger entries written.
- Approving any other reason moves the line to `return_pending` and writes
  nothing yet. When the item arrives, the seller calls
  `POST /seller/refund-requests/{id}/confirm-return` (`{ condition_note? }`):
  line → `refunded`, ledger entries written. `400` unless the request is
  `approved` and its line is `return_pending`.
- The "shipping refunded" column isn't applied yet: `shipping_fee` is always
  `0` until logistics sets real fees. The planned rule (not final) is to refund
  the group's shipping once, when its last line is refunded.

**Who resolves what:**

- **Seller** (`PATCH /seller/refund-requests/{id}/approve | reject`): only
  `pending` requests (`400` otherwise, including `"This refund request has
  been escalated to an admin"`). A seller approval is always at the seller's
  cost: `who_bears_cost` may be omitted, and anything other than `"seller"` is
  `400`.
- **Buyer** (`POST /refund-requests/{id}/escalate`): once, on a request the
  seller rejected. `escalated_at` is set; a second escalation is `400`.
- **Admin** (`PATCH /admin/refund-requests/{id}/resolve`): only
  `escalated_to_admin` requests, and final.
  `{ decision: "approve", who_bears_cost, reason }` approves (same return and
  settlement rules as above); `{ decision: "reject", reason }` closes it as
  `rejected`, line stays `active`.

**Ledger, by `who_bears_cost`:**

- `seller`: `refund_debit` of the full amount and `refund_commission_reversal`
  of the line's full commission.
- `platform`: a zero-amount `platform_absorbed_refund` record; the seller's
  payout is unaffected.

There's no `buyer` option: every approved refund returns the full price, so the
buyer never bears the product's cost. The only thing a buyer can lose is the
shipping fee, per the table above.

### Return window

Buyers can only request a refund/return on a **delivered** line, within a
window that's **category-specific** (falls back to a 14-day platform
default if the category doesn't set one — this isn't exposed to the
frontend directly; the API just returns `400` with a clear message once the
window has passed). There's no endpoint to check the remaining window
in advance — if you want to show a countdown, you'd need the category's
`return_window_days` from `GET /seller/categories/{id}` /
`GET /admin/categories/{id}` (Doc 02/03 API) combined with the
group's `delivered_at`.

---

## 2. Checkout flow — buyer-facing

1. Build the cart via `GET /cart` / `POST /cart/items` / `PATCH /cart/items/{id}` / `DELETE /cart/items/{id}`.
2. **Pickup point.** Call `GET /pickup-points/last-used`. If it returns a
   point, pre-select it ("You picked this point last time") so the buyer can
   just confirm. It's `null` for a first order or when that point has closed.
   To choose another: `GET /pickup-points/nearby?lat&lng` (by location) or
   `GET /regions` + `GET /pickup-points?region_id=` (by region). One point
   covers the whole order, all shops included.
3. Collect the **recipient** (name and phone the pickup point checks against)
   and the payment method.
4. Call `POST /checkout` with
   `{ recipient: { full_name, phone, notes? }, pickup_point_id, payment_method }`.
   A point that isn't active: `400 "This pickup point isn't available — choose another one"`.
5. **Handle the price-mismatch case** — this is a `400` with a structured body:
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
   different price than what was in the cart). Confirming = `PATCH
   /cart/items/{id}` with the unchanged quantity for each affected line, which
   moves its `price_snapshot` to the current price (§4 `CartItemRead`). A plain stock-insufficient
   error is a normal string-detail `400` — handle it like any other error.
6. On success (`CheckoutResponse`):
   - `payment_method = cash_on_delivery` → `payment_redirect_url` is `null`.
     The order is already `paid`/confirmed — redirect straight to the order
     confirmation page using `order_id`/`order_number`.
   - Any other payment method → redirect the buyer to `payment_redirect_url`
     (currently a placeholder URL — **real gateway integration isn't built
     yet**, this is explicitly out of scope for this doc; don't wire real
     Payme/Click/Uzcard flows against it yet).
7. Reserved stock expires after **15 minutes** if payment isn't completed —
   show a countdown/timeout state on the payment-redirect page if you can;
   after expiry the order flips to `payment_failed` automatically.

### `Recipient` shape

```ts
{
  full_name: string   // 1–255 chars
  phone: string       // 5–30 chars
  notes?: string | null
}
```

There's no delivery address: every order is collected at a pickup point. There's
no saved-recipient feature yet; prefill from the user's profile if you have it.

---

## 3. Endpoints

### 3.1 Buyer-facing

| Method | Path | Notes |
|---|---|---|
| GET | `/cart` | `CartRead` (§4). Creates an empty cart on first call |
| POST | `/cart/items` | `{ product_id, variant_id?, quantity }` → `201 CartItemRead`. Adding a line already in the cart adds to its quantity |
| PATCH | `/cart/items/{id}` | `{ quantity }` (sets it) → `CartItemRead`. Also sets `price_snapshot` to the current price |
| DELETE | `/cart/items/{id}` | `204` |
| POST | `/checkout` | See §2 |
| GET | `/orders` | Buyer's own orders, all shops |
| GET | `/orders/{id}` | Full detail incl. all shop groups |
| POST | `/orders/{id}/groups/{group_id}/cancel` | `{ reason }` — only while group is `pending`/`confirmed` |
| POST | `/order-lines/{id}/refund-request` | `{ reason_code, reason_text?, evidence_urls? }` — line must belong to a `delivered` group, within the return window. `refund_amount` is set to the line's `line_total` (see "Refunds are all-or-nothing") |
| GET | `/refund-requests/{id}` | Visible to the requester or the seller who owns the shop |
| POST | `/refund-requests/{id}/escalate` | Call when a buyer disputes a seller's rejection. Only on a `rejected` request that hasn't been escalated before (`escalated_at` is null) |

#### Guest cart

- Without `access_token`, the cart endpoints use a **guest cart** identified by
  the httpOnly cookie **`cart_token`**. The server creates the cart and sets
  the cookie on the first call. It's re-set on every guest cart response
  (sliding 30-day expiry) with the same `Secure`/`SameSite` settings as
  `access_token`. Just send credentials. An unknown or expired `cart_token`
  gets a new, empty cart and a new cookie.
- With `access_token`, the buyer's own cart is used and `cart_token` is ignored.
- **Merge:** `POST /auth/login` and `POST /auth/register` move the guest cart's
  lines into the user's cart, then delete the guest cart and clear the cookie.
  The same product + variant adds up. Every moved line that's available is
  capped at the current stock, and unavailable lines move as they are. The
  response bodies are unchanged: refetch `GET /cart` after login.
- Guest carts idle for 30 days are deleted, and so are empty ones after 1 day.
- Guest carts are ordinary carts: same `CartRead`, same errors. Checkout needs a login.

#### Add / update errors

Show these as toasts. `404`s mean the product or variant isn't buyable at all,
so refresh the page.

| Status | `detail` | When |
|---|---|---|
| `404` | `Product not found` | `POST`: no such product, or it isn't visible (not approved / shop not active) |
| `404` | `Variant not found` | `POST`: `variant_id` doesn't exist or belongs to another product |
| `400` | `This product requires selecting a variant` | `POST`: variant product without `variant_id` |
| `400` | `This product does not have variants` | `POST`: `variant_id` sent for a non-variant product |
| `400` | `This variant is no longer available` | `POST`: the variant was deleted |
| `400` | `Not enough stock for the requested quantity` | `POST` (the line's total after adding) or `PATCH` above current stock |
| `400` | `This item is no longer available — remove it from the cart` | `PATCH` on a line with `available: false` |
| `404` | `Cart item not found` | `PATCH`/`DELETE`: not a line of the caller's cart |
| `422` | validation array | `quantity` < 1 |

### 3.2 Seller-facing

| Method | Path | Notes |
|---|---|---|
| GET | `/seller/shops/{shop_id}/order-groups` | Query: `status` |
| GET | `/seller/order-groups/{id}` | |
| PATCH | `/seller/order-groups/{id}/status` | `{ status, reason? }` — `reason` is used for `cancelled`, ignored otherwise |
| GET | `/seller/shops/{shop_id}/refund-requests` | Query: `status` |
| PATCH | `/seller/refund-requests/{id}/approve` | `{ who_bears_cost? }` — only `"seller"` (the default). Only `pending` requests. `never_arrived` refunds at once; other reasons wait for `confirm-return` |
| PATCH | `/seller/refund-requests/{id}/reject` | `{ reason }` — only `pending` requests |
| POST | `/seller/refund-requests/{id}/confirm-return` | `{ condition_note? }` — the returned item arrived; only when the request is `approved` and its line is `return_pending`. Refunds the money |
| GET | `/seller/shops/{shop_id}/ledger` | Query (**required**): `period_start`, `period_end` (ISO datetimes) — returns entries + computed balance for that window |
| GET | `/seller/shops/{shop_id}/payouts` | Full history, all statuses |

### 3.3 Admin

RBAC as noted — `orders:manage` for the first group, `finance:manage` for the second.

| Method | Path | Purpose |
|---|---|---|
| GET | `/admin/orders` | Query: `status`, `shop_id`, `buyer_id`, `date_from`, `date_to`, `search` (case-insensitive partial match on `order_number`), `skip`, `limit` |
| GET | `/admin/orders/{id}` | Includes commission/payout fields (admin-only view) |
| GET | `/admin/refund-requests` | Query: `status` — use `status=escalated_to_admin` for the dispute queue |
| PATCH | `/admin/refund-requests/{id}/resolve` | `{ decision: "approve" \| "reject", who_bears_cost?, reason }` — only `escalated_to_admin` requests; final. `who_bears_cost` (`seller` \| `platform`) is required for `approve` (`422` otherwise) |
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
  status: 'active' | 'checked_out' | 'abandoned'
  items: CartItemRead[]    // ordered by added_at
  item_count: number       // sum of quantities over all lines — the header badge
  subtotal: string         // sum of line_total over AVAILABLE lines only
  created_at: string
  updated_at: string
}
```

### `CartItemRead`
Returned in `CartRead.items` and by `POST /cart/items` / `PATCH /cart/items/{id}`.
```ts
{
  id: number
  quantity: number
  added_at: string
  product: { id: number; slug: string; title: string; image_url: string | null }
  variant: { id: number; attributes: Record<string, string | number | boolean> } | null
  shop: { id: number; slug: string; name: string; logo_url: string | null }  // group the cart by shop
  price_snapshot: string   // price when added (or last re-added)
  unit_price: string       // CURRENT price, what checkout charges
  line_total: string       // unit_price × quantity
  available: boolean       // product approved, shop active, variant active
  in_stock: boolean        // available and current stock >= quantity
}
```

- `image_url`: the variant's first image if it has `image_ids`, else the
  product's primary image.
- Variant `attributes` use raw keys. Labels come from
  `GET /categories/{category_id}/attributes`.
- A line that stops being available (product delisted, shop suspended,
  variant deleted) **stays in the cart** with `available: false`. Show
  "No longer available — remove" and block the checkout button: checkout
  rejects it with `400 "Product N is no longer available"`.
- `unit_price !== price_snapshot` → show "price changed" in the cart. Checkout's
  `price_changed` 400 (§2) is still the final guard. It compares against
  `price_snapshot`. **To accept the new price**, `PATCH /cart/items/{id}` with
  the line's current quantity: every PATCH moves `price_snapshot` to
  `unit_price`. Then retry checkout.

### `OrderRead` (buyer-facing — no commission/payout fields)
```ts
{
  id: number
  buyer_id: number
  order_number: string          // "ORD-2026-000123"
  status: "pending_payment" | "paid" | "partially_fulfilled" | "completed" | "cancelled" | "payment_failed"
  total_amount: string
  recipient: { full_name, phone, notes }
  pickup_point: {                // null only on orders placed before pickup points were required
    id, name, address, latitude, longitude, operating_hours, contact_phone
  } | null
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
  status: "pending" | "confirmed" | "preparing" | "at_warehouse" | "shipped" | "delivered" | "cancelled"
        | "return_requested" | "partially_refunded" | "refunded"   // refund rollup, see §1
        | "arrived_at_point" | "partially_collected" | "rejected_by_buyer" | "return_to_seller"
  subtotal: string
  shipping_fee: string           // currently always "0.00" — shipping-fee calculation is a future logistics doc
  cancellation_reason: string | null
  warehouse_received_at: string | null   // when the central store received it
  delivered_at: string | null            // when the buyer finished collecting
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
  platform_sku_snapshot: string    // frozen platform_sku — what the store and pickup points match on
  unit_price: string
  quantity: number
  line_total: string
  status: "active" | "return_pending" | "refunded"
  physical_return_received_at: string | null
  created_at: string
}
```
Seller/admin lines additionally include `seller_sku_snapshot` (the seller's own
code at purchase, informational only; may be `null`), `commission_rule_id` and
`commission_amount` (both `null` on a COD line until the group is
`delivered` — see §1).

### `RefundRequestRead`
```ts
{
  id, order_line_id, requested_by: "buyer" | "seller" | "admin", requester_user_id,
  reason_code: "defective" | "not_as_described" | "wrong_item" | "changed_mind" | "never_arrived" | "other",
  reason_text: string | null,
  status: "pending" | "approved" | "rejected" | "escalated_to_admin",
  refund_amount: string,  // always the line's full line_total, never edited
  who_bears_cost: "seller" | "platform" | null,  // null until approved
  evidence_urls: string[] | null,
  resolved_by: number | null,
  resolved_at: string | null,
  escalated_at: string | null,  // set when the buyer escalated; only once
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
- Admins can't yet waive the physical return or override the shipping rule on
  a single request (planned for `other`).
- Returns delivered to a pickup point instead of the seller have no
  confirm-return path for pickup-point staff yet; the seller confirms.
