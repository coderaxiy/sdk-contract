# Sellers & Approval API — Frontend Integration Guide

How a user becomes a seller, gets approved, and how admins manage sellers after
that. All paths below are relative to the API base (`/api/v1`), e.g.
`POST /api/v1/seller/register`. Schemas: `openapi/api.yaml` → `SellerRead`,
`SellerAdminRead`, `DocumentRead`, `BankAccountRead`.

## Auth

Same cookie-based auth as the rest of the app (`access_token` httpOnly cookie —
`credentials: 'include'` on every request).

- **`POST /seller/register`** requires only a logged-in user.
- **Every other `/seller/...` endpoint** requires the user to have registered as a
  seller — `403 "Not registered as a seller"` otherwise. Use this `403` on
  `GET /seller/me` to decide whether to show the "Become a seller" flow.
- **Admin** endpoints require the `sellers:manage` permission.

## Error shape

Same as the rest of the app: `{"detail": "..."}` string for `400`/`403`/`404`,
FastAPI's structured array for `422`. `400` messages are written to be shown to
the user as-is.

---

## 1. Core concepts

### Seller status (state machine)

```
                 approve
pending_review ───────────▶ active ◀──────┐
      │                       │           │ reinstate
      │ reject             suspend        │
      ▼                       ▼           │
  rejected                suspended ──────┘

  any status ──ban──▶ banned   (terminal)
```

| Status | Meaning | Seller can create shops? |
|---|---|---|
| `pending_review` | Registered, waiting for admin review. Every seller starts here. | No |
| `active` | Approved. `verified_at` is set. | Yes, up to `shop_limit` |
| `suspended` | Temporarily blocked by an admin. `status_reason` says why. | No |
| `rejected` | Application refused. `status_reason` says why. | No |
| `banned` | Permanent. All the seller's non-closed shops are suspended with reason `seller_banned`. | No |

Only an `active` seller can create shops, have shops approved, or have shops
reactivated. Show the seller their `status` and `status_reason` on the dashboard
whenever they aren't `active`.

### Entity type

Chosen at registration, drives which documents are required for approval:

| `entity_type` | Production requirement |
|---|---|
| `individual` | `id_document` |
| `sole_proprietor` | `id_document`, `tax_certificate` |
| `company` | `business_license`, `tax_certificate` |

> ⚠️ **Testing phase: no documents are required right now.** The backend has
> relaxed the requirement for every entity type, so an admin can approve a seller
> with zero documents. Don't block the approve button on documents in the UI.
> Documents can still be uploaded and reviewed — build that UI as normal, it
> will become mandatory again before production. See task
> `seller-documents-optional`.

### Documents

Each document has its own review status: `pending` → `approved` / `rejected`.
Only **approved** documents count toward the requirement above. A rejected
document carries a `rejection_reason`; the seller fixes it by submitting a new
document of the same type (there's no "replace" endpoint — the old one stays in
the history).

`type` values: `business_license`, `tax_certificate`, `id_document`,
`bank_confirmation`, `other`.

**There is no file upload endpoint.** `file_url` is a URL to a file the client
has already stored somewhere. Until an upload endpoint exists, any reachable URL
is accepted.

---

## 2. Seller endpoints (seller website)

| Method & path | Body | Returns |
|---|---|---|
| `POST /seller/register` | `SellerRegisterRequest` | `201` `SellerRead` |
| `GET /seller/me` | — | `SellerRead` |
| `POST /seller/documents` | `DocumentSubmitRequest` | `201` `DocumentRead` |
| `POST /seller/bank-accounts` | `BankAccountCreateRequest` | `201` `BankAccountRead` |

### Register

```json
POST /seller/register
{
  "legal_name": "Aziz Karimov",
  "entity_type": "individual",
  "tax_id": "123456789",
  "country": "UZ",
  "contact_email": "aziz@example.com",
  "contact_phone": "+998901234567"
}
```

- `country` is ISO 3166-1 alpha-2.
- `contact_phone` is optional.
- One seller per user: registering twice → `400 "You are already registered as a seller"`.
- The response has `status: "pending_review"` and `shop_limit` set to the platform
  default (3).

### Submit a document

```json
POST /seller/documents
{ "type": "id_document", "file_url": "https://files.example.com/abc.pdf" }
```

`shop_id` is optional and only used for shop-level legal documents.

### Add a bank account

```json
POST /seller/bank-accounts
{
  "owner_type": "seller",
  "account_holder_name": "Aziz Karimov",
  "bank_name": "Kapitalbank",
  "account_number": "20208000900123456001",
  "is_primary": true
}
```

- `owner_type: "shop"` needs `shop_id`.
- `account_number` is hashed on the server and **never returned**. The response
  has no account number at all — show the bank name and holder instead.
- New accounts come back with `verified: false`.
- Banned sellers get `403`.

---

## 3. Admin endpoints (admin panel)

All require `sellers:manage`.

| Method & path | Body | Returns |
|---|---|---|
| `GET /admin/sellers` | — | `SellerRead[]` |
| `GET /admin/sellers/{seller_id}` | — | `SellerAdminRead` |
| `GET /admin/sellers/{seller_id}/documents` | — | `DocumentRead[]` |
| `PATCH /admin/sellers/{seller_id}/documents/{doc_id}` | `DocumentReviewRequest` | `DocumentRead` |
| `PATCH /admin/sellers/{seller_id}/approve` | — | `SellerRead` |
| `PATCH /admin/sellers/{seller_id}/reject` | `{"reason": "..."}` | `SellerRead` |
| `PATCH /admin/sellers/{seller_id}/suspend` | `{"reason": "..."}` | `SellerRead` |
| `PATCH /admin/sellers/{seller_id}/reinstate` | — | `SellerRead` |
| `PATCH /admin/sellers/{seller_id}/ban` | `{"reason": "..."}` | `SellerRead` |
| `PATCH /admin/sellers/{seller_id}/shop-limit` | `{"shop_limit": 5}` | `SellerRead` |

### List

Query params: `status` (a seller status), `search`, `skip` (default `0`),
`limit` (default `50`). Plain array response, no total count.

### Detail and risk flags

`GET /admin/sellers/{id}` returns everything in `SellerRead` plus `risk_flags`,
a list of fraud signals. They're informational — nothing is auto-blocked. Show
them prominently on the review screen:

| Flag | Meaning |
|---|---|
| `duplicate_bank_account` | One of this seller's bank accounts is also used by another seller |
| `tax_id_matches_banned_seller` | This `tax_id` belongs to a banned or rejected seller |

`risk_score` is set by a future risk service and is `null` for now.

### Review screen: the approval flow

1. Load `GET /admin/sellers/{id}` and `GET /admin/sellers/{id}/documents`.
2. Review each document:
   ```json
   PATCH /admin/sellers/{id}/documents/{doc_id}
   { "status": "rejected", "rejection_reason": "Photo is blurry" }
   ```
   `rejection_reason` is required when rejecting (`400` otherwise).
3. Approve with `PATCH /admin/sellers/{id}/approve`. If required documents are
   missing, you get
   `400 "Cannot approve: missing approved documents: id_document, tax_certificate"`
   — show it as-is. (During the testing phase this never happens.)
4. Or reject with a reason, which the seller will see.

**Only show Approve and Reject when the seller is `pending_review`.** The
backend doesn't enforce this yet (see task `seller-approve-reject-status-guard`),
so the UI must not offer these actions on active, suspended, or banned sellers.

### Other transitions

| Action | Allowed from | Otherwise |
|---|---|---|
| Suspend | `active` | `400 "Only active sellers can be suspended"` |
| Reinstate | `suspended` | `400 "Only suspended sellers can be reinstated"` / `"Banned sellers cannot be reinstated"` |
| Ban | anything except `banned` | `400 "Seller is already banned"` |

Ban can't be undone — put it behind a confirmation dialog that says the seller's
shops will be suspended too.

Every transition, document review, and shop-limit change is written to the
audit log with the acting admin.
