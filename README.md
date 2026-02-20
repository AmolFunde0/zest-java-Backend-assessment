# Zest India – Java Backend Developer Assignment

## 📌 Project Title
Product Management REST API with JWT Authentication and Role-Based Authorization

---

## 📖 Project Overview

This project is a RESTful API built using **Java 17 and Spring Boot** to manage Products and their Items.  
It supports full CRUD operations, JWT-based authentication, role-based authorization, pagination, validation, and Dockerized deployment.

The system is designed using clean layered architecture and follows REST API best practices.

---

## 🏗 Architecture Overview

The application follows a standard layered architecture:

Controller → Service → Repository → Database

Security Flow:

Client → Login → JWT Token → Authorization Header → JWT Filter → Secured APIs

---

## 🛠 Tech Stack

- Java 17
- Spring Boot 3.x
- Spring Data JPA (Hibernate)
- PostgreSQL
- Spring Security
- JWT (Access Token + Refresh Token)
- Jakarta Validation
- Swagger / OpenAPI
- JUnit 5 & Mockito
- H2 (Test Database)
- Docker & Docker Compose
- Maven

---

## 📂 Project Structure


com.zest.assignment
│
├── config
├── controller
├── service
├── repository
├── entity
├── dto
├── security
├── exception
└── DemoApplication.java


---

## 🔐 Security Implementation

### Authentication
- JWT-based authentication
- Access Token (15 minutes expiry)
- Refresh Token (7 days expiry)

### Authorization
Role-based access control:

| Endpoint | ROLE_USER | ROLE_ADMIN |
|----------|-----------|------------|
| GET /products | ✅ | ✅ |
| POST /products | ❌ | ✅ |
| PUT /products | ❌ | ✅ |
| DELETE /products | ❌ | ✅ |

### Security Features
- Stateless session management
- BCrypt password encryption
- JWT filter validation
- Custom error handling
- Refresh token endpoint
--
## 📡 API Endpoints

### Authentication

POST `/api/v1/auth/login`

Request:
```json
{
  "username": "admin",
  "password": "admin123"
}

Response:

{
  "accessToken": "...",
  "refreshToken": "..."
}

POST /api/v1/auth/refresh

Request:

{
  "refreshToken": "..."
}
Product APIs

GET /api/v1/products?page=0&size=5

GET /api/v1/products/{id}

POST /api/v1/products

PUT /api/v1/products/{id}

DELETE /api/v1/products/{id}

📊 Database Schema
Product Table
Column	Type
id	Integer
product_name	VARCHAR
created_by	VARCHAR
created_on	TIMESTAMP
modified_by	VARCHAR
modified_on	TIMESTAMP
Item Table
Column	Type
id	Integer
product_id	FK
quantity	Integer
⚙ Pagination

Implemented using Spring Data Pageable.

Example:

GET /api/v1/products?page=0&size=10
❗ Global Exception Handling

Custom standardized error response format:

{
  "timestamp": "...",
  "status": 404,
  "error": "Not Found",
  "message": "Product not found with id: 99"
}
🧪 Testing
Unit Testing

JUnit 5

Mockito

Service layer testing

Exception case testing

Integration Testing

Spring Boot Test

MockMvc

H2 in-memory database

📘 Swagger Documentation

After running the application:

http://localhost:8080/swagger-ui/index.html
🚀 Running Locally
Step 1: Clone Repository
git clone <repository-url>
Step 2: Configure Database

Update application.properties with PostgreSQL credentials.

Step 3: Build Project
mvn clean package
Step 4: Run Application
mvn spring-boot:run
🐳 Running with Docker
Step 1: Build JAR
mvn clean package
Step 2: Run Docker
docker compose up --build

Application will run on:

http://localhost:8080

Swagger:

http://localhost:8080/swagger-ui/index.html
📈 Evaluation Criteria Coverage

✔ Clean Architecture
✔ RESTful API Design
✔ API Versioning
✔ JWT Authentication
✔ Role-Based Authorization
✔ Validation
✔ Pagination
✔ Global Exception Handling
✔ Unit Testing
✔ Integration Testing
✔ Swagger Documentation
✔ Dockerized Deployment

⏱ Time Taken

(You can mention actual time taken here.)

👤 Author

Amol Funde
Java Backend Developer Candidate
Zest India Assignment Submission
