package com.itch.shop.product.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.itch.shop.product.bean.Product;
import com.itch.util.BaseDaoImpl;

public class ProducDaoImpl extends BaseDaoImpl<Product> implements ProductDao{
	//首页上热门的商品
	@Override
	public List<Product> findHot() {
		//使用离线条件查询
		DetachedCriteria criteria = DetachedCriteria.forClass(Product.class);
		//查询热门的商品，条件是is_host = 1;
		criteria.add(Restrictions.eq("is_hot", 1));
		//倒序输出
		criteria.addOrder(Order.desc("pdate"));
		//执行查询
		List<Product> list = (List<Product>) this.getHibernateTemplate().findByCriteria(criteria, 0, 10);
		return list;
	}
	
	//查询首页上的最新商品 （跟查询最热门商品一样 也是分页像是10条记录）
	@Override
	public List<Product> findNew() {
		DetachedCriteria criteria = DetachedCriteria.forClass(Product.class);
		//按日期倒序查询
		criteria.addOrder(Order.desc("pdate"));
		List<Product> list = (List<Product>) this.getHibernateTemplate().findByCriteria(criteria, 0, 10);
		return list;
	}

	@Override
	public Product findByPid(Integer pid) {
		
		return  (Product) this.getHibernateTemplate().find("from Product where pid = ?", pid).get(0);
	}

}
