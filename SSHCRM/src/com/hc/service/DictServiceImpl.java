package com.hc.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.hc.bean.Base_Dict;
import com.hc.dao.DictDao;

@Transactional
public class DictServiceImpl implements DictService{
	
	private DictDao dictDao;

	public void setDictDao(DictDao dictDao) {
		this.dictDao = dictDao;
	}

	@Override
	public List<Base_Dict> findByCode(String dict_type_code) {
		
		return dictDao.findByCode(dict_type_code);
	}
	
	
}
