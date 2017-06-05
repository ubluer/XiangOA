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
import com.xiang.modules.erp.entity.ErpRepertory;
import com.xiang.modules.erp.service.ErpRepertoryService;

/**
 * 项目库存管理Controller
 * @author xiang
 * @version 2017-06-05
 */
@Controller
@RequestMapping(value = "${adminPath}/erp/erpRepertory")
public class ErpRepertoryController extends BaseController {

	@Autowired
	private ErpRepertoryService erpRepertoryService;
	
	@ModelAttribute
	public ErpRepertory get(@RequestParam(required=false) String id) {
		ErpRepertory entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = erpRepertoryService.get(id);
		}
		if (entity == null){
			entity = new ErpRepertory();
		}
		return entity;
	}
	
	@RequiresPermissions("erp:erpRepertory:view")
	@RequestMapping(value = {"list", ""})
	public String list(ErpRepertory erpRepertory, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<ErpRepertory> page = erpRepertoryService.findPage(new Page<ErpRepertory>(request, response), erpRepertory); 
		model.addAttribute("page", page);
		return "modules/erp/erpRepertoryList";
	}

	@RequiresPermissions("erp:erpRepertory:view")
	@RequestMapping(value = "form")
	public String form(ErpRepertory erpRepertory, Model model) {
		model.addAttribute("erpRepertory", erpRepertory);
		return "modules/erp/erpRepertoryForm";
	}

	@RequiresPermissions("erp:erpRepertory:edit")
	@RequestMapping(value = "save")
	public String save(ErpRepertory erpRepertory, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, erpRepertory)){
			return form(erpRepertory, model);
		}
		erpRepertoryService.save(erpRepertory);
		addMessage(redirectAttributes, "保存项目库存成功");
		return "redirect:"+Global.getAdminPath()+"/erp/erpRepertory/?repage";
	}
	
	@RequiresPermissions("erp:erpRepertory:edit")
	@RequestMapping(value = "delete")
	public String delete(ErpRepertory erpRepertory, RedirectAttributes redirectAttributes) {
		erpRepertoryService.delete(erpRepertory);
		addMessage(redirectAttributes, "删除项目库存成功");
		return "redirect:"+Global.getAdminPath()+"/erp/erpRepertory/?repage";
	}

}