create table jul19_weather (
	wt_no number(3) primary key,
	wt_hour varchar2(10 char) not null,
	wt_temp varchar2(10 char) not null,
	wt_tmx varchar2(10 char) not null,
	wt_wfKor varchar2(10 char) not null,
	wt_wdKor varchar2(10 char) not null
);

create sequence jul19_weather_seq;

drop table jul19_weather cascade constraint purge;
drop sequence jul19_weather_seq;

select * from jul19_weather;

--------------------------------------------------------
create table jul19_airs (
	sa_no number(3) primary key,
	sa_MSRSTE_NM varchar2(10 char) not null,
	sa_PM10 number(4, 1) not null,
	sa_PM25 number(4, 1) not null
);

create sequence jul19_airs_seq;
select * from jul19_airs;
drop table jul19_airs cascade constraint purge;

--------------------------------------------------------
-- (table간 제약조건 고려 X / 시험 점수는 정수로 처리)
-- 학생 : 이름, 생일, 몇 강의장, 중간, 기말(
create table jul19_student (
	s_no number(3) primary key,
	s_name varchar2(10 char) not null,
	s_birthday date not null,
	s_classroom varchar2(10 char) not null,
	s_mid number(3) not null,
	s_fin number(3) not null
);

create sequence jul19_student_seq;
drop table jul19_student cascade constraint purge;
drop sequence jul19_student_seq;
select * from jul19_student
--------------------------------------------------------
-- 강의장 : 몇 강의장, 강의장 위치
-- 1강의장 : 5층 복도 오른쪽		/ 2강의장 : 5층 복도 왼쪽 끝
-- 3강의장 : 5층 복도 왼쪽 첫번째 	/ 4강의장 : 6층 정면 / 5강의장 : 6층 오른쪽
-- 강의장에 대한 데이터는 여기서 insert로 처리!
create table jul19_classroom (
	c_classroom varchar2(10 char) primary key,
	c_location varchar2(20 char) not null
);

insert into jul19_classroom values('1강의장', '5층 복도 오른쪽');
insert into jul19_classroom values('2강의장', '5층 복도 왼쪽 끝');
insert into jul19_classroom values('3강의장', '5층 복도 왼쪽 첫번째');
insert into jul19_classroom values('4강의장', '6층 정면');
insert into jul19_classroom values('5강의장', '6층 오른쪽');

select * from JUL19_classroom;
drop table jul19_classroom cascade constraint purge;









