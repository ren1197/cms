<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../baselist.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<head>
<title>
</title>
<style type="text/css">

#img {
	width: 100px;
	height: 100px;
	box-shadow: 0px 0px 10px rgba(0,0,0,0.1);
	-webkit-transition: all ease .3s;
	transition: all ease .5s;
}
#img:hover {
	-webkit-transform: scale(1.05);
	transform: scale(2.05);
	box-shadow: 0px 0px 10px rgba(0,0,0,0.1);
	border-radius: 25%
}


</style>
   <script type="text/javascript" src="${pageContext.request.contextPath}/js/layui/layui.js"></script>
   <link href="${pageContext.request.contextPath}/js/layui/css/layui.css" rel="stylesheet" type="text/css">
</head>
<link rel="stylesheet" type="text/css" href="src/jquery.page.css">
<body>
	<form name="icform" method="post">

		<div id="menubar">
			<div id="middleMenubar">
				<div id="innerMenubar">
					<div id="navMenubar">
						
					</div>
				</div>
			</div>
		</div>
		<!-- 页面主体部分（列表等） -->
		<div class="textbox" id="centerTextbox">
			<div class="textbox-header">
				<div class="textbox-inner-header">
					<div class="textbox-title">文章列表</div>
				</div>
			</div>

			<div>


				<div class="eXtremeTable">
					<table id="ec_table" class="tableRegion" width="98%" >
						<thead>
							<tr>
								<td class="tableHeader"><input type="checkbox" name="selid"
									onclick="checkAll('id',this)"></td>
								<td class="tableHeader">序号</td>
								<td class="tableHeader">标题</td>
								<td class="tableHeader">封面图片</td>
								<td class="tableHeader">文章分类</td>
								<td class="tableHeader">创建时间</td>
								<td class="tableHeader">修改时间</td>
								<td class="tableHeader">文章状态</td>
								
							</tr>
						</thead>
						<tbody class="tableBody">
                           <input type="hidden" name="orders" value="${item.id}">
							<c:forEach items="${list}" var="item" varStatus="status">
								<tr class="odd" onmouseover="this.className='highlight'"
									onmouseout="this.className='odd'">
									<td><input type="checkbox" name="id" value="${item.id}" /></td>
									<td>${status.index+1}</td>
									<td>${item.title}</td>
							          <td><a href="toview.action?id=${item.id}"><img  id="img" style="width:100px;height:100px;"
		                           src="${pageContext.request.contextPath }/image/${item.fmimg}" /></a>
</td>
							          
							          <c:forEach items="${type}" var="type" >
									
										<c:if test="${item.cid==type.id }">
											<c:set var="typename" value="${type.name}"/>
										</c:if>
									</c:forEach>
									  <td><c:out value="${typename}"></c:out></td>
							          <td><fmt:formatDate value="${item.creattime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
							          <td><fmt:formatDate value="${item.sendtime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
		                          <td><c:if test="${item.state==1}">
											<a href="start.action?id=${item.id}"><font class="layui-btn layui-btn-radius layui-btn-warm">未发布</font></a>
										</c:if> <c:if test="${item.state==2}">
											<a href="xiaxian.action?id=${item.id}"><font class="layui-btn layui-btn-radius layui-btn-normal">已发布</font></a>
										</c:if>
										<c:if test="${item.state==3}">
										<a href="start.action?id=${item.id}"><font class="layui-btn layui-btn-radius layui-btn-danger">已下线</font></a>
										</c:if>
										</td>
								</tr>
							</c:forEach>

						</tbody>


					</table>

					
 					

				</div>

			</div>
	</form>
</body>
</html>

