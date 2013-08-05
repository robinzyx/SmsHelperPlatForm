package com.ginwavelz.sms.service.user;

import com.ginwavelz.sms.bean.user.User;
import com.ginwavelz.sms.service.base.DAO;

public interface UserService extends DAO<User> {
	/**
	 * �ж��û��Ƿ����
	 * @param username �û���
	 * @return
	 */
	public boolean exsit(String username);
	/**
	 * У���û�������
	 * @param username
	 * @param password
	 * @return
	 */
	public boolean validate(String username,String password);

}
