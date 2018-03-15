create table `vote_tree`  
(  
   `id` int not null,  
   `text` varchar(50) not null,  
   `pid`  int        
); 

insert into vote_tree values(1,'功能菜单',0);  
insert into vote_tree values(2,'系统管理',1);  
insert into vote_tree values(3,'用户管理',1);  
insert into vote_tree values(4,'个人信息',3);  
insert into vote_tree values(5,'投票记录',3);  
insert into vote_tree values(6,'投票管理',1);  
insert into vote_tree values(7,'维护',6);  
insert into vote_tree values(8,'发布新投票',6);  
insert into vote_tree values(9,'所有投票',6);  


select * from vote_tree for update;

select min(id) from vote_tree;

select * from vote_tree where id = 1;


select * from vote_tree where pid = 6;

select min(level) from vote_tree  ;

####
update vote_tree set level=0 where id = 1;
update vote_tree set level= 1 where pid = 1;
update vote_tree set level = 2 where pid in(3,6);
update vote_tree set icon = 'icon-sys';
update vote_tree set url = 'http://localhost:8080/testSSM/pages/menu/menuIndex.html' where pid = 3;
###

select * from vote_tree where levels = 2;


select v1.id,v1.text,v1.pid,v1.levels,v1.url,v2.text as pid_text
from vote_tree v1,vote_tree v2
where v1.pid = v2.id
order by pid,id
limit 20;

##################################################################
select * from downloadrecord;



################     20180312      ################################################
#角色表
drop table if exists role;
create table `role`(
	`role_id` int primary key not null auto_increment comment '主键ID',
    `name` varchar(200) comment '角色名',
    `desc` varchar(200) comment '角色描述'
)comment '角色表';

#权限表
drop table if exists permission;
create table `permission`(
	`permission_id` int auto_increment primary key not null comment '主键ID',
    `name` varchar(200) comment '权限名',
    `url` varchar(200) comment '权限路径'
)comment '权限表';

#权限映射表
drop table if exists role_permission;
create table `role_permission`(
	`r_p_id` int auto_increment not null primary key comment '权限映射角色表主键ID',
    `role_id` int not null comment '角色主键ID',
    `permission_id` int not null comment '权限主键ID'
) comment '权限映射角色表';

#人员映射表
drop table if exists sys_user_role;
create table `sys_user_role`(
	`id` int auto_increment not null primary key comment '人员映射表主键ID',
    `user_id` int not null comment '人员主键ID',
    `role_id` int not null comment '角色主键ID',
    `desc` varchar(200)
)comment '人员角色映射表';




##################################################################################











