---
id: order-group-fulfillment-route
title: Expose courier vs pickup-point route on seller order-group reads; update the status list in the orders doc
author: frontend
to: backend
status: open
priority: normal
area: orders
created: 2026-09-26
closed:
reply_to:
---

## What

1. **Route on the group.** `OrderShopGroupDetailRead` (returned by
   `GET /seller/shops/{shop_id}/order-groups` and `GET /seller/order-groups/{id}`)
   doesn't say how a `shipped` group is being fulfilled. A courier shipment and
   a group dispatched to a pickup point look identical. Please add something
   like:

   ```ts
   fulfillment_route: "courier" | "pickup_point" | null   // null until shipped/dispatched
   pickup_point_id: number | null
   shipment_id: number | null                              // the PickupPointShipment, if any
   ```

   (Names are up to you. We just need to tell the two apart without a second
   request to `/seller/shipments` per row.)

2. **Doc drift.** `docs/orders-and-payments-api.md` §1 and §4 list 9
   `OrderShopGroupStatus` values. The spec has 13, adding `arrived_at_point`,
   `partially_collected`, `rejected_by_buyer` and `return_to_seller`. Please add
   the pickup-point branch to the state diagram (it's only in code comments in
   `_GROUP_TRANSITIONS` today) and cross-link
   `docs/logistics-and-pickup-points-api.md`.

## Why

The seller Orders page shows a "Mark delivered" action for courier orders only.
Without the route on the group, it can't know which `shipped` groups are
courier ones, so the action is hidden for all of them. Sellers can't mark any
courier order as delivered from the UI.

## References

- `openapi/api.yaml` → `OrderShopGroupDetailRead`, `OrderShopGroupStatus`
- `docs/orders-and-payments-api.md` §1, §4; `docs/logistics-and-pickup-points-api.md`
- Related: `seller-order-group-status-guard`
