/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.xiang.modules.crm.api;

import com.thinkgem.jeesite.common.mapper.JsonMapper;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.xiang.modules.common.api.BaseApi;
import com.xiang.modules.crm.entity.CrmContact;
import com.xiang.modules.crm.service.CrmContactService;
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
 * 联系人管理Controller
 *
 * @author Xiang
 * @version 2017-02-28
 */
@Controller
@RequestMapping(value = "${apiPath}/crm/crmContact")
public class CrmContactApi extends BaseApi {

    private final CrmContactService crmContactService;

    @Autowired
    public CrmContactApi(CrmContactService crmContactService) {
        this.crmContactService = crmContactService;
    }

    @ModelAttribute
    public CrmContact get(@RequestParam(required = false) String id) {
        CrmContact entity = null;
        if (StringUtils.isNotBlank(id)) {
            entity = crmContactService.get(id);
        }
        if (entity == null) {
            entity = new CrmContact();
        }
        return entity;
    }

    @RequestMapping(value = {"list",""})
    @ResponseBody
    public String list(CrmContact crmContact, HttpServletRequest request, HttpServletResponse response, Model model) {
        Page<CrmContact> page = crmContactService.findPage(new Page<>(request, response), crmContact);
        return JsonMapper.toJsonString(page.getList());
    }

    @RequestMapping(value = "form")
    @ResponseBody
    public String form(CrmContact crmContact, Model model) {
        return JsonMapper.toJsonString(crmContact);
    }

    @RequestMapping(value = "save")
    @ResponseBody
    public String save(CrmContact crmContact, Model model, RedirectAttributes redirectAttributes,HttpServletRequest request) {
        String entity = request.getParameter("entity");
        crmContact = (CrmContact) JsonMapper.fromJsonString(entity,CrmContact.class);
        if (!beanValidator(model, crmContact)) {
            return "验证失败";
        }
        crmContactService.save(crmContact);
        return "";
    }

    @RequestMapping(value = "delete")
    @ResponseBody
    public String delete(CrmContact crmContact, RedirectAttributes redirectAttributes) {
        crmContactService.delete(crmContact);
        return "";
    }

}