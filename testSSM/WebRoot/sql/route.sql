select * from route;

create table `route`(
	`id` int not null primary key
);

alter table `route` add column `name` varchar(20);
alter table `route` add column `startTime` time ; 
alter table `route` add column `endTime` time;
alter table `route` add column `type` varchar(2);
alter table `route` add column `startST` varchar(200);
alter table `route` add column `endST` varchar(200);
alter table `route` add column `price` int;
alter table `route` add column `stNumber` int;
alter table `route` add column `useTime` time;

###站点表
create table `station`(
	`id` int primary key,
    `name` varchar(200),
    `useTime` time
);
alter table `station` add column `isUse` varchar(2);

create table `station_event`(
	`event_id` int primary key not null,
    `station_id` int,
    `createTime` time,
    `createMan` varchar(20),
    `modifyTime` time,
    `modifyMan` varchar(20),
    `checkTime` time,
    `checkMan` varchar(2),
    `checkFlag` varchar(2)
);

create table `route_event`(
	`event_id` int primary key not null  comment '路线新增事件id',
    `route_id` int not null comment '路线id',
    `createTime` time comment '新增时间',
    `createMan` varchar(20) comment '创建人',
    `modifyTime` time comment '修改时间',
    `modifyMan` varchar(20) comment '修改人',
    `checkTime` time comment '审核时间',
    `checkMan` varchar(2) comment '审核人',
    `checkFlag` varchar(2) default 0 comment '审核标志'
);

####站点-路线关系
create table `route2st`(
	`station_id` int,
    `route_id` int
);



select * from route;
select * from station;
select * from station_event;
