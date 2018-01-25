package com.itch.shop.product.dao;

import java.util.List;

import com.itch.shop.product.bean.Product;
import com.itch.util.BaseDao;

public interface ProductDao extends BaseDao<Product>{

	List<Product> findHot();

	List<Product> findNew();

	Product findByPid(Integer pid);

}
