# Observer Pattern: Stock Alert System

## Overview
The Observer Pattern defines a one-to-many dependency between objects so that when one object changes state, all its dependents are notified and updated automatically.

## Implementation Details
- **Subject (`StockExchange`)**: Maintains a list of observers and notifies them of price changes.
- **Observer (`MobileDisplay`)**: Receives updates from the subject and displays the new price.
- **Loose Coupling**: The subject doesn't need to know the specific types of observers, only that they implement the `Observer` interface.

## How to Run
```bash
javac src/*.java && java -cp src Demo
```
