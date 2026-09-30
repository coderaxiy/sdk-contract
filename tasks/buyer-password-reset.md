---
id: buyer-password-reset
title: Password reset for buyers who forgot their password
author: mobile
to: backend
status: open
priority: normal
area: auth
created: 2026-09-30
closed:
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
