package com.itch.shop.category.dao;

import java.util.List;

import com.itch.shop.category.bean.Category;
import com.itch.util.BaseDao;

public interface CategoryDao extends BaseDao<Category> {

	List<Category> findAll();

}
