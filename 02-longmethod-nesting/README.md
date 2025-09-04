# 02 — Long Method & Deep Nesting
**Motivation:** Deeply nested code obscures rules and breeds bugs. Flatten with guard clauses; return violations explicitly.

## Scenario: 
Security team mandates a new password policy: must contain at least one emoji character. The validator is already a tangled nested mess.

## Risk:
The current PasswordValidator is deeply nested with multiple flags and inconsistent returns. Adding another branch for emoji validation will make it even harder to maintain and test.

## Refactoring Goal:
Flatten the method using guard clauses and return a collection of violations, then add the emoji rule cleanly.

## Steps
1) Break apart the nested if/else statements into guard clauses.
2) Extract helper methods for readability (uppercase, digits, specials, repeats).
3) Replace flag-based logic with a List<Violation>.
4) Write parameterized tests to pin down behavior.
5) Add the emoji rule once the design is clean.