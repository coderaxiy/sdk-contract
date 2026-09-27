---
id: storefront-catalog-search
title: Public catalog listing and search with filters, sorting and pagination
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

There's no public way to list products except per shop
(`GET /shops/{shop_id}/products`: no filters, no sort, no pagination). The
storefront's catalog page, category pages, search results page and the header
search all need one listing endpoint.

**Ask:** `GET /products` (public, no auth), returning a plain array of product
cards per `api-standards.md`.

### Query params

| Param | Type | Behavior |
|---|---|---|
| `q` | string, optional | Full-text / case-insensitive match on title (and brand name if cheap). Ideally tolerant of Latin/Cyrillic Uzbek spelling — tell us what you support |
| `category_id` | int, optional | The category **and all its descendants** (buyers browse by parent categories like "Electronics") |
| `brand_id` | int, repeatable | OR across values: `brand_id=3&brand_id=7` |
| `shop_id` | int, optional | Replaces `GET /shops/{shop_id}/products` for the shop page |
| `price_min` / `price_max` | decimal string, optional | Compared against the card's `price_min` (cheapest active offer) |
| `in_stock` | bool, optional | `true` hides out-of-stock products. Default: show all |
| `attr` | string, repeatable, `key:value` | Only for attributes with `is_filterable = true` in the category. OR within the same key, AND across keys: `attr=color:red&attr=color:blue&attr=size:L`. `400` on a non-filterable key |
| `sort` | enum, optional | `relevance` (default when `q` is set), `newest` (default otherwise), `price_asc`, `price_desc` |
| `skip` / `limit` | int | Per api-standards; please cap `limit` (e.g. 100) |

Same visibility rule as today: only `approved` products of `active` shops.

Sorting must be stable (tie-break on `id`), otherwise pages overlap or skip
items as the user loads more. No "popular" / "best rated" sort — we don't have
honest data for those yet and won't fake it.

### Response shape the frontend will build against

```ts
// GET /products?… → ProductCardRead[]
{
  id: number
  slug: string
  title: string
  price_min: string              // Decimal as string; cheapest active offer
  price_max: string              // == price_min for non-variant products
  in_stock: boolean
  has_variants: boolean
  image_url: string | null       // primary image (is_primary, else lowest sort_order)
  shop: { id: number; slug: string; name: string }
  brand: { id: number; name: string } | null
  category_id: number
  created_at: string
}[]
```

`price_min`/`price_max`/`in_stock` must be computed exactly as in
`ProductPublicRead` (`storefront-public-product-read`), so card and product page
never disagree.

### Pagination / total

We'll keep the plain array and infer "there's another page" from
`length === limit`. A total count ("1 284 results") is a **nice-to-have** — if
you add it, please use an `X-Total-Count` response header (plus
`Access-Control-Expose-Headers: X-Total-Count`, since we send credentials) so
the body stays a plain array.

### Nice-to-have (don't block on it)

Facets for the filter sidebar, e.g. `GET /products/facets` with the same filter
params, returning the brands present in the result set (with counts) and the
overall price range. Without it we show all approved brands
(`storefront-public-shop-and-brands`) and a free-form price range.

## Why

Search is the storefront's main entry point (the header search pill and the
`/search` page); the catalog and category pages are the second. Both are
"coming soon" placeholders until this exists.

## References

- openapi/api.yaml → `/api/v1/shops/{shop_id}/products`, `CategoryAttributeRead.is_filterable`
- docs/api-standards.md → "Lists and pagination", "Money"
- docs/products-and-moderation-api.md §4 (visibility rule, "catalog/search doc territory")
- Related: `storefront-public-product-read`, `storefront-category-tree`

## Resolution

`GET /products` (public) → `ProductCardRead[]`, with every param from the table.
Full reference: `docs/storefront-catalog-api.md` §2.

- **Total:** `X-Total-Count` header, exposed via `Access-Control-Expose-Headers`.
- **`limit`:** default 50, max 100 (`422` above).
- **`q`:** case-insensitive substring match on the title or the brand name. We support
  Uzbek Latin ↔ Cyrillic transliteration (х tried as both x and h) and fold every
  apostrophe variant (`ʻ ʼ ‘ ’` etc.) to `'`. It's not fuzzy: typos don't match.
  `%`/`_` are literal.
- **`relevance`:** title prefix match, then title contains, then brand-only; newest first
  within each rank. Every sort ends on `id`, so it's stable.
- **`attr`** needs `category_id`, else `400 "attr filters need a category_id"`. A non-filterable
  or unknown key → `400 "'<key>' is not a filterable attribute of this category"`; malformed →
  `400 "Invalid attr filter '<x>' — expected key:value"`. It matches product attribute values
  (a multi_select matches if it contains the value) or active variants' attributes, by
  exact value.
- **`category_id`** includes all visible descendants; not in the public tree → `404`.
- **Facets (nice-to-have): done.** `GET /products/facets` takes the same filters and returns
  `{ brands: {id,name,count}[], price: {min,max} }`. Brands ignore the `brand_id` filter;
  price is the range of `price_min` and ignores the price filters.
