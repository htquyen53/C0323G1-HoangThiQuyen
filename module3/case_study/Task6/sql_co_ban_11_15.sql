USE furama_management_system;
-- 11.	Hiển thị thông tin các dịch vụ đi kèm đã được 
-- sử dụng bởi những khách hàng có ten_loai_khach là “Diamond” và 
-- có dia_chi ở “Vinh” hoặc “Quảng Ngãi”.

SELECT *
FROM accompanied_service accs 
JOIN contract_detail cod ON accs.accompanied_service_code = cod.accompanied_service_code
JOIN contract co ON co.contract_code = cod.contract_code
JOIN customer c ON c.customer_code = co.customer_code
JOIN customer_type ctp ON ctp.customer_type_code = c.customer_type_code
WHERE ctp.type_of_customer = "Diamond" AND (c.address LIKE "%Vinh" OR  c.address LIKE "%%Quảng Ngãi")
GROUP BY accs.accompanied_service_code;

-- 12.	Hiển thị thông tin ma_hop_dong, ho_ten (nhân viên), ho_ten (khách hàng), so_dien_thoai (khách hàng),
-- ten_dich_vu, so_luong_dich_vu_di_kem (được tính dựa trên việc sum so_luong ở dich_vu_di_kem),
--  tien_dat_coc của tất cả các dịch vụ đã từng được khách hàng đặt vào 3 tháng cuối năm 2020 
-- nhưng chưa từng được khách hàng đặt vào 6 tháng đầu năm 2021.

SELECT co.contract_code, e.full_name, c.full_name, c.numberphone, s.name_service, sum(cdt.quantity), co.deposits
FROM contract co
JOIN employer e ON e.employer_code = co.employer_code
JOIN customer c ON c.customer_code = co.customer_code
JOIN services s ON s.code_service = co.code_service
JOIN contract_detail cdt ON cdt.contract_code = co.contract_code
WHERE 
co.contract_code IN (
SELECT co.contract_code 
FROM contract co
WHERE co.contract_date BETWEEN "2020-10-01" AND "2020-12-31") 
AND
co.contract_code NOT IN (
SELECT co.contract_code 
FROM contract co
WHERE co.contract_date BETWEEN "2021-01-01" AND "2021-06-31")
GROUP BY co.contract_code;

-- 13. 	Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các Khách hàng đã đặt phòng.
-- (Lưu ý là có thể có nhiều dịch vụ có số lần sử dụng nhiều như nhau).
SELECT *
FROM accompanied_service accs
JOIN contract_detail cod ON accs.accompanied_service_code = cod.accompanied_service_code
WHERE cod.quantity = (SELECT max(cod.quantity)
FROM contract_detail cod) 
GROUP BY accs.accompanied_service_code;

SELECT	quantity_table.code, 
		accs.accompanied_service_name,
        quantity_table.sum AS 'max'
FROM
(SELECT accompanied_service_code AS 'code', sum(quantity) AS 'sum'
FROM contract_detail
GROUP BY accompanied_service_code) quantity_table
JOIN accompanied_service accs ON accs.accompanied_service_code = quantity_table.code
HAVING max = (SELECT max(quantity_table.sum)
			FROM (SELECT accompanied_service_code AS 'code', sum(quantity) AS 'sum'
			FROM contract_detail
			GROUP BY accompanied_service_code) quantity_table);


-- 14. Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một lần duy nhất. 
-- Thông tin hiển thị bao gồm ma_hop_dong, ten_loai_dich_vu, ten_dich_vu_di_kem, so_lan_su_dung
--  (được tính dựa trên việc count các ma_dich_vu_di_kem).

SELECT  co.contract_code, 
		stp.name_service_type, 
        accs.accompanied_service_name, 
        count(accs.accompanied_service_code) AS "Used"
FROM accompanied_service accs
JOIN contract_detail cod ON cod.accompanied_service_code = accs.accompanied_service_code
JOIN contract co ON co.contract_code = cod.contract_code
JOIN services s ON s.code_service = co.code_service
JOIN service_type stp ON stp.service_type_code = s.service_type_code
GROUP BY accs.accompanied_service_code
HAVING Used = 1;


SELECT	co.contract_code,
		stp.name_service_type,
        accs.accompanied_service_name,
        table_count.count
FROM 	(SELECT cod.accompanied_service_code AS 'code', count(cod.accompanied_service_code) as 'count'
		FROM contract_detail cod
		GROUP BY cod.accompanied_service_code
		HAVING count =1 
		) table_count
JOIN 	contract_detail cod ON cod.accompanied_service_code = table_count.code
JOIN 	contract co ON co.contract_code = cod.contract_code
JOIN 	services s ON s.code_service = co.code_service
JOIN	service_type stp ON stp.service_type_code = s.service_type_code
JOIN 	accompanied_service accs ON accs.accompanied_service_code = table_count.code;

SELECT cod.accompanied_service_code AS 'code', count(cod.accompanied_service_code) as 'count'
		FROM contract_detail cod
		GROUP BY cod.accompanied_service_code
		HAVING count =1;

-- 15.	Hiển thi thông tin của tất cả nhân viên bao gồm ma_nhan_vien, ho_ten, ten_trinh_do, ten_bo_phan, 
-- so_dien_thoai, dia_chi mới chỉ lập được tối đa 3 hợp đồng từ năm 2020 đến 2021.

SELECT e.employer_code, e.full_name, a.academic_level_name, d.department_name, e.numberphone, e.address
FROM (SELECT co.employer_code AS 'code', count(co.employer_code) AS "count_contract"
 FROM contract co
 WHERE co.contract_date BETWEEN "2020-01-01" AND "2021-12-31"
 GROUP BY co.employer_code) count_table
 JOIN employer e ON e.employer_code = count_table.code
 JOIN academic_level a ON a.academic_level_code = e.academic_level_code
 JOIN department d ON d.department_code = e.department_code
 WHERE count_table.count_contract <=3
 GROUP BY e.employer_code;
 
 