package com.hc.action;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.hc.bean.Base_Dict;
import com.hc.bean.Customer;
import com.hc.service.CustomerService;
import com.hc.util.FastJsonUtil;
import com.hc.util.PageBean;
import com.hc.util.UploadUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {

	private Customer customer = new Customer();

	private CustomerService customerService;

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	public Customer getModel() {

		return customer;
	}

	/**
	 * 分页查询：离线条件查询
	 * 
	 */
	// 当前页
	private Integer pageCode = 1;

	public void setPageCode(Integer pageCode) {
		if (pageCode == null || pageCode < 1) {
			pageCode = 1;
		}
		this.pageCode = pageCode;
	}

	// 每页显示的条数
	private Integer pageSize = 2;

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public String findByPage() {

		// 创建离线条件查询的对象
		DetachedCriteria criteria = DetachedCriteria.forClass(Customer.class);
		System.out.println(pageCode + " , " + pageSize);

		try {
			// 1.用名字查询
			String name = customer.getCust_name();
			if (name != null && !name.equals("")) {
				System.out.println(0);
				criteria.add(Restrictions.like("cust_name", "%" + name + "%"));

			}
			// 2.用客户级别查询
			Base_Dict level = customer.getLevel();
			System.out.println(level.getDict_id() + "......  ");
			if (!level.getDict_id().trim().equals("")) {
				System.out.println(1);
				criteria.add(Restrictions.eq("level.dict_id", level.getDict_id()));
			}
			// 3.用客户来源查询
			Base_Dict source = customer.getSource();
			System.out.println(source.getDict_id() + " //////");
			if (!source.getDict_id().equals("")) {
				System.out.println(2);
				criteria.add(Restrictions.eq("source.dict_id", source.getDict_id()));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		// 查
		PageBean<Customer> page = customerService.findByPage(criteria, pageCode, pageSize);
		// 压栈
		ValueStack vs = ActionContext.getContext().getValueStack();
		vs.set("page", page);

		return "findByPage";
	}
	
	/**
	 * /**
	 *  点击跳转至
	 		添加客户
	 */
	public String initAddUI(){
		return "initAddUI";
	}
	
	/**
	 *  添加客户
	 *  文件上传的三个属性：  upload
	 *  			  uploadFileName
	 *  			  uploadContentType		
	 */
	private File upload;
	private String uploadFileName; //需要设置成唯一
	private String uploadContentType;
	

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	//添加
	public String save() throws Exception{
		if(upload != null){
			//给对象的属性赋值(保存数据时，数据库里就会有文件名加后缀)
			String uuidName = UploadUtils.getUUIDName(uploadFileName);
			customer.setFilePath("D:/IOTest/"+uuidName);
			File file = new File("D:/IOTest/"+uuidName);
			FileUtils.copyFile(upload, file);
		}
		//保存对象到数据库
		customerService.save(customer);
		
		return "initAddUI";
	}
	/**
	 * 修改：
	 * 先用id查询
	 * 跳转到修改界面
	 * @return
	 */
	public String initUpdate(){
		
		customer = customerService.findById(customer);
		return "initUpdate";
	}
	
	/**
	 * 修改
	 * @throws Exception 
	 */
	public String update() throws Exception{
		
		if(upload != null){
			String filePath = customer.getFilePath();
			File file = new File(filePath);
			
			if(file.exists()){
				file.delete();
			}
			String uuidName = UploadUtils.getUUIDName(uploadFileName);
			//给对象的属性赋值（保存数据时，数据库里就会有文件名加后缀）
			customer.setFilePath("D:/IOTest/"+uuidName);
			File file2 = new File("D:/IOTest/"+uuidName);
			FileUtils.copyFile(upload, file2);
		}
		
		customerService.update(customer);
		//修改之后重新查询
		return "update";
	}
	
	
	/**
	 * 删除:先用id查询出来返回一个对象
	 * 		在删除对象
	 */
	public String delete(){
		Customer c = customerService.findById(customer);
		
		//删除联系人对应的文件
		String filePath = c.getFilePath();
		if(!filePath.trim().isEmpty()){
			File file = new File(filePath);
			if(file.exists()){
				file.delete();
			}
			
		}
		customerService.delete(c);
		return "delete";
	}
	
	/**
	 * 查询所有
	 */
	public String findAll(){
		
		List<Customer> list = customerService.findAll();
		String jsonString = FastJsonUtil.toJSONString(list);
		
		//把数据写出去
		HttpServletResponse response = ServletActionContext.getResponse();
		FastJsonUtil.write_json(response, jsonString);
		return null;
	}
	
	
	/**
	 * 客户级别统计（连表查询）
	 */
	public String findByLevel(){
		
		List<Object[]> list=   customerService.findByLevel();
		
		ValueStack vs = ActionContext.getContext().getValueStack();
		vs.set("list", list);
		return "findByLevel";
	}
	
	/**
	 * 客户来源统计（连表查询）
	 */
	
	public String findBySource(){
		
        List<Object[]> list = customerService.findBySource();
		for (Object[] objects : list) {
			System.out.println(Arrays.toString(objects));
		}
		
		ValueStack vs = ActionContext.getContext().getValueStack();
		vs.set("list", list);
		return "findBySource";
	}
	
}
