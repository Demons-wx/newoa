<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="js/jquery.js"></script>

<script type="text/javascript">
	$(function() {
		$('.title').click(function() {
			var $ul = $(this).next('ul');
			$('dd').find('.menuson').slideUp();
			if ($ul.is(':visible')) {
				$(this).next('.menuson').slideUp();
			} else {
				$(this).next('.menuson').slideDown();
			}
		});
	});
</script>


</head>

<body style="background:#f0f9fd;">
	<div class="lefttop">
		<span></span>办公自动化系统
	</div>

	<dl class="leftmenu">

		<s:iterator value="#application.topPrivilegeList">
			<s:if test="#session.user.hasPrivilegeByName(name)">
				<dd>				 
					<div class="title">
						<span><img src="images/${id}.png" /></span>${name}
					</div>
					<ul class="menuson">
						<s:iterator value="children">
							<s:if test="#session.user.hasPrivilegeByName(name)">
								<li>
									<div class="header">
										<cite></cite> <a href="${pageContext.request.contextPath}${url}.action" target="rightFrame">${name}</a>
										<i></i>
									</div>
								</li>
							</s:if>
						</s:iterator>
					</ul>
				</dd>
			</s:if>
		</s:iterator>
		

	</dl>

</body>
</html>
