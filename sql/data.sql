drop table if exists goods;
create table goods
(
    id          bigint(19) primary key auto_increment comment '商品id',
    name        varchar(20)    not null comment '商品名称',
    price       decimal(10, 2) not null comment '商品价格',
    description varchar(200)   not null comment '商品描述',
    picture     varchar(200)   not null comment '商品图片',
    stock       int            not null comment '商品库存',
    tag         varchar(20)    not null default '未分类' comment '商品标签',
    create_by   varchar(64)             default '' comment '创建者',
    create_time datetime comment '创建时间',
    update_by   varchar(64)             default '' comment '更新者',
    update_time datetime comment '更新时间',
    user_id     bigint(19)     not null comment '用户id',
    constraint fk_goods_user_id foreign key (user_id) references sys_user (user_id)
) comment '商品表';

drop table if exists user_apikey;
create table user_apikey
(
    id          bigint(19) primary key auto_increment comment 'id',
    user_id     bigint(19)   not null comment '用户id',
    apikey      varchar(100) not null comment 'apikey',
    create_by   varchar(64) default '' comment '创建者',
    create_time datetime comment '创建时间',
    update_by   varchar(64) default '' comment '更新者',
    update_time datetime comment '更新时间',
    constraint fk_user_apikey_user_id foreign key (user_id) references sys_user (user_id)
) comment '用户apikey表';
