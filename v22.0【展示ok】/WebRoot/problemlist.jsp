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
<title>Problem Set</title>
<link rel=stylesheet href='css/hoj.css' type='text/css'>
</head>
<body>
	<div id="wrapper">
		<jsp:include page="./include/header.jsp"></jsp:include>

		<div id=main>
			<script type="text/javascript" src="js/jquery-latest.js"></script>
			<script type="text/javascript" src="js/jquery.tablesorter.js"></script>
			<script type="text/javascript">
				$(document).ready(function() {
					$("#problemset").tablesorter();
				});
			</script>
			<h3 align='center'>
				<s:iterator begin="1" end="pageNumber" var="p">
					<s:if test="#p==nowPage">
						<!--是当前页，不显示链接-->
						<span class=red><s:property />
						</span>
					</s:if>
					<s:else>
						<a href="problemList.action?nowPage=<s:property />"><s:property />
						</a>
					</s:else>
				</s:iterator>
				<!-- <s:property value="pageList"/> -->
				<!-- <span class=red>1</span>&nbsp;<a href='problemset.php?page=2'>2</a>&nbsp;<a
					href='problemset.php?page=3'>3</a>&nbsp;<a
					href='problemset.php?page=4'>4</a>&nbsp;<a
					href='problemset.php?page=5'>5</a>&nbsp;<a
					href='problemset.php?page=6'>6</a>&nbsp;<a
					href='problemset.php?page=7'>7</a>&nbsp;<a
					href='problemset.php?page=8'>8</a>&nbsp;<a
					href='problemset.php?page=9'>9</a> -->
			</h3>
			<center>
				<table>
					<tr align='center' class='evenrow'>
						<td width='5'></td>
						<td width='50%' colspan='1'>
							<form class=form-search action=problem.php>
								Problem ID<input class="input-small search-query" type='text'
									name='id' size=5 style="height:24px">
								<button class="btn btn-mini" type='submit'>Go</button>
							</form></td>
						<td width='50%' colspan='1'>
							<form class="form-search">
								<input style="height:24px" type="text" name=search
									class="input-large search-query">
								<button type="submit" class="btn btn-mini">Search</button>
							</form></td>
					</tr>
				</table>

				<table id='problemset' width='90%' class='table table-striped'>
					<thead>

						<tr class='toprow'>
							<th width='5'></th>
							<th width='120'><A>Problem ID</A>
							</th>
							<th>Title</th>
							<th width='10%'>Source</th>
							<th style="cursor:hand" width=60>AC</th>
							<th style="cursor:hand" width=60>Submit</th>
						</tr>
					</thead>


					<tbody>
						<s:iterator value="problems" status="var">
						<s:if test="#var%2==0">
							<tr class='evenrow'>
						</s:if>
						<s:else>
							<tr class='oddrow'>
						</s:else>
							<td>
								<div class=none></div>
							</td>
							<td>
								<div class='center'><s:property value="problemId" /> </div>
							</td>
							<td>
								<div class='left'>
									<a href='problemDetails.action?problem.problemId=<s:property value="problemId" />'><s:property value="title"/> </a>
								</div>
							</td>
							<td>
								<div class='center'>
									<nobr><s:property value="source"/> </nobr>
								</div>
							</td>
							<td>
								<div class='center'>
									<a href='status.php?problem_id=<s:property value='problemId' />&jresult=4'><s:property value="solved"/> </a>
								</div>
							</td>
							<td>
								<div class='center'>
									<a href='status.php?problem_id=<s:property value='problemId' />'><s:property value="submit" /> </a>
								</div>
							</td>
						</tr>
					</s:iterator>
					</tbody>
				</table>
			</center>
			
			<h3 align='center'>
				<s:iterator begin="1" end="pageNumber" var="p">
					<s:if test="#p==nowPage">
						<!--是当前页，不显示链接-->
						<span class=red><s:property value="#p" />
						</span>
					</s:if>
					<s:else>
						<a href="problemList.action?nowPage=<s:property />"><s:property />
						</a>
					</s:else>
				</s:iterator>
				<!-- <s:property value="pageList"/> -->
				<!-- <span class=red>1</span>&nbsp;<a href='probl	emset.php?page=2'>2</a>&nbsp;<a
					href='problemset.php?page=3'>3</a>&nbsp;<a
					href='problemset.php?page=4'>4</a>&nbsp;<a
					href='problemset.php?page=5'>5</a>&nbsp;<a
					href='problemset.php?page=6'>6</a>&nbsp;<a
					href='problemset.php?page=7'>7</a>&nbsp;<a
					href='problemset.php?page=8'>8</a>&nbsp;<a
					href='problemset.php?page=9'>9</a> -->
			</h3>
			
			<jsp:include page="./include/footer.jsp"></jsp:include>
		</div>
	</div>
</body>
</html>
<!--not cached-->
