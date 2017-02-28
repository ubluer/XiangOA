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
import com.xiang.modules.crm.entity.CrmContractPayback;
import com.xiang.modules.crm.service.CrmContractPaybackService;

/**
 * 合同回款记录管理Controller
 * @author Xiang
 * @version 2017-02-28
 */
@Controller
@RequestMapping(value = "${adminPath}/crm/crmContractPayback")
public class CrmContractPaybackController extends BaseController {

	@Autowired
	private CrmContractPaybackService crmContractPaybackService;
	
	@ModelAttribute
	public CrmContractPayback get(@RequestParam(required=false) String id) {
		CrmContractPayback entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = crmContractPaybackService.get(id);
		}
		if (entity == null){
			entity = new CrmContractPayback();
		}
		return entity;
	}
	
	@RequiresPermissions("crm:crmContractPayback:view")
	@RequestMapping(value = {"list", ""})
	public String list(CrmContractPayback crmContractPayback, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<CrmContractPayback> page = crmContractPaybackService.findPage(new Page<CrmContractPayback>(request, response), crmContractPayback); 
		model.addAttribute("page", page);
		return "modules/crm/crmContractPaybackList";
	}

	@RequiresPermissions("crm:crmContractPayback:view")
	@RequestMapping(value = "form")
	public String form(CrmContractPayback crmContractPayback, Model model) {
		model.addAttribute("crmContractPayback", crmContractPayback);
		return "modules/crm/crmContractPaybackForm";
	}

	@RequiresPermissions("crm:crmContractPayback:edit")
	@RequestMapping(value = "save")
	public String save(CrmContractPayback crmContractPayback, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, crmContractPayback)){
			return form(crmContractPayback, model);
		}
		crmContractPaybackService.save(crmContractPayback);
		addMessage(redirectAttributes, "保存回款记录成功");
		return "redirect:"+Global.getAdminPath()+"/crm/crmContractPayback/?repage";
	}
	
	@RequiresPermissions("crm:crmContractPayback:edit")
	@RequestMapping(value = "delete")
	public String delete(CrmContractPayback crmContractPayback, RedirectAttributes redirectAttributes) {
		crmContractPaybackService.delete(crmContractPayback);
		addMessage(redirectAttributes, "删除回款记录成功");
		return "redirect:"+Global.getAdminPath()+"/crm/crmContractPayback/?repage";
	}

}