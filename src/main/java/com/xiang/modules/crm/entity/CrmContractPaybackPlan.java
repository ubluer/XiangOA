/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.xiang.modules.crm.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.thinkgem.jeesite.common.persistence.DataEntity;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

/**
 * 合同回款计划管理Entity
 * @author Xiang
 * @version 2017-02-28
 */
public class CrmContractPaybackPlan extends DataEntity<CrmContractPaybackPlan> {
	
	private static final long serialVersionUID = 1L;
	private Integer period;		// 期数
	private CrmContract crmContract;		// 合同id
	private CrmChance crmChance;		// 负责人id
	private Double amount;		// 应收金额
	private Date executionTime;		// 计划日期
	private String pictures;		// 图片
	private String files;		// 附件
	private Date beginExecutionTime;		// 开始 计划日期
	private Date endExecutionTime;		// 结束 计划日期
	
	public CrmContractPaybackPlan() {
		super();
	}

	public CrmContractPaybackPlan(String id){
		super(id);
	}

	public Integer getPeriod() {
		return period;
	}

	public void setPeriod(Integer period) {
		this.period = period;
	}
	
	public CrmContract getCrmContract() {
		return crmContract;
	}

	public void setCrmContract(CrmContract crmContract) {
		this.crmContract = crmContract;
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
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getExecutionTime() {
		return executionTime;
	}

	public void setExecutionTime(Date executionTime) {
		this.executionTime = executionTime;
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
	
	public Date getBeginExecutionTime() {
		return beginExecutionTime;
	}

	public void setBeginExecutionTime(Date beginExecutionTime) {
		this.beginExecutionTime = beginExecutionTime;
	}
	
	public Date getEndExecutionTime() {
		return endExecutionTime;
	}

	public void setEndExecutionTime(Date endExecutionTime) {
		this.endExecutionTime = endExecutionTime;
	}
		
}