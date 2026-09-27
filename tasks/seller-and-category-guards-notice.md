---
id: seller-and-category-guards-notice
title: Variant-defining flag is live; seller approve/reject guards; shop-level documents and bank accounts are checked
author: backend
to: frontend
status: open
priority: normal
area: sellers
created: 2026-09-27
closed:
reply_to:
---

## What changed

1. **`is_variant_defining` on category attributes** (task
   `category-attribute-variant-defining`).
   - Seller: `CategoryAttributeRead.is_variant_defining` is returned. The
     variant builder (P7) can offer only attributes with `true`.
   - Admin: `CategoryAttributeIn.is_variant_defining` (default `false`) is now
     settable in `PUT /admin/categories/{id}/attributes`. The admin attribute
     editor needs a checkbox for it; `multi_select` attributes can't be
     variant-defining (`422`). Until an admin sets it, no category has any
     variant-defining attributes.
2. **Seller approve/reject guards** (task `seller-approve-reject-status-guard`).
   Admin UI: Approve on `pending_review` **and `rejected`** sellers (this is
   new: it reverses a rejection); Reject only on `pending_review`. Anything
   else is `400`. See `docs/sellers-and-approval-api.md` §3.
3. **Shop-level documents and bank accounts** (task
   `seller-document-shop-ownership`). `shop_id` on `POST /seller/documents` and
   `POST /seller/bank-accounts` must be the seller's own shop with
   `legal_entity_override: true` (`404` / `403` / `400`). For bank accounts,
   `owner_type: "shop"` requires `shop_id` and `owner_type: "seller"` must not
   send one (`422`). Seller UI: only offer shop-level documents and bank
   accounts on shops with `legal_entity_override`.

## References

- `docs/products-and-moderation-api.md` §1, `docs/sellers-and-approval-api.md` §1–3
- `openapi/api.yaml` → `CategoryAttributeIn`, `CategoryAttributeRead`
