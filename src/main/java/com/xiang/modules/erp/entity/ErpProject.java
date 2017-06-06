/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.xiang.modules.erp.entity;

import com.xiang.modules.crm.entity.CrmContract;
import org.hibernate.validator.constraints.Length;
import com.thinkgem.jeesite.modules.sys.entity.User;
import java.util.List;
import com.google.common.collect.Lists;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 工程项目Entity
 * @author xiang
 * @version 2017-06-06
 */
public class ErpProject extends DataEntity<ErpProject> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// 名称
	private User sysUser;		// 负责人编号
	private CrmContract crmContract;		// 项目合同
	private String vip;		// 级别
	private String source;		// 来源
	private String status;		// 状态
	private String place;		// 地址
	private String longitude;		// 标记位置经度
	private String latitude;		// 标记位置纬度
	private String pictures;		// 图片
	private String files;		// 附件
	private List<ErpProjectFollower> erpProjectFollowerList = Lists.newArrayList();		// 子表列表
	
	public ErpProject() {
		super();
	}

	public ErpProject(String id){
		super(id);
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
	
	public CrmContract getCrmContract() {
		return crmContract;
	}

	public void setCrmContract(CrmContract crmContract) {
		this.crmContract = crmContract;
	}
	
	@Length(min=0, max=20, message="级别长度必须介于 0 和 20 之间")
	public String getVip() {
		return vip;
	}

	public void setVip(String vip) {
		this.vip = vip;
	}
	
	@Length(min=0, max=20, message="来源长度必须介于 0 和 20 之间")
	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}
	
	@Length(min=0, max=20, message="状态长度必须介于 0 和 20 之间")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	@Length(min=0, max=200, message="地址长度必须介于 0 和 200 之间")
	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}
	
	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	
	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
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
	
	public List<ErpProjectFollower> getErpProjectFollowerList() {
		return erpProjectFollowerList;
	}

	public void setErpProjectFollowerList(List<ErpProjectFollower> erpProjectFollowerList) {
		this.erpProjectFollowerList = erpProjectFollowerList;
	}
}