# Spring Boot CRUD Application — Book API

**Module:** Software Engineering
**Name:** Samadhi UKBS
**Registration Number:** 244186U

## Overview
A Spring Boot REST API built with Apache Maven that manages a collection of Books, supporting full CRUD (Create, Read, Update, Delete) operations. Data is stored in memory. The project follows a layered architecture separating the model, repository, service, and controller concerns.

## Technologies
- Java 21
- Spring Boot 4.1.0
- Apache Maven
- Spring Web







## Project Structure
- **Book** — the model (entity) representing a book.
- **BookRepository** — in-memory data storage layer.
- **BookService** — business logic layer.
- **BookController** — REST controller exposing the API endpoints.






## API Endpoints

| Method | Endpoint          | Description              | Success Status |
|--------|-------------------|--------------------------|----------------|
| POST   | /api/books        | Create a new book        | 201 Created    |
| GET    | /api/books        | Retrieve all books       | 200 OK         |
| GET    | /api/books/{id}   | Retrieve a book by id    | 200 OK         |
| PUT    | /api/books/{id}   | Update an existing book  | 200 OK         |
| DELETE | /api/books/{id}   | Delete a book by id      | 204 No Content |

A request for a non-existent id returns 404 Not Found.

## Build & Run Instructions

Build the project:

    ./mvnw clean package

Run the application:

    ./mvnw spring-boot:run

The application runs on http://localhost:8080

## Example Request

Create a book:

    curl -X POST http://localhost:8080/api/books -H "Content-Type: application/json" -d '{"title":"Dune","author":"Frank Herbert","year":1965}'
