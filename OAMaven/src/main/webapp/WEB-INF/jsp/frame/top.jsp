<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="js/jquery.js"></script>
<script type="text/javascript">
	$(function() {
		//顶部导航切换
		$(".nav li a").click(function() {
			$(".nav li a.selected").removeClass("selected")
			$(this).addClass("selected");
		})
	})
	function logout(){  
    	parent.window.location = "userAction_logout.action";  
	} 
</script>


</head>

<body style="background:url(images/topbg.gif) repeat-x;">

	<div class="topleft">
		<a href="main.html" target="_parent"><img src="images/logo.png"
			title="系统首页" />
		</a>
	</div>

	<ul class="nav">
		
		<!-- <li><a href="tools.html" target="rightFrame"><img
				src="images/icon04.png" title="常用工具" />
			<h2>常用工具</h2>
		</a>
		</li>
		
		<li><a href="tab.html" target="rightFrame"><img
				src="images/icon06.png" title="系统设置" />
			<h2>系统设置</h2>
		</a>
		</li> -->
	</ul>

	<div class="topright">
		<ul>
			<li><a href="${pageContext.request.contextPath}/userAction_updatePasswordUI.action" target="rightFrame">修改密码</a></li>
			<li><a onclick="logout()" href="#">退出</a></li>
			
		</ul>

		<div class="user">
			<span>欢迎您：${user.username}</span> 
		</div>

	</div>

</body>
</html>
