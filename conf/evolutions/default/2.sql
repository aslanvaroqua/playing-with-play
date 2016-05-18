# Messages schema

# --- !Ups

CREATE TABLE  (
    id SERIAL PRIMARY KEY,
    user_id INTEGER,
    weight INTEGER,
    height INTEGER,
    age INTEGER,
    hairColor varchar(255)
);

INSERT INTO Bodies (body) Values(1,150,170,23,"Blonde");
INSERT INTO Bodies (body) Values(2,150,170,23,"Black");
# --- !Downs

DROP TABLE Bodies;
