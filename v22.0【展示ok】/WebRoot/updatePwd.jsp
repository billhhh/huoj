<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'updatePwd.jsp' starting page</title>
    
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
   		<jsp:include page="include/header.jsp"></jsp:include>
   		 <s:form action="updatePwd" method="post" theme="simple">
	<br><br>
	<center><table>
		<tr><td colspan=2 height=40 width=500>&nbsp;&nbsp;&nbsp;Update Information</tr>
		<tr><td width=25%>User ID:</td>
			<td width=75%><s:property value="#session.uid"/> </td>
		</tr>
		<tr><td>old password:</td>
			<td><s:password name="oldPwd"  />
		</tr>
		<tr><td>new password:</td>
			<td><s:password name="user.password" />
		</tr>
		<tr><td>repeat:</td>
			<td><s:password />
		</tr>
		<tr><td>
			<td><input value="Submit" name="submit" type="submit">
				&nbsp; &nbsp;
				<input value="Reset" name="reset" type="reset">
		</tr>
	</table></center>
	</s:form>
   		<jsp:include page="include/footer.jsp"></jsp:include>
  </body>
</html>
