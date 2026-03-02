# Immutable Tickets Solution: HelpLite Incident Tickets

## What was done and how

I have refactored the support ticket system to use immutable objects, ensuring that once a ticket is created, its state cannot be modified. This is critical for audit trails and system consistency.

### 1. Robust Immutability (`IncidentTicket.java`)
- **How I made it immutable**: 
    - Marked the class as `final` to prevent subclassing.
    - Marked all fields as `private final`.
    - Removed all set methods.
    - Added a `private` constructor accessible only via the `Builder`.
- **Collection Protection**: The `tags` list is deep-copied during creation and wrapped in `Collections.unmodifiableList()` when accessed, preventing any external modification.
- **Fluent Builder**: Implemented a nested `Builder` class to handle object construction. This allows for a clean, readable API: `IncidentTicket.builder().id("ID").build()`.
- **Atomic Updates**: Added `toBuilder()` to allow creating "modified" versions of a ticket by returning a completely new instance with the desired changes.

### 2. Centralized Validation (`Validation.java` & `Builder`)
- **What I changed**: Moved all validation logic into the `Builder.build()` method. 
- **Validation Rules**:
    - `id`: Must match pattern `^[A-Z0-9-]+$` and be ≤ 20 chars.
    - `reporterEmail`: Must be a valid email format.
    - `title`: Must be non-blank and ≤ 80 chars.
    - `priority`: Must be one of `LOW`, `MEDIUM`, `HIGH`, `CRITICAL`.
    - `slaMinutes`: If provided, must be between 5 and 7,200.

### 3. Service Refactoring (`TicketService.java`)
- **How I changed it**: Updated the service to stop mutating existing objects. Every operation (`create`, `assign`, `escalate`) now returns a **new instance** of `IncidentTicket`, ensuring the original record remains unchanged.

## How to Verify

1.  **Run the Demo**:
    ```bash
    cd immutable-tickets/src
    javac com/example/tickets/*.java TryIt.java
    java TryIt
    ```
2.  **Observed Results**:
    - **Immutability Check**: `t1 == t2` is `false`. Modifying `t1`'s child (`t2`) does not change `t1`.
    - **Collection Security**: Attempting to add a tag directly to the list results in an `UnsupportedOperationException`.
    - **Validation**: Attempting to build a ticket with an invalid ID or email throws an `IllegalArgumentException`.
