/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.xiang.modules.erp.entity;

import org.hibernate.validator.constraints.Length;
import com.thinkgem.jeesite.modules.sys.entity.User;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 项目日报管理Entity
 * @author xiang
 * @version 2017-06-08
 */
public class ErpDaily extends DataEntity<ErpDaily> {
	
	private static final long serialVersionUID = 1L;
	private ErpProject erpProject;		// 工程id
	private User sysUser;		// 记录人编号
	private String content;		// 日报
	private String type;		// 类型
	private String weather;		// 天气
	private Double cost;		// 花费
	private String place;		// 地址
	private Double longitude;		// 标记位置经度
	private Double latitude;		// 标记位置纬度
	private String pictures;		// 图片
	private String files;		// 附件
	
	public ErpDaily() {
		super();
	}

	public ErpDaily(String id){
		super(id);
	}

	@Length(min=0, max=64, message="工程id长度必须介于 0 和 64 之间")
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
	
	@Length(min=0, max=500, message="日报长度必须介于 0 和 500 之间")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	@Length(min=0, max=20, message="类型长度必须介于 0 和 20 之间")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	@Length(min=0, max=50, message="天气长度必须介于 0 和 50 之间")
	public String getWeather() {
		return weather;
	}

	public void setWeather(String weather) {
		this.weather = weather;
	}
	
	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
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