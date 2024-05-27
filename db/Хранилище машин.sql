
create table car_bodies
(
    id   serial primary key,
    name varchar(255)
);

create table car_engines
(
    id   serial primary key,
    name varchar(255)
);

create table car_transmissions
(
    id   serial primary key,
    name varchar(255)
);

create table cars
(
    id   serial primary key,
    name varchar(255),
	body_id int references car_bodies (id),
	engine_id int references car_engines (id), 
	transmission_id int references car_transmissions (id)
);

insert into car_bodies (name) values ('Пикап'), ('Хэчбек'), ('Седан'), ('Минивен');
insert into car_engines (name) values ('Бензиновый'), ('Дизель'), ('Электро'), ('Гибрид');
insert into car_transmissions (name) values ('АКПП'), ('МКПП'), ('Вариатор'), ('Робот');

insert into cars (name, body_id, engine_id, transmission_id) values ('Toyota', 1, 1, 1);
insert into cars (name, body_id, engine_id, transmission_id) values ('Honda', 2, 2, 2);
insert into cars (name, body_id, engine_id, transmission_id) values ('Nissan', 3, 3, 3);
insert into cars (name, body_id, engine_id, transmission_id) values ('Subaru', 3,null, 3);


select c.name as "car_name", cb.name as "body_name", ce.name as "engine_name", ct.name as "transmission_name"
from cars as c
		left join car_bodies as cb on c.body_id = cb.id
		left join car_engines as ce on c.engine_id = ce.id
		left join car_transmissions as ct on c.transmission_id = ct.id;


select cb.name as "body_name"
from cars c
		right join car_bodies as cb on c.body_id = cb.id
		where c.body_id is null;


select ce.name as "engine_name"
from cars c
		right join car_engines as ce on c.engine_id = ce.id
		where c.engine_id is null;

select ct.name as "transmission_name"
from cars c
		right join car_transmissions as ct on c.transmission_id = ct.id
		where c.transmission_id is null;



