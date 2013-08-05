package com.ginwavelz.sms.web.formbean;

import org.apache.struts.action.ActionForm;

public class BaseForm extends ActionForm {
 private int page=1;

public int getPage() {
	return page;
}

public void setPage(int page) {
	this.page = page<1?1:page;
}
   
}
