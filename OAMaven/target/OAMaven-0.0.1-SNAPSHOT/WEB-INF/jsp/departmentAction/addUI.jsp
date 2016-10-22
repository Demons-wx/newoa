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
<title>添加部门</title>
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
			<li><a href="javascript:history.go(-1);">部门管理</a>
			</li>
			<li><a href="#">添加部门</a>
			</li>
		</ul>
	</div>

	<div class="formbody">
		<s:form action="departmentAction_add.action">
			<div class="formtitle">
				<span>部门添加</span>
			</div>
	
			<ul class="forminfo">
				<li>
					<label>上级部门</label>
					<s:select list="#departments" listKey="name" listValue="name" name="pd" cssClass="dfinput"></s:select>
				</li>
				<li>
					<label>部门名称</label>
					<s:textfield name="name" cssClass="dfinput"></s:textfield>
					<i>部门名称不能超过30个字符</i>
				</li>
				<li>
					<label>部门说明</label>
					<s:textarea name="description" cssClass="textinput"></s:textarea>
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
