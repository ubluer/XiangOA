/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.xiang.modules.crm.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.xiang.modules.crm.entity.CrmContract;
import com.xiang.modules.crm.dao.CrmContractDao;

/**
 * 合同管理Service
 * @author Xiang
 * @version 2017-02-28
 */
@Service
@Transactional(readOnly = true)
public class CrmContractService extends CrudService<CrmContractDao, CrmContract> {

	public CrmContract get(String id) {
		return super.get(id);
	}
	
	public List<CrmContract> findList(CrmContract crmContract) {
		return super.findList(crmContract);
	}
	
	public Page<CrmContract> findPage(Page<CrmContract> page, CrmContract crmContract) {
		return super.findPage(page, crmContract);
	}
	
	@Transactional(readOnly = false)
	public void save(CrmContract crmContract) {
		super.save(crmContract);
	}
	
	@Transactional(readOnly = false)
	public void delete(CrmContract crmContract) {
		super.delete(crmContract);
	}
	
}