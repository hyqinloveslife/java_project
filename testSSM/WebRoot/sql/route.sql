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

####站点-路线关系
create table `route2st`(
	`station_id` int,
    `route_id` int
);