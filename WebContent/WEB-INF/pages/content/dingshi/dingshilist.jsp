<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../baselist.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<head>
<title>
</title> <script type="text/javascript" src="${pageContext.request.contextPath}/js/layui/layui.js"></script>
   <link href="${pageContext.request.contextPath}/js/layui/css/layui.css" rel="stylesheet" type="text/css">
 <script type="text/javascript" src="${ctx }/js/datepicker/WdatePicker.js"></script>
</head>
<link rel="stylesheet" type="text/css" href="src/jquery.page.css">
<body>
	<form name="icform" method="post">

		<div id="menubar">
			<div id="middleMenubar">
				<div id="innerMenubar">
					<div id="navMenubar">
						<ul>

							
						<!-- 	<li id="new"><a href="#"
								onclick="formSubmit('toadd.action','_self');this.blur();">新增</a></li> -->
							<li id="update"><a href="#"
								onclick="formSubmit('toaddsend.action','_self');this.blur();">发布</a></li>
							<li id="delete"><a href="#"
								onclick="formSubmit('toaddxiaxian.action','_self');this.blur();">下线</a></li>
							
						</ul>
					</div>
				</div>
			</div>
		</div>
		<!-- 页面主体部分（列表等） -->
		<div class="textbox" id="centerTextbox">
			<div class="textbox-header">
				<div class="textbox-inner-header">
					<div class="textbox-title">定时列表</div>
				</div>
			</div>

			<div>


				<div class="eXtremeTable">
					<table id="ec_table" class="tableRegion" width="98%">
						<thead>
							<tr>
								<td class="tableHeader"><input type="checkbox" name="selid"
									onclick="checkAll('id',this)"></td>
								<td class="tableHeader">序号</td>
								<td class="tableHeader">文章标题</td>
								<td class="tableHeader">文章状态</td>
								
								
								
							</tr>
						</thead>
						<tbody class="tableBody">

							<c:forEach items="${article}" var="item" varStatus="status">
								<tr class="odd" onmouseover="this.className='highlight'"
									onmouseout="this.className='odd'">
									<td><input type="checkbox" name="id" value="${item.id}" /></td>
								
									<td>${status.index+1}</td>
									<td>${item.title}</td>
									 <td><c:if test="${item.state==1}">
											<font  class="layui-btn layui-btn-radius layui-btn-warm">未发布</font>
										</c:if> 
										<c:if test="${item.state==2}">
											<font class="layui-btn layui-btn-radius layui-btn-normal">已发布</font>
										</c:if>
										<c:if test="${item.state==3}">
										<font class="layui-btn layui-btn-radius layui-btn-danger">已下线</font>
										</c:if>
										</td>
								   <%--  <c:forEach items="${article}" var="type" >
									
										<c:if test="${item.aid==type.id }">
											<c:set var="typename" value="${type.title}"/>
											<c:set var="articlestate" value="${type.state}"/>
										</c:if>
									
									</c:forEach>
                                     <td><c:out value="${typename}"></c:out></td>
                                     <td>
                                     <c:if test='${articlestate==1}'>未发布</c:if>
                                     <c:if test='${articlestate==2}'>已发布</c:if>
                                     <c:if test='${articlestate==3}'>已下线</c:if>
                                     
                                     </td>
                                   
                                     <td><input type="text" name="pubtime" value="<fmt:formatDate value='${item.pubtime}' pattern='yyyy-MM-dd HH:mm:ss'/>"  onclick="WdatePicker({el:this,isShowOthers:true,dateFmt:'yyyy-MM-dd HH:mm:ss'});" /></td>
                                     <td><input type="text" name="stoptime" value="<fmt:formatDate value='${item.stoptime}' pattern='yyyy-MM-dd HH:mm:ss'/>"  onclick="WdatePicker({el:this,isShowOthers:true,dateFmt:'yyyy-MM-dd HH:mm:ss'});" /></td>	   
								
                                    </tr>--%>
							</c:forEach> 

						</tbody>

						

					</table>

				</div>

			</div>
	</form>
</body>
</html>

