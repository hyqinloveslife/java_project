<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>聊天室首页 </title>
<style>
	*{margin: 0;padding: 0;}
    body{
       background: url("img/bg.jpg") center;
    }
    .content{
        max-width: 350px;
        background: #f5deb3;
        border-radius: 10px;
        margin: 100px auto;
        text-align: center;
        padding: 30px 0;
    }
    .log-title{
        height: 40px;line-height: 40px;font-family: 微软雅黑;font-size: 22px;
    }
    .content input{
        margin: 10px 0;
    }
    input.typing{
        width: 280px;height: 40px;border-radius: 10px;font-size: 16px;outline: none;border: none;
        padding-left: 5px;
    }
    input.btn{
        width: 100px;height: 30px;border-radius: 10px;border: none;
    }
    .sure{
        background: #0ff;
    }
    /*css3动画效果*/
    .snow{
        position: fixed;
        top:0;left: 50%;
    }
	.login{
		min-width: 300px;
		margin: 50px auto;
		text-align: center;
	}
	.toCenter{
		min-width: 300px;
		margin: 50px auto;
		text-align: center;
	}
	.toCenter a{text-decoration: none;}
</style>
</head>
<body>
	<div class="content">
	<p class="log-title">登录</p>
		<form action="ChatServlet" method="post">
			<p> 账号：<input class="typing" type="text" value="" name="account" placeholder="请输入账号"></input> </p>
			<p> 密码：<input class="typing" type="password" value="" name="password" placeholder="请输入密码"></input></p>
			<input class="btn sure" type="submit">
			<input class="btn" type="reset">
		</form>
		<p class="toCenter"> <a href="register.jsp" >没有账号？那么先注册吧！</a></p>
	</div>
</body>
</html>