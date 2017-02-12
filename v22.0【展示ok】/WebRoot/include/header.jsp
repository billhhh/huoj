<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Welcome To Online Judge</title>
<link rel=stylesheet href='css/hoj.css' type='text/css'>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/js.js"></script>
<script language="javascript" type="text/javascript" src="js/jquery-latest.js"></script>
</head>
<body>
	<div id="wrapper">
		<div id=head>
			<h2>
				<img id=logo src="./img/logo.png"><span
					class="red">HUNAUOJ</span>
			</h2>
		</div>
		<!--end head-->
		<div id=subhead >
			<div id=menu class=navbar>
				<table align="center">
				<tr style="z-index: 10"><td style="z-index: 10">
				<ul>
					<li>
						<a class='btn' href="./"><i class="icon-home"></i> Home </a>
					</li>
					<li>
						 <a	class='btn ' href="bbs.jsp"> <i class="icon-comment"></i>Web Board</a>
					</li>
					<li>
						 <a class='btn ' href="problemList.action"> <i class="icon-question-sign"></i>Problem List</a>
					</li>
					<li>
						<a class='btn ' href="statusList.action?nowPage=1&page=next"> <i class="icon-check"></i>Status</a>
					</li>
					<li>
						<a class='btn ' href="rankList.action"> <i class="icon-signal"></i>Ranklist</a>
					</li>
					<li id="yt_menu_li"  class="menu2">
						<a class='btn btn_contest'><i class="icon-fire"></i>Online Contests</a><br>
						<div class="list">
						<a class='btn btn_contest' href="contestList.action?flag=0"><i class="icon-leaf"></i>All Contests</a><br>
						<a class='btn btn_contest' href="contestList.action?flag=1"><i class="icon-eye-open"></i>Current Contests</a><br>
						</div>
					</li>
					<li>
						<a class='btn ' href="http://localhost/web1/recent-contest.php"> <i class="icon-share"></i>Recent</a>
					</li>
					<li>
						<a class='btn ' href="faqs.jsp"> <i class="icon-info-sign"></i>F.A.Qs</a>
					</li>
				</ul>
				</td></tr >
				</table>
			</div>
			<!--end menu-->
			<div id=profile>
				<s:if test="#session.uid==null">
					<a href="regist.jsp">regist</a>
					<a href="login.jsp">login</a>
				</s:if>
				
				<s:elseif test="#session.uprivilege!=null">
					<a href=""><s:property value="#session.uid"/> </a>
					<a href="logout.action">注销</a>
					<a href="userInfo.action">修改个人信息</a>
					<a href="admininclude.jsp">Admin</a>
				</s:elseif>
				
				<s:else>
					<a href=""><s:property value="#session.uid"/> </a>
					<a href="logout.action">注销</a>
					<a href="userInfo.action">修改个人信息</a>
				</s:else>
				<!--待开发  -->
			</div>
			<!--end profile-->
		</div>
		<!--end subhead-->
		<div id=broadcast class="container" >
			<marquee class="test"  id="broadcast" scrollamount=1 direction=up scrolldelay=250
				onMouseOver='this.stop()' onMouseOut='this.start()';>
				OJ问题论坛发帖http://t.cn/zjBp4jd FAQ http://t.cn/zjHKbmN
				Linux问题看http://t.cn/aWnP1n </marquee>
		</div>
</div>
</body>
</html>
