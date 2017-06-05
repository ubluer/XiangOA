/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.xiang.modules.erp.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.xiang.modules.erp.entity.ErpRepertory;
import com.xiang.modules.erp.dao.ErpRepertoryDao;

/**
 * 项目库存管理Service
 * @author xiang
 * @version 2017-06-05
 */
@Service
@Transactional(readOnly = true)
public class ErpRepertoryService extends CrudService<ErpRepertoryDao, ErpRepertory> {

	public ErpRepertory get(String id) {
		return super.get(id);
	}
	
	public List<ErpRepertory> findList(ErpRepertory erpRepertory) {
		return super.findList(erpRepertory);
	}
	
	public Page<ErpRepertory> findPage(Page<ErpRepertory> page, ErpRepertory erpRepertory) {
		return super.findPage(page, erpRepertory);
	}
	
	@Transactional(readOnly = false)
	public void save(ErpRepertory erpRepertory) {
		super.save(erpRepertory);
	}
	
	@Transactional(readOnly = false)
	public void delete(ErpRepertory erpRepertory) {
		super.delete(erpRepertory);
	}
	
}