/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.xiang.modules.erp.api;

import com.thinkgem.jeesite.common.service.CrudService;
import com.xiang.modules.common.api.BaseApi;
import com.xiang.modules.erp.dao.ErpProjectFollowerDao;
import com.xiang.modules.erp.entity.ErpProjectFollower;
import com.xiang.modules.erp.service.ErpProjectFollowerService;
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
@RequestMapping(value = "${apiPath}/erp/erpProjectFollower")
public class ErpProjectFollowerApi extends BaseApi<ErpProjectFollowerDao,ErpProjectFollower> {

    private final ErpProjectFollowerService erpProjectFollowerService;

    @Autowired
    public ErpProjectFollowerApi(ErpProjectFollowerService erpProjectFollowerService) {
        this.erpProjectFollowerService = erpProjectFollowerService;
    }

    @Override
    protected CrudService<ErpProjectFollowerDao, ErpProjectFollower> getCrudService() {
        return erpProjectFollowerService;
    }

    @Override
    protected Class<ErpProjectFollower> getEntityClass() {
        return ErpProjectFollower.class;
    }
}