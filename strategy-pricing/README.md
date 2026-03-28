# Strategy Pattern: Pricing Systems

## Overview
The Strategy Pattern defines a family of algorithms, encapsulates each one, and makes them interchangeable. Strategy lets the algorithm vary independently from clients that use it.

## Implementation Details
- **Strategy Interface (`PricingStrategy`)**: Common interface for all pricing algorithms.
- **Concrete Strategies (`HourlyPricing`, `FlatPricing`, `WeekendPricing`)**: Individual implementations of the calculation logic.
- **Context (`FeeCalculator`)**: Maintains a reference to a Strategy object and uses it to perform calculations.
- **Benefits**: Eliminates complex conditional statements (if-else/switch) for selecting algorithms.

## How to Run
```bash
javac src/*.java && java -cp src Demo
```
