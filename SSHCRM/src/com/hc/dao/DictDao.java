package com.hc.dao;

import java.util.List;

import com.hc.bean.Base_Dict;
import com.hc.util.BaseDao;

public interface DictDao extends BaseDao{

	List<Base_Dict> findByCode(String dict_type_code);

}
