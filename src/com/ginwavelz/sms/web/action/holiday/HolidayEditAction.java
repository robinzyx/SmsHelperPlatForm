package com.ginwavelz.sms.web.action.holiday;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.ginwavelz.sms.service.holiday.HolidayService;
import com.ginwavelz.sms.web.formbean.holiday.HolidayForm;

@Controller("/manag/holiday/edit")
public class HolidayEditAction extends DispatchAction{
	@Resource
	HolidayService holidayService;
	
	public ActionForward editUI(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HolidayForm holidayForm = (HolidayForm) form;
		int h_id=Integer.valueOf(request.getParameter("h_id"));
		Holiday holiday =holidayService.find(holidayForm.getH_id());
		holiday.setH_name(holidayForm.getH_name().trim());
		holiday.setMonth(holidayForm.getMonth().trim());
//	    holiday.setCreate_time(holidayForm.getCreate_time());
		String iconpath = null;
		String iconstoragepath = null;
		/*节日icon上传*/
		if(holidayForm.getIcon()!=null && holidayForm.getIcon().getFileSize()
				>0){
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd/HH");
			String iconpathdir="/images/holiday/icon"+dateFormat.format(new Date());//构造路径
			iconstoragepath=iconpathdir;
			iconpathdir=request.getSession().getServletContext().getRealPath(iconpathdir);
			File iconsavedir= new File(iconpathdir);
			if(!iconsavedir.exists()) iconsavedir.mkdirs();//创建存储路径
			System.out.print(iconsavedir.toString());
			String ext = holidayForm.getIcon().getFileName().substring(holidayForm.getIcon().getFileName().lastIndexOf('.'));
			String iconname=UUID.randomUUID().toString()+ext;
			FileOutputStream fileOutputStream= new FileOutputStream(new File(iconsavedir,iconname));
			fileOutputStream.write(holidayForm.getIcon().getFileData());
			fileOutputStream.close();
			iconpath= iconsavedir+iconname;
			iconstoragepath=iconstoragepath+"/"+iconname;
			System.out.print(iconpath);
			
		}
		holiday.setIcon(iconstoragepath.trim());
		holiday.setType(holidayForm.getType().trim());
		holiday.setIs_up(true);
		holiday.setItemOneTitle(holidayForm.getItemOneTitle().trim());
		holiday.setItemTwoTitle(holidayForm.getItemTwoTitle().trim());
		holiday.setItemThreeTitle(holidayForm.getItemThreeTitle().trim());
		holiday.setItemFourTitle(holidayForm.getItemFourTitle().trim());
		holiday.setItemOneCont(holidayForm.getItemOneCont().trim());
		holiday.setItemTwoCont(holidayForm.getItemTwoCont().trim());
		holiday.setItemThreeCont(holidayForm.getItemThreeCont().trim());
		holiday.setItemFourCont(holidayForm.getItemFourCont().trim());
		holidayService.update(holiday);
		
		System.out.print("meme"+holidayForm.getH_id());
		return mapping.findForward("success");
	}
}
