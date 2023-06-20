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
 
 -- 17.	Cập nhật thông tin những khách hàng có ten_loai_khach từ Platinum lên Diamond,
 -- chỉ cập nhật những khách hàng đã từng đặt phòng với 
 -- Tổng Tiền thanh toán trong năm 2021 là lớn hơn 10.000.000 VNĐ.
 
 UPDATE customer_type ct 
	SET ct.type_of_customer = "Diamond"
	WHERE ct.type_of_customer = "Platinum" AND ( SELECT total_per_customer.total AS 'vip'
    FROM
		(SELECT 
			c.customer_code,
			sum(total_per_contract_table.total_per_contract) AS 'total'
			FROM 
            customer c
            JOIN (SELECT 	c.customer_code AS 'code', 
							co.contract_code,
							(s.rental_cost + (ifnull(cod.quantity,0)*(ifnull(acs.accompanied_service_price,0))))as 'Total_per_contract'
				FROM customer c
				JOIN contract co ON co.customer_code = c.customer_code
				LEFT JOIN contract_detail cod ON cod.contract_code = co.contract_code
				JOIN services s ON s.code_service = co.code_service
				LEFT JOIN accompanied_service acs ON acs.accompanied_service_code = cod.accompanied_service_code
				WHERE co.contract_date BETWEEN "2021-01-01" AND "2021-12-31"
				GROUP BY co.contract_code) total_per_contract_table ON c.customer_code = total_per_contract_table.code
			GROUP BY c.customer_code) total_per_customer
            HAVING total_per_customer.total>10000000);
    
    -- 18.	Xóa những khách hàng có hợp đồng trước năm 2021 (chú ý ràng buộc giữa các bảng).
    DELETE c FROM (SELECT c.customer_code as 'code'
    FROM customer c
    WHERE c.customer_code NOT IN (
			SELECT c.customer_code
			FROM customer c
			JOIN contract co ON c.customer_code = co.customer_code
			WHERE co.contract_date >= "2021-01-01"
			GROUP BY c.customer_code)
			GROUP BY code) non_table 
    JOIN customer c ON c.customer_code=non_table.code;
     -- 19.	Cập nhật giá cho các dịch vụ đi kèm được sử dụng trên 10 lần trong năm 2020 lên gấp đôi.
     UPDATE accompanied_service accs
     SET accs.accompanied_service_price = accompanied_service_price*2
     WHERE (;