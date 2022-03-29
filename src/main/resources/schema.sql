create table KnowledgePackage (
	id bigint auto_increment,
	title varchar(250),
	description varchar(2000),
	date varchar(10),
	primary key (id) 
);


create table KnowledgePackageSet (
	id bigint,
	title varchar(250),
	kpacId bigint,
	foreign key (kpacId) references KnowledgePackage(id) on delete cascade,
	constraint UC unique (id,kpacId)
);