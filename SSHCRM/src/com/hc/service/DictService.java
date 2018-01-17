package com.hc.service;

import java.util.List;

import com.hc.bean.Base_Dict;

public interface DictService {

	List<Base_Dict> findByCode(String dict_type_code);

}
