select * from JUN03_SNACK;


-- 관계 연산자
-- NOT, AND, OR, BETWEEN, IN

-- 먼저 AND와 BETWEEN
-- 가격이 1000원 이상 3000원 이하인 과자의 전체 내용을 조회
select * from JUN03_SNACK where s_price >= 1000 and s_price <= 3000;
-- BETWEEN을 이용해서
select * from JUN03_SNACK where s_price between 1000 and 3000;

-- 뭐가 다른가요? 그냥 between쓰는게 더 좋은거 아닌가요 ?
-- between은 이상/이하로 조건 범위를 정하기 때문에
-- 1000원 초과 3000원 미만인 과자를 조회할 때는 between 사용이 안됨

-- 가격이 1000원, 2000원, 3000원인 과자의 전체 정보를 조회
-- OR연산자
select * from JUN03_SNACK where s_price = 1000 or s_price = 2000 or s_price = 3000; 
-- 지금이야 이렇게 풀 수 있지만, 점점 or를 써야하는 빈도가 많아진다면..
-- 	귀찮겠죠...? 뭔가 비효율적이고, 복잡하고...
--	뭔가 편하게 쓸 수 있는 방법이 없을까 ?!

select * from JUN03_SNACK where s_price in (1000, 2000, 3000);
-- 가격이 1000원이냐, 2000원이냐, 3000원이냐를 나타내주는 IN 연산자 !
-- 완전 편해지고 효율적이에요! 완전 매력덩어리>_<
-- 연속되지 않은 값들을 받아오고 싶을 때 => IN을 사용하자!!

-- 그럼 이 결과에 반대되는 결과값을 받아오고 싶다면? => NOT 연산자 !
-- 그러면 이 NOT을 어디에 쓰는게 좋을까요 ? NOT IN ? IN NOT ?
select * from JUN03_SNACK where s_price not in (1000, 2000, 3000);
-- IN 연산자 앞에다가 NOT을 붙여서 사용하면 된다 ~
------------------------------------------------------------------------------------
-- 패턴 연산자
-- 문자열을 포함하는 검색 : like '패턴' 의 형태
--	이때 패턴에는 '%'를 넣는데 뭐가 들어갈지 모른다는 뜻 !
--	like '%ㅋ'		: ㅋ로 끝나는거
--	like 'ㅋ%'		: ㅋ로 시작하는거
--	like '%ㅋ%'		: ㅋ가 포함
--	그럼 like 대신	( = 'ㅋ%' ) 는 안되나요?
--		=> 등호를 써서 식을 표현하면 패턴으로 인식하는게 아닌
--			'ㅋ%' 문자 그대로 인식해버림
--		=> like로 'ㅋ%' 이런 패턴의 값을 찾아라 ~ 라고 표현해줌

-- '크'가 들어가는 회사에서 만든 과자의 이름을 조회
-- '칩'가 들어가는 과자들의 평균가를 조회
-- 크라운 과자거나, 화이트~ 인거 이름, 제조사, 가격 조회
-- 과자의 이름이 '새콤달콤'을 포함하거나 '빈츠'을 포함하는 과자 이름, 제조사, 가격
select s_maker from JUN03_SNACK where s_maker like '%크%';
select round(avg(s_price), 1) from jun03_snack where s_name like '%칩%';
select s_name, s_maker, s_price from jun03_snack where s_maker = '크라운' or s_name like '화이트%';
select s_name, s_maker, s_price from jun03_snack where s_name like '%새콤달콤%' or s_name like '%빈츠%';

-- like ~ in 구조는 아예 없다 !
select s_name, s_maker, s_price from jun03_snack where s_name like in ('%새콤달콤%', '%빈츠%');

-- REGEXP_LIKE(컬럼명, 패턴1|패턴2|...)
-- 정규식(REGEX)을 이용해서 문자를 찾는 방법인데...
-- 여러개의 패턴을 찾고 싶다면 |(파이프)를 넣어서 패턴을 추가하면 됨
-- 패턴 앞에 ^를 넣으면 : 패턴 값으로 시작하는 문자열 찾기
-- 패턴 뒤에 $를 넣으면 : 패턴 값으로 끝나는 문자열 찾기

-- 과자의 이름이 '새콤달콤'으로 시작하거나 '맛'으로 끝나는 과자의 이름, 제조사, 가격을 조회
select s_name, s_maker, s_price from JUN03_SNACK where regexp_like(s_name, '^새콤달콤|맛&');
------------------------------------------------------------------------------------
-- 집합연산자
-- 	합집합
--		UNION : 중복되는 값을 제외하고 출력
select 1 id, '수학' subject, 90 score from dual
	union
select 1 id, '수학' subject, 90 score from dual
	union
select 1 id, '수학' subject, 90 score from dual;

--		UNION ALL : 중복되더라도 모두 출력
select 1 id, '수학' subject, 90 score from dual
	union all
select 1 id, '수학' subject, 90 score from dual
	union all
select 1 id, '수학' subject, 90 score from dual;

-- 	교집합
--		INTERSECT : 두 테이블의 집합 중 공통되는 값 출력
select 1 id, '수학' subject, 90 score from dual
	union
select 2 id, '영어' subject, 80 score from dual
	intersect
select 1 id, '수학' subject, 90 score from dual;

-- 	차집합
--		MINUS : 첫번째 select문 중에서 두번째 select문에 없는 값을 출력
select 1 id, '수학' subject, 90 score from dual
	minus
select 2 id, '영어' subject, 80 score from dual
	minus
select 1 id, '수학' subject, 90 score from dual;
------------------------------------------------------------------------------------
-- 과자 데이터 중에서 회사가 크라운이고 가격이 1000원 이하이거나 3000원 이상인
--	과자의 전체 정보를 조회
-- 	연산자 우선순위 (오른쪽이 최우선순위)
--	OR > AND > NOT > 비교연산자 > 괄호

select * from jun03_snack where s_maker = '크라운'
	intersect
select * from jun03_snack where s_price <= 1000 or s_price >= 3000;
-- 소괄호를 넣어야지 원하는 결과가 나옴
select * from jun03_snack where s_maker = '크라운' and (s_price <= 1000 or s_price >= 3000);
------------------------------------------------------------------------------------
-- Group by : 그룹으로 묶어 연산해서 하나의 결과로 나타내는 것
-- 회사별 과자 평균가격, 최소가격, 최고가격
select s_maker, round(avg(s_price), 1), min(s_price), max(s_price)
	from jun03_snack
	group by s_maker;

-- Rollup 연산자
-- group by rollup(그룹 대상)
-- 컬럼에 대한 소계(subtotal)을 만들어 줌
-- group by 절의 컬럼 개수가 n개라면, rollup을 썼을 때는 n+1개

-- 회사 이름, 회사별 과자 총 가격 합계와 모든 과자들의 가격 합계
select s_maker, sum(s_price)
	from jun03_snack
	group by rollup(s_maker);
	
-- s_maker가 null이면 '전체', 그게 아니면 s_maker 값
select nvl2(s_maker, s_maker, '전체') s_maker, sum(s_price)
	from jun03_snack
	group by rollup(s_maker);
	
-- DECODE(컬럼명, 조건, 조건에 맞는 결과값, 조건에 맞지 않을 때 결과값)
select decode(s_maker, null, '전체', s_maker) s_maker, sum(s_price)
	from jun03_snack
	group by rollup(s_maker);

-- decode 사용시 : 조건 자리에는 비교연산자 (X), 산술 연산자 (O)
------------------------------------------------------------------------------------
-- Having : Group by 절에 의해 생성된 결과 중 원하는 조건에 부합하는 자료만
--			찾고자 할 때 사용
-- Having과 Where 모두 조건을 이용해서 원하는 조건에 맞는 데이터만 산출한다는
--	공통점이 있는데
-- Having : 그룹의 결과 제한
--		vs
-- Where : 조건을 사용해서 결과를 제한 (그룹화 전)

-- 회사별 과자 평균 가격이 2000원 이상인 회사의 이름과 평균 가격을 조회
select s_maker, avg(s_price) 
	from jun03_snack
	group by s_maker
	having avg(s_price) >= 2000;

-- ORDER BY : 정렬! 기본값은 ASC(오름차순), DESC(내림차순)
order by [정렬대상 ASC(오름차순 / 생략가능) / DESC]

-- 롯데 또는 오리온(강의에서는 해태) 회사의 과자 평균 가격이 1800원 이상일 때
--	각 회사의 평균 가격 내림차순 정렬
select s_maker, avg(s_price)
	from jun03_snack
	where s_maker = '롯데' or s_maker = '오리온' -- s_maker in ('롯데', '오리온')
	group by s_maker
	having avg(s_price) >= 1800
	order by avg(s_price) desc;

	
	
	
	
	
	
	
	
	
	
	
	



