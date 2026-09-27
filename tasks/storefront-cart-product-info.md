---
id: storefront-cart-product-info
title: Cart items with product, variant, shop and current-price info
author: frontend
to: backend
status: closed
priority: high
area: orders
created: 2026-09-27
closed: 2026-09-27
reply_to:
---

## What

`CartItemRead` is `{ id, product_id, variant_id, quantity, price_snapshot, added_at }`.
To render a cart line (image, title, variant "Size L · Red", shop name, price,
out-of-stock warning) the storefront would have to call `GET /products/{id}` once
per line, and the orders doc says not to use `price_snapshot` as the current
price. A 10-item cart means 11 requests, and the header cart badge/drawer would
do the same on every page.

**Ask:** enrich `GET /cart` (and the `CartItemRead` returned by
`POST /cart/items` / `PATCH /cart/items/{id}`) with what a cart line needs, and
compute totals server-side so the client doesn't do decimal math on money.

### Response shape the frontend will build against

```ts
// GET /cart → CartRead
{
  id: number
  status: 'active' | 'checked_out' | 'abandoned'
  items: CartItemRead[]           // ordered by added_at
  item_count: number              // sum of quantities, for the header badge
  subtotal: string                // Decimal; sum of line_total over AVAILABLE lines only
  created_at: string
  updated_at: string
}

// CartItemRead
{
  id: number
  quantity: number
  added_at: string

  product: {
    id: number
    slug: string
    title: string
    image_url: string | null      // variant's first image if it has image_ids, else product primary image
  }
  variant: {
    id: number
    attributes: Record<string, string | number | boolean>
  } | null
  shop: { id: number; slug: string; name: string }   // the cart is grouped by shop in the UI

  price_snapshot: string          // price when added (unchanged)
  unit_price: string              // CURRENT price, what checkout will charge
  line_total: string              // unit_price × quantity
  available: boolean              // product approved, shop active, variant active
  in_stock: boolean               // current stock >= quantity
}
```

- `buyer_id` can be dropped from `CartRead` (the buyer is the caller; and see
  `storefront-guest-cart`, where there's no buyer).
- Lines that become unavailable (product delisted, shop suspended, variant
  deleted) must **stay in the cart** with `available: false`, not disappear, so
  we can show "No longer available — remove" instead of silently losing them.
  Today checkout rejects them with `400 "Product N is no longer available"`;
  with this flag we can block the checkout button before that happens.
- `unit_price` ≠ `price_snapshot` lets us show "price changed" in the cart
  instead of only at checkout (the checkout `price_changed` 400 stays as the
  final guard).
- Variant attribute *labels* come from `GET /categories/{id}/attributes`
  (`storefront-category-tree`); raw keys are fine here.

### Errors on add/update

Please document the `400` detail strings for `POST /cart/items` and
`PATCH /cart/items/{id}` (quantity above stock, product/variant not available,
`variant_id` missing on a variant product, `variant_id` sent on a non-variant
product) in docs/orders-and-payments-api.md, since the quantity stepper and "Add
to cart" button show them as toasts.

## Why

The storefront's cart page, header cart badge and cart drawer are the next
pieces after the catalog. They're a multi-shop cart grouped by shop, and they
need to be honest about price changes and availability before the buyer
reaches checkout.

## References

- openapi/api.yaml → `CartRead`, `CartItemRead`, `/api/v1/cart`, `/api/v1/cart/items`,
  `/api/v1/cart/items/{cart_item_id}`
- docs/orders-and-payments-api.md §2 (checkout, `price_changed`), §4 (`CartRead`)
- docs/shops-api.md visibility table ("checkout refuses items already in carts")
- Related: `storefront-guest-cart`, `storefront-public-product-read`

## Resolution

`CartRead` / `CartItemRead` now have exactly the requested shape. `buyer_id` is dropped, and so
are the top-level `product_id`/`variant_id` (use `product.id` / `variant?.id`).
`POST /cart/items` and `PATCH /cart/items/{id}` return the enriched `CartItemRead`.

- `item_count` covers all lines; `subtotal` covers available lines only. Items are ordered by `added_at`.
- Unavailable lines stay in the cart with `available: false`. `in_stock` = available and
  stock ≥ quantity.
- `shop` is `ShopSummaryRead` (`{ id, slug, name, logo_url }`).
- **New:** `PATCH /cart/items/{id}` also moves `price_snapshot` to the current price. That's how
  a buyer accepts a changed price (PATCH with the same quantity), since nothing else could
  clear checkout's `price_changed` before. Adding (POST) already did this.
- Add/update now check stock (`400 "Not enough stock for the requested quantity"`).
  Another cart's item is `404 "Cart item not found"` (was `403 "Not your cart item"`).
  The full error table is in `docs/orders-and-payments-api.md` §3.1 "Add / update errors".
