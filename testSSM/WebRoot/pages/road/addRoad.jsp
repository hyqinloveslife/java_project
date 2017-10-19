<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">

<title>站点新增</title>

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
				<label>路线名称</label>
				<input type="text" name="route_name" placeholder="路线名称">
			</div>
			<div>
				<label>站点(起)</label>
				<input type="text" name="startST" placeholder="始发站">
			</div>
			<div>
				<label>站点(终)</label>
				<input type="text" name="endST" placeholder="终点站">
			</div>
			<div>
				<label>票价</label>
				<input type="text" name="price" placeholder="票价">
			</div>
			<div>
				<label>站点数</label>
				<input type="number" name="stNumber" placeholder="站点数">
			</div>
			<div>
				<label>初始时间</label>
				<input type="time" name="startTime" placeholder="起始时间">
			</div>
			<div>
				<label>结束时间</label>
				<input type="time" name="endTime" placeholder="结束时间">
			</div>
			<div>
				<label>车辆类型</label>
				<select name="type">
					<option value="1">普通</option>
					<option value="2">一般</option>				
				</select>
			</div>
			<button type="submit" >ok</button>
		</form>
	</div>
</body>
</html>
