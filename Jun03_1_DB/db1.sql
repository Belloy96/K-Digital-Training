create table jun03_snack(
	s_no number(4) primary key,
	s_name varchar2(10 char) not null,
	s_maker varchar2(10 char) not null,
	s_price number(4) not null
);
-- DML은 데이터 조작어 (Data Manipulation Language)라고 하고,
-- 테이블에 데이터를 검색, 삽입, 수정, 삭제 하는데 사용되는 문장
-- select, insert, update, delete 등이 있고,
-- 줄여서 CRUD (create read update delete) 라고 함
-- 여기서 C는 데이터를 만든다는 의미의 C (insert)
--		cf) create table = X (DBA의 작업)
-- 형태는
insert into 테이블명(컬럼명, 컬럼명, ...) values(값, 값, ...); -- 순서에 맞춰서 잘 넣어주기!

insert into jun03_snack(s_no, s_name, s_maker, s_price) values(1, '초코파이', '오리온', 5000);

-- 컬럼의 순서 바꾸기 - 됨! 컬럼의 바뀐 순서에 맞춰서 값을 넣어야 함
insert into jun03_snack(s_name, s_price, s_no, s_maker) values('새콤달콤', 500, 2, '롯데');

-- 컬럼에 값 안 넣기 - 에러 !, NOT NULL 때문에
insert into jun03_snack(s_name, s_no) values('마이쮸', 3);

-- (컬럼명, 컬럼명, ...) 안 넣고 테이블 생성 당시에 컬럼명 순서대로 넣는 방법도 있음!
insert into jun03_snack values(값, 값, ...);
insert into jun03_snack values(4, '엄마손파이', '롯데', 4000);
-------------------------------------------------------------------
-- 테이블 지우고
-- 다시 테이블 생성해서 값 5개정도 넣어봅시다!
drop table jun03_snack cascade constraint purge;

create table snack (
	s_no number(4) primary key,
	s_name varchar2(10 char) not null,
	s_price number(5) not null,
	s_weight number(3) not null,
	s_maker varchar2(10 char) not null
);

insert into snack values(1, '새우깡', 2000, 100, '농심');
select * from snack;
drop table snack cascade constraint purge;
----------------------강사님 답안-------------------------------------
insert into jun03_snack values(1, '초코파이', '롯데', 5000);
insert into jun03_snack values(2, '초코파이', '오리온', 5000);
insert into jun03_snack values(3, '마이쮸', '롯데', 500);
insert into jun03_snack values(4, '허니버터칩', '해태', 3000);
insert into jun03_snack values(5, '새콤달콤', '크라운', 500);

-- 그런데... 5개 넣어서 하나하나씩 과자들 번호를 부여하면 됐는데
-- 과자의 종류가 상당히 다양하죠?
-- 과자 데이터 계속 넣다가 나중에 몇번인지 잊어버리면..?
-- 데이터를 만들때마다 과자의 번호가 자동으로 계산이 되었으면 좋겠음 !

-- factory pattern이라고 해서 말 그대로 공장화 시스템!
--	MySQL : Autoincrement 옵션
--	현재 우리가 사용하는 OracleDB에서는 Sequence라는 것이 있음
--		번호를 순서에 맞게 자동으로 생성해주는건데
--		테이블과는 무관하고,
--		단점으로는 insert에 실패해도 sequence 값은 무조건 올라감
--		그리고, 증가된 값을 다시 내릴 수 없다

-- sequence(table과는 무관한) 생성
create sequence 시퀀스명; -- 간단한 시퀀스

-- 테이블명 뒤에 _seq를 붙여주는 문화가 있음
create sequence jun03_snack_seq;

-- 구체적인 시퀀스(간단하게 만드는 걸로도 다 해결이 되긴 함)
create sequence 시퀀스명
	increment by 1		-- 증가값 (1씩 증가)
	start with 1		-- 시작값
	minvalue 1			-- 최소값
	maxvalue 999		-- 최대값
	nocycle / cycle		-- 최대값에 도달하면 시작값부터 다시 반복할지 말지
	nocache / cache		-- 시퀀스를 미리 만들어놓고 메모리에서 가져다가 쓸지말지
	noorder / order;	-- 요청 순서대로 값을 생성할지 말지

-- sequence 삭제
drop sequence 시퀀스명;

-- sequence 사용 : 시퀀스명.nextval // val -> value
-- 기존에 있던 테이블 삭제했다가 다시 만들어서 값을 넣어봅시다!

insert into JUN03_SNACK values(jun03_snack_seq.nextval, '초코파이', '오리온', 5000);
insert into JUN03_SNACK values(jun03_snack_seq.nextval, '초코파이', '롯데', 5000);
insert into JUN03_SNACK values(jun03_snack_seq.nextval, '마이쮸', '롯데', 500);
insert into JUN03_SNACK values(jun03_snack_seq.nextval, '허니버터칩', '해태', 3000);
insert into JUN03_SNACK values(jun03_snack_seq.nextval, '허니버터칩(이건 실패)', '해태', 9999999);
insert into JUN03_SNACK values(jun03_snack_seq.nextval, '새콤달콤', '크라운', 500);
select * from JUN03_SNACK;
-- 1, 2, 3, 4, 실패, 6 값이 나오게 됨 -> 단점

-- 이제 다시 테이블이랑 시퀀스 지워주고, 테이블 다시 만들때 속성 추가!
--		(유통기한 Date)
drop table jun03_snack cascade constraint purge;
drop sequence jun03_snack_seq;

create table jun03_snack(
	s_no number(4) primary key,
	s_name varchar2(10 char) not null,
	s_maker varchar2(10 char) not null,
	s_price number(4) not null,
	s_expiration date not null
);

create sequence jun03_snack_seq;

select sysdate from dual; -- dual -> 더미 테이블(일종의 연습장)

insert into jun03_snack values(jun03_snack_seq.nextval, '새콤달콤 딸기맛', '크라운', 5000, sysdate);

-- 특정시간 / 날짜 (sysdate는 실시간 -> 유통기한에는 쓸 수 없음)
--		내장함수 - to_date('값', '패턴')
--		패턴(대문자) - YYYY, MM, DD, AM/PM(둘중에 하나만 작성해도 ok), HH(12시간), HH24(추천), MI(분), SS(초)
insert into jun03_snack values(jun03_snack_seq.nextval, '새콤달콤 딸기맛', 
	'크라운', 500, to_date('2024-06-07 14', 'YYYY-MM-DD HH24'));
insert into jun03_snack values(jun03_snack_seq.nextval, '화이트 하임', 
	'크라운', 4000, to_date('2024-06-08 15', 'YYYY-MM-DD HH24'));
insert into jun03_snack values(jun03_snack_seq.nextval, '버터와플', 
	'크라운', 3500, to_date('2024-06-09 16', 'YYYY-MM-DD HH24'));
insert into jun03_snack values(jun03_snack_seq.nextval, '참크래커', 
	'크라운', 3000, to_date('2024-06-10 17', 'YYYY-MM-DD HH24'));
	
insert into jun03_snack values(jun03_snack_seq.nextval, '고구마깡', 
	'농심', 2000, to_date('2024-06-11 18', 'YYYY-MM-DD HH24'));
insert into jun03_snack values(jun03_snack_seq.nextval, '조청유과', 
	'농심', 2000, to_date('2024-06-12 19', 'YYYY-MM-DD HH24'));
insert into jun03_snack values(jun03_snack_seq.nextval, '알새우칩', 
	'농심', 2000, to_date('2024-06-13 20', 'YYYY-MM-DD HH24'));
insert into jun03_snack values(jun03_snack_seq.nextval, '꿀꽈배기', 
	'농심', 2000, to_date('2024-06-14 21', 'YYYY-MM-DD HH24'));
	
insert into jun03_snack values(jun03_snack_seq.nextval, '칙촉', 
	'롯데', 4000, to_date('2024-06-15 22', 'YYYY-MM-DD HH24'));
insert into jun03_snack values(jun03_snack_seq.nextval, '빈츠 오리지널맛', 
	'롯데', 3000, to_date('2024-06-16 23', 'YYYY-MM-DD HH24'));
insert into jun03_snack values(jun03_snack_seq.nextval, '빠다코코낫', 
	'롯데', 2500, to_date('2024-06-17 00', 'YYYY-MM-DD HH24'));
insert into jun03_snack values(jun03_snack_seq.nextval, '초코칩쿠키', 
	'롯데', 2500, to_date('2024-06-18 01', 'YYYY-MM-DD HH24'));
insert into jun03_snack values(jun03_snack_seq.nextval, '빈츠 티라미수맛', 
	'롯데', 3000, to_date('2024-06-19 02', 'YYYY-MM-DD HH24'));

insert into jun03_snack values(jun03_snack_seq.nextval, '스윙칩', 
	'오리온', 2000, to_date('2024-06-20 03', 'YYYY-MM-DD HH24'));
insert into jun03_snack values(jun03_snack_seq.nextval, '포카칩 오리지널맛', 
	'오리온', 2000, to_date('2024-06-21 04', 'YYYY-MM-DD HH24'));
insert into jun03_snack values(jun03_snack_seq.nextval, '오징어땅콩', 
	'오리온', 2500, to_date('2024-06-22 05', 'YYYY-MM-DD HH24'));
insert into jun03_snack values(jun03_snack_seq.nextval, '꼬북칩', 
	'오리온', 2000, to_date('2024-06-23 06', 'YYYY-MM-DD HH24'));
insert into jun03_snack values(jun03_snack_seq.nextval, '포카칩 스윗치즈맛', 
	'오리온', 2000, to_date('2024-06-24 07', 'YYYY-MM-DD HH24'));

select count(*) from JUN03_SNACK; -- 개수세기
-------------------------------------------------------------------------
-- R(Read) // 대괄호는 생략! 강조의 의미, 제일 많이 사용함!! 중요 !!
select [distinct] [컬럼명], [컬럼명 as 별칭 || 컬럼명 별칭], [연산자], [통계함수]
	from [테이블명]
	where [조건식]
	group by [그룹대상]
	having [함수 포함 조건]
	order by [정렬대상 asc/desc(오름차순 / 내림차순)]
-- 의 형태 !

-- 과자테이블 전체 조회
-- '*' : 테이블 내의 모든 컬럼을 가져온다
select * from JUN03_SNACK;

-- distinct : 중복 제거
select s_maker from JUN03_SNACK;
select distinct s_maker from JUN03_SNACK; -- 중복되는거 제거하고 한 번씩만 나오게

-- 컬럼명은 그대로 컬럼명을 쓰면 되고,
-- 별칭 같은 경우... select문 안에서 숫자 계산이 가능한데 (+, -, *, /)
select s_price / 100 from JUN03_SNACK;
-- 컬럼명 자체가 s_price/100으로 나옴
-- 실제 프로그래밍 언어와 연동하다보면 컬럼명을 이용해서 값을 불러오는 경우가 있는데,
-- 별칭이라는 것을 써서 헷갈림을 방지하는 용도로 사용

-- as를 사용하는 방법
select s_price / 100 as s_price from JUN03_SNACK;
-- 컬럼명 띄어쓰기하고 바로 별칭 (현업에서는 이 방법을 더 선호)
select s_price / 100 s_price from JUN03_SNACK;

-- 연산자! (산술연산자)
-- Dual 테이블
--	1. 오라클 자체에서 제공해주는 더미테이블
--	2. 간단하게 함수를 이용해서 계산 결과값을 확인할 때 사용하는 테이블

-- fail? 정답은 4
select 1 + '3' from dual;
-- 4가 나옴
-- 대부분 다른 언어들 같은 경우에는 '문자 우선' 13이라는 결과가 나오는데
-- 오라클에서는 반대로 '숫자 우선'
-- 오라클 내에서는 연산자가 숫자만 연산 해줌

select 1 + 'a' from dual; -- 에러! (숫자로 바꿀 수 없다는 에러 'invalid number')

-- 문자를 더해주기 위한 연산자가 따로 있는데
-- 바로 '||' (shift + \)
select 1 || 'a' from dual;















