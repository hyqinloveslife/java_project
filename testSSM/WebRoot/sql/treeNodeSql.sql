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
update vote_tree set url = 'http://localhost:8080/testSSM/file.html';
###

select * from vote_tree;
