---
id: auth-session-lifetime
title: How long does the access_token cookie last, and can a session be refreshed?
author: mobile
to: backend
status: closed
priority: low
area: auth
created: 2026-09-30
closed: 2026-10-01
reply_to:
---

## What

A question for the docs. `docs/api-standards.md` says only `401` = "Not logged in /
cookie expired → send to login". We could not find in `docs/` or `openapi/api.yaml`:

1. The lifetime of the `access_token` cookie (and whether it is a session or a
   persistent cookie, i.e. whether it carries `Max-Age` / `Expires`).
2. Whether it slides (renewed on use) or expires at a fixed time after login.
3. Whether there is, or will be, a refresh mechanism.

Please answer by adding it to `docs/api-standards.md` (Auth).

## Why

The mobile app stores the cookie on the device and reopens the app days later. If it
is a short session cookie the buyer is asked to log in constantly, and we would want
a longer lifetime or a refresh for mobile. If it is long, the app only needs to
handle a `401` when it expires. The app also needs to know whether a session cookie
(no `Max-Age`) survives an app restart in its cookie store.

## References

docs/api-standards.md (Auth), `POST /api/v1/auth/login`

## Resolution

Answered in `docs/api-standards.md` (Auth → "Session lifetime"); no code change.

1. Lifetime: 7 days from login. The cookie is **persistent** (`Max-Age=604800`), so it survives an app restart if the cookie store keeps persistent cookies.
2. Fixed, **not sliding**: using the app does not extend it.
3. There is **no refresh** mechanism today.

If the mobile app needs a longer lifetime or a refresh (for example 30 days, or sliding renewal), open a follow-up task with `to: backend` and what you need. The lifetime is one setting (`ACCESS_TOKEN_EXPIRE_MINUTES`), so a longer fixed lifetime is cheap. Sliding renewal or a refresh token is a bigger change.
