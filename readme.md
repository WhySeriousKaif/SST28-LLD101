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

### [singleton-metrics: Singleton Design Pattern](file:///Users/mdkaif/Desktop/SST28-LLD101/singleton-metrics/)
**Focus**: Implementing a robust, thread-safe, and secure Singleton.
- **Goal**: Refactor `MetricsRegistry` to use Double-Checked Locking, protect against Reflection, and ensure Serialization safety.
- **Verification**: Includes scripts for Concurrency, Reflection, and Serialization checks.

### [immutable-tickets: Immutable Classes](file:///Users/mdkaif/Desktop/SST28-LLD101/immutable-tickets/)
**Focus**: Creating robust immutable data structures with the Builder pattern.
- **Goal**: Refactor `IncidentTicket` to be a `final` class with `private final` fields and defensive collection copying.
- **Verification**: Centralized validation in the builder and protection against collection leakage.

---

## 🚀 Newly Added LLD Patterns

### [observer-stock: Observer Pattern](file:///Users/mdkaif/Desktop/SST28-LLD101/observer-stock/)
**Focus**: One-to-many communication dependency.
- **Scenario**: A real-time stock price alert system notifying multiple devices (Mobile, iPad).

### [decorator-coffee: Decorator Pattern](file:///Users/mdkaif/Desktop/SST28-LLD101/decorator-coffee/)
**Focus**: Adding responsibilities dynamically without subclassing.
- **Scenario**: A coffee shop ordering system where add-ons (Milk, Soy) are wrapped around beverages.

### [state-vending: State Pattern](file:///Users/mdkaif/Desktop/SST28-LLD101/state-vending/)
**Focus**: Object behavior changes based on internal state.
- **Scenario**: A vending machine moving through Idle, Inserted Money, and Dispensing states.

### [strategy-pricing: Strategy Pattern](file:///Users/mdkaif/Desktop/SST28-LLD101/strategy-pricing/)
**Focus**: Interchangeable algorithms.
- **Scenario**: A fee calculator that switches between Hourly, Flat, and Weekend pricing.

### [factory-notification: Factory Pattern](file:///Users/mdkaif/Desktop/SST28-LLD101/factory-notification/)
**Focus**: Decoupling object creation.
- **Scenario**: A notification factory creating Email, SMS, and Push notifications.

### [composite-filesystem: Composite Pattern](file:///Users/mdkaif/Desktop/SST28-LLD101/composite-filesystem/)
**Focus**: Uniform treatment of objects and compositions.
- **Scenario**: A file system hierarchy with folders and files.

### [command-editor: Command Pattern](file:///Users/mdkaif/Desktop/SST28-LLD101/command-editor/)
**Focus**: Encapsulating requests as objects.
- **Scenario**: A text editor with undo functionality via command history.

---

## How to Run

To compile and run any exercise, navigate to the `SOLID/` folder and use the following command (replacing `XX` with the exercise number):

```bash
javac exXX/src/*.java && java -cp exXX/src DemoXX
```

Created By - [WhySeriousKaif](https://github.com/WhySeriousKaif/SST28-LLD101)

---

## 🛠️ Git & GitHub Learnings: Resolving Diverged Branches

### What Happened Today?
Our GitHub repository (`origin/main`) and the local repository (`main`) diverged. The same assignment files were added directly to GitHub (perhaps via drag-and-drop or another machine) under the folder `pen_assignment`, while simultaneously being developed locally under `DesignPen/pen_assignment`. 

When attempting to sync them, Git encountered an **add/add merge conflict**. It didn't know which version of the files to prioritize since they were introduced independently on both sides.

### How We Handled It (Step-by-Step Resolution):
1. **Align Local Structure**: First, we moved the local folders to match the GitHub structure to prevent having duplicate folders.
   ```bash
   mv DesignPen/pen_assignment ./pen_assignment
   rmdir DesignPen
   ```
2. **Initiate the Merge**: We pulled the remote branch to initiate a merge, which triggered the conflict warning.
   ```bash
   git merge origin/main
   ```
3. **Resolve Conflicts Favoring Local Code**: Because the local IDE had the most complete and accurate version of the assignments, we told Git to overwrite the conflict using "our" local files.
   ```bash
   git checkout --ours .  # Overwrites conflicted files with the local state
   git add .              # Stages the newly resolved files
   git commit --no-edit   # Finalizes the merge commit automatically
   ```
4. **The Authentication Error**: When running `git push origin main`, we hit `fatal: Authentication failed`. GitHub no longer allows password authentication in the terminal. 
   - **Fix**: You must either use a Personal Access Token (PAT) when it prompts for a password, log in using the GitHub CLI (`gh auth login`), or simply rely on your IDE (like VS Code or IntelliJ) which manages the authorization tokens automatically for you.

---

## 🔥 Essential Git Commands for Real-Life Development

In the real world/industry, you'll be working on teams. Here are the commands you'll use constantly:

### 1. State & History Checks
- `git status`
  *Real-life use*: Run this obsessively before committing to guarantee you aren't accidentally committing a `.env` file or some temporary code.
- `git log --oneline`
  *Real-life use*: Allows you to quickly find the exact commit ID where a bug was introduced.

### 2. Branching (Team Workflows)
You will **never** commit directly to `main` on a real job.
- `git checkout -b feature/user-login`
  *Real-life use*: Creates and switches to a new branch for your specific Jira ticket or task.
- `git branch -D temp-branch`
  *Real-life use*: Deletes a branch forcefully after it has been merged and is just cluttering your UI.

### 3. Syncing & Merging 
- `git pull origin main --rebase`
  *Real-life use*: Fetches the latest code your coworkers wrote and places your unpushed commits *on top* of theirs. This prevents messy merge commits and keeps history strictly linear.
- `git fetch origin`
  *Real-life use*: Updates your machine's knowledge of the remote repository without actually changing any of your local files. 

### 4. Handling Mistakes & Chaos
- `git stash` and `git stash pop`
  *Real-life use*: You are halfway done building a feature, but your PM asks you to fix a critical bug on `main` immediately. You run `git stash` to hide your unfinished work, checkout `main`, fix the bug, then come back to your branch and run `git stash pop` to resume your unfinished work.
- `git merge --abort` or `git rebase --abort`
  *Real-life use*: You try to pull the latest code and get a massive list of merge conflicts that you don't understand. Run this command to completely hit the "undo" button and go back to safety before the merge started.
- `git revert <commit-hash>`
  *Real-life use*: You pushed a commit that broke the production server. Instead of deleting history (which deletes it for your coworkers too), you `revert`, which creates a *new* commit that applies the exact opposite changes to safely roll back the bug.
