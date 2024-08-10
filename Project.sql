GO 
CREATE DATABASE MobileManagement;
USE MobileManagement;

CREATE TABLE tbl_Mobile (
    mobileId VARCHAR(10) PRIMARY KEY,
    description VARCHAR(250) NOT NULL,
    price FLOAT,
    mobileName VARCHAR(20) NOT NULL,
    yearOfProduction INT,
    quantity INT,
    notSale BIT DEFAULT 0,
	imageLink NVARCHAR(225),
);
select * from tbl_Mobile

CREATE TABLE tbl_User (
    userId VARCHAR(20) PRIMARY KEY,
    password INT NOT NULL,
    fullName VARCHAR(50) NOT NULL,
    role INT CHECK (role IN (0, 1, 2))
);

select * from tbl_User

CREATE TABLE tbl_Cart (
    cartId int PRIMARY KEY IDENTITY,
    userId varchar(20) REFERENCES tbl_User(userId),
    mobileId varchar(10) REFERENCES tbl_Mobile(mobileId),
    quantity int
);
select * from tbl_Cart


delete from tbl_Cart
delete from tbl_User

INSERT INTO tbl_User (userId, password, fullName, role) VALUES ('Staff-John', 3000, 'John', 0);
INSERT INTO tbl_User (userId, password, fullName, role) VALUES ('User-Hilter', 1945, 'Hilter', 2);
INSERT INTO tbl_User (userId, password, fullName, role) VALUES ('User-LTP', 2004, 'Phú', 2);
INSERT INTO tbl_User (userId, password, fullName, role) VALUES ('Staff-Phu', 1945, 'Bờ Hú', 2);

INSERT INTO tbl_Mobile (mobileId, description, price, mobileName, yearOfProduction, quantity, notSale, imageLink)
VALUES ('M001', 'China', 500.00, 'Huawei', 2022, 10, 0,'https://static-images.vnncdn.net/files/publish/2023/8/30/huawei-mate-609.jpg')
INSERT INTO tbl_Mobile (mobileId, description, price, mobileName, yearOfProduction, quantity, notSale, imageLink)
VALUES ('M002', 'USA', 500.00, 'Iphone', 2022, 10, 0,'https://cdn.hoanghamobile.com/i/preview/Uploads/2023/09/13/iphone-15-pro-natural-titanium-pure-back-iphone-15-pro-natural-titanium-pure-front-2up-screen-usen.png')
INSERT INTO tbl_Mobile (mobileId, description, price, mobileName, yearOfProduction, quantity, notSale, imageLink)
VALUES ('M003', 'The most recent Vietnamese Phone', 500.00, 'VSmart', 2022, 10, 0,'https://cdnmedia.baotintuc.vn/Upload/XjfgEPYM30O8z6jY3MHxSw/files/2019/09/1409/8_%20%20xanh%20den.jpg')
INSERT INTO tbl_Mobile (mobileId, description, price, mobileName, yearOfProduction, quantity, notSale, imageLink)
VALUES ('M004', 'another Chinese Brand', 500.00, 'Oppo', 2022, 10, 0,'https://cdn2.cellphones.com.vn/insecure/rs:fill:0:358/q:90/plain/https://cellphones.com.vn/media/catalog/product/o/p/oppo-a58_1_1.png')
INSERT INTO tbl_Mobile (mobileId, description, price, mobileName, yearOfProduction, quantity, notSale, imageLink)
VALUES ('M005', 'none?', 500.00, 'none?', 2022, 10, 0,'')