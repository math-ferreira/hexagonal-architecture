# Bookstore Project - DDD + Hexagonal Arch.

This project is a demonstration of the implementation of a bookstore application using Domain-Driven Design (DDD) principles and the Hexagonal Architecture pattern. It aims to provide a flexible and maintainable structure for building scalable and testable software applications.

## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Architecture Overview](#architecture-overview)
- [Project Structure](#project-structure)
- [Technologies Used](#technologies-used)
- [Setup and Installation](#setup-and-installation)
- [Usage](#usage)
- [Testing](#testing)
- [Contributing](#contributing)
- [License](#license)

## Introduction

The Bookstore Project is a Java application that simulates the operations of a bookstore, including managing books, authors, customers, and sales transactions. It follows best practices in software development, including separation of concerns, encapsulation, and modularity.

## Features

- Registering and managing books, authors, and customers
- Handling sales transactions and book exchanges
- Validating user input and enforcing business rules
- Providing a clear separation of concerns between application layers
- Using Domain-Driven Design principles to model business entities and behavior
- Implementing the Hexagonal Architecture pattern for modularity and flexibility

## Architecture Overview

The project follows the Hexagonal Architecture pattern, which consists of three main layers: the domain layer, the application layer, and the adapter layer.

1. **Domain Layer**: Contains the core domain models, entities, and business logic. It encapsulates the behavior and rules of the application.

2. **Application Layer**: Implements the application's use cases and orchestrates interactions between the domain layer and the outside world. It defines interfaces for use cases and services.

3. **Adapter Layer**: Contains adapters that connect the application to external systems, such as databases, user interfaces, and third-party services. Adapters handle input/output operations and translate between the application's internal model and external formats.

## Project Structure

The project follows a hexagonal architecture, also known as Ports and Adapters architecture, which emphasizes a clear separation between the domain logic and external concerns such as databases, user interfaces, and third-party services.

- **Adapter Layer**: Contains implementations of interfaces defined in the application layer. This layer adapts external interfaces to the application's use cases.
  - **Persistence**: Contains implementations of repositories using Spring Data JPA.
    - `AccountSpringDataJpaRepository.java`: Implementation of the `AccountRepository` using Spring Data JPA.
    - `BookSpringDataJpaRepository.java`: Implementation of the `BookRepository` using Spring Data JPA.
  - **Mapper**: Contains mapper classes responsible for mapping domain objects to entity objects and vice versa.
    - `AccountMapper.java`: Mapper class for mapping `Account` domain objects to `AccountEntity` entities and vice versa.
    - `AuthorMapper.java`: Mapper class for mapping `Author` domain objects to `AuthorEntity` entities and vice versa.
    - `BookMapper.java`: Mapper class for mapping `Book` domain objects to `BookEntity` entities and vice versa.

- **Application Layer**: Contains the business logic and use cases of the application.
  - **Service**: Contains service classes implementing the business logic of the application.
    - `AccountService.java`: Service class responsible for handling business logic related to accounts.
    - `BookService.java`: Service class responsible for handling business logic related to books.
    - `ExchangeService.java`: Service class responsible for handling exchange-related business logic.

- **Domain Layer**: Contains the domain model and business logic of the application.
  - **Model**: Contains domain model classes representing core business entities.
    - `Account.java`: Represents an account entity in the system.
    - `Author.java`: Represents an author entity in the system.
    - `Book.java`: Represents a book entity in the system.
    - `Customer.java`: Represents a customer entity in the system.
  - **Validation**: Contains classes responsible for validation logic.
    - `DateValidator.java`: Validator for date-related validation logic.
    - `ProfileValidation.java`: Validator for profile-related validation logic.
  - **Value Objects**: Contains immutable value objects used within the domain model.
    - `AuthorRegistration.java`: Represents author registration information.
    - `Currency.java`: Represents currency information.
    - `ISBN.java`: Represents an International Standard Book Number.
    - `Password.java`: Represents a password value object.
    - `Price.java`: Represents a price value object.
    - `PublicationDate.java`: Represents a publication date value object.
    - `StockQuantity.java`: Represents a stock quantity value object.
    - `Username.java`: Represents a username value object.
    - `UserProfile.java`: Represents a user profile value object.

- **Infrastructure Layer**: Contains infrastructure-related configurations and implementations.
  - **Config**: Contains configuration classes for integrating with external services or frameworks.
    - `OpenApiConfig.java`: Configuration class for integrating with OpenAPI / Swagger.
  - **Entities**: Contains entity classes representing database tables.
    - `AccountEntity.java`: Represents the account entity in the database.
    - `AuthorEntity.java`: Represents the author entity in the database.
    - `BookEntity.java`: Represents the book entity in the database.
    - `CustomerEntity.java`: Represents the customer entity in the database.
  - **Enums**: Contains enumeration classes used within the infrastructure layer.
    - `AccountStatusInfraEnum.java`: Represents account status enumeration used in the infrastructure layer.
    - `CurrencyInfraEnum.java`: Represents currency enumeration used in the infrastructure layer.
    - `GenreInfraEnum.java`: Represents genre enumeration used in the infrastructure layer.
  - **Repositories**: Contains repository interfaces for interacting with the database.
    - `AccountInfraJpaRepository.java`: Repository interface for the account entity using Spring Data JPA.
    - `BookInfraJpaRepository.java`: Repository interface for the book entity using Spring Data JPA.

- **Web Layer**: Contains controllers and DTOs for handling incoming requests and presenting responses.
  - **Controller**: Contains REST controllers responsible for handling HTTP requests.
    - `AccountController.java`: REST controller for handling account-related requests.
    - `BookController.java`: REST controller for handling book-related requests.
    - `ExchangeController.java`: REST controller for handling exchange-related requests.
  - **DTO**: Contains Data Transfer Objects (DTOs) used for request and response payloads.
    - `BookResponseDTO.java`: DTO for representing book response payloads.
    - `CreateAccountRequestDTO.java`: DTO for representing create account request payloads.
    - `CreateAuthorRequestDTO.java`: DTO for representing create author request payloads.
    - `CreateBookRequestDTO.java`: DTO for representing create book request payloads.
    - `ErrorResponseDTO.java`: DTO for representing error response payloads.
    - `ExchangeRateResponseDTO.java`: DTO for representing exchange rate response payloads.
    - `ModifyAccountRequestDTO.java`: DTO for representing modify account request payloads.
    - `ModifyBookRequestDTO.java`: DTO for representing modify book request payloads.
  - **Handler**: Contains exception handler classes for handling exceptions thrown during request processing.
    - `ServiceExceptionHandler.java`: Global exception handler for handling service-related exceptions.

## Technologies Used

- Java
- Spring Boot
- Spring Data JPA
- Swagger (for API documentation)
- JUnit (for testing)

## Setup and Installation

1. Clone the repository to your local machine.
2. Open the project in your preferred Java IDE.
3. Ensure you have Java Development Kit (JDK) installed.
4. Build the project using Maven.
5. Run the application locally using your IDE or command-line interface.

## Usage

Once the application is running, you can interact with it using RESTful endpoints provided by the controller layer. Use tools like cURL, Postman, or Swagger UI to explore and test the API endpoints.

## Dependencies

The application uses the following major dependencies:
- Spring Boot: Framework for creating Spring-based applications.
- Spring Data JPA: Provides repository support for JPA.
- OpenAPI / Swagger: Used for API documentation and testing.

## Getting Started

To run the application locally, follow these steps:
1. Clone this repository to your local machine.
2. Make sure you have Java and Maven installed.
3. Configure your database connection in `application.properties`.
4. Build the application using Maven: `mvn clean install`.
5. Run the application: `mvn spring-boot:run`.

## API Documentation

The API documentation is available using Swagger UI. After running the application locally, you can access the Swagger UI at `http://localhost:8080/swagger-ui.html`.

## Contributing

Contributions are welcome! If you find any issues or have suggestions for improvement, feel free to open an issue or create a pull request.