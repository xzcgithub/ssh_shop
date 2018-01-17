package com.hc.bean;

import java.util.HashSet;
import java.util.Set;

import com.alibaba.fastjson.annotation.JSONField;
import com.hc.bean.LinkMan;
import com.hc.bean.Visit;

public class Customer {
	private Long cust_id;
	private String cust_name;
	private Long cust_user_id;
	private Long cust_create_id;
	private String cust_phone;
	private String cust_mobile;
	private String filePath;
	
	private String cust_linkman;
	
	@JSONField(serialize=false)
	private Set<Visit> visit = new HashSet<Visit>();
	
	public Set<Visit> getVisit() {
		return visit;
	}
	public void setVisit(Set<Visit> visit) {
		this.visit = visit;
	}
	private Set<LinkMan> linkMan = new HashSet<LinkMan>();
	
	
	public Set<LinkMan> getLinkMan() {
		return linkMan;
	}
	public void setLinkMan(Set<LinkMan> linkMan) {
		this.linkMan = linkMan;
	}
	public String getCust_linkman() {
		return cust_linkman;
	}
	public void setCust_linkman(String cust_linkman) {
		this.cust_linkman = cust_linkman;
	}
	private Base_Dict source; 
	private Base_Dict industry;
	private Base_Dict level;

	public Long getCust_id() {
		return cust_id;
	}
	public void setCust_id(Long cust_id) {
		this.cust_id = cust_id;
	}
	public String getCust_name() {
		return cust_name;
	}
	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}
	public Long getCust_user_id() {
		return cust_user_id;
	}
	public void setCust_user_id(Long cust_user_id) {
		this.cust_user_id = cust_user_id;
	}
	public Long getCust_create_id() {
		return cust_create_id;
	}
	public void setCust_create_id(Long cust_create_id) {
		this.cust_create_id = cust_create_id;
	}
	public String getCust_phone() {
		return cust_phone;
	}
	public void setCust_phone(String cust_phone) {
		this.cust_phone = cust_phone;
	}
	public String getCust_mobile() {
		return cust_mobile;
	}
	public void setCust_mobile(String cust_mobile) {
		this.cust_mobile = cust_mobile;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public Base_Dict getSource() {
		return source;
	}
	public void setSource(Base_Dict source) {
		this.source = source;
	}
	public Base_Dict getIndustry() {
		return industry;
	}
	public void setIndustry(Base_Dict industry) {
		this.industry = industry;
	}
	public Base_Dict getLevel() {
		return level;
	}
	public void setLevel(Base_Dict level) {
		this.level = level;
	}

}
