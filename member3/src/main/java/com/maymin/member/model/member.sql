CREATE TABLE member(
	id number not null,
	email varchar2(50) not null PRIMARY KEY,
	name varchar2(20) not null,
	password varchar2(10) not null,
	registerDate date not null
);

drop table member;

CREATE SEQUENCE seq_id;

select * from MEMBER;