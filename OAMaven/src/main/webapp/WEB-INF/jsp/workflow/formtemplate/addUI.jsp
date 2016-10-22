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
<title>添加表单模板</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>

	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><s:a action="forwardAction_forward.action?method=right">首页</s:a>
			</li>
			<li><a href="#">审批流转</a>
			</li>
			<li><s:a action="formTemplateAction_showAllFormTemplate.action">申请模板管理</s:a>
			</li>
			<li><a href="#">增加模板</a>
			</li>
		</ul>
	</div>

	<div class="formbody">
		<s:form action="formTemplateAction_add.action" enctype="multipart/form-data">
			<div class="formtitle">
				<span>模板基本信息</span>
			</div>
	
			<ul class="forminfo">
				<li>
					模板名称：
					<s:textfield name="name" cssClass="dfinput"></s:textfield>
				</li>
				<li>
					所用流程：
					<s:select list="#pdList" listKey="key" listValue="key" name="processKey" cssClass="dfinput"></s:select>
				</li>
				<li>
					模板文件：
					<s:file name="resource"></s:file>
				</li>
				<li>
					<input name="" type="submit" class="btn" value="增加模板" />
				</li>
				<li>
					<i style="padding-left: 0">说明：<br />
						1，模板文件是doc扩展名的文件（Word文档）。<br />
						2，如果是添加：必须要选择模板文件。<br />
						3，如果是修改：只是在 需要更新模板文件时 才选择一个文件。</i>
				</li>
			</ul>
		</s:form>

	</div>


</body>

</html>
