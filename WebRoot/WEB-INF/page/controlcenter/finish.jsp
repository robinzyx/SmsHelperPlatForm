<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/page/share/taglib.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<title>Ginwave快信平台</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
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
								<DIV id="errorMessage">${error }</DIV>
							</TD>
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
						<li><a href="#">快信管理</a> <span class="divider">/</span>
						</li>
						<li><a href="#">节日管理</a><span class="divider">/</span>
						</li>
						<li><a href="#">添加完成</a>
						</li>
					</ul>
				</div>
				<!-- 导航提示条ends -->
				<!-- 进度条 -->
				<!-- 表单 starts -->
				<div class="row-fluid sortable">
					    <div class="alert alert-success">
   						${title }完成！
   						 </div>
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

	<!-- footer start -->
		<jsp:include page="/WEB-INF/page/share/Foot.jsp" />
<!-- footer end -->

	</div>
	
	<script type="text/javascript">
		function checkfrm(form){
			alert("备注不能大于100字！");
			return true;
		}
	</script>


</body>
</html>
