<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../base.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title></title>
</head>
<body>
<form method="post">
	

<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
    <div id="navMenubar">
<ul>
<li id="back"><a href="tolist.action">返回</a></li>
<li id="save"><a href="#" onclick="formSubmit('next.action','_self');this.blur();">下一篇</a></li>
<li id="save"><a href="#" onclick="formSubmit('pre.action','_self');this.blur();">上一篇</a></li>
</ul>
    </div>
</div>
</div>
</div>
     
<div class="textbox" id="centerTextbox">
    <div class="textbox-header">
    <div class="textbox-inner-header">
    <div class="textbox-title">
		浏览文章信息
    </div> 
    </div>
    </div>
<div>
 
    <div>
		<table class="commonTable" cellspacing="1">
	<div>
<input type="hidden"  name="id"value="${list.id }">
${list.content }
</div>
		</table>
	</div>
</div>
 
 
</form>
</body>
</html>

