<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/page/share/taglib.jsp" %>

<!DOCTYPE html>
<html lang="zh-CN">
<head>

<meta charset="utf-8">
<title>Ginwave快信平台</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description"
	content="Charisma, a fully featured, responsive, HTML5, Bootstrap admin template.">
<meta name="author" content="Muhammad Usman">
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
						<li><a href="#">用户</a> <span class="divider">/</span></li>
						<li><a href="#">用户管理</a></li>
					</ul>
				</div>
				<div class="row-fluid sortable">		
				<div class="box span12">
					<div class="box-header well" data-original-title>
						<h2><i class="icon-user"></i> 用户</h2>
						
					</div>
					<html:form action="/manag/user/list" method="post">
							<html:hidden property="page" />
							<html:hidden property="username"  />
							<html:hidden property="gender" />
							<html:hidden property="email" />
							<html:hidden property="contactInfo" />
							<html:hidden property="regTime"/>
							<input name="method" type="hidden" value="list"/>
					<div class="box-content">
						<table class="table table-striped table-bordered bootstrap-datatable datatable">
						  <thead>
							  <tr>
								  <th>用户名称</th>
								  <th>性别</th>
								  <th>email</th>
								  <th>注册时间</th>
								  <th>操作</th>
							  </tr>
						  </thead>   
						  <tbody>
						 <c:forEach items="${pageView.records}" var="entry">
							<tr>
								<td class="center">${entry.username}</td>
								<td class="center">${entry.gender }</td>
								<td class="center">${entry.email }</td>
								<td class="center">${entry.regTime }</td>
								
								
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
							</c:forEach>
						  </tbody>
					  </table>    
					</div>
					</html:form>
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
