create table departaments (
    id serial primary key,
    name varchar(255) not null
);

create table employyes(
    id serial primary key,
    name varchar(255) not null,
    salary int,
    departament_id int references departaments(id)
);

insert into departaments(name) values
('IT'),
('HR'),
('Sales');

insert into employyes(name, salary, departament_id) values
('Ivan', 1500, 1),
('Boris', 1200, 1),
('Petr', 1000, 2),
('Anna', 1100, 3);

select e.name as employye,
       d.name as departament
from employyes e
inner join departaments d
    on e.departament_id = d.id;

select e.name,
       e.salary,
       d.name as departament
from employyes e
inner join departaments d
    on e.departament_id = d.id
where e.salary > 1110;

select e.name,
       e.salary
from employyes e
inner join departaments d
    on e.departament_id = d.id
where d.name = 'IT';