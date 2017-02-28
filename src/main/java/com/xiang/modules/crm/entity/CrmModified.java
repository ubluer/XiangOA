/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.xiang.modules.crm.entity;

import com.thinkgem.jeesite.modules.sys.entity.User;
import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 修改记录管理Entity
 * @author Xiang
 * @version 2017-02-28
 */
public class CrmModified extends DataEntity<CrmModified> {
	
	private static final long serialVersionUID = 1L;
	private CrmCustomer crmCustomer;		// 客户id
	private User sysUser;		// 修改人id
	private String modifiedTable;		// 修改表名
	private String modifiedField;		// 修改字段
	private String beforeModified;		// 修改前内容
	private String afterModified;		// 修改后内容
	private String modifiedClass;		// 修改实体
	
	public CrmModified() {
		super();
	}

	public CrmModified(String id){
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
	
	@Length(min=0, max=64, message="修改表名长度必须介于 0 和 64 之间")
	public String getModifiedTable() {
		return modifiedTable;
	}

	public void setModifiedTable(String modifiedTable) {
		this.modifiedTable = modifiedTable;
	}
	
	@Length(min=0, max=64, message="修改字段长度必须介于 0 和 64 之间")
	public String getModifiedField() {
		return modifiedField;
	}

	public void setModifiedField(String modifiedField) {
		this.modifiedField = modifiedField;
	}
	
	@Length(min=0, max=1000, message="修改前内容长度必须介于 0 和 1000 之间")
	public String getBeforeModified() {
		return beforeModified;
	}

	public void setBeforeModified(String beforeModified) {
		this.beforeModified = beforeModified;
	}
	
	@Length(min=0, max=1000, message="修改后内容长度必须介于 0 和 1000 之间")
	public String getAfterModified() {
		return afterModified;
	}

	public void setAfterModified(String afterModified) {
		this.afterModified = afterModified;
	}
	
	@Length(min=0, max=64, message="修改实体长度必须介于 0 和 64 之间")
	public String getModifiedClass() {
		return modifiedClass;
	}

	public void setModifiedClass(String modifiedClass) {
		this.modifiedClass = modifiedClass;
	}
	
}