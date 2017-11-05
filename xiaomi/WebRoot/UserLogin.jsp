<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<html>
	<head>
		<meta charset="UTF-8">
		<title>会员登录</title>
		<link rel="stylesheet" type="text/css" href="./css/login.css">
		
	</head>
	<body>
		<!-- login -->
		<div class="top center">
			<div class="logo center">
				<a href="./index.html" target="_blank"><img src="./image/mistore_logo.png" alt=""></a>
			</div>
		</div>
		<s:form action="#" class="form center" theme="simple">
		<div class="login">
			<div class="login_center">
				<div class="login_top">
					<div class="left fl">会员登录</div>
					<div class="right fr">您还不是我们的会员？<a href="./UserRegister.jsp" target="_self">立即注册</a></div>
					<div class="clear"></div>
					<div class="xian center"></div>
				</div>
				<div class="login_main center">
					<div class="username">用户名:&nbsp;<s:textfield class="shurukuang" name="user.username" placeholder="请输入你的用户名"></s:textfield></div>
					<div class="username">密&nbsp;&nbsp;&nbsp;&nbsp;码:&nbsp;<s:password class="shurukuang" name="user.password" placeholder="请输入你的密码"></s:password></div>
					<div class="username">
						<div class="left fl">验证码:&nbsp;<s:textfield class="yanzhengma" name="username" placeholder="请输入验证码"></s:textfield></div>
						<div class="right fl"><img src="createImageAction.action" onclick="this.src='createImageAction.action?'+ Math.random()" title="点击图片刷新验证码"/></div>
					</div>
				</div>
				<div class="login_submit">
				<s:submit class="submit" type="submit" name="submit" value="立即登录"></s:submit>
				</div>
				
			</div>
		</div>
		</s:form>
		<footer>
			<div class="copyright">简体 | 繁体 | English | 常见问题</div>
			<div class="copyright">小米公司版权所有-京ICP备10046444-<img src="./image/ghs.png" alt="">京公网安备11010802020134号-京ICP证110507号</div>

		</footer>
	</body>
</html>