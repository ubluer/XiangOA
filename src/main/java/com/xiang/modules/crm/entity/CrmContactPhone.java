/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.xiang.modules.crm.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 联系人管理Entity
 * @author Xiang
 * @version 2017-02-28
 */
public class CrmContactPhone extends DataEntity<CrmContactPhone> {
	
	private static final long serialVersionUID = 1L;
	private CrmContact crmContact;		// 联系人id 父类
	private String phone;		// 电话
	
	public CrmContactPhone() {
		super();
	}

	public CrmContactPhone(String id){
		super(id);
	}

	public CrmContactPhone(CrmContact crmContact){
		this.crmContact = crmContact;
	}

	public CrmContact getCrmContact() {
		return crmContact;
	}

	public void setCrmContact(CrmContact crmContact) {
		this.crmContact = crmContact;
	}
	
	@Length(min=0, max=64, message="电话长度必须介于 0 和 64 之间")
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}