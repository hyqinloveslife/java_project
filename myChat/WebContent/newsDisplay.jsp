<%@page import="bean.News"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%request.setCharacterEncoding("gb2312"); %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>消息展示</title>
<script src="http://apps.bdimg.com/libs/jquery/1.10.2/jquery.min.js"></script>
</head>
<body>
	<!-- el表达式 -->
	<c:forEach items="${news}" var="a">
		<p>
			<span style="color: red;">${a.fromPerson }</span>
			<span>@ ${a.toPerson }</span> 
			<p style="min-height: 50px;">
				<span style="margin-left: 30px;max-width: 500px;border-radius:3px;min-height: 45px;line-height: 45px;">${a.content}</span>  
				<span style="float: right;">${a.sendTime }</span>
			</p>  
		</p>
		<hr>
	</c:forEach>
	
	<script>
		var mHeight=$(window).height();
		
		console.log(mHeight);
		$(function(){
			back2bottom();
		})
		function back2bottom(){
			$('html,body').animate({
				scrollTop:mHeight*mHeight
			},800)
		}
	</script>
</body>
</html>