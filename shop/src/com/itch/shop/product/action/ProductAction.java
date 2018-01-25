package com.itch.shop.product.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;


import com.itch.shop.category.bean.Category;
import com.itch.shop.category.service.CategoryService;
import com.itch.shop.product.bean.Product;
import com.itch.shop.product.service.ProductService;
import com.itch.util.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;

public class ProductAction extends ActionSupport implements ModelDriven<Product>{
	private  Product product = new Product();
	//注入商品的service
	private ProductService productService;
	//接受分类的cid
	private Integer cid;
	//注入一级分类的service
	private CategoryService categoryService;
	//接受当前页数
	private Integer pageCode;
	//设置每页显示的记录数
	private Integer pageSize = 8;
	//接受二级分类的id
	private Integer csid;
	
	
	
	public Integer getCsid() {
		return csid;
	}
	public void setCsid(Integer csid) {
		this.csid = csid;
	}
	public void setPageCode(Integer pageCode) {
		if (pageCode == null || pageCode < 1 ) {
			pageCode = 1;
		}
		this.pageCode = pageCode;
	}
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	
	public Integer getCid() {
		return cid;
	}
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	//用于接受数据的模型驱动
	@Override
	public Product getModel() {
		
		return product;
	}
	
	
	
	//根据商品的pid查询商品的详情
	public String findByPid(){
		product = productService.findByPid(product.getPid());
		return "findByPid";
	}
	
	//根据分类的cid 来查询商品
	public String findByCid(){
//		System.out.println(cid);
		
		System.out.println(cid);
		
//		List<Category> list = categoryService.findAll(); //之前已经查过并且存在session里了 ，所以这里可查可不查 ，不查就冲session里面拿
//		for (Category category : list) {
//			System.out.println(category); 
//		}
//		ValueStack valueStack = ActionContext.getContext().getValueStack();
//		
//		valueStack.set("list", list);
		// 创建离线条件查询的对象
		DetachedCriteria criteria = DetachedCriteria.forClass(Product.class);
		PageBean<Product> page = productService.findByPage(criteria,pageCode,pageSize);
		System.out.println(page);
		System.out.println(0000);
		ActionContext.getContext().getValueStack().set("page", page);
		
		return "findByCid";
	}
	
	//根据二级分类的id去查询商品
	public String findByCsid(){
		
		// 创建离线条件查询的对象
		DetachedCriteria criteria = DetachedCriteria.forClass(Product.class);
		PageBean<Product> page = productService.findByPage(criteria,pageCode,pageSize);
		System.out.println(page);
		System.out.println(11111);
		ActionContext.getContext().getValueStack().set("page", page);
			System.out.println(csid);	
		return "findByCsid";
	}
	
}
