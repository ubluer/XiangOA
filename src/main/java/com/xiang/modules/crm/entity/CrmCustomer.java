/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.xiang.modules.crm.entity;

import org.hibernate.validator.constraints.Length;
import com.thinkgem.jeesite.modules.sys.entity.User;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 客户管理Entity
 * @author Xiang
 * @version 2017-02-21
 */
public class CrmCustomer extends DataEntity<CrmCustomer> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// 名称
	private User sysUser;		// 负责人编号
	private String vip;		// 客户级别
	private String source;		// 客户来源
	private String classify;		// 客户分类
	private String status;		// 客户状态
	private String phone;		// 电话
	private String website;		// 网址
	private String fax;		// 传真
	private String zip;		// 邮编
	private String place;		// 地址
	private Double longitude;		// 标记位置经度
	private Double latitude;		// 标记位置纬度
	private String pitures;		// 图片
	private String files;		// 附件
	
	public CrmCustomer() {
		super();
	}

	public CrmCustomer(String id){
		super(id);
	}

	@Length(min=0, max=200, message="名称长度必须介于 0 和 200 之间")
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
	
	@Length(min=0, max=20, message="客户级别长度必须介于 0 和 20 之间")
	public String getVip() {
		return vip;
	}

	public void setVip(String vip) {
		this.vip = vip;
	}
	
	@Length(min=0, max=20, message="客户来源长度必须介于 0 和 20 之间")
	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}
	
	@Length(min=0, max=20, message="客户分类长度必须介于 0 和 20 之间")
	public String getClassify() {
		return classify;
	}

	public void setClassify(String classify) {
		this.classify = classify;
	}
	
	@Length(min=0, max=20, message="客户状态长度必须介于 0 和 20 之间")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	@Length(min=0, max=30, message="电话长度必须介于 0 和 30 之间")
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Length(min=0, max=64, message="网址长度必须介于 0 和 64 之间")
	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}
	
	@Length(min=0, max=64, message="传真长度必须介于 0 和 64 之间")
	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}
	
	@Length(min=0, max=30, message="邮编长度必须介于 0 和 30 之间")
	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}
	
	@Length(min=0, max=200, message="地址长度必须介于 0 和 200 之间")
	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}
	
	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	
	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	
	@Length(min=0, max=200, message="图片长度必须介于 0 和 200 之间")
	public String getPitures() {
		return pitures;
	}

	public void setPitures(String pitures) {
		this.pitures = pitures;
	}
	
	@Length(min=0, max=200, message="附件长度必须介于 0 和 200 之间")
	public String getFiles() {
		return files;
	}

	public void setFiles(String files) {
		this.files = files;
	}
	
}