package com.zibble.impl.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zibble.dao.UserDao;
import com.zibble.entity.UserDetailsUD;


@Service
public class UserServiceImpl implements UserService {

	// need to inject user dao
	@Autowired
	private UserDao userDao;

	@Override
	@Transactional
	public UserDetailsUD findByMobileNumberUD(String mobileNumberUD) {
		// check the database if the user already exists
		return userDao.findByMobileNumberUD(mobileNumberUD);
	}


	@Override
	@Transactional
	public void save(String mobileNumberUD) {
		UserDetailsUD user = new UserDetailsUD();
		 // assign user details to the user object
		user.setMobileNumberUD(mobileNumberUD);
		
		 // save user in the database
		userDao.save(user);
	}

	}
