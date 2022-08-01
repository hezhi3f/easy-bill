drop database if exists `easy_bill`;
create database if not exists `easy_bill`;
use `easy_bill`;

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
    `gmt_created`   datetime        not null,
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
    `gmt_create`   datetime          not null,
    `gmt_modified` datetime,
    `is_deleted`   tinyint unsigned default 0,
    primary key (`id`)
)engine = innodb
 default charset = utf8mb4;

drop table if exists `bill_record`;
create table if not exists `bill_record`
(
    `id`           bigint unsigned not null auto_increment,
    `user_id`      bigint unsigned not null,
    `time`         datetime        not null,
    `amount`       decimal(12, 2)  not null,
    `description`  varchar(150),
    `type_id`      bigint unsigned,
    `gmt_create`   datetime,
    `gmt_modified` datetime,
    `is_deleted`   tinyint unsigned default 0,
    primary key (`id`),
    foreign key (`user_id`) references bill_user (`id`),
    foreign key (`type_id`) references bill_type (`id`)
) engine = innodb
  default charset = utf8mb4;

