<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/share/taglib.jsp" %>
<!DOCTYPE html>
<html >
<head>
<meta charset="utf-8">
<title>Ginwave快信平台</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description"
	content="Charisma, a fully featured, responsive, HTML5, Bootstrap admin template.">
<meta name="author" content="Muhammad Usman">

	<!-- The styles -->
</head>

<body>
	<!-- topbar starts -->
	<jsp:include page="/WEB-INF/page/user/topbar.jsp" />
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
				<div>
					<ul class="breadcrumb">
						<li><a href="#">快信管理</a> <span class="divider">/</span></li>
						<li><a href="#">节日管理</a></li>
					</ul>
				</div>
				<div class="sortable row-fluid">
				<a data-rel="tooltip" title="6 new members." class="well span3 top-block" href="/manag/holiday/addholidayUI.do">
					<span class="icon32 icon-red icon-plus"></span>
					<div>添加节日</div>
					<div>507</div>
					<span class="notification">6</span>
				</a>

				<a data-rel="tooltip" title="4 new pro members." class="well span3 top-block" href="#">
					<span class="icon32 icon-color icon-wrench"></span>
					<div>管理节日</div>
					<div>228</div>
					<span class="notification green">4</span>
				</a>
				<a data-rel="tooltip" title="6 new members." class="well span3 top-block" href="#">
					<span class="icon32 icon-envelope-closed"></span>
					<div>当月节日短信库</div>
					<div>507</div>
					<span class="notification">6</span>
				</a>

				<a data-rel="tooltip" title="4 new pro members." class="well span3 top-block" href="#">
					<span class="icon32 icon-color icon-envelope-closed"></span>
					<div>当月节日彩信库</div>
					<div>228</div>
					<span class="notification green">4</span>
				</a>
			</div>
				<div class="row-fluid sortable">		
				<div class="box span12">
					<div class="box-header well" data-original-title>
						<h2><i class="icon-envelope"></i> 当月节日彩信</h2>
						<div class="box-icon">
							<a href="#" class="btn btn-setting btn-round"><i class="icon-cog"></i></a>
							<a href="#" class="btn btn-minimize btn-round"><i class="icon-chevron-up"></i></a>
							<a href="#" class="btn btn-close btn-round"><i class="icon-remove"></i></a>
						</div>
					</div>
					<div class="box-content">
						<table class="table table-striped table-bordered bootstrap-datatable datatable">
						  <thead>
							  <tr>
								  <th>编码</th>
								  <th>节日</th>
								  <th>彩信图片</th>
								  <th>彩信内容</th>
								  <th>操作</th>
							  </tr>
						  </thead>   
						  <tbody>
							<tr>
								<td>001</td>
								<td class="center">元旦</td>
								<td class="center">国际传统节日</td>
								<td class="center">
									<span class="label label-success">Active</span>
								</td>
								<td class="center">
									<a class="btn btn-success" href="#">
										<i class="icon-zoom-in icon-white"></i>  
										预览                                            
									</a>
									<a class="btn btn-info" href="#">
										<i class="icon-edit icon-white"></i>  
										编辑                                            
									</a>
									<a class="btn btn-danger" href="#">
										<i class="icon-trash icon-white"></i> 
										删除
									</a>
								</td>
							</tr>
							
						  </tbody>
					  </table>            
					</div>
				</div><!--/span-->
			
			</div><!--/row-->
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
		<!-- footer start -->
		<jsp:include page="/WEB-INF/page/share/Foot.jsp" />
<!-- footer end -->

	</div>
	<!--/.fluid-container-->



</body>
</html>
