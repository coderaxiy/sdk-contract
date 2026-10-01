# API Standards

Conventions every emarketseller endpoint follows. Module guides (`docs/*-api.md`)
only document where a module deviates from this.

Backend: FastAPI (Python) + PostgreSQL. The OpenAPI spec is generated from the
code — see [AGENTS.md](../AGENTS.md) for the workflow.

## Base URL

All paths are under `/api/v1`, e.g. `GET /api/v1/seller/me`. Local dev:
`http://localhost:8000`. Live interactive docs: `http://localhost:8000/docs`.

## Auth

- `POST /auth/register`, `POST /auth/login`, `POST /auth/logout`, `GET /auth/me`.
- **Account self-service** (any logged-in user):
  - `PATCH /auth/me` — `{ full_name?, phone? }` → `UserRead`. Send only what changes; `phone: null`
    clears the saved number (`phone` is on `UserRead`, `null` by default, 5–30 chars). Both are trimmed.
    Email can't be changed here.
  - `POST /auth/me/password` — `{ current_password, new_password }`. `400` with a message
    (`"Current password is incorrect"`, or the new one equals the old); `422` if `new_password` is
    shorter than 8 characters or longer than 72 bytes. On success **every other session is signed out**
    (their next request gets `401 "Session expired — log in again"`) and the response sets a fresh
    `access_token` cookie, so the current session carries on. Registering has no length rule yet.
  - `PATCH /users/{id}` and `POST /users/{id}/password` are **admin** endpoints (`users:manage`);
    an admin setting a password also signs that user's sessions out.
- **Forgotten password** (public, no login):
  1. `POST /auth/password-reset/request` — `{ email }` → always `202 { message }`, whether or not the
     account exists (no account enumeration). If it does, a **6-digit code** is emailed (Uzbek, Russian and
     English in one message), valid for **15 minutes**. At most 3 codes per account per hour; asking again
     replaces the previous code.
  2. `POST /auth/password-reset/confirm` — `{ email, code, new_password }` → `200 { message }`. Show an
     input for the code (there is no link, so **no deep-link handling** is needed). `400 "Invalid or expired
     code"` for a wrong, expired or used code, and for a code guessed wrong 5 times (request a new one).
     `422` for a malformed code (not 6 digits) or a short password (same rule as `POST /auth/me/password`).
     Success signs out every session of that user; it does **not** log in, so send them to the login screen.
  Email is sent through `EMAIL_BACKEND`: `console` (default, logs the message at WARNING, local dev only)
  or `smtp` (`SMTP_*` and `EMAIL_FROM` in `.env`). Production needs an SMTP relay before this works for real users.
- **Session lifetime.** The `access_token` cookie is a JWT that lasts **7 days from login**
  (`Max-Age=604800`, so it is a *persistent* cookie, not a session cookie: it survives closing the
  browser and restarting an app, as long as the client's cookie store keeps persistent cookies). The
  lifetime is **fixed, not sliding** — using the app does not extend it — and there is **no refresh
  endpoint**. After 7 days any request returns `401` and the client sends the user to login. Other
  ways a session ends: `POST /auth/logout` (clears the cookie on that client only; the JWT itself is not
  revoked) and a password change (see above). Cookie flags: `HttpOnly`, `SameSite=Lax` by default,
  `Secure` in production.
- Login sets an **httpOnly cookie** named `access_token`. There's no token to
  store on the web — send every request with credentials included
  (`fetch(url, { credentials: 'include' })` / `axios.defaults.withCredentials = true`).
- Admin endpoints are gated by **permissions** on the user's role
  (`sellers:manage`, `products:moderate`, `orders:manage`, `finance:manage`,
  `logistics:manage`, ...). Each module guide says which one it needs.
- Seller endpoints (`/seller/...`) additionally need a registered seller, and
  check that the seller owns the shop/product/order being touched.
- **Public (no login):** the storefront catalog — `GET /products`,
  `/products/facets`, `/products/{id}`, `/shops/{id}/products`,
  `/shops/by-slug/...`, `/categories`, `/categories/{id}/attributes`, `/brands`
  (see [storefront-catalog-api.md](storefront-catalog-api.md)) — plus
  `GET /pickup-points/nearby`.
- **The cart works logged out too** (`/cart`, `/cart/items...`): without
  `access_token` the server uses a guest cart identified by a second httpOnly
  cookie, `cart_token`, and merges it on login/register. Details in
  [orders-and-payments-api.md](orders-and-payments-api.md) §3.1.

| Status | Meaning |
|---|---|
| `401` | Not logged in / cookie expired → send to login |
| `403` | Logged in but not allowed (missing permission, not a seller, not the owner) |

## Errors

Standard FastAPI shape:

```json
// 400 / 401 / 403 / 404
{ "detail": "Only active sellers can be suspended" }

// 422 — request failed validation
{ "detail": [{ "loc": ["body", "tax_id"], "msg": "Field required", "type": "missing" }] }
```

`400` `detail` strings are written for humans — show them to the user as-is.
Exceptions that return a structured `detail` object are documented in their
module guide (e.g. checkout price mismatch in `orders-and-payments-api.md`).

## Paths and IDs

- Role prefixes: `/admin/...` (admin panel), `/seller/...` (seller website),
  `/pickup-staff/...` (pickup-point app); buyer and public endpoints have no prefix.
- IDs are integers.
- State changes are `PATCH` on an action path:
  `PATCH /admin/sellers/{seller_id}/approve`. Actions that need a reason take
  `{"reason": "..."}`.

## Lists and pagination

- Lists return a **plain JSON array** — no envelope, no total count in the body.
- Paginated lists take `skip` (default `0`) and `limit` (default `50`).
- Where a list reports a total, it's the `X-Total-Count` response header
  (exposed to CORS). Currently only `GET /products`.
- Filters are query params and compose with each other and with `skip`/`limit`.
- Admin lists that support text search take `search`.

## Money

`Decimal` fields (prices, totals, amounts) are serialized as **strings**, e.g.
`"125000.00"`. Parse with a decimal-safe library before doing math; never
compare them as floats. Coordinates use the same convention.

## Dates

ISO 8601 strings with timezone, UTC: `"2026-09-26T08:51:00Z"`. Nullable
timestamps (`verified_at`, `reviewed_at`, ...) are `null` until the event happens.

## Files

Files are uploaded once with `POST /uploads` and then referenced by **key**
(`logo_key`, `images[].key`, `file_key`, ...). Responses add a URL built from
each key for display. Send keys back, never URLs. Details:
[media-uploads-api.md](media-uploads-api.md).

## Enums

Lowercase snake_case strings (`pending_review`, `sole_proprietor`). New values can
be added — clients should render an unknown value gracefully instead of crashing.
