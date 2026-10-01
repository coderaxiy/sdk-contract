---
id: buyer-push-notifications
title: Push notifications for buyers — device token registration and order events
author: mobile
to: backend
status: closed
priority: normal
area: orders
created: 2026-09-30
closed: 2026-10-01
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

## Resolution

Shipped in stages, as the task allowed. **Registration and the events are live; real delivery is not.** Documented in the new `docs/notifications-api.md`.

1. **Device tokens:** `PUT /devices` `{ token, platform, locale? }` and `DELETE /devices?token=`. A token moves to whoever registered it last, so a shared phone only notifies the newest login. Call `DELETE /devices` before logout.
2. **Events:** `order_group.arrived_at_point` (with `collection_deadline`), `order_group.cancelled` (not for a cancellation the buyer made), `refund.approved` and `refund.rejected`. Each carries `type`, `order_id`, `group_id`, and for refunds `refund_request_id`, as strings in `data`. Text is localized to the device's `locale` (`uz`, `ru`, `en`; Uzbek if unset).
3. **Delivery is stage two.** The backend sender only logs messages (`PUSH_BACKEND=console`). Real Android and iOS delivery needs an FCM project, credentials and a provider library, so it is a deployment decision. The app can build against the registration and payloads now; nothing in the API changes when delivery goes live.

Not included: a collection-deadline reminder push, pushes for other group statuses, per-event opt-out, automatic clean-up of dead tokens.
