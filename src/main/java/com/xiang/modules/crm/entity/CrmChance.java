/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.xiang.modules.crm.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 机会管理Entity
 * @author Xiang
 * @version 2017-02-28
 */
public class CrmChance extends DataEntity<CrmChance> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// 机会名称
	private String crmCustomer;		// 客户id
	private Double amount;		// 预计成交金额
	private Date executionTime;		// 预计成交时间
	private String progress;		// 销售进度
	private String degree;		// 机会级别
	private String pitures;		// 图片
	private String files;		// 附件
	private Date beginExecutionTime;		// 开始 预计成交时间
	private Date endExecutionTime;		// 结束 预计成交时间
	
	public CrmChance() {
		super();
	}

	public CrmChance(String id){
		super(id);
	}

	@Length(min=0, max=200, message="机会名称长度必须介于 0 和 200 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=0, max=64, message="客户id长度必须介于 0 和 64 之间")
	public String getCrmCustomer() {
		return crmCustomer;
	}

	public void setCrmCustomer(String crmCustomer) {
		this.crmCustomer = crmCustomer;
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
	
	@Length(min=0, max=20, message="销售进度长度必须介于 0 和 20 之间")
	public String getProgress() {
		return progress;
	}

	public void setProgress(String progress) {
		this.progress = progress;
	}
	
	@Length(min=0, max=20, message="机会级别长度必须介于 0 和 20 之间")
	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
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