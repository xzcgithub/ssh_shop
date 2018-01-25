package com.itch.shop.category.dao;

import java.util.List;

import com.itch.shop.category.bean.Category;
import com.itch.util.BaseDaoImpl;

public class CategoryDaoImpl extends BaseDaoImpl<Category> implements CategoryDao{

	@Override
	public List<Category> findAll() {
		List<Category> list = (List<Category>) this.getHibernateTemplate().find("from Category");
		return list;
	}

}
