CREATE DATABASE IF NOT EXISTS sqldb;
USE sqldb;

CREATE TABLE IF NOT EXISTS weather
(
    id   INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    type VARCHAR(255) NOT NULL
);

INSERT INTO weather (name, type)
VALUES ('mati', 'sunny'),
       ('mati2', 'cloudy');