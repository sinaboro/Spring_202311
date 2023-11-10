create table tbl_board(
	bno int auto_increment primary key,
    title varchar(200) not null,
    content varchar(2000) not null,
    writer varchar(200) not null,
    regdate datetime default current_timestamp,
    updatedate datetime default current_timestamp
);

insert into tbl_board(title, content, writer)
values('조조', '삼국지전 등장인물', '몰라');