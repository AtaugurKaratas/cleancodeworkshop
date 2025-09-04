# 01 — Naming & Magic Numbers
**Motivation:** Cryptic names & unexplained numbers hide intent and create bugs when rules change. Make business rules explicit.

## Story:
Marketing has requested support for a new “Gold Partner” customer type with its own discount rules.

## Risk:
The current calculator uses cryptic integer type codes (1, 2, 3, …) and magic numbers for discounts and thresholds. Adding another if/else branch would bury business rules deeper into unreadable spaghetti, making future changes even harder.

## Refactoring Goal:
Introduce a CustomerType enum and descriptive constants so that adding a new type is a clean, isolated change.

## Steps:

1) Identify existing customer type codes and magic numbers.
2) Replace them with named constants and an enum.
3) Separate discount, shipping, and tax into focused methods.
4) Write tests to ensure behavior is unchanged.
5) After refactoring, add the “Gold Partner” type cleanly.

