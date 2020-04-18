<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../baselist.jsp" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title></title>
    <%@include file="layui.jsp"%>
	<script type="text/javascript" src="${ctx}/components/jquery-ui/jquery-1.2.6.js"></script>
</head>
 
<body id="left_frame">
<div class="PositionFrame_black" id="PositionFrame"></div>

 
<!-- begin1  -->
<div id="sidebar" class="sidebar">
	<div class="sidebar_t">
		<div class="sidebar_t_l"></div>
		<div class="sidebar_t_c"></div>
		<div class="sidebar_t_r"></div>
	</div>
        <div class="panel">
        <div class="panel_icon"><img src="${ctx}/skin/default/images/icon/document_into.png" /></div>
        <div class="panel-header">
        <div class="panel-title">内容管理</div>
        <div class="panel-content">
			<ul>					
					<li><a href="${ctx}/Barticlecategory/content/tolist.action" onclick="linkHighlighted(this)" target="main" id="aa_1">文章分类</a></li>
					<li><a href="${ctx}/Article/content/tolist.action" onclick="linkHighlighted(this)" target="main" id="aa_1">文章管理</a></li>
					<li><a href="${ctx}/BFriendLink/content/tolist.action" onclick="linkHighlighted(this)" target="main" id="aa_1">友情链接</a></li>
<%-- 					<li><a href="${ctx}/Badposition/content/tolist.action" onclick="linkHighlighted(this)" target="main" id="aa_1">回收站</a></li> --%>
<%-- 					<li><a href="${ctx}/Article/content/tolist.action" onclick="linkHighlighted(this)" target="main" id="aa_1">敏感词管理</a></li> --%>
					<li><a href="${ctx}/Badposition/content/tolist.action" onclick="linkHighlighted(this)" target="main" id="aa_1">广告位管理</a></li>
					<li><a href="${ctx}/Bad/content/tolist.action" onclick="linkHighlighted(this)" target="main" id="aa_1">广告管理</a></li>
					<li><a href="${ctx}/chart/test.action" onclick="linkHighlighted(this)" target="main" id="aa_1">文章状态统计</a></li>
					<li><a href="${ctx}/chart/test2.action" onclick="linkHighlighted(this)" target="main" id="aa_1">广告位统计</a></li>
				<li><a href="${ctx}/Bdingshi/content/tolist.action" onclick="linkHighlighted(this)" target="main" id="aa_1">定时任务</a></li>  
				
</li>   

			</ul>
			
        </div>
        </div>
        <div class="panel">
        <div class="panel_icon"><img src="${ctx}/skin/default/images/icon/document_into.png" /></div>
        <div class="panel-header">
        <div class="panel-title">文章查看</div>
        <div class="panel-content">
        <ul>
        <li>
        <a
    onclick="top.leftFrame.location.href='${ctx}/Barticlecategory/content/tree.action';top.main.location.href='contentMain.action';linkHighlightMenu(this);">文章查看</a>
       </li>
        </ul>
        </div>
        </div>
    </div>
    <div class="sidebar_t">
		<div class="sidebar_b_l"></div>
		<div class="sidebar_t_c"></div>
		<div class="sidebar_b_r"></div>
	</div>  
</div>	  

</body>
</html>
