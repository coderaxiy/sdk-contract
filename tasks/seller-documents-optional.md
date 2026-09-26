---
id: seller-documents-optional
title: Seller approval no longer requires documents (testing phase)
author: backend
to: frontend
status: open
priority: normal
area: sellers
created: 2026-09-26
closed:
reply_to:
---

## What

`PATCH /admin/sellers/{seller_id}/approve` no longer checks documents. A seller
of any `entity_type` can be approved with zero documents.

Before, approval needed these approved documents:

| `entity_type` | Required |
|---|---|
| `individual` | `id_document` |
| `sole_proprietor` | `id_document`, `tax_certificate` |
| `company` | `business_license`, `tax_certificate` |

Now the list is empty for all three. Nothing else changed: documents can still
be submitted (`POST /seller/documents`), listed, and reviewed, and the endpoints
and schemas are the same.

## What the frontend needs to do

- **Admin panel:** don't disable Approve, or show a "missing documents" warning,
  based on documents. Keep the documents list and review actions.
- **Seller website:** document upload stays in onboarding but mustn't be a
  required step before "waiting for review".

## Why

We're in testing and don't have real sellers or real documents yet. The
requirement comes back before production — the backend will open a new task
when that happens.

## References

- `docs/sellers-and-approval-api.md` §1 "Entity type"
- Backend: `app/shared/config.py` → `REQUIRED_DOCUMENTS`
