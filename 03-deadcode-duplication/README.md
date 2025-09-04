# 03 — Dead Code & Duplication
**Motivation:** Dead/commented code steals attention; duplication multiplies bugs. Centralize shared logic and delete the rest.

## Scenario 
Compliance requires storing user role changes with audit trail. Current UserRepository has duplicated and inconsistent CSV handling.

## Risk:
The current repository code has duplicated file-write logic, inconsistent CSV delimiters, and commented-out dead code. Adding auditing now will only worsen the duplication.

## Refactoring Goal
Unify file format handling in a single utility and remove dead code before extending functionality.

## Steps
1) Delete commented-out and unreachable code.
2) Centralize CSV parsing and formatting logic.
3) Make error handling explicit (no silent catches).
4) Add tests to pin current behavior.
5) Extend to include role-change auditing.
