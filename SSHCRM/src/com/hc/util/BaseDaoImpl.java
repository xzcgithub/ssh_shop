package com.hc.util;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.hc.bean.Customer;

@SuppressWarnings("all")
public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T>{
	
	private Class clazz;
	
	public BaseDaoImpl(){
		//获取运行时的类，this代表子类
		Class c = this.getClass();
		//获取父类接口 Type 这是一个空接口，我们需要到空接口下面的一个子接口ParameterizeType
		Type type = c.getGenericSuperclass();
		
		if(type instanceof ParameterizedType){
			ParameterizedType pt = (ParameterizedType) type;
			Type[] types = pt.getActualTypeArguments();
			clazz = (Class) types[0];
		}
		
	
	}
	/**
	 * 保存
	 */
	@Override
	public void save(T t) {
		
		this.getHibernateTemplate().save(t);
	}
	/**
	 * 删除
	 */
	@Override
	public void delete(T t) {
		
		this.getHibernateTemplate().delete(t);
	}
	/**
	 * 修改
	 */
	@Override
	public void update(T t) {
		
		this.getHibernateTemplate().update(t);
	}
	/**
	 * 用id查询
	 */
	@Override
	public T findById(long id) {
		
		return (T) this.getHibernateTemplate().get(clazz, id);
	}
	/**
	 * 查询
	 */
	@Override
	public T selectOne(T t) {
		
		return null;
	}
	/**
	 *  查询所有
	 */
	public List<T> selectAll() {
		
		return (List<T>) this.getHibernateTemplate().find("from "+clazz.getSimpleName());
	}
	

	@Override
	public PageBean<T> findByPage(DetachedCriteria criteria, Integer pageCode, Integer pageSize) {
		// 需要给分页的javaBean属性赋值，一共要set设置四个属性
		PageBean<T> pageBean = new PageBean();
		pageBean.setPageCode(pageCode);
		pageBean.setPageSize(pageSize);
		//查询数据库的总记录数select count(*)
		criteria.setProjection(Projections.rowCount());
		List<Number> value = (List<Number>) this.getHibernateTemplate().findByCriteria(criteria);
		if(value!=null && value.size()>0){
			
			Number number = value.get(0);
			int intValue = number.intValue();
			pageBean.setTotalCount(intValue);
		}
		
		//select count(*)格式置空
		criteria.setProjection(null);
		
		//查询select *
		List<T> findByCriteria = (List<T>) this.getHibernateTemplate().findByCriteria(criteria, (pageCode-1)*pageSize, pageSize);
		
		pageBean.setBeanList(findByCriteria);
		return   pageBean;
	}
}
