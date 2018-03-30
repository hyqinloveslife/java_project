<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>login</title>
<style type="text/css">
html {
	width: 100%;
	height: 100%;
	overflow: hidden;
	font-style: sans-serif;
}

body {
	width: 100%;
	height: 100%;
	font-family: 'Open Sans', sans-serif;
	margin: 0;
	background-color: #4A374A;
}

#login {
	position: absolute;
	top: 50%;
	left: 50%;
	margin: -150px 0 0 -150px;
	width: 300px;
	height: 300px;
}

#login h1 {
	color: #fff;
	text-shadow: 0 0 10px;
	letter-spacing: 1px;
	text-align: center;
}

h1 {
	font-size: 2em;
	margin: 0.67em 0;
}

input {
	width: 278px;
	height: 40px;
	margin-bottom: 10px;
	outline: none;
	padding: 10px;
	font-size: 13px;
	color: #fff;
	text-shadow: 1px 1px 1px;
	border-top: 1px solid #312E3D;
	border-left: 1px solid #312E3D;
	border-right: 1px solid #312E3D;
	border-bottom: 1px solid #56536A;
	border-radius: 4px;
	background-color: #2D2D3F;
}

.but {
	width: 280px;
	min-height: 20px;
	display: block;
	background-color: #4a77d4;
	border: 1px solid #3762bc;
	color: #fff;
	padding: 9px 14px;
	font-size: 15px;
	line-height: normal;
	border-radius: 5px;
	margin: 0;
}
.but2 {
	width: 280px;
	min-height: 20px;
	display: block;
	background-color: #4a77d4;
	border: 1px solid #3762bc;
	color: #fff;
	padding: 9px 14px;
	font-size: 15px;
	line-height: normal;
	border-radius: 5px;
	margin: 20 0 0 0;
}
</style>
</head>

<body>
	<div id="login">
		<h1>Login</h1>
		<form method="post" action="${basePath}/testSSM/user/login.do">
			<input type="text" required="required" placeholder="用户名" name="account"></input>
			<input type="password" required="required" placeholder="密码" name="password"></input>
			<div style="color: red;">${flag}</div>
			<button class="but" type="submit">登录</button>
			<button class="but2" type="button" onclick="register()" >注册</button>
		</form>
	</div>
</body>
<script type="text/javascript">
function register(){
	var url="register.jsp";
	location.href=url;
}



</script>
</html>
