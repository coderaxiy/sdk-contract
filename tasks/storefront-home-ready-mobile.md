---
id: storefront-home-ready-mobile
title: Integrate published home merchandising and campaign contract on Flutter
author: backend
to: mobile
status: open
priority: high
area: storefront
created: 2026-11-04
closed:
reply_to: storefront-home-merchandising
---

## What

Read [docs/storefront-home-api.md](../docs/storefront-home-api.md) and the exported
spec. Backend APIs are implemented; use exact generated schemas rather than the
original proposed fields.

- Public `GET /api/v1/storefront/home` → `StorefrontHomeRead` with `valid_until`,
  banners, selected category shortcuts, discount sections and nullable curated
  recommendation section. Preserve array order; absent/empty promotions collapse.
- Public `GET /api/v1/storefront/campaigns/{slug}` → `CampaignRead` with title,
  intro, hero, categories and typed `products`/`text`/`image`/`categories` blocks.
- Public `GET /api/v1/storefront/campaigns/{slug}/sections/{section_id}/products`
  with skip/limit (default 20, maximum 100) → `ProductCardRead[]` plus X-Total-Count.
- Typed internal campaign and section destinations supply slug/section ID.
  Campaign URL on web: `/campaigns/{slug}`; section view-all:
  `/campaigns/{slug}/sections/{section_id}`. Keep existing locale/product routes.
- Send Accept-Language uz/ru; copy/artwork falls back Russian→Uzbek. Responsive
  artwork supplies mobile/desktop URL+width+height. Keep readable text/link if a
  URL fails. Unknown future block types must be skipped at the decoding boundary.
- ProductCardRead/ProductPublicRead add nullable original_price_min/max,
  discount_percent and discount_ends_at. Public variants add original_price and
  discount metadata; cart adds original_unit_price and discount metadata. Money
  stays decimal strings. Display a crossed-out price only when the server provides
  it; never infer reduction from unrelated variants or arbitrary list ordering.
- Campaigns curate real seller prices. Original values are captured from actual
  reductions of approved products; no marketing price override. Mixed variant
  ratios suppress card-level discounts; individual variants retain their savings.
  Promo rails exclude any product with a sold-out active variant. See guide for
  precise eligibility; regular catalog semantics stay unchanged.
- Campaign expiration/unpublish never restores the seller's price. Checkout still
  validates current price and cart snapshots. discount_ends_at is currently null.
- Responses are no-store/Vary Accept-Language. Refetch by valid_until (≤60 seconds,
  earlier at schedule boundaries) and on entry/return. A stale campaign link is
  404; a failed request is retryable, not an expired state. Reinitialize pagination
  after refresh; offset pages aren't snapshots during edits/stock changes.
- Bounded previews: 8 cards, first 10 home banner candidates, first 12 home rail
  candidates. Empty rails omitted. Use explicit editorial recommendation title only
  when recommendation_section exists; ordinary fallback is sort=newest.

## Acceptance

Keep Phase A behavior as the independent catalog fallback, then implement Phase B
from storefront-home-web-parity. Use zero/one/many banners, guest reads, unavailable
campaigns, localizations, bounded/paginated rails, selected-variant commerce, stock
filtering and real/null discount cases. Preserve navigation and scroll restoration.
Fixture: tests/api/test_storefront.py (sale campaign with 4 products, 80/100 simple
prices and variant 80/100 + 160/200); no fake content is seeded in application DB.
Coordinate actual fixture IDs/screenshots with web through a reply task. Regenerated
Kotlin/Swift SDKs are available; Flutter models must mirror the exported schemas.
Close this task after client implementation/tests; backend task closure is not
mobile UI completion.

