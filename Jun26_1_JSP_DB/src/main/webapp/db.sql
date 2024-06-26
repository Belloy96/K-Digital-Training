-- 사과 테이블 : 지역 / 색 / 맛 / 가격 / 소개		정보

-- 데이터 2개 넣기

create table Apple(
	a_location varchar2(10 char) primary key,
	a_color varchar2(10 char) not null,
	a_flavor varchar2(10 char) not null,
	a_price number(5) not null,
	a_introduce varchar2(100 char) not null
);

insert into Apple values('서울', '빨강', '달달한맛', 8000, '달달한 서울 빨강사과');
insert into Apple values('경기', '초록', '상큼한맛', 6000, '상큼한 경기 초록사과');
select * from apple;









