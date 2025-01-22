# Waste Sorting App - API


## Description
This project is a Sring Boot application designed to provide API [endpoints](http://localhost:8080) for a mobile application's CRUD operations
to the non-persistent, in-memory database.
___

## Technical Tools
- IntelliJ
- JDK 17 
- Maven
- Spring Boot
- Spring Data JPA
- H2 Database
- Swagger

## Key Features

1. CRUD _(Create, Read, Update & Delete)_: 
    - Waste Category
    - Recycling Tips
    - Disposal Tips
2. Visualise Data Via H2 Console.
3. HTTP Request & Response Handling.
___


## Prerequisites
- JDK 17 (_Bellsoft Liberica recommended)_
- Apache Maven _(3.8 or higher)_

## Running The Application

### 1. Clone The Repository
```bash 
   git clone git@github.com:blebelo/enviro365.git
   cd enviro365
```

### 2. Build The Project
```bash
   mvn clean install
```

### 3. Run
```bash
   mvn spring-boot:run
```
Once running you may access components of the application through the following links
   - [Web Server](http://localhost:8080)
   - [Swagger UI](http://localhost:8080/swagger-ui.html)
   - [H2 Console](http://localhost:8080/h2-console)
   - Username = user
   

### 4. Run Tests _(Optional)_
```bash
   mvn test
```
___

