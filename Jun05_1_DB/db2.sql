select * from jun05_franchise;
select * from jun05_ceo;
select * from jun05_menu;
-------------------------------------------------------------------------
-- 좌석 수 제일 많은 식당을 운영하는 사람의 전체 정보 조회
select * from jun05_ceo
	where c_no = (
	select f_ceo
		from jun05_franchise
		where f_seat = (
			select max(f_seat)
			from jun05_franchise
		)
	);

-- 메뉴 전체의 이름, 가격
--		을 가격 오름차순 => 가격이 같다면 메뉴명을 가나다 역순 정렬
-- 여러번 정렬 하고 싶을 때.. => order by 컬럼명 (ASC/DESC), 컬럼명 (ASC/DESC), ...
select m_name, m_price from jun05_menu order by m_price, m_name desc;

-- 전체 사장님들 이름, 생일 조회
select c_name, c_birthday from jun05_ceo;

-- 프랜차이즈 식당 몇 개 ?
select count(*) from jun05_franchise;

-- 프랜차이즈 메뉴 전체의 평균가
select avg(m_price) from jun05_menu;
-------------------------------------------------------------------------
-- 제일 비싼 메뉴 이름, 가격
select m_name, m_price 
	from jun05_menu
	where m_price = (
		select max(m_price)
		from jun05_menu
	);

-- 최연장자 사장님의 이름, 생일 (최연장자 = 최소 생일 값)
select c_name, c_birthday
	from jun05_ceo
	where c_birthday = (
		select min(c_birthday)
		from jun05_ceo
	);

-- 좌석 수 제일 적은 식당의 이름, 지점명, 좌석 수
select f_name, f_location, f_seat 
	from jun05_franchise
	where f_seat = (
		select min(f_seat) 
		from jun05_franchise
	);
-------------------------------------------------------------------------
-- 홍콩반점 서초점을 운영하는 사람의 이름, 생일
select c_name, c_birthday from jun05_ceo
	where c_no in (
		select f_ceo
		from jun05_franchise
		where f_name = '홍콩반점' and f_location = '서초'
	);
	
-- '짜장'이 들어간 음식은 어디가면 먹을 수 있나요? (식당 이름, 지점명)
select f_name, f_location from jun05_franchise
	where f_no in (
		select m_f_no 
		from jun05_menu 
		where m_name like '%짜장%'
	);
-------------------------------------------------------------------------
-- 최연소 사장님네 가게 메뉴 이름, 가격
select m_name, m_price 
	from jun05_menu
	where m_f_no in (
		select c_no from jun05_franchise
			where f_ceo in (
				select c_no from jun05_ceo
					where c_birthday in (
						select max(c_birthday)
					)
			)
	);
	
-- 최길동이 운영하는 가게의 모든 메뉴 이름, 가격 , 사장님 생일
select m_name, m_price, (
	select c_birthday
	from jun05_ceo
	where c_no = (
		select f_ceo
		from jun05_franchise
		where f_no = m_f_no
	)	
) c_birthday
from jun05_menu
	where m_f_no in (
		select f_no
		from jun05_franchise
		where f_ceo in (
			select c_no
			from jun05_ceo
			where c_name = '최길동'
	)
);
-------------------------------------------------------------------------
-- 테이블 여러개를 'JOIN' 시킨다	
--				: 테이블 여러개를 붙여서 RAM에 잠깐 넣어놓는...	
-------------------------------------------------------------------------
select * from jun05_franchise, jun05_ceo;	
-- 이렇게 테이블을 붙여서 사용이 가능하지만,
--	테이블들이 합쳐지면서 나타낼 수 있는 모든 값들을 나타내기 때문에
--	진짜 데이터들만 뽑아내려면 => 조건식을 사용해야 함
select * from jun05_franchise, jun05_ceo where f_ceo = c_no;	

-- 전체 식당 이름, 지점명, 사장님 이름, 사장님 생일
select f_name, f_location, c_name, c_birthday 
	from jun05_franchise, jun05_ceo 
	where f_ceo = c_no;

-- 전체 메뉴명, 가격, 식당 이름, 지점명
select m_name, m_price, f_name, f_location 
	from jun05_menu, jun05_franchise 
	where m_f_no = f_no;

-- 좌석 수가 50석 이상인 식당의 메뉴명, 가격, 식당이름, 지점명, 좌석 수
select m_name, m_price, f_name, f_location, f_seat 
	from jun05_menu, jun05_franchise 
	where m_f_no = f_no and f_seat >= 50;
	
-- 규모가 제일 큰 식당의 메뉴명, 가격, 식당이름, 지점명, 좌석 수
select m_name, m_price, f_name, f_location, f_seat 
	from jun05_menu, jun05_franchise 
	where m_f_no = f_no 
		and f_seat in (
			select max(f_seat)
			from jun05_franchise
	);

-- 최연장자 사장님네 전체 메뉴명, 가격, 식당이름, 지점명, 사장님이름, 생일
--		을 메뉴명 가나다순 => 메뉴 이름이 같다면 식당이름 가나다순
select m_name, m_price, f_name, f_location, c_name, c_birthday 
	from jun05_menu, jun05_franchise, jun05_ceo 
	where m_f_no = f_no and f_ceo = c_no
		and c_birthday in (
			select min(c_birthday) 
			from jun05_ceo
	)
order by m_name, f_name;
-------------------------------------------------------------------------
-- 메뉴 데이터를 개수를 나눠서 페이즈로 보여주고 싶음
--		어떻게 할까...?
-- 메뉴테이블에 m_no가 있음 (Primary key)
--		Sequence로 처리했음
--		그.런.데.말.입.니.다 sequence는 insert에 실패해도 올라감
--		메뉴 테이터 삭제도 가능!
--	=> m_no가 정확히 1, 2, 3, 4, ... 가 아님
-- 그럼 어떤 방법이 있을까...?
-------------------------------------------------------------------------
-- Rownum (가상필드) *******************
--		select을 할 때마다 자동으로 부여됨 (숫자)
--		* 랑은 같이 사용할 수 없음
--		order by보다 먼저 부여
--		무조건 1번부터 조회해야 함!!

-- 메뉴 이름을 가나다 순으로 정렬해서 메뉴 전체 정보 조회
select rownum, m_no, m_name, m_price, m_f_no from jun05_menu order by m_name;

-- 메뉴 이름을 가나다 순으로 정렬해서 menu 테이블 rownum 1 ~ 3까지 전체 정보를 조회
select rownum, m_no, m_name, m_price, m_f_no 
	from jun05_menu 
	where rownum >= 1 and rownum <= 3 -- 이렇게 하면 order by 전에 rownum이 생성되어서
									  -- sequence를 먹인 m_no와 같게 나와버림
									  -- 우리가 의도한 바는 이름순으로 정렬을 하고
									  -- 그 다음에 번호값(rownum)을 주기를 원했음
	order by m_name;
	
select rownum, m_no, m_name, m_price, m_f_no 
	from jun05_menu
	order by m_name
	where rownum >= 1 and rownum <= 3; -- 코드상 결과값이 나오게 하려면 이렇게 하고 싶은데
									   -- 문법오류 !!!

-- 해법 !
select rownum, m_no, m_name, m_price
	from (
		select m_no, m_name, m_price 	-- 1. 이 부분을 테이블처럼 사용함
		from jun05_menu order by m_name	-- (먼저 데이터 정렬 해놓고)
		
		-- SUBQUERY가 FROM절에서 사용되는 경우를 인라인 뷰(Inline View)라고 함
		-- 하나의 쿼리문 내에서 테이블처럼 사용함 (테이블 대체 용도)
		-- 쿼리문 종료 후에는 사라지는 임시적인 뷰!
		
		-- 뷰 (View)
		-- 진짜 테이블이 아닌 가상의 테이블, 테이블처럼 취급
		-- 사용자에게 접근이 허용된 자료만을 제한적으로 보여주기 위해서 사용
		-- 그럼 진짜 테이블을 쓰면 되는데 굳이 왜 ?
		-- 1. 무언가 숨기고 싶은 정보가 있다면,
		--		뷰를 생성할 때 해당 컬럼을 빼고 생성함으로서 보안성에 좋음
		-- 2. 기존 테이블의 구조가 변경되어도 뷰의 구조를 변경하지 않아도 됨
	)
-- where rownum >= 1 and rownum <= 3;	
where rownum >= 2 and rownum <= 3; -- 1번부터 조회해야 하기 때문에 오류 !	

-- rownum 2 ~ 4까지 메뉴테이블 정보를 메뉴명 가나다순
-- select문을 겉에 한번 더 씌워주면 내부의 rownum이 숫자만 부여해놓고 효력을 잃어버림
select * -- rownum, rn, m_no, m_name, m_price / *로 대치가능
	from (
		select rownum rn, m_no, m_name, m_price -- 효력 상실! (1번부터 해야한다...는!)
			from (
				select m_no, m_name, m_price 	
				from jun05_menu 
				order by m_name	
			)
	)
where rn >= 2 and rn <= 4;	

-- ~길동 이름을 가진 사장님네
--		메뉴명, 가격, 식당명, 지점명, 사장님이름
--		가격 내림차순 => (가격이 같다면)메뉴명 가나다순 정렬 후
--		3 ~ 8번까지 조회
select * from jun05_ceo where c_name like '%길동';

select m_name, m_price, f_name, f_location, c_name
	from jun05_menu, jun05_franchise, jun05_ceo
	where m_f_no = m_no and f_ceo = c_no;

-- 김씨 성을 가진 사장님네 메뉴명, 가격, 사장님 이름, 사장님 성별
--		가격 오름차순 => 2 ~ 3번만 조회

select * from jun05_ceo where c_name like '김%';

select m_name, m_price, c_name, c_gender 
	from jun05_menu, jun05_ceo 
	where m_f_no = c_no
	order by m_price;




