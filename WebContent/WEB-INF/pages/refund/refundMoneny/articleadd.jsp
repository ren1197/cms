<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../base.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
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
<li id="save"><a href="#" onclick="formSubmit('add.action','_self');this.blur();">发布</a></li>
<li id="save"><a href="#" onclick="formSubmit('add2.action','_self');this.blur();">保存</a></li>
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
		新增文章信息
    </div> 
    </div>
    </div>
<div>
 <input type="hidden" value="1"name="isdel">

    <div>
		<table class="commonTable" cellspacing="1">
	        <tr>
	            <td class="columnTitle">标题：</td>
	            <td class="tableContent"><input type="text" name="title" value="" style="width:100%;height:27px;"/></td>
	            
	        </tr>		
	        <tr>
	            <td class="columnTitle_mustbe">分类：</td>
	            <td class="tableContent"> <select name="cid" style="width:100%;height:27px;">
		            <c:forEach items="${list}" var="item">
			          <option value="${item.id}" >
			            ${item.name}
			          </option>
			        </c:forEach> 
		          </select></td>
	            
	        </tr>
	     
	          <tr>
	            <td class="columnTitle_mustbe">封面图片：</td>
	            <td class="tableContent">	           
	         <input type="file" name="pictureFile" value="" style="width:100%;height:27px;" onchange="previewFile()"/></td>
	           
	        </tr>
	        <tr>
	         <td class="columnTitle_mustbe">图片显示：</td>
	         <td class="tableContent">
	         <img alt="" src="" style="width:150px;height:150px;">
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
<div id="container" name="content" type="text/plain" style="width:100%;height:500px;"> </div>
      <script type="text/javascript">
        var ue = UE.getEditor('container');
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
 
</form>
   
</body>
</html>

