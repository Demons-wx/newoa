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
<title>查看主题：${topic.title}</title>
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
	.PhotoArea{
		background-color: #e5f2fb;
	}
	.AuthorPhoto{
		margin: 11px 10px 5px 0;
	}
	.topicTitle{
		color: #004a7d;
		font-weight: bold;
		border-bottom: 1px dashed #958f88;
	}
	.Footer{
		background: #add4f7;
		color: #a1a1a1;
	}
	.AuthorName{
		font-weight: bold;
	}
	.topicTitle, .Content:hover{
		background-color: #fff;
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
			<li><s:a action="forumAction_show?id=%{#topic.forum.id}">${topic.forum.name}</s:a>
			</li>
			<li><a href="#">帖子阅读</a>
			</li>
		</ul>
	</div>
	
	<div class="rightinfo">
	
		<!-- 显示主题标题等 -->
		<table class="tablelist">
			<tr valign="bottom">
				<th width="3" class="ForumPageTableTitleLeft">&nbsp;</th>
				<th class="ForumPageTableTitle"><b>本帖主题：${topic.title}</b></th>
				<th style="text-align: right">
					<s:a action="replyAction_addUI?topicId=%{#topic.id}">快速回复</s:a>
				</th>
				<th width="3" class="ForumPageTableTitleRight">&nbsp;</th>
			</tr>
		</table>
		
		<!-- 显示主帖 -->
		<s:if test="currentPage == 1 || currentPage == null">
			<table class="tablelist">
				<tr>
					<td rowspan="3" width="130" height="200" class="PhotoArea" align="center" valign="top">
						<!--作者头像-->
						<div class="AuthorPhoto">
							<img border="0" width="110" height="110" src="images/defaultAvatar.gif" 
								onerror="this.onerror=null; this.src='images/defaultAvatar.gif';" />
						</div>
						<!--作者名称-->
						<div class="AuthorName">${topic.author.username}</div>
					</td>
					<td class="topicTitle" style="line-height: 15px" height="35px">
						${topic.title}
					</td>
				</tr>	
				<tr><!-- 文章内容 -->
					<td class="Content" height="140px">
						<div style="width: 96%; line-height: 28px; margin: 10px auto;">${topic.content}</div>
					</td>
				</tr>	
				<tr><!--显示楼层等信息-->
					<td class="Footer" height="35px">
						<ul>
							<li style="float: left; line-height:12px;"><font color=#C30000>[楼主]</font>
								${topic.postTime}
							</li>
						</ul>
					</td>
				</tr>
			</table>
		</s:if>
		
		<!-- 显示回复列表 -->
		<s:iterator value="recordList" status="status">
			<table class="tablelist">
				<tr>
					<td rowspan="3" width="130" height="240" class="PhotoArea" align="center" valign="top">
						<!--作者头像-->
						<div class="AuthorPhoto">
							<img border="0" width="110" height="110" src="images/defaultAvatar.gif" 
								onerror="this.onerror=null; this.src='images/defaultAvatar.gif';" />
						</div>
						<!--作者名称-->
						<div class="AuthorName">${author.username}</div>
					</td>
					<td class="topicTitle" style="line-height: 15px" height="35px">
						回复：${topic.title}
					</td>
				</tr>
				<tr><!-- 文章内容 -->
					<td class="Content" height="140px">
						<div style="width: 96%; line-height: 28px; margin: 10px auto;">${content}</div>
					</td>
				</tr>
				<tr><!--显示楼层等信息-->
					<td class="Footer" height="35px">
						<ul style="margin: 0px; width: 98%;">
							<li style="float: left; line-height:12px;"><font color=#C30000>[${(currentPage -1) * pageSize + status.count}楼]</font>
								${postTime}
							</li>
						</ul>
					</td>
				</tr>
			</table>
		</s:iterator>
		
		<s:if test="recordList != null">
			<%@ include file="/WEB-INF/jsp/common/pageView.jspf" %>
			<script type="text/javascript">
				function gotoPage(pageNum, pageCount){
					if(pageNum == 0){
						alert("已是第一页");
					}else if(pageNum == pageCount + 1){
						alert("已是最后一页");
					}else{
					// 	alert(${id} == ${topic.id});
						window.location.href = "topicAction_show.action?id=${id}&pageNum="+pageNum;
					}
				}
			</script>
		</s:if>
		

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

	

</body>

</html>