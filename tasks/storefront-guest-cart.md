---
id: storefront-guest-cart
title: Guest cart that merges into the buyer's cart on login/register
author: frontend
to: backend
status: closed
priority: normal
area: orders
created: 2026-09-27
closed: 2026-09-27
reply_to:
---

## What

All `/cart` endpoints require login, so a visitor has to register before
pressing "Add to cart". The storefront wants browsing and cart to work
anonymously, with login required only at checkout.

**Ask:** a server-side guest cart identified by a cookie, merged into the user's
cart when they log in or register.

1. **Anonymous `/cart` endpoints.** `GET /cart`, `POST /cart/items`,
   `PATCH /cart/items/{id}` and `DELETE /cart/items/{id}` work without
   `access_token`. On the first anonymous call the server creates a guest cart
   and sets an httpOnly cookie (e.g. `cart_token`, random, not guessable) with the
   same `Secure` / `SameSite` / domain settings as `access_token` and a long
   expiry (e.g. 30 days). When `access_token` is present, the user's cart is used
   as today and `cart_token` is ignored.
2. **Same response shape.** Guest carts return the `CartRead` from
   `storefront-cart-product-info` — no separate schema. (That's why we asked to
   drop `buyer_id` there; if you keep it, make it `number | null`.)
3. **Merge on `POST /auth/login` and `POST /auth/register`.** If the request
   carries a `cart_token`, move its lines into the user's active cart: same
   product + variant → quantities add up, capped at available stock; lines
   that aren't available are moved as-is (they show `available: false`). Then
   delete the guest cart and clear the cookie. The login/register response
   doesn't need to change; the frontend refetches `GET /cart` after a login.
4. **Checkout stays authenticated.** `POST /checkout` with only a `cart_token`
   → `401`, which the storefront turns into "log in to continue" and back to
   checkout afterwards.
5. Expired / abandoned guest carts can be cleaned up by a background job;
   `GET /cart` with an unknown/expired `cart_token` just starts a new one.

The frontend already sends every request with credentials, so no client changes
beyond this are needed. Please document the cookie and merge rules in
docs/orders-and-payments-api.md.

### Alternative we considered

Keeping the guest cart in `localStorage` and replaying it with
`POST /cart/items` after login. We'd rather not: the cart badge and drawer are
server-rendered, localStorage isn't readable there, and a guest cart would still
need an unauthenticated endpoint to fetch product info and current prices for
its lines.

## Why

Requiring an account before "Add to cart" puts sign-up in front of the first
buying decision. With a guest cart, buyers can collect items from several shops
and sign up only when they check out.

## References

- openapi/api.yaml → `/api/v1/cart`, `/api/v1/cart/items`, `/api/v1/auth/login`,
  `/api/v1/auth/register`, `CartRead`
- docs/orders-and-payments-api.md §2, §3.1 (cart endpoints)
- docs/api-standards.md → "Auth" (cookie)
- Depends on: `storefront-cart-product-info`

## Resolution

Implemented as specified. Details: `docs/orders-and-payments-api.md` §3.1 "Guest cart".

- `cart_token` is an httpOnly cookie, 30-day sliding expiry, same `Secure`/`SameSite` as
  `access_token`, re-set on every guest cart response. Only its SHA-256 is stored. An unknown
  token is never adopted: the server issues a new one with a new empty cart.
- With `access_token`, the user's cart is used and `cart_token` ignored. An invalid or expired
  `access_token` is still `401` (never a silent switch to a guest cart).
- Merge on `POST /auth/login` and `POST /auth/register`: quantities add up; every moved line that's
  available is capped at current stock; unavailable lines move as-is. Then the guest cart is
  deleted and the cookie cleared. Response bodies are unchanged.
- `POST /checkout` as a guest → `401`.
- Purge job (hourly): guest carts idle 30 days, and empty guest carts idle 1 day.
