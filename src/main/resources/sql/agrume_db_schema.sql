
drop table if exists exploite;
drop table if exists salle;
drop table if exists batiment;
drop table if exists campus;
drop table if exists composante;

drop table if exists reservation;
drop table if exists formation;
drop table if exists departement;


create table campus(
	nom varchar(63), 
	constraint pk_campus primary key(nom),
	ville varchar(63)
);

create table batiment(
	id varchar(15), 
	constraint pk_batiment primary key(id), 
	annee integer, 
	campus varchar(63), 
	constraint fk_batiment__campus foreign key (campus) references campus(nom) on delete cascade
);

create table salle(
	numero varchar(15), 
	constraint pk_salle primary key(numero), 
	capacite integer, 
	type_ varchar(15), 
	acces varchar(3), 
	etage varchar(3), 
	batiment varchar(15), 
	constraint fk_salle__batiment foreign key(batiment) references batiment(id) on delete cascade, 
	constraint domain_salle__type check (type_ in ('amphi','sc','td','tp','numerique'))
);

create table composante(
	acronyme varchar(15), 
	constraint pk_composante primary key (acronyme), 
	nom varchar(63), 
	responsable varchar(31)
);

create table exploite(
	composante varchar(15), 
	constraint fk_exploite__composante foreign key(composante) references composante(acronyme) on delete cascade, 
	batiment varchar(15), 
	constraint fk_exploite__batiment foreign key(batiment) references batiment(id) on delete cascade, 
	constraint pk_exploite primary key(composante, batiment)
);


-- create table departement(
-- );

-- create table formation(
-- );

-- create table reservation(
-- );

commit;