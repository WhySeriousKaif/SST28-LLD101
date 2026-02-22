# Exercise 01: Single Responsibility Principle (SRP)

## Refactoring Goal
Adhere to SRP by ensuring each class has only one reason to change.

## Changes Made
- **Original Issue**: The `OnboardingService` was performing multiple duties: parsing input, validating data, generating IDs, saving to a database, and printing results.
- **Solution**: We split the monolithic service into specialized components:
    1.  `UserParser`: Handles string parsing.
    2.  `UserValidator`: Handles email validation.
    3.  `IdGenerator`: Handles unique ID creation.
    4.  `UserRepository`: Handles database interactions.
- **Outcome**: The `OnboardingService` now only coordinates these helpers, making it cleaner and easier to maintain.
