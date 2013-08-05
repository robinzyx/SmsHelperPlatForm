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
				<a data-rel="tooltip" title="已有${record } 记录，点击添加。" class="well span3 top-block" href="/manag/holiday/addholidayUI.do">
					<span class="icon32 icon-red icon-plus"></span>
					<div>添加节日</div>
					<span class="notification">${record }</span>
				</a>
				<a data-rel="tooltip" title="共计${record }条记录。" class="well span3 top-block" href="#">
					<span class="icon32 icon-color icon-wrench"></span>
					<div>管理节日</div>
					<span class="notification green">${record}</span>
				</a>
				<a data-rel="tooltip" title="点击进入短信库查看" class="well span3 top-block" href="/manag/sms/smsListUI.do">
					<span class="icon32 icon-envelope-closed"></span>
					<div>节日短信库</div>
				</a>
				<a data-rel="tooltip" title="点击进入彩信库查看" class="well span3 top-block" href="/manag/mms/mmsListUI.do">
					<span class="icon32 icon-color icon-envelope-closed"></span>
					<div>节日彩信库</div>
				</a>
			</div>
				<div class="row-fluid sortable">		
				<div class="box span12">
					<div class="box-header well" data-original-title>
						<h2><i class="icon-star-empty"></i> 管理节日</h2>
						
					</div>
					<html:form action="/manag/holiday/holidayList" method="post">
							<html:hidden property="page" />
							<html:hidden property="h_id"/>
							<html:hidden property="h_name"  />
							<html:hidden property="month" />
							<html:hidden property="icon" />
							<html:hidden property="type" />
							<html:hidden property="itemOneTitle"/>
							<html:hidden property="itemOneCont"/>
							<html:hidden property="itemTwoTitle"/>
							<html:hidden property="itemTwoCont"/>
							<html:hidden property="itemThreeTitle"/>						
							<html:hidden property="itemThreeCont"/>						
							<html:hidden property="itemFourTitle"/>						
							<html:hidden property="itemFourCont"/>						
							<input name="method" type="hidden" value="list"/>
					<div class="box-content">
						<table class="table table-striped table-bordered bootstrap-datatable datatable">
						  <thead>
							  <tr>
								  <th>编号</th>
								  <th>名称</th>
								  <th>图标</th>
								  <th>日期</th>
								  <th>类型</th>
								  <th>标题1/内容1</th>
								  <th>标题2/内容2</th>
								  <th>标题3/内容3</th>
								  <th>标题4/内容4</th>
								  <th>添加短信/彩信</th>
								  <th >操作</th>
							  </tr>
						  </thead>   
						  <tbody>
						  <c:forEach items="${holidayPageView.records}" var="entry">
							<tr>
								<td class="center ">${entry.h_id }</td>
								<td class="center ">${entry.h_name }</td>
								<td class="center "><img alt="" src="${entry.icon}" width="50"></td>
								<td class="center">${entry.month }</td>
								<td class="center">${entry.type }</td>
								<td class="center "><div class="mytd">${entry.itemOneTitle }/${entry.itemOneCont }</div></td>
								<td class="center "><div class="mytd">${entry.itemTwoTitle }/${entry.itemTwoCont}</div></td>
								<td class="center "><div class="mytd">${entry.itemThreeTitle}/${entry.itemThreeCont}</div></td>
								<td class="center "><div class="mytd">${entry.itemFourTitle }/${entry.itemFourCont }</div></td>
								<td class="center">
									<a class="btn " href="<html:rewrite action="/manag/add/smsUI.do?"/>method=addSmsUI&h_id=${entry.h_id}">
										<i class=" icon-envelope"></i>  
										 短信                                        
									</a>
									<a class="btn " href="<html:rewrite action="/manag/add/mmsUI.do?"/>method=addMmsUI&h_id=${entry.h_id}">
										<i class=" icon-envelope"></i>  
										彩信                                       
									</a>
								</td>
								
								<td class="center">
									<a class="btn btn-success" href="<html:rewrite action="/manag/holiday/viewUI.do?"/>method=viewUI&h_id=${entry.h_id}">
										<i class="icon-zoom-in icon-white"></i>  
										预览                                            
									</a>
									<a class="btn btn-info" href="<html:rewrite action="/manag/holiday/editUI.do?"/>method=editUI&h_id=${entry.h_id}">
										<i class="icon-edit icon-white"></i>  
										 编辑                                           
									</a>
									<a class="btn btn-danger" href="<html:rewrite action="/manag/holiday/delete.do?"/>method=delete&h_id=${entry.h_id}">
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
