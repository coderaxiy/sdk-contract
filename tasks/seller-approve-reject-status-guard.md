---
id: seller-approve-reject-status-guard
title: Approve/reject seller accept any current status, including banned
author: backend
to: backend
status: closed
priority: high
area: sellers
created: 2026-09-26
closed: 2026-09-27
reply_to:
---

## What

`PATCH /admin/sellers/{seller_id}/approve` and `.../reject` don't check the
seller's current status:

- `approve` on a **banned** seller sets it back to `active`. Ban is supposed to
  be terminal, and `reinstate` explicitly refuses banned sellers — approve is a
  way around that. The seller's shops stay suspended, so the result is an
  active seller with dead shops.
- `approve` on a `suspended` seller skips `reinstate` and overwrites `verified_at`.
- `reject` works on `active` sellers, bypassing `suspend`/`ban`.

## Expected

- `approve`: only from `pending_review` (and probably `rejected`, if re-applying
  is allowed — decide). Otherwise `400`.
- `reject`: only from `pending_review`. Otherwise `400`.

Same pattern as `suspend_seller` / `reinstate_seller` in
`app/modules/sellers/service.py`.

## Why

Found while writing `docs/sellers-and-approval-api.md`. Until this is fixed, the
doc tells the frontend to only show Approve/Reject on `pending_review` sellers.
Update that section when closing this task.

## References

- Backend: `app/modules/sellers/service.py` → `approve_seller`, `reject_seller`
- `docs/sellers-and-approval-api.md` §3 "Review screen"

## Resolution

- `approve`: allowed from `pending_review` and `rejected`, otherwise
  `400 "Only sellers in pending_review or rejected status can be approved"`.
  `rejected` is allowed because a user can't register a second seller profile,
  so reversing the rejection is the only way back after fixing documents.
  Banned and suspended sellers can no longer be approved (suspended goes through
  reinstate).
- `reject`: only from `pending_review`, otherwise
  `400 "Only sellers in pending_review status can be rejected"`.
- `docs/sellers-and-approval-api.md` §1 state diagram and §3 "Review screen"
  updated (the "backend doesn't enforce this yet" note is gone).
- Backend: `app/modules/sellers/service.py` → `approve_seller`, `reject_seller`.
