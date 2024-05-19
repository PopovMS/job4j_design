insert into roles (name) values ('admin');

insert into users (name, role_id) values ('admin', 1);

insert into rules (name) values ('FullAccess');

insert into roles_rules (role_id, rule_id) values (1, 1);

insert into states (name) values ('active');

insert into categories (name) values ('Hardware');

insert into items (name, user_id, category_id, state_id) values ('item1', 1, 1, 1);

insert into comments (name, item_id) values ('comment1', 1);

insert into attachs (name, item_id) values ('attach1', 1);