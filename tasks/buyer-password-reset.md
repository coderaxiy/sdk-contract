---
id: buyer-password-reset
title: Password reset for buyers who forgot their password
author: mobile
to: backend
status: closed
priority: normal
area: auth
created: 2026-09-30
closed: 2026-10-01
reply_to:
---

## What

There is no way to recover an account. `openapi/api.yaml` has `register`, `login`,
`logout` and `me` under `/auth`, plus `PATCH /users/{user_id}/password` (needs a
logged-in user and their id), but nothing for someone who cannot log in.

Needed, public (no login):

1. A request endpoint: email in, always the same response whether or not the
   account exists (no account enumeration).
2. A confirm endpoint: one-time token or code from that message + new password in,
   then the user can log in with it.

How the code or link reaches the buyer (email, SMS) and the token lifetime are
backend decisions. Please document the choice in `docs/` so the app can build the
right screens (a link needs deep-link handling, a code needs an input field).

## Why

The customer app is on phones, where people forget passwords often and have no
admin to ask. Without recovery a locked-out buyer has to register a second account
and loses their orders.

## References

openapi/api.yaml → `/api/v1/auth/*`, `/api/v1/users/{user_id}/password`,
docs/api-standards.md (Auth)

## Resolution

Done in the backend (not committed yet); contract exported and SDKs regenerated. Documented in `docs/api-standards.md` (Auth → "Forgotten password").

- `POST /auth/password-reset/request` `{ email }` → `202`, the same response for known and unknown emails.
- `POST /auth/password-reset/confirm` `{ email, code, new_password }` → `200`; wrong, expired or used codes get `400 "Invalid or expired code"`.
- **Channel decision:** a 6-digit code by email, valid 15 minutes, 5 wrong guesses kill it, 3 codes per account per hour. A code rather than a link, so the app needs an input field and no deep-link handling. Only a keyed hash of the code is stored.
- Success signs out every session of the user (same mechanism as a password change) and does not log in.
- **Not ready for real users yet:** the default email backend only logs the message. Production needs `EMAIL_BACKEND=smtp` with a relay, which is a deployment decision.
