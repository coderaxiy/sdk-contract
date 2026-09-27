---
id: storefront-apis-breaking-mobile
title: Breaking — public product endpoints return ProductPublicRead; cart responses reshaped; guest cart
author: backend
to: mobile
status: open
priority: high
area: orders
created: 2026-09-27
closed:
reply_to:
---

## What

Shipped for the customer storefront. Several changes break the buyer app once it
updates the SDK.

### 1. Public product endpoints return `ProductPublicRead` (breaking)

`GET /products/{product_id}` and `GET /shops/{shop_id}/products` no longer return
`ProductRead`. The new schema is `ProductPublicRead`:

- **Gone:** `shop_id`, `category_id`, `brand_id` (now nested `shop`, `category`,
  `brand` objects), `base_price`, `stock_quantity`, `seller_sku`, `status`,
  `rejection_reason`, `needs_attention`, `moderated_by`, `moderated_at`, `updated_at`,
  `images[].key`, `variants[].stock_quantity` / `seller_sku` / `is_active` / `product_id`,
  and `attribute_values` (replaced by resolved `attributes` with labels).
- **New:** `price_min`, `price_max`, `in_stock` (product and per variant),
  `shop { id, slug, name, logo_url }`, `brand`, `category` with `ancestors`,
  resolved `attributes`.
- `variants` holds **active variants only**. A variant product with no active
  variant is now `404`.

The shop list returns `[]` for an inactive shop, as before.

### 2. Cart responses reshaped (breaking)

- `CartRead`: `buyer_id` removed. New `item_count`, `subtotal`. `status` is now an enum.
- `CartItemRead`: `product_id` / `variant_id` removed → `product { id, slug, title, image_url }`,
  `variant { id, attributes } | null`, plus `shop`, `unit_price` (current price),
  `line_total`, `available`, `in_stock`.
- `POST /cart/items` and `PATCH /cart/items/{id}` return the new `CartItemRead`.
- Another cart's item: `404 "Cart item not found"` (was `403 "Not your cart item"`).
- Add/update now check stock: `400 "Not enough stock for the requested quantity"`.
- `PATCH /cart/items/{id}` sets `price_snapshot` to the current price. To accept
  a checkout `price_changed`, PATCH each affected line with its current quantity,
  then retry checkout.

### 3. New, non-breaking

- Cart works without login (guest cart via the `cart_token` cookie, merged on
  `POST /auth/login` / `/auth/register`). The app's cookie jar already stores and
  sends it. An app that requires login before the cart needs no change.
- Catalog: `GET /products` (search, filters, sort, `X-Total-Count` header),
  `GET /products/facets`, `GET /categories` (tree), `GET /categories/{id}/attributes`,
  `GET /brands`, `GET /shops/by-slug/{slug}`, `GET /shops/by-slug/{shop}/products/{product}`.
  All public.

## Why

The buyer-facing responses exposed moderation state, seller SKUs and exact stock
to anyone, and a cart line needed one product request each to render.

## References

- docs/storefront-catalog-api.md (new)
- docs/orders-and-payments-api.md §3.1 (guest cart, add/update errors), §4 (`CartRead`, `CartItemRead`)
- openapi/api.yaml → `ProductPublicRead`, `ProductCardRead`, `CartRead`, `CartItemRead`
- Closed: storefront-public-product-read, storefront-cart-product-info, storefront-guest-cart
