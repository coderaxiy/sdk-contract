---
id: product-variant-lifecycle
title: Deleted variants block re-adding; variant image_ids break when product images are saved
author: frontend
to: backend
status: closed
priority: normal
area: products
created: 2026-09-27
closed: 2026-09-27
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

4. **Submit counts deleted variants.** `submit_for_review` checks
   `variant_repo.list_by_product(product.id)`, which doesn't filter
   `is_active`. A variant product whose variants were all deleted still passes
   "must have at least one variant" and goes to review with nothing to buy.
   Expected: count active variants only. The seller UI already blocks submit
   without an active variant.

## Why

The seller variant builder lets sellers remove variants and attach photos
to them (e.g. the red variant shows red photos). Today both features lose data
silently.

## References

- Backend: `app/modules/products/repository.py` → `find_by_attributes`,
  `get_by_sku`, `replace_images`; `app/modules/products/service.py` →
  `ProductVariantService.create_variant` / `update_variant` / `delete_variant`
- `openapi/api.yaml` → `ProductVariantUpdate`, `ProductVariantRead.image_ids`

## Resolution

1. **Deleted variants come back by reactivation**, not by excluding them from the
   checks: variant `sku` has a DB unique constraint, so a deleted variant must
   keep its SKU. `ProductVariantUpdate.is_active` (`true` reactivates, `false`
   deletes). Creating a variant with a deleted variant's combination or SKU is
   `400` naming it: `"Deleted variant 12 (PT-L) has this attribute combination —
   reactivate it with PATCH /seller/variants/12 {"is_active": true}"`.
   Reactivation re-checks the keys against the product's current category.
2. **Image ids survive saves:** images are matched by `key`; resent keys keep
   their row and `id` (order/primary updated), removed ones are deleted and
   stripped from every variant's `image_ids`.
3. **`image_ids` validated:** must be this product's image ids (`400` listing
   the foreign ones); duplicates removed.
4. **Submit counts active variants only** (`"…at least one active variant…"`).

Docs: `docs/products-and-moderation-api.md` §1 Images, §3 variant rows.
Backend: `app/modules/products/{service,repository,schemas}.py`. The unused
`deactivate_variant` (no route; same as DELETE) was removed.
