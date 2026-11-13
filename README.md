# Address Book Application – Spring Boot REST API

## Project Overview

Address Book Application is a backend REST API developed using Spring Boot, Java, and Maven. The project demonstrates RESTful web service development, layered architecture, Data Transfer Objects (DTOs), model mapping, service-layer implementation, exception handling, and in-memory data management.

The application allows users to:

- Retrieve all contacts from the address book.
- Search for a contact using its unique ID.
- Create new contacts.
- Update existing contact details.
- Delete contacts from the address book.
- Handle invalid contact requests using custom exceptions and appropriate HTTP status codes.

The project follows a layered architecture that separates the Controller, Service, Model, DTO, Mapper, and Exception Handling components. This improves code readability, maintainability, testability, and separation of concerns.

The application currently stores contact records in an in-memory `ArrayList`. Therefore, contact data is temporary and is reset whenever the application restarts.

## Technologies Used

- **Programming Language:** Java
- **Framework:** Spring Boot
- **Build Tool:** Maven
- **Testing Framework:** JUnit 5
- **Mocking Framework:** Mockito
- **API Testing Tool:** Postman
- **IDE:** IntelliJ IDEA
- **JDK:** Java 22
- **Server:** Embedded Apache Tomcat
- **Interface:** REST API (JSON)
- **Data Storage:** In-memory ArrayList

## Project Structure

```text
Address-Book/
│
└── src/
    ├── main/
    │   ├── java/
    │   │   └── com/
    │   │       └── addressbook/
    │   │           ├── AddressBookApplication.java
    │   │           │
    │   │           ├── controller/
    │   │           │   └── AddressBookController.java
    │   │           │
    │   │           ├── dto/
    │   │           │   └── AddressBookDTO.java
    │   │           │
    │   │           ├── exception/
    │   │           │   ├── ContactNotFoundException.java
    │   │           │   └── GlobalExceptionHandler.java
    │   │           │
    │   │           ├── mapper/
    │   │           │   └── AddressBookMapper.java
    │   │           │
    │   │           ├── model/
    │   │           │   └── AddressBook.java
    │   │           │
    │   │           └── service/
    │   │               ├── AddressBookService.java
    │   │               └── AddressBookServiceImpl.java
    │   │
    │   └── resources/
    │       └── application.properties
    │
    └── test/
        └── java/
            └── com/
                └── addressbook/
                    ├── AddressBookApplicationTests.java
                    │
                    ├── controller/
                    │   └── AddressBookControllerTest.java
                    │
                    └── service/
                        └── AddressBookServiceImplTest.java

pom.xml
README.md
```

## Use Cases Implemented

### Section 1 – UC1: Create Address Book Spring Project

Created a Spring Boot application to provide the foundation for handling REST API requests for the Address Book system.

**Implemented Features:**

- Created a Spring Boot project using Maven.
- Configured the main application class using `@SpringBootApplication`.
- Configured the embedded Apache Tomcat server.
- Configured application properties.
- Established the initial project structure.
- Verified application startup using Spring Boot.
- Added an application context loading test using JUnit 5.

**Main Class:**

`AddressBookApplication.java`

### Section 1 – UC2: Create REST Controller

Created a REST Controller to demonstrate HTTP methods and handle Address Book API requests.

**Implemented Features:**

- Created `AddressBookController` using `@RestController`.
- Configured the base endpoint using `@RequestMapping`.
- Implemented GET, POST, PUT, and DELETE operations.
- Used `ResponseEntity` to return HTTP responses.
- Accepted JSON request bodies using `@RequestBody`.
- Added SLF4J logging.
- Configured MySQL connection properties for the database integration stage.
- Tested REST endpoints using Postman.

**API Endpoints:**

| HTTP Method | Endpoint | Description |
|---|---|---|
| GET | `/addressbook/` | Retrieve all contacts |
| GET | `/addressbook/get/{id}` | Retrieve a contact by ID |
| POST | `/addressbook/create` | Create a new contact |
| PUT | `/addressbook/update/{id}` | Update an existing contact |
| DELETE | `/addressbook/delete/{id}` | Delete a contact |

*At this stage, the endpoints demonstrate REST request and response handling. Actual contact storage is introduced in Section 2 UC3.*

### Section 2 – UC1: Introduce DTO and Model

Introduced separate Model and Data Transfer Object (DTO) classes to organize contact data and separate internal application objects from API request and response objects.

**AddressBook Model:**

Created `AddressBook.java` to represent the contact information.

| Field | Type | Description |
|---|---|---|
| id | int | Unique contact identifier |
| firstName | String | First name of the contact |
| lastName | String | Last name of the contact |
| phoneNumber | String | Contact phone number |

**AddressBookDTO:**

Created `AddressBookDTO.java` to transfer contact information between the client and the application.

**Implemented Features:**

- Created a separate model class for contact representation.
- Created a DTO class for API data transfer.
- Used private fields with getters and setters.
- Added constructors for object initialization.
- Implemented a mapper class to convert DTO objects into model objects and vice versa.
- Avoided directly exposing the model through the API.

**Mapper Class:**

`AddressBookMapper.java`

### Section 2 – UC2: Introduce Service Layer

Introduced a dedicated Service Layer to separate business logic from the REST Controller.

**Implemented Features:**

- Created `AddressBookService` interface.
- Implemented business operations in `AddressBookServiceImpl`.
- Moved contact-management operations away from the controller.
- Used constructor-based dependency injection.
- Configured the controller to communicate with the service through its interface.
- Added SLF4J logging for service operations.
- Implemented service-layer unit tests using JUnit 5.

**Service Operations:**

| Method | Description |
|---|---|
| `getAllContacts()` | Retrieves all contacts |
| `getContactById(int id)` | Retrieves a contact using its ID |
| `createContact(AddressBookDTO dto)` | Creates a contact |
| `updateContact(int id, AddressBookDTO dto)` | Updates contact details |
| `deleteContact(int id)` | Deletes a contact |

### Section 2 – UC3: Store Address Book Data in Memory

Implemented actual CRUD operations using an in-memory `ArrayList` to maintain contact records.

**Implemented Features:**

- Used `ArrayList<AddressBook>` to store contact records.
- Implemented automatic ID generation.
- Added new contacts to the collection.
- Retrieved all stored contacts.
- Searched for contacts using their unique IDs.
- Updated existing contact information.
- Deleted contacts from the collection.
- Added custom exception handling for contacts that do not exist.
- Implemented global exception handling using `@RestControllerAdvice`.
- Returned appropriate HTTP status codes.
- Added service-layer unit tests covering successful and unsuccessful operations.

**Data Storage:**

`ArrayList<AddressBook>`

**Custom Exception:**

`ContactNotFoundException.java`

**Global Exception Handler:**

`GlobalExceptionHandler.java`

**Important:** Contact records are currently stored in application memory. The records are not permanently saved and will be lost when the application is restarted.

## REST API Reference

Base URL:

```text
http://localhost:8080/addressbook
```

| Operation | Method | Endpoint | Expected Status |
|---|---|---|---|
| Get all contacts | GET | `/` | 200 OK |
| Get contact by ID | GET | `/get/{id}` | 200 OK |
| Create contact | POST | `/create` | 201 Created |
| Update contact | PUT | `/update/{id}` | 200 OK |
| Delete contact | DELETE | `/delete/{id}` | 200 OK |
| Contact not found | GET/PUT/DELETE | Relevant ID endpoint | 404 Not Found |

## Sample API Requests

### 1. Create Contact

**POST**

```text
http://localhost:8080/addressbook/create
```

Request Body:

```json
{
    "firstName": "Utakarsh",
    "lastName": "Jain",
    "phoneNumber": "9876543210"
}
```

### 2. Retrieve All Contacts

**GET**

```text
http://localhost:8080/addressbook/
```

### 3. Retrieve Contact by ID

**GET**

```text
http://localhost:8080/addressbook/get/1
```

### 4. Update Contact

**PUT**

```text
http://localhost:8080/addressbook/update/1
```

Request Body:

```json
{
    "firstName": "Utakarsh",
    "lastName": "Jain",
    "phoneNumber": "9999999999"
}
```

### 5. Delete Contact

**DELETE**

```text
http://localhost:8080/addressbook/delete/1
```

### 6. Handle Contact Not Found

**GET**

```text
http://localhost:8080/addressbook/get/99
```

If the requested contact does not exist, the application returns HTTP `404 Not Found` with an appropriate error response.

## Sample API Response

**Create Contact – 201 Created**

```json
{
    "id": 1,
    "firstName": "Utakarsh",
    "lastName": "Jain",
    "phoneNumber": "9876543210"
}
```

**Retrieve All Contacts – 200 OK**

```json
[
    {
        "id": 1,
        "firstName": "Utakarsh",
        "lastName": "Jain",
        "phoneNumber": "9876543210"
    }
]
```

**Contact Not Found – 404 Not Found**

```json
{
    "error": "Contact Not Found",
    "message": "Contact not found with id: 99"
}
```

*These examples illustrate the intended API response structure.*

## Maven Dependencies

The project uses Spring Boot Web for REST API development and Spring Boot Test for automated testing.

Important dependencies include:

- `spring-boot-starter-web` – Provides REST Controller support and embedded Tomcat.
- `spring-boot-starter-test` – Provides testing support.
- `junit-jupiter` – Supports unit testing using JUnit 5.
- `mockito-junit-jupiter` – Supports mocking and dependency testing.
- `mysql-connector-j` – Provides the MySQL JDBC driver for the database integration stage.

The dependencies and their versions are managed through the Maven configuration in `pom.xml`.

## How to Run the Project

### Prerequisites

- Java JDK 22 or above.
- IntelliJ IDEA.
- Apache Maven.
- Postman for API testing.

### Execution Steps

**1. Clone the Repository**

```bash
git clone https://github.com/Utakarsh-Jain/Address-Book.git
```

**2. Open the Project**

Open the cloned project in IntelliJ IDEA.

**3. Load Maven Dependencies**

Allow IntelliJ IDEA to download and configure the required Maven dependencies.

Alternatively, execute:

```bash
mvn clean install
```

**4. Run the Application**

Execute the `main()` method in:

```text
com.addressbook.AddressBookApplication
```

Alternatively, run:

```bash
mvn spring-boot:run
```

**5. Test the REST APIs**

Open Postman and send GET, POST, PUT, and DELETE requests using the endpoints documented above.

The application runs on:

```text
http://localhost:8080
```

## Run Tests

To execute all automated tests using Maven:

```bash
mvn clean test
```

The project uses JUnit 5 and Mockito for automated testing.

**Testing Coverage Includes:**

- Spring application context loading.
- Controller endpoint behavior.
- Service-layer business logic.
- Contact creation and retrieval.
- Contact searching by ID.
- Contact updates and deletion.
- Handling invalid contact IDs.
- Custom exception handling through service-level tests.

## Architecture and Design

The application follows a layered architecture.

| Layer / Package | Responsibility |
|---|---|
| `controller` | Handles incoming HTTP requests and returns API responses |
| `service` | Contains business logic and contact-management operations |
| `model` | Represents the internal contact data structure |
| `dto` | Transfers contact data between API clients and the application |
| `mapper` | Converts model objects into DTOs and DTOs into model objects |
| `exception` | Handles application-specific exceptions and error responses |

This separation ensures that each component has a clearly defined responsibility and makes the application easier to maintain, test, and extend.

## Learning Outcomes

Through this project, the following concepts were practiced:

- Developing RESTful APIs using Spring Boot.
- Understanding HTTP methods and status codes.
- Creating REST Controllers using Spring annotations.
- Handling JSON requests and responses.
- Using `ResponseEntity` for HTTP response management.
- Implementing Model and DTO classes.
- Mapping between DTO and model objects.
- Applying layered architecture.
- Implementing Service interfaces and service implementations.
- Using constructor-based dependency injection.
- Performing CRUD operations using Java Collections.
- Managing application data using `ArrayList`.
- Generating unique identifiers for records.
- Implementing custom exceptions.
- Handling exceptions globally using `@RestControllerAdvice`.
- Logging application events using SLF4J.
- Writing unit tests using JUnit 5 and Mockito.
- Managing project dependencies and builds using Maven.
- Testing REST APIs using Postman.

## Future Enhancements

The application can be extended with the following features:

- Integrate MySQL for permanent contact storage.
- Implement Spring Data JPA and repository-layer operations.
- Add request validation using Jakarta Bean Validation.
- Introduce pagination and sorting for contact retrieval.
- Implement search functionality using contact names and phone numbers.
- Add authentication and authorization using Spring Security.
- Introduce API documentation using Swagger/OpenAPI.
- Develop a frontend interface for managing contacts.

## Author

**Utakarsh Jain**

GitHub: [Utakarsh-Jain](https://github.com/Utakarsh-Jain)

Repository: Address-Book

This project was developed as part of Spring Boot training, covering Section 1 UC1–UC2 and Section 2 UC1–UC3.
