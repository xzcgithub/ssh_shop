package com.hc.util;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

public interface BaseDao<T> {
	
	public void save(T t);
	
	public void delete(T t);
	
	public void update(T t);
	
	public T findById(long id);
	
	public T selectOne(T t);
	
	public List<T> selectAll();
	
	public PageBean<T> findByPage(DetachedCriteria criteria,Integer pageCode,Integer pageSize);
}
