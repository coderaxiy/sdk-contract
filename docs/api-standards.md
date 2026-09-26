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
- Login sets an **httpOnly cookie** named `access_token`. There's no token to
  store on the web — send every request with credentials included
  (`fetch(url, { credentials: 'include' })` / `axios.defaults.withCredentials = true`).
- Admin endpoints are gated by **permissions** on the user's role
  (`sellers:manage`, `products:moderate`, `orders:manage`, `finance:manage`,
  `logistics:manage`, ...). Each module guide says which one it needs.
- Seller endpoints (`/seller/...`) additionally need a registered seller, and
  check that the seller owns the shop/product/order being touched.

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

- Lists return a **plain JSON array** — no envelope, no total count.
- Paginated lists take `skip` (default `0`) and `limit` (default `50`).
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
