# Media Uploads API — Frontend & Mobile Integration Guide

How sellers upload shop logos and banners, product images, and KYC documents.
All paths are relative to the API base (`/api/v1`). Schemas: `openapi/api.yaml`
→ `UploadRead`, `UploadPurpose`.

## The flow: upload first, attach second

Every file goes through the same two steps:

```
1. POST /uploads?purpose=product_image   (multipart, field "file")
      → 201 { key: "products/images/33/9f3c….webp", url: "http://…", … }

2. Send the key where the file belongs:
      POST  /seller/shops                    { "logo_key": "…", "banner_key": "…" }
      PATCH /seller/shops/{shop_id}          { "logo_key": "…" }
      POST  /seller/shops/{shop_id}/products { "images": [{ "key": "…", "is_primary": true }] }
      PATCH /seller/products/{product_id}    { "images": [...] }
      POST  /seller/documents                { "type": "id_document", "file_key": "…" }
```

**Store and send keys, never URLs.** Responses always include a ready-to-use
URL built from the key (`logo_url`, `banner_url`, `images[].url`, `file_url`) —
use it for display, but don't save it or send it back.

Uploading on file selection (step 1) and attaching on form save (step 2) gives
you instant previews and a fast save. A file that's uploaded but never attached
is harmless.

## Auth

Registered sellers only — `403 "Not registered as a seller"` otherwise, and
banned sellers get `403`. Sellers in `pending_review` **can** upload (they need
to, for KYC documents).

## `POST /uploads`

| | |
|---|---|
| Query | `purpose` (required): `shop_logo` \| `shop_banner` \| `product_image` \| `seller_document` |
| Body | `multipart/form-data` with one field, `file` |
| Response | `201` `UploadRead` |

`purpose` is a query parameter, not a form field.

### Per-purpose rules

| `purpose` | Accepted files | Stored as | Scaled to fit | Access |
|---|---|---|---|---|
| `shop_logo` | JPEG, PNG, WebP | WebP | 512 × 512 | public |
| `shop_banner` | JPEG, PNG, WebP | WebP | 2400 × 2400 | public |
| `product_image` | JPEG, PNG, WebP | WebP | 2048 × 2048 | public |
| `seller_document` | JPEG, PNG, WebP, **PDF** | WebP (images), PDF as-is | 3000 × 3000 | **private** |

- **Max 10 MB** per file as sent, and at most 50 megapixels.
- Images are **always re-encoded to WebP**: the phone's rotation is applied,
  metadata (including GPS location) is removed, transparency is kept. Images
  are only ever scaled down, never up. Don't pre-process on the client beyond
  what your UX needs — at most, downscale very large photos to save upload time.
- The file type is detected from the content, not the extension or the
  `Content-Type` you send.
- **HEIC is not accepted.** iOS converts to JPEG when you take
  `UIImage.jpegData(...)` or use `PHPickerViewController` with a JPEG
  representation — do that before uploading.

### `UploadRead`

```ts
{
  id: number
  key: string           // send this when attaching the file
  url: string           // for immediate preview only — see "Private files"
  purpose: "shop_logo" | "shop_banner" | "product_image" | "seller_document"
  content_type: string  // "image/webp" or "application/pdf"
  size_bytes: number    // size as stored, after re-encoding
  width: number | null  // null for PDFs
  height: number | null
  created_at: string
}
```

### Errors

| Status | When | `detail` (show as-is) |
|---|---|---|
| `400` | Wrong or broken file | `"File is not a valid image"`, `"Unsupported image format — use JPEG, PNG, or WebP"`, `"Image resolution is too large"` |
| `400` | Size | `"File is empty"`, `"File is too large — the maximum is 10 MB"` |
| `403` | Not a seller / banned | `"Not registered as a seller"`, `"Banned sellers cannot upload files"` |
| `422` | Missing `file` or bad `purpose` | FastAPI validation array |
| `503` | Storage is down | `"File storage is temporarily unavailable, try again"` — safe to retry |

## Attaching: errors

When you send a key in step 2, the server checks it. Both are `400`:

- `"Unknown upload key: <key>"` — the key doesn't exist **or belongs to another
  user** (deliberately the same message).
- `"Upload <key> is a shop_logo, not a product_image"` — the file was uploaded
  with a different `purpose`. Re-upload it with the right one.

## Public vs private files

- **Public** (logos, banners, product images): `url` is permanent. Safe to cache
  and to use directly in `<img>` / image loaders.
- **Private** (`seller_document`): `url` / `file_url` is a **signed link valid
  for 15 minutes**. The same URL without its signature returns `403`. Don't
  cache it — re-fetch the document (`GET /admin/sellers/{id}/documents`, or the
  response of the call that returned it) to get a fresh link when showing it
  again.

## Code

### Web (TypeScript)

The TS types describe the file field as `string`; in the browser send a `File`
in `FormData`. Let the browser set the multipart `Content-Type` (with boundary).

```ts
import type { components } from '<contract>/sdk/typescript';

type UploadPurpose = components['schemas']['UploadPurpose'];
type UploadRead = components['schemas']['UploadRead'];

export async function upload(file: File, purpose: UploadPurpose): Promise<UploadRead> {
  const body = new FormData();
  body.append('file', file);
  const res = await fetch(`${API_URL}/api/v1/uploads?purpose=${purpose}`, {
    method: 'POST',
    body,
    credentials: 'include',
  });
  if (!res.ok) throw await res.json(); // { detail }
  return res.json();
}

// then: api.POST('/api/v1/seller/shops', { body: { name, logo_key: logo.key } })
```

### Android (Kotlin)

```kotlin
val uploads = client.createService(UploadsApi::class.java)
val part = MultipartBody.Part.createFormData(
    "file", "photo.jpg", bytes.toRequestBody("image/jpeg".toMediaType()),
)
val uploaded: UploadRead? =
    uploads.createUploadApiV1UploadsPost(UploadPurpose.product_image, part).body()
```

### iOS (Swift)

`file` is a URL to a local file — write the JPEG/PNG data to a temporary file first.

```swift
let fileURL = FileManager.default.temporaryDirectory.appendingPathComponent("photo.jpg")
try jpegData.write(to: fileURL)
let uploaded = try await UploadsAPI.createUploadApiV1UploadsPost(purpose: .productImage, file: fileURL)
```
