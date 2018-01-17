package com.hc.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import com.hc.bean.Customer;
import com.hc.dao.CustomerDao;
import com.hc.util.PageBean;

@SuppressWarnings("all")
@Transactional
public class CustomerServiceImpl implements CustomerService{
	private CustomerDao customerDao;

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	@Override
	public PageBean<Customer> findByPage(DetachedCriteria criteria, Integer pageCode, Integer pageSize) {
		
		return customerDao.findByPage(criteria, pageCode, pageSize);
	}

	@Override
	public void save(Customer customer) {
		customerDao.save(customer);
		
	}

	@Override
	public Customer findById(Customer customer) {
		
		return customerDao.findById(customer);
	}

	@Override
	public void update(Customer customer) {
		
		customerDao.update(customer);
		
	}

	@Override
	public void delete(Customer c) {
		customerDao.delete(c);
		
	}

	@Override
	public List<Customer> findAll() {
		
		return customerDao.findAll();
	}

	@Override
	public List<Object[]> findByLevel() {
		
		return customerDao.findByLevel();
	}

	@Override
	public List<Object[]> findBySource() {
		
		return customerDao.findBySource();
	}
	
	
}
