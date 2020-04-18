<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../base.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<head>
    <title></title>
      <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
     <script	src="${pageContext.request.contextPath}/utf8-jsp/ueditor.config.js"></script>
     <script src="${pageContext.request.contextPath}/utf8-jsp/ueditor.all.js"></script>
     <script	src="${pageContext.request.contextPath}/utf8-jsp/lang/zh-cn/zh-cn.js"></script>
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
    	   alert("ces1")
           reader.readAsDataURL(file);
       } else {
           // 图片文件是空的
           alert("ce2")
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
<li id="save"><a href="#" onclick="formSubmit('update.action','_self');this.blur();">发布</a></li>
<li id="save"><a href="#" onclick="formSubmit('update2.action','_self');this.blur();">保存</a></li>
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
		修改退货信息
    </div> 
    </div>
    </div>

    <input type="hidden" value="${list.id}" name="id">
   
    <div>
		<table class="commonTable" cellspacing="1">
	        <tr>
	            <td class="columnTitle">标题：</td>
	            <td class="tableContent"><input type="text" name="title"  value="${list.title}" dataType="整数" dispName="排序号"/></td>
	           
	        </tr>		
	        <tr>
	            <td class="columnTitle_mustbe">分类：</td>
	            <td class="tableContent"> <select name="cid" >
			   					 <c:forEach items="${type}" var="type">
			   					 <c:choose>
			   					 	<c:when test="${list.cid==type.id}">
			   							<option value="${type.id}" selected="selected">${type.name }</option>
			   					 	</c:when>
			   					 	<c:otherwise>
			   					 		<option value="${type.id}">${type.name }</option>
			   					 	</c:otherwise>
			   					 </c:choose>
			   					</c:forEach>	
                            </select></td>
	           
	        </tr>
	     
	      <tr>
	            <td class="columnTitle_mustbe">创建时间：</td>
	            <td class="tableContent"><input type="text" name="creattime"  value="<fmt:formatDate value='${list.creattime}' pattern='yyyy-MM-dd HH:mm:ss'/>" readonly="readonly" /></td>
	            
	        </tr>
	        <tr>
	            <td class="columnTitle_mustbe">修改时间：</td>
	            <td class="tableContent"><input type="text" name="sendtime" value="<fmt:formatDate value='${list.sendtime}' pattern='yyyy-MM-dd HH:mm:ss'/>"  onclick="WdatePicker({el:this,isShowOthers:true,dateFmt:'yyyy-MM-dd HH:mm:ss'});" /></td>
	            
	        </tr>
	    
	           
	       
	        <tr>
	        <td>图片上传：</td>
	          <td class="tableContent">
	         <input type="file" name="pictureFile" onchange="previewFile()">
	         </td>
	         
	         </tr>
	          <tr>
	         <td class="columnTitle_mustbe">图片显示：</td>
	         <td class="tableContent">
	         <img alt="" src="${pageContext.request.contextPath }/uploadimages/${list.fmimg}" style="width:150px;height:150px;">
	         </td>
	        </tr>
	        <tr>
	            <td class="columnTitle">内容：</td>
	           <td class="tableContent"> 
	            
           </td>
	        </tr>

		</table>
	</div>
</div>
    <div >
                <textarea id="container" name="content"  type="text/plain" style="width:100%;height:500px;"></textarea>
           </div>
           <div id = "content1"  hidden="hidden">
			${list.content}
			</div>
          
             <script type="text/javascript">	
		     $(document).ready(function(){  
		        var content =$('#content1').html();		 
		         var ue = UE.getEditor('container'); 
		         ue.ready(function() {//编辑器初始化完成再赋值  
			     ue.setContent(content);  //赋值给UEditor  
		         });  
		
		     });
		
      </script> 
</form>
 
</body>
</html>

