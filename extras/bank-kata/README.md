# 🏦 Bank Kata (Dirty Version)

This is the **dirty starting point** for the Bank Kata exercise.  
Your task: **refactor** this codebase before adding new features.

---

## Story
The company is rolling out a simple **retail banking system** that supports:
- Depositing money
- Withdrawing money
- Printing account statements (transaction history with running balance)

A new requirement has arrived:
> *“Statements must also be exportable for compliance checks and formatted for both PDF and CSV.”*

---

## Risk
The existing code is tangled:
- Business logic, formatting, and persistence are mixed in one class.
- Transactions are stored as raw strings.
- Duplicated logic for CSV statements.
- `System.out.println` everywhere makes testing difficult.

Adding new formats (CSV, PDF, etc.) will **duplicate bugs** and make changes risky.

---

## Refactoring Goal
Refactor the code to follow clean code principles:
- Extract domain objects like `Transaction`.
- Separate statement printing into its own class.
- Keep business logic separate from formatting logic.

---

## Steps
1. Write unit tests to lock current behavior.
2. Introduce a `Transaction` object instead of raw strings.
3. Create a `TransactionRepository` to handle storage.
4. Extract a `StatementPrinter` for printing logic.
5. Update `Account` to delegate responsibilities.
6. After refactoring, add the new **CSV export** feature safely.

---

Happy refactoring 🚀
