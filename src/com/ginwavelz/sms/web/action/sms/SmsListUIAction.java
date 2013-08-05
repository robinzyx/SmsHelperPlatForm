package com.ginwavelz.sms.web.action.sms;

import java.util.LinkedHashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.stereotype.Controller;

import com.ginwavelz.sms.bean.PageView;
import com.ginwavelz.sms.bean.holiday.Holiday;
import com.ginwavelz.sms.bean.holiday.Sms;
import com.ginwavelz.sms.service.holiday.HolidayService;
import com.ginwavelz.sms.service.holiday.SmsService;
import com.ginwavelz.sms.web.formbean.holiday.HolidayForm;
import com.ginwavelz.sms.web.formbean.sms.SmsForm;

@Controller("/manag/sms/smsListUI")
public class SmsListUIAction extends Action {
	@Resource
	SmsService smsService;

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.print("sms coming");
		SmsForm smsForm =(SmsForm) form;
		PageView<Sms> smsPageView= new PageView<Sms>((int)smsService.getCount(), smsForm.getPage());
		smsPageView.setQueryResult(smsService.getScrollData(smsPageView.getFirstResult(), smsPageView.getMaxresult()));
		request.setAttribute("smsPageView", smsPageView);
		request.setAttribute("record", smsService.getCount());
		System.out.print(smsPageView);
		return mapping.findForward("success");
	}

	
}
