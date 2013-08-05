package com.ginwavelz.sms.web.action.holiday;

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
import com.ginwavelz.sms.bean.holiday.Mms;
import com.ginwavelz.sms.bean.holiday.Sms;
import com.ginwavelz.sms.service.holiday.HolidayService;
import com.ginwavelz.sms.service.holiday.MmsService;
import com.ginwavelz.sms.service.holiday.SmsService;
import com.ginwavelz.sms.web.formbean.holiday.HolidayForm;
import com.ginwavelz.sms.web.formbean.mms.MmsForm;
import com.ginwavelz.sms.web.formbean.sms.SmsForm;

@Controller("/manag/holiday/holidayListUI")
public class HolidayListUIAction extends Action {
	@Resource(name="holidayServiceBean") 
	HolidayService holidayService;
    
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		/* 节日分页查询*/
		HolidayForm holidayForm =(HolidayForm) form;
		PageView<Holiday> holidayPageView= new PageView<Holiday>((int)holidayService.getCount(), holidayForm.getPage());
		LinkedHashMap<String, String> orderby= new LinkedHashMap<String, String>();
		orderby.put("create_time", "desc");
		holidayPageView.setQueryResult(holidayService.getScrollData(holidayPageView.getFirstResult(), holidayPageView.getMaxresult(), orderby));
		request.setAttribute("holidayPageView", holidayPageView);
		request.setAttribute("record", holidayService.getCount());
		System.out.print("节日总计路数为："+holidayPageView.getTotalrecord());
		return mapping.findForward("success");
	}

	
}
