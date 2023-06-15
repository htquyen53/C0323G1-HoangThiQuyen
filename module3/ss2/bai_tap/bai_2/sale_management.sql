DROP DATABASE IF EXISTS sales_management;
CREATE DATABASE sales_management;
USE sales_management;
CREATE TABLE customer (
    cID INT AUTO_INCREMENT PRIMARY KEY,
    cName VARCHAR(70),
    cAge INT(3)
);
CREATE TABLE product (
    pID INT AUTO_INCREMENT PRIMARY KEY,
    pName VARCHAR(100),
    pPrice DOUBLE
);
CREATE TABLE order_ (
    oID INT AUTO_INCREMENT PRIMARY KEY,
    cID INT,
    oDate DATE,
    oTotalPrice DOUBLE,
    FOREIGN KEY (cID)
        REFERENCES customer (cID)
);
CREATE TABLE order_detail (
    oID INT,
    pID INT,
    odQTY INT,
    CONSTRAINT positive_odQTY CHECK (odQTY>1),
    FOREIGN KEY (oID)
        REFERENCES order_ (oID),
    FOREIGN KEY (pID)
        REFERENCES product (pID)        
);
