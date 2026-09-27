# Logistics & Pickup Points API — Frontend Integration Guide

Backend implementation of `05-logistics-and-pickup-points.md`. All paths below
are relative to the API base (`/api/v1`), e.g. `GET /api/v1/admin/pickup-points`.
This module serves **three client surfaces**: the admin panel (including the
central-store screens for warehouse staff), the pickup-point staff app, and the
buyer app. Sellers have no logistics endpoints: they bring goods to the central
store, and the platform takes it from there.

## Auth

Same cookie-based auth as the rest of the app (`access_token` httpOnly
cookie — `credentials: 'include'` on every request).

- **Admin** endpoints require the `logistics:manage` permission.
- **Pickup-point staff** is a **new identity, not an RBAC role** — a logged-in
  `User` either has an active row in `pickup_point_staff` or doesn't. There is
  no field on `GET /auth/me` that tells you this. **Call `GET /pickup-staff/me`
  right after login** (or on app boot) to discover whether the current user is
  staff at all, and if so their `pickup_point_id` and `role`
  (`manager`/`operator`) — 403 means "not staff." This endpoint isn't in the
  original spec's table; it was added specifically because the frontend has no
  other way to know this.
- A user can be **active staff at exactly one point at a time** (enforced at
  the DB level) — don't build UI that assumes a staff member switches between
  multiple points.
- `manager` vs `operator`: only `manager` can see reconciliation, list co-staff,
  and invite/suspend/re-role staff. `operator` can do everything
  operational (check-in, collect, reject) but gets `403` on those.
- **Warehouse staff** (central store) endpoints `/warehouse/...` require the
  `warehouse:operate` permission. The `warehouse_staff` role has it (admins do
  too); assign the role through the roles API. There's only one central store,
  so unlike pickup-point staff there's nothing else to discover.
- **Buyer** endpoints: `/pickup-points/nearby` is public (no login).
  `/pickup-points`, `/pickup-points/last-used`, `/regions` and the
  pickup-status endpoint need a logged-in user; pickup-status also needs order
  ownership.

## Error shape

Same as the rest of the app: `{"detail": "..."}` string for `400`/`403`/`404`,
FastAPI's structured array for `422`. Nothing in this module uses a structured
`400` body like checkout's price-mismatch case — every `400` here is a plain
message string safe to show directly or map to a generic toast.

---

## 1. Core concepts

### Why this exists

The platform's only fulfillment model is **pickup point** (there's no courier-to-door):
buyer travels to a point, inspects the item, and pays cash there. This is the
main reason `cash_on_delivery` exists at all — nearly every COD order will
flow through this module, not get delivered straight to a door.

### The physical flow, and who does what

```
Buyer (app)            Seller           Central store (warehouse staff)     Pickup-point staff (app)          Buyer
───────────            ──────           ───────────────────────────────     ────────────────────────          ─────
checkout: picks  ──▶   prepares, ──▶   receive the group                ──▶ check-in (per item, may   ──▶   sees "ready for
a pickup point         brings goods     (preparing → at_warehouse),         flag discrepancies) →            pickup" + deadline,
for the order          to the store     then ship groups to their           creates a Holding                visits the point
                                        point (at_warehouse → shipped)      collect / reject  ◀────────────  pays, takes items
```

### State machine — `OrderShopGroup.status` (pickup-point branch)

This continues the state machine from the orders API doc. Sellers drive it up
to `preparing`; warehouse staff set `at_warehouse` (received at the central
store) and `shipped` (sent to the buyer's pickup point, by creating a
shipment).

```
shipped ──(staff check-in, no discrepancy)──▶ arrived_at_point
             │
             ├──▶ partially_collected ──▶ partially_collected   (repeat visits —
             │         ▲______________________|                  buyer comes back
             │                                                    for more items)
             │
             ├──▶ delivered            (every item now collected and/or rejected —
             │                          this is the "done" terminal state even if
             │                          some items were rejected, as long as at
             │                          least one was collected)
             │
             ├──▶ rejected_by_buyer    (100% of the group's items were rejected —
             │                          none collected at all)
             │
             └──▶ return_to_seller     (collection_deadline passed with items
                                        still un-visited — automatic, not staff-
                                        triggered)
```

**Important for UI:** everything after `arrived_at_point` is a **system-computed
rollup** of per-item state, not a status the frontend ever sets directly. The
only actions the frontend calls are check-in, collect, and reject — always
re-fetch the group/holding after any of these rather than assuming which
status it landed on.

### Granularity: Shipment → Holding → per-item status (this is the trickiest part)

Three different "container" levels exist and it's easy to conflate them:

| Level | What it represents | Status enum |
|---|---|---|
| `PickupPointShipment` | One central store → point trip. Bundles items from **several orders and shops**, all bound for the same point. | `dispatched → in_transit → arrived` / `discrepancy` |
| `PickupPointHolding` | Everything from **one `OrderShopGroup`** currently sitting at a point. One holding = one order's items from one shop. | `holding → partially_collected → collected` / `expired_uncollected` |
| `PickupPointHoldingItem` | **Per-`OrderLine`**, the actual collect/reject unit. | `holding → collected` / `rejected_by_buyer` / `expired_uncollected` |

`PickupPointHolding.status = "collected"` is an **umbrella "fully resolved"**
value — it fires whether every item was bought, or some were bought and the
rest rejected, or (rare) all were rejected. Don't read `holding.status ===
"collected"` as "buyer paid for everything" — check the individual
`items[].status` for that.

### Discrepancy at check-in is a **partial-success** operation

When staff check in a shipment, items are evaluated independently. If item A
matches its expected quantity and item B doesn't:
- Item A's `OrderLine` **immediately gets a `PickupPointHolding`** and its
  `OrderShopGroup` moves to `arrived_at_point` — buyer can collect it right away.
- Item B's line does **not** get a holding — it's frozen until an admin calls
  `resolve-discrepancy` — and the whole `PickupPointShipment.status` shows
  `discrepancy` in the meantime.

So: **`shipment.status = "discrepancy"` does not mean nothing happened.** If
you're building the staff check-in confirmation screen, show per-item outcome
(which items are now ready for pickup vs. which are blocked pending admin
review), not just the shipment-level status.

### Commission freezes per line, per visit — not per group, not at check-in

For COD orders, commission is resolved and the seller's ledger entry is
written **the instant that specific line's holding item reaches `collected`**
— not when the group arrives, not when the whole group finishes. A group can
sit in `partially_collected` for days with some lines already paid out to the
seller and others completely untouched. **This has no direct UI implication**
(you're never displaying commission to a buyer, and seller ledger views
already handle per-line COD timing per the orders API doc) — it just means
don't assume group-level financial fields are final until `delivered`.

### Rejection has no financial side effect

If a buyer rejects an item at the point, nothing is reversed on the ledger
(nothing was ever charged/credited for that line — collection and freezing are
the same event). The rejected quantity restocks automatically. No
refund-request flow is involved.

### Cash reconciliation is completely separate from the seller payout ledger

`PickupPointCashReconciliation` tracks **physical cash custody** at a point
(what staff should have vs. what they declare) — it has nothing to do with
what a seller is owed. Don't build these into the same screen; they answer
different questions ("is the cash box right" vs. "what does this seller earn").
Reconciliation periods are daily and **auto-generated by a backend job** — the
frontend never creates one, only declares against an existing one.

### Money and coordinate fields are strings, not numbers

Same convention as the rest of the API: `Decimal` fields (`amount_collected`,
`expected_amount`, `declared_amount`, `variance`, `line_total` on order lines,
etc.) and `latitude`/`longitude` are all JSON strings. Parse before formatting
or doing arithmetic.

---

## 2. Flow walkthroughs

### 2.1 Admin: onboarding a new pickup point

1. `POST /admin/pickup-points` — point is created as `pending_setup`.
2. Assign at least one **manager** — there's no direct "assign staff" admin
   endpoint; the manager invites further staff themselves via
   `POST /pickup-staff/staff/invite` **once they're staff**, but the *first*
   manager has to be created some other way today (e.g. direct DB/seed, or
   flag this to backend if you need an admin-side "create first manager"
   endpoint — it doesn't exist yet).
3. `PATCH /admin/pickup-points/{id}/status` with `{"status": "active"}` —
   **this fails with `400`** if the point has zero active managers. Surface
   that error clearly rather than a generic failure toast.

### 2.2 Central store: receiving from sellers and shipping to points

1. **Inbound.** `GET /warehouse/inbound?shop_id=` lists groups sellers are
   preparing (`WarehouseGroupRead`, oldest first, with their lines). Use it at
   the drop-off counter: find the seller's groups, count the items.
2. **Receive.** `POST /warehouse/order-groups/{group_id}/receive` (no body) →
   `at_warehouse`, `warehouse_received_at` set. It means *every* item in the
   group arrived complete and undamaged. Don't receive a group with missing or
   damaged items; the seller takes it back and returns with the full set.
   `400` unless the group is `preparing`.
3. **Outbound.** `GET /warehouse/outbound?pickup_point_id=` lists groups in the
   store, each with its `pickup_point_id`. Group them by point in the UI.
4. **Ship.** `POST /warehouse/shipments`
   `{ "pickup_point_id": 4, "order_shop_group_ids": [12, 15, 19] }` → `201`
   `ShipmentRead`. Every group must be `at_warehouse` and for that point
   (`400` naming the first group that isn't); the point must be active. All
   groups move to `shipped` together, or none do. Duplicate ids are ignored.
5. **History.** `GET /warehouse/shipments?status=&skip=&limit=` — shipments
   sent, newest first. From here the pickup point's check-in (§2.3) takes over.

### 2.3 Pickup staff: check-in

1. `GET /pickup-staff/shipments?status=dispatched` (or `in_transit`) — incoming queue.
2. Staff physically counts each item, then
   `POST /pickup-staff/shipments/{id}/check-in` with one entry per item:
   ```json
   { "items": [
     { "item_id": 12, "received_quantity": 2 },
     { "item_id": 13, "received_quantity": 1, "condition_note": "box crushed" }
   ]}
   ```
   `item_id` here is the `PickupPointShipmentItem.id`, **not** the order line
   id — get it from the shipment's `items[]` array. The resulting per-item
   status is inferred server-side: exact match → `received`; `received_quantity
   = 0` → always `missing` regardless of any note; a nonzero-but-short count →
   `damaged` if `condition_note` is set, otherwise `missing`. There's no way
   for the client to force a specific status — it's purely a function of the
   two numbers plus whether a note was given. See §1's discrepancy note for
   what happens next.

### 2.4 Pickup staff: collection (buyer present)

1. `GET /pickup-staff/holdings` — everything currently holding/partially
   collected at this point.
2. Buyer wants to pay for some or all outstanding items:
   ```json
   POST /pickup-staff/holdings/{holding_id}/collect
   { "items": [{ "holding_item_id": 45, "quantity_collected": 1 }],
     "amount_collected": "50000.00" }
   ```
   **`amount_collected` must exactly equal the sum of the selected items'
   line totals for the quantity being collected** (unit price × quantity, to
   2 decimal places) — a mismatch is a `400` and the request is fully
   rejected (no partial apply). The spec calls this "get a supervisor
   override" — **there is no override endpoint today**; a mismatch is a hard
   stop, so the staff UI should compute and display the expected total
   up front to avoid the error entirely, rather than relying on the API to
   correct a wrong entry.
3. Buyer declines an item instead:
   ```json
   POST /pickup-staff/holdings/{holding_id}/reject
   { "holding_item_ids": [46], "reason": "damaged on inspection" }
   ```
4. Re-fetch the holding (or just trust the response) to show updated
   per-item status — a holding can require many visits before it's fully resolved.

### 2.5 Pickup staff: reconciliation (manager only)

1. `GET /pickup-staff/reconciliation/current` — returns the **most recent**
   reconciliation by period, which returns `null` only if none has ever been
   generated for this point. **It does not filter by status** — if today's
   period hasn't been generated yet (e.g. the nightly job hasn't ticked), this
   can return an already-`resolved` reconciliation from a prior day. Check
   `status === "pending_review"` before treating the response as "this is what
   you need to declare right now" — anything else means there's nothing
   currently awaiting declaration, not that the data is wrong.
2. `POST /pickup-staff/reconciliation/{id}/declare` with
   `{"declared_amount": "..."}` — after this, `status` becomes `matched` or
   `variance_flagged` depending on whether it equals `expected_amount`.
   Declaration is **one-shot** — a second call is a `400`.

### 2.6 Buyer: tracking a pickup order

1. During checkout (orders API §2), pre-select `GET /pickup-points/last-used`
   (the point on the buyer's previous order; `null` if none or it closed), and
   let the buyer change it via `GET /pickup-points/nearby?lat=...&lng=...&radius_km=25`
   or `GET /regions` + `GET /pickup-points?region_id=`. The order's
   `pickup_point` is on `OrderRead`.
2. On the order detail page, once a group shows `arrived_at_point` or later,
   call `GET /orders/{order_id}/groups/{group_id}/pickup-status` to show
   "ready for pickup," the deadline, and per-item collected/rejected state.
   Before `arrived_at_point` this returns `404` ("hasn't arrived yet") — treat
   that as "still in transit," not an error state.

---

## 3. Endpoints

### 3.1 Admin (`logistics:manage`)

| Method | Path | Notes |
|---|---|---|
| GET | `/admin/pickup-points` | Query: `status`, `region_id` |
| POST | `/admin/pickup-points` | See `PickupPointCreateRequest` §4 |
| GET | `/admin/regions` | Not in the original spec — added so a point-creation form has something to populate the `region_id` dropdown with |
| PATCH | `/admin/pickup-points/{id}` | Partial update, all fields optional |
| PATCH | `/admin/pickup-points/{id}/status` | `{ status }` — `400` if activating with zero managers |
| GET | `/admin/pickup-points/{id}/staff` | |
| GET | `/admin/shipments` | Query: `status`, but **only `discrepancy` is accepted** (the endpoint is a fixed discrepancy queue, not a general shipment browser) |
| PATCH | `/admin/shipments/{id}/resolve-discrepancy` | See §3.3 body shape |
| GET | `/admin/reconciliations` | Query: `status` (optional — omit for all) |
| PATCH | `/admin/reconciliations/{id}/resolve` | `{ resolution_note }` — only valid on `variance_flagged` |

### 3.2 Pickup-point staff

| Method | Path | Notes |
|---|---|---|
| GET | `/pickup-staff/me` | Identity/role discovery — call this first, see §Auth |
| GET | `/pickup-staff/shipments` | Query: `status` (optional) |
| POST | `/pickup-staff/shipments/{id}/check-in` | See §2.3 |
| GET | `/pickup-staff/holdings` | All holdings at this staff member's point |
| POST | `/pickup-staff/holdings/{id}/collect` | See §2.4 |
| POST | `/pickup-staff/holdings/{id}/reject` | See §2.4 |
| GET | `/pickup-staff/reconciliation/current` | Manager only — `403` for `operator` |
| POST | `/pickup-staff/reconciliation/{id}/declare` | Manager only |
| GET | `/pickup-staff/staff` | Manager only — co-staff at this point |
| POST | `/pickup-staff/staff/invite` | Manager only — `{ user_id, role }` |
| PATCH | `/pickup-staff/staff/{id}/role` | Manager only — not in the original spec, added for parity with invite |
| PATCH | `/pickup-staff/staff/{id}/suspend` | Manager only — same |

### 3.3 Central store (`warehouse:operate`)

| Method | Path | Notes |
|---|---|---|
| GET | `/warehouse/inbound` | Query: `shop_id`. Groups in `preparing` |
| POST | `/warehouse/order-groups/{group_id}/receive` | No body. `preparing → at_warehouse`; returns `OrderShopGroupRead` |
| GET | `/warehouse/outbound` | Query: `pickup_point_id`. Groups in `at_warehouse` |
| POST | `/warehouse/shipments` | `{ pickup_point_id, order_shop_group_ids }` → `201 ShipmentRead`. See §2.2 |
| GET | `/warehouse/shipments` | Query: `status`, `skip`, `limit` (max 200) |

Sellers have no logistics endpoints: the old seller dispatch-to-point and
`/seller/shipments` are removed.

### 3.4 Buyer-facing

| Method | Path | Notes |
|---|---|---|
| GET | `/pickup-points/nearby` | **Public, no auth.** Query (required): `lat` (number, -90..90), `lng` (number, -180..180); optional `radius_km` (default 25). Out-of-range coordinates → `422` |
| GET | `/pickup-points` | Query: `region_id`. Active points only, by name |
| GET | `/pickup-points/last-used` | `PickupPointRead \| null` — the point on the buyer's most recent order, if still active |
| GET | `/regions` | For the region filter |
| GET | `/orders/{order_id}/groups/{group_id}/pickup-status` | Requires login + order ownership; `404` before the group reaches `arrived_at_point` |

`resolve-discrepancy` body shape:
```json
{
  "items": [
    { "item_id": 13, "resolved_quantity": 1, "status": "damaged" }
  ],
  "resolution_note": "Central store confirmed 1 unit damaged in transit, refund follow-up outside this system"
}
```
`status` per item must be `received`, `missing`, or `damaged`. Resolving an
item to `received` creates its holding immediately (same as a clean check-in).
Resolving to `missing`/`damaged` is **permanent** — that line never becomes
collectible and there's currently no refund/return path wired to this outcome
(see §5).

---

## 4. Response shapes (key fields)

### `PickupPointRead`
```ts
{
  id: number
  name: string
  address: object              // free-form JSON — {region, district, street, landmark, coordinates}, not schema-enforced
  latitude: string              // decimal string
  longitude: string
  type: "platform_operated" | "partner_operated"   // only platform_operated is used at launch
  capacity_units: number | null
  status: "pending_setup" | "active" | "temporarily_closed" | "closed"
  operating_hours: object       // free-form JSON, e.g. {"mon": "9-18", ...} — not schema-enforced
  contact_phone: string
  region_id: number
  created_at: string
  updated_at: string
}
```
`NearbyPickupPointRead` (from `/pickup-points/nearby`) is the same shape plus
`distance_km: number`.

### `PickupPointStaffRead`
```ts
{ id, pickup_point_id, user_id, role: "manager" | "operator", status: "active" | "suspended", created_at }
```

### `ShipmentRead`
```ts
{
  id, pickup_point_id,
  status: "dispatched" | "in_transit" | "arrived" | "discrepancy",
  dispatched_at: string | null, expected_arrival_at: string | null, arrived_at: string | null,
  received_by_staff_id: number | null, created_at: string,
  items: {
    id, shipment_id, order_line_id, expected_quantity: number, received_quantity: number | null,
    condition_note: string | null, status: "expected" | "received" | "missing" | "damaged",
  }[]
}
```

### `WarehouseGroupRead`
```ts
{
  id: number                 // order_shop_group_id
  order_id: number
  order_number: string
  shop_id: number
  status: "preparing" | "at_warehouse"
  pickup_point_id: number | null   // the buyer's point; null only on legacy orders
  warehouse_received_at: string | null
  lines: OrderLineRead[]           // product title/sku snapshot, quantity
}
```

### `HoldingRead`
```ts
{
  id, pickup_point_id, order_shop_group_id,
  status: "holding" | "partially_collected" | "collected" | "expired_uncollected",
  arrived_at: string, collection_deadline: string, created_at: string,
  items: {
    id, pickup_point_holding_id, order_line_id, quantity: number, quantity_collected: number,
    status: "holding" | "collected" | "rejected_by_buyer" | "expired_uncollected",
    updated_at: string,
  }[]
}
```
Remember: `status = "collected"` at the holding level is the "fully resolved"
umbrella — check `items[]` for the real per-line outcome (§1).

### `CashCollectionRecordRead` (response to a `collect` call)
```ts
{
  id, order_shop_group_id, amount_collected: string,
  collected_by_staff_id: number, collected_at: string,
  items: { id, cash_collection_record_id, pickup_point_holding_item_id, quantity_collected: number, amount: string }[]
}
```

### `ReconciliationRead`
```ts
{
  id, pickup_point_id, period_start: string, period_end: string,
  expected_amount: string,
  declared_amount: string | null,   // null until staff declare
  variance: string | null,          // null until staff declare; "0.00" = matched
  status: "pending_review" | "matched" | "variance_flagged" | "resolved",
  submitted_by_staff_id: number | null, reviewed_by: number | null,
  resolution_note: string | null, created_at: string,
}
```

### `PickupStatusRead` (buyer-facing tracking)
```ts
{
  order_shop_group_id, pickup_point_id,
  holding_status: "holding" | "partially_collected" | "collected" | "expired_uncollected",
  arrived_at: string, collection_deadline: string,
  items: { order_line_id, quantity: number, quantity_collected: number,
            status: "holding" | "collected" | "rejected_by_buyer" | "expired_uncollected" }[]
}
```

---

## 5. Suggested integration order

1. **Admin**: pickup-point CRUD + activate flow (§2.1) — needed before
   anything else can be tested end-to-end.
2. **Pickup-staff app**: `GET /pickup-staff/me` identity check on boot, then
   shipment queue + check-in (§2.3).
3. **Pickup-staff app**: holdings list + collect/reject (§2.4) — the highest-
   traffic screen once live, worth the most UI care (amount-mismatch
   prevention especially, see §2.4 point 2).
4. **Central store (admin panel)**: inbound/receive and outbound/ship screens
   (§2.2) — needed before any order can reach a point.
5. **Buyer app**: point picker in checkout with the last-used default, then
   order-detail pickup status tracking (§2.6).
6. **Pickup-staff app**: reconciliation screen, manager-only (§2.5).
7. **Admin**: discrepancy queue + resolve-discrepancy, and reconciliation
   variance review — lower traffic, do last.
8. **Pickup-staff app**: staff management (invite/role/suspend) — needed
   eventually but not blocking for launch if a point starts with one manager.

## 6. Known gaps / things not yet wired up

- **No admin endpoint creates a pickup point's first manager.** Someone has to
  become staff before they can invite others; there's currently no way to
  bootstrap that from the admin panel. Flag to backend if this blocks the
  admin onboarding flow.
- **No supervisor-override endpoint** for a collection amount mismatch — it's
  a hard `400`, full stop (§2.4).
- **Orders placed before pickup points were required** have
  `pickup_point_id: null` and can't be shipped from the central store; they
  don't appear in `/warehouse/outbound` filtered by point.
- **No refund/return path** for a shipment item permanently resolved as
  missing/damaged during discrepancy resolution — that `OrderLine` just never
  becomes collectible. Don't build UI that implies a refund happens
  automatically here.
- **No capacity alerting** — `capacity_units` is stored but nothing computes
  "this point is nearly full" anywhere; if you want to show a capacity bar,
  you'd need to compute held-item count client-side from `/pickup-staff/holdings`.
- **No push notifications at all** (buyer collection-deadline reminders,
  arrival notices, discrepancy alerts to admins) — see the earlier discussion
  in this project; every "needs attention" state here is pull/polling only.
- **Reverse logistics (return-to-seller / rejected-item shipping back) has no
  dedicated tracking** beyond the `OrderShopGroup.status` flipping to
  `return_to_seller`/`rejected_by_buyer` — there's no shipment-in-reverse
  model yet, so don't build a "track the return" UI expecting shipment-style
  detail.
