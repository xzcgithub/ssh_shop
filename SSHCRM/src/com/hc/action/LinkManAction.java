package com.hc.action;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.hc.bean.LinkMan;
import com.hc.service.LinkManService;
import com.hc.util.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;

public class LinkManAction extends ActionSupport implements ModelDriven<LinkMan>{
	
	private LinkManService linkManService;
	
	public void setLinkManService(LinkManService linkManService) {
		this.linkManService = linkManService;
	}
	private LinkMan linkMan = new LinkMan();
	@Override
	public LinkMan getModel() {
		
		return linkMan;
	}
	
	/**
	 * 分页查询
	 */
	private Integer pageCode = 1;//当前页
	private Integer pageSize = 2;//每页显示的数量

	public void setPageCode(Integer pageCode) {
		if(pageCode == null || pageCode < 1){
			pageCode = 1;
		}
		this.pageCode = pageCode;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
	public String findByPage(){
		
		//创建离线条件查询对象
		DetachedCriteria criteria = DetachedCriteria.forClass(LinkMan.class);
			//拼接条件查询
		try {
			//1.名字条件查询
			String lkm_name = linkMan.getLkm_name();
			if(!lkm_name.equals("")){
				criteria.add(Restrictions.like("lkm_name", "%"+lkm_name+"%"));
			}
			//2.所属客户查询
			Long id = linkMan.getCustomer().getCust_id();
			if(id != null){
				criteria.add(Restrictions.eq("customer.cust_id", id));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		PageBean<LinkMan> page = linkManService.findByPage(pageCode,pageSize,criteria);
		
		ValueStack vs = ActionContext.getContext().getValueStack();
		vs.set("page", page);
		
		return "findByPage";
	}
	
	/**
	 * 跳转到添加联系人界面
	 */
	public String initAddUI(){
		
		return "initAddUI";
	}
	
	/**
	 * 保存添加的联系人
	 */
	public String save(){
		
		linkManService.save(linkMan);
		
		return "initAddUI";
	}
	
	/**
	 * 修改联系人
	 * 	修改之前先查询，
	 * 		用id查询返回一个对象
	 * 			模型驱动取值到页面
	 */
	public String initUpdate(){
		Long id = linkMan.getLkm_id();
		linkMan = linkManService.findById(id);
		return "initUpdate";
	}
	
	/**
	 * 修改
	 */
	public String update(){
		linkManService.update(linkMan);
		return "update";
	}
	
	/**
	 *删除：
	 *	先通过id查询处对象
	 *		在删除整个对象 
	 */
	public String delete(){
		
		Long id = linkMan.getLkm_id();
		linkMan = linkManService.findById(id);
		linkManService.delete(linkMan);
		
		return "delete";
	}
	
	
	
	
	
	
	
	
}
