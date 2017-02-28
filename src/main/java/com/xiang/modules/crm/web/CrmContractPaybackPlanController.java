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
import com.xiang.modules.crm.entity.CrmContractPaybackPlan;
import com.xiang.modules.crm.service.CrmContractPaybackPlanService;

/**
 * 合同回款计划管理Controller
 * @author Xiang
 * @version 2017-02-28
 */
@Controller
@RequestMapping(value = "${adminPath}/crm/crmContractPaybackPlan")
public class CrmContractPaybackPlanController extends BaseController {

	@Autowired
	private CrmContractPaybackPlanService crmContractPaybackPlanService;
	
	@ModelAttribute
	public CrmContractPaybackPlan get(@RequestParam(required=false) String id) {
		CrmContractPaybackPlan entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = crmContractPaybackPlanService.get(id);
		}
		if (entity == null){
			entity = new CrmContractPaybackPlan();
		}
		return entity;
	}
	
	@RequiresPermissions("crm:crmContractPaybackPlan:view")
	@RequestMapping(value = {"list", ""})
	public String list(CrmContractPaybackPlan crmContractPaybackPlan, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<CrmContractPaybackPlan> page = crmContractPaybackPlanService.findPage(new Page<CrmContractPaybackPlan>(request, response), crmContractPaybackPlan); 
		model.addAttribute("page", page);
		return "modules/crm/crmContractPaybackPlanList";
	}

	@RequiresPermissions("crm:crmContractPaybackPlan:view")
	@RequestMapping(value = "form")
	public String form(CrmContractPaybackPlan crmContractPaybackPlan, Model model) {
		model.addAttribute("crmContractPaybackPlan", crmContractPaybackPlan);
		return "modules/crm/crmContractPaybackPlanForm";
	}

	@RequiresPermissions("crm:crmContractPaybackPlan:edit")
	@RequestMapping(value = "save")
	public String save(CrmContractPaybackPlan crmContractPaybackPlan, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, crmContractPaybackPlan)){
			return form(crmContractPaybackPlan, model);
		}
		crmContractPaybackPlanService.save(crmContractPaybackPlan);
		addMessage(redirectAttributes, "保存回款计划成功");
		return "redirect:"+Global.getAdminPath()+"/crm/crmContractPaybackPlan/?repage";
	}
	
	@RequiresPermissions("crm:crmContractPaybackPlan:edit")
	@RequestMapping(value = "delete")
	public String delete(CrmContractPaybackPlan crmContractPaybackPlan, RedirectAttributes redirectAttributes) {
		crmContractPaybackPlanService.delete(crmContractPaybackPlan);
		addMessage(redirectAttributes, "删除回款计划成功");
		return "redirect:"+Global.getAdminPath()+"/crm/crmContractPaybackPlan/?repage";
	}

}