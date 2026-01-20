# HapifyMe Automation Project

This repository contains a **Java-based UI and API automation framework** for the HapifyMe application.  
It is designed as a **portfolio project**, showcasing clean automation architecture and real-world QA practices.

---

## Tech Stack

- **Java**
- **Maven**
- **Selenide** – UI automation
- **Cucumber (BDD)** – UI test scenarios
- **Rest-Assured** – API automation
- **JUnit** – Test execution
- **Awaitility** – Asynchronous polling
- **Jackson** – JSON serialization/deserialization

---

## Project Overview

The project demonstrates both **UI and API automation**, covering realistic end-to-end flows.

### UI Automation
- Login (positive and negative scenarios)
- Registration flows
- Profile interactions
- Page Object Model (POM) implementation
- BDD-style scenarios using Cucumber

### API Automation
- User registration with dynamically generated data
- Email confirmation using polling
- Login and token handling
- Profile retrieval and update
- User deletion and validation

---

## Project Structure

The project is organized to clearly separate **production code**, **test logic**, and **test resources**.

### `src/main/java`
Contains reusable, framework-level code:

- **models** – POJOs used for API request and response mapping  
- **pages** – Page Object Model (POM) classes for UI automation  
- **utils** – Shared utilities such as:
  - configuration handling (`ConfigManager`)
  - UI waits and helpers
  - reusable data helpers

### `src/test/java`
Contains test logic and test-specific support code:

- **api** – API test classes  
  - `UserLifecycleTest` – end-to-end API user flow
- **base** – Shared API test setup  
  - `BaseTest` – initializes a reusable Rest-Assured `RequestSpecification`
    using configuration values from `ConfigManager`
- **ui** – UI automation glue code  
  - **runners** – Cucumber test runners  
  - **stepdefinitions** – Cucumber step implementations
- **utils** – Test-only helper classes  
  - asynchronous polling utilities (e.g. `ApiPoller`)

### `src/test/resources`
Contains test assets and configuration:

- **features** – Cucumber feature files (BDD scenarios)
- **config.properties** – Test configuration values

## How to Run Tests Locally

### Prerequisites
- Java 21
- Maven

To run the entire test suite (UI and API): `mvn clean test`

This command executes all automated UI and API tests configured in the project.

---

## CI Integration (GitHub Actions)

This project is integrated with GitHub Actions for continuous integration.

The CI pipeline is configured to:
- Run automatically on every push and pull request to the main branch
- Build the project using Maven
- Execute the full automated test suite using mvn clean test
- Provide immediate feedback on test execution status

### Successful Pipeline Execution

<img width="1886" height="464" alt="Capture" src="https://github.com/user-attachments/assets/da0ef773-2e51-4132-aac4-565b859e758f" />

## Negative Authentication Scenario (Data-Driven Testing)

This project includes a **negative login test** implemented using a Cucumber `Scenario Outline`.

The scenario runs the same login flow with multiple sets of invalid credentials defined in the `Examples` table.  
Each execution verifies that authentication fails correctly and that the user receives appropriate feedback.

The test ensures that:
- Incorrect email and password combinations do not grant access
- The application displays a consistent error message
- Authentication failure is handled gracefully

This scenario simulates real user behavior and validates both functional and UX aspects of the login process.









