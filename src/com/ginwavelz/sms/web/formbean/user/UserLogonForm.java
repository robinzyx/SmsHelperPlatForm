package com.ginwavelz.sms.web.formbean.user;

import org.apache.struts.action.ActionForm;
import org.apache.struts.chain.commands.servlet.ValidateActionForm;

/**
 * 用户登陆表单
 * @author robin
 *
 */
public class UserLogonForm extends ActionForm {
	/*用户名*/
	private String username;
	/*密码*/
	private String password;
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
	
	

}
