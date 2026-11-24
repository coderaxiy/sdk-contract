---
id: frontend-contract-notice-audit
title: Verify older web contract notices against the current clients
author: backend
to: frontend
status: open
priority: normal
area: api-standards
created: 2026-11-24
closed:
reply_to:
---

## What

Review the older open notices against customer web (`emarket`), the seller
portal (`emarket-seller-web`), and the admin portal (`emarket-admin`). For each
notice, use its stated audience and compare the actual client behavior with
[the current OpenAPI](../openapi/api.yaml) and the linked integration guides.
The queue records coordination status. A single matching field, route, or type
is only partial evidence of delivery.

| Notice | Verify in the affected clients |
| --- | --- |
| [Central-store fulfillment](central-store-fulfillment.md) | Buyer pickup-point selection, seller warehouse handoff and allowed actions, and admin receiving/dispatch. Customer web already submits `pickup_point_id`. Verify the complete flow. |
| [Media uploads](media-uploads.md) | Upload and attach object keys for each in-scope field and render URLs returned by the API. |
| [Pickup returns](pickup-returns-notice.md) | Return deadlines, evidence photos, pickup handover, and `returned_to_point` display. |
| [Refund behavior](refunds-all-or-nothing.md) | Full-line refunds, seller and admin actions, escalation and receipt-confirmation states. Review alongside pickup returns. |
| [Product lifecycle](products-lifecycle-notice.md) | SKU mapping, variant reactivation, stable image IDs, archive, category changes, brand clearing, and applicable admin workflows. |
| [Seller and category guards](seller-and-category-guards-notice.md) | Review action guards, variant-defining fields, and shop-level documents and bank-account handling. |
| [Shops](shops-contract-notice.md) | Slug and shop-limit conflicts, image clearing, and rejected shop resubmission. |
| [Storefront APIs](storefront-apis-notice.md) | Public product types, enriched and guest cart behavior, and admin category translation validation. |

## Acceptance

For each notice, record which client was checked, the relevant route or component,
and the outcome of a local check. Add a resolution and close the original notice
when all affected surfaces are verified. For a gap, keep the original notice
open and record the missing client behavior there. Group overlapping returns
and refunds changes where they share a screen. Close this audit after all eight
notices have recorded outcomes.
