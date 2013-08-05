package com.ginwavelz.sms.service.user.impl;

import java.io.Serializable;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ginwavelz.sms.bean.user.User;
import com.ginwavelz.sms.service.base.impl.DaoSupport;
import com.ginwavelz.sms.service.user.UserService;
import com.ginwavelz.sms.util.MD5;

@Service
@Transactional
public class UserServiceBean extends DaoSupport<User> implements UserService {
	public boolean exsit(String username) {
		long count = (Long) em
				.createQuery("select count (o) from User o where o.username=?1")
				.setParameter(1, username).getSingleResult();
		return count > 0;
	}

	public boolean validate(String username, String password) {
		long count = (Long) em
				.createQuery(
						"select count (o) from User o where o.username=?1 and o.password=?2")
				.setParameter(1, username)
				.setParameter(2, MD5.MD5Encode(password)).getSingleResult();
		return count > 0;
	}

	@Override
	public void save(User entity) {
		entity.setPassword(MD5.MD5Encode(entity.getPassword()));
		super.save(entity);
	}

	@Override
	public void delete(Serializable entityid) {
		// TODO Auto-generated method stub
		
	}

}
