<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../base.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title></title>
<script src="${pageContext.request.contextPath}/wordexport/jquery-2.1.1.min.js"></script>
<script	src="${pageContext.request.contextPath}/wordexport/FileSaver.js"></script>
<script	src="${pageContext.request.contextPath}/wordexport/jquery.wordexport.js"></script>
</head>
<body>
<form method="post">
	

<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
    <div id="navMenubar">
<ul>
<li id="back"><a href="tolist.action">返回</a></li>
<!-- <li id="save"><a href="#" onclick="formSubmit('next.action','_self');this.blur();">下一篇</a></li>
<li id="save"><a href="#" onclick="formSubmit('pre.action','_self');this.blur();">上一篇</a></li> -->
<li id="save"><a class="word-export" href="javascript:void(0)"> 导出</a></li>
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
	<div  id="page-content">
<input type="hidden"  name="id"value="${list.id }">
<input type="hidden"  name="id"value="${list.orders }">
${list.content }
</div>
		</table>
	</div>
</div>
 
 
</form>
</body>
<script type="text/javascript">
    jQuery(document).ready(function($) {
        $("a.word-export").click(function(event) {
            $("#page-content").wordExport("文章导出");
        });
    });
</script>
</html>

