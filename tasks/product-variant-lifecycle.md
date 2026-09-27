---
id: product-variant-lifecycle
title: Deleted variants block re-adding; variant image_ids break when product images are saved
author: frontend
to: backend
status: open
priority: normal
area: products
created: 2026-09-27
closed:
reply_to:
---

## What

1. **A deleted variant can't come back.** `DELETE /seller/variants/{id}` only
   sets `is_active=false`, but:
   - `find_by_attributes` doesn't filter `is_active`, so re-adding the same
     combination (e.g. size L / red) fails with "A variant with this exact
     attribute combination already exists".
   - `get_by_sku` doesn't filter either, so its SKU is taken forever.
   - `ProductVariantUpdate` has no `is_active`, so it can't be reactivated.
   A seller who deletes a variant by mistake is stuck. Expected: allow
   `is_active: true` in `ProductVariantUpdate` (reactivate), **or** exclude
   inactive variants from both checks. Document which.
2. **Variant `image_ids` break on every image save.** `replace_images` deletes
   all `ProductImage` rows and inserts new ones, so every `PATCH` with `images`
   (even just reordering) issues new image ids, and every variant's `image_ids`
   then points at ids that no longer exist. Expected: keep ids for images
   whose `key` is resent, or have variants reference image **keys** instead of
   ids.
3. **`image_ids` aren't validated.** A variant can reference any integer, not
   just images of its own product. Expected: `400` for ids that aren't this
   product's images.

## Why

The seller variant builder lets sellers remove variants and attach photos
to them (e.g. the red variant shows red photos). Today both features lose data
silently.

## References

- Backend: `app/modules/products/repository.py` → `find_by_attributes`,
  `get_by_sku`, `replace_images`; `app/modules/products/service.py` →
  `ProductVariantService.create_variant` / `update_variant` / `delete_variant`
- `openapi/api.yaml` → `ProductVariantUpdate`, `ProductVariantRead.image_ids`
