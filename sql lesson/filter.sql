TRUNCATE TABLE product RESTART IDENTITY CASCADE;
TRUNCATE TABLE type RESTART IDENTITY CASCADE;
create table type (
    id serial primary key,
    name varchar(255)
);

create table product (
    id serial primary key,
    name varchar(255),
    type_id int references type(id),
    expired_date date,
    price float
);

insert into type(id,name) values
(1,'Сыр'),
(2,'Молоко'),
(3,'Мясо'),
(4,'Овощи'),
(5,'Фрукты'),
(6,'Мороженое');

insert into product(name, type_id, expired_date, price) values
('Сыр моцарелла', 1, '2026-01-15', 200),
('Сыр пармезан', 1, '2026-04-01', 500),
('Молоко 1л', 2, '2026-03-05', 80),
('Молоко 2л', 2, '2026-03-10', 150),
('Мясо Говядина', 3, '2026-03-12', 700),
('Мясо Свинина', 3, '2026-03-10', 650),
('Мороженое Ваниль', 6, '2026-06-01', 120),
('Мороженое Шоколад', 6, '2026-06-01', 130),
('Яблоки', 5, '2026-03-20', 50),
('Морковь', 4, '2026-03-18', 40),
('Сыр Плавленый', 1, '2026-03-07', 180),
('Молоко 0.5л', 2, '2026-03-03', 70);

select p.*
from product p
join type t on p.type_id = t.id
where t.name = 'Сыр';

select *
from product
where name ilike '%Мороженое%';

select *
from product
where expired_date < current_date;

select *
from product
where price = (select max(price) from product);

select t.name as тип_продукта, count(p.id) as количество
from type t
left join product p on p.type_id = t.id
group by t.name;

select p.*
from product p
join type t on p.type_id = t.id
where t.name in ('СЫР', 'МОЛОКО');

select t.name as тип_продукта, count (p.id) as количество
from type t
join product p on p.type_id = t.id
group by t.name
having count(p.id) < 10;

select p.*, t.name as тип_продукта
from product p
join type t on p.type_id = t.id;