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
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><s:property value="" />
</title>
<link rel=stylesheet href='css/hoj.css' type='text/css'>
<!-- <link rel="next" href="submitpage.php?id=1000"> -->
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	<jsp:include page="include/header.jsp" />
	<div id="wrapper">
		<div id=main>
			<center>
				<h2><s:property value="problem.problemId"/>: <s:property value="problem.title" /> </h2>
				<br><a class="btn btn-primary" href="viewWord.action?pid=${problem.problemId}"><b>直接查看题目word文档</b></a><br><br>
				<span class=green>Time Limit: </span>${problem.timeLimit} Sec&nbsp;&nbsp;<span
					class=green>Memory Limit: </span>${problem.memoryLimit} MB<br> <span class=green>
					Submit:	</span>${problem.submit}&nbsp;&nbsp;<span class=green>
					Solved: </span>${problem.solved}<br>[
					<a href='submitpage.jsp?id=${problem.problemId}'>Submit</a>][<a
					href='problemstatus.php?id=1000'>Status</a>][<a
					href='bbs.php?pid=1000'>Web Board</a>]
			</center>
			<h2>Description</h2>
			<div class=content>${problem.description}</div>
			<h2>Input</h2>
			<div class=content>${problem.input}</div>
			<h2>Output</h2>
			<div class=content>${problem.output}</div>
			<h2>Sample Input</h2>
			<pre class=content><span class=sampledata>${problem.sampleInput }</span></pre>
			<h2>Sample Output</h2>
			<pre class=content><span class=sampledata>${problem.sampleOutput}</span></pre>
			<h2>HINT</h2>
			<div class=content>
				<p>${problem.hint}</p>
			</div>
			<h2>Source</h2>
			<div class=content>
				<p>
					<a href='problemset.php?search=POJ'>${problem.source}</a>
				</p>
			</div>
			<center>
				[<a href='submitpage.jsp?id=${problem.problemId}'>Submit</a>][<a
					href='problemstatus.php?id=1000'>Status</a>][<a
					href='bbs.php?pid=1000'>Web Board</a>]
			</center>
		</div>
		<!--end main-->
	</div>
	<!--end wrapper-->
	
	<jsp:include page="include/footer.jsp" />
</body>
</html>
