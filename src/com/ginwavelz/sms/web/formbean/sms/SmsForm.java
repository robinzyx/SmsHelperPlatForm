package com.ginwavelz.sms.web.formbean.sms;

import org.apache.struts.action.ActionForm;

import com.ginwavelz.sms.bean.holiday.Holiday;
import com.ginwavelz.sms.web.formbean.BaseForm;
/**
 * ���ű?
 * @author robin
 *
 */
public class SmsForm extends BaseForm {
	/*对应节日Id*/
	private Integer h_id;
	private String h_name;
	private Integer sms_id;
	/*短信内容*/
	private String sms_cont;
	
	private Holiday holiday;
	
	
	public Integer getH_id() {
		return h_id;
	}

	public void setH_id(Integer h_id) {
		this.h_id = h_id;
	}

	public Integer getSms_id() {
		return sms_id;
	}

	public void setSms_id(Integer sms_id) {
		this.sms_id = sms_id;
	}

	public String getSms_cont() {
		return sms_cont;
	}

	public void setSms_cont(String sms_cont) {
		this.sms_cont = sms_cont;
	}

	public Holiday getHoliday() {
		return holiday;
	}

	public void setHoliday(Holiday holiday) {
		this.holiday = holiday;
	}

	public String getH_name() {
		return h_name;
	}

	public void setH_name(String h_name) {
		this.h_name = h_name;
	}

	

	

}
