---
id: seller-pickup-point-selection
title: Seller can't know which pickup point to dispatch to (no buyer choice on the order, no seller point list)
author: frontend
to: backend
status: closed
priority: high
area: logistics
created: 2026-09-26
closed: 2026-09-27
reply_to:
---

## What

`POST /seller/order-groups/{group_id}/dispatch-to-point` takes a
`pickup_point_id`. The docs call pickup points the platform's primary
fulfillment model (`docs/logistics-and-pickup-points-api.md` §1), but the
seller has no way to know which point to use:

1. **The buyer's chosen point isn't stored.** `CheckoutRequest` only has
   `payment_method` and `shipping_address`. No order schema (`OrderRead`,
   `OrderShopGroupRead`, `OrderShopGroupDetailRead`) has a `pickup_point_id`.
   The guide's integration order (§5, step 5) plans a "nearby-point picker in
   checkout", but there's nowhere to send the result.
2. **Sellers can't list points.** `GET /admin/pickup-points` needs
   `logistics:manage`. The only other list is the public
   `GET /pickup-points/nearby?lat&lng`, which needs coordinates the seller
   doesn't have. The seller order-group read doesn't include the buyer's
   address either.
3. **Sellers can't resolve a point id to a name.** `ShipmentRead.pickup_point_id`
   is all the seller sees. The shipments list can only show "Point #12".

## Expected

- **Checkout records the buyer's point:** `CheckoutRequest.pickup_point_id`
  (required when the fulfillment is pickup, or per shop group if buyers can
  pick different points per shop). Expose it on
  `OrderShopGroupDetailRead.pickup_point_id`, plus the point's `name` and
  address summary, or an expandable `pickup_point` object. Then dispatch is
  one click on the buyer's point, with no picker at all.
- **Decide whether a seller may dispatch to a different point** than the
  buyer chose. If not, `dispatch-to-point` could take no body, or the backend
  rejects a mismatch.
- **Point names for sellers:** either embed `pickup_point: {id, name, address}`
  in `ShipmentRead`, or add a seller-safe `GET /seller/pickup-points/{id}` (or a
  list filtered to `status: active`).
- **Related to `order-group-fulfillment-route`:** once the group records its
  point, "courier vs pickup point" is just `pickup_point_id !== null`.

## Why

The seller Logistics page shows the shipment history (with "Point #id"). The
dispatch action on a `preparing` order group is on hold: the only picker we
could build today is "use your browser location and choose any nearby point",
which ignores where the buyer actually is and would send parcels to arbitrary
points.

## References

- `openapi/api.yaml` → `CheckoutRequest`, `OrderShopGroupDetailRead`, `ShipmentRead`,
  `DispatchToPointRequest`, `/api/v1/pickup-points/nearby`, `/api/v1/admin/pickup-points`
- `docs/logistics-and-pickup-points-api.md` §1, §2.2, §5
- Related: `order-group-fulfillment-route`

## Resolution

Product decision: **the pickup point isn't the seller's concern.** Sellers bring
goods to one central store; warehouse staff send them to the point the buyer
chose. Every order is collected at a pickup point (no courier-to-door).

- **Checkout records the buyer's point, per order:**
  `CheckoutRequest { recipient: { full_name, phone, notes? }, pickup_point_id, payment_method }`
  (`shipping_address` is gone). Inactive point → `400`.
  `OrderRead.pickup_point` embeds `{ id, name, address, latitude, longitude, operating_hours, contact_phone }`.
- **Remembered choice:** `GET /pickup-points/last-used` returns the point on the
  buyer's latest order (or `null`) so checkout can pre-select it.
- **Point lists:** `GET /pickup-points?region_id=` and `GET /regions`, besides `nearby`.
- **Sellers don't dispatch:** `POST /seller/order-groups/{id}/dispatch-to-point`
  and `GET /seller/shipments` are removed. New `/warehouse/...` endpoints
  (inbound, receive, outbound, shipments) with the `warehouse:operate`
  permission / `warehouse_staff` role. New group status `at_warehouse`.

Docs: `docs/logistics-and-pickup-points-api.md` §1–§4, `docs/orders-and-payments-api.md` §1–§2, §4.
