# Exercise 03: Open-Closed Principle (OCP)

## Refactoring Goal
Adhere to OCP: Code should be open for extension but closed for modification.

## Changes Made
- **Original Issue**: `EligibilityEngine` used a long `if-else` chain to check student eligibility. Adding a new rule required modifying the engine's core code.
- **Solution**: 
    1.  Introduced the `EligibilityRule` interface.
    2.  Implemented concrete rules like `GpaRule` and `BacklogRule`.
    3.  The engine now simply iterates over a list of `EligibilityRule` objects.
- **Outcome**: We can now add 100 new eligibility rules without changing a single line in the `EligibilityEngine`.
