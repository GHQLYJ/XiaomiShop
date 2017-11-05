package com.xiaomi.dao.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xiaomi.bean.User;
import com.xiaomi.dao.UserDAO;

public class UserDaoImpl extends HibernateDaoSupport implements UserDAO {

	@Override
	public void addUser(User user) {

		this.getHibernateTemplate().save(user);

	}

}
