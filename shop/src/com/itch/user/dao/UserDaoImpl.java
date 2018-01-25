package com.itch.user.dao;

import java.util.List;


import com.itch.user.bean.User;
import com.itch.util.BaseDaoImpl;

public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{

	@Override
	public User findByName(User user) {
		List<User> list = (List<User>) this.getHibernateTemplate().find("from User where username = ?", user.getUsername());
		if(list.size() > 0){
			User user1 = list.get(0);
			return user1;
		}
		return null;
	}

	@Override
	public User select(User user) {
		List<User> list = (List<User>) this.getHibernateTemplate().find("from User where username=? and password = ?", user.getUsername(),user.getPassword());
		if(list != null && list.size() > 0){
			return list.get(0);
		}
		return null;
	}


}
