/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.xiang.modules.crm.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.xiang.modules.crm.entity.CrmCustomerFollow;
import com.xiang.modules.crm.dao.CrmCustomerFollowDao;

/**
 * 跟进记录管理Service
 * @author Xiang
 * @version 2017-02-28
 */
@Service
@Transactional(readOnly = true)
public class CrmCustomerFollowService extends CrudService<CrmCustomerFollowDao, CrmCustomerFollow> {

	public CrmCustomerFollow get(String id) {
		return super.get(id);
	}
	
	public List<CrmCustomerFollow> findList(CrmCustomerFollow crmCustomerFollow) {
		return super.findList(crmCustomerFollow);
	}
	
	public Page<CrmCustomerFollow> findPage(Page<CrmCustomerFollow> page, CrmCustomerFollow crmCustomerFollow) {
		return super.findPage(page, crmCustomerFollow);
	}
	
	@Transactional(readOnly = false)
	public void save(CrmCustomerFollow crmCustomerFollow) {
		super.save(crmCustomerFollow);
	}
	
	@Transactional(readOnly = false)
	public void delete(CrmCustomerFollow crmCustomerFollow) {
		super.delete(crmCustomerFollow);
	}
	
}