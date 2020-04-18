<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../base.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
		修改分类信息
    </div> 
    </div>
    </div>
<div>
 
    <div>
		<table class="commonTable" cellspacing="1">
	        <tr>
	          <input type="hidden" id="id" name="id" value="${list.id}">
	            <td class="columnTitle">分类标题：</td>
	            <td class="tableContent"><input type="text" name="name" value="${list.name}" /></td>
	            
	        </tr>		
	        <tr>
	            <td class="columnTitle_mustbe">上级分类：</td>
	            <td class="tableContent"><select name="pid" style="width:100%;height:27px;">
			   					 <c:forEach items="${type}" var="type">
			   					 <c:choose>
			   					 	<c:when test="${list.pid==type.id}">
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
	            <td class="tableContent"><input type="text"  value="<fmt:formatDate value='${list.creattime}' pattern='yyyy-MM-dd HH:mm:ss'/>" readonly="readonly" name="creattime" value="${obj.contacts}" dataType="非空字符串" dispName="联系人"/></td>
	            
	        </tr>
	        

		</table>
	</div>
</div>
 
 
</form>
</body>
</html>

