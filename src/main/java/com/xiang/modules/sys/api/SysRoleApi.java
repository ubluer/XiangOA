/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.xiang.modules.sys.api;

import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.sys.dao.RoleDao;
import com.thinkgem.jeesite.modules.sys.entity.Role;
import com.thinkgem.jeesite.modules.sys.service.SystemService;
import com.xiang.modules.common.api.BaseApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 工程项目Controller
 *
 * @author xiang
 * @version 2017-06-06
 */
@Controller
@RequestMapping(value = "${apiPath}/sys/sysRole")
public class SysRoleApi extends BaseApi<RoleDao,Role> {

    private final SystemService systemService;

    @Autowired
    public SysRoleApi(SystemService systemService) {
        this.systemService = systemService;
    }

    @Override
    protected CrudService<RoleDao, Role> getCrudService() {
        return null;
    }

    @Override
    protected Class<Role> getEntityClass() {
        return Role.class;
    }

}