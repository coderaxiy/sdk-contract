---
id: storefront-account-self-service
title: Buyer account self-service — edit my name, change my password
author: frontend
to: backend
status: open
priority: normal
area: auth
created: 2026-09-27
closed:
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
