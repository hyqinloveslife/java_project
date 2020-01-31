<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<%
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";

%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>list article</title>
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<style type="text/css">
	.container{
		width: 40%;
		margin: 0 auto;
	}
	.layout-header{
		height: 60px;
		display: flex;
		flex-direction: row;
	}
	.layout-header .icon{
		flex: auto;
	}
	.layout-header .opt{
		width: 50px;
	}
	
	.layout-header #hideContent{
		width: 100px;
		background: red;
		display: none;
	}
	
	.layout-header .icon img{
		width: 60px;
		height: 60px;
		border-radius: 30px;
		flex: 80px;
	}
	.layout-header .icon .icon-desc{
		flex: auto;
		/* line-height: 100px; */
		padding: 0 0 0 20px;
	}
	
	.opt img{
		width: 24px;
		height: 24px;
	}
	
	.dropdown .dropdown-menu{
		/* 屏蔽某个css的某个属性，设置为initail !important */
		position: initial  !important;
	} 
	.layout-main{
		padding: 10px 0 0 0 ;
	}
	.layout-main .content{
		font-family: punctuation,"PingFangSC-Regular","Microsoft Yahei","sans-serif";
		font-size: 16px;
		line-height: 24px;
		color: #000;
	}
	
	.layout-footer{
		padding: 10px 0 0 0;
	}
	.layout-footer .browse{
		display: flex;
		height: 30px;
		line-height: 30px;
	}
	.layout-footer .browse .left-zone{
		flex: 1;
	}
	.layout-footer .browse .right-zone{
		flex: 1;	
		display:flex;
		flex-direction: row-reverse;
	}	
	.layout-footer .browse .left-zone span{
		color: #777;
		margin: 0 10px 0 0;
	}
	.layout-footer .browse .right-zone img{
		width: 24px;
		height: 24px;
		margin: 0 10px 0 0;
	}
	
	/* 设置分割线 */
	hr{
		margin-left: 20px;
		margin-right: 20px;
		margin-top: 10px !important;
		margin-bottom: 10px !important;
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
							<p style="color: #777;">
								<c:out value="${a.editTime}" default="00:00"></c:out>
							</p> 
						</div>
					</div>
				</div>
				
				<div class="opt dropdown">
					<button type="button" class="btn dropdown-toggle" id="dropdownMenu1" 
							data-toggle="dropdown">
						<span class="caret"></span>
					</button>
					<ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
						<li role="presentation">
							<a role="menuitem" tabindex="-1" href="#">收藏</a>
						</li>
						<li role="presentation">
							<a role="menuitem" tabindex="-1" href="#">举报</a>
						</li>
						<li role="presentation">
							<a role="menuitem" tabindex="-1" href="#">屏蔽</a>
						</li>
					</ul>
				</div>
			</div>
			<div class="layout-main">
				<span class="content">
					<c:out value="${a.content}" default="默认内容"></c:out>
				</span>
			</div>
			<div class="layout-footer">
				<!-- 浏览数，点赞数，点踩数 -->
				<div class="browse"> 
					<div class="left-zone">
						<span>点赞
							<c:out value="${a.praise}" default="0"></c:out>
						</span>
						<span>踩
							<c:out value="${a.oppose}" default="0"></c:out>
						</span>
					</div>
					<div class="right-zone">
						<a href="#" class="tooltip-test" data-toggle="tooltip" title="评论">
							<img alt="" src="${basePath}img/comment.png">
						</a>
						<a href="#" class="tooltip-test" data-toggle="tooltip" title="反对">
							<img alt="" src="${basePath}img/oppose.png">
						</a>
						<a href="#" class="tooltip-test" data-toggle="tooltip" title="点赞">
							<img alt="" src="${basePath}img/praise.png">
						</a> 
					</div>
				</div>
				<hr>
				<!-- 点赞人数显示  这里使用flex的流式布局 -->
				<div class="praise">
					
				</div>
				
				<!-- 评论显示 -->
				<div>
					
				</div>
			</div>
		</c:forEach>
	</div>
	
<script type="text/javascript">
	
	$(document).on('mouseenter','.opt img',function(){
		console.log('来装逼啦');
		$('.layout-header #hideContent').css('display','flex');
		$('.layout-header #hideContent').css('flex-direction','column');
	}).on('mouseleave','.opt img',function(){
		console.log('装完逼就跑啦');
		$('.layout-header #hideContent').css('display','none');
	})

</script>	
</body>
</html> 