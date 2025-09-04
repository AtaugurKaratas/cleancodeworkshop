# 09 — Feature Envy & Mutable Singleton
**Motivation:** “Tell, don’t ask” reduces coupling; global mutable state causes spooky action at a distance.

## Story
Finance requires dynamic tax rates per customer type. Current code fetches global mutable tax from Config.

## Risk
The current billing logic lives outside the customer and uses a mutable global singleton for tax. Extending this will scatter tax logic across the codebase, making it brittle

## Refactoring Goal
Move billing into the Customer domain and replace the mutable global config with an immutable configuration object. then extend for per-type taxes.

## Steps
1) Introduce an immutable `Config` object.
2) Move billing behavior into the `Customer` domain; keep `StatementService` as a thin coordinator.
3) Inject `Config` through constructors.
4) Add tests for tax scenarios.
5) Extend cleanly to support per-customer-type taxes.
