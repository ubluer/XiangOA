/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.xiang.modules.erp.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.xiang.modules.erp.entity.ErpRepertoryCost;
import com.xiang.modules.erp.dao.ErpRepertoryCostDao;

/**
 * 项目库存消费Service
 * @author xiang
 * @version 2017-06-05
 */
@Service
@Transactional(readOnly = true)
public class ErpRepertoryCostService extends CrudService<ErpRepertoryCostDao, ErpRepertoryCost> {

	public ErpRepertoryCost get(String id) {
		return super.get(id);
	}
	
	public List<ErpRepertoryCost> findList(ErpRepertoryCost erpRepertoryCost) {
		return super.findList(erpRepertoryCost);
	}
	
	public Page<ErpRepertoryCost> findPage(Page<ErpRepertoryCost> page, ErpRepertoryCost erpRepertoryCost) {
		return super.findPage(page, erpRepertoryCost);
	}
	
	@Transactional(readOnly = false)
	public void save(ErpRepertoryCost erpRepertoryCost) {
		super.save(erpRepertoryCost);
	}
	
	@Transactional(readOnly = false)
	public void delete(ErpRepertoryCost erpRepertoryCost) {
		super.delete(erpRepertoryCost);
	}
	
}