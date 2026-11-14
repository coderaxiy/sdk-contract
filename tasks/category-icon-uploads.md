---
id: category-icon-uploads
title: Add category icon uploads with safe SVG and raster representations
author: frontend
to: backend
status: closed
priority: normal
area: categories
created: 2026-11-14
closed: 2026-11-14
reply_to:
---

# Category icon uploads — backend task and admin rollout

Status: proposed backend contract; admin integration implemented behind
`PUBLIC_CATEGORY_ICON_UPLOADS_ENABLED=true` (default off).

## Audit and decision

Admin currently accepts `icon_url` directly in category create/update. The shared
media API uses upload-first/attach-by-key, accepts raster images, and has no
category purpose. Its seller authorization cannot serve category administrators.
Keep category hierarchy, translations, commission, attributes, and lifecycle rules
unchanged. Follow the existing upload service, storage abstraction, permissions,
audit log, and category service boundaries.

The supplied Uzum response contains a PNG URL and inline SVG. This establishes
multiple representations, not multiple uploads or automatic theme support. Its SVG
has fixed red fills. Use one uploaded source and derive representations server-side;
do not require administrators to maintain matching URL and markup fields.

## Backend implementation

1. Extend `POST /api/v1/uploads?purpose=category_icon`, multipart field `file`.
   Require `categories:manage`, without requiring a seller profile. Use the shared
   `UploadRead` response; `key` attaches the asset and `url` previews it.
2. Accept SVG, PNG, JPEG, WebP; proposed maximum 1 MiB input. Detect actual content,
   reject empty/malformed files and decompression bombs, enforce image dimensions
   and SVG complexity limits. Preserve transparency. Keep validated SVG vector data;
   derive a public raster fallback using the existing media processing boundary.
3. Sanitize SVG on the server with a maintained allowlist parser. Reject scripts,
   event handlers, foreignObject, external resources, unsafe URLs/CSS, DTD/entities,
   and recursive/expensive references. Apply complexity/time/resource limits during
   both parsing and rasterization. Never trust filename/MIME or client validation.
4. Add `icon_key` to category create/PATCH. PATCH omission preserves the icon;
   null removes all representations; a valid key replaces them atomically. Validate
   purpose, administrator ownership/access using existing upload attachment policy,
   and existence. Prevent dangling keys and unauthorized attachment.
5. Category admin/public reads return nullable `icon_key`, `icon_url` (raster fallback),
   and `icon_svg` (sanitized derived markup, SVG sources only). The upload `url` can
   serve the sanitized source; the saved category URL is the derived fallback.
   Clients must never inject unsanitized markup. No client-supplied `icon_svg` write
   field. No automatic recoloring: multicolor artwork retains its original colors.
   A future monochrome/themed rendering mode requires an explicit product contract.
6. Preserve existing `icon_url` records. During transition accept legacy URL writes;
   reject conflicting `icon_key`/`icon_url` writes. Do not fetch arbitrary legacy URLs
   as part of migration. Document precedence and eventual deprecation separately.
7. Use existing orphan cleanup for cancelled uploads; replacements must not delete
   media still referenced elsewhere. Apply current audit and cache invalidation rules.
8. Update OpenAPI, shared SDKs, media/category docs, and publish the contract before
   enabling the admin rollout setting.

## Acceptance and validation

- Authorized admin without seller profile uploads each supported type; unauthorized
  users cannot upload or attach category icons.
- Test unsafe/malformed SVG, external references, oversize and image/complexity limits,
  wrong purpose/ownership, missing key, and storage failures.
- Create, replace, omit, clear, and legacy edit round-trip; public and admin reads
  agree. Failed replacement preserves the previous icon. Deleting/deactivating a
  category follows existing business rules.
- Upload cancellation leaves cleanup-eligible media. Derived URLs remain stable,
  caching is versioned, and sanitized SVG cannot execute when rendered by consumers.

## Admin implementation and release order

A separate React editor uses shared Axios, endpoint constants, existing dialog and
translation components. File selection uploads; Save attaches only a changed key.
Upload errors retain the current icon, save is blocked during upload, and removal
sends null. Raw SVG is never injected into the DOM. Existing URL editing remains
available while the rollout setting is absent/false.

Deploy backend and verify its published contract first, then set
`PUBLIC_CATEGORY_ICON_UPLOADS_ENABLED=true` and rebuild the admin. Smoke-test upload,
failed upload/retry, save failure/retry, clear, cancel, and unchanged legacy edits.

## References

- `docs/media-uploads-api.md` — upload-first/attach-by-key conventions.
- `openapi/api.yaml` — category create/update/read and UploadPurpose schemas.
- Admin repository: `tasks/category-icon-uploads.md` — rollout plan.

## Resolution

Implemented in the backend workspace on 2026-11-14. Migration
`f1c8a2d4e609` follows `d9f4b7a2c601`; it adds category upload references,
SVG/raster metadata, cleanup retention timestamps and deletion markers. Existing
legacy URL rows remain unchanged and no remote URLs are fetched.

- `POST /api/v1/uploads?purpose=category_icon` requires `categories:manage`
  without seller registration. Inputs are content-detected SVG/PNG/JPEG/WebP,
  at most 1 MiB and 4096 pixels per side; raster output fits 512 × 512.
- Static SVG is validated with defusedxml plus an explicit element/attribute
  allowlist, then rasterized with CairoSVG in bounded subprocesses. CSS, gradients,
  embedded images and all references are intentionally unsupported; raster uploads
  remain available for such artwork. The exact subset/limits are documented in
  `docs/category-icons-api.md`.
- Category create/PATCH accepts owned category-icon upload keys; reads include
  nullable `icon_key`, raster `icon_url`, and sanitized `icon_svg`. PATCH omission
  preserves; null clears. Legacy URL writes remain supported; sending both icon
  write fields returns 422. Existing category authorization, hierarchy, lifecycle,
  audits and public cache behavior remain in force.
- Hourly cleanup handles cancelled/replaced icons after a 24-hour grace period,
  preserves category references, and locks upload rows against attachment races.
  A durable deletion marker prevents attachment after partial deletion failures.
- Updated OpenAPI, TypeScript/Kotlin/Swift SDKs and media/category integration docs.

Validation: 7 processing/security tests and 7 PostgreSQL HTTP/migration tests pass;
39-test storefront/auth/category regression run passes. Ruff passes for changed
modules; scoped mypy check passes with Python 3.12 target and missing third-party
imports ignored. OpenAPI validation passes with two existing warnings; task
frontmatter validation passes. Storage failure paths use mocks; deployment and
live object-storage/admin smoke tests remain release steps.

Contract commit: this task's closing commit. Backend changes remain in the working
checkout alongside pre-existing uncommitted work; they have not been deployed.
Install updated dependencies (Docker includes libcairo2), apply the migration,
deploy and verify the API before enabling the admin rollout setting.
