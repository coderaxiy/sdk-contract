---
id: buyer-phone-signup-optional-email
title: Support buyer phone signup without email and optional email addition from profile
author: mobile
to: backend
status: open
priority: high
area: auth
created: 2026-11-02
closed:
reply_to:
---

## What

Implement and document buyer registration using a phone number, with no email
required. Users may optionally add an email later from their own profile. This
is the owner's stated requirement for the Flutter customer app (`market-app`).

### Current contract

- `POST /api/v1/auth/register`: `RegisterRequest` requires `email: string
  (email)` and `password: string`; `full_name` is optional. No phone input.
- `POST /api/v1/auth/login`: `LoginRequest` requires email and password.
- `UserRead.email` is a required, non-null email string; `phone` is nullable.
- `PATCH /api/v1/auth/me` supports name and phone only. API standards explicitly
  say email cannot be changed here. The saved phone is currently contact data,
  not a documented authentication identifier.
- Password reset request/confirm requires email and delivers an emailed code.
- No phone signup/verification flow or mobile-specific signup guide was found
  in the local docs, spec, or task inbox. Fetching remote updates failed because
  the configured GitHub SSH identity was rejected; recheck upstream before work.

### Required behavior and deliverables

1. A buyer can register with a phone number and no email, sign in again, and use
   their account without ever supplying an email. Do not generate fake emails.
2. Return an absent email consistently (prefer `email: string | null`) in the
   user schema and document its representation for all clients.
3. Provide authenticated self-service email addition from the profile. Document
   request/response fields, validation, uniqueness conflicts, verification and
   pending-email behavior, and whether later replacement/removal is supported.
   An admin-only user update endpoint does not satisfy this requirement.
4. Define the phone authentication mechanism: phone/password versus SMS OTP,
   phone ownership verification, normalization and accepted country formats,
   uniqueness, duplicate-account handling, phone changes, and rate limits. These
   choices are not specified by the owner; decide/document them or reply with
   concrete questions before clients implement a guessed flow.
5. Cover recovery for accounts without email (if passwords remain), including
   code expiry, resend/attempt limits, errors, session invalidation, and the
   SMS provider/dev setup if applicable. Document any production blockers.
6. Preserve existing email accounts and other clients, or explicitly document
   migration and breaking changes. Preserve cookie-based session handling and
   guest-cart merging; state whether registration signs in or requires login.
7. Add an actionable mobile buyer-auth guide under `docs/`, with signup, login,
   verification/recovery, profile email addition, concrete JSON examples,
   status/error codes, and Uzbek/Russian localization behavior.
8. Implement in the backend, add regression tests for phone-only signup/login,
   missing/duplicate identifiers, verification/recovery, and email addition.
   Export the OpenAPI spec, validate, regenerate SDKs, and update affected docs
   in the same change set. Send follow-up tasks to `mobile` and affected web
   clients with exact endpoints, schemas, examples, and migration instructions.

Exact new endpoint names and request schemas are for the backend to define and
export; this task requests behavior, not an invented client-side API contract.

## Why

The current Flutter registration UI and repository require email/password and
the profile only edits name/phone. This prevents the intended phone-first buyer
onboarding. Mobile implementation is waiting for a supported backend contract;
email should be an optional later profile action, not a signup prerequisite.

## References

- `openapi/api.yaml`: `/api/v1/auth/register`, `/api/v1/auth/login`,
  `/api/v1/auth/me`, password-reset endpoints, `RegisterRequest`, `LoginRequest`,
  `UserRead`, and the self-profile update schema.
- `docs/api-standards.md`, Auth section.
- `tasks/storefront-account-self-service.md`: previous decision to defer email
  changes pending verification.
- `tasks/buyer-password-reset.md`: current email-only recovery decision.
- `market-app/lib/features/auth/data/auth_repository.dart`, `user.dart`, and
  `presentation/auth_pages.dart`, `presentation/account_page.dart`.
