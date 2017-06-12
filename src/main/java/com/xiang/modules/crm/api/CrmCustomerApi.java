/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.xiang.modules.crm.api;

import com.thinkgem.jeesite.common.service.CrudService;
import com.xiang.modules.common.api.BaseApi;
import com.xiang.modules.crm.dao.CrmCustomerDao;
import com.xiang.modules.crm.entity.CrmCustomer;
import com.xiang.modules.crm.service.CrmCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 客户管理Controller
 *
 * @author Xiang
 * @version 2017-02-28
 */
@Controller
@RequestMapping(value = "${apiPath}/crm/crmCustomer")
public class CrmCustomerApi extends BaseApi<CrmCustomerDao,CrmCustomer> {

    private final CrmCustomerService crmCustomerService;

    @Autowired
    public CrmCustomerApi(CrmCustomerService crmCustomerService) {
        this.crmCustomerService = crmCustomerService;
    }


    @Override
    protected CrudService<CrmCustomerDao, CrmCustomer> getCrudService() {
        return crmCustomerService;
    }

    @Override
    protected Class<CrmCustomer> getEntityClass() {
        return CrmCustomer.class;
    }
}