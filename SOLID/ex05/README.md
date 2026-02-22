# Exercise 05: Liskov Substitution Principle (LSP)

## Refactoring Goal
Ensure subclasses can be substituted for their base class without breaking the application.

## Changes Made
- **Original Issue**: Different `Exporter` subclasses had inconsistent validation logic, leading to unexpected runtime behavior when switching types.
- **Solution**:
    1.  Established a clear validation "Contract" in the base `Exporter` class via `validateRequest`.
    2.  Standardized error handling so all exporters behave predictably according to the base class agreement.
- **Outcome**: Any exporter subtype can now be used interchangeably without the client needing to know their internal constraints.
