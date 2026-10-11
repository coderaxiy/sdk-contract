---
id: category-content-locales
title: Category translations must be exactly the supported content languages — uz and ru (no en)
author: frontend
to: backend
status: closed
priority: normal
area: categories
created: 2026-10-01
closed: 2026-10-12
reply_to: storefront-apis-notice
---

## What

Product decision (2026-10-01): marketplace content is written in **Uzbek (`uz`) and
Russian (`ru`)**, with no English for now. Every category must carry **exactly one
translation for each of `uz` and `ru`**, no more and no fewer.

Today `CategoryCreate.translations` / `CategoryUpdate.translations` only require
`min_length=1` (`app/modules/categories/schemas.py`) and accept any `locale` string.
Expected on `POST /admin/categories` and `PATCH /admin/categories/{id}` (when
`translations` is sent; omitting it still leaves them alone):

- The set of locales must equal `{uz, ru}`: each present once, non-empty `name`.
  Otherwise `422`, with a message that names the problem, e.g.
  `"translations must include exactly: uz, ru (missing: ru)"` or
  `"unsupported locale: en"`.
- Keep the supported list in one backend setting (e.g. `CONTENT_LOCALES = ["uz", "ru"]`)
  so adding a language later is a config change plus a data backfill, not new code.
- Existing data: categories created earlier may have an `en` translation and/or lack `uz`/`ru`.
  Don't break reads. The admin panel fills the gaps when an admin next edits a category,
  and saving drops the old `en` row (PATCH replaces the whole set). A one-off report or
  migration listing categories missing `uz`/`ru` would help; your call.

**The same rule applies to category attribute labels** (`AttributeTranslationIn` in
`PUT /admin/categories/{id}/attributes`): each attribute carries exactly one non-empty
`label` for `uz` and one for `ru`, with `422` otherwise. The admin attribute editor
already sends exactly these two.

The interface languages also dropped English (product decision, same day). The admin
panel now offers only Uzbek (default) and Russian.

## Why

The admin panel now edits categories with two fixed rows, Oʻzbekcha and Русский, both
required. The first-run wizard asks for both names too. The rule belongs in the backend
as well, so no other client (scripts, a future app) can create a category the storefront
can't show in one of its languages.

## References

- openapi/api.yaml → `CategoryCreate`, `CategoryUpdate`, `TranslationIn`
- emarketseller → `app/modules/categories/schemas.py` (`translations` fields), `service.py` (`replace_translations`)
- emarket-admin → `src/i18n/config.ts` (`CONTENT_LOCALES`), `src/components/react/CategoriesTable.tsx`, `src/components/react/OnboardingWizard.tsx`
- task `storefront-apis-notice` (empty `translations` is already `422`)

## Resolution

Done (backend, 2026-10-12).

- `CONTENT_LOCALES = ["uz", "ru"]` in `app/shared/config.py`; validation in
  `app/modules/categories/schemas.py`.
- `POST /admin/categories`, `PATCH /admin/categories/{id}` (when `translations` is sent) and
  `PUT /admin/categories/{id}/attributes` (per attribute `translations`) return `422` unless
  the set of locales is exactly `uz` + `ru`, each once, with a non-empty `name` / `label`.
  Messages: `translations must include exactly: uz, ru (missing: ru)`,
  `unsupported locale: en`, `duplicate locale: uz`.
- Reads are untouched, so legacy `en` rows and missing `uz`/`ru` still load. No data migration or
  report was added; the admin fills gaps on the next edit as described. Docs:
  `docs/storefront-catalog-api.md`.
