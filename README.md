# Spring Boot Case Study App

## Overview

The Spring Boot Case Study App is a Java-based web application that uses the Spring Boot framework to manage and analyze data related to countries, regions, and continents. It provides functionalities to filter and retrieve data, calculate statistics, and display results.

## Features

- **Database Connectivity**: The app connects to a PostgreSQL database to store and retrieve data.

- **Entity-Relationship Model**: The app is built around an entity-relationship model that includes entities like `Country`, `Region`, `Continent`, `Language`, and `CountryStat`.

- **JPA and Hibernate**: Java Persistence API (JPA) and Hibernate are used for database persistence and object-relational mapping.

- **RESTful APIs**: The app exposes RESTful APIs to perform various operations on the data, such as filtering, statistics calculation, and retrieval.

- **CORS Configuration**: Cross-Origin Resource Sharing (CORS) is configured to allow web clients to access the APIs from different domains.

- **Pagination**: The app supports pagination for large datasets, ensuring efficient data retrieval.

## Prerequisites

- Java 17
- PostgreSQL database
- Maven

## Getting Started

1. Clone the repository to your local machine.

2. Configure the `application.yml` file with your PostgreSQL database connection details.
```yaml
spring:
datasource:
driver-class-name: org.postgresql.Driver
url: jdbc:postgresql://localhost:5432/your-database-name
username: your-username
password: your-password
```

3. Build and run the application using Maven:

```cli
mvn spring-boot:run
```

4. Access the application at `http://localhost:8080`.

## Usage

- Use the provided RESTful APIs to interact with the application's data.

- Implement frontend components to display and interact with the data according to your requirements.

## License

This project is licensed under the MIT License.
