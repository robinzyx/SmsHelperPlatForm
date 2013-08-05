package com.ginwavelz.sms.web.action.mms;

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
import com.ginwavelz.sms.service.holiday.MmsService;
import com.ginwavelz.sms.service.holiday.SmsService;
import com.ginwavelz.sms.web.formbean.holiday.HolidayForm;

@Controller("/manag/mms/delete")
public class MmsDeleteAction extends Action {
	@Resource
	MmsService mmsService;

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		int mms_id=Integer.valueOf(request.getParameter("mms_id"));
		mmsService.delete(mms_id);
		request.setAttribute("title", "删除彩信");
		return mapping.findForward("success");
	}
	
}
