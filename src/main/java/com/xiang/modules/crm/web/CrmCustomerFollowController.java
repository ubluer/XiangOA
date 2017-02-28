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
import com.xiang.modules.crm.entity.CrmCustomerFollow;
import com.xiang.modules.crm.service.CrmCustomerFollowService;

/**
 * 跟进记录管理Controller
 * @author Xiang
 * @version 2017-02-28
 */
@Controller
@RequestMapping(value = "${adminPath}/crm/crmCustomerFollow")
public class CrmCustomerFollowController extends BaseController {

	@Autowired
	private CrmCustomerFollowService crmCustomerFollowService;
	
	@ModelAttribute
	public CrmCustomerFollow get(@RequestParam(required=false) String id) {
		CrmCustomerFollow entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = crmCustomerFollowService.get(id);
		}
		if (entity == null){
			entity = new CrmCustomerFollow();
		}
		return entity;
	}
	
	@RequiresPermissions("crm:crmCustomerFollow:view")
	@RequestMapping(value = {"list", ""})
	public String list(CrmCustomerFollow crmCustomerFollow, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<CrmCustomerFollow> page = crmCustomerFollowService.findPage(new Page<CrmCustomerFollow>(request, response), crmCustomerFollow); 
		model.addAttribute("page", page);
		return "modules/crm/crmCustomerFollowList";
	}

	@RequiresPermissions("crm:crmCustomerFollow:view")
	@RequestMapping(value = "form")
	public String form(CrmCustomerFollow crmCustomerFollow, Model model) {
		model.addAttribute("crmCustomerFollow", crmCustomerFollow);
		return "modules/crm/crmCustomerFollowForm";
	}

	@RequiresPermissions("crm:crmCustomerFollow:edit")
	@RequestMapping(value = "save")
	public String save(CrmCustomerFollow crmCustomerFollow, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, crmCustomerFollow)){
			return form(crmCustomerFollow, model);
		}
		crmCustomerFollowService.save(crmCustomerFollow);
		addMessage(redirectAttributes, "保存跟进记录成功");
		return "redirect:"+Global.getAdminPath()+"/crm/crmCustomerFollow/?repage";
	}
	
	@RequiresPermissions("crm:crmCustomerFollow:edit")
	@RequestMapping(value = "delete")
	public String delete(CrmCustomerFollow crmCustomerFollow, RedirectAttributes redirectAttributes) {
		crmCustomerFollowService.delete(crmCustomerFollow);
		addMessage(redirectAttributes, "删除跟进记录成功");
		return "redirect:"+Global.getAdminPath()+"/crm/crmCustomerFollow/?repage";
	}

}