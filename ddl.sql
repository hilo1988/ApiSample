CREATE DATABASE api_sample CHARACTER SET UTF8;

DROP TABLE IF EXISTS person;

CREATE TABLE person (
id BIGINT NOT NULL AUTO_INCREMENT,
first_name VARCHAR(64) NOT NULL,
last_name VARCHAR(64) NOT NULL,
age INT NOT NULL,
PRIMARY KEY(id)
);


SELECT *
FROM person
WHERE (first_name LIKE '%a%' OR last_name LIKE '%a')
      AND age >= 1
      AND age <= 10