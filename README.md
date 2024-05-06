# Pack Express User-Auth Microservice

Pack Express User Authentication Microservice is a Spring Boot application designed to handle user authentication functionalities for the Pack Express package delivery service.

## Table of Contents

* Features
* Technologies Used
* Installation
* API Endpoints

## Features

* **User Registration:** Allow users to register for a new account securely.
* **User Login:** Authenticate users and generate JWT tokens for accessing protected resources.
* **Password Encryption:** Encrypt user passwords for enhanced security.
* **Token Management:** Handle token generation, validation, and expiration.
* **User Profile Management:** Allow users to update their profile information and manage account settings.

## Technologies Used

* **Spring Boot:** Framework for building microservices in Java.
* **Spring Security:** Provides authentication and authorization support.
* **JWT (JSON Web Tokens):** Securely transmit information between parties as a JSON object.
* **BCrypt:** Password hashing algorithm for secure password storage.
* **Spring Data JPA:** Simplifies data access with ORM for database operations.
* **Hibernate:** ORM tool for mapping Java objects to database tables.
* **MySQL:** Relational database for storing user data.

## Installation

* Clone the repository:
```
https://github.com/sudhanshu2900/pack-express-userauth-microservice.git
```
* Navigate to the project directory:
```
cd pack-express-userauth-microservice
```
* Set up MySQL database:
  (1) Create a new MySQL database.
  (2) Update the database connection properties in application.properties.
* Build and run the application:
```
mvn spring-boot:run
```
* The application will start running at **http://localhost:9001**.

NOTE: Microservice will run on port 9001.
