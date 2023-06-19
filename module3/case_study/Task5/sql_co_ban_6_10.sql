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
JOIN contract c ON s.code_service = c.code_service
WHERE (c.code_service IN (
SELECT c.code_service
FROM contract c
WHERE c.contract_date BETWEEN "2020-01-01" AND "2020-12-31")
) AND c.code_service NOT IN (SELECT c.code_service
FROM contract c
WHERE c.contract_date BETWEEN "2021-01-01" AND "2021-12-31")
GROUP BY s.code_service;	
					