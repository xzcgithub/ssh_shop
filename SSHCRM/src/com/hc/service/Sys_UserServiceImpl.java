package com.hc.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.hc.bean.Sys_User;
import com.hc.dao.Sys_UserDao;
import com.hc.util.Base64;
import com.hc.util.State;

@Transactional
public class Sys_UserServiceImpl implements Sys_UserService{
	
	private Sys_UserDao sys_UserDao;

	public void setSys_UserDao(Sys_UserDao sys_UserDao) {
		this.sys_UserDao = sys_UserDao;
	}

	@Override
	public Sys_User select(Sys_User sys_User) {
		//登陆的时候需要把密码也加密 使其跟注册时对应起来
		String user_password = sys_User.getUser_password();
		
		try {
			String encode = Base64.encode(user_password);
			
			sys_User.setUser_password(encode);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		
		return sys_UserDao.select(sys_User);
	}



	@Override
	public Sys_User findByCode(Sys_User sys_User) {
		
		return sys_UserDao.findByCode(sys_User);
	}

	@Override
	public void sava(Sys_User sys_User) {
		//添加状态
		sys_User.setUser_state(State.gerState());
		//密码加密：base64加密
		//先查询密码 给给注册时所写的密码加上密 然后在save到数据库
		String user_password = sys_User.getUser_password();
		try {
			String encode = Base64.encode(user_password);
			//把加密后的数据重新复制给对象
			sys_User.setUser_password(encode);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		sys_UserDao.sava(sys_User);
		
	}

	@Override
	public void update(Sys_User sys_User) {
		String user_password = sys_User.getUser_password();
		
		try {
			String encode = Base64.encode(user_password);
			
			sys_User.setUser_password(encode);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		sys_UserDao.update(sys_User);
	}

	@Override
	public List<Sys_User> findAll() {
		
		return sys_UserDao.findAll();
	}

	

	
	
	
}
