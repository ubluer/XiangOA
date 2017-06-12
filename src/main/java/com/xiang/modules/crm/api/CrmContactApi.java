/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.xiang.modules.crm.api;

import com.thinkgem.jeesite.common.service.CrudService;
import com.xiang.modules.common.api.BaseApi;
import com.xiang.modules.crm.dao.CrmContactDao;
import com.xiang.modules.crm.entity.CrmContact;
import com.xiang.modules.crm.service.CrmContactService;
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
@RequestMapping(value = "${apiPath}/crm/crmContact")
public class CrmContactApi extends BaseApi<CrmContactDao,CrmContact> {

    private final CrmContactService crmContactService;

    @Autowired
    public CrmContactApi(CrmContactService crmContactService) {
        this.crmContactService = crmContactService;
    }


    @Override
    protected CrudService<CrmContactDao, CrmContact> getCrudService() {
        return crmContactService;
    }

    @Override
    protected Class<CrmContact> getEntityClass() {
        return CrmContact.class;
    }
}