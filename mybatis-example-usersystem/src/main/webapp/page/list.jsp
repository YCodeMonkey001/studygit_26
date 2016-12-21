<%@ page  contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<base href="/mybatis-example-usersystem/">
<meta charset="UTF-8">
<title>用户列表</title>
<link type="text/css" rel="stylesheet" href="easyui/themes/icon.css">
<link type="text/css" rel="stylesheet" href="easyui/themes/default/easyui.css">
<link type="text/css  rel="stylesheet" href="css/login.css">

</head>
<body>
	<table id="userList"></table>
	<div id="modifyDiv">
		<form id="modifyForm" method="post" enctype="multipart/form-data">
			<p><input id="uid" name="id" readonly="readonly"/></p>
			<p><input id="uname" name="name" /></p>
			<p><input id="ubirthday" name="birthday" /></p>
			<p><input id="ugender" name="gender"/></p>
			<p><input id="ucareer" name="career" /></p>
			<p><input id="uaddress" name="address" /></p>
			<p><input id="umobile" name="mobile" /></p>
			<p><input type="file"  name="picPath" onchange="chgPic(this)"/></p>
			<p><img width='100' src="image/not_pic.jpg" id="pic"></p>
			<p><a class="closeBtn" href="javascript:void(0)">关闭</a>&nbsp;&nbsp;
			<a class="updateBtn" href="javascript:void(0)">修改</a></p>
		</form>
	</div>
	<div id="detailDiv">
		<form id="dmodifyForm" method="post" enctype="multipart/form-data">
			<p><input id="duid" name="id" readonly="readonly"/></p>
			<p><input id="duname" name="name" /></p>
			<p><input id="dubirthday" name="birthday" /></p>
			<p><input id="dugender" name="gender"/></p>
			<p><input id="ducareer" name="career" /></p>
			<p><input id="duaddress" name="address" /></p>
			<p><input id="dumobile" name="mobile" /></p>
			<p><img width='100' src="image/not_pic.jpg" id="dpic"></p>
			<p><a class="dcloseBtn" href="javascript:void(0)">关闭</a></p>			
		</form>
	</div>
	
	<script type="text/javascript" src="easyui/jquery.min.js"></script>
	<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="easyui/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="js/list.js"></script>
</body>
</html>