USE furama_management_system;
-- 6.	Hiển thị ma_dich_vu, ten_dich_vu, dien_tich, chi_phi_thue, ten_loai_dich_vu của tất cả các loại dịch vụ 
-- chưa từng được khách hàng thực hiện đặt từ quý 1 của năm 2021 (Quý 1 là tháng 1, 2, 3).

select s.code_service, s.name_service, s.area, s.rental_cost, st.name_service_type
from services s 
left join contract c ON c.code_service = s.code_service
join service_type st on s.service_type_code = st.service_type_code
where c.code_service not in (
		select c.code_service
        from contract c
        where c.contract_date > "2021-01-01" and c.contract_date < "2021-03-31")
group by s.code_service; 

-- 7.	Hiển thị thông tin ma_dich_vu, ten_dich_vu, dien_tich, so_nguoi_toi_da, chi_phi_thue, 
-- ten_loai_dich_vu của tất cả các loại dịch vụ đã từng được khách hàng đặt phòng trong năm 2020 
-- nhưng chưa từng được khách hàng đặt phòng trong năm 2021.
SELECT s.code_service, s.name_service, s.area, s.maximum_occupancy, s.rental_cost, st.name_service_type
FROM services s
JOIN service_type st ON s.service_type_code = st.service_type_code
JOIN contract co ON s.code_service = co.code_service
WHERE (co.code_service IN (
SELECT co.code_service
FROM contract co
WHERE co.contract_date BETWEEN "2020-01-01" AND "2020-12-31")
) AND co.code_service NOT IN (SELECT co.code_service
FROM contract co
WHERE co.contract_date BETWEEN "2021-01-01" AND "2021-12-31")
GROUP BY s.code_service;
-- 8. Hiển thị thông tin ho_ten khách hàng có trong hệ thống, với yêu cầu ho_ten không trùng nhau.
-- Học viên sử dụng theo 3 cách khác nhau để thực hiện yêu cầu trên.
SELECT c.full_name
FROM customer c
group by c.full_name;

-- 9.	Thực hiện thống kê doanh thu theo tháng,
--  nghĩa là tương ứng với mỗi tháng trong năm 2021 thì sẽ có bao nhiêu khách hàng thực hiện đặt phòng.
SELECT MONTH(co.contract_date) AS "Month", count(co.customer_code)
FROM contract co
WHERE co.contract_date BETWEEN "2021-01-01" AND "2021-12-31"
GROUP BY Month 
ORDER BY Month;
 -- 10.	Hiển thị thông tin tương ứng với từng hợp đồng thì đã sử dụng bao nhiêu dịch vụ đi kèm. 
 -- Kết quả hiển thị bao gồm ma_hop_dong, ngay_lam_hop_dong, ngay_ket_thuc,
 -- tien_dat_coc, so_luong_dich_vu_di_kem (được tính dựa trên việc sum so_luong ở dich_vu_di_kem).
 SELECT co.contract_code, co.contract_date, co.contract_end_date, co.deposits, ifnull(sum(cot.quantity),0) AS "Quantity of accompanied service"
 FROM contract co
 LEFT JOIN contract_detail cot ON co.contract_code = cot.contract_code
 LEFT JOIN accompanied_service accs ON cot.accompanied_service_code = accs.accompanied_service_code
 GROUP BY co.contract_code;