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
import com.xiang.modules.crm.entity.CrmCustomerFollower;
import com.xiang.modules.crm.service.CrmCustomerFollowerService;

/**
 * 跟进人管理Controller
 * @author Xiang
 * @version 2017-02-28
 */
@Controller
@RequestMapping(value = "${adminPath}/crm/crmCustomerFollower")
public class CrmCustomerFollowerController extends BaseController {

	@Autowired
	private CrmCustomerFollowerService crmCustomerFollowerService;
	
	@ModelAttribute
	public CrmCustomerFollower get(@RequestParam(required=false) String id) {
		CrmCustomerFollower entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = crmCustomerFollowerService.get(id);
		}
		if (entity == null){
			entity = new CrmCustomerFollower();
		}
		return entity;
	}
	
	@RequiresPermissions("crm:crmCustomerFollower:view")
	@RequestMapping(value = {"list", ""})
	public String list(CrmCustomerFollower crmCustomerFollower, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<CrmCustomerFollower> page = crmCustomerFollowerService.findPage(new Page<CrmCustomerFollower>(request, response), crmCustomerFollower); 
		model.addAttribute("page", page);
		return "modules/crm/crmCustomerFollowerList";
	}

	@RequiresPermissions("crm:crmCustomerFollower:view")
	@RequestMapping(value = "form")
	public String form(CrmCustomerFollower crmCustomerFollower, Model model) {
		model.addAttribute("crmCustomerFollower", crmCustomerFollower);
		return "modules/crm/crmCustomerFollowerForm";
	}

	@RequiresPermissions("crm:crmCustomerFollower:edit")
	@RequestMapping(value = "save")
	public String save(CrmCustomerFollower crmCustomerFollower, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, crmCustomerFollower)){
			return form(crmCustomerFollower, model);
		}
		crmCustomerFollowerService.save(crmCustomerFollower);
		addMessage(redirectAttributes, "保存跟进人成功");
		return "redirect:"+Global.getAdminPath()+"/crm/crmCustomerFollower/?repage";
	}
	
	@RequiresPermissions("crm:crmCustomerFollower:edit")
	@RequestMapping(value = "delete")
	public String delete(CrmCustomerFollower crmCustomerFollower, RedirectAttributes redirectAttributes) {
		crmCustomerFollowerService.delete(crmCustomerFollower);
		addMessage(redirectAttributes, "删除跟进人成功");
		return "redirect:"+Global.getAdminPath()+"/crm/crmCustomerFollower/?repage";
	}

}