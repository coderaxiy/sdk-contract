# Buyer phone signup, login, recovery, and optional email

For customer mobile apps and websites. All paths below start with `/api/v1`.
Use the usual cookie jar on mobile and `credentials: 'include'` on web. Phone
verification currently uses a **staff callback**, not SMS; never display “SMS sent”.
The buyer UI must explain that staff will call the submitted number and relay the
code. The [admin website guide](admin-phone-otp-api.md) describes that operation.

## Phone identity and compatibility

Accepted input: international `+` followed by 8–15 ASCII digits, first digit
nonzero. Spaces, parentheses, and hyphens are removed; country code is required.
For example, `+998 (90) 123-45-67` becomes `+998901234567`. Local `901234567`,
`00998...`, letters, and extensions are rejected (`422`). This validates syntax,
not the existence of a carrier or subscriber. No country is inferred.

`UserRead.email` is now **string or null**, always present. Do not invent placeholder
emails. `verified_phone` (unique, nullable) is the login/recovery identifier;
`phone_verified_at` is nullable UTC timestamp. Legacy `phone` is checkout contact
data; changing/clearing it with `PATCH /auth/me` does not change `verified_phone`.
Do not label an arbitrary contact phone as verified. Verified-phone replacement,
removal, attachment to old email accounts, and account merging are not supported.
Existing contact numbers are not backfilled as authentication identities.

Existing email registration/login/recovery remain supported. Existing users have
`verified_phone: null`. Email-only signup still uses `POST /auth/register` with
`{email,password,full_name?}`; it does not use the new phone signup flow.
Duplicate verified phones give `409 auth.phone_registered`: direct the user to
login/recovery, never create or merge accounts automatically.

## 1. Request phone/password signup

`POST /auth/phone/register/request` (public)

```json
{ "phone": "+998901234567", "password": "example-password", "full_name": "Ali" }
```

Password: at least 8 characters, at most 72 UTF-8 bytes; name optional (1–255
characters when supplied). `202`:

```json
{
  "challenge_id": "2b449fde-2a34-4718-95a7-b8fa26c77078",
  "expires_at": "2026-11-03T08:15:00Z",
  "resend_after_seconds": 60,
  "delivery": "manual_admin"
}
```

No account/session exists yet. Code never appears in a buyer response. Keep the
challenge UUID and show a 6-digit code field. Codes last 15 minutes; resend by
repeating this request with phone/password/name after the cooldown. Each resend
returns a new UUID, invalidates the old code, and replaces pending signup data.
There are at most 3 issued challenges per phone per rolling hour, shared across
signup and recovery, with at least 60 seconds between requests. Successful,
expired, consumed and exhausted challenges count toward issuance quotas.

## 2. Confirm and log in

`POST /auth/phone/register/confirm` (public)

```json
{ "challenge_id": "2b449fde-2a34-4718-95a7-b8fa26c77078", "code": "004219" }
```

`200 UserRead`, for example:

```json
{
  "email": null, "full_name": "Ali", "id": 42,
  "phone": "+998901234567", "verified_phone": "+998901234567",
  "phone_verified_at": "2026-11-03T08:05:00Z", "is_active": true,
  "roles": [], "admin_quick_start_at": null, "seller_quick_start_at": null
}
```

The code is consumed once. Five incorrect guesses exhaust a challenge; a resend
is required. Keep codes as strings, including leading zeros. The guest cart is
merged on successful confirmation and `cart_token` cleared. **Registration does
not sign in**. Next call `POST /auth/login`:

```json
{ "phone": "+998901234567", "password": "example-password" }
```

Or use `{email,password}` for an attached/legacy email. Supply **exactly one**
of `phone` and `email`; neither/both gives `422`. Login passwords are at most
72 UTF-8 bytes. `200 {"message":"Login successful","token_type":"cookie"}`
sets the existing httpOnly `access_token` cookie and merges any guest cart.
Use `GET /auth/me` afterward. Inactive accounts cannot log in or use sessions.

## 3. Recover a phone-only account

`POST /auth/phone/password-reset/request` (public):

```json
{ "phone": "+998901234567" }
```

Same `202 OtpChallengeRead` shape for known, unknown, and inactive numbers;
unknown/inactive accounts produce no deliverable code or staff inbox entry.
Same callback, lifetime, resend and issuance limits as signup. Ask again through
this endpoint to resend; signup is not a recovery mechanism.

`POST /auth/phone/password-reset/confirm` (public):

```json
{
  "challenge_id": "2b449fde-2a34-4718-95a7-b8fa26c77078",
  "code": "004219", "password": "new-example-password"
}
```

Here `password` is the new password (same 8-character/72-byte limits). `200
MessageResponse` consumes the code, changes the password, and revokes **all**
existing sessions, including the caller's. It does not sign in; return to login.
Existing email-based password reset endpoints still work after adding email.

## 4. Optionally add email from the profile

Authentication required; email is never a signup prerequisite.

1. `POST /auth/me/email/request` with `{"email":"ali@example.com"}` → `202
   OtpChallengeRead` with `delivery: "email"`. Email is validated with EmailStr
   and uniqueness follows existing exact stored-email matching. `UserRead.email`
   remains null while pending; pending addresses are not login identifiers.
2. Receive a six-digit email code and call `POST /auth/me/email/confirm` with
   `{challenge_id,code}` → `200 UserRead` with the attached email. Only the same
   authenticated user can confirm. Cookie/password/verified phone stay the same;
   the account may now log in using either identifier and the same password.

Email uses `EMAIL_BACKEND=console` (local logs only) or `smtp` (`SMTP_*`,
`EMAIL_FROM`); real delivery requires a configured SMTP relay. Staff phone inbox
never exposes email codes. Email challenges also expire after 15 minutes and
allow five failed guesses. At most 3 requests per user **and** address per hour,
60-second cooldown; asking for a different pending address replaces the previous
challenge. `409 auth.email_registered` on an existing address, including a race
at confirmation. `409 auth.email_already_set` if email is already attached.
Self-service replacement/removal is unsupported; `PATCH /auth/me` still accepts
only contact phone/name. Never send email there or optimistically update it.

## Errors, localization, and rollout

| Status | Action |
|---|---|
| `400 auth.otp_invalid` | Wrong/expired/used/exhausted code, unknown UUID, wrong purpose/user; show retry/resend |
| `401` | Invalid login credentials or missing/expired/revoked session |
| `409 auth.phone_registered` | Offer login or phone password recovery |
| `409 auth.email_registered` / `auth.email_already_set` | Show conflict; keep existing profile state |
| `422` | Invalid request (phone, identifiers, password, UUID, six ASCII digits); show field errors |
| `429 auth.otp_rate_limited` | Disable resend according to `Retry-After` seconds; hourly quota may require longer than 60 seconds |
| `503 auth.phone_delivery_unavailable` | Phone verification is disabled/unconfigured; show unavailable, not success |

Send `Accept-Language: uz` / `ru` on every call. New coded errors return localized
`detail` plus stable `code`. Existing login/messages may remain English; localize
success UI by action/status. Pydantic custom-validator errors can remain English;
use `loc`/`type` for field UI. Missing/unsupported locale defaults to Uzbek.

Backend rollout: apply migration `b6a2d8e4f901`, restart to seed permissions, set a
strong non-default `SECRET_KEY` and `PHONE_OTP_BACKEND=manual_admin`, and staff the
admin inbox before releasing phone signup. The default is disabled. No SMS/push
provider is wired; production needs a staffed callback process or a future SMS
adapter, HTTPS/secure cookies, and gateway/IP abuse controls. Do not advertise
automated delivery. Downgrading the migration requires resolving null-email
accounts first; no fake emails are generated during upgrade or downgrade.

Generated models: `PhoneSignupRequest`, `PhoneRequest`, `OtpConfirm`,
`PhoneRecoveryConfirm`, `OtpChallengeRead`, `EmailAdditionRequest`, `LoginRequest`,
`UserRead`. Flutter/storefront types must mirror the exported OpenAPI contract.
