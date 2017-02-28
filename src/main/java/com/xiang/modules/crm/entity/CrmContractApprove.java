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
 * 成交记录管理Entity
 * @author Xiang
 * @version 2017-02-28
 */
public class CrmContractApprove extends DataEntity<CrmContractApprove> {
	
	private static final long serialVersionUID = 1L;
	private CrmContract crmContract;		// 合同id
	private CrmCustomer crmCustomer;		// 客户id
	private User submitter;		// 创建人id
	private Date submitDate;		// 提交日期
	private User approver;		// 审批人
	private Date approveDate;		// 审批日期
	private String status;		// 审批状态
	private String reason;		// 驳回理由
	private String pictures;		// 图片
	private String files;		// 附件
	private Date beginSubmitDate;		// 开始 提交日期
	private Date endSubmitDate;		// 结束 提交日期
	private Date beginApproveDate;		// 开始 审批日期
	private Date endApproveDate;		// 结束 审批日期
	
	public CrmContractApprove() {
		super();
	}

	public CrmContractApprove(String id){
		super(id);
	}

	public CrmContract getCrmContract() {
		return crmContract;
	}

	public void setCrmContract(CrmContract crmContract) {
		this.crmContract = crmContract;
	}
	
	public CrmCustomer getCrmCustomer() {
		return crmCustomer;
	}

	public void setCrmCustomer(CrmCustomer crmCustomer) {
		this.crmCustomer = crmCustomer;
	}
	
	public User getSubmitter() {
		return submitter;
	}

	public void setSubmitter(User submitter) {
		this.submitter = submitter;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getSubmitDate() {
		return submitDate;
	}

	public void setSubmitDate(Date submitDate) {
		this.submitDate = submitDate;
	}
	
	public User getApprover() {
		return approver;
	}

	public void setApprover(User approver) {
		this.approver = approver;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getApproveDate() {
		return approveDate;
	}

	public void setApproveDate(Date approveDate) {
		this.approveDate = approveDate;
	}
	
	@Length(min=0, max=20, message="审批状态长度必须介于 0 和 20 之间")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	@Length(min=0, max=200, message="驳回理由长度必须介于 0 和 200 之间")
	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
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
	
	public Date getBeginSubmitDate() {
		return beginSubmitDate;
	}

	public void setBeginSubmitDate(Date beginSubmitDate) {
		this.beginSubmitDate = beginSubmitDate;
	}
	
	public Date getEndSubmitDate() {
		return endSubmitDate;
	}

	public void setEndSubmitDate(Date endSubmitDate) {
		this.endSubmitDate = endSubmitDate;
	}
		
	public Date getBeginApproveDate() {
		return beginApproveDate;
	}

	public void setBeginApproveDate(Date beginApproveDate) {
		this.beginApproveDate = beginApproveDate;
	}
	
	public Date getEndApproveDate() {
		return endApproveDate;
	}

	public void setEndApproveDate(Date endApproveDate) {
		this.endApproveDate = endApproveDate;
	}
		
}