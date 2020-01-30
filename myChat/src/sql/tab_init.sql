use chatroomdb;

## 建表，并且设置编码格式
drop table if exists users;
create table users(
	id int primary key not null auto_increment ,
    name varchar(50) not null comment '用户姓名',
    account varchar(50) not null comment '账号',
    psw varchar(50) not null comment '密码',
    gender varchar(4) comment '性别',
    age int comment '年龄',
    address varchar(200) comment '地址' ,
    phone varchar(20) comment '联系电话',
    email varchar(200) comment '邮箱'
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


drop table if exists news;
create table news(
	news_id int primary key not null auto_increment,
    fromperson varchar(200) not null comment '发消息的人',
    toperson varchar(200) comment '收消息的人',
    content varchar(2000) comment '内容',
    createTime date comment '时间'
) engine=innodb default charset=utf8;

##文章表
drop table if exists articles;
create table articles(
	id int primary key not null auto_increment,
    title varchar(200) not null comment '文章标题',
    users_id int not null comment '作者id',
    author varchar(200) not null comment '作者名字',
    writeTime date comment '创建时间',
    editTime date comment '修改时间',
    content varchar(2000) comment '文章内容',
    praise int default 0 comment '点赞数量',
    oppose int default 0 comment '点踩数量'
)engine=innodb default charset=utf8;

##评论表
drop table if exists comments;
create table comments(
	id int primary key not null auto_increment,
    article_id int not null comment '所属文章id',
    reply_content varchar(2000) not null comment '评论内容',
    createTime date comment '评论时间',
    users_id int not null comment '作者id',
    author varchar(200) not null comment '作者名字',
    beComented int not null comment '被评论的人的id',
	beComenter	varchar(200) not null comment '被评论的人的名字'
)engine=innodb default charset=utf8;

