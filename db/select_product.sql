

-- 1. Написать запрос получение всех продуктов с типом "СЫР"

select * 
	from product as p
		join type as t
			on p.type_id = t.id
where t.name = 'Сыр';

-- 2. Написать запрос получения всех продуктов, у кого в имени есть слово "мороженое"

select * from product
	where name LIKE '%Мороженное%';

-- 3. Написать запрос, который выводит все продукты, срок годности которых уже истек

select * from product where expired_date < CURRENT_DATE;

-- 4. Написать запрос, который выводит самый дорогой продукт. 

select p.name, max(p.price)
	from product as p
		join type as t
			on p.type_id = t.id
			--where p.price = 120;
			where p.price = (select max(price) from product)
group by p.name;

-- 5. Написать запрос, который выводит для каждого типа количество продуктов к нему принадлежащих. В виде имя_типа, количество

select t.name, COUNT(p.name)
from product as p
         join type t
			on p.type_id = t.id
group by t.name;

-- 6. Написать запрос получение всех продуктов с типом "СЫР" и "МОЛОКО"
select * 
	from product as p
		join type as t
			on p.type_id = t.id
where t.name = 'Сыр' OR t.name = 'Молоко';

-- 7. Написать запрос, который выводит тип продуктов, которых осталось меньше 10 штук. Под количеством подразумевается количество

select t.name, COUNT(p.name)
from product as p
         join type t
			on p.type_id = t.id
group by t.name
having COUNT(p.name) < 10;


-- 8. Вывести все продукты и их тип.

select * 
	from product as p
		join type as t
			on p.type_id = t.id;










