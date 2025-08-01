# Spring Boot Course - Learning Path

---

## **1. Week 1: Introduction and Setup**

- **Topics:**
  1. Welcome to the course
  2. Course objectives
  3. What will the course not do for you?
  4. Collaboration and teamwork
  5. Building a habit of regular practice
  6. Tools and requirements for the course
  7. Homework assignment

---

## **2. Week 2: Working with a Project**

- **Topics:**
  1. What is Spring Boot?
  2. How does the container work?
  3. Setting up a project
  4. Project structure
  5. What is a Bean?
  6. Inversion of Control
  7. Dependency Injection
  8. Advanced Dependency Injection
  9. Internationalization
  10. Configuration management
  11. Profiling
  12. Preparing for testing
  13. Quiz
  14. Homework

## **Additional Tasks with Code Links**

This section includes additional tasks from the course, completed during code reviews by the course author.

### **Task 2: Code Review by Course Author**
- **Description:** Task focusing on advanced dependency injection in Spring Boot.
- **Link to Code:**  
  [Task 2 Code](https://github.com/gkowalczyk/Spring-Boot2-course/tree/main/src/main/java/com/example/springboot2course/shop?fbclid=IwY2xjawIK8aVleHRuA2FlbQIxMAABHc-Nq1b2MSFCKj3mJ5jlw6mQenOmihTIR4IdMTNwdppoWb5ZVXtbPhGtrQ_aem_K4-0GeQtNZ3dY6cyhxX8KA)
---

## **3. Week 3: Building a REST API**

- **Topics:**
  1. What is REST?
  2. HTTP protocols
  3. Implementing web methods
  4. Parameterizing web methods
  5. Coding HTTP methods
  6. Building a REST API
  7. Quiz
  8. Homework
  9. Bonus: Using Swagger
  10. Bonus: Returning data in XML format
  11. Bonus: HATEOAS
### **Task 3: Code Review by Course Author**
- **Description:** REST API implementation for managing cars.
- **Link to Backend Code:**  
  [Task 3 Backend Code](https://github.com/gkowalczyk/Spring-Boot2-course/tree/main/CarApiApp/src/main/java/com/example/carapiapp?fbclid=IwY2xjawIK8dBleHRuA2FlbQIxMAABHbkhsS3y1p-tf5zLKz1YSQFtfqpViTI7qLOyIEHf-uThOTuRE_d01Z1O4w_aem_uHQ2L8sY68FEk6YRBVAy5w)
- **Link to Frontend React Code:**  
  [Task 3 Frontend Code](https://github.com/gkowalczyk/Spring-Boot2-course/tree/main/CarApiApp/carapi-frontend?fbclid=IwY2xjawIK8jVleHRuA2FlbQIxMAABHbkhsS3y1p-tf5zLKz1YSQFtfqpViTI7qLOyIEHf-uThOTuRE_d01Z1O4w_aem_uHQ2L8sY68FEk6YRBVAy5w)

---

## **4. Week 4: Spring MVC**

- **Topics:**
  1. Model-View-Controller (MVC) pattern
  2. View rendering options
  3. Vaadin integration
  4. Thymeleaf and React
  5. Quiz
  6. Homework
### **Task 4: Code Review by Course Author**
- **Description:** Extending the car API functionality with additional features.
- **Link to Backend Code:**  
  [Task 4 Backend Code - Part 1](https://github.com/gkowalczyk/Spring-Boot2-course/tree/main/CarApiApp/src/main/java/com/example/carapiapp?fbclid=IwY2xjawIK8dBleHRuA2FlbQIxMAABHbkhsS3y1p-)  
  [Task 4 Frontend Code - Part 2](https://github.com/gkowalczyk/Spring-Boot2-course/tree/main/CarApiApp/carapi-frontend)

---

## **5. Week 5: HTTP Clients**

- **Topics:**
  1. Working with remote services
  2. Implementing HTTP clients
  3. Mapping JSON to POJOs
  4. Advanced HTTP clients
  5. Quiz
  6. Homework
### **Task 5: Weather API Application**
- **Description:** Build a weather application using Spring Boot (backend) and React (frontend).
- **Link to Backend Code:**  
  [Weather API Backend Code](https://github.com/gkowalczyk/Spring-Boot2-course/tree/main/WeatherApiApp/src/main/java/com/example/weatherapiapp?fbclid=IwY2xjawIK8kRleHRuA2FlbQIxMAABHQuqnrtyh_MmnXRS0gsGkaXOB8tdg1oLoSRRkDNjVqQzNB7wVEQVoeF2kw_aem_HqznrzrjnNWFYeh5fYev7Q)
- **Link to Frontend React Code:**  
  [Weather API Frontend Code](https://github.com/gkowalczyk/Spring-Boot2-course/blob/main/WeatherApiApp/src/main/resources/frontend/weather-app/src/App.js?fbclid=IwY2xjawIK8k1leHRuA2FlbQIxMAABHV_Ii06mDTyNfAYFI03oGPGC8RrWB2vxGP5BWGlvVxgeUP4kGJ0rhGj_ig_aem_I7wNXoxmcx_t4hJQWbmVNA)

---

## **6. Week 6: Aspect-Oriented Programming (AOP)**

- **Topics:**
  1. Introduction to AOP
  2. AOP in practice
  3. AOP annotations
  4. Quiz
  5. Homework
### **Task 6:  Aspect-Oriented Programming**
- **Description:** Write an application that provides a simple API interface. Anyone who calls the GET method will receive a list of movies (title, year, producer). Calling the POST method will allow adding a movie to the list and additionally trigger an EMAIL to be sent using an ASPECT.
- **Link to Backend Code:**  
  [Backend Code](https://github.com/gkowalczyk/Spring-Boot2-course/tree/main/VideoApiApp/src/main/java/com/example/videoapiapp)


---

## **7. Week 7: Databases I - JDBC**

- **Topics:**
  1. Setting up a database
  2. Configuring connections
  3. Generating models
  4. Performing CRUD operations
  5. Advanced DAO operations
  6. Quiz
  7. Homework
### **Task 7:  Aspect-Oriented Programming**
- **Description:** Write an application that allows adding and displaying vehicles from a database via a GUI. The vehicle should have fields to store the brand, model, color, and production date. Create a form that enables filtering and displaying vehicles within a specific date range, e.g., showing all vehicles in the database produced between 2010 and 2015.
Write an application that fetches news from a selected API and saves it to the database. Create a GUI that allows browsing and editing the news entries.
- **Link to Backend Code:**  
  [Backend Code](https://github.com/gkowalczyk/Spring-Boot2-course/tree/main/CarApiAppDb/src/main/java/com/example/carapiappdb)
- **Link to Frontend React Code:**  
  [Frontend Code](https://github.com/gkowalczyk/Spring-Boot2-course/tree/main/CarApiAppDb/src/main/resources/static/car_api_db_frontend/src)

---

## **8. Week 8: Databases II - Hibernate**

- **Topics:**
  1. ORM and JPA basics
  2. Configuring Hibernate
  3. Advanced queries and operations
  4. Relationships and entities
  5. Quiz
  6. Homework
### **Task 8:  Databases II - Hibernate**
- **Description:** Write an application that connects to a weather API and saves the current temperature information in a database every hour (use Hibernate or R2DBC).
- **Link to Backend Code:**  
  [Backend Code](https://github.com/gkowalczyk/Spring-Boot2-course/tree/main/WeatherApiAppR2dbc/src/main/java/com/example/weatherApiAppR2dbc)
### **Online Notebook**
- **Description:** Write an Online Notebook – a graphical user interface (GUI) application that allows users to create notes, save them in a database, edit them later, and display them.
- **Link to Backend Code:**  
  [Backend Code](https://github.com/gkowalczyk/Spring-Boot2-course/tree/main/NoteOnlineApp/src/main/java/com/example/noteonlineapp)
- **Link to Frontend React Code:**  
  [Frontend Code](https://github.com/gkowalczyk/Spring-Boot2-course/tree/main/NoteOnlineApp/src/main/resources/static/my-app/src)

#### **Preview of the Frontend Application**
![Online Notebook Screenshot](https://raw.githubusercontent.com/gkowalczyk/Spring-Boot2-course/refs/heads/main/NoteOnlineApp/src/main/resources/static/my-app/src/react.bmp)
---

## **9. Week 9: Databases III - NoSQL**

- **Topics:**
  1. Introduction to NoSQL
  2. Configuring NoSQL databases
  3. Performing CRUD operations
  4. Bonus: Firebase integration
  5. Quiz
  6. Homework
### **Task 9:  Databases III - NoSQL**
### **Homework Assignment**
1. Load **1000 objects** into the application from a **CSV file** generated using [Mockaroo](https://www.mockaroo.com/).
2. Create a method that **saves all elements** to a local database.
3. Implement an **aspect** that listens to the method execution:
  - At the start of the operation, it should trigger a **time counter**.
  - Once the operation is completed, it should log the **execution time**.
4. Do the same for **reading data** from the database (**without displaying** it, as this could distort the results).
5. Perform this experiment using **both a relational (SQL) and a non-relational (NoSQL) database**.
6. **Compare the results** and document your findings.
7. **Share your observations** with the group to discuss performance differences and insights.

### **Performance Comparison**
After executing the test:
- MongoDB was **approximately 35-36% faster** than MySQL in write and read operations.
- The additional overhead in MySQL comes from **ORM (Object-Relational Mapping)**, which introduces **extra processing time**.
- - Below is a **graphical representation** of the performance comparison:

![Performance Comparison](https://github.com/gkowalczyk/Spring-Boot2-course/blob/main/CSV_Formatter_MysqlDb_App/src/main/resources/wykes.png)
- **Link to Backend Code:**  
  [Backend Code MONGO DB](https://github.com/gkowalczyk/Spring-Boot2-course/tree/main/CSV_Formatter_Mongo_DB_App/src/main/java/com/example/csv_formatter_mongo_db_app)
- [Backend Code MYSQL](https://github.com/gkowalczyk/Spring-Boot2-course/tree/main/CSV_Formatter_MysqlDb_App/src/main/java/com/example/csv_formatter_mysqldb_app)

---

## **10. Week 10: Application Testing**


- **Topics:**
  1. Test-driven development (TDD)
  2. Unit testing
  3. Integration testing
  4. End-to-end testing
  5. Quiz
  6. Homework
### **Homework Assignment**
# API Integration Testing and Application Expansion

## ✅ Integration Tests
Write **integration tests** to verify the correctness of the API developed in the past weeks. Ensure that all **GET, POST, PUT, and DELETE** methods work as intended, and that all exception handling cases are properly tested.  
🔹 **Remember to use profiles!** 😊

---

## 🚀 Application Expansion
### If your application stores **vehicles**, then:
- Create a **service method** that:
  - Retrieves all vehicles of a specified color from the database.
  - Changes (repaints) their color to a randomly chosen one.
- Write an appropriate **unit test** for this method.

### If your application stores a **different type of entity (other than a vehicle)**:
- Implement similar logic:
  - Fetch elements from the database based on a given parameter.
  - Randomly assign them a new value.

---

## 📝 Testing Guidelines
🔹 **Unit tests** are sufficient to validate this functionality.  
🔹 If you want to expose this functionality via the **API**, then **integration tests or E2E tests** will be required. 🚀

- **Link to Backend Code:**  
  [Car_Api_App_Testing](https://github.com/gkowalczyk/Spring-Boot2-course/tree/main/CarApiTesting/src)

---

## **11. Week 11: Design Patterns and Reactive Programming**

- **Topics:**
  1. Introduction to DTOs
  2. Factory and Builder patterns
  3. Observables, Flux, and Mono in Spring
  4. Reactive HTTP clients
  5. Reactive database connections
  6. Quiz
  7. Homework

---

## **12. Week 12: Final Project and Deployment**

- **Topics:**
  1. Project implementation (e.g., Face API application)
  2. Building GUI
  3. Deploying on cloud platforms (e.g., PaaS)
  4. Homework
  5. Course summary and next steps


# Spring Security Learning Module

This project demonstrates a practical introduction to Spring Security, covering key concepts such as user authentication, authorization, role-based access control, and login/logout handling.

## 📘 Module 1, 2 Topics

### ✅ 1. Introduction to Spring Security
- What is Spring Security?
- Authentication vs Authorization

### ✅ 2. Project Setup and Dependency Management
- Adding the `spring-boot-starter-security` dependency
- Defining the security configuration class

### ✅ 3. User Definition
- Using `InMemoryUserDetailsManager`
- Creating users (`admin`, `user`) with roles
- Encoding passwords using `BCryptPasswordEncoder`

### ✅ 4. Role Management and Authorization
- Restricting access using `.hasRole(...)`, `.hasAnyRole(...)`
- Optional: `@PreAuthorize` annotations

### ✅ 5. Granting Access to Endpoints
| Endpoint       | Role Access         | Response                               |
|----------------|---------------------|----------------------------------------|
| `/admin`       | ADMIN only          | "Hello admin {name}"                   |
| `/user`        | USER or ADMIN       | "Hello user {name}"                    |
| `/anonymous`   | Everyone            | "Hello {name}" or "Hello stranger"     |
| `/bye`         | Everyone            | "Goodbye"                              |

### ✅ 6. Login Form and Logout Handling
- Using the default Spring Security login page (`/login`)
- Configuring custom `AuthenticationSuccessHandler`
- Redirecting to `/bye` on logout

### ✅ 7. Homework – Task 1 (Required)
Implement the application with the following rules:
- Admin has access to all endpoints
- User has access to `/user`, `/anonymous`, and `/bye`
- Unauthenticated users can access only `/anonymous` and `/bye`
- All users should be redirected to `/bye` after logout
- When a logged-in user accesses `/anonymous`, they should see `"Hello {name}"`

### ✅ 8. Homework – Task 2 (Optional)
Implement a **login counter** that tracks how many times each user has successfully logged in. Display this information in the endpoint responses.

- **Link to Backend Code:**  
  [Backend Code - homework](https://github.com/gkowalczyk/Spring-Boot2-course/tree/main/spring_security_m2/src/main/java/com/example/spring_security_m2)

---
# 🌿 Spring Security – Module 3: User Management

## 📋 Scope

This module covers full user registration and session management flow in a Spring Boot security-based application.

---

## 🔹 Topics Covered

- Introduction
- Registration form
- Storing users in a database
- Activating users via email
- Password reset mechanism
- Session handling (browser side)
- Session handling (database side)
- Notes
- Homework
- Knowledge test

---

## ✅ Homework Task – Basic Version

Implement a complete registration form allowing users to register with either a `User` or `Admin` role.

### Requirements:

- The user selects their role during registration.
- Email confirmation is **always required** to activate the account.
- If a user selects the `Admin` role:
  - A notification email is sent to the **main administrator**.
  - Until the administrator confirms via the activation link, the user has only `User` privileges.
- Add example endpoints to **test the full flow** (registration, activation, login, session, etc.).
- Automatically clean up expired or used **tokens** from the database.
- Thoroughly **validate user input** – no invalid or unsafe data should get through.

---

## 💡 Ambitious Version (Bonus)

In addition to the basic version:

- Add a **custom login form** with an option to choose session duration:
  - `7 days`, `21 days`, or `28 days`
- Use **persistent tokens stored in the database** for `remember-me` sessions.
- Ensure **email verification** is fully working and **required before login**.
- Polish the frontend with:
  - Friendly form validation
  - Clear and accessible error feedback

**Link to Backend Code:**  
[Backend Code - homework](https://github.com/gkowalczyk/Spring-Boot2-course/tree/main/spring_security_m3_hom/src/main/java/com/example/spring_security_m3_hom)

**Link to Frontend Code:**  
[Frontend Code - homework](https://github.com/gkowalczyk/Spring-Boot2-course/tree/main/spring_security_m3_hom/src/main/resources/static/my-app/src)

![User Registration Preview](https://github.com/gkowalczyk/Spring-Boot2-course/raw/refs/heads/main/spring_security_m3_hom/src/main/resources/preview.bmp)



# 🌿 Spring Security – Module 4: User Management: Hash Functions and Encoders**

- **Topics:**
  1. Introduction to hash module
  2. What is a hash function?
  3. Adding salt to the hash
  4. The role of encoders in Spring Security
  5. Overview of hashing algorithms based on BCrypt

### **Task 4: Hash Function and BCrypt Exploration**
- **Description:**  
  This module introduces the concept of hashing in security, explains the need for salting, and discusses encoder strategies in Spring Security. It includes a practical breakdown of the `PasswordEncoder` interface and the BCrypt hashing algorithm with different cost factors.

- **Hands-on:**
  - Implementing your own `PasswordEncoder` with SHA-256 and salt
  - Comparing security of SHA-256 vs BCrypt
  - Breaking weak hashes using dictionary attacks
  - Configuring encoder strategies in Spring Security

**Link to Backend Code:**  
[Backend Code - homework](https://github.com/gkowalczyk/Spring-Boot2-course/blob/main/spring_security_m3_hom/src/main/java/com/example/spring_security_m3_hom/PersonalSha256PasswordEncoder.java)


# 🌿 Spring Security – Module 5: JWT Authentication with RSA

- **Topics:**
What is JWT (JSON Web Tokens)?
1. Symmetric vs. asymmetric signing (HMAC vs. RSA).
2. Generating and signing JWT tokens with a private RSA key.
3. Sending JWT tokens in HTTP Authorization headers.

 Configuring Spring Security to:
1. Extract and verify JWT tokens using a public RSA key
2. Populate the security context from JWT claims
3. Stateless authentication architecture in Spring Boot

✅ Homework Task: JWT Authentication

Requirements:

Client Application:
Load private RSA key from a PEM file, 
generate and sign JWT tokens using RS256, 
send JWT tokens in requests with the Authorization: Bearer <token> header.

Backend Application:
Load the public RSA key from a PEM file for verifying JWT signatures,
configure a JwtFilter to extract and validate tokens, 
grant or deny access based on claims inside the JWT.


**Link to Backend Code - Client:**  
[Backend Code - homework](https://github.com/gkowalczyk/Spring-Boot2-course/tree/main/spring_security_jwt_client/src/main/java/com/example/spring_security_jwt_client)

**Link to Backend Code - API:**  
[Backend Code - homework](https://github.com/gkowalczyk/Spring-Boot2-course/tree/main/spring_security_jwt/src/main/java/com/example/spring_security_jwt)

---
  
## **Author**

This course was created by **Przemysław Bykowski**, an experienced software engineer and Spring Boot expert.

