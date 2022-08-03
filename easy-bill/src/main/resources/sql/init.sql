insert into bill_type(`type`,`is_expend`,`gmt_created`)
values ('衣','1',now()),
       ('食','1',now()),
       ('住','1',now()),
       ('行','1',now()),
       ('教育','1',now()),
       ('医疗','1',now()),
       ('娱乐','1',now()),
       ('工姿','0',now()),
       ('零花钱','0',now()),
       ('奖金','0',now());

insert into bill_user(`username`, `password`, `gmt_created`)
values ('guomq', '123456', now()),
       ('liaoxh', '123456', now()),
       ('guojq', '123456', now());