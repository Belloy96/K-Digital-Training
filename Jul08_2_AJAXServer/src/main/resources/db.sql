create table jul08_fruit(
	f_name varchar2(10 char) primary key,
	f_price number(5) not null
);

insert into  JUL08_FRUIT values('귤', 2800);
insert into  JUL08_FRUIT values('망고', 5500);
insert into  JUL08_FRUIT values('레몬', 8000);
insert into  JUL08_FRUIT values('수박', 13000);
insert into  JUL08_FRUIT values('사과', 3200);
insert into  JUL08_FRUIT values('샤인머스캣', 10800);

select * from JUL08_FRUIT;

drop table jul08_fruit;


