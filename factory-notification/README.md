# Factory Pattern: Notification System

## Overview
The Factory Method Pattern defines an interface for creating an object, but lets subclasses decide which class to instantiate. Factory Method lets a class defer instantiation to subclasses.

## Implementation Details
- **Product Interface (`Notification`)**: Defines the interface of objects the factory creates.
- **Concrete Products (`EmailNotification`, `SMSNotification`, `PushNotification`)**: Individual product implementations.
- **Factory (`NotificationFactory`)**: Contains the logic to decide which product to instantiate based on input criteria.
- **Benefits**: Decouples the client from individual product classes, making it easy to add new products (e.g., Slack notifications) without changing client code.

## How to Run
```bash
javac src/*.java && java -cp src Demo
```
