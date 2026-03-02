# Singleton Refactoring Solution: Metrics Registry

## What was done and how

I have refactored the `MetricsRegistry` to ensure it follows the strict Singleton pattern, protecting it against concurrency, reflection, and serialization issues.

### 1. Robust Singleton Implementation (`MetricsRegistry.java`)
- **How I made it thread-safe**: I used **Double-Checked Locking** with the `volatile` keyword. The `volatile` keyword ensures that the instance is fully initialized before any other thread can access it, preventing "half-baked" objects.
- **How I blocked reflection**: I added a check inside the **private constructor**. If `INSTANCE != null` when the constructor is called, it throws a `RuntimeException`. This stops anyone from using `setAccessible(true)` to create a second instance.
- **How I handled serialization**: I implemented the `readResolve()` method. During deserialization, Java calls this method; I programmed it to return the existing `getInstance()`, ensuring the deserialized object is exactly the same as the current global instance.

### 2. Global Integration (`MetricsLoader.java`)
- **What I changed**: I replaced the direct instantiation (`new MetricsRegistry()`) with `MetricsRegistry.getInstance()`. This ensures that when the properties file is loaded, it populates the same global registry used by the rest of the application.

### 3. Execution Fix (`App.java`)
- **What I fixed**: I updated the file path logic for `metrics.properties` to be more robust, allowing the application to run correctly regardless of whether it's executed from the project root or the `src` folder.

### 1. Refactored `MetricsRegistry`

The following enhancements were made to ensure it is a true Singleton:

- **Private Constructor**: Changed the constructor from `public` to `private` to prevent external instantiation.
- **Double-Checked Locking (DCL)**: Implemented `getInstance()` with Double-Checked Locking. This ensures thread-safety while keeping performance high by avoiding synchronization once the instance is initialized.
- **Volatile Instance Variable**: Marked the `INSTANCE` variable as `volatile`. This is critical for DCL to ensure that changes to the instance are visible across threads and to prevent instruction reordering that could lead to "half-baked" objects.
- **Reflection Protection**: Added a check in the constructor to throw a `RuntimeException` if an instance already exists, effectively blocking reflection attacks.
- **Serialization Safety**: Implemented the `readResolve()` method to ensure that deserialization returns the same singleton instance instead of creating a new one.

### 2. Updated `MetricsLoader`

- Modified the `loadFromFile` method to use `MetricsRegistry.getInstance()` instead of `new MetricsRegistry()`. This ensures all parts of the application share the same global registry.

## How to Verify

1.  **Concurrency Check**:
    ```bash
    cd singleton-metrics/src
    java com.example.metrics.ConcurrencyCheck
    ```
    *Observed: Only one instance created across multiple threads.*

2.  **Reflection Attack Check**:
    ```bash
    java com.example.metrics.ReflectionAttack
    ```
    *Observed: Throws `java.lang.RuntimeException: Use getInstance() method...` as expected.*

3.  **Serialization Check**:
    ```bash
    java com.example.metrics.SerializationCheck
    ```
    *Observed: `Same object? true`.*

4.  **Main Application**:
    ```bash
    java com.example.metrics.App
    ```
    *Observed: Metrics loaded and displayed correctly using the Singleton instance.*
