---
id: refunds-all-or-nothing-mobile
title: Refund rework — no refund amount, new line/group refund statuses, one escalation per request
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

Full rules: `docs/orders-and-payments-api.md` §1 "Refunds are all-or-nothing".

1. `POST /order-lines/{id}/refund-request`: `refund_amount` removed from the
   body. The refund is always the line's full price; show it, no amount input.
2. **Statuses to display:**
   - `OrderLineStatus`: `active | return_pending | refunded` (`returned` is
     gone). `return_pending` = "Refund approved — send the item back; you'll be
     refunded when the seller receives it". `never_arrived` refunds skip it.
   - `OrderShopGroupStatus`: `returned` replaced by `partially_refunded`
     (some items refunded, others kept).
3. **Escalate once.** `RefundRequestRead.escalated_at` is set after the buyer
   escalates; hide "Escalate" when it's not null. The admin's decision is final
   (approve or reject).
4. A refund can still be requested for other items after one is refunded
   (group `return_requested` or `partially_refunded`), within the return window.
5. `who_bears_cost` is `"seller" | "platform"` (`"buyer"` removed). Buyers
   don't need to show it.

Regenerate the SDK: `OrderLineRead.physical_return_received_at`,
`RefundRequestRead.escalated_at`, and the enum changes above.
