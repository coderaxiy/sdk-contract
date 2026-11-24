# Admin website: campaigns, banners and curated collections

All paths have `/api/v1` prefix. Needs cookie login and **`storefront:manage`**.
Root/admin receive this permission on backend startup; other editorial staff need
an explicit role grant. Seller and buyer roles don't receive it automatically.
The [public integration guide](storefront-home-api.md) defines storefront behavior.

## Editor endpoints

| Method | Path | Result |
|---|---|---|
| GET | `/admin/storefront/campaigns?skip=0&limit=50` | `CampaignAdminRead[]`, id order; limit 1–100 |
| POST | `/admin/storefront/campaigns` | `201 CampaignAdminRead` |
| GET | `/admin/storefront/campaigns/{id}` | Full saved editing document |
| PUT | `/admin/storefront/campaigns/{id}` | Full replacement with optimistic revision check |
| DELETE | `/admin/storefront/campaigns/{id}` | 204; removes blocks/banners; public links then 404 |
| GET | `/admin/storefront/campaigns/{id}/preview` | `CampaignRead` using normal visibility/stock rules, bypassing campaign publication/schedule |
| GET / PUT | `/admin/storefront/home` | `HomeWrite`: `{category_ids: number[] | null}` |

Every write records an audit action (`storefront.campaign_saved`,
`storefront.campaign_deleted`, `storefront.home_saved`). Preview/read responses
are no-store. Public home/campaign reads need no permission.

## Standalone homepage shop banners

These endpoints use the same cookie login and `storefront:manage` permission.
Each path is under `/api/v1/admin/storefront/home/banners`.

| Method | Suffix | Input and result |
|---|---|---|
| GET | empty | `HomepageShopBannerAdminRead[]`, ordered by `(sort_order,id)` |
| GET | `/shops` | `HomepageShopOptionRead[]` for active shops, ordered by name and ID. Optional `q` is a case-insensitive name/slug substring (1–100 characters). |
| POST | empty | `HomepageShopBannerWrite` → `201 HomepageShopBannerAdminRead` in draft state |
| PUT | `/{banner_id}` | Full `HomepageShopBannerWrite` → `HomepageShopBannerAdminRead`. Keeps publication state. |
| PATCH | `/{banner_id}/publication` | `HomepageShopBannerPublication` (`{published: boolean}`) → `HomepageShopBannerAdminRead` |

Both lists accept `skip` (default 0) and `limit` (default 50, 1–100).
`HomepageShopOptionRead` contains `id`, `name`, `slug`, and `status`.
The banner response includes the editable data plus `id`, `published`, and
the current `shop` summary, including a shop that has since become non-public.

```json
{
  "shop_id": 42,
  "artwork": {"uz": {"mobile_key": "storefront/artwork/12/shop.webp"}},
  "sort_order": 0,
  "starts_at": "2026-11-24T04:00:00Z",
  "ends_at": null
}
```

Use a stable shop ID from the picker. A draft may reference an existing
non-public shop, but publishing or changing a published banner to a different
shop requires an active destination. A shop that later becomes non-public hides
its banners while preserving their publication setting. Upload artwork using
`campaign_artwork` as described below. A single shared image uses only
`artwork.uz.mobile_key`. Add `ru` for a separate Russian image and add
`desktop_key` per locale only when a separate desktop crop is needed. A saving
editor can retain keys already on this banner. New keys must belong to that
editor. All referenced uploads must exist, have the correct purpose, and have
stored image dimensions.

A lower nonnegative `sort_order` appears first. Dates are optional and accept
ISO 8601 with an offset. The API returns UTC. Present and collect local times
in `Asia/Tashkent` and convert to UTC before sending. Use `null` for no bound.
If both bounds exist, end must be after start. Unknown shop and invalid artwork
return 400. Unknown banner returns 404. Invalid input shape, position, or
schedule returns 422. Saves and publication changes record audit entries.

Campaign banner endpoints and data retain their existing behavior. Deploy
backend migration `7b3e2a1c9d04` before enabling the new editor.

## Upload artwork first

`POST /uploads?purpose=campaign_artwork`, multipart `file`, uses the established
upload-key flow. This purpose checks `storefront:manage` directly; no seller
registration is required. JPEG/PNG/WebP, ≤10 MB input, re-encoded WebP and scaled
within 3000×3000, public storage. Save returned `key`, never an arbitrary URL.
Newly attached keys must belong to the saving user and have the correct purpose.
An editor may retain/reuse artwork already attached to this campaign by another
editor. Reusing someone else's otherwise unattached key fails with 400.

Use Uzbek artwork plus optional Russian artwork, each with required mobile and
optional desktop crop. Public responses supply URLs and true stored dimensions;
desktop falls back to mobile and missing Russian to Uzbek. Alt text is the
localized banner/block/campaign title. Don't embed essential text only in artwork.

## Create an editing document

```json
{
  "slug":"autumn",
  "title":{"uz":"Kuzgi takliflar","ru":"Осенние предложения"},
  "intro":{"uz":"Takliflarni ko'ring"},
  "hero":{"uz":{"mobile_key":"storefront/artwork/1/mobile.webp","desktop_key":"storefront/artwork/1/wide.webp"}},
  "published":false,
  "starts_at":"2026-11-10T00:00:00Z",
  "ends_at":"2026-12-01T00:00:00Z",
  "category_ids":[1],
  "banners":[{"sort_order":0,"title":{"uz":"Kuzgi takliflar"},"artwork":{"uz":{"mobile_key":"storefront/artwork/1/mobile.webp"}}}],
  "blocks":[
    {"type":"text","sort_order":0,"title":{"uz":"Batafsil"},"text":{"uz":"Oddiy matn"}},
    {"type":"products","sort_order":1,"title":{"uz":"Chegirmalar"},"product_ids":[7,8],"home_kind":"discount","home_sort_order":0},
    {"type":"categories","sort_order":2,"title":{"uz":"Kategoriyalar"},"category_ids":[1]},
    {"type":"image","sort_order":3,"title":{"uz":"Takliflar"},"artwork":{"uz":{"mobile_key":"storefront/artwork/1/mobile.webp"}}}
  ]
}
```

IDs/keys above are examples; select existing records and real upload results.
`title`, `intro`, `text` are `{uz: string, ru?: string|null}`; Uzbek is required,
nonblank, ≤4000 chars. Intro/hero are nullable. Raw HTML is rejected. The editor
should offer localized copy and artwork controls, ordered blocks/product pickers,
draft/published toggle, UTC schedule inputs, and private preview.

Banner publication/scheduling is **inherited from its campaign**: a draft,
future or expired campaign never has a public banner linking to it. Draft banners
are editable and visible to editors. Unpublishing the campaign immediately hides
its banners and home sections on the next request; no separate banner status is
needed. Dates must include timezone, end must exceed start when both supplied;
start inclusive/end exclusive. Null bounds mean unbounded.

## Stable IDs and saving edits

Slug is lowercase ASCII kebab-case, ≤100 characters, unique and **immutable**.
Create returns integer campaign/block/banner IDs, `revision` and `updated_at`.
For PUT, construct `CampaignWrite`: remove response-only `id`, `revision`,
`updated_at`, set **`expected_revision`** to the revision just read, and retain each
existing block/banner `id`. Missing expected revision or a stale revision gives
409; reload before applying changes. New children omit id. Foreign child IDs give
400. Omitting an existing child deletes it. Reorder using `sort_order`; ties use
stable id. Membership order is the `product_ids` array; duplicates keep their
first occurrence. Product records must exist; inactive products may be staged but
are filtered from public reads. Category shortcuts must be active when saved.

`home_kind` is `none` (campaign-only), `discount`, or `recommendation` for product
blocks. `home_sort_order` orders home rails independently of campaign order. All
home collections still link back to their campaign/section. Discount rails retain
only products with a valid recorded product-level reduction. Recommendations are
explicit editorial curation, not a personalized engine. Admin metadata never
changes product or checkout prices. See public guide for exact comparison-price
rules, including uniform variant discounts and stock filtering.

Limits: 100 stored campaigns, 24 blocks/campaign, ten banners/campaign, ten
shortcuts per list, 200 product memberships/section and 500/campaign. Home uses
first ten active banner candidates and first twelve promoted-section candidates;
empty/invalid candidates are omitted. Keep home candidates within these bounds.
Each rail previews up to eight products; view-all uses the paginated section read.
The first nonempty recommendation candidate wins.

`PUT /admin/storefront/home` with `{category_ids:null}` resets home shortcuts to
nonempty catalog roots; `{category_ids:[]}` intentionally hides them. Otherwise
use up to ten category IDs in desired order. No client-owned home configuration.

## Errors, caching and rollout

401 missing/expired cookie; 403 missing permission; 400 invalid references,
foreign upload/child IDs, or changed slug; 404 unknown campaign; 409 duplicate slug,
stale revision, or campaign-count limit; 422 malformed schema/schedule/HTML/limits.
Existing errors may return English detail; public marketing text is localized.

No server/CDN promo cache is enabled. Public clients refetch by `valid_until`
(at most 60 seconds, earlier at schedule boundaries); published changes take
effect on the next read. Draft/private preview data must never populate public
client caches. Old links fail safely after unpublish/deletion/expiry.

Deploy migration **`d9f4b7a2c601`** then restart the API to seed permission; upload
purpose enum and new product comparison columns are included. Existing campaigns
are empty and existing product baselines null: create real editorial content,
never seed fake promotions just to fill home. Downgrade drops merchandising data
and comparison columns; PostgreSQL's unused enum value is retained safely.
