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
<title>修改密码</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>

	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><s:a action="forwardAction_forward.action?method=right">首页</s:a>
			<li><a href="#">系统管理</a></li>
			<li><s:a action="userAction_showAllUsers.action">用户管理</s:a>
			<li><a href="#">修改密码</a></li>
		</ul>
	</div>

	<div class="formbody">
		<s:form action="userAction_updatePassword.action">
			<s:hidden name="uid"></s:hidden>
			<s:hidden name="did"></s:hidden>
			<s:hidden name="rids"></s:hidden>
			<div class="formtitle">
				<span>修改密码</span>
			</div>

			<ul class="forminfo">
				<s:actionmessage/>
				<li>
					<label>原始密码</label>
					<s:password name="oldPass" cssClass="dfinput"></s:password>
				</li>
				<li>
					<label>新密码</label>
					<s:password name="newPass_1" cssClass="dfinput"></s:password>
				</li>
				<li>
					<label>确认新密码</label>
					<s:password name="newPass_2" cssClass="dfinput"></s:password>
				</li>
				<li>
					<label>&nbsp;</label> 
					<input name="" type="submit" class="btn" value="确认修改" />
				</li>
			</ul>
		</s:form>

	</div>

</body>

</html>
