---
id: shop-image-removal
title: No way to remove a shop's logo or banner once set
author: frontend
to: backend
status: closed
priority: low
area: shops
created: 2026-09-27
closed: 2026-09-27
reply_to:
---

## What

`PATCH /seller/shops/{shop_id}` can replace a logo or banner but never clear
one:

- `logo_key: null` / `banner_key: null` are ignored (`update_shop` only
  assigns when `is not None`).
- `logo_key: ""` goes through `_require_images` →
  `require_attachable([""])` → `400 "Unknown upload key: "`.

So a seller who uploads the wrong banner can only swap it for another image,
never go back to "no banner".

## Expected

A way to clear either image, for example:
- treat an explicit `null` as "remove" (use Pydantic's `model_fields_set` to
  tell "sent null" from "not sent"), or
- add `remove_logo: bool` / `remove_banner: bool` to `ShopUpdateRequest`.

Document the chosen rule in `docs/media-uploads-api.md` and the shops doc.

## Why

The seller website's shop edit form now uploads logos and banners
(`media-uploads`). It only shows "Replace" on an existing image, because
"Remove" can't work yet. The create form can drop a picked image before
saving, because nothing is attached until save.

## References

- Backend: `app/modules/shops/service.py` → `update_shop`, `_require_images`
- `openapi/api.yaml` → `ShopUpdateRequest`
- Related: `media-uploads`, `shops-api-doc`

## Resolution

Explicit `null` clears: `PATCH /seller/shops/{id}` with `"logo_key": null`,
`"banner_key": null` or `"description": null` removes it; omitted fields are
unchanged (via `model_fields_set`). `"name": null` is still ignored.
**Clients must send only changed fields** — sending `null` for an untouched
image now removes it. Documented in `docs/shops-api.md` §2 "Update" and
`docs/media-uploads-api.md`.
