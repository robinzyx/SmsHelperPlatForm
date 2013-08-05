package com.ginwavelz.sms.bean.holiday;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="Mms")
public class Mms implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8109577531356139531L;
	private Integer mms_id;
	private String mms_cont;
	private String mms_pic;
	private Holiday holiday;
		
	@Id
	@GeneratedValue
	public Integer getmms_id() {
		return mms_id;
	}
	public void setmms_id(Integer mms_id) {
		this.mms_id = mms_id;
	}
	public String getmms_cont() {
		return mms_cont;
	}
	public void setmms_cont(String mms_cont) {
		this.mms_cont = mms_cont;
	}
@ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "h_id")
	public Holiday getHoliday() {
		return holiday;
	}
	public void setHoliday(Holiday holiday) {
		this.holiday = holiday;
	}
	public String getMms_pic() {
		return mms_pic;
	}
	public void setMms_pic(String mms_pic) {
		this.mms_pic = mms_pic;
	}
	
}
