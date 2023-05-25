INSERT INTO Users (username, password, email, role) VALUES ('admin', 'admin123', 'admin@example.com', 'admin');
INSERT INTO Users (username, password, email, role) VALUES ('user', 'user123', 'user@example.com', 'user');

INSERT INTO Products (name, description, price, delivery_date, product_class, quantity) VALUES ('Product A', 'Product A description', 100, '2023-06-01', '食品', 10);
INSERT INTO Products (name, description, price, delivery_date, product_class, quantity) VALUES ('Product B', 'Product B description', 200, '2023-07-01', '嗜好品', 20);
INSERT INTO Products (name, description, price, delivery_date, product_class, quantity) VALUES ('Product C', 'Product C description', 300, '2023-08-01', '飲料水', 30);

INSERT INTO Suppliers (name, address, email, phone) VALUES ('Supplier A', '123 Main St', 'supplierA@example.com', '555-1234');
INSERT INTO Suppliers (name, address, email, phone) VALUES ('Supplier B', '456 Market St', 'supplierB@example.com', '555-5678');

INSERT INTO Product_Suppliers (product_id, supplier_id) VALUES (1, 1);
INSERT INTO Product_Suppliers (product_id, supplier_id) VALUES (2, 2);
INSERT INTO Product_Suppliers (product_id, supplier_id) VALUES (3, 1);


