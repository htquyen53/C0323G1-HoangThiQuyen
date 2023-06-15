CREATE DATABASE furama_management_system;

CREATE TABLE furama_management_system.rental_type (
code_rental INT NOT NULL primary key,
name_rental_type VARCHAR(45)
);

CREATE TABLE furama_management_system.service_type (
code_service INT NOT NULL primary key,
name_service_type VARCHAR(45)
);

CREATE TABLE furama_management_system. services (
code_service INT NOT NULL primary key,
name_service VARCHAR(45) NOT NULL,
area INT,
rental_cost DOUBLE NOT NULL,
maximum_occupancy INT,
rental_code INT,
foreign key (rental_code) references rental_type(code_rental),
service_code INT,
foreign key (service_code) references service_type(code_service),
room_standard VARCHAR(45),
other_facilities VARCHAR(45),
pool_area DOUBLE,
number_of_floor INT);
