insert into devices (name,price) values ('TV', 20000);
insert into devices (name,price) values ('Microwave', 7000);
insert into devices (name,price) values ('Xbox', 50000);
insert into devices (name,price) values ('PC', 100000);
insert into devices (name,price) values ('Iphone', 150000 );

insert into people (name) values ('Ivanov');
insert into people (name) values ('Petrov');
insert into people (name) values ('Sidorov');
insert into people (name) values ('Detochkin');
insert into people (name) values ('Sinichkina');

insert into devices_people (people_id,device_id) values(1,1),(1,3),(1,4);
insert into devices_people (people_id,device_id) values(2,4),(2,1);
insert into devices_people (people_id,device_id) values(3,1);
insert into devices_people (people_id,device_id) values(4,4),(4,5);
insert into devices_people (people_id,device_id) values(5,2),(5,5);