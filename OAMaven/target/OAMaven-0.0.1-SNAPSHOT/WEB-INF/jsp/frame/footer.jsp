<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
	$(function(){
		 setInterval("getCurDate()",100);
	})
	
	function getCurDate(){
		var d = new Date();
		var year = d.getFullYear();
		var month = add_zero(d.getMonth()+1);
		var day = add_zero(d.getDay()+1);
		var hours = add_zero(d.getHours());
		var minutes = add_zero(d.getMinutes());
		var seconds=add_zero(d.getSeconds());
		var ndate =year+"年"+month+"月"+day+"日"+"  "+hours+":"+minutes+":"+seconds;
		$("#time").text(ndate);
	}
	
	function add_zero(temp){
		if(temp<10) return "0"+temp;
		else return temp;
	}
</script>
</head>

<body>
	<div class="footer">
		<span>仅供学习交流，请勿用于任何商业用途</span> <i>版权所有 2016  wangxuan</i>
		<p id="time" style="margin-left: 600px;"></p>
	</div>
</body>
</html>
