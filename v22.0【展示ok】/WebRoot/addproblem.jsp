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
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Content-Language" content="zh-cn">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel=stylesheet href='css/hoj.css' type='text/css'>
<title>New Problem</title>
</head>
<body leftmargin="30">
	<center>
		<h1>Add New problem</h1>

		<s:form action="addproblem.action" method="post" theme="simple">
			<input type=hidden name=problem_id value="New Problem">
			<p align=left>Problem Id:&nbsp;&nbsp;New Problem</p>
			<p align=left>
				Title:<input class="input input-xxlarge" type=text name="problem.title"
					size=71>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<a class="btn btn-primary" href="upload.jsp?isnew=yes"><b>上传题目word文档</b></a>
			</p>
			<p align=left>
				Time Limit:<input type=text name="problem.timeLimit" size=20 value=1000>MS
			</p>
			<p align=left>
				Memory Limit:<input type=text name="problem.memoryLimit" size=20 value=128000>KByte
			</p>
			<p align=left>
				Description:<br>
				<textarea class="input input-xxlarge" rows=13 name="problem.description"
					cols=80></textarea>
			</p>

			<p align=left>
				Input:<br>
				<textarea class="input input-xxlarge" rows=13
					name="problem.input" cols=80></textarea>
			</p>

			<p align=left>
				Output:<br>
				<textarea class="input input-xxlarge" rows=13 name="problem.output"
					cols=80></textarea>
			</p>

			<p align=left>
				Sample Input:<br>
				<textarea class="input input-xxlarge" rows=13 name="problem.sampleInput"
					cols=80></textarea>
			</p>
			<p align=left>
				Sample Output:<br>
				<textarea class="input input-xxlarge" rows=13 name="problem.sampleOutput"
					cols=80></textarea>
			</p>
			<p align=left>
				Test Input:<br>
				<textarea class="input input-xxlarge" rows=13 name="problem.testInput"
					cols=80></textarea>
			</p>
			<p align=left>
				Test Output:<br>
				<textarea class="input input-xxlarge" rows=13 name="problem.testOutput"
					cols=80></textarea>
			</p>
			<p align=left>
				Hint:<br>
				<textarea class="input input-xxlarge" rows=13 name="problem.hint"
					cols=80></textarea>
			</p>

			<p>
				SpecialJudge: N<input type=radio name=spj value='0' checked>Y<input
					type=radio name=spj value='1'>
			</p>
			<p align=left>
				Source:<br>
				<textarea name="problem.source" rows=1 cols=70></textarea>
			</p>
			<p align=left>
				contest: <select name=contest_id>
					<option value=''>none</option>
				</select>
			</p>
			<div align=center>
				<input type=hidden name="postkey" value="7ED618DB4F"> <input
					type=submit value=Submit name=submit>
			</div>
		</s:form>
		<p>
			<span class=center> Anything about the Problems, Please
				Contact Admin:<a href="mailto:root@localhost">admin</a> </span>
		</p>
		</center>
</body>
</html>
