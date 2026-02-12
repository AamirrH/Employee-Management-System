---

# Employee Management System

A **backend-only Employee Management System** built using **Spring Web MVC** and an **H2 embedded database**.
This project focuses on **core Spring MVC concepts**, layered architecture, validation, exception handling, and clean API design.

---

## 🚀 Key Features

* REST-style employee management APIs
* Centralized **global exception handling**
* Custom domain-specific exceptions
* Input validation using annotations
* Custom validation annotation for employee roles
* Partial updates using **PATCH**
* Reflection-based field updates
* Proper HTTP status codes using `ResponseEntity`
* Clean separation of controller, service, and persistence layers
* In-memory H2 database for easy setup

---

## 🛠 Tech Stack

* **Java**
* **Spring Web MVC**
* **H2 Embedded Database**
* **Maven**
* **Apache Tomcat**
* **Lombok**
* **ModelMapper**

---

## 🔁 API Endpoints

| Method | Endpoint          | Description                      |
| ------ | ----------------- | -------------------------------- |
| POST   | `/employees`      | Create a new employee            |
| GET    | `/allemployees`   | Retrieve all employees           |
| GET    | `/employees/{id}` | Retrieve employee by ID          |
| PUT    | `/employees/{id}` | Update full employee details     |
| PATCH  | `/employees/{id}` | Partially update employee fields |
| DELETE | `/employees/{id}` | Delete an employee               |

---

## 🧠 Backend Concepts Implemented

### Global Exception Handling

* Centralized error handling using `@ControllerAdvice`
* Custom `ResourceNotFoundException`
* Clean, consistent error responses

### Input Validation

* Standard validation annotations (`@NotNull`, `@Size`, etc.)
* **Custom `@EmployeeRole` annotation** for domain-specific validation
* Validation errors mapped to meaningful HTTP responses

### Partial Updates (PATCH)

* Supports updating only selected fields
* Uses **Java Reflection** to dynamically update fields
* Prevents overwriting unchanged data

### Response Customization

* Uses `ResponseEntity` to return:

  * Proper HTTP status codes
  * Clear success and error messages

---

## 🧱 Architecture

The project follows a **layered Spring MVC architecture**:

* **Controller Layer**

  * Handles HTTP requests
  * Defines endpoint mappings
  * Delegates logic to services

* **Service Layer**

  * Contains business logic
  * Handles validation and transformations
  * Coordinates between controller and persistence layers

* **Persistence Layer**

  * Responsible for database interactions
  * Encapsulates data access logic

* **DTO & Model Layer**

  * DTOs for API contracts
  * Models represent domain entities
  * Mapping handled using ModelMapper

---

## 🗄 Database

* **H2 In-Memory Database**
* Automatically configured at runtime
* No external database required
* Data resets on application restart

### H2 Console

```
http://localhost:8080/h2-console
JDBC URL: jdbc:h2:mem:testdb
Username: sa
Password:
```

---

## ⚙️ Running the Application

### Prerequisites

* Java 8+
* Maven

### Steps

```bash
git clone https://github.com/your-username/employee-management-system.git
cd employee-management-system
mvn clean install
```

Deploy the generated WAR file on Tomcat or run directly from your IDE.

---

## 📂 Project Structure

```
src/main/java
 └── com.example.employeemanagement
     ├── controller
     ├── service
     ├── repository
     ├── exception
     ├── validation
     ├── dto
     └── model
```

---

## 🎯 Learning Objectives

* Master **Spring Web MVC** fundamentals
* Understand request lifecycle and mappings
* Design clean REST-style APIs
* Implement validation and error handling correctly
* Use reflection safely for partial updates
* Build backend systems without heavy abstractions

---

## 🔮 Future Enhancements

* Pagination and sorting
* API documentation (Swagger / OpenAPI)
* Logging and monitoring
* Authentication and authorization
* Migration to an external database

---


Say the word 😄
