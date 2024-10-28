Library Management System Documentation
Prerequisites
Before running the application, ensure you have the following installed:

Java JDK (version 11 or later)
Maven (for managing dependencies and building the project)
PostgreSQL (or any other configured database)
IDE (like IntelliJ IDEA or Eclipse) for development

Database Setup
Create a Database:

Open your PostgreSQL client (like pgAdmin) and create a new database, e.g., library_management.
sql

CREATE DATABASE library_management;
Configure Database Connection:

Update the application.properties file in src/main/resources with your database configuration:
properties

spring.datasource.url=jdbc:postgresql://localhost:5432/library_management
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

Running the Application
Clone the Repository:

Clone the project repository from GitHub (or your version control system).
https://github.com/MaryamAkramAbdAlazeem/LibraryManagement.git
Build the Project:

Use Maven to build the project. This will download necessary dependencies.
bash

mvn clean install
Run the Application:

Start the Spring Boot application:
bash

mvn spring-boot:run
By default, the application will run on http://localhost:8080.
API Endpoints
Borrowing Records
Method	Endpoint	Description
POST	/api/borrow/{bookId}/patron/{patronId}	Allows a patron to borrow a book.
PUT	/api/return/{bookId}/patron/{patronId}	Records the return of a borrowed book.
Request Example for Borrowing a Book
http

POST /api/borrow/1/patron/1 HTTP/1.1
Content-Type: application/json

Request Example for Returning a Book
http

PUT /api/return/1/patron/1 HTTP/1.1
Content-Type: application/json
Books
Method	Endpoint	Description
GET	/api/books	Retrieve all books.
GET	/api/books/{id}	Retrieve a book by its ID.
POST	/api/books	Create a new book.
PUT	/api/books/{id}	Update an existing book.
DELETE	/api/books/{id}	Delete a book.
Patrons
Method	Endpoint	Description
GET	/api/patrons	Retrieve all patrons.
GET	/api/patrons/{id}	Retrieve a patron by ID.
POST	/api/patrons	Create a new patron.
PUT	/api/patrons/{id}	Update an existing patron.
DELETE	/api/patrons/{id}	Delete a patron.

Testing the API
You can test the API using tools like Postman or cURL. Here’s how to do it with Postman:

Create a New Request: Open Postman and create a new request.
Set the Method and URL: Choose the HTTP method (GET, POST, PUT, DELETE) and enter the endpoint URL.
Add Body: For POST and PUT requests, set the body to raw and choose JSON format.
Send the Request: Click on Send to execute the request and view the response.
