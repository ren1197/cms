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
		修改广告位
    </div> 
    </div>
    </div>
<div> 
<input type="hidden" name="id" value="${list.id}" />
 
    <div>
		<table class="commonTable" cellspacing="1">
	       <tr>
	            <td class="columnTitle">广告位名称：</td>
	            <td class="tableContent"><input type="text" name="name" value="${list.name }" /></td>
	            
	        </tr>		
	        <tr>
	            <td class="columnTitle_mustbe">广告位宽度：</td>
	            <td class="tableContent"><input type="text" name="width" value="${list.width }" /></td>
	           
	        </tr>
	        <tr>
	            <td class="columnTitle_mustbe">广告位高度：</td>
	            <td class="tableContent"><input type="text" name="height" value="${list.height }" /></td>
	           
	        </tr>
	        <tr>
	            <td class="columnTitle_mustbe">广告位描述：</td>
	            <td class="tableContent"><input type="text" name="description" value="${list.description }" /></td>
	           
	        </tr>
	        <!-- <tr>
	            <td class="columnTitle">是否显示：</td>
	            <td class="tableContent"><select id="state" name="state" style="width: 130px; heigh: 30px;"
								dataType="下拉列表" dispName="是否启用">
								<option value='' selected>--请选择--</option>
								<option value='1'>启用</option>
								<option value='0'>不启用</option>	
													 
			   </select></td>
	        </tr> -->

		</table>
	</div>
</div>
 
 
</form>
</body>
</html>

