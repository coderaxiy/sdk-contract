---
id: seller-document-shop-ownership
title: POST /seller/documents accepts a shop_id the seller doesn't own
author: backend
to: backend
status: closed
priority: normal
area: sellers
created: 2026-09-27
closed: 2026-09-27
reply_to:
---

## What

`SellerService.submit_document` stores `data.shop_id` without checking that the
shop belongs to the calling seller, or that it exists. A seller can attach a
document to another seller's shop, which would then show up when admins review
that shop's legal-entity documents.

## Expected

If `shop_id` is set: the shop must exist (`404`) and belong to the seller (`403`,
same message as `ShopService._require_owned_shop`). Consider also requiring
`legal_entity_override = true` on that shop, since that's the only case the
column is for (see the comment on `SellerDocument.shop_id`).

## Why

Found while wiring document uploads (task `media-uploads`). The uploaded file
itself is already ownership-checked; only the `shop_id` link isn't.

## References

- Backend: `app/modules/sellers/service.py` → `submit_document`

## Resolution

- `POST /seller/documents` with `shop_id`: shop must exist (`404 "Shop not
  found"`), belong to the seller (`403 "You do not own this shop"`), and have
  `legal_entity_override: true` (`400`).
- Same gap existed in `POST /seller/bank-accounts` (a payout account could be
  attached to someone else's shop); it now applies the same three checks.
  `BankAccountCreateRequest` also validates the owner shape: `owner_type: "shop"`
  requires `shop_id`, `owner_type: "seller"` must not send one (`422`). Before,
  a shop account without `shop_id` was stored with no owner at all.
- `docs/sellers-and-approval-api.md` §2 updated.
- Backend: `app/modules/sellers/service.py` → `_require_override_shop`,
  `submit_document`, `add_bank_account`; `app/modules/sellers/schemas.py`.
