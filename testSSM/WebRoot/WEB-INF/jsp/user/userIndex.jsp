<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>主页</title>
<link rel="stylesheet" type="text/css"
	href="../../../resource/css/bootstrap.css" />
<link rel="stylesheet" type="text/css"
	href="../../../resource/css/bootstrap-responsive.css" />
<link rel="stylesheet" type="text/css"
	href="../../../resource/css/style.css" />
<script type="text/javascript" src="../../../resource/js/jquery.js"></script>
<script type="text/javascript" src="../../../resource/js/bootstrap.js"></script>
<script type="text/javascript" src="../../../resource/js/ckform.js"></script>
<script type="text/javascript" src="../../../resource/js/common.js"></script>

<style type="text/css">
body {
	padding-bottom: 40px;
}

.sidebar-nav {
	padding: 9px 0;
}

@media ( max-width : 980px) { /* Enable use of floated navbar text */
	.navbar-text.pull-right {
		float: none;
		padding-left: 5px;
		padding-right: 5px;
	}
}
</style>

</head>

<body>
	<form class="form-inline definewidth m20" action="index.html"
		method="get">
		用户名称： <input type="text" name="username" id="username"
			class="abc input-default" placeholder="" value="">&nbsp;&nbsp;
		<button type="submit" class="btn btn-primary">查询</button>
		&nbsp;&nbsp;
		<button type="button" class="btn btn-success" id="addnew">新增用户</button>
	</form>
	<table class="table table-bordered table-hover definewidth m10">
		<thead>
			<tr>
				<th>用户id</th>
				<th>用户名称</th>
				<th>真实姓名</th>
				<th>最后登录时间</th>
				<th>操作</th>
			</tr>
		</thead>
		<tr>
			<td>2</td>
			<td>admin</td>
			<td>管理员</td>
			<td></td>
			<td><a href="edit.html">编辑</a></td>
		</tr>
	</table>
</body>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script type="text/javascript">
$(function () {
	$('#addnew').click(function(){
		window.location.href="register.html";
	 });
});

function del(id)
{
	if(confirm("确定要删除吗？"))
	{
		var url = "index.html";
		window.location.href=url;		
	}
}
</script>
</html>
