/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.xiang.modules.crm.entity;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 合同回款计划管理Entity
 * @author Xiang
 * @version 2017-02-28
 */
public class CrmContractPaybackPlan extends DataEntity<CrmContractPaybackPlan> {
	
	private static final long serialVersionUID = 1L;
	private Integer period;		// 期数
	private Custom crmContract;		// 合同id
	private Custom crmChance;		// 负责人id
	private Double amount;		// 应收金额
	private Date executionTime;		// 计划日期
	private String pitures;		// 图片
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
	
	public Custom getCrmContract() {
		return crmContract;
	}

	public void setCrmContract(Custom crmContract) {
		this.crmContract = crmContract;
	}
	
	public Custom getCrmChance() {
		return crmChance;
	}

	public void setCrmChance(Custom crmChance) {
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