package com.ginwavelz.sms.web.action.sms;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.springframework.stereotype.Controller;

import com.ginwavelz.sms.bean.holiday.Holiday;
import com.ginwavelz.sms.bean.holiday.Sms;
import com.ginwavelz.sms.service.holiday.HolidayService;
import com.ginwavelz.sms.web.formbean.holiday.HolidayForm;
import com.ginwavelz.sms.web.formbean.sms.SmsForm;
@Controller("/manag/add/Sms")
public class AddSmsAction extends DispatchAction {
	@Resource
	HolidayService holidayService;

	public ActionForward addsms(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		int h_id= Integer.valueOf(request.getParameter("h_id"));
		System.out.print("my id="+h_id);
		SmsForm smsForm =(SmsForm) form;
		Holiday holiday=holidayService.find(smsForm.getH_id());
		List<Sms> smslist= new ArrayList<Sms>();
		Sms sms = new Sms();
		sms.setSms_cont(smsForm.getSms_cont().trim());
		smslist.add(sms);
		holiday.setSmslist(smslist);
		System.out.print("注解="+smsForm.getH_id());
		holidayService.save(holiday);
		return mapping.findForward("success");
	}
	

}
