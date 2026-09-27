---
id: shop-approval-status-guards
title: Shop and category-assignment approve/reject ignore current status; rejected assignment can't be re-requested
author: frontend
to: backend
status: closed
priority: normal
area: shops
created: 2026-09-27
closed: 2026-09-27
reply_to:
---

## What

### 1. Shop approve/reject accept any current status

`PATCH /admin/shops/{shop_id}/approve` and `.../reject` don't check the shop's
current status (unlike `suspend` / `reactivate`, which do):

- `approve` on a `suspended` shop skips `reactivate`; on a `closed` shop it
  reopens a shop the seller closed.
- `reject` works on `active` shops, bypassing `suspend`.

Expected: both only from `pending_review`, otherwise `400`.

### 2. Category-assignment approve/reject accept any current status

`PATCH /admin/shop-category-assignments/{id}/approve` and `.../reject` have the
same gap. Expected:

- `approve`: from `pending_approval`, or from `approved` when
  `needs_reverification` is true (re-verification).
- `reject`: same sources.
- Otherwise `400`.

### 3. A rejected category assignment blocks the seller forever

`POST /seller/shops/{shop_id}/category-assignments` returns
`400 "Category already assigned to this shop"` whenever *any* assignment exists
for that shop + category — including a `rejected` one. After a rejection the
seller can never request that category again (e.g. after fixing the documents),
and the only way out is an admin approving the rejected record, which issue 2
would close.

Expected: re-requesting a category whose assignment is `rejected` moves that
assignment back to `pending_approval` with the new `document_ids` (or creates a
new one — your call), instead of `400`.

## Why

Found while building the admin Shops tab and the Category Requests review tab.
Until this is fixed, the admin UI only offers Approve/Reject on `pending_review`
shops and on `pending_approval` / needs-re-verification assignments, and has no
action on rejected assignments. Please document the shop and category-assignment
state machines (seller + admin endpoints) in a `docs/shops-api.md` when closing
this — there's no doc for shops yet.

## References

- Backend: `app/modules/shops/service.py` → `approve_shop`, `reject_shop`,
  `approve_assignment`, `reject_assignment`, `request_category_assignment`
- openapi/api.yaml → `/api/v1/admin/shops/{shop_id}/approve`,
  `/api/v1/admin/shop-category-assignments/{assignment_id}/approve`,
  `/api/v1/seller/shops/{shop_id}/category-assignments`

## Resolution

1. Shop approve/reject: only from `pending_review`, otherwise
   `400 "Only shops in pending_review status can be approved or rejected"`.
2. Category-assignment approve/reject: from `pending_approval`, or `approved`
   with `needs_reverification`, otherwise `400`.
3. Re-requesting a `rejected` category reuses that assignment: back to
   `pending_approval` with the new `document_ids`, `rejection_reason` cleared,
   same `id`. `pending_approval`/`approved` still `400`.

State machines for shops and assignments are in the new `docs/shops-api.md`
§1 and §3. No schema change.
Backend: `app/modules/shops/service.py` → `approve_shop`, `reject_shop`,
`_require_reviewable_assignment`, `request_assignment`.
