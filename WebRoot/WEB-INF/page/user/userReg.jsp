<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/page/share/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>用户注册Ginwave快信平台</title>

<!-- The styles -->

<style type="text/css">
.myinput {
	width: 160px;
}
.tocenter{
margin: 0 auto;
}
</style>
<!-- styles end -->
<SCRIPT language=JavaScript src="/js/FoshanRen.js"></SCRIPT>
<SCRIPT language=JavaScript src="/js/xmlhttp.js"></SCRIPT>
<SCRIPT LANGUAGE="JavaScript">
	
	
	function checkUsername() {
		var form = document.forms[0];
		var username = form.username.value;
		var viewobj = document.getElementById("checkResult");
		viewobj.innerHTML = "正在检测中...";
		send_request(function(value) {
			viewobj.innerHTML = value
		}, '<html:rewrite action="/user/reg"/>?method=isUserExsit&username='
				+ username, true);
	}
</SCRIPT>
</head>

<body>
	<!--  jsp:include page="/WEB-INF/page/share/simpleHead.jsp"-->
	<!-- topbar starts -->
	<jsp:include page="/WEB-INF/page/user/topbar.jsp" />
	<!-- topbar ends -->
	<!-- 检证用户是否存在表单 end -->

	<c:if test="${!empty error }"></c:if>
	<DIV id="errorinfo" style="DISPLAY:none">
		<TABLE cellSpacing=1 cellPadding=8 width="78%" align="center"
			bgColor="#dd9988" border=0>
			<TBODY>
				<TR>
					<TD bgColor="#ffffd5" align="left"><IMG height="17"
						src="/images/buy/exclamation-error-red.gif" width="17"> <FONT
							color="#990000"><STRONG><SPAN class="font14">错误提示<BR></SPAN></STRONG></FONT>
							<DIV id="errorMessage">${error }</DIV></TD>
				</TR>
			</TBODY>
		</TABLE>
	</DIV>

<div id="tocenter">
	<div class="row-fluid ">
		<div class="box span12">

			<html:form action="/user/reg" method="get"
				onsubmit="javascript:return checkForm()"
				styleClass="form-horizontal">
				<input type="hidden" name="method" value="reg" />
				<input type="hidden" name="directUrl" value="${param.directUrl}" />
				<fieldset>
					<legend>用户注册，以下内容均为必填项</legend>
					<div class="control-group info">
						<label class="control-label" for="inputInfo">用户名</label>
						<div class="controls">
							<input type="text" id="inputInfo" name="username" class=":requried :min_length;6 :max_length;12 :alphanum" />
							<br/> <input
								class="btn btn-info" type="button" name="check_username"
								value="检查用户名是否可用" onClick="checkUsername()"
								onMouseOver="this.style.cursor='hand';" /><span
								class="help-inline">5-20个字符(包括小写字母、数字、下划线)，一旦注册成功用户名不能修改。</span>
								

							<div id="checkResult"></div>
						</div>
					</div>
					<div class="control-group info">
						<label class="control-label" for="inputInfo">密码</label>
						<div class="controls">
							<input type="password" id="checkpsw" name="password" class=":requried :min_length;6 :max_length;12 :alphanum"/> <br/><span
								class="help-inline">密码由6-12个字符组成，请使用英文字母加数字或符号的组合密码</span>

						</div>
					</div>
					<div class="control-group info">
						<label class="control-label" for="inputInfo">再输入一遍密码</label>
						<div class="controls">
							<input type="password" id="inputInfo" name="repassword" class=":same_as;checkpsw"/> <br/><span
								class="help-inline">请再输入一遍您上面输入的密码。</span>
						</div>
					</div>
					<div class="control-group info">
						<label class="control-label" for="inputInfo">电子邮件</label>
						<div class="controls">
							<input type="text" id="inputInfo" name="email" class=":requried :email"/> <br/><span
								class="help-inline" />没有电子邮件？推荐使用<a
								href="https://reg.cn.yahoo.com/cnreg/cnreg_first?id=78001"
								target="_blank">雅虎3.5G免费超大邮箱</a>、<a
								href="http://mail.sogou.com/register.jsp" target="_blank">搜狐邮箱</a>和<a
								href="http://reg.126.com/reg1.jsp" target="_blank">网易邮箱</a>。<br>
						</div>
						</span>
					</div>
					<div class="form-actions">
						<button type="submit" class="btn btn-primary">提交注册信息</button>
						<button type="reset" class="btn">重置</button>
					</div>
				</fieldset>
			</html:form>
		</div>
	</div>
	<!--/span-->
</div>
	<!--/row-->
	<jsp:include page="/WEB-INF/page/share/Foot.jsp" />
</body>
</html>