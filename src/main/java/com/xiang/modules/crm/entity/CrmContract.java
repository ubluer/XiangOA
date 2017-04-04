/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.xiang.modules.crm.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.thinkgem.jeesite.common.persistence.DataEntity;
import com.thinkgem.jeesite.modules.sys.entity.User;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

/**
 * 合同管理Entity
 * @author Xiang
 * @version 2017-02-28
 */
public class CrmContract extends DataEntity<CrmContract> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// 标题
	private CrmCustomer crmCustomer;		// 客户id
	private CrmChance crmChance;		// 机会id
	private Double amount;		// 合同金额
	private Double discount;		// 折扣后金额
	private Date contractDate;		// 签约日期
	private String paymentMethod;		// 付款方式
	private User sysUser;		// 我方签约人
	private String parties;		// 客户签约人
	private Date startTime;		// 开始日期
	private Date endTime;		// 结束日期
	private String pictures;		// 图片
	private String files;		// 附件
	
	public CrmContract() {
		super();
	}

	public CrmContract(String id){
		super(id);
	}

	@Length(min=0, max=200, message="标题长度必须介于 0 和 200 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
	
	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getContractDate() {
		return contractDate;
	}

	public void setContractDate(Date contractDate) {
		this.contractDate = contractDate;
	}
	
	@Length(min=0, max=20, message="付款方式长度必须介于 0 和 20 之间")
	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	
	public User getSysUser() {
		return sysUser;
	}

	public void setSysUser(User sysUser) {
		this.sysUser = sysUser;
	}
	
	@Length(min=0, max=200, message="客户签约人长度必须介于 0 和 200 之间")
	public String getParties() {
		return parties;
	}

	public void setParties(String parties) {
		this.parties = parties;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
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