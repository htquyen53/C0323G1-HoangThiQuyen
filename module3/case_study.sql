DROP DATABASE IF EXISTS furama_management_system;
CREATE DATABASE furama_management_system;
USE furama_management_system;

CREATE TABLE rental_type (
    code_rental INT AUTO_INCREMENT PRIMARY KEY,
    name_rental_type VARCHAR(45)
);

CREATE TABLE service_type (
    code_service INT AUTO_INCREMENT PRIMARY KEY,
    name_service_type VARCHAR(45)
);

CREATE TABLE services (
    code_service INT AUTO_INCREMENT PRIMARY KEY,
    name_service VARCHAR(45) NOT NULL,
    area INT,
    rental_cost DOUBLE NOT NULL,
    maximum_occupancy INT,
    room_standard VARCHAR(45),
    other_facilities VARCHAR(45),
    pool_area DOUBLE,
    number_of_floor INT,
	rental_code INT,
    FOREIGN KEY (rental_code)
        REFERENCES rental_type (code_rental),
    service_code INT,
    FOREIGN KEY (service_code)
        REFERENCES service_type (code_service)
);
CREATE TABLE accompanied_service (
    accompanied_service_code INT AUTO_INCREMENT PRIMARY KEY,
    accompanied_service_name VARCHAR(45),
    accompanied_service_price DOUBLE,
    accompanied_service_unit VARCHAR(10),
    accompanied_service_status VARCHAR(45)
);

CREATE TABLE position (
    position_code INT AUTO_INCREMENT PRIMARY KEY,
    position_name VARCHAR(45)
);
CREATE TABLE academic_level (
    academic_level_code INT AUTO_INCREMENT PRIMARY KEY,
    academic_level_name VARCHAR(45)
);
CREATE TABLE department (
    department_code INT AUTO_INCREMENT PRIMARY KEY,
    department_name VARCHAR(45)
);
CREATE TABLE employer (
    employer_code INT AUTO_INCREMENT PRIMARY KEY,
    full_name VARCHAR(45),
    birthday DATE,
    citizen_id VARCHAR(45),
    salary DOUBLE,
    numberphone VARCHAR(45) NOT NULL,
    email VARCHAR(45),
    address VARCHAR(45),
    position_code INT,
    FOREIGN KEY (position_code)
        REFERENCES position (position_code),
    academic_level_code INT,
    FOREIGN KEY (academic_level_code)
        REFERENCES academic_level (academic_level_code),
    department_code INT,
    FOREIGN KEY (department_code)
        REFERENCES department (department_code)
);
CREATE TABLE customer_type (
    customer_type_code INT AUTO_INCREMENT PRIMARY KEY,
    type_of_customer VARCHAR(45)
);
CREATE TABLE customer (
    customer_code INT AUTO_INCREMENT PRIMARY KEY,
    full_name VARCHAR(45),
    birthday DATE,
    gender BIT(1),
    citizenID VARCHAR(45),
    numberphone VARCHAR(45) NOT NULL,
    email VARCHAR(45),
    address VARCHAR(45),
	customer_type_code INT,
    FOREIGN KEY (customer_type_code)
        REFERENCES customer_type (customer_type_code)
);
CREATE TABLE contract (
    contract_code INT AUTO_INCREMENT PRIMARY KEY,
    contract_date DATETIME,
    contract_end_date DATETIME,
    deposits DOUBLE,
    employer_code INT,
    FOREIGN KEY (employer_code)
        REFERENCES employer (employer_code),
    customer_code INT,
    FOREIGN KEY (customer_code)
        REFERENCES customer (customer_code),
    code_service INT,
    FOREIGN KEY (code_service)
        REFERENCES services (code_service)
);
CREATE TABLE contract_detail (
    contract_detail_code INT AUTO_INCREMENT PRIMARY KEY,
	quantity INT,
    contract_code INT,
    FOREIGN KEY (contract_code)
        REFERENCES contract (contract_code),
    accompanied_service_code INT,
    FOREIGN KEY (accompanied_service_code)
        REFERENCES accompanied_service (accompanied_service_code)
);


