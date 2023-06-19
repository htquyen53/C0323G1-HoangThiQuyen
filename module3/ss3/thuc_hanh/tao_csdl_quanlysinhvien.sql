CREATE DATABASE QuanLySinhVien;
USE QuanLySinhVien;
CREATE TABLE class (
classID INT not null auto_increment primary KEY,
className VARCHAR(60) NOT NULL,
startDate DATETIME NOT NULL,
Status bit
);
CREATE TABLE Student (
StudentID INT not null auto_increment PRIMARY KEY,
StudentName VARCHAR(30) NOT NULL,
Address VARCHAR(50),
Phone VARCHAR (20),
Status BIT,
ClassID INT NOT NULL,
FOREIGN KEY (ClassID) REFERENCES Class (ClassID)
);
CREATE TABLE Subject (
SubID INT NOT NULL auto_increment PRIMARY KEY,
SubName VARCHAR (30) NOT NULL,
Credit TINYINT NOT NULL DEFAULT 1 CHECK (Credit >= 1),
Status BIT default 1
);
CREATE TABLE Mark (
MarkID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
SubID INT NOT NULL,
StudentID INT NOT NULL,
Mark FLOAT DEFAULT 0 CHECK (Mark BETWEEN 0 AND 100),
ExamTimes TINYINT DEFAULT 1,
UNIQUE (SubID, StudentID),
foreign key (SubID) references Subject (SubID),
foreign key (StudentID) references Student (StudentID)
);
