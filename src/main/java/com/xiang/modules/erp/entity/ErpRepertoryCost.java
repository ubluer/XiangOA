/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.xiang.modules.erp.entity;

import com.thinkgem.jeesite.modules.sys.entity.User;
import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 项目库存消费Entity
 * @author xiang
 * @version 2017-06-05
 */
public class ErpRepertoryCost extends DataEntity<ErpRepertoryCost> {
	
	private static final long serialVersionUID = 1L;
	private ErpProject erpProject;		// 工程id
	private User sysUser;		// 记录人编号
	private ErpRepertory erpRepertory;		// 材料id
	private Double count;		// 库存数量变化
	private String unit;		// 单位
	private Double cost;		// 花费
	
	public ErpRepertoryCost() {
		super();
	}

	public ErpRepertoryCost(String id){
		super(id);
	}

	public ErpProject getErpProject() {
		return erpProject;
	}

	public void setErpProject(ErpProject erpProject) {
		this.erpProject = erpProject;
	}
	
	public User getSysUser() {
		return sysUser;
	}

	public void setSysUser(User sysUser) {
		this.sysUser = sysUser;
	}
	
	public ErpRepertory getErpRepertory() {
		return erpRepertory;
	}

	public void setErpRepertory(ErpRepertory erpRepertory) {
		this.erpRepertory = erpRepertory;
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