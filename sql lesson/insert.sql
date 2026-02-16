INSERT INTO roles(name) VALUES ('admin'), ('user');

INSERT INTO rules(name) VALUES ('read'), ('write');

INSERT INTO roles_rules(rule_id, role_id) values
    (1,1),
    (1,2),
    (2,1);

INSERT INTO users(name, role_id) values
    ('Ivan', 1),
    ('Petr', 2);

INSERT INTO states(name) VALUES
('new'),
('in progress'),
('done');

INSERT INTO categories(name) VALUES
('bug'),
('task');

INSERT INTO items(name, user_id, state_id, category_id) VALUES
('Fix login', 1, 1, 1),
('Add feature', 2, 2, 2);

INSERT INTO comments(text, item_id) VALUES
('need fix fast', 1);

INSERT INTO attachs(file_name, item_id) VALUES
('screenshot.png', 1);

