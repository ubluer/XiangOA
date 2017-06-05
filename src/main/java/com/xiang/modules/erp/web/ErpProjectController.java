/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.xiang.modules.erp.web;

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
import com.xiang.modules.erp.entity.ErpProject;
import com.xiang.modules.erp.service.ErpProjectService;

/**
 * 工程项目Controller
 * @author xiang
 * @version 2017-06-05
 */
@Controller
@RequestMapping(value = "${adminPath}/erp/erpProject")
public class ErpProjectController extends BaseController {

	@Autowired
	private ErpProjectService erpProjectService;
	
	@ModelAttribute
	public ErpProject get(@RequestParam(required=false) String id) {
		ErpProject entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = erpProjectService.get(id);
		}
		if (entity == null){
			entity = new ErpProject();
		}
		return entity;
	}
	
	@RequiresPermissions("erp:erpProject:view")
	@RequestMapping(value = {"list", ""})
	public String list(ErpProject erpProject, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<ErpProject> page = erpProjectService.findPage(new Page<ErpProject>(request, response), erpProject); 
		model.addAttribute("page", page);
		return "modules/erp/erpProjectList";
	}

	@RequiresPermissions("erp:erpProject:view")
	@RequestMapping(value = "form")
	public String form(ErpProject erpProject, Model model) {
		model.addAttribute("erpProject", erpProject);
		return "modules/erp/erpProjectForm";
	}

	@RequiresPermissions("erp:erpProject:edit")
	@RequestMapping(value = "save")
	public String save(ErpProject erpProject, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, erpProject)){
			return form(erpProject, model);
		}
		erpProjectService.save(erpProject);
		addMessage(redirectAttributes, "保存项目成功");
		return "redirect:"+Global.getAdminPath()+"/erp/erpProject/?repage";
	}
	
	@RequiresPermissions("erp:erpProject:edit")
	@RequestMapping(value = "delete")
	public String delete(ErpProject erpProject, RedirectAttributes redirectAttributes) {
		erpProjectService.delete(erpProject);
		addMessage(redirectAttributes, "删除项目成功");
		return "redirect:"+Global.getAdminPath()+"/erp/erpProject/?repage";
	}

}