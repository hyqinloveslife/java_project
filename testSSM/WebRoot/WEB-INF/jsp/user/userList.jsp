<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	System.out.println(basePath);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>用户列表</title>
<base href="<%=basePath%>">
<link rel="stylesheet" type="text/css" href="/testSSM/resource/css/bootstrap.css ">
<link rel="stylesheet" type="text/css"
	href="/testSSM/resource/css/bootstrap-responsive.css" />
<link rel="stylesheet" type="text/css"
	href="/testSSM/resource/css/style.css" />
<script type="text/javascript" src="/testSSM/resource/js/jquery.js"></script>
<script type="text/javascript" src="/testSSM/resource/js/bootstrap.js"></script>
<script type="text/javascript" src="/testSSM/resource/js/ckform.js"></script>
<script type="text/javascript" src="/testSSM/resource/js/common.js"></script>

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
	<!-- ${basePath}/testSSM/user/queryUserList.do -->
	<form class="form-inline definewidth m20" action="/testSSM/user/queryUserList.do" 
		method="post">
		用户名称： <input type="text" name="username" id="username"
			class="abc input-default" placeholder="请输入账号或姓名" value="">&nbsp;&nbsp;
		<button type="submit" class="btn btn-primary">查询</button>
		&nbsp;&nbsp;
		<button type="button" class="btn btn-success" id="addnew">新增用户</button>
	</form>
	<table class="table table-bordered table-hover definewidth l30">
		<thead>
			<tr>
				<th>操作</th>
				<th>用户账号</th>
				<th>用户密码</th>
				<th>真实姓名</th>
				<th>身份证</th>
				<th>性别</th>
				<th>年龄</th>
				<th>电话</th>
				<th>邮箱</th>
				<th>地址</th>
				<th>状态</th>
				<th>身份</th>
			</tr>
		</thead>
		
		<c:forEach var="item" items="${users}">
			<tr>
				<td> 
					<a class="btn btn-small btn-danger" onclick="remove('${item.id}','${item.account}')">删除</a> 
					<a class="btn btn-small btn-primary" onclick="modify('${item.id}','${item.account}')"
					    data-toggle="modal" data-target="#myModal">修改</a>
					<%-- <input type="button" value="删除" id="remove"  onclick="remove('${item.id}','${item.account}')">  --%>
					<%-- <input type="button" value="修改" id="modify"  onclick="modify('${item.id}','${item.account}')">  --%>
				</td>
				<td> ${item.account} </td>
				<td> ${item.password} </td>  
				<td> ${item.password} </td>
				<td> ${item.identifyNo} </td>
				<td> ${item.gender} </td>
				<td> ${item.age} </td>
				<td> ${item.phone} </td>
				<td> ${item.mail} </td>
				<td> ${item.addr}</td>
				<td> ${item.status} </td>
				<td> ${item.manager} </td>
			</tr> 
		</c:forEach>
	</table>
	
	<!-- <a class="btn btn-small btn-primary" data-toggle="modal" title="tooltip" 
		data-placement="right"  data-target="#myModal">OPEN</a> -->
	<div class="modal fade" id="myModal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">修改</h4>
				</div>
				<div class="modal-body">
					<!-- 此处自己写原生的代码最好 -->
				</div>
				<div class="modal-header">
					<button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
					<button type="submit" class="btn btn-primary" >OK</button>
				</div>
			</div>
			
			
		</div>
	</div>
</body>
<script type="text/javascript">
$(function () {
	
});

//删除
function remove(id,account){
	var url="http://localhost:8080/testSSM/user/remove.do";
	var data="id="+id;
    if(window.confirm("是否要删除"+account)){
		$.ajax({
			url:url,
			data:data,
			type:"post",
			success:function(json){
				if(json==1){
					alert("删除成功");
					
				}else{
					alert("删除失败");
					
				}
			},
			error:function(){
				alert("删除失败");
			}		
		});
		window.location.reload();
    }
	
}
//修改
function modify(id,account){
	if(window.confirm("是否要修改"+account)){
		
	}
}
</script>
</html>
