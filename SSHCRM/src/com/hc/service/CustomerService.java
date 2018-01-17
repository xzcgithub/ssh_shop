package com.hc.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.hc.bean.Customer;
import com.hc.util.PageBean;

public interface CustomerService  {

	PageBean<Customer> findByPage(DetachedCriteria criteria, Integer pageCode, Integer pageSize);

	void save(Customer customer);

	Customer findById(Customer customer);

	void update(Customer customer);

	void delete(Customer c);

	List<Customer> findAll();

	List<Object[]> findByLevel();

	List<Object[]> findBySource();

}
