/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.xiang.modules.crm.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.xiang.modules.crm.entity.CrmModified;
import com.xiang.modules.crm.dao.CrmModifiedDao;

/**
 * 修改记录管理Service
 * @author Xiang
 * @version 2017-02-28
 */
@Service
@Transactional(readOnly = true)
public class CrmModifiedService extends CrudService<CrmModifiedDao, CrmModified> {

	public CrmModified get(String id) {
		return super.get(id);
	}
	
	public List<CrmModified> findList(CrmModified crmModified) {
		return super.findList(crmModified);
	}
	
	public Page<CrmModified> findPage(Page<CrmModified> page, CrmModified crmModified) {
		return super.findPage(page, crmModified);
	}
	
	@Transactional(readOnly = false)
	public void save(CrmModified crmModified) {
		super.save(crmModified);
	}
	
	@Transactional(readOnly = false)
	public void delete(CrmModified crmModified) {
		super.delete(crmModified);
	}
	
}