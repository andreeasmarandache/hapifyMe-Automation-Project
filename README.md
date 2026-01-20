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
