package com.itch.user.service;

import org.springframework.transaction.annotation.Transactional;

import com.itch.user.bean.User;
import com.itch.user.dao.UserDao;
@Transactional
public class UserServiceImpl implements UserService{
	private UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public User findByName(User user) {
		// TODO Auto-generated method stub
		return userDao.findByName(user);
	}

	@Override
	public void save(User user) {
		
		userDao.save(user);
		
	}

	@Override
	public User select(User user) {
		// 
		return userDao.select(user);
	}

}
