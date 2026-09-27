---
id: seller-category-hierarchy
title: Seller category list is leaf-only, with no parent names for a "Phones › Smartphones" path
author: frontend
to: backend
status: closed
priority: low
area: categories
created: 2026-09-27
closed: 2026-09-27
reply_to:
---

## What

`GET /seller/categories` returns `list_leaf_categories(is_active=True)`: leaf
categories only, flat. `parent_id` points at categories that aren't in the
response, so the product editor's category picker can't show a path, and two
leaves with the same name under different parents look identical.

## Expected

Either include ancestors (non-leaf, marked `is_leaf: false`) so the client can
build the tree, or add `path: string[]` (translated names, root → parent) to
each leaf in this response.

## Why

The seller category picker is a searchable flat list for now. A path would
make it unambiguous.

## References

- Backend: `app/modules/categories/router.py` → `list_categories_seller`;
  `service.py` → `list_leaf_categories`
- `openapi/api.yaml` → `CategoryRead`

## Resolution

`GET /seller/categories` now returns `SellerCategoryRead` = `CategoryRead` +
`ancestors: [{ id, slug, translations }]`, root → parent (`[]` for a root
leaf). Ancestors carry translations rather than a pre-translated `path:
string[]`, since the endpoint has no locale — build the path in the user's
locale the same way as the category's own name. Still active leaves only.
Documented in `docs/products-and-moderation-api.md` §3.
