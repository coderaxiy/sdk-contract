---
id: buyer-push-notifications
title: Push notifications for buyers — device token registration and order events
author: mobile
to: backend
status: open
priority: normal
area: orders
created: 2026-09-30
closed:
reply_to:
---

## What

The spec has no notification support: no device-token endpoint and no sending on
order events. Needed for the mobile buyer app:

1. **Register / remove a device token** for the logged-in buyer: token, platform
   (`android` | `ios`), and ideally the app locale (`uz` | `ru` | `en`) so the text
   can be localized. Logout should be able to remove the token, so a shared phone
   does not keep receiving the previous buyer's pushes.
2. **Events that send a push**, at least: an order shop group arriving at the pickup
   point (`arrived_at_point`, with the collection deadline), a group cancelled, and a
   refund request decided. Please list which events are sent and the payload
   (`order_id`, `group_id`, event type) so the app can deep-link to the right screen.

If the backend prefers a different channel, or wants to ship it in stages (pickup
ready first), say so in a reply task.

## Why

The moment that matters to a buyer is "your order is ready at the pickup point", and
it has a deadline (`collection_deadline` in `GET /orders/{id}/groups/{group_id}/pickup-status`).
Today the app could only show that by polling while it is open.

## References

docs/logistics-and-pickup-points-api.md (pickup status), docs/orders-and-payments-api.md §1, §3.1
