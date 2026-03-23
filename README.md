# Shopping Cart (TDD Approach)

A simple shopping cart application built using Test-Driven Development (TDD) in Java with Spring Boot.

The application exposes a REST API that accepts a shopping cart payload and returns the grand total, with validation and rounding applied.

---

## Overview

This project demonstrates:

- Test-Driven Development (TDD)
- REST API design and validation
- Clean separation between domain and API layers
- Basic UI integration
- CI automation using Jenkins

---

## Approach (TDD)

Development followed the Red → Green → Refactor cycle:

1. Red – Write a failing test
2. Green – Implement the minimal code to pass
3. Refactor – Improve the design while keeping tests green

The focus was on incremental development, allowing the design to evolve naturally through tests.

---

## Thought Process

### Step 1: Core Calculation Logic

- Verify empty cart returns 0.0
- Add support for a single item
- Add support for multiple items

### Step 2: Extend Behaviour

- Add item quantities
- Handle multiple items with quantities
- Ensure correct aggregation of totals

### Step 3: Edge Cases and Validation

- Handle negative price (invalid)
- Handle zero or negative quantity (ignored)
- Default missing values (for example currency to GBP)

### Step 4: API Layer

- Accept JSON payload via REST endpoint
- Validate incoming requests
- Return calculated total with metadata

---

## Architecture

### Domain Layer

- ShoppingCart
  - Aggregates items
  - Calculates total (rounded to 2 decimal places)

- Item
  - Represents a product
  - Calculates price multiplied by quantity

---

### API Layer

- ShoppingCartController
  - Exposes /api/cart/total endpoint
  - Handles request and response mapping

- ShoppingCartRequest / ShoppingCartResponse
  - Encapsulate API payloads

---

### UI Layer (Basic)

A simple static UI is included:

- Located in: /resources/static/index.html
- Allows triggering the API from a browser
- Displays the returned grand total

This is intentionally minimal and acts as a proof of concept.

---

## Testing Strategy

### 1. Domain Tests

ShoppingCartHappyPathTest
ShoppingCartCartIdTest
ShoppingCartCurrencyTest
ShoppingCartProductNameTest
ShoppingCartTimestampTest
ShoppingCartUserIdTest
ShoppingCartValidationTest

### 2. Validation Tests

Covers:

- Negative prices
- Missing or invalid fields
- Default values

---

### 3. API Tests

ShoppingCartControllerTest using MockMvc

Covers:

- Valid payload gives correct total
- Empty cart returns 0.0
- Invalid JSON returns 400 Bad Request
- Negative price returns 400 Bad Request
- Missing currency defaults correctly
- Missing timestamp is handled gracefully

---

## CI/CD (Jenkins)

A Jenkins pipeline is set up using Docker:

- Runs tests automatically
- Validates build on each run
- Provides test execution feedback

### Features:

- Maven build integration
- Automated test execution
- Console output for debugging failures

---

## Running the Application

### Run Locally

1. Start the Spring Boot application
2. Open browser:
   http://localhost:8080/

---

### Run Tests

Using Maven:

mvn clean test

---

### Run via Jenkins

1. Start Jenkins container
2. Open Jenkins UI
3. Run the configured job
4. View test results in console output

---

## Future Improvements

- Add Selenium UI tests
- Improve UI (React or similar)
- Support multiple currencies
- Add performance testing
- Introduce logging and monitoring
- Extend validation with detailed error responses

---

## Summary

This project demonstrates:

- Strong TDD practices
- Clear test coverage across layers
- Practical API validation
- Basic UI integration
- Working CI pipeline with Jenkins

---