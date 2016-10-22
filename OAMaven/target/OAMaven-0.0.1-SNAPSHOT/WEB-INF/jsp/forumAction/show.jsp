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
<title>【${forum.name}】中的主题列表</title>
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
<style type="text/css">
	.disabled{
		color: gray;
    	display: inline;
	}
	.tablelist th{
		text-align: center;
	}
	.tablelist td{
		border-right: 0;
		line-height: 20px;
		color: #787878;
	}
	.ForumTopicPageDataLine{
		text-align: center;
	}
	.Author{
		color: #004e83;
	}
</style>

</head>


<body>

	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><s:a action="forwardAction_forward.action?method=right">首页</s:a>
			</li>
			<li><a href="#">网上交流</a>
			</li>
			<li><s:a action="forumAction_list.action">论坛</s:a>
			</li>
			<li><a href="#">【${forum.name}】中的主题列表</a>
			</li>
		</ul>
	</div>
	
	<div class="rightinfo">
		<div class="tools">
			<ul class="toolbar">
				<s:a action="topicAction_addUI?forumId=%{#forum.id}"><li><span><img src="images/t01.png" /></span>发新帖</li></s:a>
			</ul>
		</div>
		<table class="tablelist">
			<thead>
				<tr>
					<th width="50" class="ForumPageTableTitle"><!--状态/图标-->&nbsp;</th>
					<th class="ForumPageTableTitle">主题</th>
					<th width="200" class="ForumPageTableTitle">作者</th>
					<th width="120" class="ForumPageTableTitle">回复数</th>
					<th width="160" class="ForumPageTableTitle">最后回复</th>
				</tr>
			</thead>
			<!-- 主题列表 -->
			<tbody>
				<s:iterator value="recordList">
					<tr height="35">
						<td class="ForumTopicPageDataLine" align="center"><img src="images/topicType_${type}.gif" /></td>
						<td class="Topic">
							<s:a cssClass="Default" action="topicAction_show?id=%{id}">${title}</s:a>
						</td>
						<td class="ForumTopicPageDataLine">
							<ul class="ForumPageTopicUl">
								<li class="Author">${author.username}</li>
								<li class="CreateTime">${postTime}</li>
							</ul>
						</td>
						<td class="ForumTopicPageDataLine Reply" align="center"><b>${replyCount}</b></td>
						<td class="ForumTopicPageDataLine">
							<ul class="ForumPageTopicUl">
								<li class="Author">${lastReply.author.username}</li>
								<li class="CreateTime">${lastReply.postTime}</li>
							</ul>
						</td>
					</tr>
				</s:iterator> 
			</tbody>
		</table>
		
		<%@ include file="/WEB-INF/jsp/common/pageView.jspf" %>
		<script type="text/javascript">
			function gotoPage(pageNum, pageCount){
				if(pageNum == 0){
					alert("已是第一页");
				}else if(pageNum == pageCount + 1){
					alert("已是最后一页");
				}else{
					window.location.href = "forumAction_show.action?id=${id}&pageNum="+pageNum;
				}
			}
		</script>


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