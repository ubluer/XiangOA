/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.xiang.modules.erp.api;

import com.thinkgem.jeesite.common.service.CrudService;
import com.xiang.modules.common.api.BaseApi;
import com.xiang.modules.erp.dao.ErpRepertoryCostDao;
import com.xiang.modules.erp.dao.ErpRepertoryDao;
import com.xiang.modules.erp.entity.ErpRepertory;
import com.xiang.modules.erp.entity.ErpRepertoryCost;
import com.xiang.modules.erp.service.ErpRepertoryCostService;
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
@RequestMapping(value = "${apiPath}/erp/erpRepertoryCost")
public class ErpRepertoryCostApi extends BaseApi<ErpRepertoryCostDao,ErpRepertoryCost> {

    private final ErpRepertoryCostService erpRepertoryCostService;

    @Autowired
    public ErpRepertoryCostApi(ErpRepertoryCostService erpRepertoryCostService) {
        this.erpRepertoryCostService = erpRepertoryCostService;
    }

    @Override
    protected CrudService<ErpRepertoryCostDao, ErpRepertoryCost> getCrudService() {
        return erpRepertoryCostService;
    }

    @Override
    protected Class<ErpRepertoryCost> getEntityClass() {
        return ErpRepertoryCost.class;
    }
}