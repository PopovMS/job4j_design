create table drugs(
     id serial primary key,
     name varchar(255)
 );



create table patient_drugs (
	id serial primary key,
	patient_id int references patient(id),
	drugs_id int references drugs(id)
);
