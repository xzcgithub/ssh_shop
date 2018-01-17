package com.hc.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.hc.bean.Sys_User;
import com.hc.service.Sys_UserService;
import com.hc.util.FastJsonUtil;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("all")
public class Sys_UserAction extends ActionSupport implements ModelDriven<Sys_User>{
	private Sys_UserService sys_UserService;
	
	private String viCode;
	public void setViCode(String viCode) {
		this.viCode = viCode;
	}
	public void setSys_UserService(Sys_UserService sys_UserService) {
		this.sys_UserService = sys_UserService;
	}
	private Sys_User sys_User = new Sys_User();

	private String vcode;

	private HttpSession session;
	
	@Override
	public Sys_User getModel() {
		
		return sys_User;
	}
	/**
	 * 登陆
	 */
	public String login(){
		session = ServletActionContext.getRequest().getSession();
		vcode = (String) session.getAttribute("validateCode");
		if(viCode.equalsIgnoreCase(vcode)){
			
			Sys_User sys_User = sys_UserService.select(this.sys_User);
			
			if(sys_User != null){
				session.setAttribute("existUser", sys_User);
				return "index";
			}else{
				session.setAttribute("admin", "账号或者密码错误");
				return "login";
			}
		}
		session.setAttribute("msg", "验证码错误");
		return "login";
	}
	
	/**
	 * ajax 判断是否可以注册
	 * @throws Exception 
	 */
	public String checkCode() throws Exception{
		HttpServletResponse response = ServletActionContext.getResponse();
		Sys_User sys_User = sys_UserService.findByCode(this.sys_User);
		PrintWriter out = response.getWriter();
		if(sys_User == null){
			out.print(1);
		}
		return null;
	}
	
	/**
	 * 注册
	 * 	1.需要手动添加状态码 user_state
	 * 	2.需要把密码加密
	 */
	public String register(){
		sys_UserService.sava(this.sys_User);
		return "login";
	}
	
	/**
	 * 修改密码
	 */
	
	public String updatePassword(){
		
		return "updatePassword";
	}
	
	
	/**
	 * 修改提交
	 */
	public String password(){
		session = ServletActionContext.getRequest().getSession();
		//获取session里面登陆时存入的对象
		
		Sys_User user = (Sys_User) session.getAttribute("existUser");
		
		//修改密码的时候提交过来的只有一个密码属性，需要自己添加其他的值
		this.sys_User.setUser_id(user.getUser_id());
		this.sys_User.setUser_code(user.getUser_code());
		this.sys_User.setUser_name(user.getUser_name());
		this.sys_User.setUser_state(user.getUser_state());
		
		sys_UserService.update(this.sys_User);
		
		return "login";
	}
	
	
	
	
	/**
	 *退出
	 */
	
	public String exit(){
		
		session = ServletActionContext.getRequest().getSession();
		
		session.removeAttribute("existUser");
		return "login";
	}
	
	/**
	 * ajax查询所有
	 * user_findAll
	 */
	public String findAll(){
		
		List<Sys_User> list = sys_UserService.findAll();
		String jsonString = FastJsonUtil.toJSONString(list);
		//用json类把数据写出去
		HttpServletResponse response = ServletActionContext.getResponse();
		FastJsonUtil.write_json(response, jsonString);
		return null;
	}
	
	
}
