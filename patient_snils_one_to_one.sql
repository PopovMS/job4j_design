create table patient_snils (
	id serial primary key,
	patient_id int references patient(id) unique,
	snils_id int references snils(id) unique
);