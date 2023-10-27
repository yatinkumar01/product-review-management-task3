# Product and Review Management API

## Overview

This Java Spring Boot application with MySQL integration is designed to manage products and their associated reviews. The application includes two models: Product and Review. The Product model includes attributes such as name, price, creation date (cDate), update date (uDate), and a unique identifier (_id). The Review model includes userId, description, creation date (cDate), update date (uDate), and a unique identifier (_id). The application provides RESTful API endpoints for CRUD operations on products and reviews, including virtual population of reviews for a product.

## Table of Contents
- [Project Setup](#project-setup)
  - [Prerequisites](#prerequisites)
  - [Clone the Repository](#clone-the-repository)
  - [Database Configuration](#database-configuration)
  - [Build and Run the Application](#build-and-run-the-application)
- [API Endpoints](#api-endpoints)
  - [1. Product Endpoints](#1-product-endpoints)
  - [2. Review Endpoints](#2-review-endpoints)
- [Sample Requests and Responses](#sample-requests-and-responses)
- [Virtual Population of Reviews](#virtual-population-of-reviews)
- [Additional Notes](#additional-notes)

## Project Setup

### Prerequisites
- Java Development Kit (JDK) 11 or higher
- Apache Maven
- MySQL Database Server

### Clone the Repository
```bash
git clone https://github.com/yatinkumar01/product-review-api.git
cd product-review-api
