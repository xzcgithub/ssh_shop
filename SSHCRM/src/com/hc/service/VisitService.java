package com.hc.service;

import org.hibernate.criterion.DetachedCriteria;

import com.hc.bean.Visit;
import com.hc.util.PageBean;

public interface VisitService {

	PageBean<Visit> findByPage(DetachedCriteria criteria, Integer pageCode, Integer pageSize);

	void save(Visit visit);

}
