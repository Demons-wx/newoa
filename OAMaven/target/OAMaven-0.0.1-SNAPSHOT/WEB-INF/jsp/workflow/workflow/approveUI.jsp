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
<title>审批处理</title>
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
			<li><s:a action="workFlowAction_showMyTaskList.action">待我审批</s:a>
			</li>
			<li><a href="#">审批处理</a>
			</li>
		</ul>
	</div>

	<div class="formbody">
		<s:form action="workFlowAction_approve.action" enctype="multipart/form-data">
			<s:hidden name="fid"></s:hidden>
			<div class="formtitle">
				<span>申请信息</span>
			</div>
			<ul class="forminfo">
				<li>
					<s:a action="workFlowAction_download.action?fid=%{fid}">[点击下载申请信息文件]</s:a>
				</li>
			</ul>
			<div class="formtitle">
				<span>审批意见</span>
			</div>
			<ul class="forminfo">
				<li>
					请选择同意或是拒绝：
					<s:select list="{'同意','拒绝'}" name="result" cssClass="dfinput"></s:select>
				</li>
				<li>
					<input name="" type="submit" class="btn" value="提    交" />
				</li>
				<li>
					<i style="padding-left: 0">说明：<br />
						1. 同意：本次审批通过，流程继续执行。如果所有的环节都通过，则表单的最终状态为：已通过。<br/>
						2. 拒绝：本次审批未通过，流程结束，不再继续执行。表单的最终状态为：未通过。</i>
				</li>
			</ul>
		</s:form>

	</div>


</body>

</html>
