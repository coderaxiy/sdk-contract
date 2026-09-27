---
id: checkout-pickup-point-mobile
title: Checkout takes a pickup point and a recipient (no address); pre-select the last-used point
author: backend
to: mobile
status: open
priority: high
area: orders
created: 2026-09-27
closed:
reply_to:
---

## What changed (breaking)

Every order is collected at a pickup point chosen at checkout (one point per
order). Details: `docs/orders-and-payments-api.md` §2 and
`docs/logistics-and-pickup-points-api.md` §2.6, §3.4.

1. **`POST /checkout`** body is now
   `{ recipient: { full_name, phone, notes? }, pickup_point_id, payment_method }`.
   `shipping_address` is gone (no delivery address). Inactive point →
   `400 "This pickup point isn't available — choose another one"`.
2. **Remember the choice:** `GET /pickup-points/last-used` returns the point on
   the buyer's previous order, or `null`. Pre-select it ("You picked this point
   last time") so the buyer can just confirm, with a "Change" option.
3. **Choosing a point:** `GET /pickup-points/nearby?lat&lng` (public), or
   `GET /regions` + `GET /pickup-points?region_id=` (login) for buyers who
   don't share location.
4. **Order detail:** `OrderRead.recipient` and `OrderRead.pickup_point`
   (`{ id, name, address, latitude, longitude, operating_hours, contact_phone }`)
   replace `shipping_address`. Show the point with hours and directions.
5. **Statuses:** new `at_warehouse` ("At our warehouse"); `shipped` = "On the
   way to your pickup point". `OrderShopGroupRead` has `delivered_at`.

6. **Order lines:** `sku_snapshot` is renamed `platform_sku_snapshot` (the
   platform's code, e.g. `PSK-8F3K2Q`).

Regenerate the SDK: `Recipient`, `OrderPickupPointRead` new; `ShippingAddressIn` gone.
