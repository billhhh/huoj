<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">


<html>
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <meta http-equiv='refresh' content='60'>
        <title>Status</title>
        <link rel=stylesheet href='css/hoj.css' type='text/css'>
</head>
<body>
<div id="wrapper">
        <div id=head>
<h2><img id=logo src="img/logo.png"><span class="red">HUSTOJ</span></h2>
</div><!--end head-->
<div id=subhead>
	  <div id=menu class=navbar>
	  		<a  class='btn'  href="./"><i class="icon-home"></i>
		Home						
		</a>
		
		<a  class='btn '  href="bbs.php">
		<i class="icon-comment"></i>Web Board</a>
		<a  class='btn ' href="problemset.php">
		<i class="icon-question-sign"></i>ProblemSet</a>
		
	  <!-- <a  class='btn ' href="submitpage.php">
		<i class="icon-pencil"></i>编辑器</a>
		-->
		<a  class='btn   btn-warning' href="status.php">
		<i class="icon-check"></i>Status</a>
		
		<a class='btn ' href="ranklist.php">
		<i class="icon-signal"></i>Ranklist</a>
		
		<a class='btn '  href="contest.php">
		<i class="icon-fire"></i>Contest</a>
		
		<a class='btn ' href="recent-contest.php">
		<i class="icon-share"></i>Recent</a>
		
		<a class='btn ' href="faqs.php">
                <i class="icon-info-sign"></i>F.A.Qs</a>
		
			</div><!--end menu-->
<div id=profile >
<script src="include/profile.php?9409" ></script>
</div><!--end profile-->
</div><!--end subhead-->
<div id=broadcast class="container">
<marquee id=broadcast scrollamount=1 direction=up scrolldelay=250 onMouseOver='this.stop()' onMouseOut='this.start()';>
  OJ问题论坛发帖http://t.cn/zjBp4jd FAQ http://t.cn/zjHKbmN Linux问题看http://t.cn/aWnP1n </marquee>
</div>
<br>

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
                        <tr class='evenrow'><td>	187459</td><td>	<a href='userinfo.php?user=201341843226'>201341843226</a></td><td>	<div class=center><a href='problem.php?id=1015'>1015</a></div></td><td>	<span class='btn btn-success'>Accepted</span></td><td>	<div id=center class=red>952</div></td><td>	<div id=center class=red>0</div></td><td>	C</td><td>	191 B</td><td>	2014-03-30 18:51:57</td></tr><tr class='oddrow'><td>	187458</td><td>	<a href='userinfo.php?user=201341843226'>201341843226</a></td><td>	<div class=center><a href='problem.php?id=1014'>1014</a></div></td><td>	<span class='btn btn-success'>Accepted</span></td><td>	<div id=center class=red>952</div></td><td>	<div id=center class=red>0</div></td><td>	C</td><td>	139 B</td><td>	2014-03-30 18:31:44</td></tr><tr class='evenrow'><td>	187457</td><td>	<a href='userinfo.php?user=201341841206'>201341841206</a></td><td>	<div class=center><a href='problem.php?id=1337'>1337</a></div></td><td>	<span class='btn btn-danger'>Presentation Error</span></td><td>	<div id=center class=red>952</div></td><td>	<div id=center class=red>0</div></td><td>	C</td><td>	492 B</td><td>	2014-03-30 15:48:15</td></tr><tr class='oddrow'><td>	187456</td><td>	<a href='userinfo.php?user=201341841206'>201341841206</a></td><td>	<div class=center><a href='problem.php?id=1337'>1337</a></div></td><td>	<span class='btn btn-warning'>Compile Error</span></td><td>	<div id=center class=red>0</div></td><td>	<div id=center class=red>0</div></td><td>	C++</td><td>	499 B</td><td>	2014-03-30 15:47:21</td></tr><tr class='evenrow'><td>	187455</td><td>	<a href='userinfo.php?user=201341841206'>201341841206</a></td><td>	<div class=center><a href='problem.php?id=1337'>1337</a></div></td><td>	<span class='btn btn-warning'>Compile Error</span></td><td>	<div id=center class=red>0</div></td><td>	<div id=center class=red>0</div></td><td>	C++</td><td>	493 B</td><td>	2014-03-30 15:43:39</td></tr><tr class='oddrow'><td>	187454</td><td>	<a href='userinfo.php?user=201341841206'>201341841206</a></td><td>	<div class=center><a href='problem.php?id=1337'>1337</a></div></td><td>	<span class='btn btn-danger'>Presentation Error</span></td><td>	<div id=center class=red>952</div></td><td>	<div id=center class=red>0</div></td><td>	C</td><td>	489 B</td><td>	2014-03-30 15:42:16</td></tr><tr class='evenrow'><td>	187453</td><td>	<a href='userinfo.php?user=201341841206'>201341841206</a></td><td>	<div class=center><a href='problem.php?id=1342'>1342</a></div></td><td>	<span class='btn btn-success'>Accepted</span></td><td>	<div id=center class=red>952</div></td><td>	<div id=center class=red>0</div></td><td>	C</td><td>	552 B</td><td>	2014-03-30 15:29:41</td></tr><tr class='oddrow'><td>	187452</td><td>	<a href='userinfo.php?user=201341843306'>201341843306</a></td><td>	<div class=center><a href='problem.php?id=1090'>1090</a></div></td><td>	<span class='btn btn-success'>Accepted</span></td><td>	<div id=center class=red>952</div></td><td>	<div id=center class=red>0</div></td><td>	C</td><td>	540 B</td><td>	2014-03-30 13:17:57</td></tr><tr class='evenrow'><td>	187451</td><td>	<a href='userinfo.php?user=201341843306'>201341843306</a></td><td>	<div class=center><a href='problem.php?id=1090'>1090</a></div></td><td>	<span class='btn btn-danger'>Wrong Answer</span></td><td>	<div id=center class=red>952</div></td><td>	<div id=center class=red>0</div></td><td>	C</td><td>	525 B</td><td>	2014-03-30 13:08:15</td></tr><tr class='oddrow'><td>	187450</td><td>	<a href='userinfo.php?user=201341843306'>201341843306</a></td><td>	<div class=center><a href='problem.php?id=1090'>1090</a></div></td><td>	<span class='btn btn-warning'>Output Limit Exceed</span></td><td>	<div id=center class=red>1060</div></td><td>	<div id=center class=red>0</div></td><td>	C++</td><td>	518 B</td><td>	2014-03-30 13:05:37</td></tr><tr class='evenrow'><td>	187449</td><td>	<a href='userinfo.php?user=201341843306'>201341843306</a></td><td>	<div class=center><a href='problem.php?id=1090'>1090</a></div></td><td>	<span class='btn btn-danger'>Wrong Answer</span></td><td>	<div id=center class=red>952</div></td><td>	<div id=center class=red>0</div></td><td>	C</td><td>	548 B</td><td>	2014-03-30 12:44:13</td></tr><tr class='oddrow'><td>	187448</td><td>	<a href='userinfo.php?user=201341843306'>201341843306</a></td><td>	<div class=center><a href='problem.php?id=1090'>1090</a></div></td><td>	<span class='btn btn-warning'>Compile Error</span></td><td>	<div id=center class=red>0</div></td><td>	<div id=center class=red>0</div></td><td>	C</td><td>	542 B</td><td>	2014-03-30 12:04:12</td></tr><tr class='evenrow'><td>	187447</td><td>	<a href='userinfo.php?user=201341843306'>201341843306</a></td><td>	<div class=center><a href='problem.php?id=1090'>1090</a></div></td><td>	<span class='btn btn-warning'>Compile Error</span></td><td>	<div id=center class=red>0</div></td><td>	<div id=center class=red>0</div></td><td>	C++</td><td>	538 B</td><td>	2014-03-30 12:00:57</td></tr><tr class='oddrow'><td>	187446</td><td>	<a href='userinfo.php?user=201341843306'>201341843306</a></td><td>	<div class=center><a href='problem.php?id=1090'>1090</a></div></td><td>	<span class='btn btn-warning'>Compile Error</span></td><td>	<div id=center class=red>0</div></td><td>	<div id=center class=red>0</div></td><td>	C</td><td>	540 B</td><td>	2014-03-30 11:28:04</td></tr><tr class='evenrow'><td>	187445</td><td>	<a href='userinfo.php?user=201341843315'>201341843315</a></td><td>	<div class=center><a href='problem.php?id=1343'>1343</a></div></td><td>	<span class='btn btn-success'>Accepted</span></td><td>	<div id=center class=red>952</div></td><td>	<div id=center class=red>0</div></td><td>	C</td><td>	310 B</td><td>	2014-03-30 11:11:35</td></tr><tr class='oddrow'><td>	187444</td><td>	<a href='userinfo.php?user=201341843315'>201341843315</a></td><td>	<div class=center><a href='problem.php?id=1337'>1337</a></div></td><td>	<span class='btn btn-success'>Accepted</span></td><td>	<div id=center class=red>952</div></td><td>	<div id=center class=red>0</div></td><td>	C</td><td>	395 B</td><td>	2014-03-30 10:19:20</td></tr><tr class='evenrow'><td>	187443</td><td>	<a href='userinfo.php?user=201341843315'>201341843315</a></td><td>	<div class=center><a href='problem.php?id=1337'>1337</a></div></td><td>	<span class='btn btn-warning'>Compile Error</span></td><td>	<div id=center class=red>0</div></td><td>	<div id=center class=red>0</div></td><td>	C</td><td>	467 B</td><td>	2014-03-30 10:17:05</td></tr><tr class='oddrow'><td>	187442</td><td>	<a href='userinfo.php?user=201341843315'>201341843315</a></td><td>	<div class=center><a href='problem.php?id=1257'>1257</a></div></td><td>	<span class='btn btn-success'>Accepted</span></td><td>	<div id=center class=red>956</div></td><td>	<div id=center class=red>0</div></td><td>	C</td><td>	375 B</td><td>	2014-03-30 09:10:48</td></tr><tr class='evenrow'><td>	187441</td><td>	<a href='userinfo.php?user=201341843315'>201341843315</a></td><td>	<div class=center><a href='problem.php?id=1257'>1257</a></div></td><td>	<span class='btn btn-danger'>Presentation Error</span></td><td>	<div id=center class=red>952</div></td><td>	<div id=center class=red>0</div></td><td>	C</td><td>	385 B</td><td>	2014-03-30 09:09:45</td></tr><tr class='oddrow'><td>	187440</td><td>	<a href='userinfo.php?user=201341843315'>201341843315</a></td><td>	<div class=center><a href='problem.php?id=1256'>1256</a></div></td><td>	<span class='btn btn-success'>Accepted</span></td><td>	<div id=center class=red>968</div></td><td>	<div id=center class=red>0</div></td><td>	C</td><td>	317 B</td><td>	2014-03-30 08:56:26</td></tr>                        </tbody>
</table>

</div>
<div id=center>
[<a href=status.php?>Top</a>]&nbsp;&nbsp;[<a href=status.php?&top=187479>Previous Page</a>]&nbsp;&nbsp;[<a href=status.php?&top=187440&prevtop=187459>Next Page</a>]</div>



<div id=foot>
        <span class=center>
	
			<a href=setlang.php?lang=ko>한국어</a>&nbsp;
		<a href=setlang.php?lang=cn>中文</a>&nbsp;
		<a href=setlang.php?lang=fa>فارسی</a>&nbsp;
		<a href=setlang.php?lang=en>English</a>&nbsp;
		<a href=setlang.php?lang=th>ไทย</a>	<br>
		
	
		Anything about the Problems, Please Contact Admin:<a href="mailto:root@localhost">admin</a>
		
		<script type="text/javascript" charset="utf-8">
		(function(){
		  var _w = 86 , _h = 50;
		  var param = {
			url:location.href,
			type:'6',
			count:'1', /**是否显示分享数，1显示(可选)*/
			appkey:'', /**您申请的应用appkey,显示分享来源(可选)*/
			title:'', /**分享的文字内容(可选，默认为所在页面的title)*/
			pic:'', /**分享图片的路径(可选)*/
			ralateUid:'', /**关联用户的UID，分享微博会@该用户(可选)*/
			language:'zh_cn', /**设置语言，zh_cn|zh_tw(可选)*/
			rnd:new Date().valueOf()
		  }
		  var temp = [];
		  for( var p in param ){
			temp.push(p + '=' + encodeURIComponent( param[p] || '' ) )
		  }
		  document.write('<iframe allowTransparency="true" frameborder="0" scrolling="no" src="http://hits.sinajs.cn/A1/weiboshare.html?' + temp.join('&') + '" width="'+ _w+'" height="'+_h+'"></iframe>')
		})()
	</script>
		<br>
		All Copyright Reserved 2010-2013 <a href='./'>HUSTOJ</a> TEAM<br>
		<a href=gpl-2.0.txt><span class=green>GPL2.0</span></a> 2003-2013 <a href='http://code.google.com/p/hustoj/'>HUSTOJ Project</a> TEAM<br>
		
     	
	
</span>

</div><!--end foot-->
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


