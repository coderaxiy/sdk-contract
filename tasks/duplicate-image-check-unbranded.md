---
id: duplicate-image-check-unbranded
title: Duplicate-image moderation flag never fires for unbranded products
author: backend
to: backend
status: open
priority: normal
area: products
created: 2026-09-27
closed:
reply_to:
---

## What

`ProductService.run_duplicate_check` skips a candidate when
`candidate.brand_id == product.brand_id`. When both products have no brand,
`None == None` is true, so two **unbranded** listings from different shops that
use the same photo are never flagged. That's the most common stolen-photo case.

The image comparison itself now works (hashes within 10 bits count as the same
picture — a resized, re-compressed copy measured 2 bits apart).

## Decision needed

What the same-brand exclusion is for: if it's "a brand's own resellers may
share official photos", the rule should only skip when both products have the
**same non-null** brand. Proposed:

```python
if candidate.shop_id == product.shop_id:
    continue
if product.brand_id is not None and candidate.brand_id == product.brand_id:
    continue
```

## References

- Backend: `app/modules/products/service.py` → `run_duplicate_check`
- `docs/products-and-moderation-api.md` → Moderation flags
