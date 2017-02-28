/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.xiang.modules.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.xiang.modules.crm.entity.CrmChance;
import com.xiang.modules.crm.dao.CrmChanceDao;

/**
 * 联系人管理Service
 * @author Xiang
 * @version 2017-02-28
 */
@Service
@Transactional(readOnly = true)
public class CrmChanceService extends CrudService<CrmChanceDao, CrmChance> {

	
	public CrmChance get(String id) {
		CrmChance crmChance = super.get(id);
		return crmChance;
	}
	
	public List<CrmChance> findList(CrmChance crmChance) {
		return super.findList(crmChance);
	}
	
	public Page<CrmChance> findPage(Page<CrmChance> page, CrmChance crmChance) {
		return super.findPage(page, crmChance);
	}
	
	@Transactional(readOnly = false)
	public void save(CrmChance crmChance) {
		super.save(crmChance);
	}
	
	@Transactional(readOnly = false)
	public void delete(CrmChance crmChance) {
		super.delete(crmChance);
	}
	
}