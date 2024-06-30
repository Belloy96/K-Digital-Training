-- 멤버 테이블에 들어갈 내용
-- id, pw, 이름, 핸드폰번호, 생년월일, 사진

create table jun_member (
	m_id varchar2(20 char) primary key,
	m_pw varchar2(20 char) not null,
	m_name varchar2(10 char) not null,
	m_number varchar2(20 char) not null,
	m_birth number(8) not null,
	m_photo varchar2(100 char) not null
);

select * from jun_member;




















