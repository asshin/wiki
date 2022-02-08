drop table if exists `ebook`;
create table `ebook` (
                         `id` bigint not null comment 'id',
                         `name` varchar(50) comment '名称',
                         `category1_id` bigint comment '分类1',
                         `category2_id` bigint comment '分类2',
                         `description` varchar(200) comment '描述',
                         `cover` varchar(200) comment '封面',
                         `doc_count` int not null default 0 comment '文档数',
                         `view_count` int not null default 0 comment '阅读数',
                         `vote_count` int not null default 0 comment '点赞数',
                         primary key (`id`)
) engine=innodb default charset=utf8mb4 comment='电子书';

drop table if exists `test`;
create table `test`(
    `id` bigint not null comment 'id',
    `name` varchar(50) comment 'name',
    primary key (`id`)
                   ) engine=innodb default charset=utf8mb4 comment='test';

insert into `test`(id, name) VALUES (1,'zsw');
insert into `test`(id, name) VALUES (2,'zsj');

drop table if exists `demo`;
create table `demo`(
                       `id` bigint not null comment 'id',
                       `name` varchar(50) comment 'name',
                       primary key (`id`)
) engine=innodb default charset=utf8mb4 comment='test';

insert into `demo`(id, name) VALUES (1,'zsw1');
insert into `demo`(id, name) VALUES (2,'zsj2');

drop table if exists `ebook`;
create table `ebook` (
                         `id` bigint not null comment 'id',
                         `name` varchar(50) comment '名称',
                         `category1_id` bigint comment '分类1',
                         `category2_id` bigint comment '分类2',
                         `description` varchar(200) comment '描述',
                         `cover` varchar(200) comment '封面',
                         `doc_count` int not null default 0 comment '文档数',
                         `view_count` int not null default 0 comment '阅读数',
                         `vote_count` int not null default 0 comment '点赞数',
                         primary key (`id`)
) engine=innodb default charset=utf8mb4 comment='电子书';
