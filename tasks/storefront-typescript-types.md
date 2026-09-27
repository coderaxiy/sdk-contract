---
id: storefront-typescript-types
title: AGENTS.md: note that the storefront uses hand-written TS types, not sdk/typescript
author: frontend
to: backend
status: open
priority: low
area: docs
created: 2026-09-27
closed:
reply_to:
---

## What

`AGENTS.md` → "Implement" and "Using the SDK" say clients must use the generated
SDK types and clients, "never hand-written copies". The customer storefront
(`coderaxiy/emarket`) follows its owner's agent guide instead: hand-written
types in `src/lib/api/types/` (one file per entity, each noting the schema it
mirrors, cross-checked against `openapi/api.yaml`) and a single axios client
with every path in `src/lib/api/endpoints.ts`. That's the owner's decision and
won't change.

The conflict matters because every agent reads `AGENTS.md` first: an agent
working on the storefront could "fix" it by switching to `sdk/typescript`, or
flag it as a rule violation.

**Ask:** add a short exception to `AGENTS.md` under "Using the SDK → Web
(TypeScript)", something like:

> The customer storefront (`coderaxiy/emarket`) uses hand-written types that
> mirror `openapi/api.yaml` instead of `sdk/typescript`. When the spec changes,
> update the matching file in `src/lib/api/types/` by hand. The rest of this
> section applies to the other web clients.

The rest of the workflow still applies to the storefront: the spec is the
source of truth, no guessing, `tasks/` for requests. When the storefront pulls
contract updates, it reads the spec diff and updates its types by hand.

No API change.

## Why

Keep the shared rulebook true for every client, so agents on either side don't
act on a rule the storefront doesn't follow.

## References

- AGENTS.md → "3. Implement", "Using the SDK → Web (TypeScript)"
