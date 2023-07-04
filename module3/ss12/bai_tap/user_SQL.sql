CREATE DATABASE users;
USE users;
CREATE TABLE users (
id int(3) NOT NULL AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(120) NOT NULL,
email VARCHAR(220) NOT NULL,
country VARCHAR(120)
);
insert into users(name, email, country)
values("Minh", "minh@codegym.vn","Viet Nam");
insert into users(name, email, country)
values("Kante", "kante@gmail.com", "Kenia");
select *
from users;
