/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.xiang.modules.erp.entity;

import com.xiang.modules.crm.entity.CrmCustomer;
import org.hibernate.validator.constraints.Length;
import com.thinkgem.jeesite.modules.sys.entity.User;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 工程项目Entity
 * @author xiang
 * @version 2017-06-06
 */
public class ErpProjectFollower extends DataEntity<ErpProjectFollower> {
	
	private static final long serialVersionUID = 1L;
	private ErpProject erpProject;		// 项目 父类
	private String name;		// 名称
	private User sysUser;		// 负责人编号
	private CrmCustomer crmCustomer;		// 参与客户
	private String classify;		// 参与类型
	private String content;		// 参与内容
	private String pictures;		// 图片
	private String files;		// 附件
	
	public ErpProjectFollower() {
		super();
	}

	public ErpProjectFollower(String id){
		super(id);
	}

	public ErpProjectFollower(ErpProject erpProject){
		this.erpProject = erpProject;
	}

	@Length(min=0, max=64, message="项目长度必须介于 0 和 64 之间")
	public ErpProject getErpProject() {
		return erpProject;
	}

	public void setErpProject(ErpProject erpProject) {
		this.erpProject = erpProject;
	}
	
	@Length(min=1, max=200, message="名称长度必须介于 1 和 200 之间")
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
	
	@Length(min=0, max=20, message="参与类型长度必须介于 0 和 20 之间")
	public String getClassify() {
		return classify;
	}

	public void setClassify(String classify) {
		this.classify = classify;
	}
	
	@Length(min=0, max=200, message="参与内容长度必须介于 0 和 200 之间")
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