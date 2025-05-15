# 🛒 eCommerce Microservices Project

This project is an **eCommerce Application** built using a **Microservices Architecture**.

## 🛠️ Technologies Used

- **Java 8**
- **Spring Boot**
- **Spring Security**
- **Spring Data JPA**
- **JWT (JSON Web Token)**
- **Eureka (Service Discovery)**
- **Spring Cloud Gateway (API Gateway)**
- **Swagger (API Documentation)**

## 🧩 Microservices Included

- **User Service**
- **Inventory Service**
- **Order Service**
- **Product Service**
- **Eureka Discovery Service**
- **API Gateway**

## 🔗 Swagger Documentation

Each microservice exposes its API documentation through Swagger:

- **Product Service**: [http://localhost:8040/swagger-ui/index.html#/](http://localhost:8040/swagger-ui/index.html#/)
- **Inventory Service**: [http://localhost:8010/swagger-ui/index.html#/](http://localhost:8020/swagger-ui/index.html#/)
- **Order Service**: [http://localhost:8020/swagger-ui/index.html#/](http://localhost:8010/swagger-ui/index.html#/)
- **User Service**: [http://localhost:9000/swagger-ui/index.html#/](http://localhost:9000/swagger-ui/index.html#/)

## 🚀 Application Access

The entire application is accessible through the API Gateway on port `8080`.

---

> 🔒 Security is implemented using **JWT-based authentication** across services to protect APIs and ensure secure communication.
