---
id: storefront-public-shop-and-brands
title: Public shop profile (by slug) and public brand list
author: frontend
to: backend
status: closed
priority: normal
area: shops
created: 2026-09-27
closed: 2026-09-27
reply_to:
---

## What

### 1. Public shop profile — `GET /shops/by-slug/{slug}`

There's no public shop endpoint; `ShopRead` is seller/admin only and includes
`seller_id`, `legal_entity_override`, `status_reason` and the upload keys. The
storefront has a shop page at `/shops/{slug}` (header with logo, banner,
description, rating; product grid below).

**Ask:** `GET /shops/by-slug/{slug}`, public. `404` unless the shop is
`active` (same rule as the public product endpoints). A `by-slug/` segment
rather than `/shops/{slug}` because `/shops/{shop_id}/products` already takes an
int, and a digits-only slug would be ambiguous.

```ts
// GET /shops/by-slug/{slug} → ShopPublicRead
{
  id: number
  slug: string
  name: string
  description: string | null
  logo_url: string | null
  banner_url: string | null
  rating_avg: string | null        // Decimal as string; null = no ratings yet
  rating_count: number
  created_at: string               // "On emarket since 2026"
}
```

The product grid on the shop page will use `GET /products?shop_id=` from
`storefront-catalog-search`. `GET /shops/{shop_id}/products` can stay for now;
it should return `ProductPublicRead` per `storefront-public-product-read`.

Shop slugs can't change after creation (`ShopUpdateRequest` has no `slug`), so no
redirect handling is needed. Please keep it that way, or tell us if that changes.

### 2. Public brands — `GET /brands`

Brands are only readable via `/admin/brands` and `/seller/brands`. The catalog
filter sidebar needs a brand list, and product cards/pages show the brand name.

**Ask:** `GET /brands`, public, **approved brands only**, ordered by `name`.
Optional `category_id` filter: only brands that have at least one visible product
in that category or its descendants (so the sidebar doesn't list 500 brands on
"Phones"). Optional `q` for a brand search box in the filter.

```ts
// GET /brands?category_id=&q= → BrandPublicRead[]
{
  id: number
  name: string
  logo_url: string | null
  is_verified: boolean
}[]
```

No `status`, `requested_by_shop_id` or `created_at`. Brand pages aren't planned,
so no slug is needed yet.

## Why

Shop pages and "Sold by" links on product pages need the public profile; the
brand filter in the catalog needs the brand list. Both are blocked today by
seller/admin-only endpoints.

## References

- openapi/api.yaml → `ShopRead`, `BrandRead`, `/api/v1/seller/brands`,
  `/api/v1/admin/brands`, `/api/v1/shops/{shop_id}/products`
- docs/shops-api.md ("Shop address", visibility table)
- Related: `storefront-catalog-search`, `storefront-public-product-read`

## Resolution

1. `GET /shops/by-slug/{slug}` → `ShopPublicRead`, as specified. 404 unless `active`.
   **Shop slugs stay immutable**; that's now written down in `docs/shops-api.md`.
   `GET /shops/{shop_id}/products` returns `ProductPublicRead[]`.
2. `GET /brands` → `BrandPublicRead[]`: approved only, ordered by name, with optional `category_id`
   (brands with a visible product in the category or its descendants) and `q` (same spelling
   rules as catalog search). For brands in the current results with counts, use
   `GET /products/facets`.

Docs: `docs/storefront-catalog-api.md` §5–6.
