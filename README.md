## Overview

This project is a microservice-based bank backend application designed to handle the various operations of a banking system in a modular, scalable way. Each core function of the bank—such as accounts, cards, and loans—is managed by its own dedicated microservice. This architecture ensures that each service is self-contained, independent, and easy to maintain or scale as needed.

### Microservice Architecture

1. **Accounts Microservice**: Responsible for managing all operations related to customer accounts. This microservice is responsible for:
   - **Creating account details**: Setting up new bank accounts in the system.
   - **Fetching account details**: Retrieving information for existing accounts.
   - **Updating account details**: Modifying details like balance, customer information, or account status.
   - **Deleting account details**: Removing accounts from the system.

2. **Cards Microservice**: Handles all card-related functionalities within the bank, enabling a dedicated system for managing debit or credit cards. Key endpoints include:
   - **Creating card details**: Adding new cards to an account.
   - **Fetching card details**: Accessing existing card information, such as balance, card type, or status.
   - **Updating card details**: Adjusting card information, including limits or expiration.
   - **Deleting card details**: Removing cards from the system.

3. **Loans Microservice**: Manages the loan processing functionalities for customers, providing:
   - **Creating loan details**: Initiating and recording loan applications.
   - **Fetching loan details**: Retrieving information about existing loans (e.g., loan balance, interest rate).
   - **Updating loan details**: Altering loan terms or repayment details.
   - **Deleting loan details**: Removing loans from the database.

### Profile Configurations

The system also incorporates environment-specific profiles, which allow the application to operate differently based on the deployment stage. This ensures that the appropriate configurations are applied in various environments:

- **Production Configuration**: Settings optimized for performance, security, and real-time operations, ensuring the stability and safety of the live banking environment.
  
- **Development Configuration**: Tailored for developers working on enhancements or new features. This environment often includes debugging tools, local databases, and less stringent security measures.

- **Testing Configuration**: Provides an isolated environment to test the application before deployment, ensuring that bugs or vulnerabilities are caught early.

In development mode, the application uses an **H2-database** for ease of setup and local testing, which simulates the production database without the overhead of managing a complex relational database during the development phase.
