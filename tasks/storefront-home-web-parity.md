---
id: storefront-home-web-parity
title: Implement shared sales-focused home and campaign UX on the web storefront
author: mobile
to: frontend
status: open
priority: high
area: storefront
created: 2026-11-03
closed:
reply_to:
---

## Feature brief and ownership

Upgrade the customer storefront home into a shopping discovery page and add campaign landing pages. This is the durable shared UX brief for the Astro web agent and Flutter mobile agent. Preserve each platform's existing navigation, colors, fonts and theme tokens. The reference is page structure and shopping behavior, not Uzum branding or a pixel copy.

Web repo: `/Users/halilullohahmad/Desktop/emarket` (`coderaxiy/emarket`). Current entry points: `src/pages/index.astro`, `src/components/CategoryTiles.astro`, `src/components/ProductCard.astro`, `src/components/ProductRail.astro`. Mobile reference: `lib/features/catalog/presentation/home_page.dart`.

Backend dependency: `tasks/storefront-home-merchandising.md`. All merchandising paths/schemas there are proposed. Integrate only after the exported contract exists; do not invent requests, fake promotions, or local admin configuration. This task stays open until the web implementation is verified.

## Shared home hierarchy

1. Existing app/site header with a prominent search entry. Keep current menu/tab navigation. Do not add a city selector or camera search without working underlying features.
2. Wide campaign banner carousel immediately below the header/search. Every banner is an entry into its own campaign landing page, not directly into an unrelated product or generic catalog. Use admin artwork, sequence, localized accessible title and campaign destination.
3. Compact image category shortcut grid under the carousel. Artwork above a localized label, whole tile tappable. Use admin-selected categories/order when provided; before merchandising exists, use nonempty catalog roots in `sort_order`, then id order. Missing/broken artwork uses the existing category icon placeholder. Link through existing category slugs.
4. Optional admin-curated discount sections, in server order: localized heading + view-all action + horizontal product rail. Show only nonempty active sections. No discount data means no discount heading, colored empty container, or placeholder promotion.
5. Product discovery grid below promotional content: curated recommendations when supported; otherwise an honestly labeled new-arrivals feed (`sort=newest`), never mislabeled personalized recommendations. Two columns on phones, additional columns at larger widths. Products, imagery, price and title take priority over explanatory marketing text.
6. Optional ordinary category rails after the main discovery feed. Remove repeated items from these fallback rails where practical and hide rails too short to be useful. Move the existing welcome hero and three-step explanation out of prime shopping space; help can live below shopping content or in an existing help destination.

There is no required financing strip, food/quick-delivery tab, card promotion or repeated advertising banner. Those screenshot details are separate features, not part of this request.

## Banner interaction and layout

- Horizontal swipe on touch; keyboard-operable previous/next and labeled position controls on web. No autoplay for the first implementation. One banner renders as a static linked image without carousel controls; zero banners collapses the region completely.
- Keep banner aspect ratio reserved during loading to prevent layout shifts. Use mobile/desktop crops from the contract; never crop required copy out of artwork. Broken artwork retains a readable campaign title/link so navigation still works.
- On web use actual campaign anchors with a stable proposed route `/campaigns/{slug}` (finalize alongside the backend contract); open in the same tab, preserve locale. Support direct linking, refresh, browser back and restoring home scroll/carousel position.
- Category shortcuts target two compact rows on phones (typically four or five columns depending on available label width). At larger font sizes reduce columns and allow readable labels. Show at most ten home shortcuts plus a visible catalog/view-all link; desktop may use a wider grid. Do not hide category navigation behind a horizontal chip rail.

## Campaign landing page hierarchy

1. Back affordance to the previous location and a close/home action. Browser back must remain natural; direct visits have a safe home fallback. Mobile can use its native navigation stack. Keep the surrounding platform navigation consistent.
2. Campaign hero artwork and a real text title; localized short intro if supplied.
3. Optional campaign category shortcuts. Selecting one follows the declared category destination; section-jump shortcuts must be a separate typed target if supported. Never silently invent filtering semantics.
4. Admin-ordered product sections with headings and view-all destinations. Horizontal rails for small curated groups; a section's view-all page shows a paginated product grid. Optional server-authored informational blocks render only supported safe content types. Not every campaign is necessarily a discount event.
5. Product taps use the existing shop/product slug route. Returning restores campaign scroll. View-all stays within the selected campaign section and paginates in server order, avoiding duplicate or skipped cards.

No active campaign/404: localized unavailable state with home/catalog links. A network failure has a retry state and must not masquerade as an expired campaign. An empty campaign keeps valid artwork/title/intro and shows a localized empty-products message without an empty rail.

## Product cards and commerce

Reuse the existing card and product/variant/cart flow. Required shared content is image, current authoritative price (range where necessary), up to two lines of title, and availability. Show original price/discount only with supported backend fields; no ratings, reviews, delivery date, installment amounts or authenticity claims without authoritative data.

A commerce CTA may add a simple in-stock product using its valid variant id; products needing option selection must open the existing option flow. Disable duplicate pending adds, handle stock/error feedback, and keep guest cart behavior. Until such a CTA can use the existing valid flow, the whole card opens product details; do not add a decorative nonfunctional bag button. Keep wishlist behavior only if implemented.

## Locale, accessibility and responsive behavior

Offer Uzbek and Russian. Dynamic campaign/category content falls back from Russian to Uzbek, then a safe slug/title placeholder; do not default missing Russian marketing copy to English. Match translation-key names across clients. Format money with existing locale formatters and use semantic theme tokens in light/dark modes.

Same section ordering, content, eligibility, destinations, card price semantics and empty-state behavior on mobile and web. Responsive density may differ: phone product grid two columns, tablet three, desktop four to six within the existing max-width container. Aim for identical information architecture, not identical physical pixels.

Provide semantic headings, image alt text, keyboard focus, accessible carousel position labels, touch targets at least 44 logical pixels, and readable scaled text. Respect reduced motion. Rail scrolling must not trap vertical page scrolling; bottom navigation must not cover content.

## Loading, failure and refresh

Fetch independent content concurrently and avoid one request per category just to populate the first screen. Use bounded preview sizes; paginate the main discovery grid. Reserve skeleton space only for requested sections, then remove absent optional sections. A failed promo request must not suppress working categories/products. A failed main product feed gets a localized retry action; empty catalog gets a real empty state and catalog navigation.

Flutter pull-to-refresh awaits visible requests; web refresh/revalidation follows the existing Astro data strategy. Refetch expired campaign/discount data according to the backend cache policy. Never display stale savings as guaranteed checkout prices.

## Delivery sequence and acceptance

Phase A, available APIs: image category grid, product-first discovery grid, remove the oversized welcome/instructions from the top. Keep promotions absent until contract support lands. Phase B: shared home merchandising, campaign route and paginated section view-all, published discount card fields. Phase C: visual comparison on both platforms with the same backend fixtures/locales.

Verify zero/one/many banners; click/swipe/keyboard behavior; category order and navigation; admin section ordering; no promos; valid/empty/expired campaign; deep-link refresh and back scroll restoration; pagination; product navigation; guest cart/variant handling when CTAs are included; independent request failures/retry; Russian-to-Uzbek fallback; broken images; light/dark; narrow screens and enlarged text. Include screenshots for home top, home products, and campaign landing page at phone and desktop widths, with a shared fixture identifying the campaign and product ids.

Report implemented files, exact contract schemas, checks and remaining limitations in this task's Resolution. Coordinate any difference from this hierarchy through a reply task so web and mobile do not diverge.

## Mobile Phase A implementation reference — 2026-11-04

The Flutter home now uses a fixed app-bar search entry, up to ten image category shortcuts in `sort_order` then id order (nonempty roots only), and a lazy paginated newest-products grid. Welcome/how-it-works content and automatically generated category rails have been removed from home. Categories and products load independently; each failed request can be retried. Pull-to-refresh awaits both requests. Existing bottom navigation and product/category routes are preserved.

The discovery heading remains the existing `home.newArrivals` key until a real recommendation feed exists. The pagination fallback button introduces `common.loadMore`: English `Load more`, Uzbek `Yana yuklash`, Russian `Загрузить ещё`. Mirror this key on web. Automatic pagination starts near the end of the feed; a button remains available if the initial content does not fill the viewport.

Source: `lib/features/catalog/presentation/home_page.dart`; coverage: `test/features/catalog/home_page_test.dart`. Campaign banners, campaign landing pages, discount sections and discount pricing remain dependent on the backend task above. No proposed merchandising endpoint is called by this mobile phase.
