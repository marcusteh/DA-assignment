# Task Manager API

## Overview

The Task Manager API is a backend service built using Spring Boot that provides CRUD operations for managing tasks. It supports task creation, retrieval, updating, deletion, and querying via RESTful endpoints.
The project includes structured exception handling, service-layer abstractions, validation, database persistence with MySQL, API documentation (OpenAPI/Swagger), and a CI/CD pipeline with automated testing and coverage reporting.

## Architecture

1. API Layer:
- api/TasksApi
- Generated from OpenAPI and implemented by controller.

2. Controller Layer:
- controller/TasksApiController.java
- Handles incoming HTTP requests and forwards logic to the Service layer.

3. Service Layer:
- service/TaskService.java
- service/TaskServiceImpl.java
- Contains the main business logic, validation, and task-handling operations.

4. Repository Layer:
- repository/TaskRepository.java
- Uses Spring Data JPA to interact with the MySQL database.

5. Entity Layer:
- entity/TaskEntity.java
- Defines the database structure for tasks.

6. DTO & Model Layer:
- model/Task.java – response model
- model/TaskRequest.java – request DTO
- model/Error.java – error response

7. Mapper Layer:
- mapper/TaskMapper.java
- Handles conversions between Entity,Model and DTO.

8. Exception Handling:
- exception/NotFoundException.java
- exception/GlobalExceptionHandler.java
- All API errors return clean JSON responses.

## Prerequisites
### Technology Stack
- **Java**: 21
- **Framework**: Spring Boot 3.5+
- **Database**: MySQL 8+
- **Build Tool**: Gradle 8+
- **Containerization**: Docker & Docker Compose
- **Version Control**: Git
- **API End point testing**: Postman

## Quick Start
```bash
# Single command to run the entire application
./run.sh
```

## API Documentation
- **OpenAPI Specification**: Available at `/swagger-ui.html` when running
- **Postman Collection**: Import `postman_collection.json` for testing

I generated a Task Manager.postman_collection.json from postman too but is similar to the one already provided.

## Testing
I run all tests and generate coverage with one combined command:
open a terminal cd to the project root location,

### Unit  & Integration Tests
```bash
./gradlew clean test jacocoTestReport
```
Test Coverage Includes:
TaskmanagerApplicationTests.java
Ensures the Spring Boot application context can start properly.

TaskServiceTest.java
Unit tests for the service layer, using mocked repository logic to verify CRUD behaviour and error handling.

This will:
Clean previous builds
Run unit tests (everything under /src/test/java/…)
Produce a Jacoco coverage report

The coverage report will be generated here:
build/reports/jacoco/test/html/index.html

## Database Schema
Describe your database structure and any migration approach used.

The application uses a single main table called tasks, which is mapped directly from the JPA entity TaskEntity.
The entity uses annotations like @Entity, @Table, and @Column to define how the fields should look in the database.
Spring Data JPA automatically handles table creation if spring.jpa.hibernate.ddl-auto is set to update or create.

| Column        | Type                        | Description                                      |
| ------------- | --------------------------- | ------------------------------------------------ |
| `id`          | BIGINT (PK, auto-generated) | Unique identifier for each task                  |
| `title`       | VARCHAR(255), NOT NULL      | Task name/title                                  |
| `description` | VARCHAR(1000)               | Optional longer text                             |
| `completed`   | TINYINT(1), NOT NULL        | Boolean flag (`true` = done, `false` = not done) |
| `created_at`  | TIMESTAMP, NOT NULL         | Auto-assigned when row is first created          |
| `updated_at`  | TIMESTAMP, NOT NULL         | Auto-updated when row is modified                |

1. Migration Approach:
- For now, the project relies on Hibernate auto-generation via: spring.jpa.hibernate.ddl-auto=update
- This means,Tables are created/updated automatically based on your entity.No manual SQL or migration tool is needed during development.

## Observability (if implemented)
- **Metrics**: Available at `/actuator/prometheus`
- **Grafana Dashboard**: Access at `http://localhost:3000`
- **Prometheus**: Access at `http://localhost:9090`

## CI/CD Pipeline

* This project includes a GitHub Actions workflow that will:

- Run on every push to main
- Spin up MySQL as a service
- Wait for MySQL to be ready
- Build the project using Gradle
- Run unit tests + integration tests

- I assume that there's only one branch (main), understanding that not a really good practice, as it should have its own development/feature branch. But in the pipeline we can edit the to add more branches to allow the pipeline to run too:
`on:
  push:
    branches: [ main ]
  pull_request:
    branches: [ main ]
`

## Assumptions Made
- No authentication/authorization (public API).

- All task operations are for a single user context.

- Database always uses MySQL (local or Docker).

- Input is expected to follow the OpenAPI specification.

## Known Limitations
- No user accounts or login system. 
- No authentication/authorization which might allow DDOS / spams
- No soft delete; deleted tasks are removed permanently.
- Search/filtering is minimal. Only through task id
- Error messages are simple — can be improved in future to be more user friendly

## Technology Stack
- Spring Boot 3.5+
- Java 21
- MySQL 8+
- Docker & Docker Compose

## Author
Marcus Teh - [marcusforuni@gmail.com]