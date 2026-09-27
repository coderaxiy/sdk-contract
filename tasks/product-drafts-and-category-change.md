---
id: product-drafts-and-category-change
title: Drafts can't be deleted; changing a product's category doesn't re-check its attributes or variants
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

1. **Drafts can't be removed.** `POST /seller/products/{id}/archive` only
   accepts `approved` / `delisted`, and there's no delete endpoint. A seller who
   starts a product by mistake keeps it forever. Expected: allow deleting (or
   archiving) `draft` products, and maybe `rejected` ones.
2. **A category change leaves stale data.** `PATCH /seller/products/{id}` with a
   new `category_id` doesn't re-validate the existing `attribute_values` (their
   `category_attribute_id`s may not belong to the new category's schema), or
   the variants' attribute keys (they may not be variant-defining there), or
   `allows_variants` for a `has_variants=true` product. Expected: either
   require `attribute_values` to be resent with a category change and validate
   them against the new schema, or drop values that no longer apply, and `400`
   when variants don't fit. Document the rule.
3. **A brand can't be removed.** `update` only assigns `brand_id` when it
   `is not None`, so once a product has a brand, the seller can switch it but
   never go back to "no brand". Expected: an explicit `null` clears it (use
   `model_fields_set` to tell "sent null" from "omitted"). Same pattern as
   `shop-image-removal`. The seller editor disables "No brand" on products
   that have one until this lands.
4. **Minor:** a simple product's `sku` isn't checked for uniqueness, while
   variant SKUs are unique platform-wide. Is that intended?

## Why

The seller product editor lets the category be changed on edit. We'd rather
not let the form send data the backend would silently keep in an inconsistent
state.

## References

- Backend: `app/modules/products/service.py` → `update`, `archive`,
  `create_draft`
- `docs/products-and-moderation-api.md` §1 "Product status", §3

## Resolution

1. **Removing drafts:** `POST /seller/products/{id}/archive` now works from
   `draft`, `rejected`, `approved`, `delisted` (anything but `pending_review`
   and `archived`). Archive is the removal: no hard delete, history is kept.
2. **Category change:** documented in §1 "Changing a product's category".
   `attribute_values` sent with the change are validated against the new
   schema; if not sent, values outside the new schema are dropped (shared ones
   kept). Variant products: the new category must allow variants and every
   active variant's keys must be variant-defining there, else `400` naming the
   variants.
3. **Brand removal:** explicit `null` clears `brand_id` (and `description`);
   omitted fields are unchanged. §1 "Clearing fields".
4. **SKUs:** yes, unique platform-wide — now across simple products *and*
   variants in one namespace (`400`). Enforced in the service; there's no
   cross-table DB constraint.

**Follow-up (same day):** superseded by the SKU split (Doc 03 §2.1a). `sku` is
now `platform_sku` (generated, platform-wide unique) + `seller_sku` (optional,
unique within the shop only). See notice `products-lifecycle-notice`.
