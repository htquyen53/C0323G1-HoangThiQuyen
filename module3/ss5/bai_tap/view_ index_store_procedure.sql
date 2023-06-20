CREATE DATABASE demo;
USE demo; 

CREATE TABLE products (
	id INT AUTO_INCREMENT PRIMARY KEY,
	productCode INT NOT NULL,
	productName VARCHAR(100),
	productPrice DOUBLE,
	productAmount INT NOT NULL,
	productDescription VARCHAR(255),
	productStatus VARCHAR(50)
    );
INSERT INTO products 
VALUES (1, 1, "Kem chống nắng", 165000, 5, "Chống nắng tốt", "Nguyên tem"),
		(2, 2, "Kem dưỡng thể", 165000, 10, "Dưỡng trắng", "Nguyên tem");
-- tạo index
create unique index kem_chong_nang on products(productCode);
explain select * 
from products
where productCode = 1;
-- tạo và xóa view
create view view_product as
select productCode, productName, productPrice, productStatus
from products;
drop view view_product;
-- Tạo store procedure lấy tất cả thông tin của tất cả các sản phẩm trong bảng product
delimiter //
create procedure get_info (in name varchar(100)) 
begin
	select * from products p
    where p.productName = name;
end //
delimiter ;
call get_info ("Kem chống nắng"); 
