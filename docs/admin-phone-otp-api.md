# Admin website: manual phone OTP inbox

Audience: the company owner/admin/staff website agent. This is not a seller or
buyer feature. Use the existing admin website; no separate panel is required.
All paths below have the `/api/v1` prefix. See [buyer-phone-auth-api.md](buyer-phone-auth-api.md)
for the customer flow and exact request examples.

## Purpose and delivery rule

There is no SMS provider. A buyer requests signup or password recovery; authorized
staff see a pending request, **call the exact submitted phone number**, reveal its
code, and read it to the person who answers. The buyer enters that code in their
own app/site. A reveal does not verify the account or change a password.

Do not give codes to someone who merely quotes the number in chat, calls from a
different number, or supplies account details. That would bypass phone ownership
verification, especially for password recovery. Staff are trusted authentication
operators; this permission allows account takeover if misused. If a callback
cannot be completed, let the request expire. There is no bypass/approve endpoint.

## Authorization and rollout

Cookie login, `credentials: 'include'`; both endpoints require **`auth:otp:read`**.
The permission is seeded on startup for `root` and `admin`. Dispatchers and other
custom staff roles need an explicit grant through the roles API. Do not grant it
to seller/buyer roles or assume all users who can enter the admin website have it.

Deployment steps:

1. Apply backend migration `b6a2d8e4f901` with `alembic upgrade head`.
2. Set a strong, non-default `SECRET_KEY` and `PHONE_OTP_BACKEND=manual_admin`.
3. Restart the API (seeds the permission), grant only designated operators access,
   and release the inbox UI before enabling buyer signup.

Default `PHONE_OTP_BACKEND=disabled` gives `503` for phone flows/inbox. Codes are
short-lived, encrypted at rest using a key derived from `SECRET_KEY`; changing
that key invalidates existing sessions and pending encrypted codes. Configure
HTTPS and production cookies. Public deployment also needs gateway/IP abuse
limits and staffed callbacks; this is manual delivery, not automatic SMS.

## List pending requests

`GET /admin/auth/phone-otps?skip=0&limit=50&phone=%2B998901234567`

`skip >= 0`; `limit` 1–100 (default 50). Optional `phone` filter must be the exact
canonical international number (encode the `+` in the query). Newest first;
plain array, no total. Only live, unused phone requests with attempts remaining
appear. Unknown/inactive recovery accounts and email verification never appear.

```json
[
  {
    "challenge_id": "2b449fde-2a34-4718-95a7-b8fa26c77078",
    "phone": "+998901234567",
    "purpose": "phone_signup",
    "created_at": "2026-11-03T08:00:00Z",
    "expires_at": "2026-11-03T08:15:00Z"
  }
]
```

Purpose is `phone_signup` or `phone_recovery`. The list never contains a code,
password, password hash, email, or account identifier.

## Reveal for a callback

`POST /admin/auth/phone-otps/{challenge_id}/reveal`

```json
{ "reason": "Calling submitted number for signup verification" }
```

Reason is trimmed, 5–500 characters. Successful `200`:

```json
{
  "challenge_id": "2b449fde-2a34-4718-95a7-b8fa26c77078",
  "code": "004219",
  "expires_at": "2026-11-03T08:15:00Z"
}
```

Keep `code` as a string (leading zeros matter). Every successful reveal writes
`auth.otp_revealed` to the existing audit log with actor, internal challenge ID,
purpose, timestamp, and reason. The code itself is excluded from the audit.
Repeated reveals are allowed until expiry/consumption, and each is audited.

Both responses set `Cache-Control: no-store` and `Pragma: no-cache`. Keep revealed
codes in component memory only; exclude them from logs, analytics, persistent
query caches, browser storage, URLs, and notifications. Clear them on navigation,
expiry, signout, or refreshing the queue. Do not prefetch reveals.

## UI implementation and errors

Add a permission-gated “Phone verification” page with phone, purpose, created and
expiry times, a countdown, refresh, pagination, and a reason + explicit reveal
action. Poll the list about every 15–30 seconds while the page is visible, or use
manual refresh. There is no push/WebSocket endpoint. Remove a request when it
expires or disappears; a new resend has a new challenge ID and invalidates the old
code. There is no staff-side resend, approve, confirm, or password-entry action.

- `401`: cookie missing/expired or account inactive; sign in again.
- `403`: permission missing; hide the page/action.
- `400 auth.otp_invalid`: unknown challenge ID at reveal time; refresh the list.
- `404 auth.otp_not_pending`: expired, consumed, exhausted, or non-phone request.
- `422`: invalid UUID, canonical phone filter, pagination, or reason.
- `503 auth.phone_delivery_unavailable`: feature disabled or default secret.

Send `Accept-Language: uz` or `ru`; render localized `detail` and branch on `code`.
Generate types from the contract (`AdminOtpRead`, `OtpRevealRequest`,
`OtpRevealRead`); do not invent endpoints or return codes to buyer-facing APIs.
