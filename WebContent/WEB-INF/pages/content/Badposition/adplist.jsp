<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../baselist.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib prefix="atcast" uri="http://atcast.cn/common/"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<head>
<title>
</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/layui/layui.js"></script>
   <link href="${pageContext.request.contextPath}/js/layui/css/layui.css" rel="stylesheet" type="text/css">
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
<script type="text/javascript" src="${ctx }/js/jquery-1.4.4.js"></script>
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
	
		var factorynamekeyword=document.getElementById("factorynamekeyword").value;
	
		formSubmit('tolist.action', '_self');
		 
	}

</script>
</head>
<link rel="stylesheet" type="text/css" href="src/jquery.page.css">
<body>
	<form name="icform" method="post">

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
								onclick="formSubmit('start.action','_self');this.blur();">启用</a></li>
							<li id="new"><a href="#"
								onclick="formSubmit('stop.action','_self');this.blur();">停用</a></li>
                         
						</ul>
					</div>
				</div>
			</div>
		</div>
		<!-- 页面主体部分（列表等） -->
						<div class="textbox" id="centerTextbox">
			<div class="textbox-header">
				<div class="textbox-inner-header">
					<div class="textbox-title">广告位列表</div>
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
							按标题查询： <input id="factorynamekeyword" type="text" name="name" size="30" />
							
							<input id="btnFind" type="button" name="查询" value="查询" onclick="javascript:query()">
							<input type="button" name="清空" value="清空" onclick="findReset();this.blur();">
						</div>
					</fieldset>
				</div>
			</span>

        </div>

				<div class="eXtremeTable">
					<table id="ec_table" class="tableRegion" width="98%">
						<thead>
							<tr>
								<td class="tableHeader"><input type="checkbox" name="selid"
									onclick="checkAll('id',this)"></td>
								<td class="tableHeader">序号</td>
								<td class="tableHeader">广告位名称：</td>
								<td class="tableHeader">宽度</td>
								<td class="tableHeader">高度</td>
								<td class="tableHeader">广告位描述</td>
								<td class="tableHeader">是否启用</td>
								
							</tr>
						</thead>
						<tbody class="tableBody">

							<c:forEach items="${page.rows}" var="item" varStatus="status">
								<tr class="odd" onmouseover="this.className='highlight'"
									onmouseout="this.className='odd'">
									<td><input type="checkbox" name="id" value="${item.id}" /></td>
									<td>${status.index+1}</td>
									<td>${item.name}</td>
							          <td>${item.width}</td>
							          <td>${item.height}</td>
							           <td>${item.description}</td>
							          
									<td><c:if test="${item.state==0}">
											<a href="start.action?id=${item.id}"> <font class="layui-btn layui-btn-radius layui-btn-danger">停用</font></a>
										</c:if> <c:if test="${item.state==1}">
											<a href="stop.action?id=${item.id}"><font class="layui-btn layui-btn-radius layui-btn-normal">启用</font></a>
										</c:if></td>
								</tr>
							</c:forEach>

						</tbody>

						
					</table>
                        <div >
					<atcast:page url="${pageContext.request.contextPath }/Badposition/content/tolist.action" />
				   </div>
				</div>

			</div>
	</form>
</body>
</html>

