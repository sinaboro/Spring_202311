create table tbl_reply(
    rno number(10,0),
    bno number(10,0) not null,
    reply varchar2(1000) not null,
    replyer varchar2(50) not null,
    replyDate date default sysdate,
    updateDate date default sysdate
);
-- 시퀀스 생성
create SEQUENCE seq_reply;

-- 기본키 생성(rno)
alter table tbl_reply add constraint pk_reply PRIMARY key(rno);

--외래키 생성(bno => tbl_board)
alter table tbl_reply add constraint fk_reply_board
FOREIGN key(bno) REFERENCES tbl_board(bno);