package com.ginwavelz.sms.service.holiday.impl;

import java.io.Serializable;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ginwavelz.sms.bean.holiday.Holiday;
import com.ginwavelz.sms.service.base.impl.DaoSupport;
import com.ginwavelz.sms.service.holiday.HolidayService;

@Service
@Transactional
public class HolidayServiceBean extends DaoSupport<Holiday> implements HolidayService{
	
	public boolean exsit(String h_name){
		long count=(Long) em.createQuery("select count (o) from Holiday o where o.h_name=?1")
				.setParameter(1, h_name).getSingleResult();
		return count>0;
	}

	

}
