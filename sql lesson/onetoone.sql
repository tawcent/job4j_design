create table app_user(
    id serial primary key,
    username varchar(255)
);

create table profile(
    id serial primary key,
    bio text,
    app_user_id int references app_user(id) unique
);

insert into app_user(username) values
    ('Alice'),
    ('Sasha');

insert into profile(bio, app_user_id) values
    ('I love coding', 1),
    ('I love music', 2);