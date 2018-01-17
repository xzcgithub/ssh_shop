package com.hc.dao;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.hc.bean.Sys_User;

@SuppressWarnings("all")
public class Sys_UserDaoImpl extends HibernateDaoSupport implements Sys_UserDao{

	@Override
	public Sys_User select(Sys_User sys_User) {
		List<Sys_User> list = (List<Sys_User>) this.getHibernateTemplate().find("from Sys_User where user_code=? and user_password=?",sys_User.getUser_code(),sys_User.getUser_password());
		if(list.size() > 0){
			Sys_User user = list.get(0);
			return user;
		}
		return null;
	}


	@Override
	public Sys_User findByCode(Sys_User sys_User) {
		List<Sys_User> list = (List<Sys_User>) this.getHibernateTemplate().find("from Sys_User where user_code=?", sys_User.getUser_code());
		if(list.size() > 0){
			Sys_User user = list.get(0);
			return user;
		}
		return null;
	}


	@Override
	public void sava(Sys_User sys_User) {
		
		this.getHibernateTemplate().save(sys_User);
		
	}


	@Override
	public void update(Sys_User sys_User) {
		
		this.getHibernateTemplate().update(sys_User);
	}


	@Override
	public List<Sys_User> findAll() {
		List<Sys_User> list = (List<Sys_User>) this.getHibernateTemplate().find("from Sys_User");
		return list;
	}

}
