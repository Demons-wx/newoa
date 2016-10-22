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
<title>添加用户</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>

	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><s:a action="forwardAction_forward.action?method=right">首页</s:a>
			</li>
			<li><a href="#">系统管理</a>
			</li>
			<li><a href="javascript:history.go(-1);">用户管理</a>
			</li>
			<li><a href="#">添加用户</a>
			</li>
		</ul>
	</div>

	<div class="formbody">
		<s:form action="userAction_add.action">
			<div class="formtitle">
				<span>用户添加</span>
			</div>
	
			<ul class="forminfo">
				<li>
					<label>所属部门</label>
					<s:select list="#departments" listKey="did" listValue="name" name="did" cssClass="dfinput"></s:select>
				</li>
				<li>
					<label>姓名</label>
					<s:textfield name="username" cssClass="dfinput"></s:textfield>
					<i>用户名称不能超过30个字符</i>
				</li>
				<li>
					<label>性别</label>
					<s:textfield name="sex" cssClass="dfinput"></s:textfield>
				</li>
				<li>
					<label>email</label>
					<s:textfield name="email" cssClass="dfinput"></s:textfield>
				</li>
				<li>
					<label>联系电话</label>
					<s:textfield name="phone" cssClass="dfinput"></s:textfield>
				</li>
				<li>
					<label>岗位</label>
					<s:select list="#roles" listKey="rid" listValue="name" name="rids" cssClass="dfinput" multiple="true" cssStyle="height:100px"></s:select>
				</li>
				<li>
					<label>&nbsp;</label>
					<input name="" type="submit" class="btn" value="确认添加" />
				</li>
			</ul>
		</s:form>

	</div>


</body>

</html>
