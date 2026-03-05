create table devices
(
    id serial primary key,
    name varchar(255),
    price float
);

create table people
(
    id serial primary key,
    name varchar(255)
);

create table devices_people
(
    id serial primary key,
    devices_id int references devices(id),
    people_id int references people(id)
);

insert into devices(name, price) values ('PC', 100000), ('Phone', 60000), ('Vr', 75000), ('Mouse', 2000), ('Guitar', 20000), ('Ipad', 35000);
insert into people(name) values ('Grisha'), ('Elena'), ('Ruslan');
insert into devices_people(devices_id, people_id) values
(1,3),(2,2),(3,1),(4,1),(5,1),(6,2);

select avg(price) from devices;

select p.name, avg(d.price)
from devices_people dp
join people p on dp.people_id = p.id
join devices d on dp.devices_id = d.id
group by p.name;

select p.name, avg(d.price)
from devices_people dp
join people p on dp.people_id = p.id
join devices d on dp.devices_id = d.id
group by p.name
having avg(d.price) > 33333;