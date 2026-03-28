# Composite Pattern: File System

## Overview
The Composite Pattern allows you to compose objects into tree structures to represent part-whole hierarchies. Composite lets clients treat individual objects and compositions of objects uniformly.

## Implementation Details
- **Component Interface (`FileSystemComponent`)**: The base interface for both files and directories.
- **Leaf (`File`)**: Represents individual objects (files) that have no children.
- **Composite (`Directory`)**: Represents containers that can hold both files and other directories.
- **Recursive Traversal**: The `showDetails` method recursively calls children, allowing us to process the entire tree structure through the root component.

## How to Run
```bash
javac src/*.java && java -cp src Demo
```
