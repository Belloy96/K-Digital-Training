-- create schema [데이터베이스명] 으로 데이터베이스 생성
-- create database 로도 생성할 수 있음
-- 한글과 이모티콘을 사용하기 위해 설정해줄것!
create schema `belloy` default character set utf8mb4
	default collate utf8mb4_general_ci;
use belloy;
    
-- 유저 테이블 생성
create table belloy.users(
	id int not null auto_increment,
    name varchar(20) not null,
    age int unsigned not null,
    married tinyint not null,
    comment text,
    created_at datetime not null default now(),
    primary key(id),
    unique index name_unique (name ASC))
    comment = '사용자 정보'
    engine = InnoDB;
	-- 데이터베이스 엔진, 
	-- 대표적으로 MyISAM, InnoDB
    
    -- auto_increment = 시퀀스
	-- comment = 테이블에 대한 보충 설명

-- 댓글 테이블
create table belloy.comments(
	id int not null auto_increment,
    commenter int not null,
    comment varchar(100) not null,
    created_at datetime not null default now(),
    primary key(id),
    index commenter_idx (commenter ASC),
    foreign key(commenter)
    references belloy.users (id)
    on delete cascade
    on update cascade)
    comment = '댓글'
    engine = InnoDB;

-- 자료형
--	INT : 정수
--	DOUBLE : 실수
-- 	VARCHAR(용량) : 용량(Byte가 아니라 글자 수)만큼의 문자열
--	TEXT : 긴 글을 저장할 때 사용
--		수백자 이내라면 VARCHAR, 그 이상이면 TEXT
--	TINYINT : -128 ~ 127 까지의 정수
--		1 or 0만 저장한다면 Boolean의 역할을 함
--	DATETIME : 날짜/시간에 대한 정보
--		날짜는 DATE / 시간은 TIME
    
-- 제약조건
-- null / not null
-- auto_increment : 오라클의 sequence 역할
-- UNSIGNED : ex) INT : 약 -21억 ~ 21억 이라면
--	INT UNSIGNED는 0 ~ 약 42억 / 실수에는 적용 X
-- ZEROFILL : 숫자의 자릿수가 고정되어있을 때 사용
--	ex) INT(4)일 때 값이 1이면 0001
-- DEFAULT : 기본값 / 날짜에서 기본값으로
--		now()는 현재 시간/날짜
-- PRIMARY KEY : 기본키
-- UNIQUE INDEX : 해당 값이 고유해야 하는지에 대한 옵션    
    
-- 데이터 넣기
insert into belloy.users (name, age, married, comment)
		values ('벨로이', 29, 0, '내일모레서른');
insert into belloy.users (name, age, married, comment)
		values ('벨뤄이', 28, 1, '평행세계에서결혼한나');
select * from belloy.users;

insert into belloy.comments (commenter, comment)
		values (1, '얼른 날씨가 좋아졌으면 해요');
select * from belloy.comments;

drop table belloy.users cascade;
drop table belloy.comments cascade;

-- ============================================
-- << 문법 비교 .vs Oracle >>
-- - 공백치환 함수 ( IFNULL -> NVL )
-- - 현재 날짜시간 ( NOW() -> SYSDATE )
-- - 날짜 포맷
--	Oracle : TO_CHAR(sysdate, 'YYYYMMDDHH24MISS')
--	MySQL : DATE_FORMAT(now(), '%Y%m%d%H%i%s')
-- - 날짜 포맷(요일)
--	Oracle : 요일이 1 ~ 7로 인식 ('D', 'dy', 'day')
--	MYSQL : 요일이 0 ~ 6로 인식 ('%w')
--	Like 절 '%'
--	Oracle : Like '%'||'문자'||'%'
--	MySQL : Like CONCAT('문자', '%')
--	- 형 변환
--	Oracle : TO_CHAR, TO_DATE, TO_NUMBER 등
--	MySQL : CAST
--		ex) select to_char(1234) from dual
--		=> select cast(1234 as varchar) from dual
-- - 대소문자 구분
--	Oracle : 구분없음
--	MySQL : 기본적으로 구분하나, 설정으로 변경 가능함
-- - ROWNUM
--	Oracle : where 절에 rownum >= 5 and rownum <= 10
-- 	Mysql : where절 없이 limit 5, 10
-- - Sequence(시퀀스)는 둘 다 사용자함수를 만들어서 사용
--	Oracle : 시퀀스명.nextval
--	MySQL : table 생성 시 제약조건에 auto increment를
--		추가하기에 해당 컬럼을 Select 하면 됨
-- - 문자열 자르기
--	Oracle : SUBSTR(문자열, 1, 10)
-- 	MySQL : SUBSTRING(문자열, 1, 10)
--		LEFT(문자열, 3), RIGHT(문자열, 3)
-- - 문자열 합치기
--	Oracle : 문자열(또는 컬럼) || ' - ' 
--	MySQL : CONCAT(문자열(또는 컬럼), ' - ')


    