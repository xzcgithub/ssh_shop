package com.hc.service;

import java.util.List;

import com.hc.bean.Sys_User;

public interface Sys_UserService {

	Sys_User select(Sys_User sys_User);

	

	Sys_User findByCode(Sys_User sys_User);



	void sava(Sys_User sys_User);



	void update(Sys_User sys_User);



	List<Sys_User> findAll();

	

}
