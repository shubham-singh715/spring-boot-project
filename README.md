Spring Boot Assignment
==
Getting Started
--
* Clean and Install Maven
* Create a database named "assignment" in mysql 
``CREATE DATABASE assignment;``
* Change configuration in ``application.yml`` to 
``jpa:
  hibernate:
  ddl-auto: create``
* Run the SpringBootApplication [file](src/main/java/com/techwondoe/assignment/AssignmentApplication.java).
* Go to browser and type ``http://localhost:8080/swagger-ui.html#/`` to open swagger UI.
* Open **AuthController** and click on *Try it out*.
<img height="300" src="C:\Users\hp\Pictures\Screenshots\Screenshot(99).png" width="400"/>
* Enter ``password : root and username : root``
* Hit Execute and copy the JWT token.
* Click on **Authorize** in green color and paste the token with Bearer at start:
``Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJyb290IiwiZXhwIjoxNjU2MjgzNTYwLCJpYXQiOjE2NTYyNTgzNjB9.l0kMuZsP_O5Suhd9s29M9GLGcjUlkxMJyBtHqH4ZjzNq5XYzPaB0etJ-on_tpBZldLLCxnBzWM9oxViLZ5QnGg``
* Once Loged In , use any Api .
