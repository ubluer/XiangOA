/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.xiang.modules.erp.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.xiang.modules.erp.entity.ErpDaily;

/**
 * 项目日报管理DAO接口
 * @author xiang
 * @version 2017-06-08
 */
@MyBatisDao
public interface ErpDailyDao extends CrudDao<ErpDaily> {
	
}