<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Ranklist</title>
	<link rel=stylesheet href='css/hoj.css' type='text/css'>
</head>
<body>
<jsp:include page="./include/header.jsp"></jsp:include>

	
<br>
<div id=main>
	<table align=center width=90%>
		<thead>
		<tr><td colspan=3 align=left>
			<form action=userinfo.php>  <!--搜索框未写-->
				User<input name=user>
				<input type=submit value=Go>
			</form></td>
			<!-- <td colspan=3 align=right>
			</td> -->
		</tr>
		<tr class="toprow">
				<td width=5% align=center><b>No.</b>
				<td width=10% align=center><b>User</b>
				<td width=55% align=center><b>Nick Name</b>
				<td width=10% align=center><b>AC</b>
				<td width=10% align=center><b>Submit</b>
				<td width=10% align=center><b>Ratio</b>
		</tr>
		</thead>
		<tbody>
			<s:iterator value="users" status="var">
				<s:if test="#var.Even">
					<tr class='evenrow'>
				</s:if>
				<s:else>
					<tr class='oddrow'>
				</s:else>
				<td><s:property value="#var.count+pageSize*nowPage"/> </td>
				<td><div class=center><a href='userinfo.php?user=<s:property value='userId' /> '><s:property value="userId"/> </a></div></td>
				<td><div class=center><s:property value="nick"/> </div></td>	
				<td><div class=center><a href='status.php?user_id=201141919106&jresult=4'><s:property value="solved"/> </a></div></td>
				<td><div class=center><a href='status.php?user_id=201141919106'><s:property value="submit" /> </a></div></td>
				<td>
					<s:if test="solved==0">0</s:if>
					<s:else>
					<s:property value="%{formatDouble(solved*1.0/submit*100)}" />
					</s:else>
					% <!-- AC率留下来的百分号 -->
				</td><!--调用userAction中的方法对double型数据保留两位小数  -->
			</s:iterator>
			</table>
	<center>
		<s:iterator begin="0" end="pageNumber-1" var="p">
			<s:if test="(#p%10)==0">
				<br>
			</s:if>
			
			<s:if test="#p==nowPage">
				 <!--是当前页，不显示链接-->
				<span class=red>
					<s:property value="#p*pageSize+1"/>-<s:property value="(#p+1)*pageSize"/>
				</span>
			</s:if>
			<s:else>
				<a href='rankList.action?nowPage=<s:property value='#p' />'><s:property value="#p*pageSize+1"/>-<s:property value="(#p+1)*pageSize"/></a>&nbsp;
			</s:else>
		</s:iterator>
	</center>
<jsp:include page="include/footer.jsp"></jsp:include>
</div><!--end main-->
</body>
</html>