package com.hc.action;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.hc.bean.Base_Dict;
import com.hc.service.DictService;
import com.hc.util.FastJsonUtil;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class DictAction extends ActionSupport implements ModelDriven<Base_Dict>{
	
	private Base_Dict  base_Dict = new Base_Dict();
	private DictService dictService;
	public void setDictService(DictService dictService) {
		this.dictService = dictService;
	}
	@Override
	public Base_Dict getModel() {
		
		return base_Dict;
	}
	public String findByCode(){
		//查询ajax  post请求提交过来的数据
		String dict_type_code = base_Dict.getDict_type_code();
		//然后用数据去查询
		List<Base_Dict> list = dictService.findByCode(dict_type_code);
		
		//把数据转换为json格式
		String jsonString = FastJsonUtil.toJSONString(list);
		//把数据写出去
		HttpServletResponse response = ServletActionContext.getResponse();
		FastJsonUtil.write_json(response, jsonString);
		
		return null;
	}
}
