---
id: vit-001-homepage-shop-banners-web
title: Add Homepage Banners to Admin Vitrina and the buyer website carousel
author: backend
to: frontend
status: open
priority: high
area: storefront
created: 2026-11-24
closed:
reply_to:
---

## Scope

Implement VIT-001 in `emarket-admin` and `emarket`. Let editors publish a
standalone homepage promotion that opens a shop. The editor is independent
of the campaign editor. This task covers the two web clients.

Read the [admin integration guide](../docs/storefront-merchandising-admin-api.md#standalone-homepage-shop-banners),
the [public integration guide](../docs/storefront-home-api.md#endpoints-and-destinations),
and the [exported contract](../openapi/api.yaml). Use generated TypeScript
types in admin and the existing handwritten contract-mirroring convention in
customer web.

## Admin → Vitrina → Homepage banners

Use the cookie session and gate the menu and page with `storefront:manage`.
All paths below use the `/api/v1` prefix.

| Method | Path | Request → response |
| --- | --- | --- |
| GET | `/admin/storefront/home/banners` | `skip`, `limit` → `HomepageShopBannerAdminRead[]` |
| GET | `/admin/storefront/home/banners/shops` | `q`, `skip`, `limit` → `HomepageShopOptionRead[]` |
| POST | `/admin/storefront/home/banners` | `HomepageShopBannerWrite` → 201 `HomepageShopBannerAdminRead` in draft state |
| PUT | `/admin/storefront/home/banners/{banner_id}` | Full `HomepageShopBannerWrite` → `HomepageShopBannerAdminRead`; publication is preserved |
| PATCH | `/admin/storefront/home/banners/{banner_id}/publication` | `HomepageShopBannerPublication` (`{published: true/false}`) → `HomepageShopBannerAdminRead` |
| POST | `/uploads?purpose=campaign_artwork` | Multipart `file` → `UploadRead`; use the returned `key` |

- Show the selected shop, publication and schedule state, artwork, and carousel
  position in the list. Use the list response to populate the edit form.
- Populate the shop picker from the scoped endpoint. Search by name or slug
  with `q`, paginate with a default limit of 50 (maximum 100), and submit
  the selected `id` as `shop_id`. The picker lists active shops. If a saved
  banner's shop is missing from those options, show its returned `shop`
  summary and status, and let the editor select an active replacement.
- Accept ready-made Uzbek artwork and optional separate Russian artwork.
  Store upload keys in `artwork.uz.mobile_key`, optionally
  `artwork.ru.mobile_key`, with optional `desktop_key` per locale. A single
  shared image needs only the Uzbek mobile key. The server falls back from
  Russian to Uzbek and from desktop to mobile. Retain attached keys on edit.
- Edit `starts_at` and `ends_at` in Toshkent time using `Asia/Tashkent`.
  Convert each entered local wall time to UTC ISO 8601 (`Z`) before sending
  and convert UTC responses back for display. Send `null` for an open bound.
  Explain that start is inclusive and end is exclusive. Validate an end
  strictly after start when both are set. Lower nonnegative `sort_order`
  comes first. Save content before publishing and handle 401/403, 400 field
  errors, 404 missing banners, and 422 validation errors.

## Buyer website homepage carousel

Fetch public `GET /api/v1/storefront/home` with `Accept-Language: uz` or `ru`.
Use `StorefrontHomeRead.shop_banners` alongside the existing campaign `banners`.
A `HomepageShopBannerRead` contains `id`, `sort_order`, `title` (current shop
name), responsive `artwork.mobile/desktop` URLs and dimensions, and
`ShopBannerDestination` with `type: "shop"`, `shop_id`, and `shop_slug`.
Link to the existing `/shops/{shop_slug}` route with the current locale handling.
Use the slug from the latest response and the shop name as the link's
accessible label.

Combine slides by `sort_order`, then shop before campaign on cross-type ties,
then `id`. Use destination type plus ID as the UI key. Refresh by
`valid_until` and on returning to the page. Honor the server's visibility
and locale selection. Remove stale slides when a refresh fails after the
deadline. Preserve the existing campaign links and the empty-carousel fallback.

## Acceptance checks

1. With only `storefront:manage`, search for a shop, upload ready-made artwork,
   create a draft without a campaign, and publish it. A user without the
   permission cannot manage banners or access the picker.
2. Draft, unpublished, upcoming, and expired entries stay off the buyer
   carousel. Verify that a schedule entered in Toshkent time round-trips
   through the API as UTC.
3. Verify the shared image in both locales, a separate Russian crop, desktop
   fallback, and stable rendering of tied positions.
4. Rename a shop and refetch home. The slide opens the new shop URL without
   a banner edit. Make the shop non-public and verify the slide disappears.
5. Verify that bad image keys, a missing shop, and an invalid range produce
   editor feedback. Verify existing campaign links alongside new shop slides.
   Record the client build, verification, and commits in the resolution.

## Contract decisions and deviations

The public response adds a separate `shop_banners` array. Campaign banners
remain in `banners` with their existing destination schema, allowing current
Flutter decoding to continue. Buyer web combines the arrays for one carousel.
The backend adds independent storage and preserves existing campaign records.
The shop's current name supplies the slide title. Creation saves a draft, and
the publication endpoint handles both publishing and unpublishing. Deploy
backend migration `7b3e2a1c9d04` before enabling the editor. Flutter UI, paid
placements, seller self-service, and category destinations are outside this task.
