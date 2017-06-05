/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.xiang.modules.erp.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.xiang.modules.erp.entity.ErpRepertory;

/**
 * 项目库存管理DAO接口
 * @author xiang
 * @version 2017-06-05
 */
@MyBatisDao
public interface ErpRepertoryDao extends CrudDao<ErpRepertory> {
	
}