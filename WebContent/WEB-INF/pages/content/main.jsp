<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../base.jsp" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>模块介绍</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/calader/css/style.css">
   
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/layui/layui.js"></script>
   <link href="${pageContext.request.contextPath}/js/layui/css/layui.css" rel="stylesheet" type="text/css">
  	<link rel="stylesheet" rev="stylesheet" type="text/css" href="${ctx}/skin/default/css/main.css" media="all"/>
</head>

<body>
<form>
<div class="textbox"></div>

	<div class="modelDiv">

        <table class="modelTable" cellspacing="1">
        	<ul class="layui-timeline">
 <div class="clock">
  <div class="flip">
    <div class="digital front" data-number="0"></div>
    <div class="digital back" data-number="1"></div>
  </div>
  <div class="flip">
    <div class="digital front" data-number="0"></div>
    <div class="digital back" data-number="1"></div>
  </div>
  <em class="divider">:</em>
  <div class="flip">
    <div class="digital front" data-number="0"></div>
    <div class="digital back" data-number="1"></div>
  </div>
  <div class="flip">
    <div class="digital front" data-number="0"></div>
    <div class="digital back" data-number="1"></div>
  </div>
  <em class="divider">:</em>
  <div class="flip">
    <div class="digital front" data-number="0"></div>
    <div class="digital back" data-number="1"></div>
  </div>
  <div class="flip">
    <div class="digital front" data-number="0"></div>
    <div class="digital back" data-number="1"></div>
  </div>
</div>
 <script type="text/javascript" src="${pageContext.request.contextPath}/calader/js/script.js"></script>
        </table>
 
	</div>
</form>
</body>

</html>