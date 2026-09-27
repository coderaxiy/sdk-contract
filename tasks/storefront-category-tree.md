---
id: storefront-category-tree
title: Public category tree with localized names, and public category attributes
author: frontend
to: backend
status: closed
priority: high
area: categories
created: 2026-09-27
closed: 2026-09-27
reply_to:
---

## What

Categories are only readable through `/admin/categories` (needs a permission)
and `/seller/categories` (sellers only, leaves only, flat). The storefront needs
the whole active tree for the catalog menu, category pages and breadcrumbs, and
each category's filterable attributes for the filter sidebar.

### 1. `GET /categories` — public, whole active tree

Only `is_active = true` categories, nested, ordered by `sort_order`, then `id`.

```ts
// GET /categories → CategoryNodeRead[]   (roots)
type CategoryNodeRead = {
  id: number
  parent_id: number | null
  slug: string
  icon_url: string | null
  sort_order: number
  is_leaf: boolean
  translations: TranslationRead[]     // { locale, name, description }, same as CategoryRead
  children: CategoryNodeRead[]
}
```

- **No** commission, document, `requires_documents`, `return_window_days` or
  `default_commission_rule_id` fields — those are seller/admin concerns.
  (If `return_window_days` is meant to be shown to buyers on the product page,
  put it on `ProductPublicRead` instead.)
- Localization: all translations, client picks `uz` / `ru` / `en`, same as
  `CategoryRead`. Please make sure every active category has at least one
  translation; we fall back to `slug` otherwise.
- The frontend caches this response (it's small and changes rarely). A
  `Cache-Control: public, max-age=300` (or an `ETag`) would help.
- Nice-to-have: `product_count` per node (approved products in active shops,
  descendants included) so the menu can hide empty branches. Don't block on it.

### 2. Category by slug

Storefront URLs will be `/catalog/{category-slug}`. We can resolve the slug from
the cached tree, so no extra endpoint is needed **if** category slugs are
globally unique. Please confirm that. Since `CategoryUpdate` allows changing
`slug`, old links will 404; that's acceptable for categories.

### 3. `GET /categories/{category_id}/attributes` — public

Same data as `/seller/categories/{category_id}/attributes` (effective attributes,
inherited ones included), open to everyone, for an active category (404 otherwise).
Used to build the filter sidebar and to label `attr=key:value` filters in
`storefront-catalog-search`.

```ts
// GET /categories/{category_id}/attributes → CategoryAttributePublicRead[]
{
  id: number
  key: string
  data_type: 'text' | 'number' | 'boolean' | 'select' | 'multi_select'
  options: string[] | null
  unit: string | null
  is_filterable: boolean
  is_variant_defining: boolean
  sort_order: number
  translations: AttributeTranslationRead[]   // { locale, label }
}[]
```

Option values (`options`) aren't localized today, so filter chips show the raw
value ("red", "XL"). If per-option labels are planned, tell us the shape and
we'll build against it; otherwise we ship with raw values.

## Why

The catalog menu (desktop dropdown, mobile "Catalog" tab), category pages,
product breadcrumbs and search filters all depend on this. Without it every
category page is a placeholder.

## References

- openapi/api.yaml → `CategoryRead`, `TranslationRead`, `SellerCategoryRead`,
  `CategoryAttributeRead`, `AttributeTranslationRead`,
  `/api/v1/seller/categories`, `/api/v1/seller/categories/{category_id}/attributes`
- docs/products-and-moderation-api.md §3 (`/seller/categories`)
- Related: `storefront-catalog-search`

## Resolution

1. `GET /categories` → `CategoryNodeRead[]`, the whole public tree, ordered by `sort_order`, `id`.
   A deactivated category hides its whole subtree. `Cache-Control: public, max-age=300`.
   **`product_count` (nice-to-have): done**: visible products, descendants included.
   No commission/document/return-window fields.
2. **Category slugs are globally unique** (DB unique constraint), so resolving from the cached
   tree is safe. Admins can still rename them; old links 404, as you accepted.
   Every category is created with at least one translation, and `PATCH /admin/categories/{id}`
   now rejects `translations: []` (`422`), so it stays that way. All current categories have one.
3. `GET /categories/{category_id}/attributes` → `CategoryAttributePublicRead[]` (effective
   attributes, inherited included), 404 unless the category is in the public tree. Same cache header.
   Option values aren't localized and no per-option labels are planned, so ship with raw values.

Docs: `docs/storefront-catalog-api.md` §4.
