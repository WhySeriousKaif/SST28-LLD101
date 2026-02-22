# Exercise 02: Single Responsibility Principle (SRP)

## Refactoring Goal
Adhere to SRP by separating business logic, data management, and presentation.

## Changes Made
- **Original Issue**: `CafeteriaSystem` was managing the menu, calculating bills, and generating invoice text.
- **Solution**:
    1.  `Menu`: Encapsulated item pricing and stock management.
    2.  `BillCalculator`: Created a pure logic class for tax and discount calculations.
    3.  `BillFormatter`: Extracted string-formatting logic for the final report.
    4.  `InvoiceStore`: Delegated persistence to a dedicated class.
- **Outcome**: Each class handles a distinct part of the billing process.
