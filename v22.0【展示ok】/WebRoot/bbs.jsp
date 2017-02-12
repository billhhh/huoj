<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel=stylesheet href='./css/hoj.css' type='text/css'>
</head>
<body>
<div id="wrapper">

    <jsp:include page="include/header.jsp"></jsp:include>
<div id=main>
<title>HUST Online Judge WebBoard</title>
<center>
<div style="width:90%">
<div style="text-align:left;font-size:80%">
[ <a href="newpost.php">New Thread</a> ]</div>
<div style="float:left;text-align:left;font-size:80%">
Location : 
<a href="discuss.php">MainBoard</a></div>

<div style="float:right;font-size:80%;color:red;font-weight:bold">
</div>
<table style="clear:both; width:100%">
<tr align=center class='toprow'>
	<td width="2%"></td>
	<td width="3%"></td>
	<td width="4%">Prob</td>
	<td width="12%">Author</td>
	<td width="46%">Title</td>
	<td width="8%">Post Date</td>
	<td width="16%">Last Reply</td>
	<td width="3%">Re</td>
</tr>
<tr align=center class='evenrow'><td></td><td></td><td><a href="discuss.php?pid=1771&cid=">1771</a></td><td><a href="../userinfo.php?user=talent">talent</a></td><td><a href="thread.php?tid=11&cid=">无能为力啊，结果只能证明我不能帮女汉子</a></td><td>2013-12-12</td><td>2014-03-04 17:28:24</td><td>4</td></tr><tr align=center class='oddrow'><td></td><td></td><td></td><td><a href="../userinfo.php?user=ybping">ybping</a></td><td><a href="thread.php?tid=1&cid=">新系统</a></td><td>2011-03-15</td><td>2013-12-17 20:10:30</td><td>3</td></tr><tr align=center class='evenrow'><td></td><td></td><td><a href="discuss.php?pid=1101&cid=">1101</a></td><td><a href="../userinfo.php?user=201041919105">201041919105</a></td><td><a href="thread.php?tid=5&cid=">学生信息排序，能不能写明白点？</a></td><td>2011-05-12</td><td>2013-12-17 20:10:03</td><td>1</td></tr><tr align=center class='oddrow'><td></td><td></td><td><a href="discuss.php?pid=1087&cid=">1087</a></td><td><a href="../userinfo.php?user=200840512119">200840512119</a></td><td><a href="thread.php?tid=4&cid=">用词请准确些额</a></td><td>2011-05-06</td><td>2013-11-29 11:35:13</td><td>1</td></tr><tr align=center class='evenrow'><td></td><td></td><td></td><td><a href="../userinfo.php?user=201241842212">201241842212</a></td><td><a href="thread.php?tid=10&cid=">题号1019</a></td><td>2012-12-23</td><td>2012-12-23 13:48:38</td><td>0</td></tr><tr align=center class='oddrow'><td><td></td><td><a href="discuss.php?pid=1474&cid=">1474</a></td><td><a href="../userinfo.php?user=201041843104">201041843104</a></td><td><a href="thread.php?tid=3&cid=">RE。。。求数据</a></td><td>2011-03-30</td><td>2012-11-26 11:31:51</td><td>1</td></tr><tr align=center class='evenrow'><td></td><td></td><td><a href="discuss.php?pid=1039&cid=">1039</a></td><td><a href="../userinfo.php?user=201041919109">201041919109</a></td><td><a href="thread.php?tid=6&cid=">格式错误 - -!</a></td><td>2011-05-12</td><td>2012-11-06 11:22:21</td><td>4</td></tr><tr align=center class='oddrow'><td></td><td></td><td></td><td><a href="../userinfo.php?user=201141919106">201141919106</a></td><td><a href="thread.php?tid=9&cid=">为什么有些题目你们用的内存那么少？</a></td><td>2012-02-18</td><td>2012-03-30 09:23:26</td><td>1</td></tr><tr align=center class='evenrow'><td></td><td></td><td><a href="discuss.php?pid=1058&cid=">1058</a></td><td><a href="../userinfo.php?user=jiangyouge">jiangyouge</a></td><td><a href="thread.php?tid=2&cid=">大整数加减发敢不敢把输入条件写清楚。</a></td><td>2011-03-26</td><td>2011-12-07 17:28:52</td><td>1</td></tr><tr align=center class='oddrow'><td></td><td></td><td><a href="discuss.php?pid=1549&cid=">1549</a></td><td><a href="../userinfo.php?user=201041919109">201041919109</a></td><td><a href="thread.php?tid=8&cid=">谁能给点暴力的测试数据啊</a></td><td>2011-10-08</td><td>2011-10-08 22:46:38</td><td>0</td></tr><tr align=center class='evenrow'><td></td><td></td><td><a href="discuss.php?pid=1519&cid=">1519</a></td><td><a href="../userinfo.php?user=200941842122zyq">200941842122zyq</a></td><td><a href="thread.php?tid=7&cid=">注意考虑满足树的情况</a></td><td>2011-08-08</td><td>2011-08-08 09:35:25</td><td>0</td></tr>
</table> 
<br>
<span style = "font-size:75%; margin:0 10">[<b class="top3">Top</b>] 总置顶</span>
<span style = "font-size:75%; margin:0 10">[<b class="top2">Top</b>] 分区置顶</span>
<span style = "font-size:75%; margin:0 10">[<b class="top1">Top</b>] 题目置顶</span>
<span style = "font-size:75%; margin:0 10">[<b class="hot">Hot</b>] 热帖</span>
<span style = "font-size:75%; margin:0 10">[<b class="lock">Lock</b>] 锁帖</span>
</div>
</center>

<jsp:include page="include/footer.jsp"></jsp:include>
</div><!--end main-->
</div><!--end wrapper-->
</body>
</html>
<!--not cached-->