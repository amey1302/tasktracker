# 🗂️ Task Tracker API

A simple Spring Boot-based REST API to manage tasks — built for tracking daily work, assigning task statuses, and managing task lifecycle efficiently.

---

## 📌 Project Info

- **Version**: 1.0
- **Language**: Java 17
- **Spring Boot Version**: 3.4.4

---

## 🚀 Features

- Create, update, delete, and retrieve tasks
- Enum-based task status: `PENDING`, `IN_PROGRESS`, `COMPLETED`
- RESTful API architecture
- MySQL database integration
- Swagger UI documentation

---

## ⚙️ Tech Stack

- Java 17
- Spring Boot
- Spring Data JPA
- Spring Validation
- MySQL
- Lombok
- SpringDoc OpenAPI (Swagger)

---

## 🧠 Project Structure

com.tasktracker 
    ├── controller 
        # REST endpoints 
    ├── model 
        # Task entity and enums 
    ├── repository 
        # Spring Data JPA interfaces 
    ├── service 
        # Business logic 
    ├── config 
        # Swagger configuration 
└── TaskTrackerApplication.java

---

## 🔗 API Endpoints

Base URL: `/api/v1`

| Method | Endpoint            | Description              |
|--------|---------------------|--------------------------|
| GET    | `/tasks`            | Get all tasks            |
| GET    | `/task/{id}`        | Get a task by ID         |
| POST   | `/task`             | Create a new task        |
| PUT    | `/task/{id}`        | Update an existing task  |
| DELETE | `/task/{id}`        | Delete a task            |

---

## 📖 Swagger UI

Swagger documentation is available at:

http://localhost:8080/swagger-ui/index.html


You can test all API endpoints directly from the Swagger interface.

---

## 🧪 Sample JSON Payload

**POST / PUT:**

```json
{
  "title": "Complete Swagger Integration",
  "description": "Implement Swagger UI using SpringDoc",
  "status": "IN_PROGRESS"
}


```
### 🧾 Enum: Task Status Values
```
PENDING

IN_PROGRESS

COMPLETED
```

#### How to Run the Project
✅ Prerequisites
```
   - Java 17
    
   - Maven
    
   - MySQL
```

#### MySQL Setup
```
CREATE DATABASE tasktracker_db;
```
Update application.properties
```
spring.datasource.url=jdbc:mysql://localhost:3306/tasktracker_db
spring.datasource.username=root
spring.datasource.password=your_password
``` 

### Build and Run

mvn clean install
mvn spring-boot:run

Or run TaskTrackerApplication.java from your IDE.

##  Testing Strategy

All unit tests follow the **AAA pattern (Arrange, Act, Assert)** for clarity and maintainability.

- **Arrange** – Set up the test data and mocks
- **Act** – Perform the action (e.g., call a method or API)
- **Assert** – Verify the result or behavior

Test classes are provided for:
- `TaskController`
- `TaskService`
- `Task` Model (`toString`, Getters/Setters)

### 📊 Code Coverage Report

Below is the summary of code coverage generated using **JaCoCo**:

![Code Coverage](https://github.com/user-attachments/assets/fa7ab923-46c7-454e-af7e-5bc9aee5d3b7)

