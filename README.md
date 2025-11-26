# Student Management System  
### (Exception Handling, Multithreading, Wrapper Classes)

---

## Overview

This enhanced version of the **Student Management System** focuses on improving safety, reliability, and responsiveness by integrating:

- **Exception Handling**
- **Custom Exceptions**
- **Multithreading**
- **Wrapper Classes**
- **Autoboxing & Unboxing**
- **Input Validation**
- **Loading Simulation using Threads**
- **Robust User Interaction**

The goal is to extend the previous system with stronger error handling and a smoother, more responsive execution flow.

---

## Features

### Exception Handling
- Handles invalid input such as:
  - Marks outside valid range  
  - Empty name, email, or course fields  
  - Non-numeric roll numbers or marks  
- Uses `try-catch-finally` blocks for safe execution  
- Includes custom exception:
  - **StudentNotFoundException**

### Multithreading
- Simulates loading animations when:
  - Adding student records  
  - Updating student data  
  - Saving or loading database-like content  
- Ensures UI responsiveness even during heavier operations.

### Wrapper Classes + Autoboxing
- Uses **Integer**, **Double**, and other wrappers for:
  - Data conversion  
  - Input validation  
  - Type safety  
- Demonstrates **autoboxing and unboxing** during student record operations.

### Improved User Experience
- Clean error messages  
- Responsive user interface  
- Realistic loading visuals through threads  

---

## Project Structure
## EnhancedStudentManagementSystem
- ├── Person.java
- ├── Student.java
- ├── StudentNotFoundException.java
- ├── RecordActions.java
- ├── StudentManager.java
- ├── LoadingThread.java
- └── Main.java

---

## Author

**Name:** Aditya Chouhan  
**Roll No:** 2401830001  
**Course:** B.Sc. (H) Cybersecurity  

---

