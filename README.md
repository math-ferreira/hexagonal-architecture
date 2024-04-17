# Hexagonal Architecture with Java and Spring

This is a base project implementing hexagonal architecture in Java with Spring framework.

## Overview

Hexagonal architecture, also known as ports and adapters architecture, is an architectural pattern used to build applications with a focus on separation of concerns and testability. It emphasizes organizing code around business logic and use cases, independent of external concerns such as UI, database, or external services.

This project demonstrates the application of hexagonal architecture using Java and Spring. It separates the core business logic from external concerns such as controllers, repositories, and infrastructure details.

## Structure

My project structure is organized as follows:

- `src/main/java`: Contains the main Java source code.
    - `com.example.application`: Contains interfaces for external concerns such as REST controllers.
    - `com.example.domain`: Contains domain entities and business logic.
    - `com.example.infrastructure`: Contains infrastructure concerns such as database repositories (H2 memory in this case).
- `src/test/java`: Contains test cases for the application.
- `src/main/resources`: Contains Spring configuration files.

## Dependencies

The project uses the following dependencies:

- Spring Boot: for building and running the application.
- Spring Data JPA: for database access.
- H2 Database: for an in-memory database for testing.
- Spring Web: for RESTful web services.

## Getting Started

To run the application locally, you need Java and Maven installed on your machine. Follow these steps:

1. Clone this repository: `git clone https://github.com/math-ferreira/hexagonal-architecture.git`
2. Navigate to the project directory: `cd hexagonal-architecture`
3. Build the project: `mvn clean install`
4. Run the application: `mvn spring-boot:run`

The application will start and you can access the RESTful endpoints at `http://localhost:8080`.

## Testing

To run the tests, execute the following command:

