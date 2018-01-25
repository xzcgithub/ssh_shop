package com.itch.shop.product.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.itch.shop.product.bean.Product;
import com.itch.util.PageBean;

public interface ProductService {

	List<Product> findHot();

	List<Product> findNew();

	Product findByPid(Integer pid);

	PageBean<Product> findByPage(DetachedCriteria criteria, Integer pageCode, Integer pageSize);

}
