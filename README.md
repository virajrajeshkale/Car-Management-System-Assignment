# Car Management System 🚗

The Car Management System is a Spring Boot application that allows users to perform CRUD operations on car details. It includes additional features such as global search, pagination, sorting, and input validation. The application is backed by a MySQL database and can be tested using Postman. 🧑‍💻

## Features
1. **CRUD Operations**:
   - Add a new car.
   - View all cars.
   - Update car details.
   - Delete a car.

2. **Additional Functionalities**:
   - **Global Search**: Search cars by name, model, year, color, or fuel type. 🔍
   - **Pagination & Sorting**: Handle large datasets efficiently with pagination and sorting. 📑
   - **Input Validation**: Ensure proper data is submitted for each operation. ✅

## Technologies Used
- **Backend**: Spring Boot
- **Database**: MySQL
- **Testing**: Postman 🛠️

## Deployed Testing URLs [USE POSTMAN] 🌐

The project is deployed and ready to test via the following API endpoints:

### 1. **Add New Car Details** 🚙
- **Type**: POST
- **URL**: (https://carmanagementsystem-0-0-1.onrender.com/api/cars)
  
### 2. **Get All Car Details** 🚗
- **Type**: GET
- **URL**: (https://carmanagementsystem-0-0-1.onrender.com/api/cars)
  
### 3. **Delete Car Details by ID** 🗑️
- **Method**: DELETE
- **URL**: (https://carmanagementsystem-0-0-1.onrender.com/api/cars/4)
  
### 4. **Update Car Details by ID** 🛠️
- **Type**: PUT
- **URL**: (https://carmanagementsystem-0-0-1.onrender.com/api/cars/2)
  
### 5. **Get Car Details by ID** 🔍
- **Type**: GET
- **URL**: (https://carmanagementsystem-0-0-1.onrender.com/api/cars/3)
  
### 6. **Global Search Car Details (Keyword: colour, name, model, fuelType)** 🔍
- **Type**: GET
- **URL**: (https://carmanagementsystem-0-0-1.onrender.com/api/cars/search?keyword=Ertiga)
  
### 7. **Sort & Paginate Car Details** 📊
- **Type**: GET
- **URL**: (https://carmanagementsystem-0-0-1.onrender.com/api/cars?page=1&size=5)


## Setup Instructions

### 1. Clone the Repository

git clone https://github.com/your-username/car-management-system.git](https://github.com/virajrajeshkale/Car-Management-System-Assignment
cd car-management-system

# Database Configuration & API Testing Guide 📋

## Database Configuration

To configure and run the Car Management System, follow the steps below to set up the database:

### 1. Install MySQL
Make sure you have MySQL installed on your system. You can download MySQL from the official website: [MySQL Downloads](https://dev.mysql.com/downloads/).

### 2. Create the Database
- Create a MySQL database named `car_management`.

CREATE DATABASE car_management;

## API Endpoints [Manual SetUp]

### 1. Add a Car 🚙
POST / http://localhost:8080/api/cars

Request Body:
json
Copy code
{
  "name": "Ertiga",
  "model": "2022",
  "year": 2021,
  "price": 120000.00,
  "color": "Blue",
  "fuelType": "CNG"
}
### 2. Get All Cars 🚗
GET / http://localhost:8080/api/cars

This endpoint returns a list of all cars in the system.
### 3. Get Car by ID 🔍
GET /http://localhost:8080/api/cars/{id}

Example: /1 will return the details of the car with ID 1.
### 4. Update a Car 🛠️
PUT /http://localhost:8080/api/cars/{id}

Request Body:
json
Copy code
{
  "name": "Updated Car Name",
  "model": "Updated Model",
  "year": 2022,
  "price": 150000.00,
  "color": "Red",
  "fuelType": "Diesel"
}
Update the details of the car with the specified ID.
### 5. Delete a Car 🗑️
DELETE /http://localhost:8080/api/cars/{id}

Example: /4 will delete the car with ID 4 from the system.
### 6. Global Search 🔍
GET /http://localhost:8080/api/cars/search?keyword=Diesel

Query Parameter:

keyword (e.g., name, model, fuelType, etc.)
Example: /search?keyword=Ertiga will search for cars with "Ertiga" in their name or details.

### 7. Sort and Paginate 📊
GET / http://localhost:8080/api/cars?page=1&size=5&sortBy=Asc

Query Parameters:

page (default: 0)
size (default: 10)
sortBy (default: "id")
sortDir (default: "asc")
Example: /cars?page=1&size=5 will return the first 5 cars, sorted by ID in ascending order.

### Testing with Postman 📬
Open Postman and create a new request.
Choose the request type (GET, POST, PUT, DELETE) as per the endpoint.
Copy the URL from the endpoints section.
For POST and PUT requests, include the relevant JSON in the body.
Hit Send and view the response.

