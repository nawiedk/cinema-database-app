# Cinema Database App

A full-stack web application developed to manage core cinema operations such as movies, screenings, customers, and tickets.  
This project was implemented as part of a university-level database systems course.

## Overview

This application enables interaction with a PostgreSQL database through a web interface powered by Spring Boot and Thymeleaf.  
It supports common operations such as querying, inserting, and filtering records, with a clean UI and structured backend logic using the DAO pattern.

## Key Features

- Java Spring Boot backend  
- PostgreSQL database with JDBC access via JdbcTemplate  
- RESTful endpoints for data access  
- Thymeleaf-based HTML frontend templates  
- Docker and Gradle-based setup for consistent builds  
- Data initialization through `schema.sql` and `data.sql`

## Technologies

- Java 17  
- Spring Boot (REST API, MVC)  
- PostgreSQL  
- JDBC / JdbcTemplate  
- Gradle  
- Thymeleaf  
- Docker

## Getting Started

```bash
git clone https://github.com/nawiedk/cinema-database-app.git
cd cinema-database-app
./gradlew build
./gradlew bootrun
```

Then open your browser and navigate to:

```
http://localhost:8080
```

## Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── example/
│   │           └── demo/
│   │               ├── controller/       # HTTP endpoints
│   │               ├── model/            # DTOs and DAOs
│   │               ├── persistence/      # DB connection
│   │               ├── security/         # Auth-related components
│   │               └── DemoApplication.java
│   ├── resources/
│   │   ├── application.properties
│   │   ├── data/
│   │   │   ├── schema.sql
│   │   │   └── data.sql
│   │   └── templates/                    # Thymeleaf HTML templates

```

## Example Endpoints

- `/film?title=...` – Search for films by title  
- `/vorstellung?datum=...&uhrzeit=...` – Filter screenings  
- `/addVorstellung` – Add a new screening  
- `/tickets?email=...` – View tickets by customer  
- `/changePassword` – Change a customer's password

## Notes

- This project is for academic use and not intended for production.
- `schema.sql` and `data.sql` initialize the database automatically on startup.