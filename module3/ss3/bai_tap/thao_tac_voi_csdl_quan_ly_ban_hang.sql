USE sale_management;
INSERT INTO customer
VALUE (1, "Minh Quan", 10),
	  (2, "Ngoc Oanh", 20),
      (3, "Hong Ha", 50);
 INSERT INTO order_
 VALUE (1, 1, "2006-21-3", null),
       (2, 2, "2006-23-3", null),
       (3, 1, "2006-16-3", null);
INSERT INTO product 
VALUE (1, "May Giat", 3),
	  (2, "Tu Lanh", 5),
      (3, "Dieu Hoa", 7),
      (4, "Quat", 1),
      (5, "Bep Dien", 2);
INSERT INTO order_detail
VALUE (1, 1, 3),
	  (1, 3, 7),
      (1, 4, 2),
      (2, 1, 1),
      (3, 1, 8),
      (2, 5, 4),
      (2, 3, 3);
      -- Hiển thị các thông tin  gồm oID, oDate, oPrice của tất cả các hóa đơn trong bảng Order
SELECT 
    oID, oDate, oPrice
FROM
    order_;
-- Danh sách các khách hàng đã mua hàng, và danh sách sản phẩm được mua bởi các khách
SELECT 	cName
FROM customer C
right join oder_ O
on C.cID = O.cID
group by C.cID;
SELECT pName
FROM product P
join order_ O
on P.pID = O.pID
group by P.pID;
-- Hiển thị tên những khách hàng không mua bất kỳ một sản phẩm nào
SELECT cName
FROM customer C
left join order_ O 
on C.cID = O.cID
WHERE c.cID is null;
-- Hiển thị mã hóa đơn, ngày bán và giá tiền của từng hóa đơn (giá một hóa đơn được tính bằng tổng giá bán của từng loại mặt hàng xuất hiện trong hóa đơn. Giá bán của từng loại được tính = odQTY*pPrice)
SELECT oID, oDate, odQTY*pPrice AS 'Total Price' 
FROM order_ O
join 
order_detail od ON o.oID = od.oID
join
product P ON P.pID = O.oID;
 

