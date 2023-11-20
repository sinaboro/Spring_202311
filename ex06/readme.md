create table users(
    username varchar2(50) primary key,
    password varchar2(50) not null,
    enabled char(1) default '1'
);
create table authorities(
    username varchar2(50) not null,
    authority varchar2(50) not null,
    CONSTRAINT fk_authorites_users FOREIGN key(username) 
        references users(username)
);
create unique index ix_auth_username on authorities(username, authority);

insert into users(username, password) values('user00', 'pw00');
insert into users(username, password) values('member00', 'pw00');
insert into users(username, password) values('admin00', 'pw00');

insert into authorities values('user00', 'ROLE_USER');
insert into authorities values('member00', 'ROLE_MEMBER');
insert into authorities values('admin00', 'ROLE_ADMIN');
insert into authorities values('admin00', 'ROLE_MEMBER');

commit;


