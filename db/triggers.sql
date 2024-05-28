
create table products
(
    id       serial primary key,
    name     varchar(50),
    producer varchar(50),
    count    integer default 0,
    price    integer
);


create
or replace function discount()
    returns trigger as
$$
    BEGIN
        update products
        set price = price - price * 0.2
        where count <= 5
        AND id = new.id;
        return NEW;
    END;
$$
LANGUAGE 'plpgsql';

create trigger discount_trigger
    after insert
    on products
    for each row
    execute procedure discount();

insert into products (name, producer, count, price)
VALUES ('product_3', 'producer_3', 8, 115);

insert into products (name, producer, count, price)
VALUES ('product_1', 'producer_1', 3, 50);

insert into products (name, producer, count, price)
VALUES ('product_1', 'producer_1', 3, 50);

create
or replace function tax()
    returns trigger as
$$
    BEGIN
        update products
        set price = price - price * 0.2
        where id = (select id from inserted)
        and count <= 5;
        return new;
    END;
$$
LANGUAGE 'plpgsql';

create trigger tax_trigger
    after insert
    on products
    referencing new table as
                    inserted
    for each statement
    execute procedure tax();

-- Задание 1 --
create
or replace function NDS()
    returns trigger as
$$
    BEGIN
        update products
        set price = price * 1.2;
        where id = (select id from inserted);
        return new;
    END;
$$
LANGUAGE 'plpgsql';

create trigger NDS_trigger
    after insert
    on products
    referencing new table as
                    inserted
    for each statement
    execute procedure nds();

-- Задание 2 --

create
or replace function NDS_row()
    returns trigger as
$$
    BEGIN
        NEW.price = NEW.price * 1.2;
        return NEW;
    END;
$$
LANGUAGE 'plpgsql';


create trigger discount_trigger
    before insert
    on products
    for each row
    execute procedure nds_row();

-- Задание 3 --

create table history_of_price
(
    id    serial primary key,
    name  varchar(50),
    price integer,
    date  timestamp
);

create
or replace function log_to_history()
	returns trigger as 
$$
begin
    insert into history_of_price (name, price, date)
    values (NEW.name, NEW.price, current_timestamp);
    return new;
end;
$$ 
language plpgsql;

create trigger add_log_history_trigger
	after insert
    on products
for each row
execute function log_to_history();

insert into products (name, producer, count, price) VALUES ('product_1', 'producer_1', 3, 100);
select * from history_of_price
