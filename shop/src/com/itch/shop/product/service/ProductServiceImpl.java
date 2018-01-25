package com.itch.shop.product.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import com.itch.shop.product.bean.Product;
import com.itch.shop.product.dao.ProductDao;
import com.itch.util.PageBean;

@Transactional
public class ProductServiceImpl implements ProductService{
	private ProductDao productDao;

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	@Override
	public List<Product> findHot() {
		// TODO Auto-generated method stub
		return productDao.findHot();
	}

	@Override
	public List<Product> findNew() {
		// TODO Auto-generated method stub
		return productDao.findNew();
	}

	@Override
	public Product findByPid(Integer pid) {
		// TODO Auto-generated method stub
		return productDao.findByPid(pid);
	}

	@Override
	public PageBean<Product> findByPage(DetachedCriteria criteria, Integer pageCode, Integer pageSize) {
		// TODO Auto-generated method stub
		return productDao.findByPage( criteria,  pageCode,  pageSize);
	}
	
}
