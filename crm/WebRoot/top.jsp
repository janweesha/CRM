<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>客户关系系统主页</title>
  </head>
  <body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" 
  background="resources/img/img_bg01.jpg" style="background-repeat: no-repeat;
  background-size:100%;background-attachment: fixed;">
  <script type="text/javascript">
  	if(requestScope.successMsg!=null)
  	{
  		alert(requestScope.successMsg);
  	}
  </script>
  	<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0" class="top">
  		<tr>
  			<td class="logo" colspan="4" align="left">
  					<font style="font-size:20">客户关系管理系统</font>
  			</td>
  			<td  align="right">
    				<font style="color:black;">管理员:${sessionScope.name}!|</font>
    				<a style="color:red;" href="${pageContext.request.contextPath}/adminServlet?method=exit" target="_parent">退出</a>
  			</td>
  		</tr>
  	</table>
  </body>
</html>
