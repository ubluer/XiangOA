/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.xiang.modules.erp.api;

import com.thinkgem.jeesite.common.service.CrudService;
import com.xiang.modules.common.api.BaseApi;
import com.xiang.modules.erp.dao.ErpDailyDao;
import com.xiang.modules.erp.dao.ErpProjectDao;
import com.xiang.modules.erp.entity.ErpDaily;
import com.xiang.modules.erp.entity.ErpProject;
import com.xiang.modules.erp.service.ErpDailyService;
import com.xiang.modules.erp.service.ErpProjectService;
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
@RequestMapping(value = "${apiPath}/erp/erpDaily")
public class ErpProjectDailyApi extends BaseApi<ErpDailyDao,ErpDaily> {

    private final ErpDailyService erpDailyService;

    @Autowired
    public ErpProjectDailyApi(ErpDailyService erpDailyService) {
        this.erpDailyService = erpDailyService;
    }

    @Override
    protected CrudService<ErpDailyDao, ErpDaily> getCrudService() {
        return erpDailyService;
    }

    @Override
    protected Class<ErpDaily> getEntityClass() {
        return ErpDaily.class;
    }
}