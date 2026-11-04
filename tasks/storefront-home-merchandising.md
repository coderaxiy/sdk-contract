---
id: storefront-home-merchandising
title: Add admin-managed home campaigns and curated discount collections
author: mobile
to: backend
status: closed
priority: high
area: storefront
created: 2026-11-03
closed: 2026-11-04
reply_to:
---

## What

Provide an admin-managed merchandising system shared by the Flutter buyer app and Astro customer storefront. The owner requests the shopping structure of the supplied Uzum references, while retaining emarket's design system and existing navigation.

Current: public `GET /api/v1/categories` supplies category icons/order and `GET /api/v1/products` supplies ordinary catalog cards. `ProductCardRead` has price ranges but no discount/original-price fields. There is no home campaign feed, campaign landing page, or curated discount collection in the local contract. Shop banners are unrelated.

The following paths and fields are **proposals for backend implementation**, not existing client APIs. Backend should finalize and publish the exact schemas before clients integrate them.

## Proposed public reads

- `GET /api/v1/storefront/home`: one ordered merchandising payload; public/guest access. Suggested fields: `banners: BannerRead[]`, `categories: CategoryNodeRead[]`, `discount_sections: MerchandisingSectionRead[]`, and optional `recommendation_section: MerchandisingSectionRead | null`. Empty arrays mean omit the respective UI. Resolve visibility and scheduling server-side; never ask clients to filter drafts.
- `GET /api/v1/storefront/campaigns/{slug}`: published campaign header, localized intro, optional category shortcuts, ordered product sections, and optional informational content. Return 404 for unknown, draft, unpublished, or inactive campaigns; do not expose private admin data.
- `GET /api/v1/storefront/campaigns/{slug}/sections/{section_id}/products?skip=0&limit=20`: paginated products in admin order, with `X-Total-Count`, following existing pagination limits. Support a section view-all destination without loading every product into the home response. Check section membership in the requested campaign.
- A home section view-all/products read is also needed when a discount section has no parent campaign; preferably make every curated collection belong to a campaign and reference its section rather than inventing unrelated filters.

Suggested entities (backend chooses final names):

| Entity | Required information |
| --- | --- |
| BannerRead | integer id, campaign slug, localized title/accessible image description, mobile and desktop image URLs plus image dimensions/aspect ratios, integer sort order |
| CampaignRead | integer id, stable unique slug, localized title/intro, hero artwork, category shortcuts, ordered typed content sections |
| MerchandisingSectionRead | stable id, localized title, campaign/section destination, ordered product preview, total visible product count |
| Localized content | translations for `uz` and `ru`; missing Russian falls back to Uzbek; no raw HTML in descriptions |
| Discount pricing | exact current price/range, nullable valid original price/range, nullable server-computed percentage, optional effective-until UTC timestamp; same representation in list, detail and cart context |

For banners use a typed internal campaign destination. Do not require arbitrary URL execution, HTML rendering, or hardcoded client campaign content. A campaign can include full-width artwork, text, category shortcuts and product rails; type and order these blocks explicitly in the exported schema. Unknown future blocks should be safely skippable.

## Admin capabilities

Provide authenticated, permission-gated CRUD for campaigns, uploaded banner/hero artwork, ordered category shortcuts and product collections; document the exact endpoints and roles. Reuse the upload-key flow and add appropriate media slots if required, rather than accepting arbitrary uploads differently.

Editors need draft/published state, optional start/end UTC dates, reorder controls, stable slug, preview, localized copy/artwork, product membership/order and section ordering. Define schedule boundaries as start inclusive/end exclusive, validate end > start, and use server time. Enforce valid references and prevent publishing a banner to an unpublished campaign. Define unpublishing and cache invalidation so stale links fail safely.

Admins must explicitly select discounted products and ordering; do not equate newest or cheapest products with discounts. Clarify whether this system assigns actual sale prices or only curates existing sale prices. If the former, implement the pricing authority and checkout validation as part of this feature; marketing metadata alone must never alter checkout totals.

## Pricing and visibility invariants

- Reuse canonical public product fields and slug links; exclude archived/unapproved/deleted shops and products, deduplicate within each section. Omit empty sections after filtering. Define out-of-stock behavior consistently; proposed default is exclude from promotional collections.
- Whole-so'm display uses existing money rules. Original price must exceed current price; no invented crossed-out prices or discounts. For variants, define exact range and percentage semantics so the displayed reduction is purchasable. Never compare unrelated cheapest variants.
- Product detail, cart and checkout must use the same authoritative effective price. Cart repricing after campaign expiration follows existing backend rules and must be documented to clients.
- Ratings, delivery promises, installment offers, bank-card benefits and authenticity badges are outside this request unless separately backed by real APIs. They appear in reference screenshots but must not be fabricated.
- Define stable deterministic order (sort order then id), response/cache policy, locale/cache variation, expiration behavior, image fallback rules and limits on banners/sections/preview products. Scheduling must not leak stale promotions through caches.

## Acceptance and handoff

Publish example payloads for a populated home, no active promotions, missing Russian translation, multi-section campaign, expired campaign and variant discounts. Cover admin authorization, invalid references, visibility/schedules, ordering, pagination and checkout price consistency with backend tests.

Export OpenAPI from backend code, validate and regenerate SDKs, update module docs, then send integration tasks to both mobile and frontend naming the exact paths/schemas and any existing product schema changes. Until then clients must use only existing catalog APIs and omit unavailable promotions.

## References

- `openapi/api.yaml`: `/api/v1/categories`, `/api/v1/products`, `CategoryNodeRead`, `ProductCardRead`, `ProductPublicRead`.
- `docs/storefront-catalog-api.md`, `docs/api-standards.md`, existing media-upload contract.
- Companion UX/implementation brief: `tasks/storefront-home-web-parity.md`.


## Resolution

Backend implementation completed in the working tree on 2026-11-04 (not committed).
The companion storefront-home-web-parity task belongs to frontend and stays open.

- Implemented guest GET `/api/v1/storefront/home`,
  `/storefront/campaigns/{slug}`, and
  `/storefront/campaigns/{slug}/sections/{section_id}/products` with skip/limit,
  X-Total-Count, canonical cards, deduplication, editor order, stock/publication
  filtering, bounded previews, and campaign membership checks.
- Added permission-gated admin campaign CRUD + private preview and home category
  configuration under `/admin/storefront`; seeded `storefront:manage` to root/admin.
  Immutable slugs, optimistic revisions, stable block/banner IDs, localized plain
  copy/responsive artwork, typed blocks and audit actions are implemented.
- Added `campaign_artwork` upload purpose through existing upload-key handling,
  with editorial permission instead of seller registration, validated ownership,
  image normalization and authoritative stored dimensions.
- Chose **curation only**: marketing never overrides checkout prices. Actual
  reductions of approved seller prices record prior-price comparison values;
  increases/unapproved price changes clear them. No fabricated/backfilled savings.
  Added nullable original-price/discount fields to public cards, detail, variants
  and cart. Uniform variant ratios are required for a product-level discount;
  individual variant savings remain exact. discount_ends_at is currently null.
  Campaign expiration affects visibility, not current product/cart prices.
- Server schedule uses inclusive start/exclusive end and 404 for inactive links.
  Public responses/errors are no-store; home/detail include valid_until (≤60s or
  the next campaign boundary). Russian copy/artwork falls back to Uzbek.
- Guides: docs/storefront-home-api.md and
  docs/storefront-merchandising-admin-api.md, including populated/empty examples,
  variant semantics, draft/expired behavior, limits and cache policy. Updated
  catalog, media-upload and cart documentation. JSON examples validate against
  the actual Pydantic models.
- Exported OpenAPI, validated it, and regenerated TypeScript/Kotlin/Swift SDKs.
  Existing ambiguous-shop-path and unused-error-schema warnings remain unchanged.
  Ruff and targeted mypy pass. 20 auth regression tests plus 14 storefront tests
  passed on isolated PostgreSQL schemas, covering admin/upload authorization,
  references, scheduling/visibility, IDs/revisions, dedup/order/pagination,
  ownership/duplicate slugs, uniform/mixed variant discounts, checkout totals after
  campaign expiration, and migration round-trip.
- Applied local migration d9f4b7a2c601 (from b6a2d8e4f901), restarted emarket_api,
  and verified anonymous home/catalog 200, unknown campaign 404/no-store, unauthenticated
  admin 401, and seeded editorial permission. No example campaigns or fake sale
  baselines were inserted into application tables. Other environments need this
  migration and an API restart before clients use the feature.
- Open client handoffs: storefront-home-ready-mobile, storefront-home-ready-web,
  and admin-storefront-merchandising-editor. Client UI implementation remains
  assigned to those agents; the backend task closes API delivery only.
