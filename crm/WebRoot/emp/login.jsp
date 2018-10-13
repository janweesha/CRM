<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>职员登录界面</title>
    <link rel="icon" type="image/x-icon" href="favicon.ico"/>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body background="resources/img/img-bg03.jpg" style="background-repeat: no-repeat;background-size:100%;background-attachment: fixed;">
  <%
  	String successMsg=(String)request.getAttribute("successMsg");
    String errorMsg=(String)request.getAttribute("errorMsg");
    String name=(String)request.getAttribute("name");
   %>
  <form action="${pageContext.request.contextPath}/adminServlet" method="post">
  <!-- 隐藏框指定访问adminServlet的login方法 -->
  	<input type="hidden" name="method" value="login"/>
    <TABLE align="center">
    	<TR>
    		<TD class="td" colspan="2" align="center">
    		<font color="black" style="font-size: 30px;">请先登录</font></TD>
    	</TR>
    	<TR>
    		<TD class="td">
    		<font color="black" style="font-size: 20px;font-style: italic;">管理员:</font>
    		</TD>
    		<TD class="td">
    		<input name="name" type="text" id="name"/>
    			<font color="red">${requestScope.errorMsg}</font>
    			<font color="green">${requestScope.successMsg}</font>
    		</TD>
    	</TR>
    	<TR>
    		<TD class="td">
    		<font color="black" style="font-size: 20px;font-style: italic;">密码:</font>
    		</TD>
    		<TD class="td">
    		<input name="pwd" type="password" id="pwd"/>
    		</TD>
    	</TR>
    	<TR>
    		<TD class="td">
    		<font color="black" style="font-size: 20px;font-style: italic;">验证码:</font>
    		</TD>
    		<TD class="td" valign="top">
    		<input name="checkNum" type="text" id="checkNum" style="width: 80"/>
    		<img id="checkNumImg" src="${pageContext.request.contextPath}/VerifyCodeServlet" 
    		height="40" align="middle"  style="cursor:hand">
    		</TD>
    		<TD class="td">
    		<font color="black"  style="font-size: 10px;font-style: italic;">
    		点击图片刷新<br>
    		</font>
    		<font color="red"  style="font-size: 10px;font-style: italic;">
    		${requestScope.imageMess}
    		</font>
    		</TD>
    	</TR>
    	<TR>
    		<TD class="td">
    		</TD>
    		<TD class="td" colspan="2" align="center">
    		<input type="submit" name="submit" value="登&nbsp;录" style="cursor:hand"/>
    		<a href="${pageContext.request.contextPath}/admin/register.jsp">没有账号？注册一个</a>
    		</TD>
    	</TR>
    </TABLE>
    </form>
    <script type="text/javascript">
    document.getElementById("checkNumImg").onclick = function () {
        // 获取img元素
        // 为了让浏览器发送请求到servlet, 所以一定要改变src
        document.getElementsByTagName("img")[0].src =
            "${pageContext.request.contextPath}/VerifyCodeServlet?time=" + new Date().getTime();
    };
   /*  function checkSubmit()
    {
    	var name=$("#name").val();
    	var pwd=$("#pwd").val();
    	var checkNum=$("#checkNum").val();
    	
    	name=$.trim(name);
    	pwd=$.trim(pwd);
    	checkNum=$.trim(checkNum);
		if(true)
    	{
    		document.forms[0].submit();
    	}
    } */
</script> 
  </body>
</html>
