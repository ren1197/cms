<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../baselist.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="atcast" uri="http://atcast.cn/common/"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
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
<!-- Bootstrap Core CSS -->
<link href="<%=basePath%>css/bootstrap.min.css" rel="stylesheet">

<!-- MetisMenu CSS -->
<link href="<%=basePath%>css/metisMenu.min.css" rel="stylesheet">

<!-- DataTables CSS -->
<link href="<%=basePath%>css/dataTables.bootstrap.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="<%=basePath%>css/sb-admin-2.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="<%=basePath%>css/font-awesome.min.css" rel="stylesheet"
	type="text/css">
<link href="<%=basePath%>css/boot-crm.css" rel="stylesheet"
	type="text/css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.4.4.js"></script>
<script>
	function isOnlyChecked() {
		var checkBoxArray = document.getElementsByName('id');
		var count = 0;
		for (var index = 0; index < checkBoxArray.length; index++) {
			if (checkBoxArray[index].checked) {
				count++;
			}
		}
		
		if (count == 1)
			return true;
		else
			return false;
	}
	function toView() {
		if (isOnlyChecked()) {
			formSubmit('toview.action', '_self');
		} else {
			alert("请先选择一项并且只能选择一项，再进行操作！");
		}
	}
	//实现更新
	function toUpdate() {
		if (isOnlyChecked()) {
			formSubmit('toupdate.action', '_self');
		} else {
			
			 alert("请先选择一项并且只能选择一项，再进行操作！"); 
		}
	}
	function query() {	 
		var state=document.getElementById("state").value;
		var factorynamekeyword=document.getElementById("factorynamekeyword").value;
	
		formSubmit('tolist.action', '_self');
		 
	}

</script>
	
</head>
<!-- <link rel="stylesheet" type="text/css" href="src/jquery.page.css"> -->
<body>
	<form name="icform" method="post" >

		<div id="menubar">
			<div id="middleMenubar">
				<div id="innerMenubar">
					<div id="navMenubar">
						<ul>
							<li id="new"><a href="#"
								onclick="formSubmit('toadd.action','_self');this.blur();">新增</a></li>
					     	<li id="update"><a href="#" onclick="javascript:toUpdate()">修改</a></li>
							<li id="delete"><a href="#"
								onclick="formSubmit('delete.action','_self');this.blur();">删除</a></li>
							<li id="delete"><a href="#"
								onclick="formSubmit('deletem.action','_self');this.blur();">删除N</a></li>
							<li id="new"><a href="#"
								onclick="formSubmit('start.action','_self');this.blur();">发布</a></li>
							<li id="new"><a href="#"
								onclick="formSubmit('xiaxian.action','_self');this.blur();">下线</a></li>
                             <li id="new"><a href="#"
								onclick="formSubmit('moveup.action','_self');this.blur();">上移</a></li>
								<li id="new"><a href="#"
								onclick="formSubmit('movedown.action','_self');this.blur();">下移</a></li>
								<li id="new"><a href="#"
								onclick="formSubmit('moveuptop.action','_self');this.blur();">置顶</a></li>
								 <!-- <li id="new"><a href="#"
								onclick="formSubmit('startdingshi.action','_self');this.blur();">启动定时</a></li>  -->
								<li id="new"><a href="${pageContext.request.contextPath }/recycle/content/articleList.action">回收站</a></li>
						
						</ul>
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
              <span class="noprint">
				<div id="find_div" style="width: 98%;">
					<fieldset>
						<legend>
							<font class="textbox-title">查询条件&nbsp;</font>
						</legend>
						<div style="width: 98%; padding-top: 7px; text-align: left;">
							文章状态： <select id="state" name="state" style="width: 130px; heigh: 30px;"
								dataType="下拉列表" dispName="查询条件">
								<option value='' selected>--请选择--</option>
								<option value='1'>未发布</option>
								<option value='2'>已发布</option>
									
								<option value='3'>已下线</option>									 
							</select>
							按标题查询： <input id="factorynamekeyword" type="text" name="title" size="30" />
							<input id="btnFind" type="button" name="查询" value="查询" onclick="javascript:query()">
							<input type="button" name="清空" value="清空" onclick="findReset();this.blur();">
						</div>
					</fieldset>
				</div>
			</span>

        </div>
				<div class="eXtremeTable">
					<table id="ec_table" class="tableRegion"  width="98%" >
						<thead>
							<tr>
								<td class="tableHeader"  lay-data="{type:'checkbox'}">
								 <input type="checkbox" name="selid"
									onclick="checkAll('id',this)"> 
								</td>
								<td class="tableHeader" >序号</td>
								<td class="tableHeader" >标题</td>
								<td class="tableHeader" >封面图片</td>
								<td class="tableHeader" >文章分类</td>
								<td class="tableHeader" >创建时间</td>
								<td class="tableHeader" >修改时间</td>
								<td class="tableHeader" >文章状态</td>
								
							</tr>
						</thead>
						<tbody class="tableBody">
                           <input type="hidden" name="orders" value="${item.id}">
							<c:forEach items="${page.rows}" var="item" varStatus="status">
								<tr class="odd" onmouseover="this.className='highlight'"
									onmouseout="this.className='odd'">
									<%-- <td><input type="checkbox" name="id" value="${item.id}" /></td> --%>
									<td><input type="checkbox" name="id" value="${item.id}" /></td>
									<td>${status.index+1}</td>
									<td>${item.title}</td>
							          <td><a href="toview.action?id=${item.id}">
							          <img id="img" style="width:100px;height:100px;"
		                               src="${pageContext.request.contextPath}/image/${item.fmimg}" /></a>
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
											<a href="start.action?id=${item.id}"><font  class="layui-btn layui-btn-radius layui-btn-warm">未发布</font></a>
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

					
 					<div >
					<atcast:page url="${pageContext.request.contextPath }/Article/content/tolist.action" />
				   </div>
						
				</div>

			</div>
	</form>
</body>

</html>

