/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.xiang.modules.erp.api;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.mapper.JsonMapper;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.common.web.BaseController;
import com.xiang.modules.common.api.BaseApi;
import com.xiang.modules.common.api.vo.ResponseJson;
import com.xiang.modules.erp.dao.ErpProjectDao;
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
 *
 * @author xiang
 * @version 2017-06-06
 */
@Controller
@RequestMapping(value = "${apiPath}/erp/erpProject")
public class ErpProjectApi extends BaseApi<ErpProjectDao,ErpProject> {

    private final ErpProjectService erpProjectService;

    @Autowired
    public ErpProjectApi(ErpProjectService erpProjectService) {
        this.erpProjectService = erpProjectService;
    }

    @Override
    protected CrudService<ErpProjectDao, ErpProject> getCrudService() {
        return erpProjectService;
    }

    @Override
    protected Class<ErpProject> getEntityClass() {
        return ErpProject.class;
    }
}