package com.hc.dao;

import java.util.List;

import com.hc.bean.Customer;
import com.hc.util.BaseDaoImpl;

public class CustomerDaoImpl extends BaseDaoImpl<Customer> implements CustomerDao{

	@Override
	public Customer findById(Customer customer) {
		List<Customer> list = (List<Customer>) this.getHibernateTemplate().find("from Customer where cust_id=?", customer.getCust_id());
		
		return list.get(0);
	}

	@Override
	public List<Customer> findAll() {
		List<Customer> list = (List<Customer>) this.getHibernateTemplate().find("from Customer");
		return list;
	}

	@Override
	public List<Object[]> findByLevel() {
		/**
		 * SELECT b.`dict_item_name`,COUNT(*) FROM cst_customer c INNER JOIN
		 * base_dict b ON c.cust_level = b.dict_id GROUP BY c.`cust_level`
		 */
		/*
		 * String hql = "select " + "c.level.dict_item_name,count(*) " +
		 * "from Customer c " + "inner join " + "c.level " + "group by " +
		 * "c.level";
		 */
		String hql = "select c.level.dict_item_name,count(*) from Customer c inner join c.level group by c.level";
		List<Object[]> list = (List<Object[]>) this.getHibernateTemplate().find(hql);
		return list;
	}

	@Override
	public List<Object[]> findBySource() {
		
		String hql = "select c.source.dict_item_name,count(*) from Customer c inner join c.source group by c.source";
		List<Object[]> list = (List<Object[]>) this.getHibernateTemplate().find(hql);
		return list;
	}

	
}
