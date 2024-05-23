create database if not exists message_wall charset utf8;

use message_wall;

drop table if exists message;
create table message (`from` varchar(1024), `to` varchar(1024), message varchar(1024));