---
id: shop-slug-availability
title: Reject a taken explicit shop slug (400) and add a slug-availability check
author: frontend
to: backend
status: closed
priority: normal
area: shops
created: 2026-09-26
closed: 2026-09-27
reply_to:
---

## What

`POST /seller/shops` accepts an optional `slug`. When it's already taken, the
backend silently appends `-1`, `-2`… (`create_shop` → the `while await
self.repo.get_by_slug(slug)` loop) and returns `201`. A seller who typed
`my-shop` gets `my-shop-1` with no error. `slug` can't be changed afterwards
(it's not in `ShopUpdateRequest`), so the seller is stuck with an address they
never chose.

Slugs are unique across **all** sellers (`shops.slug` is `unique=True`), but a
seller can only list their own shops, so the client has no way to check
availability beforehand.

Requested:

1. **Explicit slug taken → error.** When the request includes `slug` and the
   slugified value is taken, return `400` (or `409`, pick one and document it)
   with a `detail` like `"Shop address 'my-shop' is already taken"`. Keep the
   auto-suffix only for slugs derived from `name` (no `slug` sent).
2. **Availability check** for live form feedback, e.g.
   `GET /api/v1/seller/shops/slug-availability?slug=my-shop` →
   `{ slug: "my-shop", available: boolean }`, where `slug` is the normalized
   value `_slugify` would store. Seller-only, cheap, fine to call on debounce.
3. **Slug rules in the doc** (`shops-api-doc`): `_slugify` keeps Unicode
   letters (`\w` is Unicode-aware in Python), so `"Café Déjà-vu"` →
   `café-déjà-vu` and Cyrillic names give Cyrillic slugs. Is that intended for
   URLs? If slugs should be ASCII-only, transliterate here, and the seller form
   will mirror whatever you decide. Also: a name with no letters/digits
   (`"!!!"`) slugifies to `""`. What does the backend do then?

## Why

The seller website now has a custom "shop address" field. It shows the exact
slug `_slugify` will produce (mirrored client-side and checked against 11 edge
cases) and blocks slugs the seller's *own* shops use. For clashes with other
sellers' shops it can only detect the silent rename after the fact and tell the
seller. The product requirement is no duplicate or surprise slugs.

## References

- Backend: `app/modules/shops/service.py` → `_slugify`, `create_shop` (slug loop);
  `app/modules/shops/model.py` → `slug` `unique=True`
- `openapi/api.yaml` → `ShopCreateRequest.slug`, `ShopRead.slug`
- Related: `shops-api-doc`

## Resolution

Doc 01 §4.2 decisions:

1. Explicit `slug` taken → **`409`** `"Shop address 'my-shop' is already taken"`.
   Derived slugs still get `-1`, `-2`… silently.
2. `GET /api/v1/seller/shops/slug-availability?slug=` →
   `SlugAvailabilityRead { slug, available }`, `slug` = the normalized value.
3. **Slugs are ASCII-only.** Cyrillic is transliterated (Uzbek official
   mapping, Russian letters included), accents stripped, everything else
   dropped. The exact algorithm and table are in `docs/shops-api.md` §2
   "Shop address" — please update the client-side mirror (your 11 edge cases
   will change for Unicode input). A name with no letters or digits derives
   `shop`; an explicit slug (or availability query) that normalizes to nothing
   is `400 "A shop address must contain at least one letter or digit"`.

Also: the shop-limit error is now `409` (Doc 01 §4.1), not `400`.
Backend: `app/modules/shops/{service,router,schemas}.py`, `app/shared/exceptions.py` (`ConflictError`).
