-- Create Databate
drop database if exists retro_care;
create database retro_care;
use retro_care;

create table app_role
(
    id           bigint auto_increment
        primary key,
    flag_deleted bit          null,
    name         varchar(255) null
);

create table app_user
(
    id           bigint auto_increment
        primary key,
    flag_deleted bit          null,
    flag_online  bit          null,
    password     varchar(255) null,
    user_name    varchar(255) null
);

create table customer
(
    id           bigint auto_increment
        primary key,
    address      varchar(255) null,
    birth_day    date         null,
    code         varchar(20)  null,
    email        varchar(100) null,
    flag_deleted bit          null,
    name         varchar(100) null,
    note         text         null,
    phone_number varchar(20)  null,
    point        bigint       null,
    app_user_id  bigint       null,
    constraint FKgn8girv8mn8xxqh5d98lr775w
        foreign key (app_user_id) references app_user (id)
);

create table employee
(
    id            bigint auto_increment
        primary key,
    address       varchar(100) not null,
    birthday      date         not null,
    code_employee varchar(50)  not null,
    flag_delete   bit          null,
    id_card       varchar(20)  not null,
    image         longtext     null,
    name_employee varchar(100) not null,
    note          longtext     null,
    phone_number  varchar(15)  not null,
    start_day     date         not null,
    app_user_id   bigint       not null,
    constraint FKc7ry7r59wb20ay0may25uujw3
        foreign key (app_user_id) references app_user (id)
);

create table kind_of_medicine
(
    id           bigint auto_increment
        primary key,
    code         varchar(255) null,
    flag_deleted bit          null,
    name         varchar(255) null
);

create table medicine
(
    id                  bigint       not null
        primary key,
    active_element      text         null,
    code                varchar(255) null,
    flag_deleted        bit          null,
    maker               varchar(255) null,
    name                varchar(255) null,
    note                longtext     null,
    origin              varchar(255) null,
    price               double       null,
    quantity            bigint       null,
    retail_profits      float        null,
    vat                 float        null,
    kind_of_medicine_id bigint       null,
    constraint FK6f3slsta9vikh2mwwnhvosme0
        foreign key (kind_of_medicine_id) references kind_of_medicine (id)
);

create table cart_details
(
    id          bigint auto_increment
        primary key,
    quantity    int    null,
    app_user_id bigint null,
    medicine_id bigint null,
    constraint uniqueMultiIndex
        unique (app_user_id, medicine_id),
    constraint FK1r8bx2lkydpfk6l927mhbayvf
        foreign key (medicine_id) references medicine (id),
    constraint FKiu9o9jbo11l79iys6433y8g1l
        foreign key (app_user_id) references app_user (id)
);

create table image_medicine
(
    id           bigint   not null
        primary key,
    flag_deleted bit      null,
    image_path   longtext null,
    medicine_id  bigint   null,
    constraint FKeh3ehee6agdg91n7c66q2sxm7
        foreign key (medicine_id) references medicine (id)
);

create table order_app_user
(
    id          bigint auto_increment
        primary key,
    flag_delete bit          not null,
    flag_online bit          not null,
    password    varchar(255) null,
    user_name   varchar(255) null
);

create table orders
(
    id           bigint auto_increment
        primary key,
    code         varchar(255) null,
    date_time    date         null,
    flag_deleted bit          null,
    note         varchar(255) null
);

create table order_details
(
    id            bigint auto_increment
        primary key,
    current_price double null,
    quantity      int    null,
    medicine_id   bigint null,
    order_id      bigint null,
    constraint FKjyu2qbqt8gnvno9oe9j2s2ldk
        foreign key (order_id) references orders (id),
    constraint FKpi0ffs9t416ejipygy2v6ff9t
        foreign key (medicine_id) references medicine (id)
);

create table patient
(
    id           bigint auto_increment
        primary key,
    flag_deleted bit          null,
    name         varchar(255) null
);

create table prescription
(
    id           bigint auto_increment
        primary key,
    code         varchar(50)  null,
    duration     int          null,
    flag_deleted bit          null,
    name         varchar(255) null,
    note         varchar(255) null,
    symptoms     varchar(255) null,
    patient_id   bigint       null,
    constraint FKqrlh184tfvdi95erwl65p4xj3
        foreign key (patient_id) references patient (id)
);

create table indication
(
    id              bigint auto_increment
        primary key,
    dosage          int    null,
    flag_deleted    bit    null,
    frequency       int    null,
    medicine_id     bigint null,
    prescription_id bigint null,
    constraint FKm9tkw2hfn68jxvrljwoxcopat
        foreign key (prescription_id) references prescription (id),
    constraint FKmhcc77fjffgoqdvg2jqq8f749
        foreign key (medicine_id) references medicine (id)
);

create table supplier
(
    id           bigint auto_increment
        primary key,
    address      varchar(255) null,
    code         varchar(255) null,
    email        varchar(255) null,
    flag_delete  bit          null,
    name         varchar(255) null,
    note         varchar(255) null,
    phone        varchar(255) null,
    flag_deleted bit          null,
    phone_number varchar(255) null
);

create table invoice
(
    id              bigint auto_increment
        primary key,
    code            varchar(255) null,
    creation_date   datetime  null,
    document_number varchar(255) null,
    flag_deleted    bit          null,
    note            varchar(255) null,
    paid            double       null,
    app_user_id  bigint       null,
    supplier_id  bigint       null,
    constraint FK3o9l0fsi4ki0pwnr7hocqrval
        foreign key (app_user_id) references app_user (id),
    constraint FKl05cc3dyi5klnu8hptshv1j30
        foreign key (supplier_id) references supplier (id)
);

create table invoice_detail
(
    id                bigint auto_increment
        primary key,
    discount          float        null,
    expiry            datetime(6)  null,
    flag_deleted      bit          null,
    lot               varchar(255) null,
    medicine_quantity int          null,
    invoice_id     bigint       null,
    medicine_id    bigint       null,
    constraint FK2nnuu0qqu9mhgt5bd1ewqg8q3
        foreign key (invoice_id) references invoice (id),
    constraint FK30i8t8tybnkdc43ukadn1x3an
        foreign key (medicine_id) references medicine (id)
);

create table unit
(
    id           bigint       not null
        primary key,
    flag_deleted bit          null,
    name         varchar(255) null
);

create table unit_detail
(
    id              bigint       not null
        primary key,
    conversion_rate bigint       null,
    conversion_unit varchar(255) null,
    flag_deleted    bit          null,
    medicine_id     bigint       null,
    unit_id         bigint       null,
    constraint FK7asv4rei4mgijhe62r096hyhy
        foreign key (medicine_id) references medicine (id),
    constraint FKpvafnfahgvq55bf6eg0k7sqsr
        foreign key (unit_id) references unit (id)
);

create table user_order
(
    id          bigint auto_increment
        primary key,
    app_user_id bigint null,
    order_id    bigint null,
    constraint FKmxw9875tcodjrhao78rr2keyh
        foreign key (app_user_id) references app_user (id),
    constraint FKrlglekn12wx5o456laekbv32u
        foreign key (order_id) references orders (id)
);

create table user_role
(
    id          bigint auto_increment
        primary key,
    app_role_id bigint null,
    app_user_id bigint null,
    constraint FKbcrg4je9i9jbl5sk02ydxme1b
        foreign key (app_role_id) references app_role (id),
    constraint FKj16wg2x08hwytvgys4y9idf4b
        foreign key (app_user_id) references app_user (id)
);


-- Insert into 

-- app_user , app_role , user_role

insert into `app_user` (`user_name`, `password`,`flag_online`, `flag_deleted` )
values 	("nhatngo","$10$JoTn4m9b.8cYvIfo269L3u.4XJjo/RtjI0VAa51CxwsNa1wHdLESu",0,0),
		("minhhanh","$10$JoTn4m9b.8cYvIfo269L3u.4XJjo/RtjI0VAa51CxwsNa1wHdLESu",0,0),
		("anhdao","$10$JoTn4m9b.8cYvIfo269L3u.4XJjo/RtjI0VAa51CxwsNa1wHdLESu",0,0),
		("lehuy","$10$JoTn4m9b.8cYvIfo269L3u.4XJjo/RtjI0VAa51CxwsNa1wHdLESu",0,0),
		("tancuong","$10$JoTn4m9b.8cYvIfo269L3u.4XJjo/RtjI0VAa51CxwsNa1wHdLESu",0,0),
		("ngocthanh","$10$JoTn4m9b.8cYvIfo269L3u.4XJjo/RtjI0VAa51CxwsNa1wHdLESu",0,0),
		("thiquyen","$10$JoTn4m9b.8cYvIfo269L3u.4XJjo/RtjI0VAa51CxwsNa1wHdLESu",0,0),
		("thoantin","$10$JoTn4m9b.8cYvIfo269L3u.4XJjo/RtjI0VAa51CxwsNa1wHdLESu",0,0),
		("vantan","$10$JoTn4m9b.8cYvIfo269L3u.4XJjo/RtjI0VAa51CxwsNa1wHdLESu",0,0),
        ("vietcao","$10$JoTn4m9b.8cYvIfo269L3u.4XJjo/RtjI0VAa51CxwsNa1wHdLESu",0,0),
        ("tinvv","$10$JoTn4m9b.8cYvIfo269L3u.4XJjo/RtjI0VAa51CxwsNa1wHdLESu",0,0),
        ("vietduy","$10$JoTn4m9b.8cYvIfo269L3u.4XJjo/RtjI0VAa51CxwsNa1wHdLESu",0,0),
		("thanhson","$10$JoTn4m9b.8cYvIfo269L3u.4XJjo/RtjI0VAa51CxwsNa1wHdLESu",0,0),
		("ngonhat","$10$JoTn4m9b.8cYvIfo269L3u.4XJjo/RtjI0VAa51CxwsNa1wHdLESu",0,0),
        ("thanhkim","$10$JoTn4m9b.8cYvIfo269L3u.4XJjo/RtjI0VAa51CxwsNa1wHdLESu",0,0),
		("nhatngohuu","$10$JoTn4m9b.8cYvIfo269L3u.4XJjo/RtjI0VAa51CxwsNa1wHdLESu",0,0),
		("minhhanhnguyen","$10$JoTn4m9b.8cYvIfo269L3u.4XJjo/RtjI0VAa51CxwsNa1wHdLESu",0,0),
		("anhdaophan","$10$JoTn4m9b.8cYvIfo269L3u.4XJjo/RtjI0VAa51CxwsNa1wHdLESu",0,0),
		("lehuyle","$10$JoTn4m9b.8cYvIfo269L3u.4XJjo/RtjI0VAa51CxwsNa1wHdLESu",0,0),
		("tancuonghuyn","$10$JoTn4m9b.8cYvIfo269L3u.4XJjo/RtjI0VAa51CxwsNa1wHdLESu",0,0),
		("ngocthanhkim","$10$JoTn4m9b.8cYvIfo269L3u.4XJjo/RtjI0VAa51CxwsNa1wHdLESu",0,0),
		("thiquyenhoang","$10$JoTn4m9b.8cYvIfo269L3u.4XJjo/RtjI0VAa51CxwsNa1wHdLESu",0,0),
		("thoantindam","$10$JoTn4m9b.8cYvIfo269L3u.4XJjo/RtjI0VAa51CxwsNa1wHdLESu",0,0),
		("vantannguyen","$10$JoTn4m9b.8cYvIfo269L3u.4XJjo/RtjI0VAa51CxwsNa1wHdLESu",0,0),
        ("vietcaonguyen","$10$JoTn4m9b.8cYvIfo269L3u.4XJjo/RtjI0VAa51CxwsNa1wHdLESu",0,0),
        ("tinvovan","$10$JoTn4m9b.8cYvIfo269L3u.4XJjo/RtjI0VAa51CxwsNa1wHdLESu",0,0),
        ("vietduynguyen","$10$JoTn4m9b.8cYvIfo269L3u.4XJjo/RtjI0VAa51CxwsNa1wHdLESu",0,0),
		("thanhsontran","$10$JoTn4m9b.8cYvIfo269L3u.4XJjo/RtjI0VAa51CxwsNa1wHdLESu",0,0)
        ;
        
insert into `app_role` (`name`,`flag_deleted`)
values ("ROLE_ADMIN",0),("ROLE_MANAGER",0),("ROLE_EMPLOYEE",0),("ROLE_CUSTOMER",0);

set FOREIGN_KEY_CHECKS = 0;
insert into `user_role`(`app_role_id`,`app_user_id`)
values (1,1),(2,2),(3,3),(3,4),(3,5),(4,6),(4,7),(4,8),(4,9),(3,10),(4,11),(4,12),(3,13);
set FOREIGN_KEY_CHECKS = 1;


-- customer 
insert into customer(id,address,birth_day,code,email,flag_deleted,name,note,phone_number,point,app_user_id)
values  (1,'Sơn Trà, Đà Nẵng','2000-01-01','KH001','ngoc@gmail.com',false,'Đàm Minh Nhật Ngọc', 'Không có tiền sử bệnh án','0913118559',0,1),
		(2,'Liên Chiểu, Đà Nẵng','2000-01-02','KH002','anh@gmail.com',false,'Lê Huy Anh', 'Không có tiền sử bệnh án','0913178259',0,2),
		(3,'Thanh Khê, Đà Nẵng','1999-01-01','KH003','vu@gmail.com',false,'Hoàng Nhật Vũ', 'Không có tiền sử bệnh án','0913378559',0,null),
		(4,'Ngũ Hành Sơn, Đà Nẵng','2000-01-05','KH004','thanh@gmail.com',false,'Ngọc Thành Kim', 'Không có tiền sử bệnh án','0413178559',0,3),
		(5,'Quận 7, Hồ Chí Minh','1997-01-01','KH005','yen@gmail.com',false,'Thị Hạnh Yến', 'Không có tiền sử bệnh án','0913148559',0,4),
		(6,'Sơn Trà, Đà Nẵng','2000-05-01','KH006','van@gmail.com',false,'Nguyễn Huệ Văn', 'Không có tiền sử bệnh án','0913175569',0,null),
		(7,'Sơn Trà, Đà Nẵng','2000-01-03','KH007','nguyet@gmail.com',false,'Trần Ánh Nguyệt', 'Không có tiền sử bệnh án','0913178769',0,5),
        (8,'Sơn Trà, Đà Nẵng','2000-01-01','KH008','ngoc@gmail.com',false,'Đàm Minh Nhật Ngọc', 'Không có tiền sử bệnh án','0913115027',0,6),
		(9,'Liên Chiểu, Đà Nẵng','2000-01-02','KH009','huy@gmail.com',false,'Lê Huy', 'Không có tiền sử bệnh án','09131782026',0,7),
		(10,'Thanh Khê, Đà Nẵng','1999-01-01','KH010','phuong@gmail.com',false,'Hoàng Nhật VũPhương', 'Không có tiền sử bệnh án','0913378025',0,null),
		(11,'Ngũ Hành Sơn, Đà Nẵng','2000-01-05','KH011','kimanh@gmail.com',false,'Ngọc Kim Ánh', 'Không có tiền sử bệnh án','041317855024',0,8),
		(12,'Sơn Trà, Đà Nẵng','2000-05-01','KH013','anhvan@gmail.com',false,'Nguyễn Anh Văn', 'Không có tiền sử bệnh án','0913175020',0,null),
		(13,'Sơn Trà, Đà Nẵng','2000-01-03','KH014','tran@gmail.com',false,'Trần Nguyệt', 'Không có tiền sử bệnh án','09131787019',0,10),
        (14,'Sơn Trà, Đà Nẵng','2000-01-01','KH015','minhngoc@gmail.com',false,'Đàm Minh Ngọc', 'Không có tiền sử bệnh án','0913118018',0,11),
		(15,'Liên Chiểu, Đà Nẵng','2000-01-02','KH016','leanh@gmail.com',false,'Lê Anh', 'Không có tiền sử bệnh án','0913178217',0,12),
		(16,'Thanh Khê, Đà Nẵng','1999-01-01','KH017','vu@gmail.com',false,'Hoàng Vũ', 'Không có tiền sử bệnh án','0913378516',0,null),
		(17,'Ngũ Hành Sơn, Đà Nẵng','2000-01-05','KH018','ngocyen@gmail.com',false,'Ngọc Yến', 'Không có tiền sử bệnh án','0413178515',0,13),
		(18,'Quận 7, Hồ Chí Minh','1997-01-01','KH019','nguyenanh@gmail.com',false,'Nguyễn Hạnh Yến', 'Không có tiền sử bệnh án','0913148514',0,14),
		(19,'Sơn Trà, Đà Nẵng','2000-05-01','KH020','linh@gmail.com',false,'Nguyễn Văn Linh', 'Không có tiền sử bệnh án','0913175513',0,null),
		(20,'Quang Trung, Huế','2000-01-03','KH021','nhungoc@gmail.com',false,'Trần Như Ngọc', 'Không có tiền sử bệnh án','0913178712',0,15);


-- employee
INSERT INTO `retro_care`.`employee` (`address`, `birthday`, `code_employee`, `flag_delete`, `id_card`, `name_employee`, `note`, `phone_number`, `start_day`,`app_user_id`)
 VALUES ('123 Nguyễn Văn Linh, Đà Nẵng', '2002-02-02', 'NV010', 1, '000000233333', 'Nguyễn Văn Bảy', 'Có bằng đại học', '0123123124', '2023-08-31',16),
		('45 Võ Thị Sáu, Quảng Nam', '2002-05-06', 'NV011', 1, '002456233333', 'Lê Văn Bách', 'Từng làm Parmacity', '0123454124', '2023-09-02',17), 
		('789 Lý Thường Kiệt, Huế', '1999-12-15', 'NV012', 1, '003456233333', 'Trần Thị Tám', 'Có kinh nghiệm 3 năm', '0123789123', '2023-09-05',18),
		('567 Trần Hưng Đạo, Đà Nẵng', '2000-08-20', 'NV013', 1, '004456233333', 'Phạm Văn Chín', 'Tốt nghiệp loại giỏi', '0123908123', '2023-09-06',19),
		('12 Trường Chinh, Quảng Nam', '1998-10-10', 'NV014', 1, '005456233333', 'Đinh Thị Mười Hai', 'Có chứng chỉ tiếng Anh', '0123567123', '2023-09-08',20),
		('456 Trần Phú, Huế', '1997-07-25', 'NV015', 1, '006456233333', 'Lê Văn Năm', 'Đạt chứng chỉ PMP', '0123465123', '2023-09-10',21),
		('789 Hoàng Diệu, Đà Nẵng', '2001-04-30', 'NV016', 1, '007456233333', 'Trần Thị Sáu', 'Có kinh nghiệm 2 năm', '0123164123', '2023-09-12',22),
		('123 Nguyễn Trãi, Quảng Nam', '1996-03-05', 'NV017', 1, '008456233333', 'Nguyễn Văn Bảy', 'Hoàn thành dự án lớn', '0123123123', '2023-09-15',23),
		('456 Lê Duẩn, Huế', '2003-01-01', 'NV018', 1, '009456233333', 'Phạm Thị Chín', 'Tốt nghiệp chuyên ngành', '0123454123', '2023-09-18',24),
		('789 Hoàng Văn Thụ, Đà Nẵng', '2000-09-08', 'NV019', 1, '010456233333', 'Lê Văn Mười', 'Có kinh nghiệm 5 năm', '0123789123', '2023-09-20',25),
		('123 Nguyễn Huệ, Quảng Nam', '1999-11-11', 'NV020', 1, '011456233333', 'Trần Thị Mười', 'Từng làm ở công ty A', '0123908123', '2023-09-22',26),
		('456 Trần Cao Vân, Huế', '1997-06-16', 'NV021', 1, '012456233333', 'Nguyễn Văn Năm', 'Có chứng chỉ Scrum Master', '0123567123', '2023-09-25',27);
    
    
insert into supplier (id, address, code, email, flag_deleted, name, note, phone_number)
values 	(1,'143 Hải Phòng,Đà Nẵng','NUTINE','nutine@gmail.com',false,'Dược Phẩm Nutine','Không có nợ','0908223242'),
		(2,'100 Hà Đông,Hà Nội','PHARMACITY','pharmacity@gmail.com',false,'Công Ty Pharmacity','Không có nợ','0902888675'),
		(3,'100 Hai Bà Trưng,Sài gòn','VITAMIN','vitamin@gmail.com',false,'Công Ty Vitamin','Không có nợ','0908222557'),
		(4,'253 Dũng Sĩ Thanh Khê,Đà Nẵng','DANAPHA','danapha@gmail.com',false,'Công Ty Danapha','Không có nợ','0907228425'),
		(5,'40 Triệu Nữ Vương,Đà Nẵng','TRAFACO','trapaco@gmail.com',false,'Công Ty Traphaco','Không có nợ','0978242235'),
		(6,'38 Bàu Năng 2 Đà Nẵng','ABIPHA','abipha@gmail.com',false,'Công Ty ABIPHA','Không có nợ','0987654321'),
		(7,'33 Yên Khê 2 Đà Nẵng','BLUE','bluegreen@gmail.com',false,'Công Ty Bluegreen','Không có nợ','0908223457'),
		(8,'142 Nguyễn Tri Phương Đà Nẵng','INTERN','intern@gmail.com',false,'Công Ty Intern','Không có nợ','0908223457'),
		(9,'120 Lý Thái Tông Đà Nẵng','CODUPHA','codupha@gmail.com',false,'Công Ty Codupha','Không có nợ','0986223425'),
		(10,'115 Ngô Gia Tự Đà Nẵng','CENTERPAHARCO','centerpharco@gmail.com',false,'Dược Phẩm Centerpharco','Không có nợ','0897223424'),
		(11,'253 Dũng Sĩ Thanh Khê,Đà Nẵng','DONAD','donadpha@gmail.com',false,'Công Ty Donad','Không có nợ','0987232421'),
        (12,'132 Hải Phòng, Đà Nẵng','NOVOTO','novoe@gmail.com',false,'Dược Phẩm Novoto','Không có nợ','0908223241'),
		(13,'20 Hà Thành, Hà Nội','PHARMACORD','pharmacord@gmail.com',false,'Công Ty Pharmacord','Không có nợ','0902888671'),
		(14,'50 Hai Bà Trưng, Hồ Chí Minh','VITAMIA','vitamia@gmail.com',false,'Dược phẩm Vitamia','Không có nợ','0908222111'),
		(15,'Thanh Khê, Đà Nẵng','BOCO','bocopharma@gmail.com',false,'Công Ty Boco Pharmacy','Không có nợ','090722844'),
		(16,'25 Triệu Nữ Vương, Huế','HUEPHARMA','huepharma@gmail.com',false,'Công Ty Hue Pharmacy','Không có nợ','0978242200'),
		(17,'111 Núi Thành, Đà Nẵng','ALIBABA','alibaba@gmail.com',false,'Công Ty ALIBABA','Không có nợ','0987654123'),
		(18,'01 Bạch Đằng, Đà Nẵng','BICONA','bicona@gmail.com',false,'Công Ty Bicona','Không có nợ','0908223432'),
		(19,'132 Nguyễn Tri Phương, Đà Nẵng','ALACO','ala@gmail.com',false,'Dược phẩm ALA','Không có nợ','0908223477'),
		(20,'10 Lý Thái Tông, Vinh','VINHPHACO','vinhphaco@gmail.com',false,'Công Ty VinhPhaco','Không có nợ','0986223415'),
		(21,'14 Yên Bái','GENEVER','genever@gmail.com',false,'Dược Phẩm Genever Việt Nam','Không có nợ','0897221424'),
		(22,'32 Lý Tự Trọng, Quận 1, Hồ Chí Minh','VINCO','vinco@gmail.com',false,'Công Ty Vinvohome','Không có nợ','0987232000'),
        (23,'12 Nguyễn Huệ, Đống Đa, Hà Nội','HANOIP','hanoipharma@gmail.com',false,'Dược Phẩm Pharmaty Hà Nội','Không có nợ','0905223242'),
		(24,'14 Đoàn Khê, Nha Trang','NATRANG','natrang@gmail.com',false,'Công Ty Natrang','Không có nợ','0902888678'),
		(25,'110 Nguyễn Ái Quốc, Nghệ An','AIQUOC','aiquoc@gmail.com',false,'Ái Quốc Pharmacy','Không có nợ','09082268689'),
		(26,'25 Hoài An, Bình Định','HOAIAN','hoaianpharmacy@gmail.com',false,'Công Ty Hoài An Pharmacy','Không có nợ','0903228425'),
		(27,'111 Trưng Nữ Vương, Đà Nẵng','HACOCORP','haococorp@gmail.com',false,'Công Ty Hacocorp','Không có nợ','0978242222'),
		(28,'38 Bàu Năng, Huế','THACO','thaco@gmail.com',false,'Công Ty Thaco Corp','Không có nợ','0987654111'),
		(29,'12 Thanh Hoa, Đà Nẵng','ANTHAI','aithaicorp@gmail.com',false,'Công Ty An Thái Corp','Không có nợ','0908223455'),
		(30,'15 Thái Hòa, Hải Dương','THAIHOA','thaihoa@gmail.com',false,'Dược phẩm Thái Hòa','Không có nợ','0903223459'),
		(31,'18 Thái Phiên, Nha Trang','THAIA','thaia@gmail.com',false,'Công Ty Thái An','Không có nợ','0983123425'),
		(32,'111 Ngô Tự, Đà Nẵng','TETRA','tetra@gmail.com',false,'Dược Phẩm Tetra','Không có nợ','0897223420'),
		(33,'12 An Thái, Hà Nội','HANAI','hanai@gmail.com',false,'Công Ty Hanai','Không có nợ','0987232474'),
        (34,'10 Xuân Diệu, Hồ Chí Minh','LIFEHEALTHY','nutine@gmail.com',false,'Dược Phẩm Healthy Life','Không có nợ','0908223242'),
		(35,'90 Hà Đông, Hà Nội','PHARMACITY','pharmacity@gmail.com',false,'Công Ty Pharmacity','Không có nợ','0902888675');
    
   -- Kind of medicine
INSERT INTO retro_care.kind_of_medicine (id, code, flag_deleted, name) VALUES (1, 'NT001', false, 'Bổ Gan');
INSERT INTO retro_care.kind_of_medicine (id, code, flag_deleted, name) VALUES (2, 'NT002', false, 'Bổ Phổi');
INSERT INTO retro_care.kind_of_medicine (id, code, flag_deleted, name) VALUES (3, 'NT003', false, 'Bổ Tim');
INSERT INTO retro_care.kind_of_medicine (id, code, flag_deleted, name) VALUES (4, 'NT004', false, 'Bổ Xương');
INSERT INTO retro_care.kind_of_medicine (id, code, flag_deleted, name) VALUES (5, 'NT005', false, 'Bổ Thận');
INSERT INTO retro_care.kind_of_medicine (id, code, flag_deleted, name) VALUES (6, 'NT006', false, 'Bổ Mắt');
INSERT INTO retro_care.kind_of_medicine (id, code, flag_deleted, name) VALUES (7, 'NT007', false, 'Bổ Não');
INSERT INTO retro_care.kind_of_medicine (id, code, flag_deleted, name) VALUES (8, 'NT008', false, 'Dạ Dày');
INSERT INTO retro_care.kind_of_medicine (id, code, flag_deleted, name) VALUES (9, 'NT009', false, 'Cảm Cúm');
INSERT INTO retro_care.kind_of_medicine (id, code, flag_deleted, name) VALUES (10, 'NT010', false, 'Tiểu Đường');
INSERT INTO retro_care.kind_of_medicine (id, code, flag_deleted, name) VALUES (11, 'NT011', false, 'Thống Phong');
INSERT INTO retro_care.kind_of_medicine (id, code, flag_deleted, name) VALUES (12, 'NT012', false, 'Huyết Áp Cao');
INSERT INTO retro_care.kind_of_medicine (id, code, flag_deleted, name) VALUES (13, 'NT013', false, 'Huyết Áp Thấp');   

    -- Medicine--
INSERT INTO medicine (id,code, name, price, quantity, vat, note, maker, active_element, origin, retail_profits, kind_of_medicine_id, flag_deleted)
VALUES
  (1,'MD001', 'Paracetamol', 10.5, 100, 10.0, 'Thuốc giảm đau', 'Nhà sản xuất A', 'Paracetamol', 'Việt Nam', 10.0, 1, 0),
  (2,'MD002', 'Amoxicillin', 15.2, 50, 5.0, 'Thuốc kháng sinh', 'Nhà sản xuất B', 'Amoxicillin', 'Việt Nam', 10.0, 2, 0),
  (3,'MD003', 'Omeprazole', 8.7, 80, 0.0, 'Thuốc chống loét dạ dày', 'Nhà sản xuất C', 'Omeprazole', 'Việt Nam', 10.0, 3, 0),
  (4,'MD004', 'Aspirin', 7.9, 120, 10.0, 'Thuốc giảm đau', 'Nhà sản xuất D', 'Aspirin', 'Việt Nam', 10.0, 1, 0),
  (5,'MD005', 'Simvastatin', 12.6, 60, 0.0, 'Thuốc hạ cholesterol', 'Nhà sản xuất E', 'Simvastatin', 'Việt Nam', 10.0, 4, 0),
  (6,'MD006', 'Loperamide', 9.3, 40, 5.0, 'Thuốc chống tiêu chảy', 'Nhà sản xuất F', 'Loperamide', 'Việt Nam', 10.0, 3, 0),
  (7,'MD007', 'Ibuprofen', 6.8, 90, 10.0, 'Thuốc giảm đau', 'Nhà sản xuất G', 'Ibuprofen', 'Việt Nam', 10.0, 1, 0),
  (8,'MD008', 'Cetirizine', 5.5, 70, 0.0, 'Thuốc hạ cholesterol', 'Nhà sản xuất H', 'Cetirizine', 'Việt Nam', 10.0, 4, 0),
  (9,'MD009', 'Azithromycin', 16.4, 30, 5.0, 'Thuốc kháng sinh', 'Nhà sản xuất I', 'Azithromycin', 'Việt Nam', 10.0, 2, 0),
  (10,'MD010', 'Dexamethasone', 11.9, 100, 0.0, 'Thuốc chống viêm, giảm ngứa', 'Nhà sản xuất J', 'Dexamethasone', 'Việt Nam', 10.0, 4, 0),
  (11,'MD011', 'Ibuprofen', 6.8, 90, 10.0, 'Thuốc giảm đau', 'Nhà sản xuất G', 'Ibuprofen', 'Việt Nam', 10.0, 1, 0),
  (12,'MD012', 'Cetirizine', 5.5, 70, 0.0, 'Thuốc hạ cholesterol', 'Nhà sản xuất H', 'Cetirizine', 'Việt Nam', 10.0, 4, 0),
  (13,'MD013', 'Azithromycin', 16.4, 30, 5.0, 'Thuốc kháng sinh', 'Nhà sản xuất I', 'Azithromycin', 'Việt Nam', 10.0, 2, 0),
  (14,'MD014', 'Dexamethasone', 11.9, 100, 0.0, 'Thuốc chống viêm, giảm ngứa', 'Nhà sản xuất J', 'Dexamethasone', 'Việt Nam', 10.0, 4, 0),
  (15,'MD015', 'Ranitidine', 9.7, 80, 0.0, 'Thuốc chống loét dạ dày', 'Nhà sản xuất K', 'Ranitidine', 'Việt Nam', 10.0, 3, 0),
  (16,'MD016', 'Atorvastatin', 14.5, 60, 0.0, 'Thuốc hạ cholesterol', 'Nhà sản xuất L', 'Atorvastatin', 'Việt Nam', 10.0, 4, 0),
  (17,'MD017', 'Erythromycin', 18.2, 40, 5.0, 'Thuốc kháng sinh', 'Nhà sản xuất M', 'Erythromycin', 'Việt Nam', 10.0, 2, 0),
  (18,'MD018', 'Prednisone', 8.3, 120, 10.0, 'Thuốc giảm đau', 'Nhà sản xuất N', 'Prednisone', 'Việt Nam', 10.0, 1, 0),
  (19,'MD019', 'Lisinopril', 12.8, 50, 0.0, 'Thuốc hạ huyết áp', 'Nhà sản xuất O', 'Lisinopril', 'Việt Nam', 10.0, 5, 0),
  (20,'MD020', 'Ciprofloxacin', 7.6, 70, 5.0, 'Thuốc kháng sinh', 'Nhà sản xuất P', 'Ciprofloxacin', 'Việt Nam', 10.0, 2, 0),
  (21,'MD021', 'Prozac', 14.0, 75, 5.0, 'Thuốc chống trầm cảm', 'Nhà sản xuất Q', 'Fluoxetine', 'Việt Nam', 10.0, 6, 0),
  (22,'MD022', 'Metformin', 9.5, 85, 0.0, 'Thuốc điều trị đái tháo đường', 'Nhà sản xuất R', 'Metformin', 'Việt Nam', 10.0, 7, 0),
  (23,'MD023', 'Hydrochlorothiazide', 12.3, 65, 0.0, 'Thuốc hạ áp lực máu', 'Nhà sản xuất S', 'Hydrochlorothiazide', 'Việt Nam', 10.0, 8, 0),
  (24,'MD024', 'Morphine', 18.7, 55, 10.0, 'Thuốc giảm đau mạnh', 'Nhà sản xuất T', 'Morphine', 'Việt Nam', 10.0, 1, 0),
  (25,'MD025', 'Diazepam', 7.0, 95, 5.0, 'Thuốc an thần', 'Nhà sản xuất U', 'Diazepam', 'Việt Nam', 10.0, 9, 0),
  (26,'MD026', 'Tramadol', 15.6, 45, 10.0, 'Thuốc giảm đau', 'Nhà sản xuất V', 'Tramadol', 'Việt Nam', 10.0, 1, 0),
  (27,'MD027', 'Cefuroxime', 11.1, 105, 5.0, 'Thuốc kháng sinh', 'Nhà sản xuất W', 'Cefuroxime', 'Việt Nam', 10.0, 2, 0),
  (28,'MD028', 'Loratadine', 6.3, 115, 0.0, 'Thuốc chống dị ứng', 'Nhà sản xuất X', 'Loratadine', 'Việt Nam', 10.0, 10, 0),
  (29,'MD029', 'Warfarin', 10.9, 35, 0.0, 'Thuốc chống đông máu', 'Nhà sản xuất Y', 'Warfarin', 'Việt Nam', 10.0, 11, 0),
  (30,'MD030', 'Metoprolol', 8.4, 125, 0.0, 'Thuốc điều trị tăng huyết áp', 'Nhà sản xuất Z', 'Metoprolol', 'Việt Nam', 10.0, 12, 0);
    -- Image Medicine--
INSERT INTO image_medicine(id, flag_deleted, image_path, medicine_id)
VALUE
  (1, FALSE, 'https://cdn.tgdd.vn/Products/Images/10053/129005/enervon-600x600.jpg',1),
  (2, FALSE, 'https://cdn.tgdd.vn/Products/Images/10053/129006/enervon-600x600.jpg', 2),
  (3, FALSE, 'https://cdn.tgdd.vn/Products/Images/10053/129007/enervon-600x600.jpg', 3),
  (4, FALSE, 'https://cdn.tgdd.vn/Products/Images/10053/129008/enervon-600x600.jpg', 4),
  (5, FALSE, 'https://cdn.tgdd.vn/Products/Images/10053/129009/enervon-600x600.jpg', 5),
  (6, FALSE, 'https://cdn.tgdd.vn/Products/Images/10053/129010/enervon-600x600.jpg', 6),
  (7, FALSE, 'https://cdn.tgdd.vn/Products/Images/10053/129011/enervon-600x600.jpg', 7),
  (8, FALSE, 'https://cdn.tgdd.vn/Products/Images/10053/129012/enervon-600x600.jpg', 8),
  (9, FALSE, 'https://cdn.tgdd.vn/Products/Images/10053/129013/enervon-600x600.jpg', 9),
  (10, FALSE, 'https://cdn.tgdd.vn/Products/Images/10053/129014/enervon-600x600.jpg', 10);
  

  
-- Unit--
INSERT INTO unit(id, name, flag_deleted)
VALUES
  (1, 'Hộp', FALSE),
  (2, 'Vỉ', FALSE),
  (3, 'Viên', False);

-- Unit Detail--
INSERT INTO unit_detail(id, conversion_rate, conversion_unit, flag_deleted, medicine_id, unit_id)
VALUE
  (1, 10,'Viên', FALSE, 1, 1),
  (2, 5, 'Hộp', FALSE, 2, 1),
  (3, 3, 'Hộp', FALSE, 3, 1),
  (4, 4, 'Vỉ', FALSE, 4, 2),
  (5, 6, 'Vỉ', FALSE, 5, 1),
  (6, 2, 'Viên', FALSE, 6, 3),
  (7, 8, 'Viên', FALSE, 7, 2),
  (8, 7, 'Hộp', FALSE, 8, 1),
  (9, 9, 'Hộp', FALSE, 9, 1),
  (10, 1, 'Viên', FALSE, 10, 3);

    
-- patient-- 
INSERT INTO `retro_care`.`patient` (`id`, `flag_deleted`, `name`) VALUES (1, 0, 'Phụ nữ mang thai');
INSERT INTO `retro_care`.`patient` (`id`, `flag_deleted`, `name`) VALUES (2, 0, 'Trẻ em');
INSERT INTO `retro_care`.`patient` (`id`, `flag_deleted`, `name`) VALUES (3, 0, 'Người lớn');
INSERT INTO `retro_care`.`patient` (`id`, `flag_deleted`, `name`) VALUES (4, 0, 'Người già');

-- prescription-- 
INSERT INTO `retro_care`.`prescription` (`id`, `code`, `duration`, `flag_deleted`, `name`, `note`, `symptoms`, `patient_id`) VALUES (1, 'TH-001', 4, 0, 'Cảm', 'Không có', 'Ho,rát họng', 2);
INSERT INTO `retro_care`.`prescription` (`id`, `code`, `duration`, `flag_deleted`, `name`, `note`, `symptoms`, `patient_id`) VALUES (2, 'TH-002', 5, 0, 'Sốt', 'Không có', 'Nhiệt độ lớn hơn 38 độ', 3);
INSERT INTO `retro_care`.`prescription` (`id`, `code`, `duration`, `flag_deleted`, `name`, `note`, `symptoms`, `patient_id`) VALUES (3, 'TH-003', 3, 0, 'Viêm da', 'Không có', 'Nổi mẩn da', 1);
INSERT INTO `retro_care`.`prescription` (`id`, `code`, `duration`, `flag_deleted`, `name`, `note`, `symptoms`, `patient_id`) VALUES (4, 'TH-004', 4, 0, 'Dị ứng', 'Không có', 'Ngứa nổi mẩn', 2);
INSERT INTO `retro_care`.`prescription` (`id`, `code`, `duration`, `flag_deleted`, `name`, `note`, `symptoms`, `patient_id`) VALUES (5, 'TH-005', 7, 0, 'Tiêu chảy', 'Không có', 'Đau bụng, đi ngoài', 3);
INSERT INTO `retro_care`.`prescription` (`id`, `code`, `duration`, `flag_deleted`, `name`, `note`, `symptoms`, `patient_id`) VALUES (6, 'TH-006', 5, 0, 'Nhức đầu', 'Không có', 'Hoa mắt, chóng mặt', 4);
INSERT INTO `retro_care`.`prescription` (`id`, `code`, `duration`, `flag_deleted`, `name`, `note`, `symptoms`, `patient_id`) VALUES (7, 'TH-007', 4, 0, 'Cúm', 'Không có', 'Ho', 4);
INSERT INTO `retro_care`.`prescription` (`id`, `code`, `duration`, `flag_deleted`, `name`, `note`, `symptoms`, `patient_id`) VALUES (8, 'TH-008', 5, 0, 'Sẹo', 'Không có', 'Viêm da', 2);

-- indication-- 
INSERT INTO `retro_care`.`indication` (`id`, `dosage`, `flag_deleted`, `frequency`, `prescription_id`, `medicine_id`) VALUES (1, 3, 0, 2, 3, 2);
INSERT INTO `retro_care`.`indication` (`id`, `dosage`, `flag_deleted`, `frequency`, `prescription_id`, `medicine_id`) VALUES (2, 4, 0, 1, 2, 1);
INSERT INTO `retro_care`.`indication` (`id`, `dosage`, `flag_deleted`, `frequency`, `prescription_id`, `medicine_id`) VALUES (3, 5, 0, 2, 2, 3);
INSERT INTO `retro_care`.`indication` (`id`, `dosage`, `flag_deleted`, `frequency`, `prescription_id`, `medicine_id`) VALUES (4, 2, 0, 2, 3, 4);
INSERT INTO `retro_care`.`indication` (`id`, `dosage`, `flag_deleted`, `frequency`, `prescription_id`, `medicine_id`) VALUES (5, 3, 0, 3, 2, 5);
INSERT INTO `retro_care`.`indication` (`id`, `dosage`, `flag_deleted`, `frequency`, `prescription_id`, `medicine_id`) VALUES (6, 4, 0, 2, 2, 6);


-- invoice
INSERT INTO `invoice` (`code`, `document_number`, `creation_date`, `paid`, `note`, `flag_deleted`, `supplier_id`, `app_user_id`)
	VALUES ('HDN0001', 'DOC001', '2023-09-25 10:00:00', 1000.00, 'Payment received', 0, 1, 1),
	('HDN0002', 'DOC002', '2023-09-20 14:30:00', 1500.00, 'Payment pending', 0, 2, 2),
	('HDN0003', 'DOC003', '2023-09-21 09:45:00', 2000.00, 'Payment received', 0, 1, 3),
	 ('HDN0004', 'DOC004', '2023-09-22 11:00:00', 1200.00, 'Payment received', 0, 2, 4),
	 ('HDN0005', 'DOC005', '2023-09-19 08:25:10', 1500.00, 'Payment pending', 0, 10, 5),
	 ('HDN0006', 'DOC006', '2023-09-19 14:17:20', 1200.00, 'Payment pending', 0, 2, 2),
	 ('HDN0007', 'DOC007', '2023-09-20 16:20:00', 1200.00, 'Payment pending', 0, 5, 3),
	 ('HDN0008', 'DOC008', '2023-09-20 14:54:00', 1900.00, 'Payment pending', 0, 1, 4),
	 ('HDN0009', 'DOC009', '2023-09-23 10:35:45', 1500.00, 'Payment pending', 0, 7, 2),
	 ('HDN0010', 'DOC0010', '2023-09-23 09:23:54', 1500.00, 'Payment pending', 0, 8, 5);

-- invoice detail
INSERT INTO `invoice_detail` (`discount`, `medicine_quantity`, `lot`, `flag_deleted`, `medicine_id`, `invoice_id`,`expiry`)
VALUES (0.1, 10, '20230918', 0, 1, 1,'2024-09-18'),
(0.05, 5, '20230918', 0, 1, 1,'2024-09-18'),
(0.2, 8, '20230918', 0, 2, 2,'2024-09-18'),
(0.1, 12, '20230918', 0, 2, 2,'2024-09-18'),
(0.15, 6, '20231918', 0, 3, 3,'2024-09-18'),
(0.1, 10, '20230918', 0, 3, 3,'2024-09-18'),
 (0.15, 6, '20230918', 0, 4, 4,'2024-09-18'),
 (0.1, 12, '20230918', 0, 4, 4,'2024-09-18'),
 (0.2, 8, 'NV1918', 0, 5, 5,'2024-09-18'),
 (0.05, 5, 'NV1918', 0, 5, 5,'2024-09-18'),
 (0.1, 10, 'NV1918', 0, 6, 6,'2024-09-18'),
 (0.15, 6, 'NV1918', 0, 6, 6,'2024-09-18'),
 (0.1, 12, '230101', 0, 7, 7,'2024-01-01'),
 (0.2, 8, '230101', 0, 7, 7,'2024-01-01'),
 (0.05, 5, '230101', 0, 8, 8,'2024-01-01'),
 (0.1, 10, '230101', 0,8, 8,'2024-01-01'),
 (0.15, 6, '230601', 0, 9, 9,'2024-06-01'),
 (0.1, 12, '230601', 0, 9, 9,'2024-06-01'),
 (0.2, 8, '230601', 0, 10, 10,'2024-06-01'),
 (0.05, 5, '230601', 0, 10, 10,'2024-06-01');

-- order, order details, cart, order_user
INSERT INTO retro_care.cart_details (id, quantity, app_user_id, medicine_id) VALUES (1, 5, 1, 1);
INSERT INTO retro_care.cart_details (id, quantity, app_user_id, medicine_id) VALUES (2, 2, 1, 2);
INSERT INTO retro_care.cart_details (id, quantity, app_user_id, medicine_id) VALUES (3, 1, 2, 3);
INSERT INTO retro_care.cart_details (id, quantity, app_user_id, medicine_id) VALUES (4, 3, 2, 4);
INSERT INTO retro_care.cart_details (id, quantity, app_user_id, medicine_id) VALUES (5, 4, 2, 1);

INSERT INTO retro_care.orders (id, code, date_time, flag_deleted, note) VALUES (1, 'OR1', '2023-09-11 16:09:33', false, "");
INSERT INTO retro_care.orders (id, code, date_time, flag_deleted, note) VALUES (2, 'OR2', '2023-09-12 16:09:33', false, "");
INSERT INTO retro_care.orders (id, code, date_time, flag_deleted, note) VALUES (3, 'OR3', '2023-09-13 16:09:33', false, "");
INSERT INTO retro_care.orders (id, code, date_time, flag_deleted, note) VALUES (4, 'OR4', '2023-09-14 16:09:33', false, "");
INSERT INTO retro_care.orders (id, code, date_time, flag_deleted, note) VALUES (5, 'OR5', '2023-09-15 16:09:33', false, "");
INSERT INTO retro_care.order_details (id, current_price, quantity, medicine_id, order_id) VALUES (1, 50000, 2, 1, 1);
INSERT INTO retro_care.order_details (id, current_price, quantity, medicine_id, order_id) VALUES (2, 70000, 4, 2, 2);
INSERT INTO retro_care.order_details (id, current_price, quantity, medicine_id, order_id) VALUES (3, 60000, 6, 3, 3);
INSERT INTO retro_care.order_details (id, current_price, quantity, medicine_id, order_id) VALUES (4, 30000, 8, 4, 4);
INSERT INTO retro_care.order_details (id, current_price, quantity, medicine_id, order_id) VALUES (5, 70000, 10, 5, 5);

INSERT INTO retro_care.user_order (id, app_user_id, order_id) VALUES (1, 1, 1);
INSERT INTO retro_care.user_order (id, app_user_id, order_id) VALUES (2, 1, 2);
INSERT INTO retro_care.user_order (id, app_user_id, order_id) VALUES (3, 1, 3);
INSERT INTO retro_care.user_order (id, app_user_id, order_id) VALUES (4, 2, 4);
INSERT INTO retro_care.user_order (id, app_user_id, order_id) VALUES (5, 2, 5);

-- Nguyễn Lưu Minh Hạnh procedure Query SQL - altered 199 1700
ALTER TABLE cart_details
    ADD UNIQUE INDEX user_medicine_index (app_user_id, medicine_id);

DELIMITER //
CREATE PROCEDURE createOrder(IN user_id BIGINT, IN loyaltyPoint BIGINT)
BEGIN
    -- create a new order
    INSERT INTO orders (date_time, flag_deleted)
    VALUES (NOW(), 0);

    -- get the ID of the new added order
    SET @order_id = LAST_INSERT_ID();

    -- uupdate the 'code' field with the prefix 'KOL' and the orderId
    UPDATE orders
    SET code = CONCAT('KOL', @order_id)
    WHERE id = @order_id;

    -- insert a new row into user_order
    INSERT INTO user_order (app_user_id, order_id)
    VALUES (user_id, @order_id);

    -- Create new order details for each item in the cart
    INSERT INTO order_details (order_id, medicine_id, quantity, current_price)
    SELECT @order_id, cd.medicine_id, cd.quantity, m2.price
    FROM cart_details cd
    inner join medicine m2 on m2.id = cd.medicine_id
    WHERE app_user_id = user_id;

    -- update the quantity in the medicine table
    UPDATE medicine AS m
    INNER JOIN cart_details AS c ON m.id = c.medicine_id
    INNER JOIN unit_detail AS ud ON m.id = ud.medicine_id
    SET m.quantity = m.quantity - (c.quantity * ud.conversion_rate)
    WHERE c.app_user_id = user_id;

    -- update point
    update customer c
    set c.point = loyaltyPoint
    where c.app_user_id = user_id;

    -- delete the items from the cart
    DELETE FROM cart_details WHERE app_user_id = user_id;

END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE getCartDetailsForMail(IN user_id BIGINT)
BEGIN
    SELECT c.id as customerId, c.phone_number as phoneNumber,
     cd.id as cartId, m.id as medicineId, c.email as customerEmail, m.name AS medicineName,
           ( SELECT image_path
             FROM image_medicine im
             WHERE im.medicine_id = m.id
             ORDER BY im.id
             LIMIT 1) as medicineImage,
           m.price as medicinePrice,
           cd.quantity AS quantityInCart,
           c.name AS customerName,
           c.address AS address,
           c.point as loyaltyPoint
    FROM cart_details as cd
             JOIN medicine m ON cd.medicine_id = m.id
             JOIN app_user au ON cd.app_user_id = au.id
             JOIN customer c ON au.id = c.app_user_id
    WHERE cd.app_user_id = user_id;
END //
DELIMITER ;

-- SET GLOBAL sql_mode=(SELECT REPLACE(@@sql_mode,'ONLY_FULL_GROUP_BY',''));

-- Huỳnh Lê Tấn Cường

DELIMITER //
create procedure create_invoice (
code_p varchar(50),
document_number_p varchar(50),
creation_date_p datetime,
paid_p double,
note_p longtext,
flag_deleted_p bit(1) ,
supplier_id_p bigint,
app_user_id_p bigint)
BEGIN
insert into invoice(code,document_number,creation_date,paid,note,flag_deleted,supplier_id,app_user_id)
VALUES (code_p ,document_number_p,creation_date_p,paid_p,note_p,flag_deleted_p,supplier_id_p,app_user_id_p);
select id,code,document_number,creation_date,paid,note,flag_deleted,supplier_id,app_user_id
from invoice
where id in (
				select max(id)
				from invoice
            );
END //
DELIMITER ;
DELIMITER //
create procedure edit_invoice (id_p bigint,
code_p varchar(50),
document_number_p varchar(50),
creation_date_p datetime,
paid_p double,
note_p longtext,
flag_deleted_p bit(1) ,
supplier_id_p bigint)
BEGIN
UPDATE invoice
SET code = code_p,document_number=document_number_p,creation_date=creation_date_p,paid=paid_p,note=note_p,flag_deleted=flag_deleted_p,supplier_id=supplier_id_p
WHERE id = id_p;
select id,code,document_number,creation_date,paid,note,flag_deleted,supplier_id,app_user_id
from invoice
where id = id_p;
END //
DELIMITER ;

DELIMITER //
create procedure addRoleForAppUser(app_role_id bigint, app_user_id bigint)
begin 
set FOREIGN_KEY_CHECKS = 0;
insert into user_role ( app_role_id,app_user_id)
values (app_role_id,app_user_id);
set FOREIGN_KEY_CHECKS = 1;
end //
DELIMITER ;
