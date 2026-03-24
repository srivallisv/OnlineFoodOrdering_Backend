-- FoodOrderingSystem Database Script

-- Users Table
CREATE TABLE users (
    id NUMBER PRIMARY KEY,
    name VARCHAR2(100) NOT NULL,
    email VARCHAR2(100) UNIQUE NOT NULL,
    password VARCHAR2(50) NOT NULL
);

-- Restaurants Table
CREATE TABLE restaurants (
    id NUMBER PRIMARY KEY,
    name VARCHAR2(100) NOT NULL,
    location VARCHAR2(100) NOT NULL
);

-- Orders Table
CREATE TABLE orders (
    id NUMBER PRIMARY KEY,
    user_id NUMBER REFERENCES users(id),
    restaurant_id NUMBER REFERENCES restaurants(id),
    order_date DATE DEFAULT SYSDATE,
    total NUMBER(10,2) NOT NULL
);

-- Sample Data
INSERT INTO users (id, name, email, password) VALUES (1, 'Alice', 'alice@example.com', 'pass123');
INSERT INTO restaurants (id, name, location) VALUES (1, 'Pizza Place', 'Downtown');
INSERT INTO orders (id, user_id, restaurant_id, total) VALUES (1, 1, 1, 250.50);