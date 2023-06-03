INSERT INTO Users (username, password, email, role) VALUES ('admin', 'admin123', 'admin@example.com', 'admin');
INSERT INTO Users (username, password, email, role) VALUES ('user', 'user123', 'user@example.com', 'user');

INSERT INTO Products (name, description, price, product_class, delivery_date, quantity) VALUES ('Product A', 'Product A description', 100, '食品', '2023-06-01', 10);
INSERT INTO Products (name, description, price, product_class, delivery_date, quantity) VALUES ('Product B', 'Product B description', 200, '嗜好品', '2023-07-01', 20);
INSERT INTO Products (name, description, price, product_class, delivery_date, quantity) VALUES ('Product C', 'Product C description', 300, '飲料水', '2023-08-01', 30);

INSERT INTO Suppliers (name, address, email, phone) VALUES ('Supplier A', '123 Main St', 'supplierA@example.com', '555-1234');
INSERT INTO Suppliers (name, address, email, phone) VALUES ('Supplier B', '456 Market St', 'supplierB@example.com', '555-5678');

INSERT INTO Product_Suppliers (product_id, supplier_id) VALUES (1, 1);
INSERT INTO Product_Suppliers (product_id, supplier_id) VALUES (2, 2);
INSERT INTO Product_Suppliers (product_id, supplier_id) VALUES (3, 1);


