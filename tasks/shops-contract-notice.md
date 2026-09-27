---
id: shops-contract-notice
title: Shops — 409 for taken slugs and shop limit, ASCII slugs, null clears images, resubmit rejected shops
author: backend
to: frontend
status: open
priority: high
area: shops
created: 2026-09-27
closed:
reply_to:
---

## What changed

New guide: `docs/shops-api.md`. Changes clients must react to:

1. **`409` instead of `400`** for `POST /seller/shops` when the explicit `slug`
   is taken, and when the seller is at their shop limit.
2. **Slugs are ASCII-only** (transliterated). Update the client-side slug
   mirror to the algorithm and table in `docs/shops-api.md` §2 "Shop address".
   Live check: `GET /seller/shops/slug-availability?slug=` →
   `{ slug, available }` (new `SlugAvailabilityRead`).
3. **`PATCH /seller/shops/{id}`: explicit `null` now clears** `logo_key`,
   `banner_key` and `description`. Send only changed fields — a form that sends
   `logo_key: null` for an untouched logo will remove it. Add "Remove" next to
   "Replace" on logo/banner.
4. **Rejected shops can be resubmitted:** edit, then `POST /seller/shops/{id}/submit`
   → `pending_review`. Replace the "close and create a new shop" copy.
5. **Rejected category assignments** can be re-requested with new
   `document_ids`; the same assignment goes back to `pending_approval`.
6. **Admin:** shop approve/reject only on `pending_review`; assignment
   approve/reject only on `pending_approval` or `approved` +
   `needs_reverification`. Others are `400`.
7. Checkout refuses cart items from shops that aren't `active`
   (`400 "Product N is no longer available"`).
