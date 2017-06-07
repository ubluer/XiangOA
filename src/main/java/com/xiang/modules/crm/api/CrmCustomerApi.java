/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.xiang.modules.crm.api;

import com.thinkgem.jeesite.common.mapper.JsonMapper;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.common.web.BaseController;
import com.xiang.modules.common.api.vo.ResponseJson;
import com.xiang.modules.crm.entity.CrmCustomer;
import com.xiang.modules.crm.service.CrmCustomerService;
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
 * 客户管理Controller
 *
 * @author Xiang
 * @version 2017-02-28
 */
@Controller
@RequestMapping(value = "${apiPath}/crm/crmCustomer")
public class CrmCustomerApi extends BaseController {

    private final CrmCustomerService crmCustomerService;

    @Autowired
    public CrmCustomerApi(CrmCustomerService crmCustomerService) {
        this.crmCustomerService = crmCustomerService;
    }

    @ModelAttribute
    public CrmCustomer get(@RequestParam(required = false) String id) {
//        String id1 = request.getParameter("id");
        CrmCustomer entity = null;
        if (StringUtils.isNotBlank(id)){
            entity = crmCustomerService.get(id);
        }
        if (entity == null){
            entity = new CrmCustomer();
        }
        return entity;
    }

    //    @RequiresPermissions("crm:crmCustomer:view")
    @RequestMapping(value = {"list", ""})
    @ResponseBody
    public String list(CrmCustomer crmCustomer, HttpServletRequest request, HttpServletResponse response, Model model) {
        String entity = request.getParameter("query");
        CrmCustomer obj = (CrmCustomer) JsonMapper.fromJsonString(entity, CrmCustomer.class);
        if(obj==null){
            obj=new CrmCustomer();
        }
        Page<CrmCustomer> page = crmCustomerService.findPage(new Page<>(request, response), obj);
        return JsonMapper.toJsonString(new ResponseJson(page.getList()));
    }

    //    @RequiresPermissions("crm:crmCustomer:view")
    @RequestMapping(value = "form")
    @ResponseBody
    public String form(CrmCustomer crmCustomer) {
        return JsonMapper.toJsonString(crmCustomer);
    }

    //    @RequiresPermissions("crm:crmCustomer:edit")
    @RequestMapping(value = "save")
    @ResponseBody
    public String save(CrmCustomer crmCustomer, Model model, HttpServletRequest request) {

        String entity = request.getParameter("entity");
        CrmCustomer obj = (CrmCustomer) JsonMapper.fromJsonString(entity, CrmCustomer.class);
//        CrmCustomer crmCustomer = new CrmCustomer();
        if (!beanValidator(model, obj)) {
            return "保存客户失败,验证失败";
        }
        try {
            crmCustomerService.save(obj);
        }catch (Exception e){
            return "保存客户失败,数据不完整";
        }
        return "";
    }

    //    @RequiresPermissions("crm:crmCustomer:edit")
    @RequestMapping(value = "delete")
    @ResponseBody
    public String delete(CrmCustomer crmCustomer, RedirectAttributes redirectAttributes) {
        crmCustomerService.delete(crmCustomer);
        return "删除客户成功";
    }

}