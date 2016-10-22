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
<title>提交申请</title>
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
			<li><s:a action="workFlowAction_showFormTemplate.action">起草申请</s:a>
			</li>
			<li><a href="#">提交申请</a>
			</li>
		</ul>
	</div>

	<div class="formbody">
		<s:form action="workFlowAction_submit.action" enctype="multipart/form-data">
			<s:hidden name="ftid"></s:hidden>
    		<s:hidden name="processKey"></s:hidden>
			<div class="formtitle">
				<span>下载文档模板</span>
			</div>
			<ul class="forminfo">
				<li>
					<s:a action="formTemplateAction_download.action?ftid=%{ftid}">[点击下载文档模板文件]</s:a>
				</li>
			</ul>
			<div class="formtitle">
				<span>申请信息</span>
			</div>
			<ul class="forminfo">
				<li>
					请选择填写好的文档：
					<s:file name="resource"></s:file>
				</li>
				<li>
					<input name="" type="submit" class="btn" value="提交申请" />
				</li>
				<li>
					<i style="padding-left: 0">说明：<br />
						1. 下载模板文件。<br />
						2. 填写文档中的表单。<br />
						3. 选择这个填写好的文件进行提交。<br />
						4. 提交表单后，就会按照 模板对应的流程 开始流转。</i>
				</li>
			</ul>
		</s:form>

	</div>


</body>

</html>
