package com.ginwavelz.sms.web.action.sms;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.springframework.stereotype.Controller;

import com.ginwavelz.sms.bean.holiday.Holiday;
import com.ginwavelz.sms.service.holiday.HolidayService;
import com.ginwavelz.sms.service.holiday.SmsService;
import com.ginwavelz.sms.web.formbean.holiday.HolidayForm;

@Controller("/manag/sms/delete")
public class SmsDeleteAction extends Action {
	@Resource
	SmsService smsService;

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		int sms_id=Integer.valueOf(request.getParameter("sms_id"));
		smsService.delete(sms_id);
		System.out.print(sms_id);
		request.setAttribute("title", "删除短信");
		return mapping.findForward("success");
	}
	
}
