drop database if exists `easy_bill`;
create database if not exists `easy_bill`;
use `easy_bill`;

drop table if exists `bill_user`;
create table `bill_user`
(
    `id`           bigint unsigned not null auto_increment,
    `username`     varchar(16)     not null,
    `password`     varchar(16)     not null,
    `avatar`       varchar(16),
    `nickname`     varchar(16),
    `phone_number` varchar(16),
    `email`        varchar(16),
    `gender`       tinyint unsigned,
    `age`          int unsigned,
    `gmt_create`   datetime,
    `gmt_modified` datetime,
    primary key (`id`)
) engine = innodb
  default charset = utf8;

drop table if exists `bill_record`;
create table if not exists `bill_record`
(
    `id`           bigint unsigned not null auto_increment,
    `user_id`      bigint unsigned not null,
    `time`         datetime,
    `amount`       decimal(12, 2)  not null,
    `description`  varchar(150),
    `type_id`      bigint unsigned,
    `gmt_create`   datetime,
    `gmt_modified` datetime,
    primary key (`id`)
) engine = innodb
  default charset = utf8;


drop table if exists `bill_type`;
create table if not exists `bill_type`
(
    `id`   bigint unsigned   not null auto_increment,
    `type` varchar(8) unique not null,
    primary key (`id`)
);


