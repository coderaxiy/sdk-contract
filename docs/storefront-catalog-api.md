# Storefront Catalog API — Frontend Integration Guide

The public, buyer-facing read side: catalog listing and search, the product page,
the category tree, brands and shop profiles. All paths are relative to `/api/v1`.
Schemas: `openapi/api.yaml` → `ProductCardRead`, `ProductPublicRead`,
`CatalogFacetsRead`, `CategoryNodeRead`, `CategoryAttributePublicRead`,
`BrandPublicRead`, `ShopPublicRead`, `ShopSummaryRead`. The cart is in
[orders-and-payments-api.md](orders-and-payments-api.md) §3.1 and §4.

## Auth

None. Every endpoint here works without `access_token`, and ignores it if sent.

## Error shape

Standard (`api-standards.md`): `{"detail": "..."}` for `400`/`404`, FastAPI's
array for `422`. `400` messages can be shown as-is.

---

## 1. What a buyer can see

A product is **visible** when all three hold:

1. `status = approved`,
2. its shop is `active`,
3. it can be ordered at some price: a non-variant product always can, and a
   variant product needs at least one active variant.

Anything else is `404 "Product not found"` on the product endpoints and is left
out of every list. Out-of-stock products **stay visible** (`in_stock: false`),
unless you filter them out with `in_stock=true`.

### Price and stock summary

Cards and the product page carry the same three fields, computed in one place
on the server, so they never disagree:

| Field | Non-variant product | Variant product |
|---|---|---|
| `price_min` | `base_price` | lowest price among **active** variants |
| `price_max` | `base_price` | highest price among active variants |
| `in_stock` | `stock_quantity > 0` | any active variant has stock > 0 |

Money is a decimal string (`"120000.00"`). Exact stock levels are never exposed.
A quantity above stock is rejected by `POST /cart/items` / `PATCH /cart/items/{id}`
(`400 "Not enough stock for the requested quantity"`).

---

## 2. Catalog and search — `GET /products`

Returns `ProductCardRead[]`, a plain array. The **total number of matches** is in
the `X-Total-Count` response header, which is exposed to credentialed CORS
requests. Use it for "1 284 results", or keep inferring "more pages" from
`length === limit`.

| Param | Type | Behavior |
|---|---|---|
| `q` | string | Case-insensitive substring match on the title **or** the brand name. See "Search spelling" below |
| `category_id` | int | The category **and all its visible descendants**. `404 "Category not found"` if the category isn't in the public tree |
| `brand_id` | int, repeatable | OR: `brand_id=3&brand_id=7` |
| `shop_id` | int | One shop's products (the shop page grid) |
| `price_min` / `price_max` | decimal | Compared against the card's `price_min` |
| `in_stock` | bool | `true` hides out-of-stock products. Omitted/`false`: all |
| `attr` | `key:value`, repeatable | Needs `category_id`. OR within one key, AND across keys: `attr=color:red&attr=color:blue&attr=size:L`. Values match exactly (case-sensitive) against product attribute values (a `multi_select` value matches if it contains the value) **or** any active variant's attributes |
| `sort` | `relevance` \| `newest` \| `price_asc` \| `price_desc` | Default: `relevance` when `q` is set, else `newest` |
| `skip` / `limit` | int | `limit` default `50`, max `100` (`422` above) |

`attr` errors (`400`):

- `"attr filters need a category_id"`
- `"Invalid attr filter 'color' — expected key:value"`
- `"'weight' is not a filterable attribute of this category"`: the key isn't
  an effective attribute of `category_id` with `is_filterable = true`. Keys come
  from `GET /categories/{category_id}/attributes`.

Sorting is stable: every order ends with `id`, so pages never overlap or skip
items. `relevance` ranks titles that **start with** the query first, then titles
that contain it, then brand-only matches, with newest first within each rank.
`sort=relevance` without `q` behaves like `newest`. There's no "popular" or
"rating" sort.

### Search spelling

Uzbek is written in both scripts, so `q` also matches its transliterations:

- Latin ↔ Cyrillic: `shisha` also finds `шиша`, `хонор` also finds `honor`
  (х is tried as both `x` and `h`).
- Apostrophes: `ʻ ʼ ‘ ’ \` ´` are treated as `'` on both sides, so `gʻilof`,
  `g'ilof` and `g’ilof` are the same query.
- `%` and `_` are literal characters, not wildcards.

This is transliteration, not fuzzy matching: typos and Russian-style spellings of
Uzbek sounds (`гилоф` for `gʻilof`) don't match.

### `ProductCardRead`

```ts
{
  id: number
  slug: string
  title: string
  price_min: string
  price_max: string
  in_stock: boolean
  has_variants: boolean
  image_url: string | null      // primary image, else the lowest sort_order
  shop: { id: number; slug: string; name: string; logo_url: string | null }
  brand: { id: number; name: string; logo_url: string | null; is_verified: boolean } | null
  category_id: number
  created_at: string
}
```

### Facets — `GET /products/facets`

Takes the same filter params as `GET /products` (no `sort`/`skip`/`limit`) and
returns what the filter sidebar needs:

```ts
{
  brands: { id: number; name: string; count: number }[]  // by count desc, then name
  price: { min: string | null; max: string | null }       // null when nothing matches
}
```

- `brands` ignores the `brand_id` filter itself, so ticking a brand doesn't hide
  the others.
- `price` is the range of `price_min` (what the price filter compares) and
  ignores `price_min`/`price_max`.

---

## 3. Product page

| Method | Path | Returns |
|---|---|---|
| GET | `/products/{product_id}` | `ProductPublicRead` |
| GET | `/shops/by-slug/{shop_slug}/products/{product_slug}` | `ProductPublicRead` |
| GET | `/shops/{shop_id}/products` | `ProductPublicRead[]`, newest first. For the shop page grid prefer `GET /products?shop_id=` (cards, filters, pagination) |

All three: `404 "Product not found"` unless the product is visible (§1). For an
unknown or inactive shop, the list returns `[]`.

### Readable URLs and renamed slugs

Product slugs are unique **per shop**, so a storefront URL is
`/shops/{shop-slug}/{product-slug}`, resolved with the by-slug endpoint.
When a seller renames a product, its **previous slugs keep resolving** to it.
The response always carries the current `slug` and `shop.slug`. If they differ
from the URL, issue a `301` to the canonical URL. Shop slugs never change.

If another product in the shop later takes an old slug, the slug belongs to that
product from then on.

### `ProductPublicRead`

```ts
{
  id: number
  slug: string
  title: string
  description: string | null
  platform_sku: string | null     // null on variant products ("Article" in the UI)
  has_variants: boolean
  price_min: string               // see §1
  price_max: string
  in_stock: boolean

  shop: { id: number; slug: string; name: string; logo_url: string | null }
  brand: { id: number; name: string; logo_url: string | null; is_verified: boolean } | null
  category: {
    id: number
    slug: string
    translations: { locale: string; name: string; description: string | null }[]
    ancestors: { id: number; slug: string; translations: TranslationRead[] }[]  // root → parent
  }

  images: { id: number; url: string; sort_order: number; is_primary: boolean }[]  // by sort_order

  variants: {                     // ACTIVE variants only; [] when has_variants = false
    id: number
    platform_sku: string
    price: string
    in_stock: boolean
    attributes: Record<string, string | number | boolean>
    image_ids: number[] | null    // ids from images[]
  }[]

  // The spec table, resolved: no extra call needed.
  attributes: {
    key: string
    label_translations: { locale: string; label: string }[]
    data_type: 'text' | 'number' | 'boolean' | 'select' | 'multi_select'
    unit: string | null
    value: string | number | boolean | string[]
    is_variant_defining: boolean
    sort_order: number
  }[]                             // by sort_order, then key

  created_at: string
}
```

Not included, on purpose: moderation state, `seller_sku`, exact stock, deleted
variants, the admin who approved it. Product `title`/`description` are
single-language. Category and attribute labels carry all translations: pick
`uz` / `ru` / `en` on the client.

---

## 4. Categories

### `GET /categories` — the public tree

Returns `CategoryNodeRead[]`: the roots, with children nested, each level ordered
by `sort_order` then `id`. It contains only active categories, and a deactivated
category hides its whole subtree. The response has
`Cache-Control: public, max-age=300`.

```ts
type CategoryNodeRead = {
  id: number
  parent_id: number | null
  slug: string               // globally unique
  icon_url: string | null
  sort_order: number
  is_leaf: boolean
  translations: { locale: string; name: string; description: string | null }[]
  product_count: number      // visible products, descendants included
  children: CategoryNodeRead[]
}
```

- **Slugs are globally unique**, so `/catalog/{category-slug}` can be resolved
  from the cached tree. Admins can change a category slug; old category links
  then 404.
- Every category is created with at least one translation. Fall back to `slug`
  if the buyer's locale is missing.
- Use `product_count` to hide empty branches in the menu.

### `GET /categories/{category_id}/attributes`

Returns `CategoryAttributePublicRead[]`: the category's **effective** attributes
(inherited ones included, local definitions winning), ordered by `sort_order`,
then `key`. `404 "Category not found"` unless the category is in the public
tree. Cached like the tree.

```ts
{
  id: number
  key: string
  data_type: 'text' | 'number' | 'boolean' | 'select' | 'multi_select'
  options: string[] | null    // raw values, not localized
  unit: string | null
  is_filterable: boolean      // only these can be used in attr=
  is_variant_defining: boolean
  sort_order: number
  translations: { locale: string; label: string }[]
}[]
```

Option values aren't localized and no per-option labels are planned yet, so show
the raw value in filter chips.

---

## 5. Brands — `GET /brands`

Returns `BrandPublicRead[]`: **approved** brands ordered by name.

| Param | Behavior |
|---|---|
| `category_id` | Only brands with at least one visible product in the category or its descendants. `404` if the category isn't public |
| `q` | Case-insensitive match on the name, with the same spelling rules as catalog search |

```ts
{ id: number; name: string; logo_url: string | null; is_verified: boolean }[]
```

For the brands actually present in the current search results (with counts),
use `GET /products/facets`.

---

## 6. Shop profile — `GET /shops/by-slug/{slug}`

Returns `ShopPublicRead`. `404 "Shop not found"` unless the shop is `active`.

```ts
{
  id: number
  slug: string
  name: string
  description: string | null
  logo_url: string | null
  banner_url: string | null
  rating_avg: string | null   // decimal string; null = no ratings yet
  rating_count: number
  created_at: string
}
```

Shop slugs can't change after creation, so no redirect handling is needed.
