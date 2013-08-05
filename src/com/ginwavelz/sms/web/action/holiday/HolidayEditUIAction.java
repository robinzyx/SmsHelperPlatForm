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

@Controller("/manag/holiday/editUI")
public class HolidayEditUIAction extends Action {
	@Resource
	HolidayService holidayService;
	
	
		
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HolidayForm holidayForm = new HolidayForm();
		int h_id=Integer.valueOf(request.getParameter("h_id"));
		Holiday holiday =holidayService.find(h_id);
//		holidayForm.setH_name(holiday.getH_name());
////		holidayForm.setIcon(holiday.getIcon());
//		holidayForm.setItemOneTitle(holiday.getItemOneTitle());
//		holidayForm.setItemOneCont(holiday.getItemOneCont());
//		
//		holidayForm.setItemTwoCont(holiday.getItemTwoCont());
//		holidayForm.setItemTwoTitle(holiday.getItemTwoCont());
//		
//		holidayForm.setItemThreeTitle(holiday.getItemThreeTitle());
//		holidayForm.setItemThreeCont(holiday.getItemThreeCont());
//		
//		holidayForm.setItemFourTitle(holiday.getItemFourTitle());
//		holidayForm.setItemFourCont(holiday.getItemFourCont());
		
		request.setAttribute("holiday", holiday);
		return mapping.findForward("showUI");
	}



	
   
	
}
