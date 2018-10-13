<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>部门列表</title>
    <link rel="icon" type="image/x-icon" href="favicon.ico"/>
 	 <link rel="stylesheet" href="themes/default/easyui.css" type="text/css"></link>
  	<link rel="stylesheet" href="themes/icon.css" type="text/css"></link>
 	 <script type="text/javascript" src="js/jquery.min.js"></script>
 	<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
  	<script type="text/javascript" src="js/easyui-lang-zh_CN.js"></script>
  </head>
  <body>
  <div style="background-color: aqua;">部门搜索</div>
  <div>
  	<form name="form1" method="post" 
  	action="${pageContext.request.contextPath}/deptAction/searchDept.action">
  	<table>
  		<tr>
  			<td width="200px" align="left"><input name="searchText" id="searchText" value="${requestScope.searchText}" type="text"></td>
  			<td align="right">
  			<button type="submit" name="submit" id="submit">
  			<img src="${pageContext.request.contextPath}/resources/img/icon_search.png" 
  			width="15px" height="15px">
  			搜索
  			</button>
  			<button type="button" name="btn3" id="btn3" 
  			onclick="window.location.href='${pageContext.request.contextPath}/deptAction/showDept.action'">
  			<img src="${pageContext.request.contextPath}/resources/img/icon_delete.png" 
  			width="15px" height="15px">
  			清空
  			</button>
  			</td>
  		</tr>
  	</table>
  	</form>
  </div>
  <div style="background-color: aqua;">部门列表</div>
  <div id="checkBoxs">
  <button type="button"
  onclick="window.location.href='${pageContext.request.contextPath}/dept/addDept.jsp'">
  <img src="${pageContext.request.contextPath}/resources/img/icon_new.png" width="15px" height="15px">添加
  </button>
  <button type="button" id="editButton">
 <img src="${pageContext.request.contextPath}/resources/img/icon_edit.png"  width="15px" height="15px">修改
  </button>
  <button type="button" id="deleteButton">
 <img src="${pageContext.request.contextPath}/resources/img/icon_delete.png"  width="15px" height="15px">删除
  </button>
  </div>
  <div style="background-color:#FFDCB9;">
  <form name="form2">
    <table border="1" cellspacing="0" id="PowerTable">
    	<tr style="background-color:#B3D9D9;">
    		<td width="2%" style="background-color:white;">
    			<input type="checkbox" id="checkAll" name="checkAll"/>
    		</td>
    		<td width="20%">
    		部门名称
    		</td>
    		<td width="20%">
    		部门负责人
    		</td>
    		<td width="20%">
    		部门职能
    		</td>
    		<td width="20%">
    		备注
    		</td>
  		</tr>
  		<c:forEach var="dept" items="${requestScope.DEPTLIST}">
    		<tr>
    			<td style="background-color:white;">
    			<input type="checkbox" id="ids" name="ids" value="${dept.id}"/>
    		</td>
    		<td>
    			${dept.name}
    		</td>
    		<td>
    			${dept.manager}
    		</td>
    		<td>
    			${dept.work}
    		</td>
    		<td>
    			${dept.remark}
    		</td>
    		</tr>
    	</c:forEach>
    </table>
  </form>
  </div>
  <script type="text/javascript">
  		var checkAll=document.getElementById('checkAll');//全选按钮
  		var deleteButton=document.getElementById('deleteButton');//删除按钮
  		var editButton=document.getElementById('editButton');//编辑按钮
  		var ids=document.getElementsByName('ids');//form2的所有checkBox
  		for(let i=0;i<ids.length;i++)
  		{
  			ids[i].onclick=function()
  			{
  				checkAll.checked=true
  				for(let j=0;j<ids.length;j++)
  				{
  					if(ids[j].checked==false)
  					{
  						checkAll.checked=false
  					}
  				}
  			}
  		}
  		checkAll.onclick=function()
  		{
  			//alert('批量');
  			for(let i=0;i<ids.length;i++)
  				{
  					ids[i].checked=checkAll.checked
  				}
  		}	
  		deleteButton.onclick=function()
  		{
  			document.form2.action='${pageContext.request.contextPath}/deptAction/deleteDept.action'
  			document.form2.submit()
  		}
  		editButton.onclick=function()
  		{
  			document.form2.action='${pageContext.request.contextPath}/deptAction/findDept.action'
  			document.form2.submit()
  		}
  	</script>
  </body>
</html>
