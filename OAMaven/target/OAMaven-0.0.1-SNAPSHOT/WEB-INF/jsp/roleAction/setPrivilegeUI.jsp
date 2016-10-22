<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>设置权限</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script language="javascript" src="treeview/jquery.treeview.js"></script>
<link type="text/css" rel="stylesheet" href="treeview/jquery.treeview.css" />
<script type="text/javascript">
	$(function(){
		$("[name=privilegeIds]").click(function(){
			// 当选中或取消一个权限时，同时选中或取消所有的下级权限
			$(this).siblings("ul").find("input").attr("checked",this.checked);	
			
			// 当选中一个权限时，也要选中所有的直接上级权限
			if(this.checked == true){
				$(this).parents("li").children("input").attr("checked",true);
			}
			
			if(this.id == "cb_15" || this.id == "cb_16" || this.id == "cb_17"){
				$("#cb_14").attr("checked",this.checked);
			}
			if(this.id == "cb_6" || this.id == "cb_7" || this.id == "cb_8" || this.id == "cb_9"){
				$("#cb_5").attr("checked",this.checked);
			}
			if(this.id == "cb_13" || this.id == "cb_12" || this.id == "cb_11"){
				$("#cb_10").attr("checked",this.checked);
			}
			if($("#cb_15").attr("checked") == true || $("#cb_16").attr("checked") == true || $("#cb_17").attr("checked") == true){
				$("#cb_14").attr("checked",true);
			}
			if($("#cb_6").attr("checked") == true || $("#cb_7").attr("checked") == true || $("#cb_8").attr("checked") == true || $("#cb_9").attr("checked") == true){
				$("#cb_5").attr("checked",true);
			}
			if($("#cb_13").attr("checked") == true || $("#cb_12").attr("checked") == true || $("#cb_11").attr("checked") == true){
				$("#cb_10").attr("checked",true);
			}
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
			<li><a href="#">系统管理</a>
			</li>
			<li><a href="javascript:history.go(-1);">岗位管理</a>
			</li>
			<li><a href="#">设置权限</a>
			</li>
		</ul>
	</div>

	<!-- 备注
																		   判断此权限是否被选中，如果被选中则回显,此处的id是privilege实体类中的id
	<input type="checkbox" name="privilegeIds" value="${id}" id="cb_${id}" <s:property value="%{id in privilegeIds ? 'checked' : ''}"/>/>
	<label for="cb_${id}">${name}</label>  此行实现点击权限的文字也选中checkbox，for中填要被关联的元素id

	 -->

	<div class="formbody">
		<s:form action="roleAction_setPrivilege.action">
			<s:hidden name="rid"></s:hidden>
			<div class="formtitle">
				<span>正在为【${name}】设置权限</span>
			</div>
			<ul  id="tree">
				<!-- 显示树状结构的内容 -->
				<s:iterator value="#application.topPrivilegeList">
					<li>
						<input type="checkbox" name="privilegeIds" value="${id}" id="cb_${id}" <s:property value="%{id in privilegeIds ? 'checked' : ''}"/>/>
						<label for="cb_${id}">${name}</label>
						<ul>
							<s:iterator value="children">
								<li>
									<input type="checkbox" name="privilegeIds" value="${id}" id="cb_${id}" <s:property value="%{id in privilegeIds ? 'checked' : ''}"/>/>
									<label for="cb_${id}">${name}</label>														  
									<ul>
										<s:iterator value="children">
											<li>
												<input type="checkbox" name="privilegeIds" value="${id}" id="cb_${id}" <s:property value="%{id in privilegeIds ? 'checked' : ''}"/>/>
												<label for="cb_${id}">${name}</label>
											</li>
										</s:iterator>
									</ul>
								</li>
							</s:iterator>
						</ul>
					</li>
				</s:iterator>
			</ul>
			<li>
				<label>&nbsp;</label>
				<input name="" type="submit" class="btn" value="保存" />
			</li>
		</s:form>
	</div>
	<script language="javascript">
		$("#tree").treeview();
	</script>
	

</body>

</html>