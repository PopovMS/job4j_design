create table snils(
    id serial primary key,
    number int
);

create table patient(
    id serial primary key,
    name varchar(255),
  	address varchar(255),
  	snils_id int references snils(id)
);



insert into patient(name, address) values ('Petrov','Lenina 1-10',1);
insert into patient(name, address) values ('Sidorov','Lenina 50-10',2);
insert into patient(name, address) values ('Ivanod','Mira 10-100',3);
insert into patient(name, address) values ('Sinichkina','Mira 20-10');

insert into snils(number) values ('118304050');
insert into snils(number) values ('118304060');
insert into snils(number) values ('118304070');

select pp.name, s.number
from patient as pp join snils as s on pp.snils_id = s.id;

select pp.name as Имя, s.number as Снилс
from patient as pp join snils as s on pp.snils_id = s.id;

select pp.name as "Имя владельца", s.number Номер
from patient pp join snils s on pp.snils_id = s.id;