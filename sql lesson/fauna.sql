CREATE TABLE fauna
(
    id              SERIAL PRIMARY KEY,
    name            TEXT,
    avg_age         INT,
    discovery_date  DATE
);

INSERT INTO fauna(name, avg_age, discovery_date) values
('big fish', 15000, '1900-01-01'),
('small fish', 12000, NULL),
('cat', 5000, '1800-01-01'),
('tiger', 20000, '1940-01-01'),
('unknown', 18000, NULL);

SELECT * from fauna
WHERE name LIKE '%fish%';

SELECT * FROM fauna
WHERE avg_age BETWEEN 10000 AND 20000;

SELECT * FROM fauna
discovery_date IS NULL;

SELECT * FROM fauna
WHERE discovery_date < '1950-01-01';