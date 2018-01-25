package com.itch.shop.category.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.itch.shop.category.bean.Category;
import com.itch.shop.category.dao.CategoryDao;

@Transactional
public class CategoryServiceImpl implements CategoryService {
	private CategoryDao categoryDao;

	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

	@Override
	public List<Category> findAll() {
		return categoryDao.findAll();
	}
	
}
