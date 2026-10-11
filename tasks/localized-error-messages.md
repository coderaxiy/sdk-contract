---
id: localized-error-messages
title: Return error messages (400/403/404/409 `detail`, 422 `msg`) in the user's language — uz and ru
author: frontend
to: backend
status: open
priority: normal
area: api-standards
created: 2026-10-12
closed:
reply_to:
---

## What

Every client UI is localized (admin panel and seller website: **uz** and **ru**),
but every error the backend returns is English. `docs/api-standards.md` tells
clients to show `400` `detail` strings "to the user as-is", so an Uzbek or
Russian user gets an English sentence in the middle of a translated screen.

Example, admin panel in Uzbek, activating a pickup point
(`PATCH /admin/pickup-points/{id}/status`):

```json
{ "detail": "Cannot activate a pickup point with no active manager assigned" }
```

shown under a fully Uzbek row. The same happens for every guard in the contract
(status guards, ownership checks, approve/reject checks, ...) and for the `msg`
of `422` validation errors.

### Proposed solution

1. **Language comes from the `Accept-Language` request header.** The standard
   mechanism; works for every client (web, mobile) and needs no new query
   param or body field. Clients will send the user's current UI language as a
   bare code: `Accept-Language: uz` or `Accept-Language: ru`.
   - Supported: `uz`, `ru`. Anything else, or a missing header, falls back to
     one default (suggest `uz`, the product's default locale; `en` is fine if
     backend prefers — just document it).
   - Parse the header properly (`ru-RU,ru;q=0.9,en;q=0.8`) and pick the first
     supported tag.
   - A cookie is not an option: the API is on a different origin from the
     clients, and language is a per-request UI choice, not a session one.

2. **Message catalog keyed by stable error codes, not by English text.** Add a
   per-language catalog (`uz` / `ru` / `en`) and translate where the response
   is built (a FastAPI exception handler that resolves `HTTPException`s raised
   with a code). Raise e.g. `AppError("pickup_point.no_active_manager")`
   instead of a literal string. Keep the `{"detail": "<translated string>"}`
   shape **unchanged**, so no client breaks.

3. **Additive: expose the code too.** For errors raised through the catalog,
   also return a machine-readable code next to the text, so clients can branch
   or override copy without matching on translated strings:

   ```json
   { "detail": "Faol menejer biriktirilmagan olib ketish punktini faollashtirib bo'lmaydi",
     "code": "pickup_point.no_active_manager" }
   ```

   `code` is additive (non-breaking) and must stay stable once published.
   Structured `detail` objects that already exist (e.g. checkout price
   mismatch) keep their shape.

4. **`422` validation errors.** Translate the `msg` of the common Pydantic
   types (`Field required`, `String should have at least N characters`, value
   is not a valid ..., etc.) through the same catalog; `loc` and `type` stay
   as they are.

5. **Docs + spec.** Document the `Accept-Language` behavior and the `code`
   field in `docs/api-standards.md` (Errors section), and add `code` to the
   error schema in the OpenAPI spec. Run `npm run export && npm run validate
   && npm run gen:all`.

### Rollout suggestion

Translating every message at once is not necessary. Suggested order:
(a) header parsing + catalog + exception-handler plumbing; (b) the errors the
admin/seller UIs surface most (status guards, approve/reject, pickup points,
shops, product moderation, refunds); (c) the long tail as it is touched.
Untranslated messages fall back to the current English text, so this can ship
incrementally.

## Why

- Users see mixed-language screens, and the error is exactly the message they
  most need to understand.
- Without a language on the server, every client would have to keep a duplicate
  translation of each backend string keyed on its English text, which breaks
  whenever a sentence is edited. Stable codes plus a server-side catalog avoid
  that.

## Frontend side (once this is available)

Admin panel and seller website will send `Accept-Language` from the current UI
locale on every request through their shared HTTP client. Nothing else changes;
they already display `detail` as-is. Please reply here (or close with a
Resolution) once the header is honored so we can enable it.

## References

docs/api-standards.md → Errors; openapi/api.yaml → error responses (`detail`)

## Progress (backend, 2026-10-12) — still open

Plumbing is live; the long tail is not translated yet, so the task stays open.

- `Accept-Language` is honored on every request: `uz` / `ru`, default `uz`, parsed per RFC
  (`ru-RU,ru;q=0.9` → `ru`). **You can start sending it now.**
- Errors raised through the catalog return `{ "detail": "<translated>", "code": "<stable code>" }`.
  Everything else keeps the English `detail` and has no `code`.
- Translated so far: the auth/permission guards (`auth.*`, incl. the 401 from the auth
  middleware), the generic defaults (`common.*`), and `pickup_point.no_active_manager`.
- `422` `msg` is translated for the common Pydantic types (see `docs/api-standards.md`
  → Errors → Language).
- `ErrorResponse` (`detail`, `code?`) added to the spec; docs updated.
- Next: the module guards, in the order you suggested (status guards, approve/reject, pickup
  points, shops, product moderation, refunds). Dynamic messages become placeholders
  (`{role}`, …) so they stay translatable.

