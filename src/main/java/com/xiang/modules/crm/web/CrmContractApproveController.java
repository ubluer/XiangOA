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
import com.xiang.modules.crm.entity.CrmContractApprove;
import com.xiang.modules.crm.service.CrmContractApproveService;

/**
 * 成交记录管理Controller
 * @author Xiang
 * @version 2017-02-28
 */
@Controller
@RequestMapping(value = "${adminPath}/crm/crmContractApprove")
public class CrmContractApproveController extends BaseController {

	@Autowired
	private CrmContractApproveService crmContractApproveService;
	
	@ModelAttribute
	public CrmContractApprove get(@RequestParam(required=false) String id) {
		CrmContractApprove entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = crmContractApproveService.get(id);
		}
		if (entity == null){
			entity = new CrmContractApprove();
		}
		return entity;
	}
	
	@RequiresPermissions("crm:crmContractApprove:view")
	@RequestMapping(value = {"list", ""})
	public String list(CrmContractApprove crmContractApprove, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<CrmContractApprove> page = crmContractApproveService.findPage(new Page<CrmContractApprove>(request, response), crmContractApprove); 
		model.addAttribute("page", page);
		return "modules/crm/crmContractApproveList";
	}

	@RequiresPermissions("crm:crmContractApprove:view")
	@RequestMapping(value = "form")
	public String form(CrmContractApprove crmContractApprove, Model model) {
		model.addAttribute("crmContractApprove", crmContractApprove);
		return "modules/crm/crmContractApproveForm";
	}

	@RequiresPermissions("crm:crmContractApprove:edit")
	@RequestMapping(value = "save")
	public String save(CrmContractApprove crmContractApprove, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, crmContractApprove)){
			return form(crmContractApprove, model);
		}
		crmContractApproveService.save(crmContractApprove);
		addMessage(redirectAttributes, "保存成交记录成功");
		return "redirect:"+Global.getAdminPath()+"/crm/crmContractApprove/?repage";
	}
	
	@RequiresPermissions("crm:crmContractApprove:edit")
	@RequestMapping(value = "delete")
	public String delete(CrmContractApprove crmContractApprove, RedirectAttributes redirectAttributes) {
		crmContractApproveService.delete(crmContractApprove);
		addMessage(redirectAttributes, "删除成交记录成功");
		return "redirect:"+Global.getAdminPath()+"/crm/crmContractApprove/?repage";
	}

}