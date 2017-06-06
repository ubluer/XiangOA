/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.xiang.modules.erp.api;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.mapper.JsonMapper;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.common.web.BaseController;
import com.xiang.modules.common.api.vo.ResponseJson;
import com.xiang.modules.erp.entity.ErpProject;
import com.xiang.modules.erp.service.ErpProjectService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 工程项目Controller
 * @author xiang
 * @version 2017-06-06
 */
@Controller
@RequestMapping(value = "${apiPath}/erp/erpProject")
public class ErpProjectApi extends BaseController {

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
	
	@RequestMapping(value = {"list", ""})
    @ResponseBody
	public String list(ErpProject erpProject, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<ErpProject> page = erpProjectService.findPage(new Page<>(request, response), erpProject);
		return JsonMapper.toJsonString(new ResponseJson(page));
	}

	@ResponseBody
	@RequestMapping(value = "form")
	public String form(ErpProject erpProject, Model model) {
	    return JsonMapper.toJsonString(new ResponseJson(erpProject));
	}

	@RequestMapping(value = "save")
    @ResponseBody
	public String save(ErpProject erpProject, Model model, HttpServletRequest request) {
		String entity = request.getParameter("entity");
		erpProject = (ErpProject) JsonMapper.fromJsonString(entity,ErpProject.class);
	    if (!beanValidator(model, erpProject)){
			return form(erpProject, model);
		}
		erpProjectService.save(erpProject);
		return JsonMapper.toJsonString(new ResponseJson(""));
	}
	
	@RequestMapping(value = "delete")
    @ResponseBody
	public String delete(ErpProject erpProject) {
		erpProjectService.delete(erpProject);
		return JsonMapper.toJsonString(new ResponseJson(""));
	}

}