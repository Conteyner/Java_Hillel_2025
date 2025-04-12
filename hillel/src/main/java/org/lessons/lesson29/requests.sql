CREATE DATABASE sales_database;

CREATE TABLE sales (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    product VARCHAR(256),
    price DECIMAL,
    quantity INT
);

CREATE TABLE sales (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    product VARCHAR(256),
    price DECIMAL,
    quantity INT
);

INSERT INTO sales (product, price, quantity) VALUES
    ('Laptop', 1000, 5),
    ('Phone', 700, 3),
    ('Tablet', 500, 2),
    ('Printer', 300, 4);

SELECT * FROM sales;

SELECT * FROM sales
LIMIT 2;

SELECT SUM(price * quantity) AS total_value
FROM sales;

SELECT product,
       SUM(quantity),
       AVG(price)
FROM sales
GROUP BY product;
