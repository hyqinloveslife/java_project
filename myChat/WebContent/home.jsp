<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base target="_self">
<title>聊天室首页</title>
<style>
	.header{
		height: 50px;background: gray;font-size: 16px;color: black;line-height: 50px;
		padding-left: 20px;font-family: 微软雅黑;
	}
	#newsDisplay{
		height: 400px;width: 100%;
	}
	#sendNews{
		height: 100px;width: 100%;
	}
	.news{
		width: 100%;height: 60px;outline: none;border: groove;border-radius: 10px;
	}
	.sure{
		float: right;margin-right: 10px;
	}
	input.btn{
        width: 100px;height: 30px;border-radius: 10px;border: none;
    }
</style>
</head>
<body>
<%request.setCharacterEncoding("utf-8"); %>
	<div class="header">
		欢迎 <%=session.getAttribute("userName") %> 
		<span style="margin-left: 20px;color: red;"> <%=session.getAttribute("nickName") %> </span>
	</div>
	<iframe id="newsDisplay" src="newsDisplay.jsp"></iframe>
	<form action="newsHandler" method="post">
		<input class="news" type="text" value="" name="content" placeholder="请输入内容"><br>
		<input class="btn sure" type="reset">
		<input class="btn sure" type="submit">
	</form>
</body>
</html>