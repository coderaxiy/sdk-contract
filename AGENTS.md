# Agent rules — emarketseller SDK contract

Every AI agent (backend, web frontend, mobile) working with the emarketseller API
reads this file first. It is the single set of default rules shared by all sides.

## What this repo is

The contract between the emarketseller backend (FastAPI) and its clients
(admin panel, seller website, buyer app, pickup-point staff app). It holds:

| Path | What | Who writes it |
|---|---|---|
| `openapi/api.yaml` | OpenAPI 3.1 spec, **exported from the backend code** | backend (via `npm run export`) — never edit by hand |
| `sdk/` | Generated clients (TypeScript, Kotlin, Swift) | `npm run gen:*` — never edit by hand |
| `docs/` | Integration guides per module + API standards | backend |
| `tasks/` | Requests and notices between backend, frontend, mobile | anyone |

## Default rules

1. **The code is the source of truth, the spec follows it.** The backend is
   code-first: FastAPI generates the spec. Any backend change to a path, request
   body, response schema, query param, status code, or enum must be followed by
   `npm run export && npm run validate && npm run gen:all` in the same change set.
2. **Never hand-edit `openapi/` or `sdk/`.** They are regenerated and your edit
   will be overwritten. Need a contract change? Open a task.
3. **Don't guess the API.** If a field, endpoint, or behavior isn't in
   `openapi/api.yaml` or `docs/`, it doesn't exist. Open a task instead of
   inventing it or working around it on the client.
4. **Follow `docs/api-standards.md`** for auth, error shape, pagination, money,
   and dates. Module-specific rules live in the matching `docs/*-api.md`.
5. **Communicate through `tasks/`, not chat.** Every request, question, reply, or
   breaking-change notice between sides is a task file (see below).
6. **Keep docs current.** A backend change that alters behavior described in
   `docs/` updates that doc in the same commit.

## Tasks workflow

One task = one Markdown file in `tasks/`. Full format: [tasks/README.md](tasks/README.md).

- **Status is `open` or `closed`. Nothing else.**
- A new task — received from the frontend/mobile agent, or created by the backend
  for them — is always created with `status: open`.
- When the work is done, the side that did it sets `status: closed` and fills in
  `closed:` with the date, and appends a `## Resolution` section saying what was
  done (endpoints, fields, commit).
- Don't delete tasks. Closed tasks are the history of why the API looks the way it does.

### At the start of a session

```bash
npm run tasks          # open tasks
```

Pick up the ones addressed to your side (`to:` field). Don't touch tasks addressed
to another side except to reply in a new task.

### Creating a task

```bash
npm run task:new -- <kebab-id> <to: backend|frontend|mobile>
```

Then fill in the body. Be concrete: endpoint, fields, types, current vs expected
behavior, why. A task the other side can act on without asking questions is a
good task.

### Replying to a task

For a short answer, append to the original task. For a long answer or one that
needs decisions, create `<original-id>-reply.md` with `reply_to: <original-id>`.

## "There are new updates in the SDK contract" — check, verify, implement

When you (a frontend or mobile agent) are told the contract has updates, do this
in order.

### 1. Check — pull and see what changed

```bash
git pull                                  # submodule: git submodule update --remote <path>
git log --oneline ORIG_HEAD..HEAD         # commits you just received
git diff --stat ORIG_HEAD..HEAD           # which files changed
npm run tasks                             # open tasks
```

Read, in this order:

1. **Open tasks with `to:` your side** (`frontend` or `mobile`). These are your
   work items.
2. **Changed docs** (`git diff ORIG_HEAD..HEAD -- docs/`). Behavior changes are
   explained here.
3. **Changed spec** (`git diff ORIG_HEAD..HEAD -- openapi/api.yaml`). This is the
   exact list of added/removed/changed endpoints, fields, and enums — including
   changes no task mentions. Every change here can affect your app.

### 2. Verify — before writing code

For each task and each spec change:

- Confirm the endpoint, fields, and types the task describes **match
  `openapi/api.yaml`** and the SDK in `sdk/`. The spec is generated from the
  backend code, so if a task and the spec disagree, the spec is what's running.
- Find every place in your app that uses the changed endpoints/schemas. A removed
  or renamed field breaks the build once you update the SDK — that's the point.
- If something is unclear, contradicts the spec, or is missing: **don't guess.**
  Create a reply task (`reply_to: <id>`, `to: backend`) and move on to the next item.

### 3. Implement

- Update your app's copy of the SDK (pull the repo / bump the submodule), then
  make the changes using the SDK types and clients — never hand-written copies.
  (One exception: the customer storefront; see "Using the SDK → Web".)
- Follow the task and the matching `docs/*-api.md`.
- Build and type-check your app against the new SDK, then run it against a local
  backend (`http://localhost:8000`) for the flows the task touches.

### 4. Close

In the task file: `status: closed`, `closed: <today>`, and a `## Resolution`
section saying what you changed (screens, files, your app's commit). Then
`npm run tasks:check`, commit, and push this repo.

## Using the SDK

Never edit anything in `sdk/`. It's regenerated from the spec on every backend
change. Paths in the SDK include the `/api/v1` prefix, so the base URL is only
the host, e.g. `http://localhost:8000`.

**Auth is an httpOnly cookie (`access_token`) set by `POST /api/v1/auth/login`.**
Every client must store that cookie and send it back — see each platform below.

### Web (TypeScript) — `sdk/typescript`

Types only (generated by `openapi-typescript`). Use them with
[`openapi-fetch`](https://openapi-ts.dev/openapi-fetch/) for fully typed requests:

```ts
import createClient from 'openapi-fetch';
import type { components, paths } from '<contract>/sdk/typescript';

type SellerRead = components['schemas']['SellerRead'];

const api = createClient<paths>({ baseUrl: API_URL, credentials: 'include' });

const { data, error } = await api.GET('/api/v1/seller/me');

await api.PATCH('/api/v1/admin/sellers/{seller_id}/reject', {
  params: { path: { seller_id: 1 } },
  body: { reason: 'Blurry ID' },
});
```

`credentials: 'include'` is what sends the auth cookie.

**Exception: the customer storefront (`coderaxiy/emarket`)** uses hand-written
types that mirror `openapi/api.yaml` (`src/lib/api/types/`, one file per entity,
each naming the schema it mirrors) and one axios client with every path in
`src/lib/api/endpoints.ts`, instead of `sdk/typescript`. That's its owner's
decision: don't switch it to the SDK or flag it as a violation. When the spec
changes, update the matching type file by hand from the spec diff. Everything
else here still applies to it: the spec is the source of truth, no guessing,
`tasks/` for requests. The rest of this section applies to the other web
clients.

### Android (Kotlin) — `sdk/mobile/kotlin`

Retrofit + coroutines + kotlinx.serialization, package `com.emarketseller.sdk`
(`api/`, `model/`, `infrastructure/ApiClient`). Include it as a Gradle composite
build:

```kotlin
// settings.gradle.kts
includeBuild("<contract>/sdk/mobile/kotlin")

// app/build.gradle.kts
dependencies { implementation("com.emarketseller:emarketseller-sdk:0.1.0") }
```

```kotlin
val client = ApiClient(
    baseUrl = API_URL,
    // OkHttp has no cookie jar by default — without one, every call after login is 401.
    okHttpClientBuilder = OkHttpClient.Builder().cookieJar(yourPersistentCookieJar),
)
val sellers = client.createService(SellersApi::class.java)
val me: SellerRead? = sellers.getSellerMeApiV1SellerMeGet().body()
```

The generated methods don't take the `access_token` parameter the spec lists —
the cookie jar sends it. Building needs JDK 17 or 21 (Gradle 8.14 doesn't run on
JDK 26).

### iOS (Swift) — `sdk/mobile/swift`

Swift package `EmarketSellerSDK`, async/await. In Xcode: *File → Add Package
Dependencies → Add Local…* → `<contract>/sdk/mobile/swift`.

```swift
import EmarketSellerSDK

EmarketSellerSDKAPIConfiguration.shared.basePath = apiURL
let me = try await SellersAPI.getSellerMeApiV1SellerMeGet()
```

The client uses a default `URLSession`, which stores the login cookie in
`HTTPCookieStorage.shared` and sends it automatically. Leave the optional
`accessToken:` parameter as `nil`.

### Method names

Kotlin/Swift method names come from the spec's `operationId`, currently
FastAPI's default: `<function>_<path>_<method>`, e.g. `getSellerMeApiV1SellerMeGet`.
Find the one you need by path in `sdk/mobile/*/docs/` or `openapi/api.yaml`.

## Before you commit

```bash
npm run tasks:check    # every task has valid frontmatter and status
npm run validate       # spec lints clean
```
