<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	System.out.println("basePath : " + basePath);
	System.out.println("path : " + path);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../../../resource/css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="../../../resource/css/bootstrap-responsive.css" />
<link rel="stylesheet" type="text/css" href="../../../resource/css/style.css" />
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
<title>login</title>
</head>
<body>
	<form action="${basePath}/testSSM/user/register.do" method="post" class="definewidth m20">
		<table class="table table-bordered table-hover definewidth m10">
			<tr>
				<td width="10%" class="tableleft">登录名</td>
				<td><input id="account" type="text" name="account" onblur="validate()" /></td>
				<td> <div class="error"></div> </td>
			</tr>
			<tr>
				<td class="tableleft">密码</td>
				<td><input type="password" name="password" /> <span>*请输入6-16位密码</span> </td>
				<td> <div class="error_pwd"></div> </td>
			</tr>
			<tr>
				<td class="tableleft">真实姓名</td>
				<td><input type="text" name="name" /></td>
				<td> <div class="error_name"></div> </td>
			</tr>
			<tr>
				<td class="tableleft">身份证号码</td>
				<td><input id="identifyNO" type="text" name="identifyNO" onblur="validateIdentify()" /> <span>*请输入身份证号</span></td>
				<td> <div class="error_id"></div> </td>
			</tr>
			<tr>
				<td class="tableleft">性别</td>
				<td>
					<select id="gender" name="gender">
						<option value="1">男</option>
						<option value="2">女</option>
						<option value="3">保密</option>
					</select> 
				</td>
				<td> <div class="error_gender"></div> </td>
			</tr>
			<tr>
				<td class="tableleft">生日</td>
				<td><input type="text" name="birth" /></td>
				<td> <div class="error_birth"></div> </td>
			</tr>
			<tr>
				<td class="tableleft">邮箱</td>
				<td><input type="text" name="mail" /></td>
				<td> <div class="error_mail"></div> </td>
			</tr>
			<tr>
				<td class="tableleft">地址</td>
				<td><input type="text" name="addr" /></td>
				<td> <div class="error_addr"></div> </td>
			</tr>
			<tr>
				<td class="tableleft">状态</td>
				<td><input type="radio" name="status" value="1" checked /> 启用 <input
					type="radio" name="status" value="0" /> 禁用</td>
				<td> <div class="error_status"></div> </td>
			</tr>
			<tr>
				<td class="tableleft">角色</td>
				<td>
					<select id="manager" name="manager">
						<option value="1">管理员</option>
						<option value="2">会员</option>
					</select> 
				</td>
			</tr>
			<tr>
				<td class="tableleft"></td>
				<td>
					<button type="submit" class="btn btn-primary" type="button">保存</button>
					&nbsp;&nbsp;
					<button type="button" class="btn btn-success" name="backid"
						id="backid">返回列表</button>
				</td>
			</tr>
		</table>
	</form>

</body>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script type="text/javascript">
	function validateIdentify(){
		var identify=$('#identifyNO').val();
		if(identify.length!=18){
			$('.error_id').html("<div style='color:red;'>身份证不合法</div>");
			return;
		}
	}

	//验证用户名是否可用
	function validate() {
		var account = $('#account').val();
		if (account == "") {
			$(".error").html("<div style='color:red;'>请输入用户名</div>");
			return;
		}
		$.ajax({
			type : 'POST',
			url : '${basePath}/testSSM/test/validate.do',
			data : 'account=' + account,
			success : function(json) {
				var msg = json.replace(/"([^"]*)"/g, "$1");
				console.log(msg);
				if (msg == "0") {
					$('.error').html("<div style='color:green'>用户名可以注册</div>");
				} else {
					$('.error').html("<div style='color:red'>用户名已经存在</div>");
				}
			},
			error : function(data) {
				alert("ajax失败");
			}
		});
	}
</script>
</html>