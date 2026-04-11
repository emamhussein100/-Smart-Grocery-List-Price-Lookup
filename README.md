# 🛒 Smart Grocery List & Price Lookup

A full-stack web application built with **Spring Boot 3 + Angular 16** that allows admins to manage grocery products and users to build personal shopping lists.

---
a
# 🚀 Features

## 👨‍💼 Admin Features

* Admin login (JWT authentication)
* Search meals/products from external API
* Add products to local database (approved items)
* Bulk import products
* Delete products
* Paginated product management

---

## 🧑 User Features

* User login (JWT authentication)
* View approved grocery products
* Search/filter products by name/category
* View product details:

  * Calories
  * Brand
  * Price
  * Category
* Create shopping lists
* Add products with quantity to shopping list

---

# 🏗️ Tech Stack

## Backend

* Java 17
* Spring Boot 3
* Spring Security + JWT
* Spring Data JPA
* PostgreSQL
* Maven

## Frontend

* Angular 16+
* TypeScript
* RxJS
* Standalone Components
* Angular Forms (ngModel)

---

# 📁 Project Structure

## Backend

```
src/main/java/org/example/smartgrocery
│
├── controller
├── service
├── entity
├── dto
├── repository
├── mapper
├── util (JWT)
```

## Frontend

```
src/app
│
├── core
│   ├── services
│   ├── interceptors
│
├── models
├── features
│   ├── admin-dashboard
│   ├── user-dashboard
│   ├── auth
```

---

# 🔐 Authentication

JWT-based authentication system.

### Token contains:
```json
{
  "username": "admin123",
  "password": "admin123",
}
```json
{
  "username": "emam123",
  "password": "emam123",
}
```

```json
{
  "sub": "username",
  "role": "USER/ADMIN",
  "userId": 1
}
```

### Frontend:

* Token stored in localStorage
* Sent via HTTP interceptor

---

# 🗄️ Database Design

## Main Tables:

* users
* products
* shopping_list
* shopping_list_items

## Relationships:

* User → ShoppingList (1 to many)
* ShoppingList → Products (via ShoppingListItem)
* ShoppingListItem contains quantity

---

# 📦 API Endpoints

## Auth

```
POST /auth/login
```

## Admin

```
GET    /admin/search?query=
POST   /admin/products
POST   /admin/products/bulk
DELETE /admin/products/{id}
```

## Products

```
GET /products/all
GET /products/search?keyword=
GET /products/all/page?page=0&size=5
```

## Shopping List

```
POST /shoppingList/create/{userId}
POST /shoppingList/addProduct
```

---

# ⚙️ Setup Instructions

## 1️⃣ Backend Setup

```bash
cd backend
mvn spring-boot:run
```

### application.properties

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/smart_grocery
spring.datasource.username=postgres
spring.datasource.password=your_password
```

Runs on:

```
http://localhost:8080
```

---

## 2️⃣ Frontend Setup

```bash
cd frontend
npm install
ng serve
```

Runs on:

```
http://localhost:4200
```

---

# 🔗 Flow

1. Admin imports meals from API
2. Products saved in DB
3. Users login via JWT
4. Users view products
5. Users create shopping list
6. Users add products with quantity

---

# 📌 Future Improvements

* Role-based route guards
* Cart page (update/remove items)
* Analytics dashboard
* Product ratings
* Mobile responsive UI
* Notifications

---

# 👨‍💻 Author

Emam Hussein
Full Stack Developer (Java + Angular)

---

# ⭐ Notes

Built as a software engineering assessment project using:

* Spring Boot 3
* Angular 16
* JWT authentication
* REST APIs
* Clean architecture
