-- 21.	Tạo khung nhìn có tên là v_nhan_vien để lấy được thông tin của tất cả các nhân viên có địa chỉ là “Hải Châu” 
-- và đã từng lập hợp đồng cho một hoặc nhiều khách hàng bất kì với ngày lập hợp đồng là “12/12/2019”.

USE furama_management_system;

CREATE VIEW v_nhan_vien AS
SELECT  e.employer_code as 'code', co.employer_code as'contract', e.full_name, e.birthday, e.citizen_id, e.salary, e.numberphone, e.email, e.address
FROM employer e
JOIN contract co ON co.employer_code = e.employer_code
WHERE e.address like "%Đà Nẵng" AND co.contract_date = "2021-04-25";

DROP VIEW v_nhan_vien;

-- 22.	Thông qua khung nhìn v_nhan_vien thực hiện cập nhật địa chỉ thành “Liên Chiểu” đối với tất cả các nhân viên được nhìn thấy bởi khung nhìn này.
SET sql_safe_updates = 0;
UPDATE v_nhan_vien v
SET v.address = "Liên Chiểu, Đà Nẵng" 
WHERE v.address like "%Đà Nẵng";
SET sql_safe_updates = 1;

-- 23.	Tạo Stored Procedure sp_xoa_khach_hang dùng để xóa thông tin của một khách hàng nào đó với ma_khach_hang được truyền vào như là 1 tham số của sp_xoa_khach_hang.
delimiter //
CREATE PROCEDURE sp_xoa_khach_hang (IN ma_khach_hang INT)
BEGIN 
DELETE e 
FROM employer e
WHERE e.employer_code = ma_khach_hang;
END //
delimiter ;

CALL sp_xoa_khach_hang (3);

-- 24.	Tạo Stored Procedure sp_them_moi_hop_dong dùng để thêm mới vào bảng hop_dong với yêu cầu sp_them_moi_hop_dong
--  phải thực hiện kiểm tra tính hợp lệ của dữ liệu bổ sung, với nguyên tắc không được trùng khóa chính và
-- đảm bảo toàn vẹn tham chiếu đến các bảng liên quan.

delimiter //
CREATE PROCEDURE sp_them_moi_hop_dong (in ma_hop_dong INT, ngay_ky_hop_dong DATETIME, ngay_ket_thuc DATETIME, dat_coc DOUBLE, ma_nhan_vien INT, ma_khach_hang INT, ma_dich_vu INT)
BEGIN 
IF ma_hop_dong NOT IN (SELECT co.contract_code FROM contract co) 
		AND ma_nhan_vien IN (SELECT e.employer_code FROM employer e)
		AND ma_dich_vu IN (SELECT s.code_service FROM services s) THEN
INSERT INTO contract 
VALUES (ma_hop_dong, ngay_ky_hop_dong,ngay_ket_thuc, dat_coc, ma_nhan_vien, ma_khach_hang, ma_dich_vu);
ELSE SELECT 'Not vallidate!' AS error;
END IF;
END //
delimiter ;
CALL sp_them_moi_hop_dong (13, "2020-07-14 00:00:00",	"2020-07-21 00:00:00",	210000,	7,	3,	1);

-- 25.	Tạo Trigger có tên tr_xoa_hop_dong khi xóa bản ghi trong bảng hop_dong thì hiển thị tổng số lượng
-- bản ghi còn lại có trong bảng hop_dong ra giao diện console của database.
-- Lưu ý: Đối với MySQL thì sử dụng SIGNAL hoặc ghi log thay cho việc ghi ở console.
   
SELECT count(*) FROM contract;

DELIMITER //
CREATE TRIGGER tr_xoa_hop_dong 
AFTER DELETE ON contract
FOR EACH ROW
BEGIN
SELECT count(*) INTO @msg FROM contract;
-- SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = @message; 
END //
DELIMITER ;

DROP TRIGGER tr_xoa_hop_dong ;
set @msg=0;
DELETE FROM contract co
WHERE co.contract_code = 2;
select @msg as'hợp đồng còn lại'

