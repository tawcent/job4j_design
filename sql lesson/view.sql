create table customers (
    id serial primary key,
    name varchar(255)
);
create table products (
    id serial primary key,
    name varchar(255),
    price numeric(10, 2)
);

create table orders (
    id serial primary key,
    customer_id int references customers(id),
    created_at date
);

create table orders_time (
    id serial primary  key,
    order_id int references orders(id),
    priduct_id int references products(id),
    quantity int
);

INSERT INTO customers(name) VALUES
('Alice'),
('Bob');

INSERT INTO products(name, price) VALUES
('Laptop', 1000),
('Mouse', 50),
('Keyboard', 100);

INSERT INTO orders(customer_id, created_at) VALUES
(1, '2024-01-01'),
(1, '2024-01-02'),
(2, '2024-01-03');

CREATE VIEW order_totals AS
SELECT
    o.id AS order_id,
    o.customer_id,
    SUM(p.price * oi.quantity) AS total
FROM orders o
JOIN order_items oi ON o.id = oi.order_id
JOIN products p ON oi.product_id = p.id
GROUP BY o.id, o.customer_id;

CREATE VIEW customer_stats AS
SELECT
    c.name AS customer_name,
    COUNT(ot.order_id) AS orders_count,
    SUM(ot.total) AS total_amount,
    AVG(ot.total) AS avg_order
FROM customers c
JOIN order_totals ot ON c.id = ot.customer_id
GROUP BY c.name;