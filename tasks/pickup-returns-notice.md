---
id: pickup-returns-notice
title: Returns are live — pickup-point handover, returned_to_point status, refund_request and return_deadline on lines, photo evidence
author: backend
to: frontend
status: open
priority: normal
area: orders
created: 2026-10-01
closed:
reply_to: storefront-buyer-returns
---

## What

`storefront-buyer-returns` is live: all four items.

1. **`OrderLineRead.refund_request`** — the line's latest request (`id`, `status`, `reason_code`, `created_at`, `resolved_at`, `escalated_at`, `resolution_note`, `return_point`, `point_received_at`), or `null`. `RefundRequestRead` also has `resolution_note` and `point_received_at`.
2. **`OrderLineRead.return_deadline`** — ISO datetime, per line (the window is per category), `null` until the group is delivered. Hide "Return this item" after it.
3. **New `OrderLineStatus` value `returned_to_point`.** Handle it in every `status` switch: the buyer handed the item in at the pickup point, the refund has **not** been paid yet. The group stays `return_requested`.
4. **How to return:** the buyer takes the item to the pickup point the order was collected at. While the line is `return_pending`, `refund_request.return_point` is that point; show "Bring the item to {name}". The backend sends no free text, so build the message in the app's language.
5. **Pickup staff app:** `GET /pickup-staff/returns` lists approved returns waiting at the staff member's point (order number, recipient name and phone, product, quantity, reason). `POST /pickup-staff/returns/{id}/receive` (`{ condition_note? }`) records the handover.
6. **Photo evidence:** upload with `POST /uploads?purpose=refund_evidence` (any logged-in buyer, max 30 a day), then send up to 5 `evidence_keys` in `POST /order-lines/{id}/refund-request`. **Breaking:** `evidence_urls` is gone from the request (a client still sending it has it ignored). `RefundRequestRead.evidence` is `{ key, url }[]` with signed 15-minute URLs.

Flow: `active → return_pending → returned_to_point → refunded`. The seller's existing `confirm-return` still releases the money and also works straight from `return_pending`.

## Why

Buyers need to find their request, see why it was rejected, know the deadline and know where to take the item.

## References

docs/orders-and-payments-api.md (`OrderLine.status`, `OrderLineRead`, refunds), docs/logistics-and-pickup-points-api.md §3.2, task `storefront-buyer-returns`
