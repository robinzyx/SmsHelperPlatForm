package com.ginwavelz.sms.bean.holiday;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="Sms")
public class Sms implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7976168819890615194L;
	private Integer sms_id;
	private String sms_cont;
	private Holiday holiday;
		
	@Id
	@GeneratedValue
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
	@ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "h_id")
	public Holiday getHoliday() {
		return holiday;
	}
	public void setHoliday(Holiday holiday) {
		this.holiday = holiday;
	}
	
	
}
