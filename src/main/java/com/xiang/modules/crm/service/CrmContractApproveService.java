/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.xiang.modules.crm.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.xiang.modules.crm.entity.CrmContractApprove;
import com.xiang.modules.crm.dao.CrmContractApproveDao;

/**
 * 成交记录管理Service
 * @author Xiang
 * @version 2017-02-28
 */
@Service
@Transactional(readOnly = true)
public class CrmContractApproveService extends CrudService<CrmContractApproveDao, CrmContractApprove> {

	public CrmContractApprove get(String id) {
		return super.get(id);
	}
	
	public List<CrmContractApprove> findList(CrmContractApprove crmContractApprove) {
		return super.findList(crmContractApprove);
	}
	
	public Page<CrmContractApprove> findPage(Page<CrmContractApprove> page, CrmContractApprove crmContractApprove) {
		return super.findPage(page, crmContractApprove);
	}
	
	@Transactional(readOnly = false)
	public void save(CrmContractApprove crmContractApprove) {
		super.save(crmContractApprove);
	}
	
	@Transactional(readOnly = false)
	public void delete(CrmContractApprove crmContractApprove) {
		super.delete(crmContractApprove);
	}
	
}