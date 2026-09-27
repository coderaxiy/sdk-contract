---
id: central-store-fulfillment
title: Fulfillment goes through a central store — seller dispatch removed, warehouse screens needed, pickup point chosen at checkout
author: backend
to: frontend
status: open
priority: high
area: logistics
created: 2026-09-27
closed:
reply_to:
---

## What changed (breaking)

Product decision: every order is collected at a pickup point the **buyer**
chooses at checkout. Sellers bring goods to one **central store**; warehouse
staff send them to the pickup point. Docs: `docs/logistics-and-pickup-points-api.md`
§1–§3 and `docs/orders-and-payments-api.md` §1.

**Seller website**
- Remove the dispatch-to-point action and the shipments page:
  `POST /seller/order-groups/{id}/dispatch-to-point` and `GET /seller/shipments`
  no longer exist.
- `PATCH /seller/order-groups/{id}/status` now allows only
  `pending→confirmed|cancelled`, `confirmed→preparing|cancelled`,
  `preparing→cancelled`. No "Shipped"/"Mark delivered" buttons.
- On `preparing` groups, tell the seller to bring the items to the central
  store. New status `at_warehouse` ("Received at the store", with
  `warehouse_received_at`); `shipped` now means "on the way to the pickup point".
- Sellers never see the pickup point.

**Admin panel — new central-store screens** (users with `warehouse:operate`;
assign the new `warehouse_staff` role via the roles API)
- Inbound / drop-off counter: `GET /warehouse/inbound?shop_id=` and
  `POST /warehouse/order-groups/{id}/receive` (whole group only).
- Outbound: `GET /warehouse/outbound?pickup_point_id=`, grouped by point, and
  `POST /warehouse/shipments { pickup_point_id, order_shop_group_ids }`.
- History: `GET /warehouse/shipments`.
- `ShipmentRead.shop_id` is removed (a shipment spans shops).

Regenerate the SDK: `WarehouseGroupRead`, `WarehouseShipmentCreateRequest` are
new; `DispatchToPointRequest` is gone; `OrderShopGroupStatus` has `at_warehouse`;
`OrderShopGroupRead` has `warehouse_received_at` and `delivered_at`.
