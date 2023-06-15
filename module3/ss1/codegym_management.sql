CREATE DATABASE `codegym_management`;
CREATE TABLE `codegym_management`.`student`(
`id_student` INT primary key, 
`name_student` VARCHAR(45),
`birthday` DATE,
`gender` VARCHAR(10),
 `email` VARCHAR(20),
 `score` float,
 `name_class` VARCHAR(10),
 foreign key (`name_class`) references class(name_class)
);

CREATE TABLE `codegym_management`.`class` (
`name_class` VARCHAR(10) primary key);

CREATE TABLE `codegym_management`.`teacher` (
`id_teacher` INT primary key,
`name_teacher` VARCHAR(45),
`salary` FLOAT(10,2),
`name_class` VARCHAR(10),
 foreign key(`name_class`) references class(name_class)
);

CREATE TABLE `codegym_management`.`jame_account`(
`account` VARCHAR(20),
`password` VARCHAR(30),
`id_student` INT,
foreign key (`id_student`) references student(id_student)
);
 
 SELECT *
 from teacher;