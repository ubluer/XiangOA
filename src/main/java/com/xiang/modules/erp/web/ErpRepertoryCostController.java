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
import com.xiang.modules.erp.entity.ErpRepertoryCost;
import com.xiang.modules.erp.service.ErpRepertoryCostService;

/**
 * 项目库存消费Controller
 * @author xiang
 * @version 2017-06-05
 */
@Controller
@RequestMapping(value = "${adminPath}/erp/erpRepertoryCost")
public class ErpRepertoryCostController extends BaseController {

	@Autowired
	private ErpRepertoryCostService erpRepertoryCostService;
	
	@ModelAttribute
	public ErpRepertoryCost get(@RequestParam(required=false) String id) {
		ErpRepertoryCost entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = erpRepertoryCostService.get(id);
		}
		if (entity == null){
			entity = new ErpRepertoryCost();
		}
		return entity;
	}
	
	@RequiresPermissions("erp:erpRepertoryCost:view")
	@RequestMapping(value = {"list", ""})
	public String list(ErpRepertoryCost erpRepertoryCost, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<ErpRepertoryCost> page = erpRepertoryCostService.findPage(new Page<ErpRepertoryCost>(request, response), erpRepertoryCost); 
		model.addAttribute("page", page);
		return "modules/erp/erpRepertoryCostList";
	}

	@RequiresPermissions("erp:erpRepertoryCost:view")
	@RequestMapping(value = "form")
	public String form(ErpRepertoryCost erpRepertoryCost, Model model) {
		model.addAttribute("erpRepertoryCost", erpRepertoryCost);
		return "modules/erp/erpRepertoryCostForm";
	}

	@RequiresPermissions("erp:erpRepertoryCost:edit")
	@RequestMapping(value = "save")
	public String save(ErpRepertoryCost erpRepertoryCost, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, erpRepertoryCost)){
			return form(erpRepertoryCost, model);
		}
		erpRepertoryCostService.save(erpRepertoryCost);
		addMessage(redirectAttributes, "保存库存消费成功");
		return "redirect:"+Global.getAdminPath()+"/erp/erpRepertoryCost/?repage";
	}
	
	@RequiresPermissions("erp:erpRepertoryCost:edit")
	@RequestMapping(value = "delete")
	public String delete(ErpRepertoryCost erpRepertoryCost, RedirectAttributes redirectAttributes) {
		erpRepertoryCostService.delete(erpRepertoryCost);
		addMessage(redirectAttributes, "删除库存消费成功");
		return "redirect:"+Global.getAdminPath()+"/erp/erpRepertoryCost/?repage";
	}

}