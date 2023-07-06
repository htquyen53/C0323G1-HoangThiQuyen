DROP DATABASE if exists users;
CREATE DATABASE users;
USE users;
CREATE TABLE users (
id int(3) NOT NULL AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(120) NOT NULL,
email VARCHAR(220) NOT NULL,
country VARCHAR(120)
);
insert into users(name, email, country)
values("oanh", "a@codegym.vn","Viet Nam");
insert into users(name, email, country)
values("Kante", "kante@gmail.com", "Kenia");

select *
from users;

DELIMITER //
create procedure select_all()
BEGIN
	select * from users;
END //
DELIMITER ;
call select_all();
DELIMITER //
create procedure update_user(IN user_id INT, IN user_name VARCHAR(120), IN user_email VARCHAR(220), IN user_country VARCHAR(120))
BEGIN
UPDATE users SET name = user_name, email = user_email, country = user_country
WHERE id = user_id;
END //
DELIMITER ;

drop procedure if exists update_user;

call update_user(2,"Kante J","kante@gmail.com","Kenia");

DELIMITER //
create procedure delete_user(IN user_id int)
BEGIN
delete from users
WHERE id = user_id;
END //
DELIMITER ;

drop procedure if exists delete_user;
call delete_user(2);

DELIMITER //
create procedure sort_by_name()
BEGIN
select * 
from users
order by name asc;
END //
DELIMITER ;
drop procedure if exists sort_by_name;
call sort_by_name();