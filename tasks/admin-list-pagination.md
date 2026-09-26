---
id: admin-list-pagination
title: Pagination (skip/limit) on admin list endpoints
author: frontend
to: backend
status: closed
priority: high
area: admin
created: 2026-09-15
closed: 2026-09-15
reply_to:
---

## Why

Several admin-panel list pages currently fetch the entire result set on every
load — no page size limit, no offset. That's fine while data volume is low,
but it won't hold up: **Products** and **Orders** in particular are the two
tables expected to grow fastest (every catalog item, every checkout), and an
unbounded `GET` will eventually mean slow admin pages and needless DB/network
load on every filter change.

Two endpoints already support this — `GET /api/v1/admin/sellers` and
`GET /api/v1/users/` both take `skip`/`limit` query params. The endpoints
below don't have the same support yet.

## What the frontend needs

Add `skip`/`limit` query params (same names/semantics as the existing
`/admin/sellers` and `/users/` endpoints) to:

1. **`GET /api/v1/admin/products`** — highest priority, catalog-sized growth.
2. **`GET /api/v1/admin/orders`** — highest priority, grows with every checkout.
3. `GET /api/v1/admin/moderation-queue`
4. `GET /api/v1/admin/refund-requests`
5. `GET /api/v1/admin/payouts`
6. `GET /api/v1/admin/brands`

Items 3–6 are lower volume today (moderation queue and refund disputes are
naturally bounded by admin throughput, payouts/brands even more so) — fine to
sequence after 1–2 if that's easier, but flagging them now so the same
convention lands everywhere instead of half the admin list endpoints
supporting `skip`/`limit` and half not.

Response shape can stay a plain array (matching `/admin/sellers` /
`/users/` today, no pagination envelope) — that's consistent with what the
frontend already handles. If a total-count field is easy to add alongside
that without restructuring the response, it'd let the admin UI show an
accurate "showing N of TOTAL" instead of just "showing N," but this is a
nice-to-have, not a blocker — don't reshape the response just for it.

## What this does NOT need (yet)

- No cursor-based pagination — `skip`/`limit` matching the existing
  convention is enough; don't introduce a second pagination style.
- No server-side sort — these endpoints' existing filter query params
  (`status`, `shop_id`, `category_id`, `buyer_id`, `date_from`/`date_to`,
  `only_flagged`, etc.) are unaffected; just add `skip`/`limit` alongside them.
- No change to the non-admin (seller-facing) equivalents of these
  endpoints — this task is scoped to the admin list surface only.

## Resolution

Done. All six endpoints accept `skip` (default `0`) and `limit` (default `50`),
same semantics as `/admin/sellers` and `/users/`, composing with their existing
filters. Response stays a plain array — no total count was added.

- `GET /admin/products`
- `GET /admin/orders`
- `GET /admin/moderation-queue`
- `GET /admin/refund-requests`
- `GET /admin/payouts`
- `GET /admin/brands`
