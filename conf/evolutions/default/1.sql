# Person schema

# !Ups
CREATE TABLE person (
    id int(20) AUTO_INCREMENT,
    name varchar(255),
    lastName varchar(255),
    phone1 varchar(255),
    phone2 varchar(255),
    PRIMARY KEY (id)
);

# !Downs
DROP TABLE person;

