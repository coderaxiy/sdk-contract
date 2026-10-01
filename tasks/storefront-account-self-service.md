---
id: storefront-account-self-service
title: Buyer account self-service — edit my name, change my password
author: frontend
to: backend
status: closed
priority: normal
area: auth
created: 2026-09-27
closed: 2026-10-01
reply_to:
---

## What

The storefront's account page can only show `GET /auth/me`. There's no documented way
for a buyer to change their own profile or password:

- `PATCH /users/{user_id}` (`UserUpdate { full_name, email }`) and
  `POST /users/{user_id}/password` (`UserPasswordSet { password }`) look like admin user
  management: nothing in `docs/` says a buyer may call them on their own id, and
  "set password" takes no current password.

**Ask:** self-service endpoints for the logged-in user (any role):

| Method | Path | Body | Notes |
|---|---|---|---|
| PATCH | `/auth/me` | `{ full_name?: string }` | Returns `UserRead`. Email change can wait: it needs verification |
| POST | `/auth/me/password` | `{ current_password: string, new_password: string }` | `400` with a human message on a wrong current password; same password rules as register. Should other sessions be signed out? Please decide and document |

Plus, nice-to-have, a saved phone on the user (`phone: string | null` on `UserRead`,
settable via `PATCH /auth/me`): checkout asks for the recipient phone every time on a
new device. Today we remember it only in the browser.

Please document these in a short auth section (there's no `auth-api.md` yet;
`api-standards.md` has the basics).

## Why

Buyers expect to fix a typo in their name (it prefills the checkout recipient) and to
change their password without contacting support.

## References

- openapi/api.yaml → `/api/v1/auth/me`, `/api/v1/users/{user_id}`,
  `/api/v1/users/{user_id}/password`, `UserUpdate`, `UserPasswordSet`, `UserRead`
- docs/api-standards.md → "Auth"

## Resolution

Done in the backend (not committed yet); contract exported and SDKs regenerated. Documented in `docs/api-standards.md` (Auth).

- `PATCH /auth/me` — `{ full_name?, phone? }` → `UserRead`. `phone` is new on `UserRead` (`string | null`); `phone: null` clears it. Email change is not included, as agreed.
- `POST /auth/me/password` — `{ current_password, new_password }`. `400` on a wrong current password. `new_password` needs 8 to 72 bytes; register still has no length rule. Decision on the open question: **other sessions are signed out** (via the new `users.password_changed_at` checked against the token's issue time), and the response sets a fresh cookie, so the current session stays logged in.
- Admin `POST /users/{id}/password` now signs that user's sessions out too.
- Existing tokens without an issue time keep working until a password change, and are rejected after one.
