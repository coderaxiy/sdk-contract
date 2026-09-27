---
id: shop-rejected-resubmit
title: A rejected shop has no way back to review
author: frontend
to: backend
status: closed
priority: normal
area: shops
created: 2026-09-26
closed: 2026-09-27
reply_to:
---

## What

Once an admin rejects a shop (`PATCH /admin/shops/{id}/reject` → `status:
rejected`), the seller can't do anything with it except close it:

- `POST /seller/shops/{id}/submit` only accepts `pending_review` (400
  "Only shops in pending_review status can be submitted").
- `PATCH /seller/shops/{id}` succeeds on a rejected shop but leaves it
  `rejected`. Renaming only moves **`active`** shops back to review.
- Closing it and creating a new shop is the only path, and the old name stays
  taken (uniqueness is checked against all shops, closed included, via
  `get_by_name_ilike`).

## Expected

Decide one of these, and document it in `docs/shops-api.md`:

1. **Resubmittable (our preference):** a seller can fix the problem the admin
   named in `status_reason`, then `POST /submit` on a `rejected` shop moves it
   back to `pending_review` (clearing `status_reason`). Possibly limited to N
   resubmits.
2. **Terminal:** rejected is final. Then say so, and let a closed/rejected
   shop's name be reused, so "close and recreate" actually works.

## Why

The seller website shows the rejection reason on the shop row. Right now the
only honest thing it can say next to it is "close this shop and create a new
one with a different name", which is a dead end for a seller who just needed to
fix a description.

## References

- Backend: `app/modules/shops/service.py` → `submit_for_approval`, `update_shop`, `create_shop` (name check)
- `openapi/api.yaml` → `/api/v1/seller/shops/{shop_id}/submit`, `ShopStatus`

## Resolution

Option 1 (Doc 01 §4.2): rejected shops are resubmittable. `POST
/seller/shops/{id}/submit` on a `rejected` shop moves it to `pending_review`
and clears `status_reason` (audit action `shop.resubmitted`). No resubmit
limit. `PATCH` already worked on rejected shops, so the flow is edit → submit.
Documented in `docs/shops-api.md` §2 "Submit".
Also fixed: renaming a shop to a different capitalization of its own name
returned "already taken".
