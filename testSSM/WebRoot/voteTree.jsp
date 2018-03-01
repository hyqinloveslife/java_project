<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>生成菜单树</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!-- 在线资源引用，需要联网 -->
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jstree/3.2.1/themes/default/style.min.css" />	

	<script type="text/javascript" src="resource/js/jquery.js"></script>
	<script type="text/javascript" src="resource/js/jstree.js"></script>
  </head>
  
  <body>
    <div id="tree"></div>
  </body>
  <script type="text/javascript">
  var data = [{"id":"1", "text":"首页","a_attr":{"href":"http://www.baidu.com","text":"链接到百度"}
  									  ,"li_attr":{"href":"http://www.baidu.com","text":"链接到百度"}
  			  },
              {"id":"2", "text":"新闻"
              ,"children":[{"id":"3", "text":"新闻1"}
	  			          ,{"id":"3", "text":"新闻2"}]
  			  ,"state":{"opened":false,"disabled":false,"selected":true}}
	  ];

	
 /*  $(function(){
	var data = getTree();
	
	$('#tree').jstree({
		plugins: ["contextmenu"],
		'core':{
			  'data':data
		},
		 "contextmenu": {
             "items": {
                 "create": null,
                 "rename": null,
                 "remove": null,
                 "ccp": null,
                 "add": {
                     "label": "add",
                     "action": function (obj) {
                         alert("add operation--clickedNode's id is:" + obj);
                     }
                 },
                 "delete": {
                     "label": "delete",
                     "action": function (obj) {
                         alert("add operation--clickedNode's id is:" + obj);
                     }
                 }
             }
         }
	})
  }); */


  $(function(){
	  $.ajax({
			type : 'GET',
			url : '${basePath}/testSSM/menu/tree.do',
			success : function(json) {
				//console.log(json.data[0].children);
				message = json.data[0];
				//message = JSON.stringify(message);
				$('#tree').jstree({
					plugins: ["contextmenu"],
					'core':{
						'data':message
					},
					"contextmenu": {
			             "items": {
			                 "create": null,
			                 "rename": null,
			                 "remove": null,
			                 "ccp": null,
			                 "add": {
			                     "label": "add",
			                     "action": function (obj) {
			                         alert("add operation--clickedNode's id is:" + obj);
			                     }
			                 },
			                 "delete": {
			                     "label": "delete",
			                     "action": function (obj) {
			                         alert("add operation--clickedNode's id is:" + obj);
			                     }
			                 }
			             }
			         }
				});
			}
		});

  });	
  </script>
</html>
