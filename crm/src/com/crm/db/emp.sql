create database if not exists crm;
use crm;

drop table if exists emp;
create table if not exists emp(
	e_id int(10) primary key auto_increment,
	e_name varchar(20) not null unique,
	e_pwd varchar(50) not null,
	e_deptid int(10) not null,
	e_courseid int(10),
	e_gender int(1),
	e_birth date,
	e_empdate date,
	e_salary double(8,2),
	e_status int(1),
	e_work varchar(20),
	e_remark varchar(100),
	e_tell varchar(30)
);

insert into emp(e_name,e_pwd,e_deptid) values('赵四','123456','1');