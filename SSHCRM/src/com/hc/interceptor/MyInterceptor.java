package com.hc.interceptor;

import org.apache.struts2.ServletActionContext;

import com.hc.bean.Sys_User;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class MyInterceptor extends MethodFilterInterceptor{
	//拦截器
	@Override
	protected String doIntercept(ActionInvocation arg0) throws Exception {
		//判断用户是否登入
		Sys_User user = (Sys_User) ServletActionContext.getRequest().getSession().getAttribute("existUser");
		if(user==null){
			return "login";
		}
		return arg0.invoke();
	}
	
	
}
