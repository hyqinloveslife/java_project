<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
				<label>站点(起)</label>
				<input type="text" name="startST" placeholder="始发站">
			</div>
			
			<button type="submit" >ok</button>
			<button id="btnAdd">add</button>
		</form>
	</div>
  </body>
  <script type="text/javascript" src="../../resource/js/jquery.js"></script>
  <script type="text/javascript">
  var count=0;
	$('#btnAdd').on('click',function(){
		var _html = '';
		_html += '<div>';
		_html +='<input type = "text"  name = "station'+count+'" placeholder = "station" />';
		_html +='<button onclick="btnRemove(this)">remove</button>';
		_html +='</div>'
		$('#section').append(_html);
		count++;
	});
	
	$('#ok').on('click',function(){
		var arry = new Array();
		var els = document.getElementsByName("station");
		for (var i=0;i<els.length;i++) {
			//alert(els[i].value);
			arry.push(els[i].value);
		}
		alert(arry);
	});
	
	function btnRemove(data){
		data.parentNode.remove(data);
	}
  </script>
</html>
