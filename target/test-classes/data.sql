CREATE TABLE IF NOT EXISTS customer (
    id VARCHAR(255) PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    street VARCHAR(255) NOT NULL,
    number INT NOT NULL,
    zip VARCHAR(20) NOT NULL,
    city VARCHAR(255),
    active BOOLEAN NOT NULL,
    rewards DECIMAL(10,2) NOT NULL
);

DELETE FROM customer;

INSERT INTO customer (id, name, street, number, zip, city, active, rewards)
VALUES ('1', 'Vinicius', 'Rua XPTO', 123, '01010-000', 'São Paulo', true, 150.50);
