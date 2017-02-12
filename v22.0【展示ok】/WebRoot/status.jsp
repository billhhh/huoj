<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">


<html>
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <meta http-equiv="refresh" content="60">
        <title>Status</title>
        <link rel=stylesheet href='css/hoj.css' type='text/css'>
</head>
<body>
<jsp:include page="./include/header.jsp"></jsp:include>
<div id="wrapper">
        
<br><br><br>

<div id=main>



<div id=center class="input-append">
<form id=simform action="status.php" method="get">
Problem ID:<input class="input-mini" style="height:24px" type=text size=4 name=problem_id value=''>
User:<input class="input-mini" style="height:24px" type=text size=4 name=user_id value=''>
Language:<select class="input-small" size="1" name="language">
<option value='-1' selected>All</option><option value=0>C</option><option value=1>C++</option><option value=2>Pascal</option><option value=3>Java</option><option value=4>Ruby</option><option value=5>Bash</option><option value=6>Python</option><option value=7>PHP</option><option value=8>Perl</option><option value=9>C#</option><option value=10>Obj-C</option><option value=11>FreeBasic</option><option value=12>Other Language</option></select>
Result:<select class="input-small" size="1" name="jresult">
<option value='-1' selected>All</option><option value='4'>AC</option><option value='5'>PE</option><option value='6'>WA</option><option value='7'>TLE</option><option value='8'>MLE</option><option value='9'>OLE</option><option value='10'>RE</option><option value='11'>CE</option><option value='0'>PD</option><option value='1'>PR</option><option value='2'>CI</option><option value='3'>RJ</option></select></select>

<input type=submit class='input'  value='Search'></form></div>

<div id=center>
<table id=result-tab class="table table-striped content-box-header" align=center width=80%>
<thead>
<tr  class='success toprow' >
<th >RunID<th >User<th >Problem<th >Result<th >Memory<th >Time<th >Language<th >Code Length<th >Submit Time</tr>
</thead>

<tbody>
	<s:iterator value="StatusItems" status="var">
	<s:if test="#var%2==0">
		<tr class='evenrow'>
	</s:if>
	<s:else>
		<tr class='oddrow'>
	</s:else>
		<td>
			<s:if test="#session.uprivilege!=null">
				<div class='center'><a href='outView.action?outSolutionId=<s:property value="solutionId" />'><s:property value="solutionId" /> </a></div>
			</s:if>
			<s:else>
				<div class='center'><s:property value="solutionId" /> </div>
			</s:else>
		</td>
		<td>
			<div class='left'>
				<a href='?'><s:property value="userId"/> </a>
			</div>
		</td>
		<td>
			<div class='center'>
				<a href='problemDetails.action?problem.problemId=<s:property value="problemId" />'><s:property value="problemId"/> </a>
			</div>
		</td>
		<td>
			<div class='center'>
			<!-- 待开发，result编号 -->
			<s:if test="result==0">
				Waiting
			</s:if>
			<s:elseif test="result==1">
				CompileError
			</s:elseif>
			<s:elseif test="result==2">
				Running
			</s:elseif>
			<s:elseif test="result==3">
				RuntimeErrorTimeLimit
			</s:elseif>
			<s:elseif test="result==4">
				TimeLimit
			</s:elseif>
			<s:elseif test="result==5">
				MemoryLimit
			</s:elseif>
			<s:elseif test="result==6">
				WrongAnswer
			</s:elseif>
			<s:elseif test="result==7">
				Accepted
			</s:elseif>
			</div>
		</td>
		<td>
			<div class='center'>
				<s:property value="memory" />
			</div>
		</td>
		<td>
			<div class='center'>
				<s:property value="time" />
			</div>
		</td>
		<td>
			<div class='center'>
			<s:if test="language==1">
				C++
			</s:if>
			<s:elseif test="language==0">
				C
			</s:elseif>
			</div>
		</td>
		<td>
			<div class='center'>
				<s:property value="codeLength" />
			</div>
		</td>
		<td>
			<div class='center'>
				<s:property value="inDate" />
			</div>
		</td>
</s:iterator>
</tbody>


</table>
</div>
<div id=center>
[<a href=statusList.action?nowPage=1>Top</a>]&nbsp;&nbsp;
<s:if test="nowPage>2"> 	
[<a href="statusList.action?nowPage=<s:property value="nowPage"/>&page=previous">Previous Page</a>]&nbsp;&nbsp;
</s:if>
<s:else>
[Previous Page]&nbsp;&nbsp;
</s:else>
[<a href="statusList.action?nowPage=<s:property value='nowPage'/>&page=next">Next Page</a>]</div>

<jsp:include page="./include/footer.jsp"></jsp:include>
</div><!--end main-->
</div><!--end wrapper-->
</body>
<script type="text/javascript">
  var i=0;
  var judge_result=['Pending','Pending Rejudging','Compiling','Running & Judging','Accepted','Presentation Error','Wrong Answer','Time Limit Exceed','Memory Limit Exceed','Output Limit Exceed','Runtime Error','Compile Error','Compile OK','Test Running Done',''];
//alert(judge_result[0]);
function auto_refresh(){
        var tb=window.document.getElementById('result-tab');
                // alert(tb);
        var rows=tb.rows;
        for(var  i=1;i<rows.length;i++){
                var cell=rows[i].cells[3].innerHTML;
                var sid=rows[i].cells[0].innerHTML;
          if(cell.indexOf(judge_result[0])!=-1||cell.indexOf(judge_result[2])!=-1||cell.indexOf(judge_result[3])!=-1){
        //alert(sid);
                fresh_result(sid);
                }
        }
}
function findRow(solution_id){
    var tb=window.document.getElementById('result-tab');
     var rows=tb.rows;

      for(var i=1;i<rows.length;i++){
                var cell=rows[i].cells[0];
//              alert(cell.innerHTML+solution_id);
        if(cell.innerHTML==solution_id) return rows[i];
      }
}

function fresh_result(solution_id)
{
var xmlhttp;
if (window.XMLHttpRequest)
  {// code for IE7+, Firefox, Chrome, Opera, Safari
  xmlhttp=new XMLHttpRequest();
  }
else
  {// code for IE6, IE5
  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
  }
xmlhttp.onreadystatechange=function()
  {
  if (xmlhttp.readyState==4 && xmlhttp.status==200)
    {
     var tb=window.document.getElementById('result-tab');
     var row=findRow(solution_id);
     //alert(row);
     var r=xmlhttp.responseText;
     var ra=r.split(",");
//     alert(r);
//     alert(judge_result[r]);
      var loader="<img width=18 src=image/loader.gif>";
     row.cells[3].innerHTML="<span class='btn btn-warning'>"+judge_result[ra[0]]+"</span>"+loader;
     row.cells[4].innerHTML=ra[1];
     row.cells[5].innerHTML=ra[2];
     if(ra[0]<4)
        window.setTimeout("fresh_result("+solution_id+")",2000);
     else
        window.location.reload();

    }
  }
xmlhttp.open("GET","status-ajax.php?solution_id="+solution_id,true);
xmlhttp.send();
}
//
auto_refresh();
</script>

</html>
<!--not cached-->

