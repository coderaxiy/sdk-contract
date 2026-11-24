---
id: buyer-phone-auth-web
title: Implement phone buyer auth and nullable-email compatibility (frontend)
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

Audience: customer storefront/websites; also update admin/seller user displays. Backend phone/password signup, OTP verification, phone
recovery, and optional verified email addition are implemented. Read
[docs/buyer-phone-auth-api.md](../docs/buyer-phone-auth-api.md) and exported spec.

1. Public signup: `POST /api/v1/auth/phone/register/request`
   `{"phone":"+998901234567","password":"example-password","full_name":"Ali"}`
   → `202 OtpChallengeRead` (`challenge_id`, `expires_at`, `resend_after_seconds`,
   `delivery: "manual_admin"`). Staff **call**, no SMS is sent.
2. `POST /api/v1/auth/phone/register/confirm` with `{challenge_id,code}`
   → `UserRead`; merges guest cart but does not sign in. Then `/auth/login` with
   `{phone,password}`; retain/send the httpOnly cookie as before.
3. Login accepts exactly one of email/phone (both/neither → 422), with a password
   of at most 72 UTF-8 bytes. New phone passwords also need 8+ characters.
4. Recovery: `/auth/phone/password-reset/request` with `{phone}`, then
   `/auth/phone/password-reset/confirm` with `{challenge_id,code,password}`
   (password is the new one). Confirmation revokes every session; log in again.
5. Profile email: authenticated `/auth/me/email/request` with `{email}`, then
   `/auth/me/email/confirm` with `{challenge_id,code}`. Email stays null while
   pending; code is delivered by email. No self-service replacement/removal.
6. **Breaking schema change:** `UserRead.email` is now required-but-nullable;
   render phone/name fallback throughout user lists, profile, and account UIs.
   Add nullable `verified_phone` and `phone_verified_at`. `phone` remains contact
   data; editing it cannot change login identity. Never generate fake emails.
7. Six-digit string codes, 15-minute expiry, five guesses; resends replace old
   UUID/code. Three issues/phone/hour shared signup/recovery, 60-second cooldown.
   Handle 400, 409 conflicts, 422, 429 + Retry-After, and 503 disabled delivery.
   Send Accept-Language uz/ru and branch on stable error codes.

## Migration and acceptance

Update generated SDKs/types from the spec. The storefront exception in AGENTS.md
still applies: mirror the exact new schemas into its handwritten types. Keep
existing email signup/login/recovery and cookie/guest-cart behavior working.
No verified-phone change/account merge/legacy-contact backfill is supported.

Backend deployment needs migration b6a2d8e4f901, a non-default SECRET_KEY,
PHONE_OTP_BACKEND=manual_admin, and staffed callbacks. Admin UI work is tracked
separately in `admin-manual-phone-otp-inbox`. Do not present automatic SMS delivery.
Test phone-only signup→confirm→login, wrong/expired/resend code, nullable email,
recovery/session revocation, optional email confirmation, and existing email login.
Close this task after the client implementation, build, and local verification.

## Frontend handoff

Implement the customer flows in `emarket`. Start with the existing auth endpoints
in `src/lib/api/endpoints.ts` and the sign-in, registration, recovery, and account
UI. Also audit user identity displays and API types in `emarket-admin` and
`emarket-seller-web` for required-but-nullable email. Keep the existing admin
staff OTP inbox as the operator workflow.

Verify that phone signup confirmation followed by login preserves the guest
cart, that a phone-only buyer can use the site before adding email, and that
existing email sign-in still works. Check that admin and seller screens can
render a phone-only buyer without a placeholder email. Record verification for
each affected checkout in the resolution.
