/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.xiang.modules.sys.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.xiang.modules.sys.entity.SysFile;
import com.xiang.modules.sys.dao.SysFileDao;

/**
 * 文件管理Service
 * @author Xiang
 * @version 2017-02-28
 */
@Service
@Transactional(readOnly = true)
public class SysFileService extends CrudService<SysFileDao, SysFile> {

	public SysFile get(String id) {
		return super.get(id);
	}
	
	public List<SysFile> findList(SysFile sysFile) {
		return super.findList(sysFile);
	}
	
	public Page<SysFile> findPage(Page<SysFile> page, SysFile sysFile) {
		return super.findPage(page, sysFile);
	}
	
	@Transactional(readOnly = false)
	public void save(SysFile sysFile) {
		super.save(sysFile);
	}
	
	@Transactional(readOnly = false)
	public void delete(SysFile sysFile) {
		super.delete(sysFile);
	}
	
}