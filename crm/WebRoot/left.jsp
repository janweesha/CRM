<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>客户关系系统主页</title>
  </head>
  
  <body background="resources/img/img_bg02.jpg" style="background-repeat: no-repeat;
  background-size:100%;background-attachment: fixed;">
    <ul>
    	<li>
    	<a style="color:aqua;" 
    	href="${pageContext.request.contextPath}/deptAction/showDept.action" 
    	target="rightFrame">
    	部门管理</a></li>
    	<li>
    	<a style="color:aqua;" 
    	href="${pageContext.request.contextPath}/#" 
    	target="rightFrame">
    	人事管理</a></li>
    </ul>
  </body>
</html>
