---
id: seller-order-group-status-guard
title: Seller status PATCH accepts system-only order-group transitions
author: frontend
to: backend
status: open
priority: high
area: orders
created: 2026-09-26
closed:
reply_to:
---

## What

`PATCH /seller/order-groups/{group_id}/status` passes the requested status
straight to `OrderService.transition_group_status`, which only checks
`_GROUP_TRANSITIONS`. That table also holds edges the code itself marks as not
seller-driven, so a seller calling the API directly can:

- move `shipped → arrived_at_point`, and `arrived_at_point` /
  `partially_collected → delivered | rejected_by_buyer | return_to_seller`. The
  comment on those says "system-computed rollups of PickupPointHoldingItem state
  … not chosen directly by a staff action";
- move `shipped → delivered` on a group that was dispatched to a pickup point
  (`dispatch-to-point` leaves it `shipped`), skipping check-in and collection.
  It also runs the COD commission freeze on a group whose lines should be frozen
  per line at collection time;
- drive `return_requested → returned | delivered` and `returned → refunded`
  outside the refund-request flow.

## Expected

A seller-specific allow-list on this endpoint, with everything else returning
`400` (or `403`):

| From | Seller may set |
|---|---|
| `pending` | `confirmed`, `cancelled` |
| `confirmed` | `preparing`, `cancelled` |
| `preparing` | `shipped` (courier only), `cancelled` |
| `shipped` | `delivered`, **only if the group was not dispatched to a pickup point** |

Everything else is reached through its own flow (dispatch-to-point, pickup-staff
actions, refund approve/reject). Please list the final table in
`docs/orders-and-payments-api.md` §1.

## Why

The seller website only offers the transitions above. But the endpoint is the
real boundary, and right now it trusts the client. The seller UI also leaves out
"Mark delivered" entirely until `order-group-fulfillment-route` lands, because
it can't tell courier groups from pickup-point groups.

## References

- Backend: `app/modules/orders/router.py` → `update_order_group_status`;
  `app/modules/orders/service.py` → `_GROUP_TRANSITIONS`, `transition_group_status`
- `app/modules/logistics/service.py` → dispatch-to-point (requires `preparing`, sets `shipped`)
- `docs/orders-and-payments-api.md` §1 "OrderShopGroup.status"
