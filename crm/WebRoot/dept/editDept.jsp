<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>增加部门</title>
    <link rel="icon" type="image/x-icon" href="favicon.ico"/>
  </head>
  
  <body>
    <form action="${pageContext.request.contextPath}/deptAction/editDept.action" target="_self" method="post">
    <!-- 隐藏类型存储id -->
    <input type="hidden" name="id" id="id" value="${requestScope.DEPT.id}">
    <TABLE align="center">
    	<TR>
    		<TD class="td">部门名称:</TD>
    		<TD class="td">
    		<input name="name" type="text" id="name" value="${requestScope.DEPT.name}"/>
    			<font color="red">${requestScope.errorMsg}</font>
    			<font color="green">${requestScope.successMsg}</font>
    		</TD>
    	</TR>
    	<TR>
    		<TD class="td">部门负责人:</TD>
    		<TD class="td">
    		<input name="manager" type="text" id="manager" value="${requestScope.DEPT.manager}"/>
    		</TD>
    	</TR>
    	<TR>
    		<TD class="td">部门职能：</TD>
    		<TD class="td">
    		<input name="work" type="text" id="work" value="${requestScope.DEPT.work}"/>
    		</TD>
    	</TR>
    	<TR>
    		<TD class="td" valign="top">备注信息：</TD>
    		<TD class="td" valign="top">
    		<input name="remark" type="text" id="remark" value="${requestScope.DEPT.remark}" style="width:250px;height: 100px;"/>
    		</TD>
    	</TR>
    	<TR>
    		<TD class="td" align="center">
    		<input type="submit" name="submit" value="修改" style="cursor:hand"/>
    		</TD>
    		<TD class="td" colspan="2" align="center">
    		<input type="button" onclick="window.location.href='${pageContext.request.contextPath}/deptAction/showDept.action'" value="返回" style="cursor:hand"/>
    		</TD>
    	</TR>
    </TABLE>
    </form>
  </body>
</html>
