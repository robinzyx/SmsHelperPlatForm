
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/page/share/taglib.jsp"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
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
						<li><a href="#">节日管理</a><span class="divider">/</span></li>
						<li><a href="#">节日预览</a></li>
					</ul>
				</div>
				<!-- 导航提示条ends -->
				
				<!-- 表单 starts -->
				<div class="row-fluid sortable">
					<div class="box span12">
						<div class="box-header well" data-original-title>
							<h2>
								<i class=" icon-edit"></i> 节日编辑
							</h2>
							
						</div>
						<div class="box-content">
                       
							<html:form action="/manag/holiday/edit" method="post"
								enctype="multipart/form-data" styleClass="form-horizontal"
								onsubmit="return checkfm(this)">
								<INPUT TYPE="hidden" NAME="method" value="editUI">
								<html:hidden property="h_id"/>
								
								<fieldset>
									<div class="control-group">
										<label class="control-label" for="typeahead">节日名称 </label>
										<div class="controls">
											<input type="text" class="span6 typeahead" id="typeahead"
												name="h_name" data-provide="typeahead" data-items="4" value="${holiday.h_name }"
												data-source='["元旦","腊八","春节","元宵节","情人节","妇女节","植树节","愚人节","清明节","劳动节","青年节","母亲节","护士节","儿童节","父亲节","端午节","建党节","七夕节","教师节","中秋节","国庆节","重阳节","环卫节","万圣节","记者节","光棍节","圣诞节"]'>
										</div>
									</div>
									<!-- <div class="control-group">
										<label class="control-label" for="date01">添加日期</label>
										<div class="controls">
											<input type="text" 
												 name="create_time"
												style="height: 20px;" id="date01" class=":date_au" >
										</div>
									</div>
									 -->

									<div class="control-group">
										<label class="control-label" for="fileInput">节日图标</label>
										<div class="controls">
											<input class="input-file uniform_on" id="fileInput"
												name="icon" type="file" value="${holiday.icon }">
										</div>

									</div>

									<div class="control-group">
										<label class="control-label" for="selectError">节日日期</label>
										<div class="controls">
											<select id="selectError" data-rel="chosen" name="month" value="${holiday.month }">
												<option>01/01</option>
												<option>农历01/01</option>
												<option>农历12/08</option>
												<option>农历01/15</option>
												<option>02/14</option>
												<option>03/08</option>
												<option>03/12</option>
												<option>04/01</option>
												<option>04/05</option>
												<option>05/01</option>
												<option>05/04</option>
												<option>五月第二个星期日</option>
												<option>05/12</option>
												<option>06/01</option>
												<option>六月第三个星期日</option>
												<option>农历05/05</option>
												<option>07/01</option>
												<option>农历07/07</option>
												<option>09/10</option>
												<option>农历08/15</option>
												<option>10/01</option>
												<option>农历09/09</option>
												<option>10/03</option>
												<option>11/08</option>
												<option>11/11</option>
												<option>12/25</option>
											</select>
										</div>
									</div>


									<div class="control-group">
										<label class="control-label">节日类型</label>
										<div class="controls">
											<label class="radio"> <input type="radio" name="type"
												id="optionsRadios1" value="中国传统节日 " checked="">
												中国传统节日 </label>
											<div style="clear:both"></div>
											<label class="radio"> <input type="radio" name="type"
												id="optionsRadios2" value="世界传统节日"> 世界传统节日 </label>
										</div>
									</div>

<div class="control-group">
										<label class="control-label" for="textarea2">自定义标题</label>
										<div class="controls">
											<label class="control-label" for="textarea2">自定义内容</label>
										</div>
									</div>


									<div class="control-group">
										<div class="control-label"><input id="textInput" class="input-text" value="${holiday.itemOneTitle }" style="width: 50px" type="text" name="itemOneTitle" /></div>
										<div class="controls">
											<textarea id="textarea2" rows="3" style="width: auto;" name="itemOneCont" >${holiday.itemOneCont }</textarea>
										</div>
									</div>
									<div class="control-group">
										<div class="control-label"><input id="textInput" class="input-text" style="width: 50px" type="text" name="itemTwoTitle" value="${holiday.itemTwoTitle }"/></div>
										<div class="controls">
											<textarea id="textarea2" name="itemTwoCont" rows="3" style="width: auto;" >${holiday.itemTwoCont }</textarea>
										</div>
									</div>
									<div class="control-group">
										<div class="control-label"><input id="textInput" class="input-text" style="width: 50px" type="text" name="itemThreeTitle" value="${holiday.itemThreeTitle }"/></div>
										<div class="controls">
											<textarea id="textarea2" name="itemThreeCont" rows="3" style="width: auto;" >${holiday.itemThreeCont }</textarea>
										</div>
									</div>
									<div class="control-group">
										<div class="control-label"><input id="textInput" class="input-text" style="width: 50px" type="text" name="itemFourTitle" value="${holiday.itemFourTitle }" /></div>
										<div class="controls">
											<textarea id="textarea2" name="itemFourCont" style="width: auto;"  >${holiday.itemFourCont }</textarea>
										</div>
									</div>


									<div class="form-actions">
										<input type="submit" name="submit" class="btn btn-primary"
											value="保存" /> <input type="reset" class="btn" value="取消" />
									</div>
								</fieldset>
							</html:form>

						
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
