# SOLID Principles Exercises

This folder contains a series of Java exercises (ex01-ex06) designed to demonstrate and practice the application of SOLID principles in software design.

## Repository Structure

Each exercise is located in its own directory (`ex01` through `ex06`) with the following structure:
- `exXX/src/`: Contains the Java source files.
- `exXX/src/DemoXX.java`: The entry point for each exercise.

## Exercises Overview

### [ex01: Single Responsibility Principle (SRP)](file:///Users/mdkaif/Desktop/SST28-LLD101/SOLID/ex01/src/)
**Focus**: Ensuring that a class has only one reason to change.
- **Current State**: Modularized into services for parsing, validation, and printing.
- **Goal**: Full compliance where each component manages exactly one responsibility.

### [ex02: Open-Closed Principle (OCP)](file:///Users/mdkaif/Desktop/SST28-LLD101/SOLID/ex02/src/)
**Focus**: Software entities should be open for extension but closed for modification.
- **Current State**: Uses static rules with conditional logic.
- **Goal**: Refactor using the Strategy Pattern to allow adding new customer types or tax/discount policies without modifying existing code.

### [ex03: Liskov Substitution Principle (LSP)](file:///Users/mdkaif/Desktop/SST28-LLD101/SOLID/ex03/src/)
**Focus**: Objects of a superclass should be replaceable with objects of its subclasses without affecting the correctness of the program.
- **Goal**: Ensure that all eligibility rules adhere to the expected behavior defined by the `EligibilityRule` interface.

### [ex04: Interface Segregation Principle (ISP)](file:///Users/mdkaif/Desktop/SST28-LLD101/SOLID/ex04/src/)
**Focus**: No client should be forced to depend on methods it does not use.
- **Goal**: Verify that room pricing and add-on pricing interfaces are lean and specific.

### [ex05: Dependency Inversion Principle (DIP)](file:///Users/mdkaif/Desktop/SST28-LLD101/SOLID/ex05/src/)
**Focus**: Depend on abstractions, not concretions.
- **Goal**: Ensure the export system uses high-level abstractions (`Exporter`) rather than depending on specific implementations.

### [ex06: Integrated SOLID Principles](file:///Users/mdkaif/Desktop/SST28-LLD101/SOLID/ex06/src/)
**Focus**: A combined application of SOLID principles in a notification system.
- **Goal**: Review and refactor for general design excellence following all five principles.

---

## How to Run

To compile and run any exercise, navigate to the `SOLID/` folder and use the following command (replacing `XX` with the exercise number):

```bash
javac exXX/src/*.java && java -cp exXX/src DemoXX
```
