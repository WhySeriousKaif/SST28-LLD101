# Exercise 06 · Liskov Substitution Principle (LSP)

Goal: explain everything in beginner-friendly words.

## A. LSP in one sentence

If a class extends another class, the new class must keep every promise made by the original class. Otherwise, code that expects the parent behavior may break.

## B. Setting the stage

- Project: we have different `NotificationSender` types (Email, SMS, WhatsApp).
- Expectation: anything that works with a `NotificationSender` should work no matter which concrete sender we pass in.
- Reality: WhatsApp had a hidden rule about phone numbers, so only that sender failed at runtime.

### What exactly broke?

```java
Notification n = new Notification("Welcome", "Hello", "riya@sst.edu", "9876543210");
NotificationSender wa = new WhatsAppSender(audit);
wa.send(n); // crash: phone must start with + and country code
```

Nothing in `NotificationSender` warned callers about the “+country-code” rule. That missing warning is the LSP break.

## C. Step-by-step fix

1. **Create one shared check**  
   Added `validateDestination(Notification n)` to `NotificationSender`. It makes sure the notification object itself is not null.

2. **Make every sender use the check**  
   Each `send` method calls `validateDestination(n)` before doing any work.

3. **Let special senders add extra checks**  
   `WhatsAppSender` overrides `validateDestination`, calls `super.validateDestination(n)` first, then checks that the phone starts with `+`.

### Code with comments

```java
// NotificationSender.java
protected void validateDestination(Notification n) {
    if (n == null) {
        throw new IllegalArgumentException("Notification cannot be null");
    }
}

// WhatsAppSender.java
@Override
protected void validateDestination(Notification n) {
    super.validateDestination(n); // keep the parent guarantee
    if (n.phone == null || !n.phone.startsWith("+")) {
        throw new IllegalArgumentException("phone must start with + and country code");
    }
}
```

Email and SMS do not need extra checks, so they just inherit the parent version.

## D. What we gained

- **Predictable behavior**: callers know that every sender enforces the same base rules.
- **Clear error**: WhatsApp fails fast with a human-readable message if the phone number is missing the plus sign.
- **Easy future work**: new senders only need to override `validateDestination` if they have extra requirements.

## E. How to explain it to someone else

1. Start with the plain LSP sentence above.
2. Show the old code snippet where WhatsApp crashed.
3. Point out the new `validateDestination` in the parent class.
4. Show the WhatsApp override and emphasize the `super` call.
5. Run `Demo06` so people can see email + sms succeed and WhatsApp fail only when the phone format is wrong.

By the end, even a beginner sees the full story: hidden rule → shared contract → override pattern → reliable behavior. No jargon needed.
