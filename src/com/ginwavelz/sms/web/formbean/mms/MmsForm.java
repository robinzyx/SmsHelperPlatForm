package com.ginwavelz.sms.web.formbean.mms;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

import com.ginwavelz.sms.bean.holiday.Holiday;
import com.ginwavelz.sms.web.formbean.BaseForm;
/**
 * ���ű?
 * @author robin
 *
 */
public class MmsForm extends BaseForm {
	/*节日id*/
	private int h_id;
	/*彩信id*/
	private int mms_id;
	/*彩信图片*/
	private FormFile mms_pic;
	/*彩信内容*/
	private String mms_cont;
	
	private Holiday holiday;
	
	
	
	public int getH_id() {
		return h_id;
	}
	public void setH_id(int h_id) {
		this.h_id = h_id;
	}
	
	public int getMms_id() {
		return mms_id;
	}
	public void setMms_id(int mms_id) {
		this.mms_id = mms_id;
	}

	public FormFile getMms_pic() {
		return mms_pic;
	}
	public void setMms_pic(FormFile mms_pic) {
		this.mms_pic = mms_pic;
	}
	public String getMms_cont() {
		return mms_cont;
	}
	public void setMms_cont(String mms_cont) {
		this.mms_cont = mms_cont;
	}
	public Holiday getHoliday() {
		return holiday;
	}
	public void setHoliday(Holiday holiday) {
		this.holiday = holiday;
	}
	
	

}
