<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addStation.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="resource/css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="resource/css/bootstrap-responsive.css">

  </head>
  
  <body>
    <div class="container">
		<form action="${basePath}/testSSM/road/save.do" method="post">
			<div>
				<label>站点(起)</label>
				<input type="text" name="startST" placeholder="始发站">
			</div>
			
			<button type="submit" >ok</button>
		</form>
	</div>
  </body>
</html>
