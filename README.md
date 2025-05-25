# Hotel Rating Microservices System 🏨⭐

This project is a microservices-based hotel rating system built with Spring Boot. It demonstrates service decomposition, inter-service communication, and RESTful APIs in a real-world-like application.

## 🧩 Microservices Overview

### 1. User Service
- Manages user data
- Fetches user ratings from the Rating Service
- Fetches hotel data from the Hotel Service
- Composes a complete response for frontend clients

### 2. Rating Service
- Stores and provides hotel ratings made by users
- API Endpoint: `/ratings/users/{userId}`

### 3. Hotel Service
- Manages hotel information
- API Endpoint: `/hotels/{hotelId}`

## 🔗 Tech Stack
- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- RestTemplate (for inter-service calls)
- Maven
- MySQL
- Lombok
- Jackson (for object mapping)

## ⚙️ Features
- Inter-service communication
- JSON object mapping from external responses
- Exception handling (e.g., `ResourceNotFoundException`)
- Microservices are independent and testable

## 🚀 Getting Started

To run each service:

```bash
cd user-service
mvn spring-boot:run

cd rating-service
mvn spring-boot:run

cd hotel-service
mvn spring-boot:run
