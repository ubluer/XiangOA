/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.xiang.modules.crm.entity;

import com.thinkgem.jeesite.modules.sys.entity.User;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 跟进人管理Entity
 * @author Xiang
 * @version 2017-02-28
 */
public class CrmCustomerFollower extends DataEntity<CrmCustomerFollower> {
	
	private static final long serialVersionUID = 1L;
	private CrmCustomer crmCustomer;		// 客户id
	private User sysUser;		// 跟进人编号
	
	public CrmCustomerFollower() {
		super();
	}

	public CrmCustomerFollower(String id){
		super(id);
	}

	public CrmCustomer getCrmCustomer() {
		return crmCustomer;
	}

	public void setCrmCustomer(CrmCustomer crmCustomer) {
		this.crmCustomer = crmCustomer;
	}
	
	public User getSysUser() {
		return sysUser;
	}

	public void setSysUser(User sysUser) {
		this.sysUser = sysUser;
	}
	
}