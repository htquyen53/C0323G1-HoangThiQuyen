DROP DATABASE IF exists `customer_management`;
CREATE DATABASE `customer_management`;
USE `customer_management`;

	CREATE TABLE `customer` (
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
	`code` VARCHAR(20) NOT NULL UNIQUE,
	`name` VARCHAR(100),
	`birthday` DATE NOT NULL,
	`address` VARCHAR(255),
	`phone_number` VARCHAR(20) NOT NULL UNIQUE,
	`email` VARCHAR(100) NOT NULL UNIQUE,
	`point` BIGINT DEFAULT(0),
	`note` TEXT,
	`flag_deleted` BIT(1),
	`id_app_user` BIGINT NOT NULL UNIQUE,
	FOREIGN KEY (`id_app_user`) REFERENCES app_user (`id_app_user`)
	);

