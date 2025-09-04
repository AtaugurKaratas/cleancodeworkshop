# 06 — Error Handling & Null

**Motivation:** Magic return codes and nulls hide failure modes. Make contracts explicit with `Optional` and specific exceptions.

## Story
Inventory system must now support reservations that expire (e.g., auto-release after 15 min)

## Risk
The current system uses null and magic return codes (-1, -2) for errors. Adding expiry logic will create ambiguity and fragile error handling.

## Refactoring Goal
Replace ambiguous codes with Optional for absence and explicit exceptions for errors.

## Steps
1) Replace `null`/`-1`/`-2` codes with `Optional` and rich exceptions.
2) Clarify the contract of reserve and release.
3) Add tests for missing/insufficient cases.
4) Implement reservation expiry after refactoring.