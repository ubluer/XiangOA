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
import com.xiang.modules.erp.entity.ErpProjectFollower;
import com.xiang.modules.erp.dao.ErpProjectFollowerDao;

/**
 * 工程项目Service
 * @author xiang
 * @version 2017-06-06
 */
@Service
@Transactional(readOnly = true)
public class ErpProjectService extends CrudService<ErpProjectDao, ErpProject> {

	@Autowired
	private ErpProjectFollowerDao erpProjectFollowerDao;
	
	public ErpProject get(String id) {
		ErpProject erpProject = super.get(id);
		erpProject.setErpProjectFollowerList(erpProjectFollowerDao.findList(new ErpProjectFollower(erpProject)));
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
		for (ErpProjectFollower erpProjectFollower : erpProject.getErpProjectFollowerList()){
			if (erpProjectFollower.getId() == null){
				continue;
			}
			if (ErpProjectFollower.DEL_FLAG_NORMAL.equals(erpProjectFollower.getDelFlag())){
				if (StringUtils.isBlank(erpProjectFollower.getId())){
					erpProjectFollower.setErpProject(erpProject);
					erpProjectFollower.preInsert();
					erpProjectFollowerDao.insert(erpProjectFollower);
				}else{
					erpProjectFollower.preUpdate();
					erpProjectFollowerDao.update(erpProjectFollower);
				}
			}else{
				erpProjectFollowerDao.delete(erpProjectFollower);
			}
		}
	}
	
	@Transactional(readOnly = false)
	public void delete(ErpProject erpProject) {
		super.delete(erpProject);
		erpProjectFollowerDao.delete(new ErpProjectFollower(erpProject));
	}
	
}