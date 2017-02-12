<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags"  prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'admin.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<!-- 这里引用css文件 -->
	<link rel="stylesheet" type="text/css" href="css/hoj.css">

  </head>
  
  <body>
<hr>
<h4>
<ol>
	<li>
		<a class="btn btn-primary" href="index.jsp" target="main"><b>SeeOJ</b></a>
	</li><li>
		<a class="btn btn-primary" href="http://localhost/web1/admin/news_add_page.php" target="main"><b>AddNews</b></a>
	</li><li>
		<a class="btn btn-primary" href="http://localhost/web1/admin/news_list.php" target="main"><b>NewsList</b></a>
		
	</li><li>
		<a class="btn btn-primary" href="addproblem.jsp" target="main"><b>AddProblem</b></a>
	</li><li>
		<a class="btn btn-primary" href="http://localhost/web1/admin/problem_list.php" target="main"><b>ProblemList</b></a>
		
</li><li>
	<a class="btn btn-primary" href="http://localhost/web1/admin/contest_add.php" target="main"><b>AddContest</b></a>
</li><li>
	<a class="btn btn-primary" href="http://localhost/web1/admin/contest_list.php" target="main"><b>ContestList</b></a>
</li><li>
	<a class="btn btn-primary" href="http://localhost/web1/admin/team_generate.php" target="main"><b>TeamGenerator</b></a>
</li><li>
	<a class="btn btn-primary" href="http://localhost/web1/admin/setmsg.php" target="main"><b>SetMessage</b></a>
</li><li>
	<a class="btn btn-primary" href="http://localhost/web1/admin/changepass.php" target="main"><b>ChangePassWD</b></a>
</li><li>
	<a class="btn btn-primary" href="http://localhost/web1/admin/rejudge.php" target="main"><b>Rejudge</b></a>
</li><li>
	<a class="btn btn-primary" href="http://localhost/web1/admin/privilege_add.php" target="main"><b>AddPrivilege</b></a>
</li><li>
	<a class="btn btn-primary" href="http://localhost/web1/admin/privilege_list.php" target="main"><b>PrivilegeList</b></a>
</li><li>
	<a class="btn btn-primary" href="http://localhost/web1/admin/source_give.php" target="main"><b>GiveSource</b></a>
</li><li>
	<a class="btn btn-primary" href="http://localhost/web1/admin/problem_export.php" target="main"><b>ExportProblem</b></a>
</li><li>
	<a class="btn btn-primary" href="http://localhost/web1/admin/problem_import.php" target="main"><b>ImportProblem</b></a>
</li><li>
	<a class="btn btn-primary" href="http://localhost/web1/admin/update_db.php" target="main"><b>UpdateDatabase</b></a>

</li><li>
	<a class="btn btn-primary" href="http://code.google.com/p/hustoj/" target="_blank"><b>HUSTOJ</b></a>
</li><li>
	<a class="btn btn-primary" href="http://code.google.com/p/freeproblemset/" target="_blank"><b>FreeProblemSet</b></a>

</li></ol>
	<a href="http://localhost/web1/admin/problem_copy.php" target="main" title="Create your own data"><font color="eeeeee">CopyProblem</font></a> <br>
	<a href="http://localhost/web1/admin/problem_changeid.php" target="main" title="Danger,Use it on your own risk"><font color="eeeeee">ReOrderProblem</font></a>
   
</h4><h4>


</h4>
  </body>
</html>
