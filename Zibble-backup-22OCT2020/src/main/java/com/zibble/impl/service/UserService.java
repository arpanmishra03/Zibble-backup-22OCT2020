package com.zibble.impl.service;

import com.zibble.entity.UserDetailsUD;

public interface UserService{

	public UserDetailsUD findByMobileNumberUD(String mobileNumberUD);

	public void save(String mobileNumberUD);

}
