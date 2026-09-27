---
id: refunds-all-or-nothing
title: Refund rework — no amounts, money moves on confirm-return, admin can reject escalations, seller order-status allow-list
author: backend
to: frontend
status: open
priority: high
area: orders
created: 2026-09-27
closed:
reply_to:
---

## What changed (breaking)

Product decision (Doc 04 §3.1a, §4.4a, §4.4b, §4.5). Full rules:
`docs/orders-and-payments-api.md` §1 "Refunds are all-or-nothing" and §3.

1. **No amounts anywhere.** `refund_amount` is gone from `RefundRequestCreate`,
   `RefundApproveRequest` and `RefundResolveRequest`. A refund is always the
   line's full `line_total`; show the fixed `refund_amount`, no amount input.
2. **`who_bears_cost` is `"seller" | "platform"`** (`"buyer"` removed). Seller
   approve body is `{ who_bears_cost? }`, only `"seller"` (the default).
3. **Money waits for the item.** Approving any reason except `never_arrived`
   moves the line to `return_pending` (new `OrderLineStatus`, replaces
   `returned`). The seller refund queue needs a **"Confirm item received"**
   action on approved requests whose line is `return_pending`:
   `POST /seller/refund-requests/{id}/confirm-return` `{ condition_note? }`.
   That's when the line becomes `refunded` and the ledger changes.
4. **Group refund status is computed.** `OrderShopGroupStatus` replaces
   `returned` with `partially_refunded`. `return_requested`,
   `partially_refunded`, `refunded` are set from the lines, never by the status
   PATCH.
5. **Seller order-status PATCH** accepts only the transitions in doc §1
   (`pending→confirmed|cancelled`, `confirmed→preparing|cancelled`,
   `preparing→cancelled`); see task `central-store-fulfillment`.
6. **Admin dispute queue:** `PATCH /admin/refund-requests/{id}/resolve` body is
   `{ decision: "approve" | "reject", who_bears_cost?, reason }`, only on
   `escalated_to_admin`. `who_bears_cost` is required for `approve`. The admin
   UI needs both buttons; reject closes the dispute for the seller.
7. **Escalation is once only.** `RefundRequestRead.escalated_at` is set when the
   buyer escalates; hide "Escalate" when it's not null.
8. Seller approve/reject only on `pending`.

Regenerate the SDK: `RefundConfirmReturnRequest` is new; `OrderLineRead` has
`physical_return_received_at`; `RefundRequestRead` has `escalated_at`.
