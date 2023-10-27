# REST API for Product & Review Management.

This Java Spring Boot application with MySQL integration is designed to manage products and their associated reviews. The application includes two models: Product and Review. The Product model includes attributes such as name, price, creation date (cDate), update date (uDate), and a unique identifier (_id). The Review model includes userId, description, creation date (cDate), update date (uDate), and a unique identifier (_id). The application provides RESTful API endpoints for CRUD operations on products and reviews, including virtual population of reviews for a product.

## Setup Instructions

### Prerequisites
- Java Development Kit (JDK) 11 or higher
- Apache Maven
- MySQL Database Server

### Clone the Repository
```bash
git clone https://github.com/your-username/product-review-api.git
cd product-review-api



## Features

### Product Model:

- **Attributes:** The Product model includes attributes such as Name, Price, cDate (Creation Date), uDate (Update Date), and a unique identifier (_id).
- **Functionality:** Implement functionality to add, read all, read by ID, update, and delete products.

### Review Model:

- **Attributes:** The Review model includes attributes such as userId, description, cDate (Creation Date), uDate (Update Date), and a unique identifier (_id).
- **Functionality:** Implement functionality to add and delete reviews.

# Tech Stack

- Java
- Spring Boot
- Spring MVC
- Hibernate
- Spring Data JPA
- MySQL
- Maven
- Git

# API Endpoints
## API Endpoints

### 1. Product Endpoints

- **Add a Product:**
  - **Endpoint:** `POST /api/products`
  - **Request Body:**
    ```json
    {
      "name": "Product Name",
      "price": 29.99
    }
    ```

- **Read All Products:**
  - **Endpoint:** `GET /api/products`

- **Read Product by ID:**
  - **Endpoint:** `GET /api/products/{id}`

- **Update a Product:**
  - **Endpoint:** `PUT /api/products/{id}`
  - **Request Body:**
    ```json
    {
      "name": "Updated Product Name",
      "price": 39.99
    }
    ```

- **Delete a Product:**
  - **Endpoint:** `DELETE /api/products/{id}`

### 2. Review Endpoints

- **Create a Review for a Product:**
  - **Endpoint:** `POST /api/products/{productId}/reviews`
  - **Request Body:**
    ```json
    {
      "userId": "user123",
      "description": "Great product! Highly recommended."
    }
    ```

- **Delete a Review:**
  - **Endpoint:** `DELETE /api/products/{productId}/reviews/{reviewId}`

- **Virtual Population of Reviews for a Product:**
  - **Endpoint:** `GET /api/products/{productId}/reviews`


# Contributors
- [Yatin Kumar](https://github.com/yatinkumar01)
