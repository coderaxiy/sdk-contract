---
id: shops-api-doc
title: Write docs/shops-api.md (shop lifecycle, fields, seller + admin endpoints)
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

Every other module has an integration guide in `docs/`; shops don't. The seller
website's Shops page was built by reading `app/modules/shops/service.py`
directly, which rule 3 in `AGENTS.md` says clients shouldn't have to do. Please
add `docs/shops-api.md` in the same style as the other guides.

Behaviour we found in the code and would like confirmed (or corrected) in the doc:

- **Status machine** (`ShopStatus`): `pending_review → active`, `pending_review →
  rejected`, `active ⇄ suspended`, any non-closed → `closed`. Which transitions
  are seller-driven and which are admin-only.
- **Create** (`POST /seller/shops`): seller must be `active` (403 otherwise);
  `shop_limit` counts non-closed shops and returns **400**. The code comment says
  a client can "treat this BadRequestError as 409". Please pick one and document
  it. Name uniqueness is case-insensitive (400). `slug` is optional and derived
  from `name`, with `-1`, `-2`… appended on collision.
- **Fields settable only at create:** `slug` and `legal_entity_override` aren't in
  `ShopUpdateRequest`. Is that intended? If so, say so. Also explain what
  `legal_entity_override` means for the seller (the model comment says "operates
  under a different legal entity than the parent seller (§4.4)"). Does it
  require a shop-level document or bank account, and what should the create form
  tell the seller?
- **Update** (`PATCH /seller/shops/{id}`): closed shops can't be edited (400).
  Renaming an `active` shop moves it back to `pending_review` with
  `status_reason: "name_changed"`. Nulls are ignored, so a field can't be
  cleared by sending `null` (sending `""` works for `description`). Is that the
  intended way to clear a logo/banner?
- **Submit** (`POST /seller/shops/{id}/submit`): only valid on `pending_review`,
  and doesn't change status (just signals the admin queue). What does the admin
  side see differently after a submit? Should the UI show "submitted" anywhere?
- **Close** (`POST /seller/shops/{id}/close`): terminal from the seller's side
  (`status_reason: "seller_initiated"`). What happens to live products and open
  order groups of a closed shop?
- **`status_reason` values:** the full list (`name_changed`, `seller_initiated`,
  `seller_banned`, admin free text…), so clients can map them to copy.
- **Category assignments** (`/seller/shops/{id}/category-assignments`): shop must
  be `active`, assignment lifecycle, what the admin approves.
- **Staff** (`POST /seller/shops/{id}/staff`): roles, and who can invite.
- **Bank accounts and documents at shop level** (`owner_type: "shop"`,
  `DocumentSubmitRequest.shop_id`): when a shop needs its own.
- **Commission preview** (`GET /seller/shops/{id}/commission-preview`): what it
  returns and when to show it.
- **Logo and banner:** recommended sizes. Upload is covered by
  `file-upload-endpoint`.

## Why

The Shops page (list, create, edit, submit, close) is built. The shop detail
page (categories, staff, bank accounts) is next, and it's where most of the
undocumented rules above bite.

## References

- `openapi/api.yaml` → `ShopRead`, `ShopCreateRequest`, `ShopUpdateRequest`, `ShopStatus`, `/api/v1/seller/shops*`
- Backend: `app/modules/shops/service.py`, `app/modules/shops/model.py`
- Related: `shop-rejected-resubmit`, `file-upload-endpoint`

## Resolution

`docs/shops-api.md` written, answering each point:

- Status machine with seller/admin transitions and their guards (§1).
- Create: shop limit is **`409`**; name uniqueness `400`; slug rules and the
  availability endpoint (§2).
- `slug` and `legal_entity_override` are create-only by design (§2, §6).
- Update: omitted vs `null` vs value per field (§2).
- Submit: no-op on `pending_review` (no separate "submitted" state on either
  side); resubmits `rejected` shops (§2).
- Close: terminal; products disappear for buyers, existing order groups must
  still be fulfilled. Checkout now also refuses cart items from non-active
  shops (it didn't before). A closed shop's ledger balance is never paid out —
  listed as a known gap needing a product decision (§8).
- `status_reason` values (§1), category assignments (§3), staff (§4),
  commission preview (§5), legal entity override (§6), logo/banner sizes
  (link to the uploads doc).
