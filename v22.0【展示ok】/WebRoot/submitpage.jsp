<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
			
//如果未登录，重定向到login页面
if(request.getSession().getAttribute("uid") == null)
	response.sendRedirect("login.jsp");
	
	int pid=Integer.parseInt(request.getParameter("id"));
	
	request.getSession().setAttribute("pid", pid);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>Submit</title>
        <link rel=stylesheet href='css/hoj.css' type='text/css'>
</head>
<body>

	<jsp:include page="./include/header.jsp"></jsp:include>
<br>

<div id=main>
        <center>
<script language="Javascript" type="text/javascript" src="edit_area/edit_area_full.js"></script>
<script language="Javascript" type="text/javascript">

editAreaLoader.init({
                id: "source"            
                ,start_highlight: true
                ,allow_resize: "both"
                ,allow_toggle: true
                ,word_wrap: true
                ,language: "en"
                ,syntax: "cpp"  
                        ,font_size: "8"
                ,syntax_selection_allow: "basic,c,cpp,java,pas,perl,php,python,ruby"
                        ,toolbar: "search, go_to_line, fullscreen, |, undo, redo, |, select_font,syntax_selection,|, change_smooth_selection, highlight, reset_highlight, word_wrap, |, help"          
        });
</script>
<script src="include/checksource.js"></script>
<script src="include/jquery-latest.js"></script>


<s:form action="submit.action" method="post" theme="simple">
Problem <span class=blue><b><%=pid %></b></span>


<br>
Language:
<select id="language" name="context.language">
<option value=0 selected>
                        C
                 </option><option value=1 >
                        C++
                 </option><option value=2 >
                        Pascal
                 </option><option value=3 >
                        Java
                 </option></select>
<br>

<textarea style="width:80%" cols=180 rows=20 id="source" name="context.source"></textarea><br>

<br>
<br>

<td colspan=3><input name="submit" class="btn btn-info" type="submit" size=10 value="Submit">
</s:form>

<iframe name=testRun width=0 height=0 src="about:blank"></iframe>
</center>
<script>
 var sid=0;
 var i=0;
  var judge_result=['Pending','Pending Rejudging','Compiling','Running & Judging','Accepted','Presentation Error','Wrong Answer','Time Limit Exceed','Memory Limit Exceed','Output Limit Exceed','Runtime Error','Compile Error','Compile OK','Test Running Done',''];

function print_result(solution_id)
{
sid=solution_id;
$("#out").load("status-ajax.php?tr=1&solution_id="+solution_id);

}

function fresh_result(solution_id)
{
sid=solution_id;
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
     var tb=window.document.getElementById('result');
     var r=xmlhttp.responseText;
     var ra=r.split(",");
//     alert(r);
//     alert(judge_result[r]);
      var loader="<img width=18 src=image/loader.gif>";  
     var tag="span";
     if(ra[0]<4) tag="span disabled=true";
     else tag="a";
     tb.innerHTML="<"+tag+" href='reinfo.php?sid="+solution_id+"' class='badge badge-info' target=_blank>"+judge_result[ra[0]]+"</"+tag+">";
     if(ra[0]<4)tb.innerHTML+=loader;
     tb.innerHTML+="Memory:"+ra[1]+"kb&nbsp;&nbsp;";
     tb.innerHTML+="Time:"+ra[2]+"ms";
     if(ra[0]<4)
        window.setTimeout("fresh_result("+solution_id+")",2000);
     else
        window.setTimeout("print_result("+solution_id+")",2000);
    }
  }
xmlhttp.open("GET","status-ajax.php?solution_id="+solution_id,true);
xmlhttp.send();
}
function getSID(){
  var ofrm1 = document.getElementById("testRun").document;  
  var ret="0";
    if (ofrm1==undefined)
    {
        ofrm1 = document.getElementById("testRun").contentWindow.document;
        var ff = ofrm1;
       ret=ff.innerHTML;
    }
    else
    {
        var ie = document.frames["frame1"].document;
        ret=ie.innerText;
    }
  return ret+"";
}

var count=0;

     var  handler_interval;
function do_test_run(){ 
     if( handler_interval) window.clearInterval( handler_interval);
          var loader="<img width=18 src=image/loader.gif>";
          var tb=window.document.getElementById('result');
          tb.innerHTML=loader;
  if(typeof(eAL) != "undefined"){   eAL.toggle("source");eAL.toggle("source");}
        

        var mark="problem_id";
        var problem_id=document.getElementById(mark);
        problem_id.value=0;
        document.getElementById("frmSolution").target="testRun";
        document.getElementById("frmSolution").submit();
        document.getElementById("TestRun").disabled=true;
        document.getElementById("Submit").disabled=true;
        count=20;
         handler_interval= window.setTimeout("resume();",1000);
       
}
     
  function resume(){
  	count--;
        var s=document.getElementById('Submit');
        var t=document.getElementById('TestRun');
        if(count<0){
  		s.disabled=false;
  		t.disabled=false; 
                s.value="Submit";
        	t.value="Test";
                if( handler_interval) window.clearInterval( handler_interval);
        }else{
        	s.value="Submit("+count+")";
        	t.value="Test("+count+")";
                window.setTimeout("resume();",1000);
        
        }
  }
</script>

<jsp:include page="include/footer.jsp"></jsp:include>

</div><!--end main-->
</body>
</html>
<!--not cached-->

