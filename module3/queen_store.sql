CREATE DATABASE queen_store;
USE queen_store;
CREATE TABLE customer (
	customer_id INT AUTO_INCREMENT PRIMARY KEY,
    customer_name VARCHAR(100),
    customer_gender BIT,
    customer_id_card INT,
    customer_phone_number VARCHAR(50),
    customer_mail VARCHAR(50),
    customer_address VARCHAR(100),
    type_of_customer_id INT,
    FOREIGN KEY (type_of_customer_id) REFERENCES type_of_customer(type_of_customer_id),
    customer_user_name VARCHAR(100),
    FOREIGN KEY (customer_user_name) REFERENCES customer_account(customer_user_name)
    );
CREATE TABLE type_of_customer (
	type_of_customer_id INT AUTO_INCREMENT PRIMARY KEY,
    type_of_customer_name VARCHAR(100)
    );
CREATE TABLE customer_account (
	customer_user_name VARCHAR(100) NOT NULL PRIMARY KEY,
    customer_password VARCHAR(100)
    );
    