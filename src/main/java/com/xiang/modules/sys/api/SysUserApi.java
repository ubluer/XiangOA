/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.xiang.modules.sys.api;

import com.thinkgem.jeesite.common.mapper.JsonMapper;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.sys.dao.UserDao;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.sys.service.SystemService;
import com.xiang.modules.common.api.BaseApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 工程项目Controller
 *
 * @author xiang
 * @version 2017-06-06
 */
@Controller
@RequestMapping(value = "${apiPath}/sys/sysUser")
public class SysUserApi extends BaseApi<UserDao,User> {

    private final SystemService systemService;

    @Autowired
    public SysUserApi(SystemService systemService) {
        this.systemService = systemService;
    }

    @Override
    protected CrudService<UserDao, User> getCrudService() {
        return null;
    }

    @Override
    protected Class<User> getEntityClass() {
        return User.class;
    }

    @RequestMapping(value = {"list", ""})
    @ResponseBody
    @Override
    public String list(HttpServletRequest request, HttpServletResponse response) throws IllegalAccessException, InstantiationException {
        String query = request.getParameter("query");
        User queryObj = (User) JsonMapper.fromJsonString(query, getEntityClass());
        if(queryObj==null){
            queryObj=new User();
        }
        Page<User> page = systemService.findUser(new Page<>(request, response), queryObj);
        return success(page.getList());
    }

    @RequestMapping(value = "form")
    @ResponseBody
    @Override
    public String form(String id) {
        return success(systemService.getUser(id));
    }

}