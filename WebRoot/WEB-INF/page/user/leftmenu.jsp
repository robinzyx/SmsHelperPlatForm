<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html lang="true">
  <head>
    <html:base />
    

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
   <ul class="nav nav-tabs nav-stacked main-menu">
						<li class="nav-header hidden-tablet">快信</li>
						<li><a class="ajax-link"
							href="/manag/holiday/holidayListUI.do"><i
								class="icon-star-empty"></i><span class="hidden-tablet">
									节日管理</span> </a>
						<li><a class="ajax-link  " href="/manag/mms/mmsListUI.do"><i
								class="icon-envelope "></i><span class="hidden-tablet">
									彩信管理</span>
						</a>
						</li>
						<li><a class="ajax-link" href="/manag/sms/smsListUI.do"><i
								class="icon-envelope"></i><span class="hidden-tablet">
									短信管理</span>
						</a>
						</li>
						</li>
						<li class="nav-header hidden-tablet">用户</li>
						<li><a class="ajax-link" href="/manag/user/userListUI.do"><i
								class="icon-user"></i><span class="hidden-tablet"> 用户管理</span> </a>
						</li>
						<li><a class="ajax-link" href="ui.html"><i
								class="icon-search"></i><span class="hidden-tablet"> 用户查询</span>
						</a>
						</li>
					</ul>
  </body>
</html:html>
