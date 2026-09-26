---
id: admin-products-orders-search
title: search query param on admin products/orders lists
author: frontend
to: backend
status: open
priority: normal
area: admin
created: 2026-09-15
closed:
reply_to:
---

## Why

Now that `GET /admin/products` and `GET /admin/orders` are paginated
(task `admin-list-pagination`, closed), the admin frontend removed the
client-side text search it used to run against `title`/`sku` (products) and
`order_number` (orders). That search only ever matched within whatever page
was currently loaded — fine when the whole list was fetched at once, actively
wrong once pagination means most rows aren't loaded at all. Rather than ship
something that silently misses matches on other pages, the search boxes were
dropped from both tables.

`GET /api/v1/admin/sellers` already has this exact pattern — a `search` query
param the frontend uses instead of client-side filtering — so this is asking
for the same convention on two more endpoints, not a new one.

## What the frontend needs

1. **`GET /api/v1/admin/products`** — add a `search` query param matching a
   product's `title` and/or `sku` (case-insensitive partial match, same spirit
   as whatever `/admin/sellers`'s `search` already does).
2. **`GET /api/v1/admin/orders`** — add a `search` query param matching
   `order_number` (case-insensitive partial match).

Both should compose normally with the existing filter params and with
`skip`/`limit` — same as every other filter on these two endpoints.

## What this does NOT need (yet)

- No fuzzy/multi-field ranking — a plain `ILIKE`-style partial match (or
  whatever `/admin/sellers` already does) is enough.
- No change to any other endpoint — this is scoped to just these two.
