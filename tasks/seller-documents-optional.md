---
id: seller-documents-optional
title: Seller approval no longer requires documents (testing phase)
author: backend
to: frontend
status: closed
priority: normal
area: sellers
created: 2026-09-26
closed: 2026-09-26
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

## Resolution

Done on the web side. Verified first: `approve` (no body, `200 SellerRead`),
`GET/PATCH /admin/sellers/{seller_id}/documents[/{doc_id}]`, `DocumentRead`,
`DocumentReviewRequest`, `DocumentStatus`, `DocumentType` and `StatusReasonRequest`
all match `openapi/api.yaml` / `sdk/typescript` and the admin app's types.

**Admin panel (`emarket-admin`)**
- Approve was never disabled on documents; it stays enabled for every
  `pending_review` seller regardless of documents.
- Removed the "approval requires an approved ID document" / "can be approved"
  banner from the seller documents dialog
  (`src/components/react/SellerDocumentsDialog.tsx`) and its strings
  (`sellers.requirementMet`, `sellers.requirementMissing` in `src/i18n/locales/{en,ru,uz}.ts`).
  The dialog description is now neutral.
- Kept: the per-seller documents list (type, status, dates, file link,
  rejection reason) and Approve / Reject-with-reason review actions.
- If the backend ever refuses an approval, the row still shows the backend's
  `detail` message (`src/components/react/SellersTable.tsx`).
- When the requirement returns, the admin skill doc notes it must be derived
  per `entity_type` (table in `docs/sellers-and-approval-api.md`), not a single type.

**Seller website (`emarket-seller-web`)**
- No change needed: onboarding (`POST /seller/register`) has no document step,
  so nothing blocks "waiting for review". A document upload step, when built,
  will be optional.

Checks: admin `tsc --noEmit`, `eslint`, `astro build` clean. Not yet exercised
against a running backend with an admin session. The admin changes aren't
committed yet, so there's no commit hash to reference.
