# Critter Chronologer

## Overview
Critter Chronologer is a Spring Boot backend application developed as part of the Udacity Data Stores and Persistence course. This project implements a RESTful API system for managing a pet service business, including customer management, employee scheduling, pet records, and service appointments.

## Problem Statement
The goal was to design and implement a multi-tiered backend application that demonstrates proficiency in:
- Entity relationship modeling
- JPA/Hibernate persistence
- RESTful API design
- Service layer architecture
- DTO pattern implementation

## Technologies Used
- Java 11
- Spring Boot
- Spring Data JPA
- Hibernate
- Maven
- H2 Database
- MySQL (optional)
- Postman

## Key Features
- Customer and pet registration
- Employee management with skills and availability tracking
- Schedule creation linking employees, pets, and services
- REST API endpoints for all entities
- Bidirectional entity relationships
- DTO-based request/response handling

## Project Structure
```
critter-chronologer/
├── README.md
├── .gitignore
├── documentation/
│   ├── Critter Chronologer Project Documentation.docx
│   └── images/
│       ├── entity-diagram.png
│       ├── postman-test.png
│       └── database-schema.png
└── critter/
    ├── pom.xml
    └── src/
        ├── main/
        │   ├── java/com/udacity/jdnd/course3/critter/
        │   │   ├── pet/
        │   │   ├── schedule/
        │   │   └── user/
        │   └── resources/
        │       ├── application.properties
        │       └── Udacity.postman_collection.json
        └── test/
```

## Entity Relationships
- Customer has many Pets (One-to-Many)
- Schedule has many Pets (Many-to-Many)
- Schedule has many Employees (Many-to-Many)
- Employee has Skills (Enumerated)

## API Endpoints

### Customer Endpoints
- POST /user/customer - Create customer
- GET /user/customer/pet/{petId} - Get customer by pet
- GET /user/customer - Get all customers

### Employee Endpoints
- POST /user/employee - Create employee
- GET /user/employee/{employeeId} - Get employee by ID
- PUT /user/employee/{employeeId} - Update employee availability

### Pet Endpoints
- POST /pet - Create pet
- GET /pet/{petId} - Get pet by ID
- GET /pet - Get all pets

### Schedule Endpoints
- POST /schedule - Create schedule
- GET /schedule - Get all schedules
- GET /schedule/pet/{petId} - Get schedules by pet
- GET /schedule/employee/{employeeId} - Get schedules by employee

## How to Run

### Prerequisites
- Java JDK 11 or higher
- Maven 3.6+
- IntelliJ IDEA (recommended)

### Steps
1. Clone the repository
```bash
git clone https://github.com/Bhavs23/critter-chronologer.git
cd critter-chronologer/critter
```

2. Build the project
```bash
mvn clean install
```

3. Run the application
```bash
mvn spring-boot:run
```

4. Access the application at `http://localhost:8080`

5. Test endpoints using Postman
   - Import `src/main/resources/Udacity.postman_collection.json`

## Testing
Run unit tests:
```bash
mvn test
```

## Documentation
Complete project documentation with detailed implementation steps and screenshots is available in:
- `documentation/Critter Chronologer Project Documentation.docx`

## Starter Code Attribution
This project was developed using starter code provided by Udacity as part of the Data Stores and Persistence course. The starter template was extended with complete entity implementations, service layer logic, repository patterns, and API functionality.

Original starter repository: https://github.com/udacity/nd035-c3-data-stores-and-persistence-project-starter

## Learning Outcomes
- Implemented complex JPA entity relationships
- Applied DTO pattern for clean API design
- Developed layered architecture (Controller, Service, Repository)
- Managed bidirectional relationships and cascade operations
- Configured Spring Data JPA with Hibernate
- Tested RESTful APIs using Postman

## Author
Bhavika Vunnam  
