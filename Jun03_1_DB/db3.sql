-- 웹사이트에서 게시판에 대한 테이블과 이를 [참조하는] 댓글 테이블을 만드려고 함
-- 게시판 테이블에서는 [작성자 / 게시판 글 내용 / 작성 시간]에 대한 부분이 있었으면
-- 댓글 테이블에는 [작성자 / 댓글 내용 / 작성 시간]에 대한 부분이 있었으면

-- 1. 테이블의 구조를 파악해서 게시판 테이블 만들기
-- 2. 테이블의 구조를 파악해서 댓글 테이블 만들기
--	[조건 : 참조 되는 테이블의 내용이 삭제되면 관련있는 댓글 내용도 삭제]
-- 3. 게시판 테이블에 값 2개 넣고 / 각 게시글마다 댓글 2개씩 넣기
--	[조건 : 날짜 관련한 값은 현재 날짜/시간으로 통일]
-- 4. 게시글 1번을 지웠을 때 관련 댓글들도 지워지는지 확인

create table notice_board (
	nb_num number(5) primary key,
	nb_author varchar2(10 char) not null,
	nb_content varchar2(20 char) not null,
	nb_time date not null
);

insert into notice_board values(1, 'Belloy', '식곤증이 온...ㄷ..', sysdate)
insert into notice_board values(2, 'KG', '평가는 무서운 것이에요', sysdate)
select * from notice_board;

create table comment_board (
	cb_author varchar2(10 char) not null,
	cb_content varchar2(20 char) not null,
	cb_time date not null,
	cb_num number(5) not null,	
	constraint fk_cb_num foreign key(cb_num)
		references notice_board(nb_num)
		on delete cascade
);

insert into comment_board ('Belle', '나도..1', sysdate, 1);
insert into comment_board ('Roy', '나도..2', sysdate, 1);
insert into comment_board ('Kim', '인정..1', sysdate, 2);
insert into comment_board ('Gyeom', '인정..2', sysdate, 2);

drop table notice_board cascade constraint purge;
drop table comment_board cascade constraint purge;

----------------------강사님 답안-----------------------------------------
create table board(
	b_no number(4) primary key,
	b_owner varchar2(10 char) not null,
	b_txt varchar2(100 char) not null,
	b_when date not null
);

create sequence board_seq;

create table board_reply (
	br_no number(4) primary key,
	br_b_no number(4) not null, -- 소속된 글 번호 / 이걸로 board 테이블을 참조
	br_owner varchar2(10 char) not null,
	br_txt varchar2(100 char) not null,
	br_when date not null,
	constraint fk_board_reply foreign key(br_b_no)
		references board(b_no)
		on delete cascade
);

create sequence board_reply_seq;

insert into board values(board_seq.nextval, '박비버', '안녕하세요', sysdate);
insert into board values(board_seq.nextval, 'Beaver Kim', 'Hi', sysdate);
select * from board;

insert into board_reply values(board_reply_seq.nextval, 1, '최비버', '으악!', sysdate);
insert into board_reply values(board_reply_seq.nextval, 2, '박비버', '악으!', sysdate);
insert into board_reply values(board_reply_seq.nextval, 1, '오비버', '빠끄!', sysdate);
insert into board_reply values(board_reply_seq.nextval, 2, '정비버', '끄빠!', sysdate);
select * from board_reply;

delete from board where b_no = 1;

drop table board cascade constraint purge;
drop sequence board_seq;
drop table board_reply cascade constraint purge;
drop sequence board_reply_seq;







