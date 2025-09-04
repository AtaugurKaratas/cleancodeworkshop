# 08 — Library CLI (Group / Mob)
**Motivation:** Mixed I/O and logic make code untestable. Separate concerns and invert I/O.

## Steps
1) Run `Main` to observe behavior. Identify mixed I/O and domain.
2) 
3) Add tests for domain behavior (no console), then for integration.

## Story
The librarians want to build a web UI for the library features.

## Risk
All functionality is currently inside the CLI main method, mixed with I/O. Copying this logic into a web controller would duplicate bugs.

## Refactoring Goal
Extract a pure Library domain model and leave I/O handling to adapters.

## Steps
1) Observe current CLI behavior. Run `Main` to observe behavior. Identify mixed I/O and domain.
2) Create a Library class containing domain logic.
3) Refactor the CLI to call into Library. Extract pure `Library` domain; add an I/O interface (`Console`); keep `Main` trivial.
4) Add tests for domain operations.
5) Build a web controller on top of the clean design.