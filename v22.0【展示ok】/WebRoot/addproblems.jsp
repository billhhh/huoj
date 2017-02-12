<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
<head>
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Content-Language" content="zh-cn">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>New Problem</title>
</head>
<body leftmargin="30" >

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel=stylesheet href='css/hoj.css' type='text/css'>

<h1 >Add New problem</h1>

<form method=POST action=problem_add.php>
<input type=hidden name=problem_id value="New Problem">
<p align=left>Problem Id:&nbsp;&nbsp;New Problem</p>
<p align=left>Title:<input class="input input-xxlarge" type=text name=title size=71></p>
<p align=left>Time Limit:<input type=text name=time_limit size=20 value=1>MS</p>
<p align=left>Memory Limit:<input type=text name=memory_limit size=20 value=128>KByte</p>
<p align=left>Description:<br><!--<textarea rows=13 name=description cols=80></textarea>-->

<input type="hidden" id="description" name="description" value="&lt;p&gt;&lt;/p&gt;" style="display:none" /><input type="hidden" id="description___Config" value="" style="display:none" /><iframe id="description___Frame" src="../fckeditor/editor/fckeditor.html?InstanceName=description&amp;Toolbar=Default" width="800" height="250" frameborder="0" scrolling="no"></iframe></p>

<p align=left>Input:<br><!--<textarea rows=13 name=input cols=80></textarea>-->

<input type="hidden" id="input" name="input" value="&lt;p&gt;&lt;/p&gt;" style="display:none" /><input type="hidden" id="input___Config" value="" style="display:none" /><iframe id="input___Frame" src="../fckeditor/editor/fckeditor.html?InstanceName=input&amp;Toolbar=Default" width="800" height="250" frameborder="0" scrolling="no"></iframe></p>

</p>
<p align=left>Output:<br><!--<textarea rows=13 name=output cols=80></textarea>-->


<input type="hidden" id="output" name="output" value="&lt;p&gt;&lt;/p&gt;" style="display:none" /><input type="hidden" id="output___Config" value="" style="display:none" /><iframe id="output___Frame" src="../fckeditor/editor/fckeditor.html?InstanceName=output&amp;Toolbar=Default" width="800" height="250" frameborder="0" scrolling="no"></iframe>
</p>
<p align=left>Sample Input:<br><textarea  class="input input-xxlarge"  rows=13 name=sample_input cols=80></textarea></p>
<p align=left>Sample Output:<br><textarea  class="input input-xxlarge"  rows=13 name=sample_output cols=80></textarea></p>
<p align=left>Test Input:<br><textarea  class="input input-xxlarge" rows=13 name=test_input cols=80></textarea></p>
<p align=left>Test Output:<br><textarea  class="input input-xxlarge"  rows=13 name=test_output cols=80></textarea></p>
<p align=left>Hint:<br>
<input type="hidden" id="hint" name="hint" value="&lt;p&gt;&lt;/p&gt;" style="display:none" /><input type="hidden" id="hint___Config" value="" style="display:none" /><iframe id="hint___Frame" src="../fckeditor/editor/fckeditor.html?InstanceName=hint&amp;Toolbar=Default" width="800" height="250" frameborder="0" scrolling="no"></iframe></p>
<p>SpecialJudge: N<input type=radio name=spj value='0' checked>Y<input type=radio name=spj value='1'></p>
<p align=left>Source:<br><textarea name=source rows=1 cols=70></textarea></p>
<p align=left>contest:
	<select  name=contest_id>
<option value=''>none</option>	</select>
</p>
<div align=center>
<input type=hidden name="postkey" value="7ED618DB4F">
<input type=submit value=Submit name=submit>
</div></form>
<p>
<span class=center>
	
		
	
		Anything about the Problems, Please Contact Admin:<a href="mailto:root@localhost">admin</a>
		<br>
		All Copyright Reserved 2010-2013 <a href='./'>HUSTOJ</a> TEAM<br>
		<a href=gpl-2.0.txt><span class=green>GPL2.0</span></a> 2003-2013 <a href='http://code.google.com/p/hustoj/'>HUSTOJ Project</a> TEAM<br>
		
     	
	
</span>
</body></html>

