# Spring Boot Application
This is a Spring Boot application that automate the delivery of survey links to administrators of specified domain names.

## Prerequisites
- Java 17 or higher
- Maven

## Getting Started
1. Clone the repository
2. Build the project using Maven clean install
3. Run the application
4. Access the application at http://localhost:8080

## Configuration
- Update the following application properties in `application.properties` to send emails:
  spring.mail.username=email
  spring.mail.password=password
  spring.mail.host=
  spring.mail.port=

## postman 
- Use attached postman collection to hit the endpoint 

