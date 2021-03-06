/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.xiang.modules.crm.entity;

import com.thinkgem.jeesite.modules.sys.entity.User;
import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 跟进记录管理Entity
 * @author Xiang
 * @version 2017-02-28
 */
public class CrmCustomerFollow extends DataEntity<CrmCustomerFollow> {
	
	private static final long serialVersionUID = 1L;
	private CrmCustomer crmCustomer;		// 客户id
	private CrmChance crmChance;		// 机会id
	private CrmContract crmContract;		// 合同id
	private User sysUser;		// 发布人编号
	private String content;		// 发布内容
	private String pictures;		// 图片
	private String files;		// 附件
	
	public CrmCustomerFollow() {
		super();
	}

	public CrmCustomerFollow(String id){
		super(id);
	}

	public CrmCustomer getCrmCustomer() {
		return crmCustomer;
	}

	public void setCrmCustomer(CrmCustomer crmCustomer) {
		this.crmCustomer = crmCustomer;
	}

	public CrmChance getCrmChance() {
		return crmChance;
	}

	public void setCrmChance(CrmChance crmChance) {
		this.crmChance = crmChance;
	}

	public CrmContract getCrmContract() {
		return crmContract;
	}

	public void setCrmContract(CrmContract crmContract) {
		this.crmContract = crmContract;
	}

	public User getSysUser() {
		return sysUser;
	}

	public void setSysUser(User sysUser) {
		this.sysUser = sysUser;
	}
	
	@Length(min=0, max=500, message="发布内容长度必须介于 0 和 500 之间")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	@Length(min=0, max=200, message="图片长度必须介于 0 和 200 之间")
	public String getPictures() {
		return pictures;
	}

	public void setPictures(String pictures) {
		this.pictures = pictures;
	}
	
	@Length(min=0, max=200, message="附件长度必须介于 0 和 200 之间")
	public String getFiles() {
		return files;
	}

	public void setFiles(String files) {
		this.files = files;
	}
	
}