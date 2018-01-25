package com.itch.user.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.itch.user.bean.User;
import com.itch.user.service.UserService;
import com.itch.user.service.UserServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
/**
 * 跳转到注册界面的Action
 * 
 */
public class UserAction extends ActionSupport implements ModelDriven<User>{
	private HttpSession session;
	private String vcode;
	private String viCode;
	
	public void setViCode(String viCode) {
		this.viCode = viCode;
	}

	private User user = new User();
	private UserService userService ;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	

	@Override
	public User getModel() {
		
		return user;
	}
	/**
	 * 跳转到注册界面
	 * @return
	 */
	
	public String registPage(){
		
		return "registPage";
	}
	/**
	 * 异步ajax判断是否可以注册
	 * @return
	 * @throws Exception
	 */
	public String findByName() throws Exception{
		HttpServletResponse response = ServletActionContext.getResponse();
		User user = userService.findByName(this.user);
		PrintWriter out = response.getWriter();
		if(user == null){
			out.print(1);
		}
		return null;
	}
	
	/**
	 * 提交注册信息保存到后台
	 * @return
	 */
	public String regist(){
		userService.save(this.user);
		
		return "login";
	}
	/**
	 * 跳转到登陆界面
	 * @return
	 */
	public String loginPage(){
		
		return "loginPage";
	}
	
	/**
	 * 登陆
	 * @return
	 */
	public String login(){
		session = ServletActionContext.getRequest().getSession();
		vcode = (String) session.getAttribute("validateCode");
		if(viCode.equalsIgnoreCase(vcode)){
			
			User user = userService.select(this.user);
			
			if(user != null){
				session.setAttribute("existUser", user);
				return "loginSuccess";
			}else{
				session.setAttribute("admin", "账号或者密码错误");
				return "login";
			}
		}
		session.setAttribute("msg", "验证码错误");
		return "login";
		
	}
	
	/**
	 * 退出
	 * @return
	 */
	public String quit(){
		 session = ServletActionContext.getRequest().getSession();
		 session.removeAttribute("existUser");
		
		return "quit";
	}
}
