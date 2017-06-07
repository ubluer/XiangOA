/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.xiang.modules.crm.api;

import com.thinkgem.jeesite.common.mapper.JsonMapper;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.common.web.BaseController;
import com.xiang.modules.common.api.BaseApi;
import com.xiang.modules.common.api.vo.ResponseJson;
import com.xiang.modules.crm.dao.CrmContractDao;
import com.xiang.modules.crm.entity.CrmContract;
import com.xiang.modules.crm.entity.CrmCustomer;
import com.xiang.modules.crm.service.CrmContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 合同管理Controller
 *
 * @author Xiang
 * @version 2017-02-28
 */
@Controller
@RequestMapping(value = "${apiPath}/crm/crmContract")
public class CrmContractApi extends BaseApi<CrmContractDao,CrmContract> {

    private final CrmContractService crmContractService;

    @Autowired
    public CrmContractApi(CrmContractService crmContractService) {
        this.crmContractService = crmContractService;
    }

    @Override
    protected CrudService getCrudService() {
        return crmContractService;
    }

    @Override
    protected Class getEntityClass() {
        return CrmContract.class;
    }


}