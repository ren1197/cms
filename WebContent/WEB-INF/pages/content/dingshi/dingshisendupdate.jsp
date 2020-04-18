<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../base.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<head>
    <title></title>
      <script type="text/javascript" src="${ctx }/js/layui/layui.js"></script>
   <link href="${ctx }/js/layui/css/layui.css" rel="stylesheet" type="text/css">
    <script	src="${pageContext.request.contextPath}/utf8-jsp/ueditor.config.js"></script>
<script src="${pageContext.request.contextPath}/utf8-jsp/ueditor.all.js"></script>
<script	src="${pageContext.request.contextPath}/utf8-jsp/lang/zh-cn/zh-cn.js"></script>
<script type="text/javascript" src="${ctx }/js/datepicker/WdatePicker.js"></script>

</head>
<body>
<form method="post" name="upfile" enctype="multipart/form-data">

<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
    <div id="navMenubar">
<ul>
<li id="save"><a href="#" onclick="formSubmit('start.action','_self');this.blur();">发布</a></li>

<li id="back"><a href="tolist.action">返回</a></li>
</ul>
    </div>
</div>
</div>
</div>
     
<div class="textbox" id="centerTextbox">
    <div class="textbox-header">
    <div class="textbox-inner-header">
    <div class="textbox-title">
		新增定时
    </div> 
    </div>
    </div>
<div>
 <input type="hidden" value="1"name="isdel">
<input type="hidden" value="${list.id}" name="id">
    <div>
		<table class="commonTable" cellspacing="1">
	    	
	        <tr>
	            <td class="columnTitle_mustbe">结束时间：</td>
	            <td class="tableContent">
	          <%--   <input type="text" name="sendtime" value="<fmt:formatDate value='${item.sendtime}' pattern='yyyy-MM-dd HH:mm:ss'/>"  onclick="WdatePicker({el:this,isShowOthers:true,dateFmt:'yyyy-MM-dd HH:mm:ss'});" /></td> --%>
	               <input type="text" name="sendtime" class="layui-input"  value="${item.sendtime}" id="test1">
	       </td>
	        </tr>
	       

		</table>
	</div>
	                 
          
</div>
<div id="container" name="content" type="text/plain" style="width:100%;height:500px;"> </div>
     <script>
layui.use('laydate', function(){
  var laydate = layui.laydate;
  var myDate = new Date();  //获取当前时间
  //执行一个laydate实例
  laydate.render({ 
    elem: '#test1' //指定元素
    ,type: 'datetime'
    ,calendar: true
    ,min: myDate.toLocaleString()
    ,max: '2099-1-01 00:0:00'
  });
  laydate.render({
	 elem: '#test2' //指定元素
	 ,type: 'datetime'
	,calendar: true
	,min: '2019-12-25 12:30:00'
	,max: '2099-1-01 00:0:00'
	  });
});
</script> 
</form>
   
</body>
</html>

