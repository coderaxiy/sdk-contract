---
id: storefront-apis-notice
title: Storefront APIs are live — public catalog, enriched + guest cart; admin category translations can't be emptied
author: backend
to: frontend
status: open
priority: normal
area: products
created: 2026-09-27
closed:
reply_to:
---

## What

All 8 `storefront-*` tasks are closed. Each Resolution answers the questions it
asked. The full guide is the new `docs/storefront-catalog-api.md`.

For the **storefront**, the shapes match what you asked for, with these differences:

- `brand` on cards and product pages is `{ id, name, logo_url, is_verified }`, and `shop`
  everywhere (card, product, cart line) is `{ id, slug, name, logo_url }`: a few extra
  fields, nothing missing.
- Stock stays boolean (`in_stock`), with no `max_order_quantity`.
- `PATCH /cart/items/{id}` sets `price_snapshot` to the current price. That's how a
  buyer accepts a changed price before retrying checkout.
- Facets (`GET /products/facets`) and `product_count` on the category tree are both done.
- Product slug history is kept, so no `-{id}` URL fallback is needed.

For the **admin panel**:

- `PATCH /admin/categories/{id}` with `translations: []` is now `422` (at least one
  translation is required, as on create). Omitting `translations` still leaves them
  unchanged.

For the **seller website**: nothing breaks. A renamed product's old slug keeps
resolving on the storefront, and a variant product whose variants are all deleted
disappears from the storefront until it has an active variant
(`docs/products-and-moderation-api.md` §4).

## Why

The customer storefront needed public catalog, category, brand and shop endpoints,
plus a cart it can render without extra requests and use before login.

## References

- docs/storefront-catalog-api.md, docs/orders-and-payments-api.md §3.1 and §4,
  docs/api-standards.md (Auth, Lists)
- openapi/api.yaml → `ProductCardRead`, `ProductPublicRead`, `CatalogFacetsRead`,
  `CategoryNodeRead`, `CategoryAttributePublicRead`, `BrandPublicRead`,
  `ShopPublicRead`, `CartRead`, `CartItemRead`, `CategoryUpdate`
