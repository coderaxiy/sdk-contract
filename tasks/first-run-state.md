---
id: first-run-state
title: Remember per user that the first-run quick start was completed (admin wizard + seller quick start)
author: frontend
to: backend
status: closed
priority: normal
area: shared
created: 2026-10-01
closed: 2026-10-12
reply_to:
---

## What

Both web apps show a one-time quick start modal on a user's first visit:

| App | Flow | Where it's mounted |
|---|---|---|
| emarket-admin | role → create first category → done | `AdminLayout.astro`, `OnboardingWizard.tsx` |
| emarket-seller-web | what you'll sell → verify documents → done | `SellerLayout.astro`, `SellerQuickStart.tsx` |

Whether a user has finished or dismissed it is stored only in a **browser
cookie** (`onboarding_seen` in admin, `seller_quick_start_seen` in seller),
holding user ids. So the modal comes back on every new browser, device, private
window, or cleared cookies, for someone who already went through it.

Expected: a per-user flag the frontend can read on the existing session call
and set once.

- **Read:** add to `UserRead` (returned by `GET /auth/me`) a nullable
  timestamp per flow, e.g. `quick_start_completed_at: { admin: string | null, seller: string | null }`.
  Two flat fields (`admin_quick_start_at`, `seller_quick_start_at`) are fine
  too. It's per user, since the same `User` can be an admin operator and a seller.
- **Write:** `POST /auth/me/quick-start` with `{ "app": "admin" | "seller" }`.
  It sets that flow's timestamp to now if it's still null and returns the
  updated `UserRead`. It's idempotent: completing twice is a no-op.
- No permission beyond being logged in; it only touches the caller's own record.

The frontend reads it server-side (the layouts already have
`Astro.locals.user` from `/auth/me`) to decide whether to render the modal,
then calls the write on Done / Skip / Esc. Once this lands, both cookies go away.

## Why

The quick start is meant to happen once per person, not once per browser.
Showing it again to an established seller or admin looks broken. In the seller
app it's also how they reach document upload, so a repeat asks for documents
they already sent. Task `seller-documents-read` lets the modal show those
documents, but it shouldn't open at all.

## References

- openapi/api.yaml → `UserRead`, `GET /api/v1/auth/me`
- emarketseller → `app/modules/auth/schemas.py` (`UserRead`), `app/modules/auth/router.py`
- emarket-admin → `src/lib/preferences.ts` (`ONBOARDING_COOKIE`)
- emarket-seller-web → `src/lib/preferences.ts` (`QUICK_START_COOKIE`)

## Resolution

Done (backend, 2026-10-12). Flat fields, migration `e7a3c5b1d9f4`.

- `UserRead` (`GET /auth/me`, and everywhere `UserRead` is returned) gains
  `admin_quick_start_at` and `seller_quick_start_at`: ISO timestamp or `null`.
- `POST /auth/me/quick-start` with `{ "app": "admin" | "seller" }` sets that timestamp to now if
  still `null` and returns the updated `UserRead`. Idempotent; any logged-in user; only touches the
  caller. `422` for any other `app` value.
- Existing users start with `null` for both, so everyone sees the quick start once more after this
  ships; the frontend can drop the cookies after the first successful call. Docs:
  `docs/api-standards.md` Auth section.
