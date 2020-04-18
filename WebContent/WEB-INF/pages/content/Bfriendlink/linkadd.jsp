<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../base.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <title></title>
   

    <script type="text/javascript">
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

<form method="post" enctype="multipart/form-data" >

<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
    <div id="navMenubar">
<ul>
<li id="save"><a href="#" onclick="formSubmit('add.action','_self');this.blur();">确定</a></li>
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
		友情链接新增
    </div> 
    </div>
    </div>
<div>
  <input  name="isdel" type="hidden" value="1">
    <div>
		<table class="commonTable" cellspacing="1">
	        <tr>
	            <td class="columnTitle">链接名称：</td>
	            <td class="tableContent"><input style="width:150px;" type="text" name="name" value="" /></td>
	            
	        </tr>		
	        <tr>
	            <td class="columnTitle_mustbe">url地址：</td>
	            <td class="tableContent"><input  style="width:150px;" type="text" name="url" value="" /></td>
	           
	        </tr>
	       
	        <tr>
	            <td class="columnTitle_mustbe">链接图片：</td>
	            <td class="tableContent"><input type="file" name="pictureFile" value="" onchange="previewFile()" style="width:150px;"/></td>
	           
	        </tr>
	        <tr>
	         <td class="columnTitle_mustbe">图片显示：</td>
	         <td class="tableContent">
	         <img alt="" src="" style="width:150px;height:150px;">
	         </td>
	        </tr>
	        <tr>
	            <td class="columnTitle">是否显示：</td>
	            <td>
	       
			    
                    
                       <select id="state" name="state" style="width: 130px; heigh: 30px;"
								dataType="下拉列表" dispName="是否显示">
								<option value='' selected>--请选择--</option>
								<option value='1'>是</option>
								<option value='0'>否</option>	
													 
			   </select> 
			   </td>
	        </tr>

		</table>
	</div>
</div>
 
 
</form>
</body>
</html>

