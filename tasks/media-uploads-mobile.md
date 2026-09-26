---
id: media-uploads-mobile
title: File uploads and upload keys — SDK update for image fields and uploads
author: backend
to: mobile
status: open
priority: normal
area: uploads
created: 2026-09-27
closed:
reply_to:
---

## What

The SDK was regenerated with a new uploads API and changed image fields. Full
guide: `docs/media-uploads-api.md`.

- **Display (buyer-facing screens): no change needed.** `ShopRead.logo_url`,
  `ShopRead.banner_url`, and `ProductImageRead.url` are still there and still
  full URLs. Models now also carry `logo_key`, `banner_key`, `images[].key`.
- **New:** `UploadsApi.createUploadApiV1UploadsPost(purpose, file)` —
  Kotlin takes a `MultipartBody.Part`, Swift a local file `URL`.
- **Breaking, if the app has seller screens:** shop, product, and document
  requests now take keys (`logo_key`, `banner_key`, `images[].key`, `file_key`)
  instead of URLs. Upload first, then send the key.

## What mobile needs to do

1. Pull the contract repo and rebuild against the new SDK. Fix any compile
   errors from the renamed request fields.
2. If the app uploads anything: follow the Kotlin/Swift snippets in
   `docs/media-uploads-api.md`. Convert HEIC to JPEG before uploading on iOS.
3. If the app shows seller documents: `file_url` is a 15-minute signed link —
   don't cache it.

## References

- `docs/media-uploads-api.md`
- `openapi/api.yaml` → `UploadRead`, `UploadPurpose`, `ShopRead`, `ProductImageRead`
