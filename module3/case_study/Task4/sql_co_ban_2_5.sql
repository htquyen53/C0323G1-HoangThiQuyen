USE furama_management_system;
-- 2. Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 kí tự.
SELECT 
    e.employer_code, e.full_name
FROM
    employer e
WHERE
    (e.full_name LIKE 'H%'
        OR e.full_name LIKE 'T%'
        OR e.full_name LIKE 'K%')
        AND CHAR_LENGTH(e.full_name) <= 15độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”;
SELECT *
FROM customer c
WHERE ((datediff(NOW(),c.birthday)/365) >=18 AND (datediff(NOW(),c.birthday)/365) <=50) AND (c.address like "%Đà Nẵng" OR c.address like "%Quảng Trị");
-- 4.	Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần. Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng.
-- Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.
SELECT c.customer_code, c.full_name, count(c.customer_code) as number_of_bookings
FROM customer c
JOIN contract co ON c.customer_code = co.customer_code
JOIN customer_type type ON c.customer_type_code = type.customer_type_code
WHERE type_of_customer like "Diamond"
GROUP BY c.customer_code
ORDER BY number_of_bookings;
-- 5. 5.	Hiển thị ma_khach_hang, ho_ten, ten_loai_khach, ma_hop_dong, ten_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc,
-- tong_tien (Với tổng tiền được tính theo công thức như sau: Chi Phí Thuê + Số Lượng * Giá, với Số Lượng và Giá là từ bảng dich_vu_di_kem, hop_dong_chi_tiet)
--  cho tất cả các khách hàng đã từng đặt phòng. 
-- (những khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra).
SELECT 
    c.customer_code,
    c.full_name,
    ctp.type_of_customer,
    co.contract_code,
    s.name_service,
    co.contract_date,
    co.contract_end_date,
    s.rental_code + sum(acs.accompanied_service_price*ifnull(cdt.quantity,0)) as Total
FROM
    customer c
        LEFT JOIN
    customer_type ctp ON c.customer_type_code = ctp.customer_type_code
        LEFT JOIN
    contract co ON c.customer_code = co.customer_code
        LEFT JOIN
    services s ON s.service_code = co.code_service
        LEFT JOIN
    contract_detail cdt ON co.contract_code = cdt.contract_code
        LEFT JOIN
    accompanied_service acs ON acs.accompanied_service_code = cdt.accompanied_service_code
    group by co.contract_code;
    set global sql_mode='only_full_group_by'
