<%@ page language="java" import="java.util.*,java.sql.Timestamp,com.model.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

String result="Finished";
//Timestamp nowTime=new Timestamp(new Date().getTime());
Timestamp nowTime=new Timestamp(System.currentTimeMillis());
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

 <html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Contest</title>
	<link rel=stylesheet href='css/hoj.css' type='text/css'>
</head>
<body>

	<jsp:include page="./include/header.jsp"></jsp:include>
<br>

<div id=main>

<center>
<table width=90%>
<h2>Contest List</h2>ServerTime:<span id=nowdate></span>

<tr class="toprow">
	<td width=10% align=center><b>ID</b>
	<td width=50% align=center><b>Name</b>
	<td width=30% align=center><b>Status</b>
	<td width=10% align=center><b>Private</b>
</tr>
	<s:set name="nowTime" value="new java.util.Date()"></s:set>

	<tbody>
	<s:iterator value="contests" status="var">		<!--此处的var代表行数  -->
				<s:if test="#var.Even">
					<tr class='evenrow'>
				</s:if>
				<s:else>
					<tr class='oddrow'>
				</s:else>
				<td><div class=center><s:property value="contestId"/></div></td>
				<td><div class=left><a href='???'><s:property value="title" /> </a></div></td>	
				<td><div class=center>
				<s:set name="lessTime" value="endTime"></s:set>
				<s:if test='#lessTime == null || #lessTime.getTime()>#nowTime.getTime()'>Running</s:if>
				<s:else>Finished</s:else>
				</div></td>
				<td><div class=center><s:property value="privateornot" /></div></td>
			</s:iterator>

	</table>
</center>

<!-- 分页的功能 -->
<center>
		<s:iterator begin="0" end="pageNumber-1" var="p">
			<s:if test="(#p%10)==0">
				<br>
			</s:if>
			
			<s:if test="#p==nowPage">
				 <!--是当前页，不显示链接-->
				<span class=red>
					<s:property value="#p*pageSize+1"/>-<s:property value="(#p+1)*pageSize"/>
				</span>
			</s:if>
			<s:else>
				<a href='contestList.action?nowPage=<s:property value='#p' />'><s:property value="#p*pageSize+1"/>-<s:property value="(#p+1)*pageSize"/></a>&nbsp;
			</s:else>
		</s:iterator>
	</center>

		
<script>
var diff=new Date("2014/05/25 14:26:38").getTime()-new Date().getTime();
//alert(diff);
function clock()
    {
      var x,h,m,s,n,xingqi,y,mon,d;
      var x = new Date(new Date().getTime()+diff);
      y = x.getYear()+1900;
      if (y>3000) y-=1900;
      mon = x.getMonth()+1;
      d = x.getDate();
      xingqi = x.getDay();
      h=x.getHours();
      m=x.getMinutes();
      s=x.getSeconds();
  
      n=y+"-"+mon+"-"+d+" "+(h>=10?h:"0"+h)+":"+(m>=10?m:"0"+m)+":"+(s>=10?s:"0"+s);
      //alert(n);
      document.getElementById('nowdate').innerHTML=n;
      setTimeout("clock()",1000);
    } 
    clock();
</script>


<jsp:include page="include/footer.jsp"></jsp:include>
</div><!--end main-->

</body>
</html>
<!--not cached-->

