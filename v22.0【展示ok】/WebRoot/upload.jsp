<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

String isNew=request.getParameter("isnew");

//request.setAttribute("haha", isNew);

//System.out.println("这在upload.jsp页面"+isNew);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 <head>
 <title>文件上传</title>
 <meta http-equiv="Content-Type" content="text/html; charset=gb2312">
 </head>
 
 <body>
 <jsp:include page="include/header.jsp"></jsp:include>
 <p>&nbsp;</p>
 <h1 align="center">上传文件选择</h1><br>
 
 <center>
 <form action="doUpload.action?isnew=<%=isNew %>" method="post" enctype="multipart/form-data">
     <table>
	  		<tr>
	  			<td>上传文件:</td>
	  			<td><input type="file" name="myFile"></td>
	  		</tr>
	  		<tr>
	  			<td><input type="submit" value="上传"></td>
	  			<td><input type="reset"></td>
	  		</tr>
	  	</table>
 </form>
 </center>
 <jsp:include page="include/footer.jsp"></jsp:include>
 </body>
 </html>
