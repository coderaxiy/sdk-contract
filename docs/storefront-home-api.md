# Storefront home and campaign integration

For Flutter buyers and the customer website. API paths below are relative to
`/api/v1`. All three reads are public and do not require cookies. Admin editing
is documented in [storefront-merchandising-admin-api.md](storefront-merchandising-admin-api.md).
The exported OpenAPI and generated SDKs are authoritative.

## Endpoints and destinations

| GET | Returns |
|---|---|
| `/storefront/home` | `StorefrontHomeRead`: `valid_until`, campaign `banners`, `shop_banners`, `categories`, `discount_sections`, nullable `recommendation_section` |
| `/storefront/campaigns/{slug}` | `CampaignRead`: `valid_until`, id, slug, localized title/intro, optional hero, categories, ordered typed blocks |
| `/storefront/campaigns/{slug}/sections/{section_id}/products?skip=0&limit=20` | Plain `ProductCardRead[]`, `X-Total-Count`; skip ≥ 0, limit 1–100 |

Banners have `destination: {type: "campaign", campaign_slug}`; product sections
have `destination: {type: "campaign_section", campaign_slug, section_id}`. These
are internal destinations, never arbitrary URLs. Web routes should be
`/campaigns/{slug}` and `/campaigns/{slug}/sections/{section_id}` with the existing
locale mechanism preserved. Category shortcuts retain category slug links; product
cards retain the existing shop/product slug destination. The server never asks
clients to filter draft or scheduled content.

Standalone shop banners are in `shop_banners: HomepageShopBannerRead[]`. Each
item includes `id`, `sort_order`, `title` (the current shop name), responsive
`artwork`, and `destination: {type: "shop", shop_id, shop_slug}`. On buyer web,
link to the existing `/shops/{shop_slug}` route and preserve locale handling.
Use the slug from each fresh response. The backend resolves it from the shop ID
and hides the banner once the shop is non-public. Only published banners with
an active shop and a current display window appear. Start is inclusive and end
is exclusive. `valid_until` includes the next visible-shop banner schedule
boundary when it falls before the usual refresh deadline.

Shop banner artwork follows the same Russian-to-Uzbek and desktop-to-mobile
fallback rules described below. `shop_banners` is ordered by `(sort_order, id)`.
To combine both arrays in one web carousel, sort by `sort_order`, then shop
before campaign for cross-type ties, then `id`. Key slides by destination type
and ID. Campaign banners retain their existing payload and ordering in `banners`.

`404` means unknown/draft/unpublished/not-yet-started/expired campaign, or a section
not belonging to that campaign (or not a products block). Show campaign unavailable
with home/catalog actions. Network/server failures get retry, not an expired state.
An active campaign with no visible products returns `200` with its title, intro,
artwork, and any remaining informational blocks; don't invent a product rail.

## Locale, ordering, visibility and limits

Send `Accept-Language: uz` or `ru`. Missing Russian copy/artwork falls back to
Uzbek independently; no English marketing fallback. Text is plain text; escape it
and do not render HTML. Category translations retain the established category
schema; clients select Russian then Uzbek. Unsupported/missing locale uses Uzbek.

Preserve server array order. Banner and campaign block order is `(sort_order,id)`;
home collection order is `(home_sort_order,id)`. Product membership follows the
editor's ID array, deduplicated by first occurrence before pagination. Sections
retain stable integer IDs while edited; do not derive them from indexes/titles.
Skip unknown future block types. There are four current block types:

- `products`: id, sort_order, title, typed destination, `products` preview, `total`.
- `text`: id, sort_order, title, `text` (plain string).
- `image`: id, sort_order, title, responsive `artwork`.
- `categories`: id, sort_order, title, `categories: CategoryNodeRead[]`.

Previews contain at most **8 products**. View-all always uses the section endpoint,
including home discount rails; every rail belongs to a campaign. `total` and
`X-Total-Count` count currently eligible products before pagination. Catalog cards
are reused unchanged, including slug/shop/category/brand/image and stock fields.
Promotional products must be approved, belong to an active shop, and have stock;
variant products are excluded if **any active variant is sold out**, keeping the
entire displayed range purchasable. Ordinary catalog stock/range semantics remain
as documented in [storefront-catalog-api.md](storefront-catalog-api.md).

Discount sections additionally require a genuine product-level discount (see
below). Empty product/category blocks are omitted after filtering. Published
campaign headers/artwork remain navigable even with no product sections. Unknown,
inactive or orphaned category paths are removed. Home categories use the admin
selection; an unset selection falls back to nonempty catalog roots, `(sort_order,id)`,
up to ten. An explicitly empty selection means no home shortcuts.

Bounded home: first **10** active banner candidates and first **12** home-promoted
section candidates in server order, with invalid/empty candidates omitted. The
first eligible recommendation among those candidates is returned. Candidates
outside these limits are not a home pagination feed. Editors should keep their
promoted candidate count within these limits. Campaigns permit 24 blocks, ten
banners, ten shortcuts, 200 memberships/section and 500 memberships/campaign;
there are at most 100 stored campaigns. The main discovery grid still paginates
`GET /products?sort=newest`; only use a recommendations heading when the explicit
curated `recommendation_section` is present, and never call it personalized.

## Artwork and client fallbacks

`artwork: {mobile: {url,width,height}, desktop: {url,width,height}}` uses actual
stored image dimensions. Reserve `width / height` aspect ratio before loading.
A missing desktop crop uses mobile artwork; a missing Russian pair uses Uzbek.
No server upscaling or guessed dimensions. A missing artwork record omits its
image block/banner, while an unreachable URL must retain a readable title/link
client-side. Categories use existing icon placeholders. No fabricated ratings,
shipping promises, installments, card benefits or authenticity claims.

## Price comparison: curation only

Campaigns do **not** assign prices, discounts, expiry prices, subsidies or checkout
rules. Sellers already set the authoritative `base_price` / variant `price` through
the existing endpoints. When a seller lowers a previously approved product's live
price, the backend records its real prior price as a comparison baseline. Further
reductions preserve that baseline; **any increase or a price change on an
unapproved product clears it**. Creating a product/variant cannot supply a fake
comparison value; the existing forbid-extra write schemas reject it. Existing
products migrate with null baselines, so no historical savings are invented.

Additive fields on `ProductCardRead` and `ProductPublicRead`:

```ts
original_price_min: string | null
original_price_max: string | null
discount_percent: number | null
discount_ends_at: string | null
```

Public variants add `original_price`, `discount_percent`, `discount_ends_at`;
cart items add `original_unit_price`, `discount_percent`, `discount_ends_at`.
Money stays decimal strings. Original price must exceed the same offer's current
price. Percent is `floor((original-current)*100/original)`; reductions below 1%
get a null percentage and are excluded from discount rails.

For variant-level savings, compute/return each variant's own reduction. A product
comparison range and percentage are exposed **only when every active variant has
a valid reduction and every exact current/original ratio is identical**. Thus
80/100 + 160/200 gives current 80–160, original 100–200 and 20%; 80/100 + 150/200
suppresses all product-level comparison fields, while the variants retain 20%
and 25%. An undiscounted active variant also suppresses the product summary.
Never infer a percentage by comparing unrelated cheapest variants. Discounts with
no product summary don't qualify for home discount rails, but normal/recommendation
collections can still include those products with variant pricing on detail.

`discount_ends_at` is currently always **null**: there is no scheduled sale-price
engine. Campaign end/unpublish changes merchandising visibility only; the seller's
current price continues in catalog, detail, cart and checkout. Checkout still
rechecks current price/stock under locks and returns the existing `price_changed`
response when a cart snapshot differs. Do not change totals from original prices,
percentages, banners, or a client countdown. Historical order prices stay frozen.

## Cache and refresh

Reads use `Cache-Control: no-store`, `Vary: Accept-Language`; public storefront
error responses also prohibit caching. Do not persist promo responses in CDN,
service-worker or offline caches. `valid_until` is the earlier of 60 seconds from
server time and the next relevant schedule boundary (home includes upcoming
published campaigns and eligible shop destinations; campaign detail includes
its own boundary). Re-fetch by that
UTC deadline and on returning to the page. If refresh fails, remove expired
promotional content rather than continue promising savings; categories and the
ordinary catalog can have independent retry states. Section view-all should
re-fetch on entry and no later than its parent campaign's deadline. There is no
snapshot cursor: concurrent editor/stock changes can shift offset pagination;
restart at skip=0 after refresh or a changed total.

Schedule start is inclusive, end exclusive, based on UTC server time. Unpublish,
delete, expiration and stock/moderation changes take effect on the next read;
stale deep links return 404. No invalidation/push subscription is required.

## Payload examples

No active promotions (categories may still contain catalog roots):

```json
{"valid_until":"2026-11-04T10:01:00Z","banners":[],"shop_banners":[],"categories":[],"discount_sections":[],"recommendation_section":null}
```

Populated home with missing Russian copy (requesting Russian returns Uzbek):

```json
{
  "valid_until":"2026-11-04T10:01:00Z",
  "banners":[{"id":1,"sort_order":0,"title":"Chegirmalar",
    "artwork":{"mobile":{"url":"https://assets.example/crop.webp","width":600,"height":300},"desktop":{"url":"https://assets.example/wide.webp","width":1200,"height":300}},
    "destination":{"type":"campaign","campaign_slug":"autumn"}}],
  "shop_banners":[],
  "categories":[],
  "discount_sections":[{"type":"products","id":3,"sort_order":0,"title":"Takliflar",
    "destination":{"type":"campaign_section","campaign_slug":"autumn","section_id":3},"total":1,
    "products":[{"id":7,"slug":"phone","title":"Telefon","price_min":"80.00","price_max":"80.00","in_stock":true,"has_variants":false,"image_url":null,"shop":{"id":2,"slug":"shop","name":"Shop","logo_url":null},"brand":null,"category_id":1,"created_at":"2026-11-01T10:00:00Z","original_price_min":"100.00","original_price_max":"100.00","discount_percent":20,"discount_ends_at":null}]}],
  "recommendation_section":null
}
```

A multi-block campaign can start with text and categories before products:

```json
{
  "valid_until": "2026-11-04T10:01:00Z",
  "id": 1,
  "slug": "autumn",
  "title": "Kuzgi takliflar",
  "intro": "Yangi takliflar",
  "hero": null,
  "categories": [],
  "blocks": [
    {
      "type": "text",
      "id": 2,
      "sort_order": 0,
      "title": "Batafsil",
      "text": "Takliflarni ko'ring"
    },
    {
      "type": "products",
      "id": 3,
      "sort_order": 1,
      "title": "Takliflar",
      "destination": {
        "type": "campaign_section",
        "campaign_slug": "autumn",
        "section_id": 3
      },
      "products": [
        {
          "id": 7,
          "slug": "phone",
          "title": "Telefon",
          "price_min": "80.00",
          "price_max": "80.00",
          "in_stock": true,
          "has_variants": false,
          "image_url": null,
          "shop": {
            "id": 2,
            "slug": "shop",
            "name": "Shop",
            "logo_url": null
          },
          "brand": null,
          "category_id": 1,
          "created_at": "2026-11-01T10:00:00Z",
          "original_price_min": "100.00",
          "original_price_max": "100.00",
          "discount_percent": 20,
          "discount_ends_at": null
        }
      ],
      "total": 1
    }
  ]
}
```

A products block with total > 0 always has a nonempty bounded preview. An expired campaign
returns `404 {"detail":"Campaign not found"}`. Prices, IDs and asset URLs above
are illustrative, not seeded promotions. Use the integration tests' fixture for
shared screenshot/local verification.
