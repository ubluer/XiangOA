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
import com.xiang.modules.crm.entity.CrmChance;
import com.xiang.modules.crm.service.CrmChanceService;

/**
 * 联系人管理Controller
 * @author Xiang
 * @version 2017-02-28
 */
@Controller
@RequestMapping(value = "${adminPath}/crm/crmChance")
public class CrmChanceController extends BaseController {

	@Autowired
	private CrmChanceService crmChanceService;
	
	@ModelAttribute
	public CrmChance get(@RequestParam(required=false) String id) {
		CrmChance entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = crmChanceService.get(id);
		}
		if (entity == null){
			entity = new CrmChance();
		}
		return entity;
	}
	
	@RequiresPermissions("crm:crmChance:view")
	@RequestMapping(value = {"list", ""})
	public String list(CrmChance crmChance, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<CrmChance> page = crmChanceService.findPage(new Page<CrmChance>(request, response), crmChance); 
		model.addAttribute("page", page);
		return "modules/crm/crmChanceList";
	}

	@RequiresPermissions("crm:crmChance:view")
	@RequestMapping(value = "form")
	public String form(CrmChance crmChance, Model model) {
		model.addAttribute("crmChance", crmChance);
		return "modules/crm/crmChanceForm";
	}

	@RequiresPermissions("crm:crmChance:edit")
	@RequestMapping(value = "save")
	public String save(CrmChance crmChance, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, crmChance)){
			return form(crmChance, model);
		}
		crmChanceService.save(crmChance);
		addMessage(redirectAttributes, "保存联系人成功");
		return "redirect:"+Global.getAdminPath()+"/crm/crmChance/?repage";
	}
	
	@RequiresPermissions("crm:crmChance:edit")
	@RequestMapping(value = "delete")
	public String delete(CrmChance crmChance, RedirectAttributes redirectAttributes) {
		crmChanceService.delete(crmChance);
		addMessage(redirectAttributes, "删除联系人成功");
		return "redirect:"+Global.getAdminPath()+"/crm/crmChance/?repage";
	}

}