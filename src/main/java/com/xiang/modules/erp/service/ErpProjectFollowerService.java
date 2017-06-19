/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.xiang.modules.erp.service;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.xiang.modules.erp.dao.ErpProjectFollowerDao;
import com.xiang.modules.erp.entity.ErpProjectFollower;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 项目日报管理Service
 * @author xiang
 * @version 2017-06-09
 */
@Service
@Transactional(readOnly = true)
public class ErpProjectFollowerService extends CrudService<ErpProjectFollowerDao, ErpProjectFollower> {

	public ErpProjectFollower get(String id) {
		return super.get(id);
	}
	
	public List<ErpProjectFollower> findList(ErpProjectFollower erpProjectFollower) {
		return super.findList(erpProjectFollower);
	}
	
	public Page<ErpProjectFollower> findPage(Page<ErpProjectFollower> page, ErpProjectFollower erpProjectFollower) {
		return super.findPage(page, erpProjectFollower);
	}
	
	@Transactional(readOnly = false)
	public void save(ErpProjectFollower erpProjectFollower) {
		super.save(erpProjectFollower);
	}
	
	@Transactional(readOnly = false)
	public void delete(ErpProjectFollower erpProjectFollower) {
		super.delete(erpProjectFollower);
	}
	
}