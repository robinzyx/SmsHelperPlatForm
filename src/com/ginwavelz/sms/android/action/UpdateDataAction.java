package com.ginwavelz.sms.android.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.springframework.stereotype.Controller;

import com.ginwavelz.sms.bean.holiday.Holiday;
import com.ginwavelz.sms.bean.holiday.Mms;
import com.ginwavelz.sms.bean.holiday.Sms;
import com.ginwavelz.sms.service.holiday.HolidayService;

@Controller("/android/updata")
public class UpdateDataAction extends DispatchAction {
	
	@Resource
	HolidayService holidayService;

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		try {
			response.setContentType("text/html;charset=utf-8");
			response.setCharacterEncoding("UTF-8");
			if (request.getParameter("parameter").equals("up")) {
				Holiday holiday ;
//				System.out.println("得到的参数为"+request.getParameter("item"));
				int id=Integer.parseInt(request.getParameter("item"));
				System.out.println("id="+id);
				holiday=holidayService.find(id);
				if(holiday!=null&&holiday.getIs_up()){
					System.out.println(holiday.getH_name());
					JSONObject object=new JSONObject();
					object.put("holiday", objectToJson(holiday,id));
					response.getWriter().write(object.toString());
					
				}else{
					response.getWriter().write("unneed");
				}
				
//				long count=holidayService.getCount();
//				JSONObject object=new JSONObject();
//				JSONArray jsonArrayHoliday=new JSONArray();
//				for(int i=1;i<=count;i++){
//					jsonArrayHoliday.add(objectToJson(holiday,i,count));
//				}
//				object.put("holidayArray",jsonArrayHoliday );
//				System.out.println("object"+object);
//				response.getWriter().write(object.toString());
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private JSONObject objectToJson(Holiday holiday ,int i){
		holiday = holidayService.find(i);
		JSONObject json = new JSONObject();
		json.put("h_id", holiday.getH_id());
		json.put("h_name", holiday.getH_name());
		json.put("itemFourTitle", holiday.getItemFourTitle());
		json.put("itemFourCont", holiday.getItemFourCont());
		json.put("itemThreeTitle", holiday.getItemThreeTitle());
		json.put("itemThreeCont", holiday.getItemThreeCont());
		json.put("itemTwoTitle", holiday.getItemTwoTitle());
		json.put("itemTwoCont", holiday.getItemTwoCont());
		json.put("itemOneTitle", holiday.getItemOneTitle());
		json.put("itemOneCont", holiday.getItemOneCont());
		json.put("is_up", holiday.getIs_up());
		JSONArray jsonArrayForSms = new JSONArray();
		JSONObject jsonObjectForSms = new JSONObject();
		for (Sms sms : holiday.getSmslist()) {
			jsonObjectForSms.put("sms_id", sms.getSms_id());
			jsonObjectForSms.put("sms_cont", sms.getSms_cont());
			jsonArrayForSms.add(jsonObjectForSms);
		}
		;
		json.put("sms", jsonArrayForSms.toString());

		JSONArray jsonArrayForMms = new JSONArray();
		JSONObject jsonObjectForMms = new JSONObject();
		for (Mms mms : holiday.getMmslist()) {
			jsonObjectForMms.put("mms_id", mms.getmms_id());
			jsonObjectForMms.put("mms_cont", mms.getmms_cont());
			jsonObjectForMms.put("mms_pic", mms.getMms_pic());
			jsonArrayForMms.add(jsonObjectForMms);
		}
		json.put("mms", jsonArrayForMms.toString());
		
		System.out.println(json + "////smsPageView="
				+ holiday.getSmslist().size() + "jsonObjectForSms//"
				+ jsonObjectForSms + "jsonArrayForSms"
				);
		
		return json;
	}

}
