package com.hc.service;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import com.hc.bean.LinkMan;
import com.hc.dao.LinkManDao;
import com.hc.util.PageBean;

@Transactional
public class LinkManServiceImpl implements LinkManService{
	private LinkManDao linkManDao;

	public void setLinkManDao(LinkManDao linkManDao) {
		this.linkManDao = linkManDao;
	}

	@Override
	public PageBean<LinkMan> findByPage(Integer pageCode, Integer pageSize, DetachedCriteria criteria) {
		
		return linkManDao.findByPage(criteria, pageCode, pageSize);
	}

	@Override
	public void save(LinkMan linkMan) {
		
		linkManDao.save(linkMan);
	}

	@Override
	public LinkMan findById(Long id) {
		
		return linkManDao.findById(id);
	}

	@Override
	public void update(LinkMan linkMan) {
		linkManDao.update(linkMan);
		
	}

	@Override
	public void delete(LinkMan linkMan) {
		linkManDao.delete(linkMan);
		
	}

	
	
}
