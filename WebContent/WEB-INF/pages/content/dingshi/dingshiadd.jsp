<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../base.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<head>
    <title></title>
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
<li id="save"><a href="#" onclick="formSubmit('add.action','_self');this.blur();">发布定时</a></li>

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

    <div>
		<table class="commonTable" cellspacing="1">
	    		
	        <tr>
	            <td class="columnTitle_mustbe">分类：</td>
	            <td class="tableContent"> <select name="aid" style="width:100%;height:27px;">
		            <c:forEach items="${article}" var="item">
			          <option value="${item.id}" >
			            ${item.title}
			          </option>
			        </c:forEach> 
		          </select></td>	            
	        </tr>
	     <tr>
	            <td class="columnTitle_mustbe">开始时间：</td>
	            <td class="tableContent"><input type="text" name="pubtime"  value="<fmt:formatDate value='${list.creattime}' pattern='yyyy-MM-dd HH:mm:ss'/>" onclick="WdatePicker({el:this,isShowOthers:true,dateFmt:'yyyy-MM-dd HH:mm:ss'});"/></td>
	            
	        </tr>
	        <tr>
	            <td class="columnTitle_mustbe">结束时间：</td>
	            <td class="tableContent"><input type="text" name="stoptime" value="<fmt:formatDate value='${list.sendtime}' pattern='yyyy-MM-dd HH:mm:ss'/>"  onclick="WdatePicker({el:this,isShowOthers:true,dateFmt:'yyyy-MM-dd HH:mm:ss'});" /></td>
	            
	        </tr>
	       

		</table>
	</div>
	                 
          
</div>
<div id="container" name="content" type="text/plain" style="width:100%;height:500px;"> </div>
      
</form>
   
</body>
</html>

