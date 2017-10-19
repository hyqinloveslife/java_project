
select ff.NAME,ff.password,ff.account,ff.ADDR,ff.age,ff.id,
case when ff.gender = 1 then '男'
	when ff.gender = 2 then '女'
else '未说明性别'
end as gender,
ff.birth, ff.mail,ff.phone,
case when ff.manager = 1 then '管理员'
   when ff.manager =2 then '会员' 
   else '未说明身份' end as manager,
 case when  ff.status =1 then '有效' 
    when ff.status = 0 then '无效'
    else '未说明是否有效'
    end as status
from user ff 
where 1=1 and account like 'cn001' or name like '李' ;



insert into user(name,password,account) values('富士康','123456','cn201'),('富士康','123456','cn201'),('富士康','123456','cn201');

#用户事件表
create table userEvent( 
	id int primary key not null ,
    register_time datetime ,
    last_login_time datetime,
    user_id int
);

#文章表
create table article(
	id int primary key not null ,
    title varchar(200),
    content varchar(200),
    bg_img varchar(200),
    logo varchar(200),
    author varchar(200),
    author_id int,
    write_time datetime,
    edit_time datetime,
    apply_time datetime,
    article_type varchar(2),
    address varchar(200),
    description varchar(200),
    short_content varchar(200),
    likes int,
    dislikes int,
    commentsNum int,
    isExsit varchar(2),
    allow_copy varchar(2),
    commendId int,
    commentId int
);

#点赞事件表
create table `commend`(
	`id` int primary key not null ,
    `time` datetime ,
    `user_id` int
);



#评论事件表
create table `comments`(
	`id` int(11) primary key not null,
    `time` datetime,
    `user_id` int,
    `commentsContent` varchar(200)
);


create table `downloadRecord`(
	`id` int(11) primary key not null,
    `fileName` varchar(200),
    `filePath` varchar(200),
    `length` int(11),
    `status` varchar(2),
    `startTime` datetime,
    `endTime` datetime
);

drop table roleItem;
create table `roleItem`(
	`id` varchar(200) primary key not null,
    `name` varchar(200),
    `desc` varchar(200),
    `url` varchar(200),
    `up_role_id` varchar(200)
);
insert into roleItem (`id`,`name`,`url`,`desc`,`up_role_id`) values ('03','素材信息','jsp/user/userIndex.jsp','素材信息','0')
,('02','文件信息','jsp/user/userIndex.jsp','文件信息','0');
select * from roleItem;

##
drop table mainrole;
create table `mainRole`(
	`id` varchar(200) primary key not null,
    `homepage` varchar(200),
    `text` varchar(200)
);
select * from mainrole;
insert into mainrole (`id`,`homepage`,`text`) values('0','1','系统管理'),('1','2','知乎日报');
#########
drop table role;
create table `role`(
	`id` varchar(200) primary key not null,
    `text` varchar(200),
    `href` varchar(200),
    `up_id` varchar(200)
);
insert into role (`id`,`text`,`href`,`up_id`) values ('03','素材信息','jsp/user/userIndex.jsp','0')
,('11','文件信息1','jsp/user/userIndex.jsp','1'),('02','文件信息','jsp/user/userIndex.jsp','0')
,('12','文件信息2','jsp/user/userIndex.jsp','1');

select * from role;



drop trigger if exists `bookshop`.`insert_or_update_goods`;
delimiter $$
create trigger `bookshop`.`insert_or_update_age`
after insert on `users`
for each row begin
	
	

end;$$  
delimiter
    
select * from users;    
    
		
DROP TABLE IF EXISTS tab1;
CREATE TABLE tab1(
    tab1_id varchar(11)
);       
DROP TABLE IF EXISTS tab2;
CREATE TABLE tab2(
    tab2_id varchar(11)
);
DROP TRIGGER IF EXISTS t_afterinsert_on_tab1;
CREATE TRIGGER t_afterinsert_on_tab1 
AFTER INSERT ON tab1
FOR EACH ROW
insert into tab2(tab2_id) values(new.tab1_id);

DROP TRIGGER IF EXISTS `t_afterdelete_on_tab1`;
delimiter $$
CREATE TRIGGER  `test`.`t_afterdelete_on_tab1`
AFTER DELETE ON `tab1`
FOR EACH ROW BEGIN
      delete from tab2 where tab2_id=old.tab1_id;
END $$
delimiter ; 

INSERT INTO tab1(tab1_id) values('0001');

select * from tab1;
select * from tab2;



