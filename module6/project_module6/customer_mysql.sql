SELECT * FROM retro_care.customer;
insert into customer 
values (1, 'KL0001','Đàm Thoại Tin','1998-01-01','Sơn Trà, Đà Nẵng','0913123456','tindt@gmail.com',0, 'Không có tiền sử huyết áp cao',true,1),
		(2, 'KL0002','Đàm Thoại Tín','1998-01-01','Sơn Trà, Đà Nẵng','0913123457','tindta@gmail.com',0, 'Không có tiền sử huyết áp cao',true,2),
        (3, 'KL0003','Đàm Như Ngọc','1998-01-01','Sơn Trà, Đà Nẵng','0913123458','tindtb@gmail.com',0, 'Không có tiền sử huyết áp cao',true,3),
        (4, 'KL0004','Đàm Ánh Tuyết','1998-01-01','Sơn Trà, Đà Nẵng','0913123459','tindtc@gmail.com',0, 'Không có tiền sử huyết áp cao',true,4),
        (5, 'KL0005','Đàm Thoại Ngọc','1998-01-01','Sơn Trà, Đà Nẵng','0913123450','tindtd@gmail.com',0, 'Không có tiền sử huyết áp cao',true,5);
        insert into customer 
values (6, 'KL0006','Đàm Thoại Anh','1998-01-01','Sơn Trà, Đà Nẵng','0913123409','tindt6@gmail.com',0, 'Không có tiền sử huyết áp cao',true,null),
		(7, 'KL0007','Đàm Thoại Tín','1998-01-01','Sơn Trà, Đà Nẵng','0913123407','tindt7a@gmail.com',0, 'Không có tiền sử huyết áp cao',true,null),
        (8, 'KL0008','Đàm Như Ngọc','1998-01-01','Sơn Trà, Đà Nẵng','0913123451','tindtb8@gmail.com',0, 'Không có tiền sử huyết áp cao',true,null),
        (9, 'KL0009','Đàm Ánh Tuyết','1998-01-01','Sơn Trà, Đà Nẵng','0913123109','tindt9c@gmail.com',0, 'Không có tiền sử huyết áp cao',true,null),
        (10, 'KL00010','Đàm Thoại Ngọc','1998-01-01','Sơn Trà, Đà Nẵng','0913124450','tin0dtd@gmail.com',0, 'Không có tiền sử huyết áp cao',true,null);
        
        select c.code, c.name, c.birthday, c.address, c.phone_number, c.note, e.code as type 
        from customer c
        join app_user au on c.app_user_id = au.id
        join employee e on e.app_user_id = au.id
        join user_order uo on uo.app_user_id = au.id 
        right join orders o on o.id = uo.order_id
        group by c.code;
        
SELECT *
FROM orders o
left JOIN user_order uo ON uo.order_id = o.id
JOIN app_user au ON au.id = uo.app_user_id
JOIN customer c ON c.app_user_id = au.id;
-- JOIN employee e ON e.app_user_id = au.id;

-- Hiển thị danh sách khách hàng đã mua hàng        
SELECT c.code, c.name, c.birthday, c.address, c.phone_number, c.note
from customer c
where c.app_user_id in (
select uo.app_user_id
from user_order uo);

-- Hiển thị danh sách khách hàng đã mua hàng có phân loại

SELECT code, name, birthday, address, phone_number, note,
    CASE
        WHEN app_user_id IS NULL THEN 'khách lẻ'
        ELSE 'khách online'
    END AS type
FROM customer
where name like '%%' and code like '%%' and address like '%%' and app_user_id is null or app_user_id
ORDER BY code;

DELIMITER //
CREATE Procedure getAll (in input_name varchar(100), in input_code varchar(20), in input_address varchar(255), in appUserId int, in input_sort varchar(20) )
BEGIN
SELECT 
        code, name, birthday, address, phone_number, note,
        CASE
            WHEN app_user_id IS NULL THEN 'khách lẻ'
            when app_user_id is not null then 'khách online'
        END AS type
    FROM customer
    WHERE name LIKE CONCAT('%', input_name, '%')
        AND code like concat('%', input_code,'%')
        AND address LIKE CONCAT('%', input_address, '%')
        AND app_user_id is null or app_user_id = appUserId or app_user_id 
    ORDER BY input_sort;
    end//
DELIMITER ;
CALL getAll('', '', 'Đà Nẵng', null, 'code');

DROP PROCEDURE IF EXISTS getAll;


SELECT code, name, birthday, address, phone_number, note,
    CASE
        WHEN app_user_id IS NULL THEN 'khách lẻ'
        ELSE 'khách online'
    END AS type
FROM customer
WHERE name LIKE '%tin%' 
    AND code = 1 
    AND address LIKE '%Đà Nẵng%' 
    AND phone_number = '' 
    AND (app_user_id IS NULL OR app_user_id = 1) ;
