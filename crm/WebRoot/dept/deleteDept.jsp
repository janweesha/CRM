<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>删除部门页面</title>
  </head>
  
  <body>
    <form name="form1" action="${pageContext.request.contextPath}/deptAction/deleteDept.action">
    	
    </form>
  </body>
</html>
