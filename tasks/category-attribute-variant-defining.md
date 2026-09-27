---
id: category-attribute-variant-defining
title: Expose is_variant_defining on CategoryAttributeRead (docs say it's there; the API doesn't return it)
author: frontend
to: backend
status: closed
priority: high
area: products
created: 2026-09-27
closed: 2026-09-27
reply_to:
---

## What

`docs/products-and-moderation-api.md` §1 "Attribute values" says: "Each
`CategoryAttribute` in that response now also carries an `is_variant_defining`
boolean". It doesn't. `GET /seller/categories/{category_id}/attributes` returns
`CategoryAttributeRead`, which has no such field in `openapi/api.yaml`, the SDK,
or the live `openapi.json`. The column exists on the model
(`app/modules/categories/model.py`), and `ProductVariantService.
_validate_variant_defining_keys` enforces it. It just isn't serialized.

## Expected

Add `is_variant_defining: boolean` to `CategoryAttributeRead` (both the admin
and seller attribute endpoints), then regenerate the spec and SDKs.

## Why

The seller product editor's variant builder has to offer only the attributes a
variant may use (size, color…), since anything else is rejected with "Variant
attribute keys must be variant-defining". Without the flag, the only options
are guessing (e.g. every `select` attribute) or letting sellers hit that error.
The variant builder (phase P7) is **on hold until this lands**. The rest of the
product editor is being built meanwhile.

## References

- `openapi/api.yaml` → `CategoryAttributeRead`
- Backend: `app/modules/categories/model.py` (`is_variant_defining`),
  `app/modules/categories/schemas.py`, `app/modules/products/service.py` →
  `_validate_variant_defining_keys`
- `docs/products-and-moderation-api.md` §1

## Resolution

- `CategoryAttributeRead.is_variant_defining: boolean` is now returned by both
  `GET /seller/categories/{category_id}/attributes` and the admin attribute
  endpoints (inherited attributes included).
- The flag couldn't be **set** either: `CategoryAttributeIn` didn't have it, so
  every attribute was `false` and no variant attribute key was ever accepted.
  `CategoryAttributeIn.is_variant_defining` (default `false`) now exists on
  `PUT /admin/categories/{id}/attributes`. A `multi_select` attribute can't be
  variant-defining (`422`). **Existing categories need an admin to re-save their
  attributes with the flag set** before the variant builder has anything to offer.
- Spec + SDKs regenerated; `docs/products-and-moderation-api.md` §1 updated.
- Backend: `app/modules/categories/{schemas,service,router}.py`.
