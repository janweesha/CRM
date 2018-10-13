<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>注册页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <form action="${pageContext.request.contextPath}/adminServlet" method="post">
  <!-- 隐藏框指定访问adminServlet的login方法 -->
  	<input type="hidden" name="method" value="register"/>
  	 <%
    String errorMsg=(String)request.getAttribute("errorMsg");
    /* String name;
    if(request.getAttribute("name")!=null)
    {
    	name=(String)request.getAttribute("name");
    } */
   %>
    <TABLE align="center">
    	<TR>
    		<TD class="td">管理员:</TD>
    		<TD class="td">
    		<input name="name" type="text" id="name">
    		</TD>
    	</TR>
    	<TR>
    		<TD class="td">密码:</TD>
    		<TD class="td">
    		<input name="pwd" type="password" id="pwd"/>
    		</TD>
    	</TR>
    	<TR>
    		<TD class="td">确认密码:</TD>
    		<TD class="td">
    		<input name="checkPwd" type="password" id="checkPwd"/>
    		</TD>
    	</TR>
    	<TR>
    		<TD class="td">验&nbsp;证&nbsp;码:</TD>
    		<TD class="td">
    		<input name="checkNum" type="text" id="checkNum" style="width: 80"/>
    		<img id="checkNumImg" src="${pageContext.request.contextPath}/VerifyCodeServlet" 
    		height="40" align="middle">
    		<input type="button" value="看不清？换一张" id="btn" style="cursor:hand"/>
    		<font color="red">${requestScope.imageMess}</font>
    		</TD>
    	</TR>
    	<TR>
    		<TD class="td">
    		</TD>
    		<TD class="td" colspan="2" align="center">
    		<input type="submit" name="submit" value="注&nbsp;册" style="cursor:hand"/>
    		<a href="${pageContext.request.contextPath}/admin/login.jsp">已有账号？前往登录</a>
    		</TD>
    	</TR>
    </TABLE>
    </form>
    <script type="text/javascript">
    document.getElementById("btn").onclick = function () {
        // 获取img元素
        // 为了让浏览器发送请求到servlet, 所以一定要改变src
        document.getElementsByTagName("img")[0].src =
            "${pageContext.request.contextPath}/VerifyCodeServlet?time=" + new Date().getTime();
    };
</script> 
  </body>
</html>
