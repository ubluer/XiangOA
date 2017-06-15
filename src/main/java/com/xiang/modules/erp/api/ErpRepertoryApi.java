/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.xiang.modules.erp.api;

import com.thinkgem.jeesite.common.service.CrudService;
import com.xiang.modules.common.api.BaseApi;
import com.xiang.modules.erp.dao.ErpProjectDao;
import com.xiang.modules.erp.dao.ErpRepertoryDao;
import com.xiang.modules.erp.entity.ErpProject;
import com.xiang.modules.erp.entity.ErpRepertory;
import com.xiang.modules.erp.service.ErpProjectService;
import com.xiang.modules.erp.service.ErpRepertoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 工程项目Controller
 *
 * @author xiang
 * @version 2017-06-06
 */
@Controller
@RequestMapping(value = "${apiPath}/erp/erpRepertory")
public class ErpRepertoryApi extends BaseApi<ErpRepertoryDao,ErpRepertory> {

    private final ErpRepertoryService erpRepertoryService;

    @Autowired
    public ErpRepertoryApi(ErpRepertoryService erpRepertoryService) {
        this.erpRepertoryService = erpRepertoryService;
    }

    @Override
    protected CrudService<ErpRepertoryDao, ErpRepertory> getCrudService() {
        return erpRepertoryService;
    }

    @Override
    protected Class<ErpRepertory> getEntityClass() {
        return ErpRepertory.class;
    }
}