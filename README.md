# Customer Microservice 

## Overview

Customer Microservice is a Spring Boot REST API for managing customer data in the Banking Application.

### Features

* Add Customer
* Get Customer By ID
* Get All Customers
* Update Customer
* Delete Customer

---

## Tech Stack

* Java 21
* Spring Boot
* Spring Data JPA
* PostgreSQL
* Maven

---

## API Endpoints

```http
POST   /customer/add
GET    /customer/{customerId}
GET    /customer/all
PUT    /customer/update/{customerId}
DELETE /customer/delete/{customerId}
```

---

## Database Configuration

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/customer
spring.jpa.hibernate.ddl-auto=update
```

---

## Run Application

```bash
git clone https://github.com/joy101020/Customer.git
cd Customer
mvn spring-boot:run
```

Runs on:

```text
http://localhost:8081
```

---

## Author
Srinjoy Das
