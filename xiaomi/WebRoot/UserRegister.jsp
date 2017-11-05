<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
	<head>
		<meta charset="UTF-8">
		<title>用户注册</title>
		<link rel="stylesheet" type="text/css" href="./css/login.css">
		<link rel="stylesheet" type="text/css" href="./css/button.css">

<script type="text/javascript">
		
		function getphone(){
			
			
			alert("phone:"+document.getElementById("phone").value);
			
			
			location.href="getNumberAction?user.phone="+document.getElementById("phone").value+"&&user.username="+document.getElementById("username").value+"&&user.password="+document.getElementById("password").value+"&&user.repassword="+document.getElementById("repassword").value;
			
		}


</script>
	</head>
	<body>
	<%
		String code = (String)session.getAttribute("code");
	
	%>
	<s:form action="userRegisterAction.action" theme="simple">
		<div class="regist">
			<div class="regist_center">
				<div class="regist_top">
					<div class="left fl">会员注册</div>
					<div class="right fr"><a href="./index.html" target="_self">小米商城</a></div>
					<div class="clear"></div>
					<div class="xian center"></div>
				</div>
				<div class="regist_main center">
					<div class="username">用&nbsp;&nbsp;户&nbsp;&nbsp;名:&nbsp;&nbsp;<s:textfield class="shurukuang" name="user.username" placeholder="请输入你的用户名" id="username"></s:textfield><span>请不要输入汉字</span></div>
					<div class="username">密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码:&nbsp;&nbsp;<s:textfield class="shurukuang" name="user.password" placeholder="请输入你的密码" id="password"></s:textfield><span>请输入6位以上字符</span></div>
					
					<div class="username">确认密码:&nbsp;&nbsp;<s:textfield class="shurukuang" name="user.repassword" placeholder="请输入你的密码" id="repassword"></s:textfield><span>两次密码要输入一致哦</span></div>
					
					
					
					<div class="username">手&nbsp;&nbsp;机&nbsp;&nbsp;号:&nbsp;&nbsp;<s:textfield class="shurukuang" name="user.phone" placeholder="请填写正确的手机号" id="phone"></s:textfield><a href="javascript:getphone();" class="button button-pill button-tiny">获取验证码</a></div>
					
					
					<div class="username">
						<div class="left fl">验&nbsp;&nbsp;证&nbsp;&nbsp;码:&nbsp;&nbsp;<s:textfield class="shurukuang" name="validateCode"  placeholder="请输入手机验证码"></s:textfield> </div>
						<div class="right fl"></div>
						<div class="clear"></div>
					</div>
				</div>
				<s:actionerror/>
				<div class="regist_submit">
						<s:submit class="submit" type="submit" name="submit" value="立即注册"></s:submit>
				</div>
				
			</div>
		</div>
		</s:form>
	</body>
</html>