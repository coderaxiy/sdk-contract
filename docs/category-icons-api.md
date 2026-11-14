# Category icons

Category icons use upload-first/attach-by-key. Existing legacy `icon_url` records
remain readable and editable; no migration fetches URLs.

## Upload and attach

1. `POST /api/v1/uploads?purpose=category_icon`, multipart field `file`.
   Requires an active account with `categories:manage`; no seller profile needed.
2. Use the returned `UploadRead.url` for preview and send `UploadRead.key` as
   `icon_key` to `POST /api/v1/admin/categories` or
   `PATCH /api/v1/admin/categories/{category_id}`.

Only the uploading administrator may attach a key, and it must exist and have
purpose `category_icon`. Other administrators may edit or clear existing category
icons without reattaching them. Attachment failures leave the existing icon intact.

## Files and safety

Input is limited to 1 MiB and dimensions up to 4096 pixels per side. Actual content
is detected, ignoring MIME and filename. PNG, JPEG and WebP are normalized to WebP,
scaled down to fit 512 × 512, preserving transparency. SVG produces both sanitized
vector source and a WebP fallback with the same bounds and original colors.

SVG uses defusedxml with DTD, entities and external access forbidden, followed by
a strict static shape/presentation allowlist. Supported elements: SVG root, groups,
paths, rectangles, circles, ellipses, lines, polylines, polygons, titles and descriptions.
Use the SVG namespace and pixel dimensions or a viewBox. Text must be converted to
paths. CSS/style, scripts, event handlers, foreignObject, images, animation, all
references (including local use/gradients), inherited colors and external resources
are rejected rather than silently removed. Unsupported artwork can be uploaded as PNG.

Limits: 512 elements, depth 16, 32 KiB per attribute, 12,000 geometry/command tokens,
and finite numeric values bounded by 1,000,000. Parsing and rasterization run in
separate processes with 3 CPU seconds, 8 wall seconds, 512 MiB address space on Linux,
and at most two concurrent workers per API process. Invalid/unsafe/over-budget inputs
return 400; storage outages return 503. Deployment needs libcairo2 (included in Docker);
local macOS development needs `brew install cairo` and, for Python installations
that do not search Homebrew libraries, `export DYLD_FALLBACK_LIBRARY_PATH=/opt/homebrew/lib`
(use `/usr/local/lib` on Intel Macs).

## Category writes and reads

| Write | Result |
|---|---|
| Omit icon fields on PATCH | Preserve all current representations |
| `icon_key: "..."` | Atomically replace icon; clear legacy URL |
| `icon_key: null` | Clear all representations |
| `icon_url: "..."` | Transitional legacy URL write; clear uploaded icon association |
| `icon_url: null` | Clear all representations |
| Both fields present, even null | 422; send exactly one |

Admin/seller category reads and public category trees include nullable:

- `icon_key`: uploaded source key; null for legacy URLs.
- `icon_url`: public raster fallback URL; legacy URL for old records.
- `icon_svg`: server-sanitized markup for SVG uploads; otherwise null.

There is no writable `icon_svg` field. Prefer `icon_url` or `<img src>` for display;
never inject client-provided SVG. There is no automatic recoloring/theme mode.
Legacy URL writes remain supported without a removal date; deprecation will require
a separate contract notice. Uploaded keys take precedence when reading.

## Lifetime and caching

Keys contain a fresh UUID for each upload, so replacement versions the source and
fallback URLs. The existing public category tree cache remains 300 seconds; clients
should refetch after saving. Icon changes use the existing category audit log.

An hourly job removes unattached category-icon uploads unused for 24 hours in batches
of 100. It preserves uploads referenced by any category (including inactive ones),
and current storage URLs referenced through legacy category fields. Replacements and
category deletion never immediately delete media. Replacement/clear refreshes the
24-hour grace period so cached responses retain working URLs. Attachment and cleanup lock the same
upload row, and a foreign key prevents dangling category keys. Cleanup persists a deletion marker before touching storage, preventing attachment
of partially removed media. Storage deletion failures retain that marked record for retry. No arbitrary legacy URL is fetched.

## Admin release

Deploy the migration and backend, publish the regenerated contract, then enable
`PUBLIC_CATEGORY_ICON_UPLOADS_ENABLED=true` and rebuild the admin. Smoke-test upload,
retry, save/retry, clear, cancel and unchanged legacy edits before rollout.
