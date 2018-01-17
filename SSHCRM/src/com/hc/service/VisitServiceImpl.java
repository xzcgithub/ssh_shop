package com.hc.service;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import com.hc.bean.Visit;
import com.hc.dao.VisitDao;
import com.hc.util.PageBean;

@Transactional
public class VisitServiceImpl implements VisitService{
	private VisitDao visitDao;

	public void setVisitDao(VisitDao visitDao) {
		this.visitDao = visitDao;
	}

	@Override
	public PageBean<Visit> findByPage(DetachedCriteria criteria, Integer pageCode, Integer pageSize) {
		
		return visitDao.findByPage(criteria, pageCode, pageSize);
	}

	@Override
	public void save(Visit visit) {
		
		visitDao.save(visit);
	}
	
}
