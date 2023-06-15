DROP DATABASE IF exists inventory_management;
CREATE DATABASE inventory_management;
USE inventory_management;
CREATE TABLE delivery_note (
    delivery_note_code INT AUTO_INCREMENT PRIMARY KEY,
    shipping_date DATE
);
CREATE TABLE receipt_note (
    receipt_note_code INT AUTO_INCREMENT PRIMARY KEY,
    receipt_date DATE
);

CREATE TABLE supplier (
    supplier_code INT AUTO_INCREMENT PRIMARY KEY,
    supplier_name VARCHAR(255),
    supplier_address VARCHAR(255)
);
CREATE TABLE number_phone (
    id_phone INT NOT NULL PRIMARY KEY,
    supplier_code INT NOT NULL,
    FOREIGN KEY (supplier_code)
        REFERENCES supplier (supplier_code)
);
CREATE TABLE orders (
    order_code INT AUTO_INCREMENT PRIMARY KEY,
    order_date DATE,
    supplier_code INT NOT NULL,
    FOREIGN KEY (supplier_code)
        REFERENCES supplier (supplier_code)
);
CREATE TABLE materials (
    material_code INT AUTO_INCREMENT PRIMARY KEY,
    material_name VARCHAR(255)
);
CREATE TABLE delivery_detail (
    delivery_note_code INT NOT NULL,
    material_code INT NOT NULL,
    PRIMARY KEY (delivery_note_code , material_code),
    shipped_unit_price DOUBLE,
    shipped_quantity INT,
    FOREIGN KEY (delivery_note_code)
        REFERENCES delivery_note (delivery_note_code),
    FOREIGN KEY (material_code)
        REFERENCES materials (material_code)
);
CREATE TABLE receipt_details (
    receipt_unit_price DOUBLE,
    receipt_quantity INT,
    material_code INT NOT NULL,
    receipt_note_code INT NOT NULL,
    PRIMARY KEY (material_code , receipt_note_code),
    FOREIGN KEY (material_code)
        REFERENCES materials (material_code),
    FOREIGN KEY (receipt_note_code)
        REFERENCES receipt_note (receipt_note_code)
);
CREATE TABLE order_detail (
    material_code INT NOT NULL,
    order_code INT NOT NULL,
    PRIMARY KEY (material_code , order_code),
    FOREIGN KEY (material_code)
        REFERENCES materials (material_code),
    FOREIGN KEY (order_code)
        REFERENCES orders (order_code)
);
