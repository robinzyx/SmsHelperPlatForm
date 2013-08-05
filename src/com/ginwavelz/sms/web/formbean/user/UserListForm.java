package com.ginwavelz.sms.web.formbean.user;

import com.ginwavelz.sms.bean.user.ContactInfo;
import com.ginwavelz.sms.web.formbean.BaseForm;

/**
 * �û��б�?
 * @author Administrator
 *
 */
public class UserListForm extends BaseForm{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5853524862536111527L;
	private String username;
	private String gender;
	private String email;
	private String regTime;
	private ContactInfo contactInfo;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRegTime() {
		return regTime;
	}
	public void setRegTime(String regTime) {
		this.regTime = regTime;
	}
	public ContactInfo getContactInfo() {
		return contactInfo;
	}
	public void setContactInfo(ContactInfo contactInfo) {
		this.contactInfo = contactInfo;
	}
	

}
