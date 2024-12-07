-- Создание таблицы пользователей
CREATE TABLE userEntities (
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    phone VARCHAR(15),
    role VARCHAR(20) DEFAULT 'userEntity',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Создание таблицы товаров
CREATE TABLE productEntities (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description TEXT,
    price DECIMAL(10, 2) NOT NULL CHECK (price >= 0),
    quantity INT NOT NULL CHECK (quantity >= 0),
    categoryEntity VARCHAR(50),
    image_url TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Создание таблицы заказов
CREATE TABLE orderEntities (
    id SERIAL PRIMARY KEY,
    user_id INT REFERENCES userEntities(id) ON DELETE CASCADE,
    total_price DECIMAL(10, 2) NOT NULL CHECK (total_price >= 0),
    address TEXT NOT NULL,
    comment TEXT,
    status VARCHAR(50) DEFAULT 'в обработке',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Создание таблицы товаров в заказах
CREATE TABLE order_items (
    id SERIAL PRIMARY KEY,
    order_id INT REFERENCES orderEntities(id) ON DELETE CASCADE,
    product_id INT REFERENCES productEntities(id) ON DELETE CASCADE,
    quantity INT NOT NULL CHECK (quantity > 0),
    price DECIMAL(10, 2) NOT NULL CHECK (price >= 0)
);

-- Создание таблицы корзины
CREATE TABLE cart (
    id SERIAL PRIMARY KEY,
    user_id INT REFERENCES userEntities(id) ON DELETE CASCADE,
    product_id INT REFERENCES productEntities(id) ON DELETE CASCADE,
    quantity INT NOT NULL CHECK (quantity > 0)
);

CREATE TABLE roles (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE user_roles (
    user_id INT,
    role_id INT,
    PRIMARY KEY (user_id, role_id),
    FOREIGN KEY (user_id) REFERENCES userEntities(id) ON DELETE CASCADE,
    FOREIGN KEY (role_id) REFERENCES roles(id) ON DELETE CASCADE
);

INSERT INTO roles (name) VALUES ('USER'), ('ADMIN'), ('MANGER');

CREATE TABLE categories (
                            id SERIAL PRIMARY KEY,
                            name VARCHAR(50) NOT NULL UNIQUE
);
CREATE TABLE productEntities (
                          id SERIAL PRIMARY KEY,
                          name VARCHAR(100) NOT NULL,
                          description TEXT,
                          price DECIMAL(10, 2) NOT NULL CHECK (price >= 0),
                          quantity INT NOT NULL CHECK (quantity >= 0),
                          category_id int,
                          image_url TEXT,
                          created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                          CONSTRAINT fk_category FOREIGN KEY (category_id) REFERENCES categories(id) ON DELETE SET NULL
);

CREATE TABLE cart (
                      id SERIAL PRIMARY KEY,
                      user_id INT REFERENCES userEntities(id) ON DELETE CASCADE,
                      product_id INT REFERENCES productEntities(id) ON DELETE CASCADE,
                      quantity INT NOT NULL CHECK (quantity > 0),
                      created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
CREATE TABLE order_items (
                             id SERIAL PRIMARY KEY,
                             order_id INT REFERENCES orderEntities(id) ON DELETE CASCADE,
                             product_id INT REFERENCES productEntities(id) ON DELETE CASCADE,
                             quantity INT NOT NULL CHECK (quantity > 0),
                             price DECIMAL(10, 2) NOT NULL CHECK (price >= 0)
);

INSERT INTO categories (name) VALUES
                                  ('Electronics'),
                                  ('Clothing'),
                                  ('Books'),
                                  ('Furniture'),
                                  ('Toys');

INSERT INTO productEntities (name, description, price, quantity, category_id, image_url)
VALUES
    ('Product 1', 'Description for productEntity 1', 10.99, 100, 1, 'image1.jpg'),
    ('Product 2', 'Description for productEntity 2', 20.49, 200, 2, 'image2.jpg'),
    ('Product 3', 'Description for productEntity 3', 15.75, 150, 3, 'image3.jpg'),
    ('Product 4', 'Description for productEntity 4', 5.99, 50, 4, 'image4.jpg'),
    ('Product 5', 'Description for productEntity 5', 30.00, 300, 5, 'image5.jpg'),
    ('Product 6', 'Description for productEntity 6', 7.99, 120, 1, 'image6.jpg'),
    ('Product 7', 'Description for productEntity 7', 18.49, 75, 2, 'image7.jpg'),
    ('Product 8', 'Description for productEntity 8', 12.99, 80, 3, 'image8.jpg'),
    ('Product 9', 'Description for productEntity 9', 25.99, 60, 4, 'image9.jpg'),
    ('Product 10', 'Description for productEntity 10', 22.49, 250, 5, 'image10.jpg');
INSERT INTO cart (user_id, product_id, quantity)
VALUES
    (1, 1, 2),
    (1, 2, 1),
    (2, 3, 4),
    (2, 5, 2),
    (3, 1, 3),
    (3, 4, 1);
INSERT INTO order_items (order_id, product_id, quantity, price)
VALUES
    (1, 1, 2, 10.99),  -- заказ 1, товар 1, 2 штуки по цене 10.99
    (1, 2, 1, 20.49),  -- заказ 1, товар 2, 1 штука по цене 20.49
    (2, 3, 4, 15.75),  -- заказ 2, товар 3, 4 штуки по цене 15.75
    (2, 5, 2, 30.00),  -- заказ 2, товар 5, 2 штуки по цене 30.00
    (3, 1, 3, 10.99),  -- заказ 3, товар 1, 3 штуки по цене 10.99
    (3, 4, 1, 5.99);   -- заказ 3, товар 4, 1 штука по цене 5.99

