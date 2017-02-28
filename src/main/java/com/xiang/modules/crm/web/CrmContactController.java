/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.xiang.modules.crm.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.xiang.modules.crm.entity.CrmContact;
import com.xiang.modules.crm.service.CrmContactService;

/**
 * 联系人管理Controller
 * @author Xiang
 * @version 2017-02-28
 */
@Controller
@RequestMapping(value = "${adminPath}/crm/crmContact")
public class CrmContactController extends BaseController {

	@Autowired
	private CrmContactService crmContactService;
	
	@ModelAttribute
	public CrmContact get(@RequestParam(required=false) String id) {
		CrmContact entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = crmContactService.get(id);
		}
		if (entity == null){
			entity = new CrmContact();
		}
		return entity;
	}
	
	@RequiresPermissions("crm:crmContact:view")
	@RequestMapping(value = {"list", ""})
	public String list(CrmContact crmContact, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<CrmContact> page = crmContactService.findPage(new Page<CrmContact>(request, response), crmContact); 
		model.addAttribute("page", page);
		return "modules/crm/crmContactList";
	}

	@RequiresPermissions("crm:crmContact:view")
	@RequestMapping(value = "form")
	public String form(CrmContact crmContact, Model model) {
		model.addAttribute("crmContact", crmContact);
		return "modules/crm/crmContactForm";
	}

	@RequiresPermissions("crm:crmContact:edit")
	@RequestMapping(value = "save")
	public String save(CrmContact crmContact, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, crmContact)){
			return form(crmContact, model);
		}
		crmContactService.save(crmContact);
		addMessage(redirectAttributes, "保存联系人成功");
		return "redirect:"+Global.getAdminPath()+"/crm/crmContact/?repage";
	}
	
	@RequiresPermissions("crm:crmContact:edit")
	@RequestMapping(value = "delete")
	public String delete(CrmContact crmContact, RedirectAttributes redirectAttributes) {
		crmContactService.delete(crmContact);
		addMessage(redirectAttributes, "删除联系人成功");
		return "redirect:"+Global.getAdminPath()+"/crm/crmContact/?repage";
	}

}