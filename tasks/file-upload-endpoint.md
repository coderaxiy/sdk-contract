---
id: file-upload-endpoint
title: Add a file/image upload endpoint that returns a URL for the *_url fields
author: frontend
to: backend
status: closed
priority: high
area: shared
created: 2026-09-26
closed: 2026-09-27
reply_to:
---

## What

There is no upload endpoint in the API. Every image or file field is a bare URL
the client must already have hosted somewhere:

| Schema | Field(s) | Who fills it |
|---|---|---|
| `ShopCreateRequest` / `ShopUpdateRequest` | `logo_url`, `banner_url` | seller website |
| `ProductCreate` / `ProductUpdate` → `ProductImageIn` | `url` | seller website |
| `DocumentSubmitRequest` | `file_url` | seller website (onboarding) |
| `BrandRequestCreate` | `logo_url` | seller website |
| `RefundRequestCreate` | `evidence_urls` | buyer app |
| `CategoryCreate` / `CategoryUpdate` | `icon_url` | admin panel |

`docs/sellers-and-approval-api.md` §1 already says so: "There is no file upload
endpoint. `file_url` is a URL to a file the client has already stored
somewhere." Clients have no such storage, so today the only UI we can build is
"paste an image link", which isn't shippable for sellers.

Requested: one upload flow all clients share, whose result is a URL that goes
straight into the existing `*_url` fields (so none of the schemas above change).
Either shape works for us; your call:

- **Direct:** `POST /api/v1/uploads` (`multipart/form-data`, a `file` part plus
  a `purpose`, e.g. `shop_logo | shop_banner | product_image | seller_document |
  brand_logo | refund_evidence | category_icon`) → `201 { url, content_type,
  size_bytes }`.
- **Presigned:** `POST /api/v1/uploads/presign` `{ purpose, content_type,
  size_bytes }` → `{ upload_url, method, headers, url }`, the client PUTs the
  bytes to `upload_url` and then sends `url`.

What the clients need to know, preferably in the spec and a doc:

- The allowed content types and max size per `purpose` (images vs PDFs for
  documents), and the exact 4xx the endpoint returns when they're violated, so
  we can validate before uploading and show the backend's message after.
- Who can upload for which purpose (e.g. `shop_*` / `product_image` need a
  Seller, `category_icon` needs an admin permission).
- Whether a returned URL is public and permanent, or signed and expiring.
  `ShopRead.logo_url` is shown to buyers, so it has to stay reachable.
- Any recommended image dimensions or aspect ratios (logo square? banner wide?),
  and whether the backend resizes.
- Whether the `*_url` fields will accept **only** URLs from this endpoint once
  it exists (we'd prefer yes, so nobody hotlinks arbitrary hosts).

## Why

The seller website's shop form (create/edit) is being expanded with a logo and
banner, and the product form will need images next. Without uploads, sellers
would have to host images elsewhere and paste links. The same gap blocks seller
document upload in onboarding and refund evidence in the buyer app.

## References

- `openapi/api.yaml` → `ShopCreateRequest`, `ShopUpdateRequest`, `ProductImageIn`,
  `DocumentSubmitRequest`, `BrandRequestCreate`, `RefundRequestCreate`, `CategoryCreate`
- `docs/sellers-and-approval-api.md` §1 "Documents"
- `docs/api-standards.md` (please add the upload rules here or in a new doc)

## Resolution

Superseded by the backend's `media-uploads` task (commit 88791ba). It added
`POST /api/v1/uploads?purpose=…`, which returns `UploadRead { key, url, … }`,
and `docs/media-uploads-api.md`. It went further than this request: the
`*_url` request fields became upload **keys** (`logo_key`, `banner_key`,
`images[].key`, `file_key`) instead of accepting URLs from the endpoint. That
answers "only URLs from this endpoint" more strictly. Limits, formats, public
vs signed URLs and errors are documented in the guide. Brand logos, category
icons and refund evidence aren't upload purposes yet. They'd need their own
task when those screens are built.

