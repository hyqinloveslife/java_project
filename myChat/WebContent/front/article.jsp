<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
	System.out.println(basePath);
%>	
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>标题</title>
</head>
<body>
	<h1>一个Servlet处理多个请求</h1>
	<hr>
	<a href="<%=basePath %>queryArticle?method=findArticle">查询员工信息</a>
	<br />
	<br />
	<a href="<%=basePath %>queryArticle?method=addArticle">新增员工信息</a>
	<br />
	<br />
	<a href="<%=basePath %>queryArticle?method=deleteArticle">删除员工信息</a>
	<br />
	<br />
	<a href="<%=basePath %>queryArticle?method=updateArticle">修改员工信息</a>
	<br />
	<br />
	<a href="<%=basePath %>queryArticle?method=listArticle">查询所有员工信息</a>
</body>
</html>