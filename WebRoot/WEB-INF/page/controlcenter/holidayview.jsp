
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/page/share/taglib.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<title>Ginwave快信平台</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
						<li><a href="#">节日预览</a>
						</li>
					</ul>
				</div>
				<!-- 导航提示条ends -->

				<!-- 表单 starts -->
				<div class="row-fluid sortable">
					<div class="box span12">
						<div class="box-header well" data-original-title>
							<h2>
								<i class=" icon-eye-open"></i> 节日预览
							</h2>

						</div>
						<div class="box-content">
							<html:form action="/manag/holiday/viewUI" method="post"
								enctype="multipart/form-data" onsubmit="return checkfm(this)">
								<input type="hidden" name="method" value="viewUI">
								<html:hidden property="h_id" />

								<dl>
									<dt>节日图标</dt>
									<dd><img alt="" src="../..${holiday.icon }"></dd>
									<dt>节日名称</dt>
									<dd>${holiday.h_name }</dd>
									<dt>节日类型</dt>
									<dd>${holiday.type }</dd>
									<dt>${holiday.itemOneTitle }</dt>
									<dd>${holiday.itemOneCont }</dd>
									<dt>${holiday.itemTwoTitle }</dt>
									<dd>${holiday.itemTwoCont }</dd>
									<dt>${holiday.itemThreeTitle }</dt>
									<dd>${holiday.itemThreeCont }</dd>
									<dt>${holiday.itemFourTitle }</dt>
									<dd>${holiday.itemFourCont}</dd>
								</dl>
							</html:form>
							<a href="/manag/holiday/holidayListUI.do"	class="btn btn-primary">返回查看节日列表 </a>
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
