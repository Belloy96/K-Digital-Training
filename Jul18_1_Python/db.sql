create table jul18_coffee(
	c_no number(3) primary key,
	c_name varchar2(10 char) not null,
	c_price number(5) not null,
	c_bean varchar2(10 char) not null
)

select * from jul18_coffee;

create sequence jul18_coffee_seq;

drop table jul18_coffee;
drop sequence jul18_coffe_seq;



