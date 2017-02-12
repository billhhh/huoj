<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>Register Page</title>
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
	<jsp:include page="./include/header.jsp"></jsp:include>
	<s:form action="regist.action" method="post" theme="simple">
		<center>
			<table>
				<tr>
					<td colspan=2 height=40 width=500>&nbsp;&nbsp;&nbsp;Register
						Information
				</tr>
				<tr>
					<td width=25%>User ID:</td>
					<td width=75%><s:textfield name="user.userId" size="20"></s:textfield>* <font color="red"><s:property value="errorInfo"/> </font> </td>
					
					<!-- <input name="user.userId" size=20 type=text>* -->
				</tr>
				<tr>
					<td>Nick Name:</td>
					<td><s:textfield name="user.nick" size="30"></s:textfield></td>
					<!-- <input name="user.nick" size=50 type=text> -->
				</tr>
				<tr>
					<td>Password:</td>
					<td><s:password name="user.password" size="20"></s:password>*</td>
					<!-- <input name="user.password" size=20 type=password>* -->
				</tr>
				<tr>
					<td>Repeat Password:</td>
					<td><input size=20 type=password>*</td>
					
				</tr>
				<tr>
					<td>School:</td>
					<td><s:textfield name="user.school" size="30"></s:textfield></td>
					<!-- <input name="user.school" size=30 type=text> -->
				</tr>
				<tr>
					<td>Email:</td>
					<td><s:textfield name="user.email" size="30" /></td>
					<!-- <input name="user.email" size=30 type=text> -->
				</tr>
				<tr>
					<td>
					<td><input value="Submit" name="submit" type="submit">
						&nbsp; &nbsp; <input value="Reset" name="reset" type="reset">
				</tr>
			</table>
		</center>
	</s:form>
<jsp:include page="./include/footer.jsp"></jsp:include>
</body>
</html>
