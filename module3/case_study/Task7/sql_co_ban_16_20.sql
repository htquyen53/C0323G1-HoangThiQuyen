USE furama_management_system;
-- 16.	Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2019 đến năm 2021.

DELETE e FROM (SELECT e.employer_code as 'code'
	FROM employer e
	WHERE e.employer_code NOT IN (SELECT e.employer_code
		FROM employer e
		JOIN contract co ON co.employer_code = e.employer_code
		WHERE co.contract_date BETWEEN "2019-01-01" AND "2021-12-31"
		GROUP BY e.employer_code)
 GROUP BY code) non_contract 
 JOIN employer e ON e.employer_code = non_contract.code ;
     SELECT * FROM employer;
     
 -- 17.	Cập nhật thông tin những khách hàng có ten_loai_khach từ Platinum lên Diamond,
 -- chỉ cập nhật những khách hàng đã từng đặt phòng với 
 -- Tổng Tiền thanh toán trong năm 2021 là lớn hơn 10.000.000 VNĐ.
 	SET SQL_SAFE_UPDATES = 0;
 UPDATE customer c
	SET c.customer_type_code = 1
	WHERE c.customer_type_code IN 
				(SELECT c.customer_type_code 
                FROM  (SELECT 	c.customer_code AS 'code', 
						c.full_name AS 'name',
						c.customer_type_code,
						ct.type_of_customer AS 'type',
						sum(s.rental_cost + ifnull(cod.quantity*acs.accompanied_service_price,0)) as 'Total'
					FROM customer c
					JOIN customer_type ct ON c.customer_type_code = ct.customer_type_code 
					JOIN contract co ON co.customer_code = c.customer_code
					LEFT JOIN contract_detail cod ON cod.contract_code = co.contract_code
					JOIN services s ON s.code_service = co.code_service
					LEFT JOIN accompanied_service acs ON acs.accompanied_service_code = cod.accompanied_service_code
					WHERE (co.contract_date BETWEEN "2021-01-01" AND "2021-12-31") AND ct.type_of_customer = "Platinium"
					GROUP BY code
					HAVING Total > 10000 
					ORDER BY code) result);
	SET SQL_SAFE_UPDATES = 1;
            
				SELECT 	c.customer_code AS 'code', 
						c.full_name AS 'name',
                        c.customer_type_code,
						ct.type_of_customer AS 'Type',
						sum(s.rental_cost + ifnull(cod.quantity*acs.accompanied_service_price,0)) as 'Total'
				FROM customer c
                JOIN customer_type ct ON c.customer_type_code = ct.customer_type_code 
				JOIN contract co ON co.customer_code = c.customer_code
				LEFT JOIN contract_detail cod ON cod.contract_code = co.contract_code
				JOIN services s ON s.code_service = co.code_service
				LEFT JOIN accompanied_service acs ON acs.accompanied_service_code = cod.accompanied_service_code
				WHERE (co.contract_date BETWEEN "2021-01-01" AND "2021-12-31") AND ct.type_of_customer = "Platinium"
				GROUP BY code
                HAVING Total > 10000 
                ORDER BY code;
    
    -- 18.	Xóa những khách hàng có hợp đồng trước năm 2021 (chú ý ràng buộc giữa các bảng).
    SET FOREIGN_KEY_CHECKS = 0;
    DELETE c FROM (SELECT c.customer_code as 'code'
    FROM customer c
    WHERE c.customer_code IN (
			SELECT c.customer_code
			FROM customer c
			JOIN contract co ON c.customer_code = co.customer_code
			WHERE co.contract_date < "2021-01-01"
			GROUP BY c.customer_code)
			GROUP BY code) non_table 
    JOIN customer c ON c.customer_code=non_table.code;
    SET FOREIGN_KEY_CHECKS = 1;
    SELECT * FROM customer;
     -- 19.	Cập nhật giá cho các dịch vụ đi kèm được sử dụng trên 10 lần trong năm 2020 lên gấp đôi.
	SET SQL_SAFE_UPDATES = 0;
    UPDATE accompanied_service accs
    SET accs.accompanied_service_price = accs.accompanied_service_price*2
	WHERE accs.accompanied_service_code IN (SELECT *
											FROM (SELECT accs.accompanied_service_code AS 'code'
											FROM contract_detail cod
											JOIN accompanied_service accs ON cod.accompanied_service_code = accs.accompanied_service_code
											WHERE cod.quantity > 10
											GROUP BY accs.accompanied_service_code) AS acc_table);
	SET SQL_SAFE_UPDATES = 1;
    
    SELECT accs.accompanied_service_code AS 'code'
											FROM contract_detail cod
											JOIN accompanied_service accs ON cod.accompanied_service_code = accs.accompanied_service_code
											WHERE cod.quantity > 10
											GROUP BY accs.accompanied_service_code;    
-- 20.	Hiển thị thông tin của tất cả các nhân viên và khách hàng có trong hệ thống, 
-- thông tin hiển thị bao gồm id (ma_nhan_vien, ma_khach_hang), ho_ten, email, so_dien_thoai, ngay_sinh, dia_chi.
SELECT c.customer_code,c.full_name, c.email, c.numberphone, c.birthday, c.address
FROM customer c
UNION
SELECT e.employer_code, e.full_name, e.email, e.numberphone, e.birthday, e.address
FROM employer e;
