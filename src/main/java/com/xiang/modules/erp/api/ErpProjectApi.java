/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.xiang.modules.erp.api;

import com.thinkgem.jeesite.common.service.CrudService;
import com.xiang.modules.common.api.BaseApi;
import com.xiang.modules.erp.dao.ErpProjectDao;
import com.xiang.modules.erp.entity.ErpProject;
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
@RequestMapping(value = "${apiPath}/erp/erpProject")
public class ErpProjectApi extends BaseApi<ErpProjectDao,ErpProject> {

    private final ErpProjectService erpProjectService;

    @Autowired
    public ErpProjectApi(ErpProjectService erpProjectService) {
        this.erpProjectService = erpProjectService;
    }

    @Override
    protected CrudService<ErpProjectDao, ErpProject> getCrudService() {
        return erpProjectService;
    }

    @Override
    protected Class<ErpProject> getEntityClass() {
        return ErpProject.class;
    }
}