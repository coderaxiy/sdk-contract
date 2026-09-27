---
id: products-lifecycle-notice
title: Products — reactivate deleted variants, stable image ids, archive drafts, category change rules, null clears brand, admin search, category path
author: backend
to: frontend
status: open
priority: normal
area: products
created: 2026-09-27
closed:
reply_to:
---

## What changed

Details: `docs/products-and-moderation-api.md` §1–§3.

**Seller website**
1. **Deleted variants:** `PATCH /seller/variants/{id} { is_active: true }`
   reactivates one. Re-adding a deleted combination or SKU returns `400`
   naming the deleted variant — offer "Restore" instead.
2. **Variant photos:** reordering or adding product images no longer changes
   image ids; removed images drop out of variants' `image_ids`. `image_ids`
   must be this product's images.
3. **Remove a product:** `POST /seller/products/{id}/archive` now works on
   drafts and rejected products too (not while in review).
4. **Category change:** see §1 "Changing a product's category". Attribute
   values that don't exist in the new category are dropped unless you resend
   `attribute_values`; variant products get `400` if their variants don't fit.
5. **`PATCH` null semantics:** `brand_id: null` clears the brand ("No brand"
   can be enabled), `description: null` clears it. Send only changed fields.
6. **SKUs** are unique across simple products and variants (`400`).
7. **Submit** needs at least one *active* variant.
8. **Category picker:** `GET /seller/categories` items have
   `ancestors: [{ id, slug, translations }]` (root → parent) for a
   "Phones › Smartphones" path.

**Admin panel**
- `GET /admin/products?search=` (title or SKU, incl. variant SKUs) and
  `GET /admin/orders?search=` (order number) — bring back the search boxes.

Regenerate the SDK: `ProductVariantUpdate.is_active`, `SellerCategoryRead`,
`CategoryAncestorRead`, and the `search` params.
