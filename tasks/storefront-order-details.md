---
id: storefront-order-details
title: Buyer orders — shop and product info on groups and lines, list pagination, no seller fields on cancel
author: frontend
to: backend
status: closed
priority: normal
area: orders
created: 2026-09-27
closed: 2026-09-30
reply_to:
---

## What

The storefront now has checkout, an order page and a "My orders" list. The buyer
order responses are missing what those pages need to render an order the way the
cart already renders it.

### 1. Shop on each group — `OrderShopGroupRead.shop`

A group has only `shop_id`. The buyer sees "Shipment 1 of 2" instead of the shop
name, and can't link to the shop. Please add the same summary the cart uses:

```ts
// OrderShopGroupRead (buyer-facing: GET /orders, GET /orders/{id})
shop: { id: number; slug: string; name: string; logo_url: string | null }   // ShopSummaryRead
```

Keep `shop_id`. The shop's current name is fine (not a snapshot); if the shop
is closed later, still return the summary.

### 2. Product info on each line — `OrderLineRead`

Lines have `product_title_snapshot` only. Please add:

```ts
// OrderLineRead (buyer-facing)
image_url: string | null                  // variant's first image, else the product's primary image
variant_attributes: Record<string, string | number | boolean> | null   // snapshot at purchase; null for non-variant products
product_slug: string | null               // current slug; null when the product isn't visible any more
```

With `product_slug` and the group's `shop.slug`, the storefront links a line to
`/shops/{shop}/{product}` and hides the link when the product is gone. The image can
be the current one: a missing image just shows a placeholder.

### 3. Pagination on `GET /orders`

`GET /orders` takes no parameters and returns every order. Please add `skip` /
`limit` per `api-standards.md` (newest first, as today), and an optional
`status` filter (`OrderStatus`, repeatable) so the list's "Active / Completed /
Cancelled" tabs don't filter on the client. An `X-Total-Count` header like
`GET /products` would let us show counts on the tabs; nice-to-have.

### 4. `POST /orders/{id}/groups/{group_id}/cancel` returns seller fields

It returns `OrderShopGroupDetailRead`, which includes `commission_total` and
`payout_amount` — the docs say those are "never shown to buyers". Please return the
buyer-facing `OrderShopGroupRead` (with the `shop` from item 1) instead. The
storefront doesn't read these fields, but they shouldn't reach a buyer's browser.

## Why

Order pages should look like the cart the buyer just checked out from: shop names,
pictures and links. Today every line is plain text and every group is anonymous.
Pagination keeps "My orders" fast for repeat buyers.

## References

- openapi/api.yaml → `OrderRead`, `OrderShopGroupRead`, `OrderLineRead`,
  `OrderShopGroupDetailRead`, `/api/v1/orders`, `/api/v1/orders/{order_id}/groups/{group_id}/cancel`
- docs/orders-and-payments-api.md §3.1, §4 (`OrderShopGroupRead`, `OrderLineRead`: "never shown to buyers")
- docs/api-standards.md → "Lists and pagination"
- Same summary shape as `CartItemRead.shop` / `CartProductRead` (task `storefront-cart-product-info`)

## Resolution

Done in the backend (not committed yet); contract exported and SDKs regenerated.

1. **Shop on each group.** `OrderShopGroupRead.shop` (`ShopSummaryRead`: `id`, `slug`, `name`, `logo_url`), the shop's current values. `shop_id` is kept.
2. **Product info on each line.** `OrderLineRead` gained `image_url`, `variant_attributes` and `product_slug`.
   - `image_url` is the variant's first image, else the product's primary image.
   - `product_slug` is `null` unless the product is `approved` and its shop `active`.
   - **Differs from the ask:** `variant_attributes` are the variant's *current* attributes, not a purchase-time snapshot (lines store no snapshot). They are `null` for non-variant products or if the variant is gone.
3. **Pagination.** `GET /orders` takes `skip` (default `0`), `limit` (default `50`, max `100`) and a repeatable `status`, newest first, with `X-Total-Count`.
4. **Cancel response.** `POST /orders/{id}/groups/{group_id}/cancel` returns the buyer-facing `OrderShopGroupRead`, with `shop` and `lines`. The buyer no longer receives `commission_total` or `payout_amount`.

Side effects on seller and staff shapes: the seller/admin detail schemas (`OrderShopGroupDetailRead`, `OrderLineDetailRead`) no longer extend the buyer ones, so they have no `shop` or product fields. The warehouse endpoints use new `OrderLineBase` / `OrderShopGroupBase` schemas. `POST /warehouse/order-groups/{id}/receive` now returns the group without a `lines` array; it was always empty there.

Docs: `docs/orders-and-payments-api.md`, `docs/logistics-and-pickup-points-api.md`.
