<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<%
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";

	Object obj = session.getAttribute("articles");
	System.out.println(obj);

%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>list article</title>
<style type="text/css">
	.container{
		width: 80%;
		margin: 0 auto;
	}
	.layout-header{
		height: 100px;
		display: flex;
		flex-direction: row;
	}
	.layout-header .icon{
		margin : 0 0 0 50px;
		flex: auto;
	}
	.layout-header .opt{
		width: 50px;
		margin: 0 50px 0 0 ;
	}
	.layout-header .icon img{
		width: 80px;
		height: 80px;
		border-radius: 40px;
		flex: 80px;
	}
	.layout-header .icon .icon-desc{
		flex: auto;
		/* line-height: 100px; */
		padding: 0 0 0 20px;
	}
</style>
</head>
<script type="text/javascript">
	

</script>
<body>
	<div class="container">
		<h1>你的QQ空间</h1>
		<c:forEach items="${articles}" var="a" >
			<div class="layout-header">
				<div class="icon">
					<div style="display: flex;width: 300px;direction: row;">
						<div class="icon-img">
							<img alt="图片消失了" src="${basePath}img/100.jpg" >
						</div>
						<div class="icon-desc">
							<p>
								<c:out value="${a.author}" default="默认名字"></c:out>
							</p>
							<p>
								<c:out value="${a.editTime}" default="00:00"></c:out>
							</p> 
						</div>
					</div>
				</div>
				<div class="opt">
					opt
				</div>
			</div>
			<div class="layout-main">
				<span>
					<c:out value="${a.content}" default="默认内容"></c:out>
				</span>
			</div>
			<div class="layout-footer">
				
			</div>
		</c:forEach>
	</div>
</body>
</html> 