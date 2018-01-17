package com.hc.service;

import org.hibernate.criterion.DetachedCriteria;

import com.hc.bean.LinkMan;
import com.hc.util.PageBean;

public interface LinkManService {

	PageBean<LinkMan> findByPage(Integer pageCode, Integer pageSize, DetachedCriteria criteria);

	void save(LinkMan linkMan);

	LinkMan findById(Long id);

	void update(LinkMan linkMan);

	void delete(LinkMan linkMan);

	
}
