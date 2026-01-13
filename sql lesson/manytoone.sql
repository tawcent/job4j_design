create table category(
    id serial primary key,
    name varchar(255)
);

create table product(
    id serial primary key,
    name varchar(255),
    price numeric(10, 2),
    category_id int references category(id)
);

insert into category(name) values
    ('Electronics'),
    ('Books')

insert into product(name, price, category_id) values
    ('Laptop', 1500, 1),
    ('Phone', 950, 1),
    ('Kitchen book', 35, 2);

