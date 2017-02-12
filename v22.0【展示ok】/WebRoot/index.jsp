<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<body>
<head>
<title>Welcome To Online Judge</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel=stylesheet href='./css/hoj.css' type='text/css'>
</head>
<body>
	<jsp:include page="./include/header.jsp"></jsp:include>
	<center>
	<table width=96%>
		<tr>
			<td>
			<td><font size=big><b>g</b>
			</font>-<font size=small>[chenym]</font>
		</tr>
		<tr>
			<td>
			<td>
		</tr>
		<tr>
			<td>
			<td><font size=big><b>Attention</b>
			</font>-<font size=small>[housebenz]</font>
		</tr>
		<tr>
			<td>
			<td>a test information from administrator
		</tr>
	</table>
	</center>
	<jsp:include page="./include/footer.jsp"></jsp:include>
</body>
</html>
