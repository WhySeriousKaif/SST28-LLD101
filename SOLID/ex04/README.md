# Exercise 04: Open-Closed Principle (OCP)

## Refactoring Goal
Adhere to OCP using the Strategy Pattern.

## Changes Made
- **Original Issue**: `HostelFeeCalculator` had hardcoded switch statements for room types and add-on pricing.
- **Solution**:
    1.  Created `RoomPriceCalculator` and `AddOnPriceCalculator` interfaces.
    2.  Injected concrete pricing strategies into the calculator.
- **Outcome**: New room categories or pricing models can be added by creating new strategy classes, keeping the core calculator logic "Closed for Modification".
