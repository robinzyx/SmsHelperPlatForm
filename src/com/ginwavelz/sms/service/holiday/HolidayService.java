package com.ginwavelz.sms.service.holiday;

import com.ginwavelz.sms.bean.holiday.Holiday;
import com.ginwavelz.sms.service.base.DAO;

public interface HolidayService extends DAO<Holiday>{

	/**
	 * ���ڽ���
	 * @param h_name
	 * @return
	 */
	public boolean exsit(String h_name);
}