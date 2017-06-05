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
import com.xiang.modules.erp.entity.ErpDaily;
import com.xiang.modules.erp.service.ErpDailyService;

/**
 * 项目日报管理Controller
 * @author xiang
 * @version 2017-06-05
 */
@Controller
@RequestMapping(value = "${adminPath}/erp/erpDaily")
public class ErpDailyController extends BaseController {

	@Autowired
	private ErpDailyService erpDailyService;
	
	@ModelAttribute
	public ErpDaily get(@RequestParam(required=false) String id) {
		ErpDaily entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = erpDailyService.get(id);
		}
		if (entity == null){
			entity = new ErpDaily();
		}
		return entity;
	}
	
	@RequiresPermissions("erp:erpDaily:view")
	@RequestMapping(value = {"list", ""})
	public String list(ErpDaily erpDaily, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<ErpDaily> page = erpDailyService.findPage(new Page<ErpDaily>(request, response), erpDaily); 
		model.addAttribute("page", page);
		return "modules/erp/erpDailyList";
	}

	@RequiresPermissions("erp:erpDaily:view")
	@RequestMapping(value = "form")
	public String form(ErpDaily erpDaily, Model model) {
		model.addAttribute("erpDaily", erpDaily);
		return "modules/erp/erpDailyForm";
	}

	@RequiresPermissions("erp:erpDaily:edit")
	@RequestMapping(value = "save")
	public String save(ErpDaily erpDaily, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, erpDaily)){
			return form(erpDaily, model);
		}
		erpDailyService.save(erpDaily);
		addMessage(redirectAttributes, "保存日报成功");
		return "redirect:"+Global.getAdminPath()+"/erp/erpDaily/?repage";
	}
	
	@RequiresPermissions("erp:erpDaily:edit")
	@RequestMapping(value = "delete")
	public String delete(ErpDaily erpDaily, RedirectAttributes redirectAttributes) {
		erpDailyService.delete(erpDaily);
		addMessage(redirectAttributes, "删除日报成功");
		return "redirect:"+Global.getAdminPath()+"/erp/erpDaily/?repage";
	}

}