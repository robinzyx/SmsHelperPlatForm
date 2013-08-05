<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/page/share/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<!--
		Charisma v1.0.0

		Copyright 2012 Muhammad Usman
		Licensed under the Apache License v2.0
		http://www.apache.org/licenses/LICENSE-2.0

		http://usman.it
		http://twitter.com/halalit_usman
	-->
<title>Ginwave快信平台</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- The styles -->
<link href="/css/bootstrap-cerulean.css" rel="stylesheet">
<style type="text/css">
body {
	padding-bottom: 40px;
}

.sidebar-nav {
	padding: 9px 0;
}
</style>
<link href="/css/bootstrap-responsive.css" rel="stylesheet">
<link href="/css/charisma-app.css" rel="stylesheet">
<link href="/css/jquery-ui-1.8.21.custom.css" rel="stylesheet">
<link href='/css/fullcalendar.css' rel='stylesheet'>
<link href='/css/fullcalendar.print.css' rel='stylesheet' media='print'>
<link href='/css/chosen.css' rel='stylesheet'>
<link href='/css/uniform.default.css' rel='stylesheet'>
<link href='/css/colorbox.css' rel='stylesheet'>
<link href='/css/jquery.cleditor.css' rel='stylesheet'>
<link href='/css/jquery.noty.css' rel='stylesheet'>
<link href='/css/noty_theme_default.css' rel='stylesheet'>
<link href='/css/elfinder.min.css' rel='stylesheet'>
<link href='/css/elfinder.theme.css' rel='stylesheet'>
<link href='/css/jquery.iphone.toggle.css' rel='stylesheet'>
<link href='/css/opa-icons.css' rel='stylesheet'>
<link href='/css/uploadify.css' rel='stylesheet'>

<!-- The HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
	  <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
	<![endif]-->

<!-- The fav icon -->
<link rel="shortcut icon" href="img/favicon.ico">
</head>

<body>
	<!-- topbar starts -->
	<div class="navbar">
		<div class="navbar-inner">
			<div class="container-fluid">
				<a class="btn btn-navbar" data-toggle="collapse"
					data-target=".top-nav.nav-collapse,.sidebar-nav.nav-collapse">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span> </a> <a class="brand" href="index.html"> <img
					alt="Charisma Logo" src="/img/logo20.png" /> <span>经纬快信平台</span> </a>

				<!-- theme selector starts -->

				<!-- theme selector ends -->

				<!-- user dropdown starts -->
				<div class="btn-group pull-right">
					<a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
						<i class="icon-user"></i><span class="hidden-phone"> admin</span>
						<span class="caret"></span> </a>
					<ul class="dropdown-menu">
						<li><a href="#">Profile</a></li>
						<li class="divider"></li>
						<li><a href="login.html">Logout</a></li>
					</ul>
				</div>
				<!-- user dropdown ends -->

				<div class="top-nav nav-collapse">
					<ul class="nav">
						<li><a href="#">Visit Site</a></li>
						<li>
							<form class="navbar-search pull-left">
								<input placeholder="Search" class="search-query span2"
									name="query" type="text">
							</form>
						</li>
					</ul>
				</div>
				<!--/.nav-collapse -->
			</div>
		</div>
	</div>
	<!-- topbar ends -->
	<div class="container-fluid">
		<div class="row-fluid">

			<!-- left menu starts -->
			<div class="span2 main-menu-span">
				<div class="well nav-collapse sidebar-nav">
				<jsp:include page="/WEB-INF/page/user/leftmenu.jsp" />
				</div>
				<!--/.well -->
			</div>
			<!--/span-->
			<!-- left menu ends -->
			<c:if test="${!empty error }"></c:if>
			<DIV id="errorinfo" style="DISPLAY:none">
				<TABLE cellSpacing=1 cellPadding=8 width="78%" align="center"
					bgColor="#dd9988" border=0>
					<TBODY>
						<TR>
							<TD bgColor="#ffffd5" align="left"><IMG height="17"
								src="/images/buy/exclamation-error-red.gif" width="17"> <FONT
								color="#990000"><STRONG><SPAN class="font14">错误提示<BR>
									</SPAN> </STRONG> </FONT>
								<DIV id="errorMessage">${error }</DIV></TD>
						</TR>
					</TBODY>
				</TABLE>
			</DIV>

			<noscript>
				<div class="alert alert-block span10">
					<h4 class="alert-heading">Warning!</h4>
					<p>
						You need to have <a href="http://en.wikipedia.org/wiki/JavaScript"
							target="_blank">JavaScript</a> enabled to use this site.
					</p>
				</div>
			</noscript>



			<div id="content" class="span10">
				<!-- content starts -->
				<!-- 导航提示条 stars -->
				<div>
					<ul class="breadcrumb">
						<li><a href="#">快信管理</a> <span class="divider">/</span></li>
						<li><a href="#">短信管理</a><span class="divider">/</span></li>
					</ul>
				</div>
				<!-- 导航提示条ends -->
					<div class="sortable row-fluid">
				<a data-rel="tooltip" title="点击添加。" class="well span3 top-block" href="/manag/holiday/addholidayUI.do">
					<span class="icon32 icon-red icon-plus"></span>
					<div>添加节日</div>
				</a>
				<a data-rel="tooltip" title="点击管理节日。" class="well span3 top-block" href="/manag/holiday/holidayListUI.do">
					<span class="icon32 icon-color icon-wrench"></span>
					<div>管理节日</div>
				</a>
				<a data-rel="tooltip" title="${record}" class="well span3 top-block" href="/manag/sms/smsListUI.do.do">
					<span class="icon32 icon-envelope-closed"></span>
					<div>节日短信库</div>
					<span class="notification">${record}</span>
				</a>
				<a data-rel="tooltip" title="点击进入彩信库" class="well span3 top-block" href="/manag/mms/mmsListUI.do">
					<span class="icon32 icon-color icon-envelope-closed"></span>
					<div>节日彩信库</div>
					
				</a>
			</div>
				<!-- 表单 starts -->
				<div class="row-fluid sortable">

					<div class="box span12">

						<div class="box-header well" data-original-title>
							<h2>
								<i class="icon-envelope"></i> 短信预览
							</h2>
						</div>
						<html:form action="/manag/sms/smsList" method="post">
							<html:hidden property="page" />
							<html:hidden property="h_id" />
							<html:hidden property="sms_id" />
							<html:hidden property="sms_cont" />
							<input name="method" type="hidden" value="list" />
							<div class="box-content">
								<table
									class="table table-striped table-bordered bootstrap-datatable datatable">
									
									<thead>
										<tr>
											<th>短信编码</th>
											<th>所属节日</th>
											<th>短信内容</th>
											<th>操作</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${smsPageView.records}" var="entry">
											<tr>
												<td class="center">${entry.sms_id }</td>
												<td class="center">${entry.holiday.h_id }</td>
												<td class="center">${entry.sms_cont }</td>
												<td class="center"><a class="btn btn-info" href="#">
														<i class="icon-edit icon-white"></i> 编辑 </a> <a
													class="btn btn-danger"
													href="<html:rewrite action="/manag/sms/delete.do?"/>sms_id=${entry.sms_id}">
														<i class="icon-trash icon-white"></i> 删除 </a></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</html:form>
					</div>
					<!--/span-->
				</div>
			</div>
			<!--/span-->
		</div>
		<!--/row-->

		<!-- 表单 ends -->

		<!-- content ends -->
	</div>
	<!--/#content.span10-->
	</div>
	<!--/fluid-row-->

	<hr>
	<div class="modal hide fade" id="myModal">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal">×</button>
			<h3>Settings</h3>
		</div>
		<div class="modal-body">
			<p>Here settings can be configured...</p>
		</div>
		<div class="modal-footer">
			<a href="#" class="btn" data-dismiss="modal">Close</a> <a href="#"
				class="btn btn-primary">Save changes</a>
		</div>
	</div>

	<footer>
		<p class="pull-left">
			&copy; <a href="http://usman.it" target="_blank">Ginwave</a> 2013
		</p>
		<p class="pull-right">
			Powered by: <a href="http://usman.it/free-responsive-admin-template">Robinzyx</a>
		</p>
	</footer>

	</div>
	<!--/.fluid-container-->

	<!-- external javascript
	================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->

	<!-- jQuery -->
	<script src="/js/jquery-1.7.2.min.js"></script>
	<!-- jQuery UI -->
	<script src="/js/jquery-ui-1.8.21.custom.min.js"></script>
	<!-- transition / effect library -->
	<script src="/js/bootstrap-transition.js"></script>
	<!-- alert enhancer library -->
	<script src="/js/bootstrap-alert.js"></script>
	<!-- modal / dialog library -->
	<script src="/js/bootstrap-modal.js"></script>
	<!-- custom dropdown library -->
	<script src="/js/bootstrap-dropdown.js"></script>
	<!-- scrolspy library -->
	<script src="/js/bootstrap-scrollspy.js"></script>
	<!-- library for creating tabs -->
	<script src="/js/bootstrap-tab.js"></script>
	<!-- library for advanced tooltip -->
	<script src="/js/bootstrap-tooltip.js"></script>
	<!-- popover effect library -->
	<script src="/js/bootstrap-popover.js"></script>
	<!-- button enhancer library -->
	<script src="/js/bootstrap-button.js"></script>
	<!-- accordion library (optional, not used in demo) -->
	<script src="/js/bootstrap-collapse.js"></script>
	<!-- carousel slideshow library (optional, not used in demo) -->
	<script src="/js/bootstrap-carousel.js"></script>
	<!-- autocomplete library -->
	<script src="/js/bootstrap-typeahead.js"></script>
	<!-- tour library -->
	<script src="/js/bootstrap-tour.js"></script>
	<!-- library for cookie management -->
	<script src="/js/jquery.cookie.js"></script>
	<!-- calander plugin -->
	<script src='/js/fullcalendar.min.js'></script>
	<!-- data table plugin -->
	<script src='/js/jquery.dataTables.min.js'></script>

	<!-- chart libraries start -->
	<script src="/js/excanvas.js"></script>
	<script src="/js/jquery.flot.min.js"></script>
	<script src="/js/jquery.flot.pie.min.js"></script>
	<script src="/js/jquery.flot.stack.js"></script>
	<script src="/js/jquery.flot.resize.min.js"></script>
	<!-- chart libraries end -->

	<!-- select or dropdown enhancer -->
	<script src="/js/jquery.chosen.min.js"></script>
	<!-- checkbox, radio, and file input styler -->
	<script src="/js/jquery.uniform.min.js"></script>
	<!-- plugin for gallery image view -->
	<script src="/js/jquery.colorbox.min.js"></script>
	<!-- rich text editor library -->
	<script src="/js/jquery.cleditor.min.js"></script>
	<!-- notification plugin -->
	<script src="/js/jquery.noty.js"></script>
	<!-- file manager library -->
	<script src="/js/jquery.elfinder.min.js"></script>
	<!-- star rating plugin -->
	<script src="/js/jquery.raty.min.js"></script>
	<!-- for iOS style toggle switch -->
	<script src="/js/jquery.iphone.toggle.js"></script>
	<!-- autogrowing textarea plugin -->
	<script src="/js/jquery.autogrow-textarea.js"></script>
	<!-- multiple file upload plugin -->
	<script src="/js/jquery.uploadify-3.1.min.js"></script>
	<!-- history.js for cross-browser state change on ajax -->
	<script src="/js/jquery.history.js"></script>
	<!-- application script for Charisma demo -->
	<script src="/js/charisma.js"></script>
	<!-- ajax upload -->
	<script src="/js/ajaxupload.js"></script>
	<script type="text/javascript">
		function checkfrm(form) {
			alert("备注不能大于100字！");
			return true;
		}
	</script>


</body>
</html>
