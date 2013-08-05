package com.ginwavelz.sms.web.formbean.user;

import org.apache.struts.action.ActionForm;
import org.apache.struts.chain.commands.servlet.ValidateActionForm;

/**
 * �û��?
 * @author robin
 *
 */
public class UserRegForm extends ActionForm {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5898927648579780400L;
	/*�û���*/
	private String username;
	/*����*/
	private String password;
	/*�ʼ�*/
	private String email;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	

}
