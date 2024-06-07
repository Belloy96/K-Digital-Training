-- 배추, 3000g, 10000원, 홈플러스, 종로점, 1000평, 주차장 500석
-- 무, 500g, 5000원, 홈플러스, 강남점, 500평, 주차장 300석
-- 배추, 2000g, 5000원, 이마트, 서초점, 800평, 주차장 800석
-----------------------------------------------------------------------------
create table jun07_market (
	m_no number(2) primary key,
	m_name varchar2(10 char) not null,
	m_location varchar2(10 char) not null,
	m_land number(4) not null,
	m_parking number(4) not null	
	);

create sequence jun07_market_seq;	
	
insert into jun07_market values(jun07_market_seq.nextval, '홈플러스', '종로', 1000, 500);
insert into jun07_market values(jun07_market_seq.nextval, '홈플러스', '강남', 500, 300);
insert into jun07_market values(jun07_market_seq.nextval, '이마트', '서초', 800, 800);

drop sequence jun07_market_seq;
select * from jun07_market;
drop table jun07_market cascade constraint purge;
-----------------------------------------------------------------------------
create table jun07_product(
	p_no number(2) primary key,
	p_name varchar2(10 char) not null,
	p_weight number(4) not null,
	p_price number(5) not null,
	p_m_no number(2) not null,
	constraint fk_jun07_product foreign key(p_m_no)
		references jun07_market(m_no)
		on delete cascade
);

create sequence jun07_product_seq;

insert into jun07_product values (jun07_product_seq.nextval, '배추', 3000, 10000, 1);
insert into jun07_product values (jun07_product_seq.nextval, '무', 500, 5000, 2);
insert into jun07_product values (jun07_product_seq.nextval, '배추', 2000, 5000, 3);

select * from jun07_product;
-----------------------------------------------------------------------------
-- create table - DBA 업무
-- drop table - DBA 업무
-- create sequence - DBA 업무
-----------------------------------------------------------------------------
-- C - insert
--			sequence 사용, 데이터 집어넣고 (+날짜), ...
-- R - select
-- 			거의 대부분을 시간을 할애함
-- U - update
update 테이블명
	set 컬럼명 = 값, 컬럼명 = 값, ... -- 바꿀 내용
	where 조건;

-- 무를 공짜로
update jun07_product
	set p_price = 0
	where p_name = '무';
	
-- 모든 배추를 김장용특대배추로 이름 수정
update jun07_product
	set p_name = '김장용특대배추'
	where p_name = '배추';
	
-- 모든 마트의 주차장 30% 줄이기
update jun07_market
	set m_parking = m_parking * 0.7;
	
-- 홈플러스 종로점의 상품 가격 10% 할인
update jun07_product
	set p_price = p_price * 0.9
	where p_m_no = (
	select m_no
	from jun07_market
	where m_name = '홈플러스' and m_location = '종로'
	);
	
-- 제일 비싼 상품 10% 할인	
update jun07_product
	set p_price = p_price * 0.9
	where p_price = (
		select max(p_price)
		from jun07_product
	);
-----------------------------------------------------------------------------
-- D
delete from 테이블명
	where 조건식;

-- 무 삭제
delete from jun07_product
	where p_name = '무';
	
-- 가장 좁은 매장의 상품 다 삭제
delete from jun07_product
	where p_m_no = ( 
		select m_no
		from jun07_market
		where m_land = (
			select min(m_land)
			from jun07_market
		)
	);

-----------------------------------------------------------------------------
-- 홈플러스 강남점이 폐점
--	=> 그 안에 있던 상품들은 어떻게 할지...?
--	그냥 두거나 / 같이 삭제 / 비워두거나
-- 	정답이 없어서... => 나중에 프로젝트시 팀원들끼리 잘 상의해야함
-----------------------------------------------------------------------------
select * from jun07_product;
