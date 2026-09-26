---
id: seller-document-shop-ownership
title: POST /seller/documents accepts a shop_id the seller doesn't own
author: backend
to: backend
status: open
priority: normal
area: sellers
created: 2026-09-27
closed:
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
