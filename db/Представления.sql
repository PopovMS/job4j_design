
create table car_bodies
(
    id   serial primary key,
    name varchar(255)
);
insert into car_bodies (name) values ('Пикап'), ('Хэчбек'), ('Седан'), ('Минивен');

create table car_engines
(
    id   serial primary key,
    name varchar(255)
);
insert into car_engines (name) values ('Бензиновый'), ('Дизель'), ('Электро'), ('Гибрид');


create table car_transmissions
(
    id   serial primary key,
    name varchar(255)
);
insert into car_transmissions (name) values ('АКПП'), ('МКПП'), ('Вариатор'), ('Робот');

create table cars
(
    id   serial primary key,
    name varchar(255),
	body_id int references car_bodies (id),
	engine_id int references car_engines (id), 
	transmission_id int references car_transmissions (id)
);


insert into cars (name, body_id, engine_id, transmission_id) values ('Toyota', 1, 1, 1);
insert into cars (name, body_id, engine_id, transmission_id) values ('Honda', 2, 2, 2);
insert into cars (name, body_id, engine_id, transmission_id) values ('Nissan', 3, 3, 3);
insert into cars (name, body_id, engine_id, transmission_id) values ('Subaru', 3,null, 3);



create table clients
(
	id   serial primary key,
    name varchar(255)	
);

insert into clients (name) values ('Ivanov');
insert into clients (name) values ('Petrov');
insert into clients (name) values ('Sidorov');
insert into clients (name) values ('Detochkin');
insert into clients (name) values ('Sinichkina');

create table orders
(
    id serial primary key,
    active boolean default true,
    cars_id int references cars (id),
    client_id int references clients (id)
);

insert into orders (cars_id, client_id)
values (1, 1);
insert into orders (cars_id, client_id)
values (3, 2);
insert into orders (cars_id, client_id)
values (4, 3);
insert into orders (cars_id, client_id)
values (2, 4);

	select cl.name as "Client_name", ct.name as "transmission_name", count(ct.name)
from clients as cl
		join orders as o on cl.id = o.client_id
		join cars as c on o.cars_id = cl.id
		join car_transmissions as ct on c.transmission_id = ct.id
	group by (cl.name, ct.name)




create view show_clients_transmissions 
as
select  cl.name as Client_name, 
		ct.name as transmission_name
from clients as cl
		join orders as o on cl.id = o.client_id
		join cars as c on o.cars_id = c.id
		join car_transmissions as ct on c.transmission_id = ct.id
		group by (cl.name, ct.name);

select * from show_clients_transmissions;



