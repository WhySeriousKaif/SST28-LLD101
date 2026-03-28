# State Pattern: Vending Machine

## Overview
The State Pattern allows an object to alter its behavior when its internal state changes. The object will appear to change its class.

## Implementation Details
- **Context (`VendingMachine`)**: The main interface for customers. It maintains a reference to the current state.
- **State Interface (`State`)**: Defines the common interface for all possible concrete states.
- **Concrete States (`IdleState`, `InsertedMoneyState`, `DispensingState`)**: Each implements the behavior associated with its particular state.
- **Encapsulation**: State-specific logic is encapsulated within individual classes, avoiding large `switch` or `if-else` blocks in the context class.

## How to Run
```bash
javac src/*.java && java -cp src Demo
```
