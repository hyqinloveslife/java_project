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
<link type="text/css" rel="stylesheet" href="resource/css/register.css"> 
<style type="text/css">
	span {
	width: 150px;color: white;font-size: 1.2em;display: inline-block;
	display: -moz-inline-box;
}
</style>
<title>sign up</title>
</head>
<body>
	<div id="login">
		<h1>SIGN UP</h1>
		<form action="${basePath}/testSSM/user/register.do" method="post"
			class="definewidth m20">
			<div> <span>账号</span><input id="account" type="text" name="account" onblur="validate()" /> </div>
			<div class="error"></div>
			<span>密码</span><input type="password" name="password" /> <label>*请输入6-16位密码</label>
			<div class="error_pwd"></div>
			<span>真实姓名</span><input type="text" name="name" />
			<div class="error_name"></div>
			<span>身份证</span><input id="identifyNO" type="text" name="identifyNO"
				onblur="validateIdentify()" /> <label>*请输入身份证号</label>
			<div class="error_id"></div>
			
			<span>性别</span> 
			<select id="gender" name="gender" class="sele">
				<option value="1">男</option>
				<option value="2">女</option>
				<option value="3">保密</option>
			</select>
			<div class="error_gender"></div>
			<span>生日</span><input type="text" name="birth" placeholder="格式：19990101" />
			<div class="error_birth"></div>
			<span>邮箱</span><input type="text" name="mail" placeholder="格式：1234567@example.com"/>
			<div class="error_mail"></div>
			<span>地址</span><input type="text" name="addr" />
			<div class="error_addr"></div>
			<span>身份</span>
			<select id="manager" name="manager" class="sele">
				<option value="1">管理员</option>
				<option value="2">会员</option>
			</select>
			<button type="submit" class="btn btn-primary" type="button">注册</button>
			<button type="button" class="btn2 btn-success" name="backid" id="backid">返回登录</button>
		</form>
	</div>
</body>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script type="text/javascript">
	function validateIdentify() {
		var identify = $('#identifyNO').val();
		if (identify.length != 18) {
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