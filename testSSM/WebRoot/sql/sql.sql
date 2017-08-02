select * from users;


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



insert into user(name,password,account) values('富士康','123456','cn201'),('富士康','123456','cn202'),('富士康','123456','cn203'),('富士康','123456','cn204');

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


create trigger insert_or_update_age
before insert on users
for each row 
update 
	`users`
set 
	`age`=new.id+`age`;
    
		
        
	

