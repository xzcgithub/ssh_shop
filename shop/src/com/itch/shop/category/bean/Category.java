package com.itch.shop.category.bean;

import java.util.HashSet;
import java.util.Set;

import com.itch.shop.categorysecond.bean.CategorySecond;

public class Category {
	/**
	 *   `cid` int(11) NOT NULL AUTO_INCREMENT,
  		`cname` varchar(255) DEFAULT NULL,
  		PRIMARY KEY (`cid`)
		) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8

	 */
	private Integer cid;
	private String cname;
	//存放二级分类的一个集合
	private Set<CategorySecond> categorySeconds = new HashSet<CategorySecond>();
	
	
	public Set<CategorySecond> getCategorySeconds() {
		return categorySeconds;
	}
	public void setCategorySeconds(Set<CategorySecond> categorySeconds) {
		this.categorySeconds = categorySeconds;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	@Override
	public String toString() {
		return "Category [cid=" + cid + ", cname=" + cname + "]";
	}
	
}
