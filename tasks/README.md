# Tasks

The inbox between backend, web frontend, and mobile. Need an API change, have a
question, or need to tell the other side something changed? Create a task here —
not a chat message.

One task = one `.md` file, named after its `id`.

## Task or no task?

| What | How |
|---|---|
| New endpoint, new/changed fields, type change, new behavior | Task to `backend` |
| Backend changed behavior clients depend on (breaking change, relaxed validation, new required field) | Task from `backend` to `frontend` / `mobile` |
| Question about how an endpoint behaves | Task — the answer becomes documentation |
| Typo in a doc | Just fix it |

## Creating one

```bash
npm run task:new -- seller-rating backend
```

This copies `_TEMPLATE.md` to `tasks/seller-rating.md` with `id`, `to`, `status: open`,
and today's date filled in. Write the body, then commit and push.

## Format

```markdown
---
id: seller-rating            # kebab-case, same as the file name
title: Add seller rating to GET /seller/me
author: frontend             # who created it: backend | frontend | mobile | a name
to: backend                  # who has to act: backend | frontend | mobile
status: open                 # open | closed
priority: normal             # low | normal | high
area: sellers                # module: auth, sellers, shops, products, orders, logistics, ...
created: 2026-09-26
closed:                      # date, filled in when status becomes closed
reply_to:                    # optional: id of the task this answers
---

## What
Endpoint, fields, types.

## Why
Short context.

## References
openapi/api.yaml → SellerRead, docs/sellers-api.md §2
```

## Status

There are only two statuses:

- **`open`** — created, not done yet. Every task starts here.
- **`closed`** — done. The side that did the work sets it, fills in `closed:`, and
  adds a `## Resolution` section at the end describing what was done.

A task that turns out to be unnecessary is also `closed`, with a Resolution that
says why.

## Commands

```bash
npm run tasks            # open tasks
npm run tasks -- --all   # every task, including closed
npm run tasks:check      # validate frontmatter of every task
```
