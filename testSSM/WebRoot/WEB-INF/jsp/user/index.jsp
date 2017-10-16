<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	Object user=request.getSession().getAttribute("user");
	request.getSession().setAttribute("user", user);
	System.out.println("user : "+user);
	System.out.println("path : "+application.getRealPath(request.getRequestURI()));
%>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>之乎日报</title>
<link href="../resource/assets/css/dpl-min.css" rel="stylesheet" type="text/css" />
<link href="../resource/assets/css/bui-min.css" rel="stylesheet" type="text/css" />
<link href="../resource/assets/css/main-min.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css"
	href="../resource/css/bootstrap.css" />
<link rel="stylesheet" type="text/css"
	href="../resource/css/bootstrap-responsive.css" />
<link rel="stylesheet" type="text/css"
	href="../resource/css/style.css" />
</head>
<body>
	<div class="dl-title">
		<!-- <img src="/chinapost/Public/assets/img/top.png"> -->
		
	</div>

	<div class="dl-log">
		欢迎您，<span class="dl-log-user">${user}</span>
		<a href="#" title="退出系统" class="dl-log-quit">[退出]</a>
	</div>
	</div>
	<div class="content">
		<div class="dl-main-nav">
			<div class="dl-inform">
				<div class="dl-inform-title">
					<s class="dl-inform-icon dl-up"></s>
				</div>
			</div>
			<ul id="J_Nav" class="nav-list ks-clear">
				<li class="nav-item dl-selected"><div
						class="nav-item-inner nav-home">系统管理</div></li>
				<li class="nav-item dl-selected"><div
						class="nav-item-inner nav-order">业务管理</div></li>

			</ul>
		</div>
		<ul id="J_NavContent" class="dl-tab-conten">

		</ul>
	</div>
	<script type="text/javascript" src="../resource/assets/js/jquery-1.8.1.min.js"></script>
	<script type="text/javascript" src="../resource/assets/js/bui-min.js"></script>
	<script type="text/javascript" src="../resource/assets/js/common/main-min.js"></script>
	<script type="text/javascript" src="../resource/assets/js/config-min.js"></script>
	<script>
	var webUrl = "http://localhost:8080/testSSM/";
		BUI.use('common/main', function() {
			var config = [ {
				id : '1',
				menu : [ {
					text : '系统管理',
					items : [ {
						id : '12',
						text : '机构管理',
						href : webUrl+'pages/home.html'
					}, {
						id : '3',
						text : '角色管理',
						href : 'jsp/user/userIndex.jsp'
					}, {
						id : '4',
						text : '用户管理',
						href : '${basePath}/testSSM/user/userList.do'
					}, {
						id : '6',
						text : '菜单管理',
						href : '#'
					} ]
				} ]
			}, {
				id : '7',
				homePage : '9',
				menu : [ {
					text : '业务管理',
					items : [ {
						id : '9',
						text : '查询业务',
						href : '/resource/Node/index.html'
					} ]
				} ]
			} ];
			new PageUtil.MainPage({
				modulesConfig : config
			});
		});
	</script>
</body>

</html>