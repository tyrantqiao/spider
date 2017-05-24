drop table if EXISTS user;

create table user (
	id VARCHAR(10),
	username varchar(20) unique not null,
	password varchar(20) not null,
	email varchar(30) not null
);