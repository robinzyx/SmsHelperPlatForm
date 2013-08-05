package com.ginwavelz.sms.web.action.holiday;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.springframework.stereotype.Controller;

import com.ginwavelz.sms.bean.PageView;
import com.ginwavelz.sms.bean.holiday.Holiday;
import com.ginwavelz.sms.service.holiday.HolidayService;
import com.ginwavelz.sms.web.formbean.holiday.HolidayForm;

@Controller("/manag/holiday/addholiday")
public class AddHolidayAction extends DispatchAction {

	@Resource(name="holidayServiceBean") 
	HolidayService holidayService;

	public ActionForward addHolidayUI(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		return mapping.findForward("addHolidayUI");
	}
	
	public ActionForward addHoliday(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HolidayForm holidayForm = (HolidayForm)form;
		if(holidayService.exsit(holidayForm.getH_name().trim())){
			request.setAttribute("error", "该节日已存在！");
			return mapping.findForward("addHolidayUI");
		}else{
			Holiday holiday = new Holiday();
			holiday.setH_name(holidayForm.getH_name().trim());
			holiday.setMonth(holidayForm.getMonth().trim());
//		    holiday.setCreate_time(holidayForm.getCreate_time());
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
			holiday.setIs_up(false);
			holiday.setItemOneTitle(holidayForm.getItemOneTitle().trim());
			holiday.setItemTwoTitle(holidayForm.getItemTwoTitle().trim());
			holiday.setItemThreeTitle(holidayForm.getItemThreeTitle().trim());
			holiday.setItemFourTitle(holidayForm.getItemFourTitle().trim());
			holiday.setItemOneCont(holidayForm.getItemOneCont().trim());
			holiday.setItemTwoCont(holidayForm.getItemTwoCont().trim());
			holiday.setItemThreeCont(holidayForm.getItemThreeCont().trim());
			holiday.setItemFourCont(holidayForm.getItemFourCont().trim());
			holidayService.save(holiday);
			/*分页查询*/
			PageView<Holiday> holidayPageView= new PageView<Holiday>(12, holidayForm.getPage());
			LinkedHashMap<String, String> orderby= new LinkedHashMap<String, String>();
			orderby.put("create_time", "desc");
			holidayPageView.setQueryResult(holidayService.getScrollData(holidayPageView.getFirstResult(), holidayPageView.getMaxresult(), orderby));
			request.setAttribute("holidayPageView", holidayPageView);
			request.setAttribute("message", "添加完成");
			return mapping.findForward("success");
		}
		
	}
	
	
	
}
