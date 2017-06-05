/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.xiang.modules.erp.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.xiang.modules.erp.entity.ErpDaily;
import com.xiang.modules.erp.dao.ErpDailyDao;

/**
 * 项目日报管理Service
 * @author xiang
 * @version 2017-06-05
 */
@Service
@Transactional(readOnly = true)
public class ErpDailyService extends CrudService<ErpDailyDao, ErpDaily> {

	public ErpDaily get(String id) {
		return super.get(id);
	}
	
	public List<ErpDaily> findList(ErpDaily erpDaily) {
		return super.findList(erpDaily);
	}
	
	public Page<ErpDaily> findPage(Page<ErpDaily> page, ErpDaily erpDaily) {
		return super.findPage(page, erpDaily);
	}
	
	@Transactional(readOnly = false)
	public void save(ErpDaily erpDaily) {
		super.save(erpDaily);
	}
	
	@Transactional(readOnly = false)
	public void delete(ErpDaily erpDaily) {
		super.delete(erpDaily);
	}
	
}