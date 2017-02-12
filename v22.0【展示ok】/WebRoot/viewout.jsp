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
<body>
<head>
<title>Welcome To Online Judge</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel=stylesheet href='./css/hoj.css' type='text/css'>
</head>
<body>
	<jsp:include page="./include/header.jsp"></jsp:include>
	
	<br><br><br>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	题目标准输出为：<textarea style="width:28%" cols=180 rows=20 disabled="disabled"><s:property value="stdOutInfo" /></textarea>
	
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	用户代码输出为：<textarea style="width:28%" cols=180 rows=20 disabled="disabled"><s:property value="outInfo" /></textarea><br>
	
	<jsp:include page="./include/footer.jsp"></jsp:include>
</body>
</html>
