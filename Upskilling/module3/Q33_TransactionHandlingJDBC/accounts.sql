CREATE DATABASE bankdb;

USE bankdb;

CREATE TABLE accounts (
    account_id INT PRIMARY KEY,
    account_holder VARCHAR(50),
    balance DOUBLE
);

INSERT INTO accounts VALUES
(101, 'Rahul', 10000),
(102, 'Priya', 5000);