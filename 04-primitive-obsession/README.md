# 04 — Primitive Obsession & Data Clumps
**Motivation:** Long parameter lists and primitive bundles cause bugs and misuse. Introduce value objects to capture invariants.

## Scenario 
A new feature requires multi-stop route planning (e.g., Istanbul → Ankara → Izmir → Antalya). Current code passes raw (lat, lon) pairs.

## Risk
Current methods pass raw (lat, lon) doubles everywhere, causing bloated method signatures and potential mix-ups. Extending to multi-stop routes will make this even worse.

## Refactoring Goal
Introduce a GeoPoint value object and a Route class to handle domain behavior cleanly.

## Steps
1) Create GeoPoint with validation for latitude/longitude.
2) Move distance calculation into the value object.
3) Introduce a Route class for multi-stop travel.
4) Add tests for city-to-city distances and route totals.
5) Implement the multi-stop routing feature.
