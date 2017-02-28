/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.xiang.modules.crm.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.xiang.modules.crm.entity.CrmCustomer;
import com.xiang.modules.crm.dao.CrmCustomerDao;

/**
 * 客户管理Service
 * @author Xiang
 * @version 2017-02-28
 */
@Service
@Transactional(readOnly = true)
public class CrmCustomerService extends CrudService<CrmCustomerDao, CrmCustomer> {

	public CrmCustomer get(String id) {
		return super.get(id);
	}
	
	public List<CrmCustomer> findList(CrmCustomer crmCustomer) {
		return super.findList(crmCustomer);
	}
	
	public Page<CrmCustomer> findPage(Page<CrmCustomer> page, CrmCustomer crmCustomer) {
		return super.findPage(page, crmCustomer);
	}
	
	@Transactional(readOnly = false)
	public void save(CrmCustomer crmCustomer) {
		super.save(crmCustomer);
	}
	
	@Transactional(readOnly = false)
	public void delete(CrmCustomer crmCustomer) {
		super.delete(crmCustomer);
	}
	
}