# Shops API — Frontend Integration Guide

How sellers create and run shops, and how admins review them. All paths are
relative to the API base (`/api/v1`). Schemas: `openapi/api.yaml` → `ShopRead`,
`ShopCreateRequest`, `ShopUpdateRequest`, `ShopStatus`, `SlugAvailabilityRead`,
`CategoryAssignmentRead`, `ShopStaffRead`.

## Auth

- **`/seller/...`** endpoints need a registered seller (`403 "Not registered as
  a seller"` otherwise) and only ever touch the seller's own shops
  (`403 "You do not own this shop"`).
- **`/admin/shops...`** need `sellers:manage`;
  **`/admin/shop-category-assignments...`** need `categories:manage`.

## Error shape

`{"detail": "..."}` for `400`/`403`/`404`/`409`, FastAPI's array for `422`.
`400` and `409` messages are written to be shown to the user as-is.

---

## 1. Core concepts

### Shop status (state machine)

```
                 approve                 suspend
pending_review ───────────▶ active ─────────────▶ suspended
   │    ▲                     │  ◀─────────────────┘
   │    │ submit             │     reactivate
   │    │ (seller)           │ rename (seller)
   │    │                    ▼
   │    └─── rejected   pending_review
   │ reject      ▲
   └─────────────┘

 any status except closed ──close (seller)──▶ closed   (terminal)
```

| Transition | Who | Allowed from | Otherwise |
|---|---|---|---|
| approve | admin | `pending_review`, and the seller must be `active` | `400` |
| reject `{reason}` | admin | `pending_review` | `400` |
| suspend `{reason}` | admin | `active` | `400 "Only active shops can be suspended"` |
| reactivate | admin | `suspended`, and the seller must be `active` | `400` |
| submit | seller | `pending_review` (no change), `rejected` (→ `pending_review`) | `400` |
| rename | seller | `active` → `pending_review` with `status_reason: "name_changed"`; other statuses keep their status | — |
| close | seller | anything but `closed` | `400 "Shop is already closed"` |

Banning a seller suspends all their non-closed shops with
`status_reason: "seller_banned"`. Those can't be reactivated, because a banned
seller is never `active` again.

### What each status means for buyers and money

| Status | Products visible and purchasable | Payouts |
|---|---|---|
| `active` | yes | paid |
| any other | no: public product pages `404`, the shop's list is empty, checkout refuses items already in carts (`400 "Product N is no longer available"`) | held |

Order groups that already exist are unaffected by a status change: a seller
still fulfils them, and refunds still work.

### `status_reason`

`null` for `active` and `pending_review` (unless renamed). Values:

| Value | Set by |
|---|---|
| `name_changed` | seller renamed an `active` shop |
| `seller_initiated` | seller closed the shop |
| `seller_banned` | the seller was banned |
| free text | admin reject / suspend reason — show it as-is |

A resubmitted shop's `status_reason` is cleared.

---

## 2. Seller endpoints

| Method | Path | Body | Notes |
|---|---|---|---|
| POST | `/seller/shops` | `ShopCreateRequest` | `201`. See "Create" |
| GET | `/seller/shops` | — | Own shops, every status |
| GET | `/seller/shops/slug-availability?slug=` | — | `{ slug, available }` — see "Shop address" |
| GET | `/seller/shops/{id}` | — | |
| PATCH | `/seller/shops/{id}` | `ShopUpdateRequest` | See "Update" |
| POST | `/seller/shops/{id}/submit` | — | See "Submit" |
| POST | `/seller/shops/{id}/close` | — | Terminal |
| POST | `/seller/shops/{id}/category-assignments` | `{ category_id, document_ids? }` | See §3 |
| GET | `/seller/shops/{id}/category-assignments` | — | |
| POST | `/seller/shops/{id}/staff` | `{ user_id, role }` | See §4 |
| GET | `/seller/shops/{id}/commission-preview?category_id=` | — | See §5 |

### Create

```json
POST /seller/shops
{ "name": "Toshkent Bozori", "slug": "toshkent-bozori", "description": "…",
  "logo_key": "…", "banner_key": "…", "legal_entity_override": false }
```

- The seller must be `active`: `403 "Seller must be active to create a shop"`.
- **Shop limit:** shops that aren't `closed` count toward `shop_limit` (from
  `GET /seller/me`). At the limit: **`409`** `"Shop limit reached (3). Contact
  support to increase your limit."`
- **Name** is unique platform-wide, case-insensitively, including closed shops:
  `400 "Shop name '…' is already taken"`.
- New shops start in `pending_review` and show up in the admin queue at once.
- `logo_key` / `banner_key` come from `POST /uploads` (see
  `docs/media-uploads-api.md`).
- `slug` and `legal_entity_override` can only be set here. Neither is in
  `ShopUpdateRequest`.

### Shop address (`slug`)

The slug is the shop's URL segment. It's **ASCII only**, whatever script the
name is in. Normalization, which clients can mirror for a live preview:

1. Lowercase.
2. Cyrillic → Latin with this table (Uzbek official mapping; Russian letters included):

   | а | б | в | г | д | е | ё | ж | з | и | й | к | л | м | н | о | п | р | с | т | у | ф | х | ц | ч | ш | щ | ъ | ы | ь | э | ю | я | ў | қ | ғ | ҳ |
   |---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
   | a | b | v | g | d | e | yo | j | z | i | y | k | l | m | n | o | p | r | s | t | u | f | x | ts | ch | sh | sh | – | i | – | e | yu | ya | o | q | g | h |

3. Unicode NFKD, then drop every non-ASCII character (`é` → `e`, `№` → `no`,
   `ʻ` in `oʻ`/`gʻ` → dropped, CJK → dropped), and lowercase again.
4. Drop `'` and `` ` `` (so `Xo'jalik` → `xojalik`).
5. Every run of other characters that aren't `a–z`/`0–9` → one `-`; trim `-` at both ends.

Examples: `Тошкент Бозори` → `toshkent-bozori`, `Gʻalla Oʻzbekiston` →
`galla-ozbekiston`, `Café Déjà-vu` → `cafe-deja-vu`, `Щука & Co.` → `shuka-co`.

Rules:

- **`slug` omitted:** derived from `name`. If taken, `-1`, `-2`… is appended,
  with no error. A name with no letters or digits (`"!!!"`) gives `shop`, `shop-1`…
- **`slug` sent:** normalized as above, then must be free:
  **`409 "Shop address 'my-shop' is already taken"`**. If it normalizes to
  nothing: `400 "A shop address must contain at least one letter or digit"`.
- **Live check:** `GET /seller/shops/slug-availability?slug=My Shop` →
  `{ "slug": "my-shop", "available": true }`. `slug` in the response is the
  value that would be stored; show it. Same `400` for an empty result. Cheap —
  fine to call on debounce. Availability can still change before create, so
  handle the `409` anyway.
- Slugs can't be changed after creation.

### Update

`PATCH /seller/shops/{id}` — only the fields you send change.

| Field | Omitted | `null` | Value |
|---|---|---|---|
| `name` | unchanged | ignored | renamed; `active` → `pending_review` (`name_changed`); `400` if taken by another shop |
| `description` | unchanged | cleared | set |
| `logo_key` | unchanged | **logo removed** | replaced (upload rules apply) |
| `banner_key` | unchanged | **banner removed** | replaced |

**Send only the fields the user changed.** Sending `"logo_key": null` for an
untouched logo removes it. `closed` shops can't be edited (`400`).

### Submit

`POST /seller/shops/{id}/submit`:

- `pending_review`: nothing changes. The shop is already in the admin queue;
  the UI doesn't need a separate "submitted" state.
- `rejected`: back to `pending_review`, `status_reason` cleared. Fix what the
  rejection reason named (edit the shop), then submit. There's no limit on
  resubmissions.
- anything else: `400 "Only shops in pending_review or rejected status can be submitted"`.

### Close

`POST /seller/shops/{id}/close`: `closed`, `status_reason: "seller_initiated"`.
Terminal: there's no reopen. The shop stops counting toward the shop limit, its
products disappear for buyers, and its name and slug stay taken. Existing order
groups still have to be fulfilled. **Its ledger balance isn't paid out**
(payouts only go to `active` shops); see §7.

---

## 3. Category assignments

A shop sells only in leaf categories that an admin has approved for it.

```
                          approve
pending_approval ─────────────────▶ approved ──(category's document rules change)──▶ approved + needs_reverification
      │                                ▲                                                        │
      │ reject                         └──────────── approve (re-verified) ─────────────────────┤
      ▼                                                                                        │ reject
   rejected ◀──────────────────────────────────────────────────────────────────────────────────┘
      │
      └── seller requests the same category again ──▶ pending_approval
```

- **Request** `POST /seller/shops/{id}/category-assignments`
  `{ category_id, document_ids? }`, `201`:
  - the shop must be `active` (`400`);
  - the category must exist (`404`), be active, and be a leaf (the `400`
    lists the sub-categories to use instead);
  - `requires_documents` categories need `document_ids` (the seller's
    document ids from `POST /seller/documents`), otherwise `400` naming the
    required types;
  - an existing `pending_approval` or `approved` assignment:
    `400 "Category already assigned to this shop"`;
  - an existing **`rejected`** assignment is reused: it goes back to
    `pending_approval` with the new `document_ids`, and `rejection_reason` is
    cleared. The response has the same `id` as before.
- **Admin review** (`categories:manage`):

  | Method | Path | Notes |
  |---|---|---|
  | GET | `/admin/shop-category-assignments` | Query: `status`, `shop_id`, `category_id` |
  | PATCH | `/admin/shop-category-assignments/{id}/approve` | |
  | PATCH | `/admin/shop-category-assignments/{id}/reject` | `{ reason }` |

  Approve and reject work on `pending_approval`, and on `approved` with
  `needs_reverification: true`. Otherwise
  `400 "Only pending assignments, or approved ones needing re-verification, can be reviewed"`.
  Approving clears `needs_reverification`.

## 4. Staff

`POST /seller/shops/{id}/staff` `{ user_id, role: "manager" | "staff" }`,
`201 ShopStaffRead`.

- Creating a shop adds the seller as its `owner`. `owner` can't be assigned
  (`400`); there's no ownership transfer.
- Only the shop's own seller can call this today (it's a `/seller/...`
  endpoint scoped to the owner), so managers can't invite yet.
- A user already on the shop: `400`.
- There's no endpoint to list or remove staff yet (§7).

## 5. Commission preview

`GET /seller/shops/{id}/commission-preview?category_id=` →
`CommissionResolutionRead` `{ rule_id, calculation_type, percent,
flat_fee_amount, currency }`: the commission rule that would apply to a sale in
that category from this shop. Show it on the category request screen and in the
product editor once a category is picked.

## 6. Shop-level legal entity (`legal_entity_override`)

`true` means the shop operates under a different legal entity than the seller.
Such a shop can have its own documents (`POST /seller/documents` with
`shop_id`) and bank account (`POST /seller/bank-accounts` with
`owner_type: "shop"`). Both are refused for shops without the flag (see
`docs/sellers-and-approval-api.md`). Neither is required to create or approve the
shop yet. It still counts toward the seller's shop limit. On the create form,
explain it as "this shop belongs to a different company than your seller
account", and leave it off by default.

## 7. Admin endpoints (`sellers:manage`)

| Method | Path | Notes |
|---|---|---|
| GET | `/admin/shops` | Query: `status`, `seller_id`, `category_id`, `skip`, `limit` |
| GET | `/admin/shops/{id}` | |
| PATCH | `/admin/shops/{id}/approve` | Only `pending_review`; seller must be `active` |
| PATCH | `/admin/shops/{id}/reject` | `{ reason }` — only `pending_review` |
| PATCH | `/admin/shops/{id}/suspend` | `{ reason }` — only `active` |
| PATCH | `/admin/shops/{id}/reactivate` | Only `suspended`; seller must be `active` |
| GET | `/admin/audit-log?target_type=Shop&target_id=` | Status history, including `shop.resubmitted` |

Show Approve/Reject only on `pending_review` shops. A shop that went back to
review after a rename or resubmission looks the same as a new one; the audit log
tells them apart.

## 8. Known gaps

- A closed shop's remaining ledger balance is never paid out: payouts skip
  shops that aren't `active`. Needs a product decision.
- No staff list/remove endpoints; inviting an unknown `user_id` fails with `500`.
- Replaced or removed logos and banners aren't deleted from storage.
