# Products & Moderation API — Frontend Integration Guide

Backend implementation of `03-products-and-moderation.md`. All paths below are
relative to the API base (`/api/v1`), e.g. `GET /api/v1/seller/products`.

## Auth

Same as the rest of the app: login via `POST /api/v1/auth/login` sets an
**httpOnly cookie** named `access_token`. There is no bearer token to store —
every request from the browser must be made with credentials included
(`fetch(..., { credentials: 'include' })` / `axios.defaults.withCredentials = true`).

- **Admin** endpoints require the `products:moderate` permission on the logged-in
  user's role. A `403` means the user is authenticated but lacks the permission.
- **Seller** endpoints require the logged-in user to have an associated `Seller`
  record (`403 "Not registered as a seller"` otherwise), and additionally check
  that the seller **owns** the shop/product/variant being acted on
  (`403 "You do not own this..."`).
- **Buyer** endpoints are public — no auth required.

## Error shape

Standard FastAPI errors:
- `400` / `403` / `404` → `{"detail": "<message string>"}`
- `422` (request body failed validation) → `{"detail": [{"loc": [...], "msg": "...", "type": "..."}]}`

Treat `400` `detail` strings as user-facing — they're written to be shown
directly to the seller/admin (e.g. "Slug 'x' is already used by another
product in this shop").

---

## 1. Core concepts the UI needs to model

### Product status (state machine)

```
draft ──submit──▶ pending_review ──approve──▶ approved
  ▲                     │                        │
  │                  reject                    delist
  │                     ▼                        ▼
  └──────────────── rejected              delisted ──submit──▶ pending_review
                                                │
          draft/rejected/approved/delisted ──archive──▶ archived (terminal)
```

- `draft` — seller is still editing; not submitted yet.
- `pending_review` — awaiting admin action (reached via submit, resubmit, or
  relist — same `POST /seller/products/{id}/submit` action for all three).
- `approved` — live/visible to buyers.
- `rejected` — admin rejected; `rejection_reason` is set; seller can edit and resubmit.
- `delisted` — seller/admin took it down; not buyer-visible, but the record and
  its variants/attributes are retained. Relisting goes through `pending_review`
  again (no instant-reactivate).
- `archived` — terminal. This is how a seller removes a product, including a
  draft started by mistake or a rejected one they gave up on (there's no hard
  delete; the record keeps its moderation history). Anything but
  `pending_review` can be archived. Hidden everywhere, including the seller's
  default dashboard view (filter these out of the default list and only show
  them via an explicit "Archived" filter).

**Editing a product that's `approved`** may silently flip it back to
`pending_review` if a "sensitive field" (see §4 below) was changed — always
re-read the `status` field from the `PATCH` response rather than assuming the
edit was applied without a status change.

### `has_variants` — a hard fork in the form

- `has_variants: false` → the form must collect `base_price` and
  `stock_quantity` (**required** on create) and optionally `seller_sku`
  directly on the product.
- `has_variants: true` → those fields must be `null`/omitted on the product;
  price/stock/SKU are entered per-variant instead, via the separate variant
  endpoints. A product can't be submitted for review until it has at least one
  **active** variant (deleted ones don't count).

### SKUs: two fields

Every simple product and every variant has two codes:

| Field | Who sets it | Unique | Used for |
|---|---|---|---|
| `platform_sku` | **The platform**, at creation (`PSK-` + 6 characters, e.g. `PSK-8F3K2Q`). Never editable | Platform-wide | Fulfillment: warehouse and pickup-point matching, labels |
| `seller_sku` | The seller, optional free text (1–100 chars) | Within the seller's shop only | The seller's own inventory code, shown on their product and order views |

- **Never send `platform_sku`.** It, and the old `sku` field, are rejected with
  `422` on every product and variant write.
- `seller_sku` is unique across the shop's products **and** variants, deleted
  variants included (they keep it so they can be reactivated): `400 "Your shop
  already uses SKU 'RED-L'"`, or, if a deleted variant holds it, a `400` naming
  the variant to reactivate. Other shops can use the same code.
- `seller_sku: null` on `PATCH` clears it.
- A variant product has `platform_sku: null` and `seller_sku: null` itself;
  its codes are on `variants[]`.

This is enforced server-side (422 on mismatch) — build the create/edit form as
two distinct modes, not one form with optional fields.

### Images

- Upload each image first with `POST /uploads?purpose=product_image` (see
  [media-uploads-api.md](media-uploads-api.md)), then send the returned keys:
  `images: [{ key, sort_order, is_primary }]`. The server rejects keys that
  aren't yours or weren't uploaded as `product_image`.
- The `images` array on `POST` (create) / `PATCH` (update) is the complete
  list — **to keep an existing image, send its `key` again** (it's in every
  `images[]` item of the response). An image whose key is sent again **keeps its
  `id`** (only `sort_order` / `is_primary` change), so reordering doesn't break
  variant `image_ids`. Images left out are deleted, and their ids are removed
  from every variant's `image_ids`.
- The same key can't appear twice in one `images` array (`400`).
- Exactly one image in the array must have `is_primary: true` (only enforced
  when the array is non-empty).
- Omitting `images` entirely on a `PATCH` leaves the current images untouched;
  sending `images: []` clears them.

### Attribute values

- The category's attribute schema comes from the **existing** Doc 02 endpoint:
  `GET /api/v1/seller/categories/{category_id}/attributes` (already live) —
  use this to render the dynamic attribute form (`data_type`, `options` for
  select/multi_select, `is_required`).
- Submit collected values as `attribute_values: [{category_attribute_id, value}]`
  in the product create/update body — same "replace wholesale" semantics as
  images. Required attributes aren't enforced at draft-save time, only at submit
  (`POST /seller/products/{id}/submit` returns 400 listing missing keys by name).

### Changing a product's category

`PATCH /seller/products/{id}` with a new `category_id`:

- If you send `attribute_values` in the same request, they're validated against
  the **new** category's schema.
- If you don't, values whose attribute doesn't exist in the new category are
  dropped; values for attributes the two categories share (e.g. inherited from
  a common parent) are kept. Missing required ones surface at submit, as usual.
- Variant products: the new category must allow variants, and every active
  variant's attribute keys must be variant-defining there, else `400` naming
  the variants — change or delete them first. Deleted variants that don't fit
  can't be reactivated afterwards (`400`).
- Submitting still needs an approved category assignment for the new category.

### Clearing fields

On `PATCH /seller/products/{id}`, an omitted field is unchanged. An explicit
`null` clears `brand_id` ("No brand") and `description`; for other fields
`null` is ignored. Send only the fields the user changed.
- Each `CategoryAttributeRead` (seller and admin attribute endpoints) carries
  `is_variant_defining: boolean`. Attributes flagged `true` are the only keys
  allowed in a **variant's** `attributes` object (e.g. `size`, `color`), so the
  variant builder should offer only those. Any other key is rejected with
  `400 "Variant attribute keys must be variant-defining for this category …"`.
  Everything else is a flat product-level spec (e.g. `material`) and belongs in
  `attribute_values`.
- Admins set the flag per attribute in `PUT /admin/categories/{id}/attributes`
  (`CategoryAttributeIn.is_variant_defining`, default `false`). A variant holds
  one value per key, so a `multi_select` attribute can't be variant-defining
  (`422`).

### Sensitive-field re-review

Admins can configure which fields trigger re-review when edited on an
`approved` product, via `GET`/`PUT /api/v1/admin/moderation-config`
(`{"sensitive_fields": [...]}` — default `["title", "category_id", "brand_id",
"primary_image"]`). This isn't in the original spec doc's endpoint table but is
required for it to be admin-editable at runtime. The frontend doesn't need to
special-case this — just always show the current `status` from the response
after any edit, since it may have changed.

### Moderation flags (advisory only)

Moderation-queue items include a `flags: string[]` array — human-readable
strings describing possible duplicate/counterfeit/price-outlier signals (e.g.
`"Price is more than 5x the category median (120000 UZS)"`). These are
**advisory only** — never block an approval, just surface them prominently in
the admin queue UI (e.g. a warning badge) so the admin can make the final call.

The image flag (`"Primary image matches product #N from a different shop with a
different brand"`) compares perceptual hashes of primary images, so it catches
resized and re-compressed copies of the same photo, but not heavily cropped ones.
It skips products from the same shop, and products that share the **same
non-null** brand (a brand's resellers may use its official photos). Two
unbranded products from different shops with the same photo are flagged.

---

## 2. Admin endpoints

RBAC: `products:moderate` permission required on all of these.

| Method | Path | Body | Notes |
|---|---|---|---|
| GET | `/admin/products` | — | Query: `status`, `shop_id`, `category_id`, `search` (case-insensitive partial match on title, or the `platform_sku` / `seller_sku` of the product or any of its variants), `skip`, `limit` |
| GET | `/admin/products/{product_id}` | — | Full detail incl. variants/images/attribute values |
| GET | `/admin/moderation-queue` | — | Query: `category_id`, `shop_id`, `only_flagged` (bool). Returns `ModerationQueueItemRead[]` — `ProductRead` + `flags`. Flagged items sort first; ties preserve oldest-first order. |
| PATCH | `/admin/products/{product_id}/approve` | — | 400 if not `pending_review`, or if the shop's category assignment is no longer approved |
| PATCH | `/admin/products/{product_id}/reject` | `{reason: string}` | 400 if not `pending_review` |
| PATCH | `/admin/products/{product_id}/delist` | `{reason?: string}` | 400 if not `approved` |
| GET | `/admin/products/{product_id}/moderation-log` | — | Full history: `submitted` / `approved` / `rejected` / `auto_flagged` / `edited_after_approval` entries, each with a JSON `snapshot` |
| GET | `/admin/moderation-config` | — | `{sensitive_fields, updated_at, updated_by}` |
| PUT | `/admin/moderation-config` | `{sensitive_fields: string[]}` | |
| GET | `/admin/brands` | — | Query: `status` (`pending`/`approved`/`rejected`) — use this for a brand-requests review queue |
| PATCH | `/admin/brands/{brand_id}/approve` | — | |
| PATCH | `/admin/brands/{brand_id}/reject` | `{reason: string}` | |

## 3. Seller endpoints

All require an authenticated seller; ownership of the target shop/product/variant
is enforced server-side.

| Method | Path | Body | Notes |
|---|---|---|---|
| POST | `/seller/shops/{shop_id}/products` | `ProductCreate` | Creates as `draft`. 400 if the shop lacks an approved category assignment isn't checked here — only at submit (draft creation is always allowed so the seller can save work in progress) |
| PATCH | `/seller/products/{product_id}` | `ProductUpdate` (all fields optional) | May flip `approved → pending_review` — check the returned `status` |
| POST | `/seller/products/{product_id}/submit` | — | `draft`/`rejected`/`delisted` → `pending_review`. 400 with missing-attribute list, or if category assignment isn't approved, or (variant products) no active variant exists |
| POST | `/seller/products/{product_id}/delist` | `{reason?: string}` | Only from `approved` |
| POST | `/seller/products/{product_id}/archive` | — | From anything but `pending_review` and `archived`; terminal. Use it to remove drafts |
| GET | `/seller/products` | — | Query: `shop_id?`, `status?`. Omit `shop_id` to list across all of the seller's shops |
| GET | `/seller/products/{product_id}` | — | Full detail incl. `rejection_reason` when applicable |
| POST | `/seller/products/{product_id}/variants` | `ProductVariantCreate` | Only on `has_variants=true` products. `platform_sku` is generated. 400 on a `seller_sku` already used in the shop, a duplicate attribute combination, or `image_ids` that aren't this product's images. If a **deleted** variant has the same combination or SKU, the 400 names it: reactivate it instead |
| PATCH | `/seller/variants/{variant_id}` | `ProductVariantUpdate` (all optional) | `is_active: true` reactivates a deleted variant (its keys must still be variant-defining); `false` deletes it. Changing `price` or reactivating may flip the parent product back to `pending_review` if `base_price` is a configured sensitive field |
| DELETE | `/seller/variants/{variant_id}` | — | Soft-delete (`is_active=false`); `204`. The variant keeps its SKUs and combination; `PATCH {is_active: true}` brings it back |
| GET | `/seller/categories` | — | Active **leaf** categories (the only ones products can use). Each has `ancestors: [{ id, slug, translations }]`, root → parent, so the picker can show "Phones › Smartphones" in the user's locale; `[]` for a root leaf |
| GET | `/seller/brands` | — | Approved brands only — populate the brand `<select>` from this |
| POST | `/seller/brands/request` | `BrandRequestCreate` | `{shop_id, name, logo_url?}` — creates a `pending` brand for admin review; 400 if a brand with that name already exists/pending |

## 4. Buyer endpoints (public)

| Method | Path | Notes |
|---|---|---|
| GET | `/products/{product_id}` | 404 unless `status=approved` **and** the owning shop is `active` |
| GET | `/shops/{shop_id}/products` | Same visibility rule; returns `[]` (not 404) if the shop isn't active |

Note: `stock_quantity = 0` does **not** hide a product from these — it stays
visible with zero stock (no "sold out" filtering happens here; that's future
catalog/search doc territory). Show an out-of-stock state in the UI based on
`stock_quantity === 0` (or, for variant products, all variants having
`stock_quantity === 0` / `is_active === false`).

---

## 5. Response shapes (key fields)

### `ProductRead`
```ts
{
  id: number
  shop_id: number
  category_id: number
  brand_id: number | null
  title: string
  slug: string
  description: string | null
  has_variants: boolean
  base_price: string | null      // Decimal, serialized as string — parse before formatting
  stock_quantity: number | null
  platform_sku: string | null    // generated; null on variant products (see variants[])
  seller_sku: string | null
  status: "draft" | "pending_review" | "approved" | "rejected" | "delisted" | "archived"
  rejection_reason: string | null
  needs_attention: boolean
  moderated_by: number | null
  moderated_at: string | null    // ISO timestamp
  created_at: string
  updated_at: string
  images: { id, key, url, sort_order, is_primary }[]   // url is built from key — display only
  variants: ProductVariantRead[]
  attribute_values: { id, category_attribute_id, value }[]
}
```

### `ProductVariantRead`
```ts
{
  id: number
  product_id: number
  platform_sku: string           // generated, immutable, platform-wide unique
  seller_sku: string | null      // the seller's own code, unique within the shop
  price: string                  // Decimal as string
  stock_quantity: number
  is_active: boolean
  attributes: Record<string, string | number | boolean>   // e.g. { size: "L", color: "red" }
  image_ids: number[] | null     // ids from the product's images[]; duplicates removed
  created_at: string
  updated_at: string
}
```

### `BrandRead`
```ts
{ id, name, logo_url, is_verified, status: "pending" | "approved" | "rejected", requested_by_shop_id, created_at }
```

**All `Decimal` money fields (`base_price`, `ProductVariant.price`) are
serialized as JSON strings**, not numbers — this avoids floating-point drift
on UZS amounts. Parse with a decimal-safe library (or `parseFloat` if you're
only displaying, never doing further arithmetic client-side).

---

## 6. Suggested integration order

1. Seller product list/detail pages (`GET /seller/products`, `GET /seller/products/{id}`) — read-only first.
2. Product create/edit form — build the `has_variants` fork and attribute-value
   form using the category's attribute schema (`GET /seller/categories/{id}/attributes`).
3. Submit / delist / archive actions — simple state-transition buttons, disable
   based on current `status`.
4. Variant management (only relevant once `has_variants=true` forms exist).
5. Brand picker + "request new brand" flow.
6. Admin moderation queue + approve/reject/delist + moderation log view.
7. Admin moderation-config editor (low priority — a simple settings page).
8. Buyer-facing product detail / shop storefront pages.
