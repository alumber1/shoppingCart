# Shopping Cart (TDD Approach)

A simple shopping cart application built using **Test-Driven Development (TDD)** in Java.

The goal is to validate a shopping cart payload and return the correct total via a REST API.

---

## Approach

Development followed the **Red → Green → Refactor** cycle:

1. **Red** – Write a failing test  
2. **Green** – Implement the minimal code to pass  
3. **Refactor** – Improve code while keeping tests green
  
I am focusing on implementing the minimal functionality required to satisfy each test, allowing the design to evolve incrementally.	
---	

## Thought process:

The implementation began with the **core calculation logic**, keeping the design minimal and evolving it through tests.

### Step 1: Basic Calculation

- Create an empty test class  
- Verify an empty shopping cart returns `0.0`  
- Add a test for a single item  
- Add a test for multiple items  

### Step 2: Extend Behaviour

- Add support for item quantities  
- Test single item with quantity > 1  
- Test multiple items with quantities 

---
  	
## Current Implementation

- `ShoppingCart` -> aggregates totals  
- `Item` -> calculates `price × quantity`  

The design starts simple and will evolve as new requirements are introduced.
	
---
	
## Next Steps

- Add validation tests:
 	- Negative price
  	- Zero or negative quantity
- Handle edge cases:
  	- Empty or null inputs
- Extend `Item` to include:
  	- `productId`
 	- `productName`
  	- `currency`
- Introduce API layer:
  	- Accept payload
  	- Validate request
  	- Return total