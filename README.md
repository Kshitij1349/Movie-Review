# 🎬 Movie Review API

A RESTful API built with **Spring Boot** that allows users to manage movies and their reviews. The application follows a clean layered architecture with Controllers, Services, and Repositories, and uses DTOs to separate the API layer from the database layer.

---

## 🛠️ Tech Stack

| Technology | Purpose |
|---|---|
| Java 21 | Core language |
| Spring Boot | Application framework |
| Spring MVC | REST API layer |
| Spring Data JPA | Database abstraction |
| Hibernate | ORM |
| MySQL | Database |
| Lombok | Boilerplate reduction |

---

## ✨ Features

### 🎥 Movie Management
- Add new movies with details like name, director, duration and release date
- Retrieve all movies or a specific movie by id
- Update movie details
- Delete a movie

### 👤 User Management
- Register new users
- Retrieve all users or a specific user by id
- Update user details
- Delete a user

### ⭐ Review Management
- Add a review for a movie by a user with rating and content
- Retrieve all reviews
- Retrieve all reviews for a specific movie
- Update a review
- Delete a review

---

## 🏗️ Architecture

The project follows a strict **3-layer architecture**:

```
Client
  │
  ▼
Controller Layer   →   Handles HTTP requests/responses, uses DTOs
  │
  ▼
Service Layer      →   Contains business logic, converts DTOs ↔ Entities
  │
  ▼
Repository Layer   →   Handles all database operations via Spring Data JPA
  │
  ▼
Database (MySQL)
```

---

## 🗄️ Database Design

Three entities with the following relationships:
- `User` has many `Reviews`
- `Movie` has many `Reviews`
- `Review` belongs to both a `User` and a `Movie`

```
User (1) ──────→ (Many) Review (Many) ←────── (1) Movie
```

---

## 📡 API Endpoints

### 🎥 Movies
| Method | Endpoint | Description |
|---|---|---|
| `GET` | `/api/movies` | Get all movies |
| `GET` | `/api/movies/{id}` | Get movie by id |
| `POST` | `/api/movies` | Add new movie |
| `PUT` | `/api/movies/{id}` | Update movie |
| `DELETE` | `/api/movies/{id}` | Delete movie |

### 👤 Users
| Method | Endpoint | Description |
|---|---|---|
| `GET` | `/api/users` | Get all users |
| `GET` | `/api/users/{id}` | Get user by id |
| `POST` | `/api/users` | Add new user |
| `PUT` | `/api/users/{id}` | Update user |
| `DELETE` | `/api/users/{id}` | Delete user |

### ⭐ Reviews
| Method | Endpoint | Description |
|---|---|---|
| `GET` | `/api/reviews` | Get all reviews |
| `GET` | `/api/reviews/movie/{id}` | Get all reviews for a movie |
| `POST` | `/api/reviews` | Add new review |
| `PUT` | `/api/reviews/{id}` | Update review |
| `DELETE` | `/api/reviews/{id}` | Delete review |

---

## 💡 Key Concepts Demonstrated

- ✅ RESTful API design principles
- ✅ Clean layered architecture (Controller → Service → Repository)
- ✅ Entity relationships with JPA (`@OneToMany`, `@ManyToOne`)
- ✅ DTO pattern to separate API and database layers
- ✅ Spring Data JPA for database operations
- ✅ Custom repository queries (`findByMovieId`)
- ✅ Exception handling with meaningful error messages
- ✅ Lombok for reducing boilerplate code

---

## ⚙️ Setup & Installation

1. **Clone the repository**
```bash
https://github.com/Kshitij1349/Movie-Review.git
cd MovieRating
```

2. **Configure the database** — create `application.properties` in `src/main/resources/`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/movierating
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

3. **Run the application**
```bash
./mvnw spring-boot:run
```

4. **API is available at:**
```
http://localhost:8080
```

---

## 📝 Sample Requests

**Add a Movie**
```json
POST /api/movies
{
    "name": "Inception",
    "duration": 148.0,
    "director": "Christopher Nolan",
    "releaseDate": "2010-07-16"
}
```

**Add a Review**
```json
POST /api/reviews
{
    "user_id": 1,
    "movie_id": 1,
    "rating": 5,
    "content": "Absolutely brilliant movie!"
}
```
