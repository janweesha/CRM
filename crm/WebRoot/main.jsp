<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>客户关系系统主页</title>
    <link rel="icon" type="image/x-icon" href="favicon.ico"/>
  </head>
  <frameset rows="20%,*" bordercolor="white">
  	<frame src="${pageContext.request.contextPath}/top.jsp" noresize="noresize" frameborder="1" name="topFrame" id="topFrame"/>
  	<frameset cols="15%,*">
  		<frame src="${pageContext.request.contextPath}/left.jsp" noresize="noresize" frameborder="1" name="leftFrame" id="leftFrame"/>
  		<frame src="${pageContext.request.contextPath}/right.jsp" noresize="noresize" frameborder="1" name="rightFrame" id="rightFrame">
  	</frameset>
  </frameset>
  <body>
  </body>
</html>
