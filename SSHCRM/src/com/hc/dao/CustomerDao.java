package com.hc.dao;

import java.util.List;

import com.hc.bean.Customer;
import com.hc.util.BaseDao;

public interface CustomerDao extends BaseDao<Customer>{

	Customer findById(Customer customer);

	List<Customer> findAll();

	List<Object[]> findByLevel();

	List<Object[]> findBySource();

	
}
