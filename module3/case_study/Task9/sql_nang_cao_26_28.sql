USE furama_management_system;
-- 26.	Tạo Trigger có tên tr_cap_nhat_hop_dong khi cập nhật ngày kết thúc hợp đồng, 
-- cần kiểm tra xem thời gian cập nhật có phù hợp hay không, với quy tắc sau:
-- Ngày kết thúc hợp đồng phải lớn hơn ngày làm hợp đồng ít nhất là 2 ngày. 
-- Nếu dữ liệu hợp lệ thì cho phép cập nhật, nếu dữ liệu không hợp lệ thì in ra thông báo 
-- “Ngày kết thúc hợp đồng phải lớn hơn ngày làm hợp đồng ít nhất là 2 ngày” trên console của database.
-- Lưu ý: Đối với MySQL thì sử dụng SIGNAL hoặc ghi log thay cho việc ghi ở console.


DELIMITER //
CREATE TRIGGER tr_updates_contract
BEFORE UPDATE ON contract 
FOR EACH ROW
BEGIN
IF (NEW.contract_end_date <= DATE_ADD(NEW.contract_date, INTERVAL 2 DAY)) THEN
			SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'Ngày kết thúc hợp đồng phải lớn hơn ngày làm hợp đồng ít nhất là 2 ngày';
            END IF;
END //
DELIMITER ;

UPDATE contract
SET contract_end_date = "2020-12-15 00:00:00"
WHERE contract_code = 1;

-- 27.	Tạo Function thực hiện yêu cầu sau:
-- a.	Tạo Function func_dem_dich_vu: Đếm các dịch vụ đã được sử dụng với tổng tiền là > 2.000.000 VNĐ.
DELIMITER //
CREATE FUNCTION count_service (total DOUBLE)
RETURNS INT
DETERMINISTIC
BEGIN
	DECLARE c INT;
	SELECT count(*) INTO c
	FROM 
	(SELECT code FROM
			(SELECT s.code_service as 'code',
					sum(s.rental_cost) as 'total_s'
			FROM services s
			JOIN contract co ON co.code_service = s.code_service 
			GROUP BY co.code_service
			HAVING s.code_service = co.code_service) total_table
			WHERE total_table.total_s > total) as result_table;
	RETURN c;
END //
DELIMITER ;
DROP FUNCTION count_service;
SELECT code FROM
			(SELECT s.code_service as 'code',
					sum(s.rental_cost) as 'total_s'
			FROM services s
			JOIN contract co ON co.code_service = s.code_service 
			GROUP BY co.code_service
			HAVING s.code_service = co.code_service) total_table
			WHERE total_table.total_s > 2000000 ;
select count_service(2000000) as "total"
from services s
group by total;

SELECT code FROM
(SELECT s.code_service as 'code',
		sum(s.rental_cost) as 'total_s'
FROM services s
JOIN contract co ON co.code_service = s.code_service 
GROUP BY co.code_service
HAVING s.code_service = co.code_service) total_table
WHERE total_table.total_s > 2000000;

SELECT s.code_service,
		sum(s.rental_cost) as 'total'
FROM services s
JOIN contract co ON co.code_service = s.code_service
GROUP BY co.code_service
HAVING s.code_service = co.code_service;

-- b.	Tạo Function func_tinh_thoi_gian_hop_dong: Tính khoảng thời gian dài nhất tính từ lúc bắt đầu làm hợp đồng đến 
-- lúc kết thúc hợp đồng mà khách hàng đã thực hiện thuê dịch vụ (lưu ý chỉ xét các khoảng thời gian dựa vào từng lần làm
-- hợp đồng thuê dịch vụ, không xét trên toàn bộ các lần làm hợp đồng). Mã của khách hàng được truyền vào như là 1 tham số 
-- của function này.
DELIMITER //
CREATE FUNCTION func_tinh_thoi_gian_hop_dong (e_code int)
RETURNS INT
DETERMINISTIC
BEGIN
DECLARE max int;
SELECT
	max_table.time_max INTO max
FROM (
SELECT  time_table.code as code,
		max(time_table.time) as 'time_max'
FROM (SELECT 	co.contract_code, 
				c.customer_code as 'code',
				DATEDIFF(co.contract_end_date, co.contract_date) as 'time'
		FROM contract co
		JOIN customer c ON c.customer_code = co.customer_code 
		GROUP BY c.customer_code ) time_table
GROUP BY time_table.code
ORDER BY time_table.code
) max_table
WHERE max_table.code = e_code;
RETURN max;
END //
DELIMITER ;

DROP FUNCTION func_tinh_thoi_gian_hop_dong;

SELECT  time_table.code,
		max(time_table.time) as 'time_max'
FROM (SELECT 	co.contract_code, 
				c.customer_code as 'code',
				DATEDIFF(co.contract_end_date, co.contract_date) as 'time'
		FROM contract co
		JOIN customer c ON c.customer_code = co.customer_code 
		GROUP BY c.customer_code ) time_table
GROUP BY time_table.code
ORDER BY time_table.code;

SELECT c.full_name, func_tinh_thoi_gian_hop_dong (1) as 'max'
FROM  customer c;
        
--  28.	Tạo Stored Procedure sp_xoa_dich_vu_va_hd_room để tìm các dịch vụ được thuê bởi khách hàng với loại dịch vụ là “Room” từ
--  đầu năm 2015 đến hết năm 2019 để xóa thông tin của các dịch vụ đó (tức là xóa các bảng ghi trong bảng dich_vu)
--  và xóa những hop_dong sử dụng dịch vụ liên quan (tức là phải xóa những bản gi trong bảng hop_dong) và những bản liên quan khác.

DELIMITER //
-- CREATE FUNCTION sp_xoa_dich_vu_va_hd_room

