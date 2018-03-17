<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    
    <title>文件管理列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="../../resource/ezui-js/themes/default/easyui.css">
	<link rel="stypeshett" type="text/css" href="../../resource/ezui-js/themes/icon.css">
	<script type="text/javascript" src="../../resource/js/jquery.js"></script>
	<script type="text/javascript" src="../../resource/ezui-js/jquery.easyui.min.1.2.2.js"></script>
	<script type="text/javascript" src="../../resource/ezui-js/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="../../resource/js/demo/times.js"></script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>   <!-- url="/testSSM/user/files.do" -->
    <table class="easyui-datagrid" id="tt" url="/testSSM/user/files.do" title="文件列表" toolbar="#tb"
    	iconCls="icon-save" rownumbers="true" pagination="true" method="get" style="height: 500px;"
    	>
    	<thead>
	    	<tr>
				<th field="ck"  checkbox="true"></th>
				<th field="id" width="50" sortable="true">ID</th>
				<th field="fileName" width="150" align="center">文件名称</th>
				<th field="filePath" width ="380">文件目录</th>
				<th field="length" width="100" align="center">文件大小</th>
				<th field="startTime" formatter="dateFormatter" width="100">上传时间</th>
				<th field="type" width="100" >文件类型</th>
				
				<th field="operate" width="100" formatter="option_function" >操作</th>
			</tr>
		</thead>
		<div id="tb" style="padding:3px">
			<span>文件ID：</span> <input id="search_NAME" class="easyui-textbox" style="line-height:20px;border:1px solid #ccc"> 
			<span>文件类型：</span> <input id="search_TYPE" style="line-height:20px;border:1px solid #ccc">
			<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="doSearch()">查找</a> 
			<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="deleteFile()">删除</a>
		</div>	
    </table>
    
    <script type="text/javascript">
		var rootPath = "http://localhost:8080/testSSM";
		
		function doSearch() {
			$('#tt').datagrid('load', {
				文件ID : $('#id').val(),
				文件名称 : $('#text').val()
			});
		}

		function dateFormatter(value,obj,index){
			//console.log(value);
			if(value == undefined){
				return "";
			}
			var date = new Date(value);
			var times = date.getFullYear()+"/"+(date.getUTCMonth() +1)+"/"+date.getDate();
			//date  = date.Format("yyyy/mm/dd")
			return times;
		}
		
		function del(index) {
			$('#tt').datagrid('selectRow', index);
			var row = $('#tt').datagrid('getSelected');
			//alert(row.id);
			$.messager.confirm('提示', '确定要删除吗?', function(r) {
				if (r) {
					$.ajax({
						url : rootPath+"/user/removeFile.do?id="
								+ row.id,
						type : "POST",
						dataType : "json",
						success : function(result) {
							alert(result.other.message);
							//alert("删除成功！");
							$("#tt").datagrid("reload")
						},
						error : function() {
							alert("ERROR");
						}
					});
				}
			});
		}

		function deleteFile() {
			var ids = [];
			var rows = $('#tt').datagrid('getSelections');
			for ( var i = 0; i < rows.length; i++) {
				ids.push(rows[i].id);
			}
			alert(ids.join('\n'));
			var count = 0;
			$.messager.confirm('提示', '确定要删除吗?', function(r) {
				if (r) {
					for ( var i = 0; i < rows.length; i++) {
						$.ajax({
							url : rootPath+"/user/removeFile.do?id="
									+ rows[i].id,
							type : "POST",
							dataType : "json",
							success : function(result) {
								count++;
							},
							error : function() {
								alert("ERROR");
							}
						});
					}
					if(count==rows.length){
						alert("删除成功");
					}
				}
				$("#tt").datagrid("reload");
			});

		}
		//文件下载查看
		function down(index){
			$('#tt').datagrid('selectRow', index);
			var row = $('#tt').datagrid('getSelected');
			var realPath = row.filePath;
			var strs = realPath.split('\\');
			var fileName = strs[strs.length-1];
			//alert(fileName);
			var data ={fileName:fileName,realPath:realPath} 
			//文件下载为什么不能用异步提交？
			var url = encodeURI(rootPath+"/user/download.do?fileName="+fileName+"&realPath="+realPath);
			window.location.href = url;
			/* $.ajax({
				type: "post",
				data:data,
				url: rootPath+"/user/download.do",
				async: true,
				dataType: "json",
				success: function(result){
					console.log(result);
					alert(result.other.message);
				},
				error: function(){
					alert("请求出错");
				}
			}); */
		}

		function show(index){
			$('#tt').datagrid('selectRow', index);
			var row = $('#tt').datagrid('getSelected');
			var filePath = row.filePath;
			var strs = filePath.split('\\');
			var name = strs[strs.length-2]+'/'+strs[strs.length-1]
			/* alert(strs[strs.length-2]+'/'+strs[strs.length-1]);
			return; */
			var filePath = encodeURI(rootPath+'/' + name);  
			
			//window.open(filePath,"","height=200","width=300","top="+top+",left="+left);
			openWindow(filePath, 400, 500);
		} 
		
		function openWindow(url,h,w){
			var left=Math.round((window.screen.availWidth-w)/2);
    		var top=Math.round((window.screen.availHeight-100-h)/2);
			window.open(url,"","height="+h+",width="+w+",top="+top+",left="+left);
		}
		
		function option_function(val, obj, index) {
			return '<a href="#" onclick="show(' + index + ')">查看</a>&nbsp;'+
					'<a href="#" onclick="down(' + index + ')">下载</a>&nbsp;'+
					'<a href="#" onclick="del(' + index + ')">删除</a>';
		}

		function getData(){
			var rows = [];
			for(var i=1; i<=800; i++){
				var amount = Math.floor(Math.random()*1000);
				var price = Math.floor(Math.random()*1000);
				rows.push({
					id: 'Inv No '+i,
					startTime: $.fn.datebox.defaults.formatter(new Date()),
					fileName: 'Name '+i,
					type: amount,
					filePath: price,
					length: amount*price,
					status: 'Note '+i
				});
			}
			
			return rows;
		}
		//客户端分页	
		function pagerFilter(data){
			
			if (typeof data.length == 'number' && typeof data.splice == 'function'){	// is array
				data = {
					total: data.length,
					rows: data
				}
			}
			var dg = $(this);
			var opts = dg.datagrid('options');
			var pager = dg.datagrid('getPager');
			pager.pagination({
				onSelectPage:function(pageNum, pageSize){
					opts.pageNumber = pageNum;
					opts.pageSize = pageSize;
					pager.pagination('refresh',{
						pageNumber:pageNum,
						pageSize:pageSize
					});
					dg.datagrid('loadData',data);
				}
			});
			if (!data.originalRows){
				data.originalRows = (data.rows);
			}
			var start = (opts.pageNumber-1)*parseInt(opts.pageSize);
			var end = start + parseInt(opts.pageSize);
			data.rows = (data.originalRows.slice(start, end));
			return data;
		}
		
		$(function(){
			
			 //设置分页控件 
		    var p = $('#tt').datagrid('getPager'); 
		    $(p).pagination({ 
		        pageSize: 10,//每页显示的记录条数，默认为10 
		        pageList: [5,10,15],//可以设置每页记录条数的列表 
		        beforePageText: '第',//页数文本框前显示的汉字 
		        afterPageText: '页    共 {pages} 页', 
		        displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录', 
		    });  
			
			//$('#tt').datagrid({loadFilter:pagerFilter}).datagrid('loadData', getData());
		});
	</script>
  </body>
</html>
