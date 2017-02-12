<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>LOGIN</title>
<link rel=stylesheet href='./css/hoj.css' type='text/css'>
</head>

<body>
	<jsp:include page="include/header.jsp"></jsp:include>
	<center>
		<div id=main>
			<s:form action="login.action" method="post" theme="simple">
				<table algin=center>
					<tr>
						<td width=150>User ID:</td>
						<td width=200><s:textfield name="user.userId" > </s:textfield>
						<font color="red"><s:property value="errorInfo"/> </font> </td>
					</tr>
					<tr>
						<td>Password:
						<td><s:password name="user.password" />
					</tr>
					<tr>
						<td colspan=3><input name="submit" type="submit" size=10
							value="Submit">
					</tr>
				</table>
			</s:form>
		</div>
		<center>
			<jsp:include page="include/footer.jsp"></jsp:include>
</body>
</html>
