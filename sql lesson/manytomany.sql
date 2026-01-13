create table author(
    id serial primary key,
    name varchar(255)
);

create table book(
    id serial primary key,
    title varchar(255)
);

create table author_book(
    author_id int references author(id),
    book_id int references book(id),
    primary key(author_id, book_id)
);

insert into author(name) values
    ('Tolstoy'),
    ('Dostoevsky'),
    ('Pushkin');

insert into book(title) values
    ('War and Peace'),
    ('Crime and Punishment'),
    ('Eugene Onegin');

insert into author_book(author_id, book_id) values
    (1,1),
    (2,2),
    (3,3),
    (3,2);