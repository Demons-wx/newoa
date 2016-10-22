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
<title>部署流程定义</title>
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
			<li><s:a action="pdManagerAction_showLastVersions.action">审批流程管理</s:a>
			</li>
			<li><a href="#">部署流程定义</a>
			</li>
		</ul>
	</div>

	<div class="formbody">
		<s:form action="pdManagerAction_deploy.action" enctype="multipart/form-data">
			<div class="formtitle">
				<span>部署流程定义</span>
			</div>
	
			<ul class="forminfo">
				<li>
					请选择流程定义文档：
					<s:file name="resource"></s:file>
				</li>
				<li>
					<input name="" type="submit" class="btn" value="部    署" />
				</li>
				<li>
					<i style="padding-left: 0">说明：只接受zip扩展名的文件。</i>
				</li>
			</ul>
		</s:form>

	</div>


</body>

</html>
