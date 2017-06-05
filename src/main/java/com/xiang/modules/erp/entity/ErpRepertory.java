/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.xiang.modules.erp.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 项目库存管理Entity
 * @author xiang
 * @version 2017-06-05
 */
public class ErpRepertory extends DataEntity<ErpRepertory> {
	
	private static final long serialVersionUID = 1L;
	private String erpProject;		// 工程id
	private String sysUser;		// 记录人编号
	private String name;		// 名称
	private String type;		// 类型
	private String edition;		// 规格
	private String detail;		// 规格描述
	private Double count;		// 库存数量
	private String unit;		// 单位
	private Double cost;		// 花费
	
	public ErpRepertory() {
		super();
	}

	public ErpRepertory(String id){
		super(id);
	}

	@Length(min=0, max=64, message="工程id长度必须介于 0 和 64 之间")
	public String getErpProject() {
		return erpProject;
	}

	public void setErpProject(String erpProject) {
		this.erpProject = erpProject;
	}
	
	@Length(min=0, max=64, message="记录人编号长度必须介于 0 和 64 之间")
	public String getSysUser() {
		return sysUser;
	}

	public void setSysUser(String sysUser) {
		this.sysUser = sysUser;
	}
	
	@Length(min=0, max=200, message="名称长度必须介于 0 和 200 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=0, max=20, message="类型长度必须介于 0 和 20 之间")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	@Length(min=0, max=64, message="规格长度必须介于 0 和 64 之间")
	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}
	
	@Length(min=0, max=200, message="规格描述长度必须介于 0 和 200 之间")
	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}
	
	public Double getCount() {
		return count;
	}

	public void setCount(Double count) {
		this.count = count;
	}
	
	@Length(min=0, max=20, message="单位长度必须介于 0 和 20 之间")
	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}
	
}