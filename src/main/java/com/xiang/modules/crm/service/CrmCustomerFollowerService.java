/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.xiang.modules.crm.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.xiang.modules.crm.entity.CrmCustomerFollower;
import com.xiang.modules.crm.dao.CrmCustomerFollowerDao;

/**
 * 跟进人管理Service
 * @author Xiang
 * @version 2017-02-28
 */
@Service
@Transactional(readOnly = true)
public class CrmCustomerFollowerService extends CrudService<CrmCustomerFollowerDao, CrmCustomerFollower> {

	public CrmCustomerFollower get(String id) {
		return super.get(id);
	}
	
	public List<CrmCustomerFollower> findList(CrmCustomerFollower crmCustomerFollower) {
		return super.findList(crmCustomerFollower);
	}
	
	public Page<CrmCustomerFollower> findPage(Page<CrmCustomerFollower> page, CrmCustomerFollower crmCustomerFollower) {
		return super.findPage(page, crmCustomerFollower);
	}
	
	@Transactional(readOnly = false)
	public void save(CrmCustomerFollower crmCustomerFollower) {
		super.save(crmCustomerFollower);
	}
	
	@Transactional(readOnly = false)
	public void delete(CrmCustomerFollower crmCustomerFollower) {
		super.delete(crmCustomerFollower);
	}
	
}