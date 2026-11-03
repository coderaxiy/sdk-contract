---
id: admin-manual-phone-otp-inbox
title: Admin website — implement permission-gated manual phone OTP inbox
author: backend
to: frontend
status: open
priority: high
area: auth
created: 2026-11-03
closed:
reply_to: buyer-phone-signup-optional-email
---

## What

Audience: **company owner/admin/dispatcher/staff website agent**, not seller or
buyer website. Build the existing website's manual phone-verification page from
[docs/admin-phone-otp-api.md](../docs/admin-phone-otp-api.md).

- `GET /api/v1/admin/auth/phone-otps?skip=0&limit=50&phone=%2B998901234567`
  → `AdminOtpRead[]`, newest first, no codes.
- `POST /api/v1/admin/auth/phone-otps/{challenge_id}/reveal` with
  `{"reason":"Calling submitted number for signup verification"}`
  → `OtpRevealRead` (`challenge_id`, six-digit string `code`, `expires_at`).
- Both need cookie auth + `auth:otp:read`. Gate navigation/actions by permission;
  a staff label or `users:manage` alone is insufficient. Root/admin receive it on
  backend startup; custom staff roles require an explicit grant.
- UI: phone, signup/recovery purpose, timestamps/countdown, pagination, refresh
  or visible-page polling every 15–30 seconds, reason input, explicit reveal.
- Staff **call the exact submitted number** and relay the code; the buyer enters
  it on their own device. Revealing alone never verifies anything. No staff
  approve/confirm/resend/password-entry action exists.
- Never persist/log/prefetch revealed codes or put them in analytics, URLs, or
  notifications. Responses are no-store; clear codes on expiry/navigation/logout.
- Handle 401/403, 400 unknown UUID, 404 no longer pending, 422 validation, and 503
  disabled delivery. Send `Accept-Language: uz|ru`. Every reveal is audited.

## Rollout and acceptance

Use regenerated TypeScript SDK types from `openapi/api.yaml`. Apply migration
`b6a2d8e4f901`, restart backend, set non-default SECRET_KEY and
PHONE_OTP_BACKEND=manual_admin, and staff callbacks before buyer release. Do not
claim SMS support. Verify signup and recovery queue entries, permission denial,
reason validation, expired/used rows disappearing, and no code in list responses.

Phone clients and null-email migration are described in
[docs/buyer-phone-auth-api.md](../docs/buyer-phone-auth-api.md). Close this task
only after implementing the admin UI; backend endpoints/docs are ready.
