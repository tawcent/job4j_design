CREATE TABLE shop (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    price DECIMAL(10,2) NOT NULL CHECK (price >= 0),
    stock BOOLEAN NOT NULL DEFAULT TRUE
);

INSERT INTO shop (title, price, stock)
VALUES ('Choko candy', 26.50, true);

SELECT * FROM shop;
UPDATE shop
set
    price = 28.90,
    stock = false
    where title = 'Choko candy';
select * from shop;
delete from shop
where title = 'Choko candy';
select * from shop;