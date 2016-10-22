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
<title>版块列表</title>
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
	}
	.ForumPageTopic{
		color: #004e83;
		font-weight: bold;
		font-size: 13px;
	}
	.ForumPageTopicMemo{
		text-indent: 3em;
		color: #787878;
	}
	.ForumPageTopicUl{
		padding-left: 60px;
		text-align: left;
		color: #787878;
	}
	.ForumTitle{
		color: #004799;
	}
	.ForumImage{
		padding-left: 40px;
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
			<li><a href="#">论坛</a>
			</li>
		</ul>
	</div>

	<div class="rightinfo">
		<table class="tablelist">
			<thead>
				<tr>
					<th colspan="3">版块</th>
					<th width="80">主题数</th>
					<th width="80">文章数</th>
					<th width="420">最后发表的主题</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="recordList">
					<tr height="78">
						<td widht="3"></td>
						<td class="ForumImage"><img src="images/forumpage3.gif" /></td>
						<td>
							<ul>
								<li><s:a cssClass="ForumPageTopic" action="forumAction_show?id=%{id}">${name}</s:a></li>
								<li class="ForumPageTopicMemo">${description}</li>
							</ul>
						</td>
						<td align="center"><b>${topicCount}</b></td>
						<td align="center"><b>${articleCount}</b></td>
						<td>
							<ul class="ForumPageTopicUl">
								<li><font color="#444444" >┌ 主题：</font> 
									<s:a cssclass="ForumTitle" action="topicAction_show?id=%{lastTopic.id}">${lastTopic.title}</s:a>
								</li>
								<li><font color="#444444">├ 作者：</font> ${lastTopic.author.username}</li>
								<li><font color="#444444">└ 时间：</font> ${lastTopic.postTime}</li>
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
					window.location.href = "forumAction_list.action?id=${id}&pageNum="+pageNum;
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