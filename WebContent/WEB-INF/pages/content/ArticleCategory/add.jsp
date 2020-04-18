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
		新增文章分类
    </div> 
    </div>
    </div>
<div>
 
    <div>
		<table class="commonTable" cellspacing="1">
	        <tr>
	        <input type="hidden" name="isdel" value="1" >
	            <td class="columnTitle">分类内容</td>
	            <td class="tableContent"><input type="text" name="name" value="" /></td>
	            
	        </tr>		
	        <tr>
	            <td class="columnTitle_mustbe">上级分类：</td>
	            <td class="tableContent"> 
	             <select name="pid" style="width:100%;height:27px;">
	              <option value="0">选择父类型</option>
		            <c:forEach items="${list}" var="item">
			          <option value="${item.id}" >			         
			            ${item.name}
			          </option>
			        </c:forEach> 
		          </select></td>
	           
	        </tr>
	        
	        
		</table>
	</div>
</div>
 
 
</form>
</body>
</html>

