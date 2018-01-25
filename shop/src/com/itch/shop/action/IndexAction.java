package com.itch.shop.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.itch.shop.category.bean.Category;
import com.itch.shop.category.service.CategoryService;
import com.itch.shop.product.bean.Product;
import com.itch.shop.product.service.ProductService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;
/**
 * 首页访问的Action
 * @author Administrator
 *
 */
public class IndexAction extends ActionSupport{
	//在首页注入一级分类service
	private CategoryService categoryService;
	//在首页注入商品的service
	private ProductService productService;
	
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	/**
	 * 执行首页访问的方法
	 */
	public String execute(){
		//一执行首页就查询所有一级分类
		List<Category> clist = categoryService.findAll();	
		//ValueStack vs = ActionContext.getContext().getValueStack();
		//vs.set("clist", clist);
		ServletActionContext.getRequest().getSession().setAttribute("clist", clist);
		
		//查询最热门商品：is_hot 0不是热门  1是热门
			//分页显示到首页
		List<Product> hlist = productService.findHot();
		ActionContext.getContext().getValueStack().set("hlist", hlist);
		
		//查询最新的商品
		List<Product> nlist = productService.findNew();
		ActionContext.getContext().getValueStack().set("nlist", nlist);
		return "index";
	}
}
