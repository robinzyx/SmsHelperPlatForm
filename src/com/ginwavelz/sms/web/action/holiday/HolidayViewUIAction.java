package com.ginwavelz.sms.web.action.holiday;

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
import com.ginwavelz.sms.web.formbean.holiday.HolidayForm;

@Controller("/manag/holiday/viewUI")
public class HolidayViewUIAction extends DispatchAction {
	@Resource
	HolidayService holidayService;

	public ActionForward viewUI(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		int h_id=Integer.valueOf(request.getParameter("h_id"));
		Holiday holiday =holidayService.find(h_id);
		request.setAttribute("holiday",holiday );
		System.out.print(h_id);
		return mapping.findForward("view");
	}
   
	
}
