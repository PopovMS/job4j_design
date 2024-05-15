create table retrocars (
    id serial primary key, 
    name varchar(255),
	model text,
	years integer
);
insert into retrocars (name, model, years) values ('Ford', 'Mustang', '1969');
select * from retrocars;
