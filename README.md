# Hexagonal Architecture with Java and Spring

This is a base project implementing hexagonal architecture in Java with Spring framework.

## Overview

Hexagonal architecture, also known as ports and adapters architecture, is an architectural pattern used to build applications with a focus on separation of concerns and testability. It emphasizes organizing code around business logic and use cases, independent of external concerns such as UI, database, or external services.

This project demonstrates the application of hexagonal architecture using Java and Spring. It separates the core business logic from external concerns such as controllers, repositories, and infrastructure details.

## Structure

The project is designed to be modular, with each module representing a different approach using hexagonal architecture. Each module can be found in separate branches.
You can switch between branches to explore different approaches and implementations.

## Contributions

Contributions are welcome! If you have any ideas for improvements or new features, feel free to open an issue or submit a pull request.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
```
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

