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
<script type="text/javascript" src="js/jquery.js"></script>

<script language="javascript">
	$(function() {
		$('.success').css({
			'position' : 'absolute',
			'left' : ($(window).width() - 490) / 2
		});
		$(window).resize(function() {
			$('.success').css({
				'position' : 'absolute',
				'left' : ($(window).width() - 490) / 2
			});
		})
	});
</script>
<style type="text/css">
	.success{
		margin-top: 140px;
		width: 490px;
		background: url(images/success.png) no-repeat;
	}
</style>

</head>


<body style="background:#edf6fa;">

	<div class="success">

		<h2 style="padding-left: 120px; font-size: 20pt; font-weight: bold;">操作成功</h2>
		<div class="reindex" style="padding-left: 116px">
			<s:a action="forwardAction_forward.action?method=right">回到主页</s:a>
		</div>

	</div>


</body>

</html>
