package com.hc.action;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.hc.bean.Visit;
import com.hc.service.VisitService;
import com.hc.util.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;

public class VisitAction extends ActionSupport implements ModelDriven<Visit>{
	
	private VisitService visitService;
	
	public void setVisitService(VisitService visitService) {
		this.visitService = visitService;
	}
	private Visit visit = new Visit();
	@Override
	public Visit getModel() {
		
		return visit;
	}
	
	/**
	 * 分页查询拜访客户列表
	 * @return
	 */
	private Integer pageCode = 1;//当前页
	private Integer pageSize = 2;//每页显示的记录数
	
	public void setPageCode(Integer pageCode) {
		if(pageCode == null || pageCode < 1){
			pageCode = 1;
		}
		this.pageCode = pageCode;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
	// 开始时间
	private String beginDate;
	//结束时间
	private String endDate;
	
	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	/**
	 * 分页查询
	 * @return
	 */
	public String findByPage(){
		//创建离线条件查询的对象
		DetachedCriteria criteria = DetachedCriteria.forClass(Visit.class);
		//拼接条件查询
		try {
			//1.按名字查询
			String visit_interviewee = visit.getVisit_interviewee();
			System.out.println(visit_interviewee+ "  ..... ");
			if(visit_interviewee != null && !visit_interviewee.equals("")){
				criteria.add(Restrictions.like("visit_interviewee", "%"+visit_interviewee+"%"));
			}
			//2.开始时间
			if(beginDate != null){
				criteria.add(Restrictions.ge("visit_time", beginDate));
			}
			//3.结束时间
			if(endDate!=null){
				criteria.add(Restrictions.le("visit_time", endDate));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		PageBean<Visit> page = visitService.findByPage(criteria,pageCode,pageSize);
		//压栈
		ValueStack vs = ActionContext.getContext().getValueStack();
		vs.set("page", page);
		return "findByPage";
	}
	
	/**
	 * 跳转到添加拜访客户界面
	 */
	public String initAddUI(){
		
		return "initAddUI";
	}
	
	/**
	 * 保存添加的客户
	 */
	public String save(){
		
		visitService.save(visit);
		
		return "save";
	}
	
}
