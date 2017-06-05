/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.xiang.modules.erp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.xiang.modules.erp.entity.ErpProject;
import com.xiang.modules.erp.dao.ErpProjectDao;

/**
 * 工程项目Service
 * @author xiang
 * @version 2017-06-05
 */
@Service
@Transactional(readOnly = true)
public class ErpProjectService extends CrudService<ErpProjectDao, ErpProject> {

	
	public ErpProject get(String id) {
		ErpProject erpProject = super.get(id);
		return erpProject;
	}
	
	public List<ErpProject> findList(ErpProject erpProject) {
		return super.findList(erpProject);
	}
	
	public Page<ErpProject> findPage(Page<ErpProject> page, ErpProject erpProject) {
		return super.findPage(page, erpProject);
	}
	
	@Transactional(readOnly = false)
	public void save(ErpProject erpProject) {
		super.save(erpProject);
	}
	
	@Transactional(readOnly = false)
	public void delete(ErpProject erpProject) {
		super.delete(erpProject);
	}
	
}