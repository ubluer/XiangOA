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
import com.xiang.modules.crm.entity.CrmContract;
import com.xiang.modules.crm.service.CrmContractService;

/**
 * 合同管理Controller
 * @author Xiang
 * @version 2017-02-28
 */
@Controller
@RequestMapping(value = "${adminPath}/crm/crmContract")
public class CrmContractController extends BaseController {

	@Autowired
	private CrmContractService crmContractService;
	
	@ModelAttribute
	public CrmContract get(@RequestParam(required=false) String id) {
		CrmContract entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = crmContractService.get(id);
		}
		if (entity == null){
			entity = new CrmContract();
		}
		return entity;
	}
	
	@RequiresPermissions("crm:crmContract:view")
	@RequestMapping(value = {"list", ""})
	public String list(CrmContract crmContract, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<CrmContract> page = crmContractService.findPage(new Page<CrmContract>(request, response), crmContract); 
		model.addAttribute("page", page);
		return "modules/crm/crmContractList";
	}

	@RequiresPermissions("crm:crmContract:view")
	@RequestMapping(value = "form")
	public String form(CrmContract crmContract, Model model) {
		model.addAttribute("crmContract", crmContract);
		return "modules/crm/crmContractForm";
	}

	@RequiresPermissions("crm:crmContract:edit")
	@RequestMapping(value = "save")
	public String save(CrmContract crmContract, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, crmContract)){
			return form(crmContract, model);
		}
		crmContractService.save(crmContract);
		addMessage(redirectAttributes, "保存合同成功");
		return "redirect:"+Global.getAdminPath()+"/crm/crmContract/?repage";
	}
	
	@RequiresPermissions("crm:crmContract:edit")
	@RequestMapping(value = "delete")
	public String delete(CrmContract crmContract, RedirectAttributes redirectAttributes) {
		crmContractService.delete(crmContract);
		addMessage(redirectAttributes, "删除合同成功");
		return "redirect:"+Global.getAdminPath()+"/crm/crmContract/?repage";
	}

}