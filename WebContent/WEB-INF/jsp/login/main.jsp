<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:set value="${pageContext.request.contextPath}" scope="page" var="ctx"></c:set>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en">
<head>
<title>欢迎使用易云电商后台管理系统</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<meta name="description" content="概述及统计" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<!--basic styles-->

<link href="${ctx}/assets/css/bootstrap.min.css" rel="stylesheet" />
<link href="${ctx}/assets/css/bootstrap-responsive.min.css"
	rel="stylesheet" />
<link rel="stylesheet" href="${ctx}/assets/css/font-awesome.min.css" />
<link rel="stylesheet" href="${ctx}/assets/css/ace.min.css" />
<link rel="stylesheet" href="${ctx}/assets/css/ace-responsive.min.css" />
<link rel="stylesheet" href="${ctx}/assets/css/ace-skins.min.css" />
<!--inline styles related to this page-->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />


</head>

<body>
	<div class="navbar">
		<div class="navbar-inner">
			<div class="container-fluid">
				<a href="#" class="brand"> <small> <i class="icon-leaf"></i>
						欢迎使用易云电商后台管理系统
				</small>
				</a>
				<!--/.brand-->

			</div>
			<!--/.container-fluid-->
		</div>
		<!--/.navbar-inner-->
	</div>

	<div class="main-container container-fluid">
		<a class="menu-toggler" id="menu-toggler" href="#"> <span
			class="menu-text"></span>
		</a>

		<div class="sidebar" id="sidebar">
			<div class="sidebar-shortcuts" id="sidebar-shortcuts">
				<div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
					<button class="btn btn-small btn-success">
						<i class="icon-signal"></i>
					</button>

					<button class="btn btn-small btn-info">
						<i class="icon-pencil"></i>
					</button>

					<button class="btn btn-small btn-warning">
						<i class="icon-group"></i>
					</button>

					<button class="btn btn-small btn-danger">
						<i class="icon-cogs"></i>
					</button>
				</div>

				<div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
					<span class="btn btn-success"></span> <span class="btn btn-info"></span>

					<span class="btn btn-warning"></span> <span class="btn btn-danger"></span>
				</div>
			</div>
			<!--#sidebar-shortcuts-->

			<ul class="nav nav-list">
				<li>
				<a id="roomManageId" onclick="roomManage()"
					class="dropdown-toggle"> 
					<i class="icon-home"></i> 
					<span class="menu-text">商品管理 </span> <b class="arrow icon-angle-down"></b>
				</a>
					<ul class="submenu">
						<li><a id="roomSetId" onclick="roomSet()"> <i
								class="icon-double-angle-right"></i> <span>品牌管理</span>
						</a></li>

						<li><a id="commoditySetId" onclick="commoditySet()"> <i
								class="icon-double-angle-right"></i> <span>规格管理</span>
						</a></li>
					</ul></li>

				<li><a id="roomManageId" href="http://localhost:8080/app_demo/index"
					class="dropdown-toggle"> <i class="icon-home"></i> <span
						class="menu-text">权限管理 </span> <b class="arrow icon-angle-down"></b>
				</a>

			   </li>

				<li><a id="stayManageId" onclick="stayManage()"
					class="dropdown-toggle"> <i class="icon-move"></i> <span
						class="menu-text">住宿管理 </span> <b class="arrow icon-angle-down"></b>
				</a>

					<ul class="submenu">
						<li><a id="reservationsId" onclick="reservations()"> <i
								class="icon-double-angle-right"></i> <span>客房预订</span>
						</a></li>

						<li><a id="personageId" onclick="personage()"> <i
								class="icon-double-angle-right"></i> <span>住宿登记</span>
						</a></li>

						<!-- <li>
								<a id="groupId" onclick="group()">
									<i class="icon-double-angle-right"></i>
									<span>团队住宿登记 </span>
								</a>
							</li> -->

					</ul></li>

				<li><a id="financeManageId" onclick="financeManage()"
					class="dropdown-toggle"> <i class="icon-heart"></i> <span
						class="menu-text">财务管理 </span> <b class="arrow icon-angle-down"></b>
				</a>

					<ul class="submenu">

						<li><a id="financeStatisticsId" onclick="financeStatistics()">
								<i class="icon-double-angle-right"></i> <span>财务统计 </span>
						</a></li>

					</ul></li>

				<li><a id="passengerManageId" onclick="passengerManage()"
					class="dropdown-toggle"> <i class="icon-user"></i> <span
						class="menu-text">旅客管理 </span> <b class="arrow icon-angle-down"></b>
				</a>

					<ul class="submenu">

						<li><a id="passengerInformationId"
							onclick="passengerInformation()" href="#"> <i
								class="icon-double-angle-right"></i> <span>旅客信息 </span>
						</a></li>
						<li><a id="receiveTargetId" onclick="receiveTarget()"
							href="#"> <i class="icon-double-angle-right"></i> <span>接待对象
							</span>
						</a></li>

					</ul></li>



			</ul>
			<!--/.nav-list-->

			<div class="sidebar-collapse" id="sidebar-collapse">
				<i class="icon-double-angle-left"></i>
			</div>
		</div>

		<div class="main-content">
			<div class="breadcrumbs" id="breadcrumbs">
				<ul class="breadcrumb">
					<li><i class="icon-home home-icon"></i> <a id="bigGuide"
						href="#"></a> <span class="divider"> <i
							class="icon-angle-right arrow-icon"></i>
					</span></li>
					<li id="smallGuide" class="active"></li>
				</ul>
				<!--.breadcrumb-->

				</ul>
				<!--.breadcrumb-->

			</div>

			<div style="width: 100%; height: 100%;">
				<iframe id="Mainid" src="${ctx}/Main/todata.do"
					style="width: 100%; height: 100%;" frameBorder="0" scrolling="no"></iframe>
			</div>

			<div class="ace-settings-container" id="ace-settings-container">
				<div class="btn btn-app btn-mini btn-warning ace-settings-btn"
					id="ace-settings-btn">
					<i class="icon-cog bigger-150"></i>
				</div>

				<div class="ace-settings-box" id="ace-settings-box">
					<div>
						<div class="pull-left">
							<select id="skin-colorpicker" class="hide">
								<option data-class="default" value="#222A2D" />#438EB9
								<option data-class="skin-1" value="#438EB9" />#222A2D
								<option data-class="skin-2" value="#C6487E" />#C6487E
								<option data-class="skin-3" value="#D0D0D0" />#D0D0D0
							</select>
						</div>
						<span>&nbsp; 选择皮肤</span>
					</div>

					<div>
						<input type="checkbox" class="ace-checkbox-2"
							id="ace-settings-header" /> <label class="lbl"
							for="ace-settings-header">固定头部</label>
					</div>

					<div>
						<input type="checkbox" class="ace-checkbox-2"
							id="ace-settings-sidebar" /> <label class="lbl"
							for="ace-settings-sidebar">固定侧栏</label>
					</div>

					<div>
						<input type="checkbox" class="ace-checkbox-2"
							id="ace-settings-breadcrumbs" /> <label class="lbl"
							for="ace-settings-breadcrumbs">固定面包屑</label>
					</div>

					<div>
						<input type="checkbox" class="ace-checkbox-2"
							id="ace-settings-rtl" /> <label class="lbl"
							for="ace-settings-rtl">左右互换</label>
					</div>
				</div>
			</div>
			<!--/#ace-settings-container-->
		</div>
		<!--/.main-content-->
	</div>
	<!--/.main-container-->

	<a href="#" id="btn-scroll-up"
		class="btn-scroll-up btn btn-small btn-inverse"> <i
		class="icon-double-angle-up icon-only bigger-110"></i>
	</a>

	<!--basic scripts-->

	<!--[if !IE]>-->

	<script src="assets/js/jquery-2.0.3.min.js"></script>
 

	<script type="text/javascript">
		window.jQuery
				|| document
						.write("<script src='${ctx}/assets/js/jquery-2.0.3.min.js'>"
								+ "<"+"/script>");
	</script>

	<!--<![endif]-->

	<!--[if IE]>
<script type="text/javascript">
 window.jQuery || document.write("<script src='${ctx}/assets/js/jquery-1.10.2.min.js'>"+"<"+"/script>");
</script>
<![endif]-->

	<script type="text/javascript">
		if ("ontouchend" in document)
			document
					.write("<script src='${ctx}/assets/js/jquery.mobile.custom.min.js'>"
							+ "<"+"/script>");
	</script>
	<script src="${ctx}/assets/js/bootstrap.min.js"></script>

	<!--page specific plugin scripts-->

	<!--[if lte IE 8]>
		  <script src="${ctx}/assets/js/excanvas.min.js"></script>
		<![endif]-->

	<script src="${ctx}/assets/js/jquery-ui-1.10.3.custom.min.js"></script>
	<script src="${ctx}/assets/js/jquery.ui.touch-punch.min.js"></script>
	<script src="${ctx}/assets/js/jquery.slimscroll.min.js"></script>
	<script src="${ctx}/assets/js/jquery.easy-pie-chart.min.js"></script>
	<script src="${ctx}/assets/js/jquery.sparkline.min.js"></script>
	<script src="${ctx}/assets/js/flot/jquery.flot.min.js"></script>
	<script src="${ctx}/assets/js/flot/jquery.flot.pie.min.js"></script>
	<script src="${ctx}/assets/js/flot/jquery.flot.resize.min.js"></script>

	<script src="/${ctx}/assets/js/ace-extra.min.js"></script>


	<!--ace scripts耗时长-->

	<script src="${ctx}/assets/js/ace-elements.min.js"></script>
	<script src="${ctx}/assets/js/ace.min.js"></script>

	<!--inline scripts related to this page-->

	<script type="text/javascript">
	  

		function passengerInformation() {
			var a = document.getElementById("passengerManageId")
					.getElementsByTagName('span')[0].innerHTML;
			document.getElementById("bigGuide").innerHTML = a + "";
			var s = document.getElementById("passengerInformationId")
					.getElementsByTagName('span')[0].innerHTML;
			document.getElementById("smallGuide").innerHTML = s + "";
			document.getElementById('Mainid').src = '${ctx}/Passenger/tolist.do';
		}
		function receiveTarget() {
			var a = document.getElementById("passengerManageId")
					.getElementsByTagName('span')[0].innerHTML;
			document.getElementById("bigGuide").innerHTML = a + "";
			var s = document.getElementById("receiveTargetId")
					.getElementsByTagName('span')[0].innerHTML;
			document.getElementById("smallGuide").innerHTML = s + "";
			document.getElementById('Mainid').src = '${ctx}/ReceiveTarget/tolist.do';
		}

		 
		function roomSet() {
			var a = document.getElementById("roomManageId")
					.getElementsByTagName('span')[0].innerHTML;
			document.getElementById("bigGuide").innerHTML = a + "";
			var s = document.getElementById("roomSetId").getElementsByTagName(
					'span')[0].innerHTML;
			document.getElementById("smallGuide").innerHTML = s + "";
			document.getElementById('Mainid').src = '${ctx}/product/list.do';
		}
		function commoditySet() {
			var a = document.getElementById("roomManageId")
					.getElementsByTagName('span')[0].innerHTML;
			document.getElementById("bigGuide").innerHTML = a + "";
			var s = document.getElementById("commoditySetId")
					.getElementsByTagName('span')[0].innerHTML;
			document.getElementById("smallGuide").innerHTML = s + "";
			document.getElementById('Mainid').src = '${ctx}/Commodity/tolist.do';
		}

		function stayManage() {

		}
		function reservations() {
			var a = document.getElementById("stayManageId")
					.getElementsByTagName('span')[0].innerHTML;
			document.getElementById("bigGuide").innerHTML = a + "";
			var s = document.getElementById("reservationsId")
					.getElementsByTagName('span')[0].innerHTML;
			document.getElementById("smallGuide").innerHTML = s + "";
			document.getElementById('Mainid').src = '${ctx}/Predetermine/tolist.do';
		}
		function personage() {
			var a = document.getElementById("stayManageId")
					.getElementsByTagName('span')[0].innerHTML;
			document.getElementById("bigGuide").innerHTML = a + "";
			var s = document.getElementById("personageId")
					.getElementsByTagName('span')[0].innerHTML;
			document.getElementById("smallGuide").innerHTML = s + "";
			document.getElementById('Mainid').src = '${ctx}/StayRegister/tolist.do';
		}
		function group() {
			var a = document.getElementById("stayManageId")
					.getElementsByTagName('span')[0].innerHTML;
			document.getElementById("bigGuide").innerHTML = a + "";
			var s = document.getElementById("groupId").getElementsByTagName(
					'span')[0].innerHTML;
			document.getElementById("smallGuide").innerHTML = s + "";
		}

		function financeManage() {

		}
		function financeStatistics() {
			var a = document.getElementById("financeManageId")
					.getElementsByTagName('span')[0].innerHTML;
			document.getElementById("bigGuide").innerHTML = a + "";
			var s = document.getElementById("financeStatisticsId")
					.getElementsByTagName('span')[0].innerHTML;
			document.getElementById("smallGuide").innerHTML = s + "";
			document.getElementById('Mainid').src = '${ctx}/FinancialStatistics/tolist.do';
		}
	</script>
</body>
</html>
