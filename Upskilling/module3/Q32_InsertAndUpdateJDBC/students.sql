CREATE DATABASE studentdb;

USE studentdb;

CREATE TABLE students(
    id INT PRIMARY KEY,
    name VARCHAR(50),
    age INT
);

INSERT INTO students VALUES
(1,'Rahul',20),
(2,'Aman',21),
(3,'Neha',19);