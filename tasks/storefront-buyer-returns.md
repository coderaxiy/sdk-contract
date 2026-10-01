---
id: storefront-buyer-returns
title: Buyer returns — find my refund requests, return deadline, photo evidence, how to bring the item back
author: frontend
to: backend
status: closed
priority: high
area: orders
created: 2026-09-27
closed: 2026-10-01
reply_to:
---

## What

The storefront is ready to build returns on the order page ("Return this item" on a
collected line). The refund endpoints exist
(`POST /order-lines/{id}/refund-request`, `GET /refund-requests/{id}`,
`POST /refund-requests/{id}/escalate`), but four things block a usable flow.
We don't want to work around them on the client.

### 1. The buyer can't find their request again

After `POST /order-lines/{id}/refund-request` the buyer has no way back to it: there is
no list endpoint, and `OrderLineRead` doesn't reference it. A `pending` or `rejected`
request doesn't change the line's `status` (it stays `active`), so the order page can't
show "Return requested", "Rejected: escalate?" or hide the button after a request.

**Ask:** put the line's latest request on `OrderLineRead` (buyer-facing, in `GET /orders`
and `GET /orders/{id}`):

```ts
refund_request: {
  id: number
  status: 'pending' | 'approved' | 'rejected' | 'escalated_to_admin'
  reason_code: RefundReasonCode
  created_at: string
  resolved_at: string | null
  escalated_at: string | null
  /** The seller's or admin's reason when rejected; shown to the buyer. */
  resolution_note: string | null
} | null
```

If a line can have several requests over time (a new one after a final rejection?),
please say so; the latest is enough for the UI. `RefundRequestRead` has no field for the
seller's rejection reason, which the buyer needs to decide whether to escalate: please
add it there too.

### 2. Return deadline

The window is category-specific and not exposed; the docs suggest reading
`return_window_days` from seller/admin category endpoints, which the buyer can't call.

**Ask:** `return_deadline: string | null` (ISO) on `OrderShopGroupRead` (or on each line
if it can differ), `null` until `delivered_at` is set. The storefront shows "Return until
{date}" and hides the button after it. The `400` after the window stays as the guard.

### 3. Photo evidence

`RefundRequestCreate.evidence_urls` is `string[]`, but a buyer can't upload anything:
`POST /uploads` purposes are `shop_logo`, `shop_banner`, `product_image`,
`seller_document`. And `api-standards.md` says to send keys, never URLs.

**Ask:** an upload purpose `refund_evidence` a buyer may use (images; private, visible to
the buyer, the shop and admins), and `evidence_keys: string[]` (max e.g. 5) on
`RefundRequestCreate`, with `evidence: { key, url }[]` on the read side like other
upload-backed fields. Photos matter most for `defective`, `not_as_described` and
`wrong_item`.

### 4. How the buyer brings the item back

For every reason except `never_arrived`, an approved request moves the line to
`return_pending` and money moves when the **seller** confirms the item is back. The docs
also say returns handed to a pickup point have no confirm path yet. So what does the
buyer do after approval?

**Ask:** a decision and a short doc section: where the buyer takes the item (any pickup
point? the one from the order?), and what the storefront should tell them. If it's
"bring it to your order's pickup point", a `return_instructions` text or a flag on the
request would let us show it. Until then we'll show only "Approved — the shop will
contact you", which isn't great.

## Why

Returns are the last missing step of the buyer journey (browse → cart → checkout →
track → collect → return). Without 1 and 2 the buyer submits a request and loses track
of it; without 3 the most common return reasons have no proof; without 4 an approved
buyer doesn't know what to do next.

## References

- openapi/api.yaml → `RefundRequestCreate`, `RefundRequestRead`, `OrderLineRead`,
  `OrderShopGroupRead`, `UploadPurpose`, `/api/v1/order-lines/{order_line_id}/refund-request`
- docs/orders-and-payments-api.md §1 "Refunds are all-or-nothing", "Return window", §4,
  §6 "Known gaps" (returns at pickup points)
- docs/media-uploads-api.md (purposes, keys vs URLs), docs/api-standards.md "Files"
- Related: `storefront-order-details` (shop and product info on lines)

## Progress (2026-10-01, backend)

All four items are done; the task is closed.

- **Item 1 done.** `OrderLineRead.refund_request` (buyer-facing, in `GET /orders` and `GET /orders/{id}`) holds the line's latest request: `id`, `status`, `reason_code`, `created_at`, `resolved_at`, `escalated_at`, `resolution_note`. `RefundRequestRead` has `resolution_note` too. It is set when a seller or admin rejects; older rejections have `null`. A line can have several requests (a rejected one doesn't block a new one), and the latest is returned.
- **Item 2 done, on the line.** The window is per category, so it can differ within a group: `OrderLineRead.return_deadline` (ISO, `delivered_at` + the category's window or the 14-day default; `null` until delivered).
- **Item 4 done.** The buyer returns the item to the pickup point where they collected it.
  - Buyer side: while the line is `return_pending`, `refund_request.return_point` is that point. There is no `return_instructions` text: the apps are localized, so build the message from `return_point`.
  - Staff side: `GET /pickup-staff/returns` and `POST /pickup-staff/returns/{id}/receive`. The line moves to the new status `returned_to_point`.
  - Money still waits for the seller's `confirm-return`, which now accepts `return_pending` or `returned_to_point`.
  - Notices: `pickup-returns-notice` (frontend) and `pickup-returns-notice-mobile` (mobile).
- **Item 3 done.** New upload purpose `refund_evidence` (private WebP, 2048 px), open to any logged-in user with a cap of 30 uploads per day. `RefundRequestCreate.evidence_keys` (max 5) replaces `evidence_urls`: the old field is gone from the request, and a client still sending it has it ignored. `RefundRequestRead.evidence` is `{ key, url }[]` with signed 15-minute URLs, visible to the buyer, the shop's seller and admins through the refund endpoints. `evidence_urls` stays on the read schema for old rows only. `POST /uploads` now needs only a login for this purpose; the seller-only purposes are unchanged.

## Resolution

All four items are live. Docs: `docs/orders-and-payments-api.md`, `docs/media-uploads-api.md`, `docs/logistics-and-pickup-points-api.md`. Notices: `pickup-returns-notice`, `pickup-returns-notice-mobile`. The clients must also handle the new `evidence_keys` (request) and `evidence` (read) fields, described above.
