create database if not exists blog_system charset utf8;

use blog_system;

drop table if exists blog;
drop table if exists user;

create table user (
    userId int primary key auto_increment,
    username varchar(50) unique,
    password varchar(20)
);

insert into user values (null, 'zhangsan', '123'),
                        (null, 'lisi', '123');

create table blog (
    blogId int primary key auto_increment,
    title varchar(1024),
    content varchar(4096),
    postTime datetime,
    userId int,
    foreign key (userId) references user (userId)
);

insert into blog values (null, '第一篇博客', '正文1', now(), 1),
                        (null, '第二篇博客', '正文2', now(), 1),
                        (null, '第三篇博客', '正文3', now(), 1);
