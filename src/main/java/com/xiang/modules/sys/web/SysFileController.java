/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.xiang.modules.sys.web;

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
import com.xiang.modules.sys.entity.SysFile;
import com.xiang.modules.sys.service.SysFileService;

/**
 * 文件管理Controller
 * @author Xiang
 * @version 2017-02-28
 */
@Controller
@RequestMapping(value = "${adminPath}/sys/sysFile")
public class SysFileController extends BaseController {

	@Autowired
	private SysFileService sysFileService;
	
	@ModelAttribute
	public SysFile get(@RequestParam(required=false) String id) {
		SysFile entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = sysFileService.get(id);
		}
		if (entity == null){
			entity = new SysFile();
		}
		return entity;
	}
	
	@RequiresPermissions("sys:sysFile:view")
	@RequestMapping(value = {"list", ""})
	public String list(SysFile sysFile, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<SysFile> page = sysFileService.findPage(new Page<SysFile>(request, response), sysFile); 
		model.addAttribute("page", page);
		return "modules/sys/sysFileList";
	}

	@RequiresPermissions("sys:sysFile:view")
	@RequestMapping(value = "form")
	public String form(SysFile sysFile, Model model) {
		model.addAttribute("sysFile", sysFile);
		return "modules/sys/sysFileForm";
	}

	@RequiresPermissions("sys:sysFile:edit")
	@RequestMapping(value = "save")
	public String save(SysFile sysFile, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, sysFile)){
			return form(sysFile, model);
		}
		sysFileService.save(sysFile);
		addMessage(redirectAttributes, "保存文件成功");
		return "redirect:"+Global.getAdminPath()+"/sys/sysFile/?repage";
	}
	
	@RequiresPermissions("sys:sysFile:edit")
	@RequestMapping(value = "delete")
	public String delete(SysFile sysFile, RedirectAttributes redirectAttributes) {
		sysFileService.delete(sysFile);
		addMessage(redirectAttributes, "删除文件成功");
		return "redirect:"+Global.getAdminPath()+"/sys/sysFile/?repage";
	}

}