-- 어떤 특정한 식당에 대한 테이블
-- 식당 지점(체인점 지역), 식당 주인(이름), 좌석 수
create table Restaurant (
	rst_location varchar2(20 char) primary key,
	rst_owner varchar2(20 char) not null,
	rst_seat number(3) not null
);

-- 데이터 2-3개 정도 넣기
insert into Restaurant values('강남', '벨로이', 900);
insert into Restaurant values('사당', '김겸', 600);
insert into Restaurant values('홍대', '훈세', 700);

-------------------------------------------------------------
-- 예약 테이블
-- 예약자 이름, 예약 시간, 예약자 전화번호, 예약 지점
create table Reservation (
	rsv_no number(3) primary key,
	rsv_name varchar2(20 char) not null,
	rsv_time date not null,
	rsv_phonenum varchar2(20 char) not null,
	rst_location varchar2(20 char) not null,
	constraint fk_rst_location foreign key(rst_location)
	references Restaurant(rst_location)
	on delete cascade
);

create sequence Reservation_seq;

-- 데이터 2-3개 정도 넣기
insert into Reservation values(Reservation_seq.nextval, '김길동', 
			to_date('2024-06-11 18:00', 'YYYY-MM-DD HH24:MI'), '010-1234-1111', '강남');
insert into Reservation values(Reservation_seq.nextval, '이길동', 
			to_date('2024-06-12 19:00', 'YYYY-MM-DD HH24:MI'), '010-1234-2222', '강남');
insert into Reservation values(Reservation_seq.nextval, '박길동', 
			to_date('2024-06-13 20:00', 'YYYY-MM-DD HH24:MI'), '010-1234-3333', '강남');
			
insert into Reservation values(Reservation_seq.nextval, '최길동', 
			to_date('2024-06-11 18:30', 'YYYY-MM-DD HH24:MI'), '010-1234-4444', '사당');
insert into Reservation values(Reservation_seq.nextval, '정길동', 
			to_date('2024-06-12 19:30', 'YYYY-MM-DD HH24:MI'), '010-1234-5555', '사당');
insert into Reservation values(Reservation_seq.nextval, '강길동', 
			to_date('2024-06-13 20:30', 'YYYY-MM-DD HH24:MI'), '010-1234-6666', '사당');
			
insert into Reservation values(Reservation_seq.nextval, '조길동', 
			to_date('2024-06-11 18:00', 'YYYY-MM-DD HH24:MI'), '010-1234-7777', '홍대');
insert into Reservation values(Reservation_seq.nextval, '윤길동', 
			to_date('2024-06-12 19:30', 'YYYY-MM-DD HH24:MI'), '010-1234-8888', '홍대');
insert into Reservation values(Reservation_seq.nextval, '장길동', 
			to_date('2024-06-13 21:00', 'YYYY-MM-DD HH24:MI'), '010-1234-9999', '홍대');

-----------------------------select and drop--------------------------------------------
select * from Restaurant
select * from Reservation

drop table Restaurant cascade constraint purge;
drop table Reservation cascade constraint purge;



