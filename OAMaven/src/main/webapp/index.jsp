<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script language="javascript" src="fckeditor/fckeditor.js"></script>
  </head>
  
  <body>
    <form action="">
		<textarea name="content">这是回显的内容</textarea>
		<br>

		<!-- 2，写一段JS代码显示FCKeditor -->
		<script type="text/javascript">
			var oFCKeditor = new FCKeditor( 'content' ) ; // 此参数会做提交表单时的参数名使用
			oFCKeditor.BasePath	= "fckeditor/"; // 一定要指定editor文件夹所在的路径，并且要以'/'结尾
			oFCKeditor.Height	= "300px" ;
			oFCKeditor.Width	= "700px" ;
			oFCKeditor.ToolbarSet = "bbs"; // 指定工具栏的配置，默认为Default
			oFCKeditor.ReplaceTextarea(); // 替换指定id或name的Textarea为FCKeditor
		</script>
		
		<br><input type="submit" value="提交">
	</form>
  </body>
</html>
