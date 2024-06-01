
CREATE TABLE customers
(
    id         serial primary key,
    first_name text,
    last_name  text,
    age        int,
    country    text
);


insert into customers (first_name, last_name, age, country) values ('Ivan', 'Ivanov', 40, 'Russia');
insert into customers (first_name, last_name, age, country) values ('Orlando', 'Bloom', 47, 'GB');
insert into customers (first_name, last_name, age, country) values ('Sheldon', 'Cooper', 15, 'USA');
insert into customers (first_name, last_name, age, country) values ('Milosh', 'Bikovich', 36, 'Sebia');


select * from customers
where age = (select min(age) from customers);

CREATE TABLE orders_of_customers
(
    id          serial primary key,
    amount      int,
    customer_id int references customers (id)
);

insert into orders_of_customers (amount, customer_id) values (1,1);
insert into orders_of_customers (amount, customer_id) values (2,2);
insert into orders_of_customers (amount, customer_id) values (3,4);

select * from customers
where customers.id not in (select customer_id from orders_of_customers);

