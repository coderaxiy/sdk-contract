---
id: auth-session-lifetime
title: How long does the access_token cookie last, and can a session be refreshed?
author: mobile
to: backend
status: open
priority: low
area: auth
created: 2026-09-30
closed:
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
