<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>注册</title>
<style>
	.regi{
		min-width: 300px;
		margin: 50px auto;
		text-align: center;
	}
	.regi input{
		margin-top: 10px;
	}
	*{margin: 0;padding: 0;}
    body{
       background: url("img/bg.jpg") center;
    }
    .content{
        max-width: 350px;
        background: #f5deb3;
        border-radius: 10px;
        margin: 50px auto;
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
        width: 220px;height: 40px;border-radius: 10px;font-size: 16px;outline: none;border: none;
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
		margin: 0px auto;
		text-align: center;
	}
	.toCenter a{text-decoration: none;}
</style>
</head>
<body>
<%request.setCharacterEncoding("utf-8"); %>
	<div class="content">
	<p class="log-title">注册</p>
		<form action="Register" method="post">
			<p>请输入账号：<input class="typing" type="text" value="" name="account" placeholder="请输入账号"/></p>
			<p>请输入密码：<input class="typing" type="password" value="" name="password" placeholder="请输入密码"/></p>
			<p>请输入姓名：<input class="typing" type="text" value="" name="name" placeholder="请输入姓名"/></p>
			<p>请输入年龄：<input class="typing" type="text" value="" name="age" placeholder="请输入年龄"/></p>
			<p>请输入性别：<input class="typing" type="text" value="" name="gender" placeholder="请输入性别"/></p>
			<p>请输入地址：<input class="typing" type="text" value="" name="address" placeholder="请输入地址"/></p>
			<input class="btn sure" type="submit">
			<input class="btn" type="reset">
		</form>
		<p class="toCenter"> <a href="index.jsp" >已经有账号了？登录</a></p>
	</div>
</body>
</html>