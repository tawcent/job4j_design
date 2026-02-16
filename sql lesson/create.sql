create table roles (
    id SERIAL PRIMARY KEY,
    name TEXT
);

create table rules (
    id SERIAL PRIMARY KEY,
    name TEXT
);

create table roles_rules (
    id SERIAL PRIMARY KEY,
    role_id INT REFERENCES roles(id),
    rule_id INT REFERENCES rules(id)
);

create table users (
    id SERIAL PRIMARY KEY,
    name TEXT,
    role_id INT REFERENCES roles(id)
);

create table states (
    id SERIAL PRIMARY KEY,
    name TEXT
);

create table categories (
    id SERIAL PRIMARY KEY,
    name TEXT
);

create table items (
    id SERIAL PRIMARY KEY,
    name TEXT,
    user_id INT REFERENCES users(id),
    state_id INT REFERENCES states(id),
    category_id INT REFERENCES categories(id)
);

create table comments (
    id SERIAL PRIMARY KEY,
    text TEXT,
    item_id INT REFERENCES items(id)
);

create table attachs (
    id SERIAL PRIMARY KEY,
    file_name TEXT,
    item_id INT REFERENCES items(id)
);
