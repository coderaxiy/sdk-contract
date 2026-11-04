---
id: admin-storefront-merchandising-editor
title: Admin website — implement campaign and curated-home editor
author: backend
to: frontend
status: open
priority: high
area: storefront
created: 2026-11-04
closed:
reply_to: storefront-home-merchandising
---

## What

Audience: **company owner/admin/staff website agent**, not customer or seller web.
Implement [docs/storefront-merchandising-admin-api.md](../docs/storefront-merchandising-admin-api.md).
Needs cookie auth + `storefront:manage` (root/admin seeded; explicit custom-role grant).

- CRUD `/api/v1/admin/storefront/campaigns`: GET paginated list, POST create;
  `/{id}` GET, PUT full replacement, DELETE; `/{id}/preview` GET draft rendering.
- Create/edit Uzbek + optional Russian copy/artwork, hero, banners, UTC dates,
  published toggle, category shortcuts and ordered typed blocks (products, text,
  image, categories). Plain text only; schedule start inclusive/end exclusive.
- Upload first using POST /uploads?purpose=campaign_artwork with multipart file.
  Staff need storefront:manage, not seller registration. Use keys, never arbitrary
  URLs; attach requires current-user ownership/purpose or retaining this campaign's
  previously attached artwork. Public URLs/dimensions are generated server-side.
- Campaign slug immutable/unique; retain block/banner IDs on edits. For PUT remove
  response-only id/revision/updated_at, send expected_revision from last read.
  Missing/stale expected_revision → 409. Omitted children are deleted.
- Curate product membership/order explicitly. home_kind none/discount/recommendation
  and home_sort_order control home inclusion/order. Campaigns never set prices.
  Missing real discount data/stock means omission, not fabricated pricing.
- GET/PUT /admin/storefront/home sets up to ten category IDs; null catalog fallback,
  [] hide. No client-local configuration. Limits and examples are in the guide.
- Publication/schedule is inherited by banners; unpublish hides campaign banners
  and home sections together. Preview bypasses only campaign state/schedule, while
  product publication and stock rules still apply.

## Verification and rollout

Use generated TS types (CampaignWrite/CampaignAdminRead/HomeWrite and block models).
Test unauthorized roles, draft preview, schedule/HTML/reference validation,
reorder/preserve IDs, revision conflicts, artwork fallback, and public hide after
unpublish/delete. No-cache/read deadlines are documented in storefront-home-api.
Backend migration d9f4b7a2c601 adds tables, comparison columns and upload enum;
restart seeds storefront:manage. Content starts empty: editors must create real
campaigns. Close this task only after admin UI implementation/build/verification.

