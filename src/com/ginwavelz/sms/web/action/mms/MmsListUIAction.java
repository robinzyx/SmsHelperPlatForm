package com.ginwavelz.sms.web.action.mms;

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

@Controller("/manag/mms/mmsListUI")
public class MmsListUIAction extends Action {
	@Resource
	MmsService mmsService;

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.print("mms coming");
		MmsForm mmsForm =(MmsForm) form;
		PageView<Mms> mmsPageView= new PageView<Mms>((int)mmsService.getCount(), mmsForm.getPage());
		mmsPageView.setQueryResult(mmsService.getScrollData(mmsPageView.getFirstResult(), mmsPageView.getMaxresult()));
		request.setAttribute("mmsPageView", mmsPageView);
		request.setAttribute("record", mmsService.getCount());
		System.out.print(mmsPageView.getTotalrecord());
		return mapping.findForward("success");
	}

	
}
