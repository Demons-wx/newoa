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
<title>申请模板列表</title>
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
			<li><a href="#">申请模板管理</a>
			</li>
		</ul>
	</div>

	<div class="rightinfo">
		<div class="tools">
			<ul class="toolbar">
				<li>
					<s:a action="formTemplateAction_addUI.action"><span><img src="images/t01.png" /></span>增加模板</s:a>
				</li>
			</ul>
		</div>

		<table class="tablelist">
			<thead>
				<tr>
					<th>模板名称</th>
					<th>所用流程</th>
					<th>相关操作</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="#ftList">
					<tr>
						<td><s:property value="name"/></td>
						<td><s:property value="processKey"/></td>
						<td>
							<s:a action="formTemplateAction_delete.action?ftid=%{ftid}" cssClass="tablelink" onclick="return confirm('确认要删除吗?');">删除</s:a>
							<s:a action="formTemplateAction_updateUI.action?ftid=%{ftid}" cssClass="tablelink"> 修改</s:a>
							<s:a action="formTemplateAction_download.action?ftid=%{ftid}" cssClass="tablelink"> 下载</s:a>
						</td>
					</tr>
				</s:iterator>
			</tbody>
		</table>


		<%-- <%@ include file="/WEB-INF/jsp/common/pageView.jspf" %>
		<script type="text/javascript">
			function gotoPage(pageNum, pageCount){
				if(pageNum == 0){
					alert("已是第一页");
				}else if(pageNum == pageCount + 1){
					alert("已是最后一页");
				}else{
					window.location.href = "roleAction_showAllRoles.action?pageNum="+pageNum;
				}
			}
		</script> --%>


		<div class="tip">
			<div class="tiptop">
				<span>提示信息</span><a></a>
			</div>

			<div class="tipinfo">
				<span><img src="images/ticon.png" />
				</span>
				<div class="tipright">
					<p>是否确认对信息的修改 ？</p>
					<cite>如果是请点击确定按钮 ，否则请点取消。</cite>
				</div>
			</div>

			<div class="tipbtn">
				<input name="" type="button" class="sure" value="确定" />&nbsp; 
				<input name="" type="button" class="cancel" value="取消" />
			</div>

		</div>




	</div>

	<script type="text/javascript">
		$('.tablelist tbody tr:odd').addClass('odd');
	</script>

</body>

</html>