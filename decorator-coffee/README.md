# Decorator Pattern: Coffee Shop

## Overview
The Decorator Pattern attaches additional responsibilities to an object dynamically. Decorators provide a flexible alternative to subclassing for extending functionality.

## Implementation Details
- **Component (`Beverage`)**: The base abstract class for all drinks.
- **Concrete Component (`Espresso`, `HouseBlend`)**: The base objects to which we add decorators.
- **Decorator (`AddOnDecorator`)**: Wraps a `Beverage` object and adds its own behavior (cost and description).
- **Enforces OCP**: We can add new add-ons (Milk, Soy, Mocha) without changing the `Beverage` or existing concrete classes.

## How to Run
```bash
javac src/*.java && java -cp src Demo
```
