/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.xiang.modules.crm.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.xiang.modules.crm.entity.CrmContractPayback;
import com.xiang.modules.crm.dao.CrmContractPaybackDao;

/**
 * 合同回款记录管理Service
 * @author Xiang
 * @version 2017-02-28
 */
@Service
@Transactional(readOnly = true)
public class CrmContractPaybackService extends CrudService<CrmContractPaybackDao, CrmContractPayback> {

	public CrmContractPayback get(String id) {
		return super.get(id);
	}
	
	public List<CrmContractPayback> findList(CrmContractPayback crmContractPayback) {
		return super.findList(crmContractPayback);
	}
	
	public Page<CrmContractPayback> findPage(Page<CrmContractPayback> page, CrmContractPayback crmContractPayback) {
		return super.findPage(page, crmContractPayback);
	}
	
	@Transactional(readOnly = false)
	public void save(CrmContractPayback crmContractPayback) {
		super.save(crmContractPayback);
	}
	
	@Transactional(readOnly = false)
	public void delete(CrmContractPayback crmContractPayback) {
		super.delete(crmContractPayback);
	}
	
}