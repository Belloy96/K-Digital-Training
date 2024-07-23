create table search_location(
	sl_no number(3) primary key,
	sl_place_name varchar2(30 char) not null,
	sl_phone varchar2(20 char) not null,
	sl_x number(9, 6) not null,
	sl_y number(8, 6) not null
);

create sequence search_location_seq;

select * from SEARCH_LOCATION;

-- NVL 함수 : null일때 지정한 값으로 대치하는 함수
-- NVL(값, (값이)null일때 대체 값)
select nvl(null,'-'), nvl('null','-') from dual;

-- NVL2 함수 : null의 여부에 따라서 지정한 값으로 대치하는 함수
-- NVL2(값, 값이 있을때 대체값, 값이 없을때 대체값)
select nvl2(null, 'A', 'B'), nvl2('null', 'A', 'B') from dual;














