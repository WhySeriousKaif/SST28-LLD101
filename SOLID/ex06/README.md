# Exercise 06: Liskov Substitution Principle (LSP)

## Refactoring Goal
Adhere to LSP by consistent validation and contract enforcement.

## Changes Made
- **Original Issue**: `WhatsAppSender` had unique destination constraints that weren't represented in the base `NotificationSender` contract, causing "subtype surprises".
- **Solution**:
    1.  Introduced `validateDestination` in the base class.
    2.  Refined the hierarchy so each sender explicitly handles its specific constraints within the base contract.
- **Outcome**: The client can send notifications via any sender without worrying about format-specific failures.
