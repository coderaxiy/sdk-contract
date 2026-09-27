---
id: storefront-public-product-read
title: Buyer-safe product response for public product endpoints
author: frontend
to: backend
status: closed
priority: high
area: products
created: 2026-09-27
closed: 2026-09-27
reply_to:
---

## What

`GET /products/{product_id}` and `GET /shops/{shop_id}/products` return the full
`ProductRead`, the same schema the seller and admin apps use. The buyer storefront
gets moderation and seller-internal fields that anyone can read without logging in:

| Field in `ProductRead` | Problem on a public endpoint |
|---|---|
| `status`, `rejection_reason`, `needs_attention` | Moderation state; always `approved` / `null` / `false` here anyway |
| `moderated_by`, `moderated_at` | Leaks the internal id of the admin who approved it |
| `seller_sku`, `variants[].seller_sku` | The seller's own inventory code |
| `stock_quantity`, `variants[].stock_quantity` | Exact stock levels of every shop, readable by competitors |
| `variants[]` with `is_active: false` | Deleted variants the buyer can't order |
| `attribute_values[]` as `{ category_attribute_id, value }` | Not renderable without the seller-only `/seller/categories/{id}/attributes` |

It also lacks what a product page needs: the shop's name and slug (for the
"Sold by" link and the product URL), the brand name, and the category path for
breadcrumbs. Today that takes 3–4 extra requests, one of them seller-only.

**Ask:** a `ProductPublicRead` schema returned by every public product endpoint
(`GET /products/{product_id}`, `GET /shops/{shop_id}/products`, and the slug
lookup in `storefront-product-slug-urls`). Visibility rules stay as they are
(`approved` product, `active` shop, else 404). `ProductRead` stays unchanged for
seller/admin.

### Response shape the frontend will build against

```ts
// GET /products/{product_id} → ProductPublicRead
{
  id: number
  slug: string
  title: string
  description: string | null
  platform_sku: string | null          // null on variant products; shown as "Article" in the UI
  has_variants: boolean

  // Display price. Non-variant: both equal base_price. Variant: min/max over ACTIVE variants.
  price_min: string                    // Decimal as string, per api-standards
  price_max: string
  in_stock: boolean                    // non-variant: stock_quantity > 0; variant: any active variant in stock

  shop: { id: number; slug: string; name: string; logo_url: string | null }
  brand: { id: number; name: string; logo_url: string | null } | null
  category: {
    id: number
    slug: string
    translations: TranslationRead[]    // same shape as CategoryRead.translations
    ancestors: { id: number; slug: string; translations: TranslationRead[] }[]  // root → parent, like SellerCategoryRead.ancestors
  }

  images: { id: number; url: string; sort_order: number; is_primary: boolean }[]   // no `key` needed

  variants: {                          // ACTIVE variants only; [] when has_variants = false
    id: number
    platform_sku: string
    price: string
    in_stock: boolean
    attributes: Record<string, string | number | boolean>   // same as ProductVariantRead.attributes
    image_ids: number[] | null
  }[]

  // Resolved so the product page can render the spec table without another call.
  attributes: {
    key: string
    label_translations: AttributeTranslationRead[]   // { locale, label }
    data_type: 'text' | 'number' | 'boolean' | 'select' | 'multi_select'
    unit: string | null
    value: string | number | boolean | string[]
    is_variant_defining: boolean
    sort_order: number
  }[]

  created_at: string                   // ISO, used for "new" sort only, not shown
}
```

Notes:

- **Stock:** `in_stock` booleans instead of exact counts. If you'd rather expose a
  quantity so the cart's quantity stepper can cap itself, a capped number
  (e.g. `max_order_quantity = min(stock, 10)`) would do — tell us which. Until
  then the stepper relies on the `400` from `POST /cart/items` / `PATCH /cart/items/{id}`.
- **`price_min`/`price_max`** are what catalog cards and the product header show
  ("from 120 000 UZS"). The same pair appears on the catalog card in
  `storefront-catalog-search`, so compute it in one place.
- **Localization:** follow the existing convention — return all `translations`
  and the client picks the locale (storefront locales: `uz` default, `ru`, `en`).
  No `Accept-Language` handling needed. Product `title`/`description` stay
  single-language as they are today.

## Why

The customer storefront (Astro, `coderaxiy/emarket`) is building the product
page and catalog cards now. We don't want to ship pages that read moderation
fields from a public response, and we'd rather not make 4 requests per product
page to assemble shop/brand/category/attribute labels.

## References

- openapi/api.yaml → `ProductRead`, `ProductVariantRead`, `ProductAttributeValueRead`,
  `CategoryAttributeRead`, `SellerCategoryRead.ancestors`, `/api/v1/products/{product_id}`,
  `/api/v1/shops/{shop_id}/products`
- docs/products-and-moderation-api.md §4 (buyer endpoints), §5 (`ProductRead`)
- Related: `storefront-catalog-search` (card shape), `storefront-product-slug-urls`,
  `storefront-cart-product-info`

## Resolution

`ProductPublicRead` is live on `GET /products/{product_id}`, `GET /shops/{shop_id}/products`
and `GET /shops/by-slug/{shop_slug}/products/{product_slug}`. `ProductRead` is unchanged
for seller/admin.

- The shape is as requested. One addition: `brand` is `BrandPublicRead` (`{ id, name, logo_url, is_verified }`)
  and `shop` is `ShopSummaryRead` (`{ id, slug, name, logo_url }`). Cards and cart lines use the same two schemas.
- **Stock:** booleans only (`in_stock` on the product and on each variant). No
  `max_order_quantity`. The stepper relies on `400 "Not enough stock for the requested quantity"`.
- `price_min`/`price_max`/`in_stock` are single SQL expressions shared by the card,
  the product page and the facets (`app/modules/products/repository.py`).
- Visibility is unchanged (approved + active shop), plus one rule: a variant product
  whose variants are all deleted has no price, so it's hidden (404) until it has one.
- `images` are ordered by `sort_order`, `variants` are active only (by id), and `attributes`
  are resolved with `label_translations`, ordered by `sort_order` then `key`.
- `return_window_days` isn't exposed yet (orders doc §6 known gaps).

Docs: `docs/storefront-catalog-api.md` §1, §3.
