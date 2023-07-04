CREATE DATABASE queen_store;
USE queen_store;
CREATE TABLE customer (
	customer_id INT AUTO_INCREMENT PRIMARY KEY,
    customer_name VARCHAR(100) NOT NULL,
    customer_gender BIT(1) NOT NULL,
    customer_id_card VARCHAR(20) NOT NULL,
    customer_phone_number VARCHAR(20) NOT NULL,
    customer_mail VARCHAR(50),
    customer_address VARCHAR(100),
    type_of_customer_id INT,
    FOREIGN KEY (type_of_customer_id) REFERENCES type_of_customer(type_of_customer_id),
    customer_user_name VARCHAR(100) NOT NULL,
    FOREIGN KEY (customer_user_name) REFERENCES customer_account(customer_user_name)
    );
CREATE TABLE type_of_customer (
	type_of_customer_id INT AUTO_INCREMENT PRIMARY KEY,
    type_of_customer_name VARCHAR(100)
    );
CREATE TABLE customer_account (
	customer_user_name VARCHAR(100) PRIMARY KEY,
    customer_password VARCHAR(100)
    );
    