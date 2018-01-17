package com.hc.json;

import com.alibaba.fastjson.annotation.JSONField;

public class Role {
	private String rname;
	@JSONField(serialize=false)
	private User user;
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Role [rname=" + rname + ", user=" + user + "]";
	}
	
}
