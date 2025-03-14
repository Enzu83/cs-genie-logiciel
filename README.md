# Supermarket Checkout System

Project work for CentraleSupélec.

Implementation of a system for managing payment of bought items at a supermarket checkout.

## Implementation Overview

### Bank Package

Contains all classes related to the checkout such as:

- Customers
- Banks
- Credit/Debit Accounts and Cards

### Item Package

Contains all classes related to the shopping cart such as:

- Items
- LineItems
- Price/Weight Visitors

### SupermarketData Package

Contains all classes related to the supermarket particularities such as:

- Pricing policies
- Customer Plans
- Addresses
- Distance Computation

### Main Package

Contains all classes related to the global system of the supermarket such as:

- Cash Register
- SCS Controller

The system is handled by the SCSController class. It is the root of all actions.

## JUnit Tests

The JUnit tests can be found in the same directory as the class they test.

All important and critical methods have tests to validate their implementation.

## Use Cases

They are located in the Main Package.

- Use Case 1: A customer with a credit account fills a shopping cart and successfully makes a payment.
- Use Case 2: A customer with a debit account fills a shopping cart and doesn't have enough money for the payment.