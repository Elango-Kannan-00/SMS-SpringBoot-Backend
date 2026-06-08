# Student Management System

A simple Spring Boot REST API for managing student records with PostgreSQL and Spring Data JPA.

## Features

- Create a student record
- View all students
- Update a student by ID
- Delete a student by ID
- Delete all student records
- Persistent storage with PostgreSQL

## Tech Stack

- Java 21
- Spring Boot 4.0.6
- Spring Web MVC
- Spring Data JPA
- PostgreSQL
- Maven

## Project Structure

```text
src/main/java/com/student_management
├── StudentManagementApplication.java
├── controller
│   └── StudentController.java
├── dto
│   ├── StudentRequestDto.java
│   └── StudentResponseDto.java
├── entity
│   └── Student.java
├── exception
│   └── StudentException.java
├── repository
│   └── StudentRepository.java
└── service
    └── StudentService.java
```

## Prerequisites

- Java 21
- Maven
- PostgreSQL
- A database named `studentdb`

## Configuration

The application reads database settings from `src/main/resources/application.properties`.

Default configuration:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/studentdb
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

If your PostgreSQL username, password, host, or database name is different, update this file before running the app.

## How To Run

1. Create the database in PostgreSQL:

```sql
CREATE DATABASE studentdb;
```

2. Start the application from the project root:

```bash
./mvnw spring-boot:run
```

On Windows, use:

```bash
mvnw.cmd spring-boot:run
```

The application starts on the default Spring Boot port:

```text
http://localhost:8080
```

## API Endpoints

Base path: `/student`

### 1. Add Student

- **Method:** `POST`
- **Endpoint:** `/student`

Request body:

```json
{
  "name": "John Doe",
  "email": "john@example.com",
  "department": "CSE",
  "mobileNo": 9876543210,
  "age": 21,
  "cgpa": 8.5
}
```

Response:

```json
{
  "id": 1,
  "name": "John Doe",
  "department": "CSE",
  "cgpa": 8.5
}
```

### 2. Get All Students

- **Method:** `GET`
- **Endpoint:** `/student`

Response:

```json
[
  {
    "id": 1,
    "name": "John Doe",
    "department": "CSE",
    "cgpa": 8.5
  }
]
```

### 3. Update Student By ID

- **Method:** `PUT`
- **Endpoint:** `/student/{id}`

Example:

```http
PUT /student/1
```

Request body:

```json
{
  "name": "John Smith",
  "email": "johnsmith@example.com",
  "department": "ECE",
  "mobileNo": 9876543211,
  "age": 22,
  "cgpa": 8.9
}
```

Response:

```json
{
  "id": 1,
  "name": "John Smith",
  "department": "ECE",
  "cgpa": 8.9
}
```

### 4. Delete Student By ID

- **Method:** `DELETE`
- **Endpoint:** `/student/{id}`

Example:

```http
DELETE /student/1
```

Response:

```text
Student Deleted Successfully
```

### 5. Delete All Students

- **Method:** `DELETE`
- **Endpoint:** `/student`

Response when records exist:

```text
All student deleted successfully.
```

Response when no records exist:

```text
No Student found.
```

## Data Model

### Student Entity

- `id` - primary key, auto-generated
- `name` - student name
- `email` - email address
- `department` - department name
- `mobileNo` - mobile number
- `age` - age
- `cgpa` - CGPA value

## Error Handling

The service throws a custom `StudentException` when a student cannot be found for update or delete operations.

Example message:

```text
No student found with id: 1
```

## Author

Elango K
