drop database if exists `easy_bill`;
create database if not exists `easy_bill`;
use `easy_bill`;

set foreign_key_checks = 0;
drop table if exists `bill_user`;
create table `bill_user`
(
    `id`           bigint unsigned not null auto_increment,
    `username`     varchar(32)     not null,
    `password`     varchar(32)     not null,
    `avatar`       varchar(32),
    `nickname`     varchar(32),
    `phone_number` varchar(16),
    `email`        varchar(32),
    `gender`       tinyint unsigned,
    `age`          int unsigned,
    `secret`       varchar(64),
    `gmt_created`  datetime        not null,
    `gmt_modified` datetime,
    `is_deleted`   tinyint default 0,
    primary key (`id`)
) engine = innodb
  default charset = utf8mb4;

drop table if exists `bill_type`;
create table if not exists `bill_type`
(
    `id`           bigint unsigned   not null auto_increment,
    `type`         varchar(8) unique not null,
    `is_expend`    tinyint unsigned,
    `gmt_created`  datetime          not null,
    `gmt_modified` datetime,
    `is_deleted`   tinyint unsigned default 0,
    primary key (`id`)
) engine = innodb
  default charset = utf8mb4;

drop table if exists `bill_record`;
create table if not exists `bill_record`
(
    `id`           bigint unsigned not null auto_increment,
    `user_id`      bigint unsigned not null,
    `time`         datetime        not null,
    `amount`       decimal(12, 2)  not null,
    `memo`  varchar(150),
    `type_id`      bigint unsigned,
    `gmt_created`  datetime,
    `gmt_modified` datetime,
    `is_deleted`   tinyint unsigned default 0,
    primary key (`id`),
    foreign key (`user_id`) references bill_user (`id`),
    foreign key (`type_id`) references bill_type (`id`)
) engine = innodb
  default charset = utf8mb4;

set foreign_key_checks = 1;

