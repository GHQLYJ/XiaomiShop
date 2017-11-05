package com.xiaomi.service.impl;

import com.xiaomi.bean.User;
import com.xiaomi.dao.UserDAO;
import com.xiaomi.service.UserService;
import com.xiaomi.util.GetPhoneNumberUtil;

public class UserServiceImpl implements UserService {

	private UserDAO userDao;

	public UserDAO getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}

	@Override
	public void addUser(User user) {

		this.userDao.addUser(user);

	}

}
