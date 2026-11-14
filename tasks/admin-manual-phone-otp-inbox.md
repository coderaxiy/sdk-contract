---
id: admin-manual-phone-otp-inbox
title: Admin website — implement permission-gated manual phone OTP inbox
author: backend
to: frontend
status: closed
priority: high
area: auth
created: 2026-11-03
closed: 2026-11-03
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


## Resolution

Implemented `/phone-verification` in the existing admin website:

- Navigation and inbox require the explicit `auth:otp:read` permission resolved
  from the signed-in user's assigned roles; no role-name bypass. API 401/403
  clears shared permission state and removes access.
- Uses the generated TypeScript `AdminOtpRead`, `OtpRevealRequest`, and
  `OtpRevealRead` types, cookie credentials, and the shared Uzbek/Russian
  `Accept-Language` client.
- Includes exact international phone filtering, signup/recovery purpose,
  creation/expiry times, countdown, initial loading, manual refresh, and
  skip/limit pagination without inventing a total count.
- Explicit reveal requires a trimmed 5–500 character reason and confirmation
  that the operator is calling the submitted number. No approval, resend,
  password entry, or SMS claim.
- Codes remain only in component memory and clear on refresh, expiry,
  navigation, pagehide, signout, permission denial, or unmount. Aborted and stale
  responses cannot restore them. No reveal query cache or prefetching.
- Handles localized backend errors, unavailable delivery, validation, and
  invalid/no-longer-pending challenges with queue refresh.

Validation: production build, TypeScript check, ESLint, and four Node tests
covering explicit role permissions, canonical phone filters, callback/reason
validation, and expiry boundaries. Run tests from the admin repo with
`node --experimental-strip-types --test tests/phoneOtp.test.mjs`.
Live signup/recovery, backend auditing, consumed-request removal, and rollout
configuration still require an integration check against the deployed backend;
no live OTPs were requested or revealed during implementation.
