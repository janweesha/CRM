create database if not exists crm;
use crm;

drop table if exists dept;
create table if not exists dept(
	d_id int(20) primary key auto_increment,
	d_name varchar(30) not null unique,
	d_manager varchar(20) not null,
	d_work varchar(30) not null,
	d_remark varchar(100)
);

insert into dept(d_name,d_manager,d_work) values('财务','张三','财务管理');