<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<c:set value="${pageContext.request.contextPath}" var="ctx"/>
<html>
<head>
    <title></title>
    <link href="${ctx}/js/layui/css/layui.css" type="text/css" rel="stylesheet">
    <link href="${ctx}/js/layui_ext/dtree/dtree.css" type="text/css" rel="stylesheet">
    <link href="${ctx}/js/layui_ext/dtree/font/dtreefont.css" type="text/css" rel="stylesheet">
    <script type="text/javascript" src="${ctx}/js/jquery-3.1.1.min.js"></script>
    <script type="text/javascript" src="${ctx}/js/layui/layui.js"></script>
    <script type="text/javascript" src="${ctx}/js/dtree.js"></script>
</head>

<body>
<ul id="demoTree" class="dtree" data-id="0"></ul>
<script>
    $(function () {
    	layui.extend({
    	    dtree: '${ctx}/js/layui_ext/dtree/dtree'   // {/}的意思即代表采用自有路径，即不跟随 base 路径
    	  }).use(['dtree','layer','jquery'], function(){
    	    var dtree = layui.dtree, layer = layui.layer, $ = layui.jquery;
    	    

            // 初始化树
            var DemoTree = dtree.render({
                elem: "#demoTree",
                type: "all",
                dot: false,  // 隐藏小圆点
                initLevel: 1,//不展开全部,默认展开
                url: "${ctx}/Barticlecategory/content/getTree.action", // 使用url加载（可与data加载同时存在）
                dataFormat: "list",
				line: true  // 显示树线
            });

            // 绑定节点点击
            dtree.on("node('demoTree')", function (obj) {
            	
                if (obj.param.parentId == 0)
                    return;
                top.main.location.href = '${ctx}/Article/content/fingbyid.action?id=' + obj.param.nodeId
            });
        });

    })
</script>
</body>
</html>
