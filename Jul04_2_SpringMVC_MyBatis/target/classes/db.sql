create table jul04_student(
	s_no number(3) primary key,
	s_name varchar2(10 char) not null,
	s_nickname varchar2(10 char) not null
);

create sequence jul04_student_seq;

select * from jul04_student;

create table jul04_test(
	t_title varchar2(20 char) primary key,
	t_when date not null
);

select * from jul04_test;
select * from jul04_student;



drop table jul04_test;
drop table jul04_student;
drop sequence jul04_student_seq;

