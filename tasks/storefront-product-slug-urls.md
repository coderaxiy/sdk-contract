---
id: storefront-product-slug-urls
title: Look up a public product by shop slug + product slug
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

Product URLs on the storefront should be readable and shareable:
`/shops/{shop-slug}/{product-slug}` (e.g. `/shops/toshkent-bozori/samsung-galaxy-a55`).
Today a product can only be fetched by id (`GET /products/{product_id}`).

Product slugs are unique **per shop** (the seller API returns `400 "Slug 'x' is
already used by another product in this shop"`), so a product slug alone isn't
enough — the shop slug is part of the key.

**Ask:** `GET /shops/by-slug/{shop_slug}/products/{product_slug}`, public, same
visibility rule as `GET /products/{product_id}` (approved product in an active
shop, else `404`). Returns `ProductPublicRead` from
`storefront-public-product-read`, unchanged.

### Renamed slugs

`ProductUpdate` accepts `slug`, so a seller can rename a product and break every
link already shared or indexed. Please keep the old slugs: when
`{product_slug}` matches a product's **previous** slug in that shop, return the
product as usual. The response carries the current `slug` (and `shop.slug`), and
the storefront issues a `301` to the canonical URL when they differ from the
request. No new response fields needed.

If keeping slug history isn't feasible now, say so and we'll fall back to
`/shops/{shop-slug}/{product-slug}-{id}` URLs (resolved via
`GET /products/{id}`, redirecting when the slug part is stale). That needs no
backend change, but the URLs are uglier, so we'd prefer the lookup.

## Why

Readable, stable product URLs for sharing and search engines. The storefront renders product pages server-side,
so one lookup by the URL's slugs is what the page needs.

## References

- openapi/api.yaml → `/api/v1/products/{product_id}`, `ProductUpdate.slug`,
  `ProductRead.slug`
- docs/products-and-moderation-api.md "Error shape" (the per-shop slug 400)
- Related: `storefront-public-product-read`, `storefront-public-shop-and-brands`
  (`/shops/by-slug/{slug}`)

## Resolution

`GET /shops/by-slug/{shop_slug}/products/{product_slug}` → `ProductPublicRead`, 404 unless
the product is visible.

**Slug history is kept** (new `product_slug_history` table): when a seller renames a product,
the old slug keeps resolving to it. The response carries the current `slug` and
`shop.slug`, so redirect when they differ. If another product in the shop later takes an old
slug, it belongs to that product from then on. The `-{id}` fallback isn't needed.

Docs: `docs/storefront-catalog-api.md` §3.
