<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../base.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<head>
    <title></title>
     <script type="text/javascript" src="${ctx }/js/datepicker/WdatePicker.js"></script>
   <script type="text/javascript">
   /**
    * 显示选择上传的图片略缩图
    * 当选择了图片文件时触发这个方法
    */
  
   function previewFile() {
       // 通过标签选择器获取HTML元素
       var preview = document.querySelector('img');
       var file = document.querySelector('input[type=file]').files[0];
       // Js内置文件流
       var reader = new FileReader();

       // 更新img标签的src属性为图片的本地路径，就可以显示了
       reader.onloadend = function () {
           preview.src = reader.result;
       }

       // 图片文件不空就显示
       if (file) {
    	
           reader.readAsDataURL(file);
       } else {
           // 图片文件是空的
          
           preview.src = "";
       }
   }
   </script>
</head>
<body>
<form method="post" enctype="multipart/form-data">
	

<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
    <div id="navMenubar">
<ul>
<li id="save"><a href="#" onclick="formSubmit('update.action','_self');this.blur();">确定</a></li>
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
		修改友情链接
    </div> 
    </div>
    </div>
<div> 
<input type="hidden" name="id" value="${list.id}" />
 
    <div>
		<table class="commonTable" cellspacing="1">
	       <tr>
	            <td class="columnTitle">链接名称：</td>
	            <td class="tableContent"><input type="text" name="name" value="${list.name}" /></td>
	            
	        </tr>		
	        <tr>
	            <td class="columnTitle_mustbe">url地址：</td>
	            <td class="tableContent"><input type="text" name="url" value="${list.url}" /></td>
	           
	        </tr>
	       <%--  <tr>
	            <td class="columnTitle_mustbe">创建日期：</td>
	            <td class="tableContent"><input type="text" name="createtime" value="<fmt:formatDate value='${list.createtime}' pattern='yyyy-MM-dd HH:mm:ss'/>" readonly="readonly"/></td>
	           
	        </tr>
	        <tr>
	            <td class="columnTitle_mustbe">修改日期：</td>
	            <td class="tableContent"><input type="text" name="modifytime" value="<fmt:formatDate value='${list.modifytime}' pattern='yyyy-MM-dd HH:mm:ss'/>"  onclick="WdatePicker({el:this,isShowOthers:true,dateFmt:'yyyy-MM-dd HH:mm:ss'});"/></td>
	           
	        </tr>
	     --%>
	        <tr>  
	          <td class="columnTitle">图片上传：</td>
	          <td class="tableContent">  
	           <input type="file" name="pictureFile" value="${list.logoimg}" onchange="previewFile()"/></td>
	        
	        </tr>
	            <tr>
	            <td class="columnTitle_mustbe">链接图片：</td>
	        <td class="tableContent">    
	         <img  style="width:150px;height:150px;" 
		       src="${pageContext.request.contextPath }/image/${list.logoimg}" /></td>
	            <td class="tableContent">     
	        </tr>
	        

		</table>
	</div>
</div>
 
 
</form>
</body>
</html>

