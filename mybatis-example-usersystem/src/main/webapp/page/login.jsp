<%@ page  contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<base href="/mybatis-example-usersystem/">
<meta charset="UTF-8">
<title>用户登录</title>
<link type="text/css" rel="stylesheet" href="easyui/themes/icon.css">
<link type="text/css" rel="stylesheet" href="easyui/themes/default/easyui.css">
<link type="text/css" rel="stylesheet" href="css/login.css">

</head>
<body>
	<div id="LoginDiv">
		<form id="loginForm" method="post">
			<p><input name="id" placeholder="输入用户编号"  required="required" value="10242"/></p>
			<p><input name="name" placeholder="输入用密码" required="required" value="nrtusx"/></p>
			<p><a id="btnLogin"  href="javascript:void(0)"/>登录</p>
		</form>
	</div>
	<script type="text/javascript" src="easyui/jquery.min.js"></script>
	<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="js/login.js"></script>
</body>
</html>