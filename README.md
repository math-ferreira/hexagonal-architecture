# Hexagonal Architecture with Java and Spring

This is a base project implementing hexagonal architecture in Java with Spring framework.

## Overview

Hexagonal architecture, also known as ports and adapters architecture, is an architectural pattern used to build applications with a focus on separation of concerns and testability. It emphasizes organizing code around business logic and use cases, independent of external concerns such as UI, database, or external services.

This project demonstrates the application of hexagonal architecture using Java and Spring. It separates the core business logic from external concerns such as controllers, repositories, and infrastructure details.

## Structure

The project is designed to be modular, with each module representing a different approach using hexagonal architecture. Each module can be found in separate branches.
You can switch between branches to explore different approaches and implementations.

## Documentation

The API documentation is available using Swagger UI. After running the application locally, you can access the Swagger UI at `http://localhost:8080/swagger-ui.html`.

## Modules

### [hexagonal-architecture-v1]([hexagonal-architecture-v1](hexagonal-architecture-v1))

This module contains a simple project to start studying hexagonal architecture. It provides a basic implementation with minimal dependencies and functionality.

### [hexagonal-architecture-v2]([hexagonal-architecture-v2](hexagonal-architecture-v2))

This module contains a more complex project demonstrating a full-fledged implementation of hexagonal architecture. It includes multiple layers, such as adapters, application, domain, and infrastructure, and showcases various design patterns and best practices.

## References

- [Hexagonal Architecture](https://alistair.cockburn.us/hexagonal-architecture/)
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [H2 Database](https://www.h2database.com/html/main.html)
- [Spring Web](https://spring.io/guides/gs/spring-boot/)
- [Swagger](https://swagger.io/)

## Authors

- Matheus Ferreira


## Contributions

Contributions are welcome! If you have any ideas for improvements or new features, feel free to open an issue or submit a pull request.
