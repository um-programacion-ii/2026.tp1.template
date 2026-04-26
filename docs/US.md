# User Stories - BiblioTech Project
 
### **Epic 1: Resource Management**
**US 1.1: Item Registration**
* **As a** Librarian, **I want to** register new resources (Physical Books and E-books) **so that** I can keep the catalog updated.
* **Acceptance Criteria:**
    * Must capture: ISBN, title, author, year, and category.
    * The system must distinguish between a physical book and an e-book using polymorphism.
    * Data must be immutable (use of `records`).

**US 1.2: Resource Search**
* **As a** Member/Librarian, **I want to** search for books by title, author, or category **so that** I can quickly find what I need.
* **Acceptance Criteria:**
    * The search must allow filtering by one or multiple simultaneous criteria.
    * If there are no results, an empty `Optional` must be returned (without using `null`).

---

### **Epic 2: Member Management**
**US 2.1: Member Registration with Validation**
* **As a** Librarian, **I want to** register Students and Teachers **so that** they can request loans.
* **Acceptance Criteria:**
    * Validate that the DNI (ID) is unique in the system.
    * Validate that the email has a correct format.
    * Differentiate limits: Students (3 books) and Teachers (5 books).

---

### **Epic 3: Loan Cycle**
**US 3.1: Book Loan**
* **As a** Member, **I want to** request a book **so that** I can borrow it from the library.
* **Acceptance Criteria:**
    * Verify that the book is available.
    * Validate that the member has not exceeded their active loan limit.
    * Throw custom exceptions (e.g., `BookNotAvailableException`) if the rule fails.

**US 3.2: Book Return**
* **As a** Librarian, **I want to** register the return of a book **so that** I can free up the member's quota and the item's availability.
* **Acceptance Criteria:**
    * Automatically calculate if there are overdue days compared to the expected return date.
    * Update the transaction history.