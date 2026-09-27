---
id: media-uploads
title: File uploads are live — shop logo/banner, product images, and documents now take upload keys (breaking)
author: backend
to: frontend
status: open
priority: high
area: uploads
created: 2026-09-27
closed:
reply_to:
---

## What

There's a new upload endpoint, and every place that used to accept a file URL
now accepts an **upload key** instead. Full guide: `docs/media-uploads-api.md`.

**New:** `POST /api/v1/uploads?purpose=<purpose>` (multipart, field `file`) →
`201 UploadRead { key, url, ... }`. Purposes: `shop_logo`, `shop_banner`,
`product_image`, `seller_document`.

**Breaking request changes.** Careful: the shop endpoints **silently ignore** an
old `logo_url` / `banner_url` (unknown fields are dropped), so a save looks
successful but the logo never changes. The product and document endpoints fail
with `422` (`key` / `file_key` missing).

| Endpoint | Before | Now |
|---|---|---|
| `POST /seller/shops`, `PATCH /seller/shops/{id}` | `logo_url`, `banner_url` | `logo_key`, `banner_key` |
| `POST /seller/shops/{id}/products`, `PATCH /seller/products/{id}` | `images: [{ url, ... }]` | `images: [{ key, ... }]` |
| `POST /seller/documents` | `file_url` | `file_key` |

**Responses** keep `logo_url`, `banner_url`, `images[].url`, and `file_url`
(now built from the key), and add `logo_key`, `banner_key`, `images[].key`,
`file_key`. Display code doesn't need to change.

## What the frontend needs to do

1. Seller website — shop create/edit: upload logo and banner on file selection,
   send `logo_key` / `banner_key` on save.
2. Seller website — product create/edit: upload each image
   (`purpose=product_image`), send `images: [{ key, sort_order, is_primary }]`.
   On edit, **resend the keys of images you keep** — the list is replaced wholesale.
3. Seller website — KYC documents: upload with `purpose=seller_document`
   (JPEG/PNG/WebP/PDF), then `POST /seller/documents { type, file_key }`.
4. Admin panel — document review: `file_url` is now a **15-minute signed link**.
   Don't cache it; re-fetch `GET /admin/sellers/{id}/documents` to view again.
5. Show upload errors' `detail` as-is (wrong type, over 10 MB, etc.). Treat
   `503` as "try again".

## References

- `docs/media-uploads-api.md` — flow, rules per purpose, errors, TS snippet
- `docs/products-and-moderation-api.md` → Images
- `docs/sellers-and-approval-api.md` → Documents
- `openapi/api.yaml` → `UploadRead`, `UploadPurpose`, `ShopCreateRequest`, `ProductImageIn`, `DocumentSubmitRequest`

## Progress (frontend, 2026-09-27)

- **1. Shop create/edit: done** in the seller website. Logo and banner upload
  on selection (`purpose=shop_logo` / `shop_banner`, click or drag-and-drop,
  progress, the backend's `detail` shown as-is), and `logo_key` / `banner_key`
  are sent on save. Save is disabled while an upload runs. The edit form
  only offers "Replace", because an attached image can't be cleared (see
  `shop-image-removal`). The shared uploader (`ImageUploadField`, and
  `uploadFile()` / `precheckImage()` in `src/lib/api/uploads.ts`) is ready for
  products.
- **2. Product images: not started.** The Products page isn't built yet.
- **3. KYC documents: not started.** Onboarding has no documents step yet.
- **4. Admin panel:** not this app.
- Leaving this task open until 2 and 3 are done.
