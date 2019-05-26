USE master
GO
IF EXISTS (SELECT d.name FROM sys.databases d WHERE d.name='MobileStore')
	DROP DATABASE MobileStore
GO
CREATE DATABASE MobileStore
GO
USE MobileStore
GO
CREATE TABLE administrator(
	admin_id INT PRIMARY KEY IDENTITY(1,1),
	user_name VARCHAR(255),
	password VARCHAR(255),
	role VARCHAR(255)
)
GO
CREATE TABLE Product(
	product_id INT PRIMARY KEY IDENTITY(1,1),
	product_name VARCHAR(255),
	product_description TEXT,
	unit_price DECIMAL,
	unit_in_stock INT,
	manufacture_id INT,
	category_id INT,
	status BIT,
	delete_flag BIT DEFAULT 0,
	condition SMALLINT,
	update_time DATETIME,
	base_64_Image TEXT
)
GO
CREATE TABLE Orders(
	order_id INT PRIMARY KEY IDENTITY(1,1),
	order_date DATETIME,
	status VARCHAR(50),
	delete_flag BIT DEFAULT 0,
	customer_id INT
)
GO
CREATE TABLE order_detail(
	order_id INT NOT NULL,
	product_id INT NOT NULL,
	quantity INT
)
GO
CREATE TABLE manufacture(
	manufacture_id INT PRIMARY KEY IDENTITY(1,1),
	manufacture_name NVARCHAR(255)
)
GO
CREATE TABLE category(
	category_id INT PRIMARY KEY IDENTITY,
	category_name NVARCHAR(255)
)
GO
CREATE TABLE customer(
	customer_id INT PRIMARY KEY IDENTITY(1,1),
	customer_name NVARCHAR(255),
	address NVARCHAR(255),
	phone_number VARCHAR(20)
)
GO
CREATE TABLE invoice(
	order_id INT NOT NULL,
	auditor_id INT NOT NULL,
	audit_time DATE
)
GO
ALTER TABLE product
ADD CONSTRAINT FK_product_category FOREIGN KEY(category_id) REFERENCES category(category_id)
GO
ALTER TABLE product
ADD CONSTRAINT FK_product_manufacture FOREIGN KEY(manufacture_id) REFERENCES manufacture(manufacture_id)
GO
ALTER TABLE order_detail
ADD CONSTRAINT PK_order_detail PRIMARY KEY(order_id, product_id)
GO
ALTER TABLE order_detail
ADD CONSTRAINT FK_orderdetail_order FOREIGN KEY(order_id) REFERENCES orders(order_id)
GO
ALTER TABLE order_detail
ADD CONSTRAINT FK_orderdetail_product FOREIGN KEY(product_id) REFERENCES product(product_id)
GO
ALTER TABLE orders
ADD CONSTRAINT FK_order_customer FOREIGN KEY(customer_id) REFERENCES customer(customer_id)
GO
ALTER TABLE invoice
ADD CONSTRAINT PK_invoice PRIMARY KEY(order_id, auditor_id)
GO
ALTER TABLE invoice
ADD CONSTRAINT FK_invoice_order FOREIGN KEY(order_id) REFERENCES orders(order_id)
GO
ALTER TABLE invoice
ADD CONSTRAINT FK_invoice_admin FOREIGN KEY(auditor_id) REFERENCES administrator(admin_id)
GO
CREATE TRIGGER trg_order_detail ON order_detail
FOR INSERT, UPDATE
AS
	UPDATE Product SET unit_in_stock = (p.unit_in_stock - i.quantity) FROM inserted i, Product p WHERE p.product_id = i.product_id
GO
INSERT INTO administrator(user_name, password, role) VALUES ('namnv25', '123456', 'ADMIN')
INSERT INTO administrator(user_name, password, role) VALUES ('trangdtv', '123456', 'STAFF')
INSERT INTO administrator(user_name, password, role) VALUES ('dongtv3', '123456', 'ADMIN')
INSERT INTO administrator(user_name, password, role) VALUES ('congnt12', '123456', 'ADMIN')
GO
INSERT INTO category(category_name) VALUES ('Mobile phone')
INSERT INTO category(category_name) VALUES ('Laptop')
GO
INSERT INTO manufacture(manufacture_name) VALUES ('Apple')
INSERT INTO manufacture(manufacture_name) VALUES ('Samsung')
GO

select * from Product;
select * from administrator;

