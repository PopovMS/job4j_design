create table patient(
    id serial primary key,
    name varchar(255),
  	address varchar(255),
  	area_id int references area(id),
);

create table snils(
    id serial primary key,
    number int
);

insert into patient(name, address) values ('Petrov','Lenina 1-10');
insert into snils(number) values ('118304050');

select * from patient;
select * from snils;
