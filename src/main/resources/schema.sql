CREATE TABLE IF NOT EXISTS Users (
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(255) UNIQUE,
    password VARCHAR(255),
    email VARCHAR(255),
    role ENUM ('admin', 'user')
);

CREATE TABLE IF NOT EXISTS Products (
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    description TEXT,
    price DECIMAL(12,0),
    delivery_date DATE,
    product_class ENUM(' ','食品', '嗜好品', '飲料水', 'その他'),
    supplier_name VARCHAR(255),
    quantity INT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS Suppliers (
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    address VARCHAR(255),
    email VARCHAR(255),
    phone VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS Product_Suppliers (
    product_id INT NOT NULL,
    supplier_id INT NOT NULL,
    PRIMARY KEY (product_id, supplier_id),
    FOREIGN KEY (product_id) REFERENCES Products(id),
    FOREIGN KEY (supplier_id) REFERENCES Suppliers(id)
);
