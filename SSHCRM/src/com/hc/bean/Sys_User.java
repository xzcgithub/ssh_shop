package com.hc.bean;

import java.util.HashSet;
import java.util.Set;

import com.alibaba.fastjson.annotation.JSONField;

public class Sys_User {
	/**
	 	* user_id        bigint(32)  
		user_code      varchar(32) 
		user_name      varchar(64) 
		user_password  varchar(32) 
		user_state     char(1)     
	 */
	private long user_id;
	private String user_code;
	private String user_name;
	private String user_password;
	private String user_state;
	
	@JSONField(serialize=false)
	private Set<Visit> visit = new HashSet<Visit>();
	
	
	public Set<Visit> getVisit() {
		return visit;
	}
	public void setVisit(Set<Visit> visit) {
		this.visit = visit;
	}
	public long getUser_id() {
		return user_id;
	}
	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}
	public String getUser_code() {
		return user_code;
	}
	public void setUser_code(String user_code) {
		this.user_code = user_code;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public String getUser_state() {
		return user_state;
	}
	public void setUser_state(String user_state) {
		this.user_state = user_state;
	}
	@Override
	public String toString() {
		return "Sys_User [user_id=" + user_id + ", user_code=" + user_code + ", user_name=" + user_name
				+ ", user_password=" + user_password + ", user_state=" + user_state + "]";
	}
	
	
}
