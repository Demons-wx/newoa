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
<title>申请模板选择</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$(".click").click(function() {
			$(".tip").fadeIn(200);
		});

		$(".tiptop a").click(function() {
			$(".tip").fadeOut(200);
		});

		$(".sure").click(function() {
			$(".tip").fadeOut(100);
		});

		$(".cancel").click(function() {
			$(".tip").fadeOut(100);
		});

	});
</script>


</head>


<body>

	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><s:a action="forwardAction_forward.action?method=right">首页</s:a>
			</li>
			<li><a href="#">审批流转</a>
			</li>
			<li><a href="#">起草申请</a>
			</li>
		</ul>
	</div>

	<div class="formbody">
		<s:form action="formTemplateAction_add.action" enctype="multipart/form-data">
			<div class="formtitle">
				<span>请选择申请模板</span>
			</div>
	
			<ul class="forminfo">
				<li>
					<s:iterator value="#ftList">
						<div> 
							<img width="16" height="16" src="images/doc.gif"/> 
							<s:a action="workFlowAction_submitUI.action?ftid=%{ftid}&processKey=%{processKey}"><s:property value="name"/></s:a>
						</div>
					</s:iterator>
				</li>
			</ul>
		</s:form>

	</div>

</body>

</html>