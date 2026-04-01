create table car_bodies (
    id serial primary key,
    name varchar(255)
);

create table car_engines (
    id serial primary key,
    name varchar(255)
);

create table car_transmissions (
    id serial primary key,
    name varchar(255)
);

create table cars (
    id serial primary key,
    name varchar(255),
    body_id int references car_bodies(id),
    engine_id int references car_engines(id),
    transmission_id int references car_transmissions(id)
);

insert into car_bodies(name) values
('Sedan'),
('Hatchback'),
('SUV'),
('Pickup');

insert into car_engines(name) values
('Petrol'),
('Diesel'),
('Electrick'),
('Hybrid');

insert into car_transmissions(name) values
('Manual'),
('Automatic'),
('CVT'),
('Robot');

insert into cars(name, body_id, engine_id, transmission_id) values
('Toyota Camry', 1, 1, 2),
('VW Golf', 2, 1, 1),
('Tesla Model 3', 1, 3, NULL),
('BMW X5', 3, 2, 2),
('Old Car', null, null, null);

select
    c.id,
    c.name as car_name,
    b.name as body_name,
    e.name as engine_name,
    t.name as transmission_name
from cars c
left join car_bodies b on c.body_id = b.id
left join car_engines e on c.engine_id = e.id
left join car_transmissions t on c.transmission_id = t.id;

select b.name
from car_bodies b
left join cars c on b.id = c.body_id
where c.id is null;

select e.name
from car_engines e
left join cars c on e.id = c.engine_id
where c.id is null;

select t.name
from car_transmissions t
left join cars c on t.id = c.transmission_id
where c.id is null;