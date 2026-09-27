---
id: seller-refund-approval-guards
title: Seller refund approve/reject — cap the amount, restrict who_bears_cost, block escalated requests
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

`PATCH /seller/refund-requests/{id}/approve` and `.../reject` go through
`_require_owned_refund` → `_require_resolvable`, which only checks ownership
and that the status is `pending` or `escalated_to_admin`. Three gaps:

1. **Amount isn't capped.** `RefundApproveRequest.refund_amount` is only
   `ge=0`. A seller can approve more than the buyer asked for, or more than the
   line total. `_write_refund_ledger_entries` then debits that amount, and
   `proportion = refund_amount / line_total` goes above 1, reversing more
   commission than was charged. Expected: `400` when
   `refund_amount > line.line_total` (or `> refund.refund_amount`, the
   requested amount; decide which) and when it's `0` (a zero approval is a
   rejection).
2. **`who_bears_cost` is unrestricted for sellers.** A seller can send
   `"platform"`, and the refund is then absorbed by the platform
   (`platform_absorbed_refund`, seller payout unaffected). Expected: sellers
   may only send `"seller"` (or drop the field for sellers and set it
   server-side). `platform` and `buyer` stay admin-only via
   `/admin/refund-requests/{id}/resolve`. Please also document what `"buyer"`
   means for the buyer. It writes nothing to the seller ledger, and no doc says
   whether the buyer is refunded or who funds it.
3. **Sellers can resolve escalated requests.** `_require_resolvable` accepts
   `escalated_to_admin` for the seller endpoints too, so after a buyer escalates
   a rejection, the seller can still approve or re-reject it. The doc calls the
   admin resolution "final". Expected: seller endpoints accept only `pending`;
   `escalated_to_admin` is admin-only.

## Why

The seller Orders page now has a refund queue. For now the UI:
- always sends `who_bears_cost: "seller"`
- caps the amount at the requested `refund_amount`, and requires it to be above 0
- only offers approve/reject on `pending`

But the API is the real boundary, and it concerns money.

## References

- Backend: `app/modules/orders/service.py` → `approve_refund`, `reject_refund`,
  `_resolve`, `_write_refund_ledger_entries`, `_require_resolvable`;
  `app/modules/orders/schemas.py` → `RefundApproveRequest`
- `openapi/api.yaml` → `RefundApproveRequest`, `WhoBearsCost`
- `docs/orders-and-payments-api.md` §3.2, §3.3, §4 `RefundRequestRead`
