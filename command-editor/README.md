# Command Pattern: Text Editor Undo

## Overview
The Command Pattern encapsulates a request as an object, thereby letting you parameterize clients with different requests, queue or log requests, and support undoable operations.

## Implementation Details
- **Command Interface (`Command`)**: Defines `execute()` and `undo()` methods.
- **Receiver (`TextEditor`)**: The object that performs the actual business logic.
- **Concrete Command (`AppendCommand`)**: Binds a receiver and an action, implementing `execute` by calling the receiver.
- **Invoker (`CommandManager`)**: Keeps track of command history and triggers execution and undo operations.
- **Benefits**: Decouples the object that triggers the operation from the one that knows how to perform it. Supports history and queuing.

## How to Run
```bash
javac src/*.java && java -cp src Demo
```
