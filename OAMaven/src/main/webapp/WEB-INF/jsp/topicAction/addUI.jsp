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
	<title>发表新主题</title>
	<link href="css/style.css" rel="stylesheet" type="text/css" />
	<script language="javascript" src="fckeditor/fckeditor.js"></script>
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
			<li><s:a action="forumAction_show?id=%{#forum.id}">${forum.name}</s:a>
			</li>
			<li><a href="#">发表新主题</a>
			</li>
		</ul>
	</div>
	<div class="formbody">
		<s:form action="topicAction_add.action">
			<s:hidden name="forumId"></s:hidden>
			<div class="formtitle">
				<span>发表新主题</span>
			</div>
	
			<ul class="forminfo">
				<li>
					<label>标题</label>
					<s:textfield name="title" cssClass="dfinput"></s:textfield>
				</li>
				<li>
					<label>内容</label>
					<s:textarea name="content" cssClass="textinput"></s:textarea>
					<script type="text/javascript">
						var fck = new FCKeditor("content");
						fck.Height	= "240px" ;
						fck.Width	= "520px" ;
						fck.ToolbarSet = "bbs";
						fck.BasePath = "fckeditor/";
						fck.Config['EditorAreaCSS'] = "css/style.css";
						fck.ReplaceTextarea();
					</script>
				</li>
				<li>
					<label>&nbsp;</label>
					<input name="" type="submit" class="btn" value="发   表" />
				</li>
			</ul>
		</s:form>

	</div>


</body>

</html>
