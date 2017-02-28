/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.xiang.modules.crm.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.xiang.modules.crm.entity.CrmContractPaybackPlan;
import com.xiang.modules.crm.dao.CrmContractPaybackPlanDao;

/**
 * 合同回款计划管理Service
 * @author Xiang
 * @version 2017-02-28
 */
@Service
@Transactional(readOnly = true)
public class CrmContractPaybackPlanService extends CrudService<CrmContractPaybackPlanDao, CrmContractPaybackPlan> {

	public CrmContractPaybackPlan get(String id) {
		return super.get(id);
	}
	
	public List<CrmContractPaybackPlan> findList(CrmContractPaybackPlan crmContractPaybackPlan) {
		return super.findList(crmContractPaybackPlan);
	}
	
	public Page<CrmContractPaybackPlan> findPage(Page<CrmContractPaybackPlan> page, CrmContractPaybackPlan crmContractPaybackPlan) {
		return super.findPage(page, crmContractPaybackPlan);
	}
	
	@Transactional(readOnly = false)
	public void save(CrmContractPaybackPlan crmContractPaybackPlan) {
		super.save(crmContractPaybackPlan);
	}
	
	@Transactional(readOnly = false)
	public void delete(CrmContractPaybackPlan crmContractPaybackPlan) {
		super.delete(crmContractPaybackPlan);
	}
	
}