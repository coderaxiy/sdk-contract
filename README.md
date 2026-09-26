# emarketseller SDK Contract

Single source of truth for the emarketseller API: the OpenAPI spec, SDKs
generated from it (TypeScript, Kotlin, Swift), integration docs, and the task
inbox between backend, web frontend, and mobile.

**AI agents: read [AGENTS.md](AGENTS.md) first.** It holds the default rules for
every side.

## Layout

```
AGENTS.md            # rules for every AI agent working with this API (CLAUDE.md imports it)
openapi/
  api.yaml           # exported from the FastAPI backend — never edit by hand
sdk/
  typescript/        # TS types (admin panel, seller website)
  mobile/kotlin/     # Kotlin client (Android)
  mobile/swift/      # Swift client (iOS)
docs/
  api-standards.md   # auth, errors, pagination, money, dates — applies everywhere
  sellers-and-approval-api.md
  products-and-moderation-api.md
  orders-and-payments-api.md
  logistics-and-pickup-points-api.md
tasks/               # requests and notices between backend / frontend / mobile
  README.md          # task format and the open → closed lifecycle
  _TEMPLATE.md
scripts/             # export / validate / generate / task tooling
```

## Workflow (code-first)

The backend is FastAPI, so the spec is generated from the code, not written by hand.

1. Change the backend.
2. `npm run export` — regenerates `openapi/api.yaml` from the backend app.
3. `npm run validate`
4. `npm run gen:all` — regenerates the three SDKs.
5. Update the matching `docs/*-api.md` if behavior changed.
6. Close the task that asked for it (`status: closed`, `closed:` date, `## Resolution`).
7. Commit and push this repo, then the backend.

`npm run export` expects the backend checkout one directory up (this repo lives
at `emarketseller/sdk_contract/`). Elsewhere, set `BACKEND_DIR`:

```bash
BACKEND_DIR=~/code/emarketseller npm run export
```

## Tasks

```bash
npm run tasks                                # open tasks
npm run tasks -- --all                       # every task
npm run task:new -- seller-rating backend    # create tasks/seller-rating.md
npm run tasks:check                          # validate every task's frontmatter
```

Status is `open` or `closed`. See [tasks/README.md](tasks/README.md).

## Quick start

```bash
npm install
npm run export && npm run validate && npm run gen:all
```

Kotlin and Swift generation need a JDK 11+.

## For consumers

How to install and call each SDK, and what to do when told the contract has
updates: [AGENTS.md → Using the SDK](AGENTS.md#using-the-sdk).

- **Everyone:** [docs/api-standards.md](docs/api-standards.md)
- **Admin panel / seller website (TypeScript):** `import type { paths, components } from '<contract>/sdk/typescript'`
- **Android:** `sdk/mobile/kotlin` — Retrofit + coroutines + kotlinx.serialization, package `com.emarketseller.sdk`
- **iOS:** `sdk/mobile/swift` — Swift package `EmarketSellerSDK`, async/await
