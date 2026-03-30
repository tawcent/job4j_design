create table departments (
    id serial primary key,
    name varchar(255)
);

create table employees (
    id serial primary key,
    name varchar(255),
    department_id int references departments(id)
);

insert into departments(name) values
('IT'),
('HR'),
('Sales'),
('Marketing');

insert into employees(name, department_id) values
('Alice', 1),
('Bob', 1),
('Charlie', 2),
('David', 3),
('Eve', null);

select d.name as department, e.name as employee
from departments d
left join employees e
on d.id = e.department_id;

select d.name as department, e.name as employee
from departments d
right join employees e
on d.id = e.department_id;

select d.name as department, e.name as employee
from departments d
full join employees e
on d.id = e.department_id;

SELECT d.name AS department, e.name AS employee
FROM departments d
LEFT JOIN employees e
ON d.id = e.department_id;

SELECT d.name AS department, e.name AS employee
FROM employees e
RIGHT JOIN departments d
ON d.id = e.department_id;

create table teens (
    id serial primary key,
    name varchar(255),
    gender varchar(255)
);

insert into teens(name, gender) values
('Vasya', 'M'),
('Petya', 'M'),
('Masha', 'F'),
('Dasha', 'F');

select t1.name as boy, t2.name as girl
from teens t1
cross join teens t2
where t1.gender = 'M'
and t2.gender = 'F';
