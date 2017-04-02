/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.xiang.modules.crm.entity;

import com.google.common.collect.Lists;
import com.thinkgem.jeesite.common.persistence.DataEntity;
import com.thinkgem.jeesite.modules.sys.entity.User;
import org.hibernate.validator.constraints.Length;

import java.util.List;

/**
 * 联系人管理Entity
 * @author Xiang
 * @version 2017-02-28
 */
public class CrmContact extends DataEntity<CrmContact> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// 姓名
	private User sysUser;		// 负责人编号
	private CrmCustomer crmCustomer;		// 客户
	private String department;		// 部门
	private String position;		// 职位
	private String email;		// 邮箱
	private String place;		// 地址
	private String pictures;		// 图片
	private String files;		// 附件
	private List<CrmContactPhone> crmContactPhoneList = Lists.newArrayList();		// 子表列表
	
	public CrmContact() {
		super();
	}

	public CrmContact(String id){
		super(id);
	}

	@Length(min=0, max=100, message="姓名长度必须介于 0 和 100 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public User getSysUser() {
		return sysUser;
	}

	public void setSysUser(User sysUser) {
		this.sysUser = sysUser;
	}
	
	public CrmCustomer getCrmCustomer() {
		return crmCustomer;
	}

	public void setCrmCustomer(CrmCustomer crmCustomer) {
		this.crmCustomer = crmCustomer;
	}
	
	@Length(min=0, max=200, message="部门长度必须介于 0 和 200 之间")
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
	@Length(min=0, max=200, message="职位长度必须介于 0 和 200 之间")
	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}
	
	@Length(min=0, max=200, message="邮箱长度必须介于 0 和 200 之间")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Length(min=0, max=200, message="地址长度必须介于 0 和 200 之间")
	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
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
	
	public List<CrmContactPhone> getCrmContactPhoneList() {
		return crmContactPhoneList;
	}

	public void setCrmContactPhoneList(List<CrmContactPhone> crmContactPhoneList) {
		this.crmContactPhoneList = crmContactPhoneList;
	}
}