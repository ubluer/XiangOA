/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.xiang.modules.erp.entity;

import org.hibernate.validator.constraints.Length;
import com.thinkgem.jeesite.modules.sys.entity.User;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 项目日报管理Entity
 * @author xiang
 * @version 2017-06-05
 */
public class ErpDaily extends DataEntity<ErpDaily> {
	
	private static final long serialVersionUID = 1L;
	private String erpProject;		// 工程id
	private User sysUser;		// 记录人编号
	private String content;		// 日报
	private String weather;		// 天气
	private Double cost;		// 花费
	
	public ErpDaily() {
		super();
	}

	public ErpDaily(String id){
		super(id);
	}

	@Length(min=0, max=64, message="工程id长度必须介于 0 和 64 之间")
	public String getErpProject() {
		return erpProject;
	}

	public void setErpProject(String erpProject) {
		this.erpProject = erpProject;
	}
	
	public User getSysUser() {
		return sysUser;
	}

	public void setSysUser(User sysUser) {
		this.sysUser = sysUser;
	}
	
	@Length(min=0, max=500, message="日报长度必须介于 0 和 500 之间")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	@Length(min=0, max=50, message="天气长度必须介于 0 和 50 之间")
	public String getWeather() {
		return weather;
	}

	public void setWeather(String weather) {
		this.weather = weather;
	}
	
	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}
	
}