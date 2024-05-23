-- 1. Создать таблицы и заполнить их начальными данными

create table departments
(
    id   serial primary key,
    name varchar(255)
);

create table employees
(
    id       serial primary key,
    name     varchar(255),
    department_id int references departments (id)
);


insert into departments (name) values ('IT');
insert into departments (name) values ('BUH');
insert into departments (name) values ('HR');
insert into departments (name) values ('SALES');
insert into departments (name) values ('MARKETING');

insert into employees (name,department_id) values ('Ivanov',1);
insert into employees (name,department_id) values ('Petrov',1);
insert into employees (name,department_id) values ('Sidorov',2);
insert into employees (name,department_id) values ('Detochkin',3);
insert into employees (name,department_id) values ('Sinichkina',4);

-- 2. Выполнить запросы с left, right, full, cross соединениями

select * from employees e
			left join departments d on e.department_id = d.id;

select * from employees e
			right join departments d on e.department_id = d.id;

select * from employees e
			full join departments d on e.department_id = d.id;

select * from employees e
			cross join departments d;

-- 3. Используя left join найти департаменты, у которых нет работников

select * from departments d
			left join employees e on e.department_id = d.id
	where e.id is null;

-- 4. Используя left и right join написать запросы, которые давали бы одинаковый результат 

select e.name, d.name from employees e 
	right join departments d on e.department_id = d.id;

select e.name, d.name from departments d 
	left join employees e on e.department_id = d.id;



-- 5. Создать таблицу teens с атрибутами name, gender и заполнить ее.

create table teens(
    id serial primary key,
    name varchar(255),
    gender varchar(255);

insert into teens(name, gender) values 
	('Vasya', 'male'), 
	('Masha', 'female'), 
	('Darya', 'female');

-- Используя cross join составить все возможные разнополые пары. Исключите дублирование пар вида Вася-Маша и Маша-Вася.

select * from teens;

select n1.name, '-', n2.name 
	from teens n1 cross join teens n2 
	where n1.name > n2.name and n1.gender != n2.gender;


