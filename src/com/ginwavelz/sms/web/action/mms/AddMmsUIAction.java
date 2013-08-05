package com.ginwavelz.sms.web.action.mms;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.springframework.stereotype.Controller;

import com.ginwavelz.sms.bean.holiday.Holiday;
import com.ginwavelz.sms.bean.holiday.Mms;
import com.ginwavelz.sms.service.holiday.HolidayService;
import com.ginwavelz.sms.web.formbean.mms.MmsForm;

@Controller("/manag/add/mmsUI")
public class AddMmsUIAction extends DispatchAction {

	@Resource
	HolidayService holidayService;

	public ActionForward addMmsUI(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return mapping.findForward("addMmsUI");
	}

	public ActionForward addmms(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		int h_id = Integer.valueOf(request.getParameter("h_id"));
		System.out.print(h_id);
		Holiday holiday = holidayService.find(h_id);
		List<Mms> mmslist = new ArrayList<Mms>();
		Mms mms = new Mms();
		MmsForm mmsForm = (MmsForm) form;
		/** 上传彩信图片 **/
		String iconpath = null;
		String iconstoragepath = null;
		/* 节日icon上传 */
		if (mmsForm.getMms_pic()!= null
				&& mmsForm.getMms_pic().getFileSize() > 0) {

			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd/HH");
			String iconpathdir = "/images/mms/pic/"
					+ dateFormat.format(new Date());// 构造路径
			iconstoragepath = iconpathdir;
			iconpathdir = request.getSession().getServletContext()
					.getRealPath(iconpathdir);
			File iconsavedir = new File(iconpathdir);
			if (!iconsavedir.exists())
				iconsavedir.mkdirs();// 创建存储路径
			System.out.print(iconsavedir.toString());
			String ext = mmsForm
					.getMms_pic()
					.getFileName()
					.substring(
							mmsForm.getMms_pic().getFileName().lastIndexOf('.'));
			String iconname = UUID.randomUUID().toString() + ext;
			FileOutputStream fileOutputStream = new FileOutputStream(new File(
					iconsavedir, iconname));
			fileOutputStream.write(mmsForm.getMms_pic().getFileData());
			fileOutputStream.close();
			iconpath = iconsavedir + iconname;
			iconstoragepath = iconstoragepath+"/" + iconname;
			System.out.print(iconpath);

		}
		mms.setMms_pic(iconstoragepath);
		mms.setmms_cont(mmsForm.getMms_cont().trim());
		mms.setHoliday(holiday);
		mmslist.add(mms);
		holiday.setMmslist(mmslist);
		holidayService.update(holiday);
		return mapping.findForward("addSuccess");
	}
}
