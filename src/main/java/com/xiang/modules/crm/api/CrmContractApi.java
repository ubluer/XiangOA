/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.xiang.modules.crm.api;

import com.thinkgem.jeesite.common.mapper.JsonMapper;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.common.web.BaseController;
import com.xiang.modules.crm.entity.CrmContract;
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
public class CrmContractApi extends BaseController {

    private final CrmContractService crmContractService;

    @Autowired
    public CrmContractApi(CrmContractService crmContractService) {
        this.crmContractService = crmContractService;
    }

    @ModelAttribute
    public CrmContract get(@RequestParam(required = false) String id) {
        CrmContract entity = null;
        if (StringUtils.isNotBlank(id)) {
            entity = crmContractService.get(id);
        }
        if (entity == null) {
            entity = new CrmContract();
        }
        return entity;
    }

    @RequestMapping(value = {"list", ""})
    @ResponseBody
    public String list(CrmContract crmContract, HttpServletRequest request, HttpServletResponse response, Model model) {
        Page<CrmContract> page = crmContractService.findPage(new Page<CrmContract>(request, response), crmContract);
        return JsonMapper.toJsonString(page.getList());
    }

    @RequestMapping(value = "form")
    @ResponseBody
    public String form(CrmContract crmContract, Model model) {
        return JsonMapper.toJsonString(crmContract);
    }

    @RequestMapping(value = "save")
    @ResponseBody
    public String save(CrmContract crmContract, Model model, HttpServletRequest request) {
        String entity = request.getParameter("entity");
        crmContract = (CrmContract) JsonMapper.fromJsonString(entity,CrmContract.class);
        if (!beanValidator(model, crmContract)) {
            return form(crmContract, model);
        }
        crmContractService.save(crmContract);
        return "";
    }

    @RequestMapping(value = "delete")
    @ResponseBody
    public String delete(CrmContract crmContract, RedirectAttributes redirectAttributes) {
        crmContractService.delete(crmContract);
        return "";
    }

}