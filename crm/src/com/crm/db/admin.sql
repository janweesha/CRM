drop database if exists crm;
create database if not exists crm;
use crm;

drop table if exists admin;
create table if not exists admin(
	a_id int(5) primary key auto_increment,
	a_name varchar(10) not null unique,
	a_pwd varchar(50) not null
);

insert into admin(a_name,a_pwd) values('janwee','123456');