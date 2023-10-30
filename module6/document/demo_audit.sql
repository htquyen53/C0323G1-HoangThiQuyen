create database lung_tung;
use lung_tung;
 create table diem
 (id int auto_increment primary key,
 ten varchar(100),
 diem double
 );
 select * from diem;
 insert into diem 
 values (1, 'Quyen', 10),
		(2, 'Quỳnh', 9),
		(4, 'Trang', 9),
		(5, 'Ánh', 5),
		(6, 'Quý', 6),
		(7, 'Quân', 4),
		(8, 'Huy', 8.6),
		(9, 'Nhật', 9),
		(10, 'Anh', 2);
        
select d.* from diem d inner join (select diem from diem group by diem order by diem desc limit 1 offset 4) demo on demo.diem = d.diem;
select count(*) as so_luong from diem group by  having avg(diem)>=8;
create table san_pham
 (id int auto_increment primary key,
 ten varchar(100),
 gia double
 );
 select * from san_pham;
 insert into san_pham 
 values (1, 'sp1', 10000),
		(2, 'sp2', 9000),
		(3, 'sp3', 9000),
		(4, 'sp4', 5000),
		(5, 'sp5', 6000),
		(6, 'sp6', 4000),
		(7, 'sp7', 8600),
		(8, 'sp8', 4000),
		(9, 'sp9', 4000);
select min(gia) from san_pham;
select sp.* from san_pham sp where sp.gia in (select min(gia) from san_pham) group by id;

select sp.gia, count(*) as so_luong from san_pham sp group by sp.gia;

create table class (
`id` int auto_increment primary key,
`name` varchar(50)
);
select * from class;
insert into class 
values (1,'C1'),
(2,'C2'),
(3,'C3'),
(4,'C4');
select * from student;
create table student (
`id` int auto_increment primary key,
`name` varchar(255),
`class_id` int,
foreign key (`class_id`) references class(`id`)
); 
select * from student;
insert into student 
values (1,"A", 1),(2,"B",3),(3,"C",1),(4,"D",2),(5,"E",1);

SELECT class_id, COUNT(*) AS total_students
FROM student
GROUP BY class_id
ORDER BY total_students DESC
LIMIT 1;