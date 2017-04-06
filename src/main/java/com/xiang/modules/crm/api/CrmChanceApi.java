/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.xiang.modules.crm.api;

import com.thinkgem.jeesite.common.service.CrudService;
import com.xiang.modules.common.api.BaseApi;
import com.xiang.modules.crm.dao.CrmChanceDao;
import com.xiang.modules.crm.entity.CrmChance;
import com.xiang.modules.crm.service.CrmChanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 联系人管理Controller
 *
 * @author Xiang
 * @version 2017-02-28
 */
@Controller
@RequestMapping(value = "${apiPath}/crm/chance")
public class CrmChanceApi extends BaseApi<CrmChanceDao,CrmChance> {

    @Override
    protected CrudService<CrmChanceDao, CrmChance> getCrudService() {
        return crmChanceService;
    }

    @Override
    protected Class<CrmChance> getEntityClass() {
        return CrmChance.class;
    }

    private final CrmChanceService crmChanceService;

    @Autowired
    public CrmChanceApi(CrmChanceService crmChanceService) {
        this.crmChanceService = crmChanceService;
    }

}