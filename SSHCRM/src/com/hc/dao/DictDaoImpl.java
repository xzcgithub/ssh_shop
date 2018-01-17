package com.hc.dao;

import java.util.List;

import com.hc.bean.Base_Dict;
import com.hc.util.BaseDaoImpl;

public class DictDaoImpl extends BaseDaoImpl implements DictDao{

	@Override
	public List<Base_Dict> findByCode(String dict_type_code) {
		
		return (List<Base_Dict>) this.getHibernateTemplate().find("from Base_Dict where dict_type_code = ?", dict_type_code);
	}

}
