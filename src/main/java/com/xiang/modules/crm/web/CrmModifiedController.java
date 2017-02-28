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
import com.xiang.modules.crm.entity.CrmModified;
import com.xiang.modules.crm.service.CrmModifiedService;

/**
 * 修改记录管理Controller
 * @author Xiang
 * @version 2017-02-28
 */
@Controller
@RequestMapping(value = "${adminPath}/crm/crmModified")
public class CrmModifiedController extends BaseController {

	@Autowired
	private CrmModifiedService crmModifiedService;
	
	@ModelAttribute
	public CrmModified get(@RequestParam(required=false) String id) {
		CrmModified entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = crmModifiedService.get(id);
		}
		if (entity == null){
			entity = new CrmModified();
		}
		return entity;
	}
	
	@RequiresPermissions("crm:crmModified:view")
	@RequestMapping(value = {"list", ""})
	public String list(CrmModified crmModified, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<CrmModified> page = crmModifiedService.findPage(new Page<CrmModified>(request, response), crmModified); 
		model.addAttribute("page", page);
		return "modules/crm/crmModifiedList";
	}

	@RequiresPermissions("crm:crmModified:view")
	@RequestMapping(value = "form")
	public String form(CrmModified crmModified, Model model) {
		model.addAttribute("crmModified", crmModified);
		return "modules/crm/crmModifiedForm";
	}

	@RequiresPermissions("crm:crmModified:edit")
	@RequestMapping(value = "save")
	public String save(CrmModified crmModified, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, crmModified)){
			return form(crmModified, model);
		}
		crmModifiedService.save(crmModified);
		addMessage(redirectAttributes, "保存修改记录成功");
		return "redirect:"+Global.getAdminPath()+"/crm/crmModified/?repage";
	}
	
	@RequiresPermissions("crm:crmModified:edit")
	@RequestMapping(value = "delete")
	public String delete(CrmModified crmModified, RedirectAttributes redirectAttributes) {
		crmModifiedService.delete(crmModified);
		addMessage(redirectAttributes, "删除修改记录成功");
		return "redirect:"+Global.getAdminPath()+"/crm/crmModified/?repage";
	}

}