package com.xiang.modules.common.api;

import com.thinkgem.jeesite.common.mapper.JsonMapper;
import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.DataEntity;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.common.web.BaseController;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Xiang.Yu
 * @version 0.0.1
 * @date 2017/3/15
 * @description BaseApi
 */
public abstract class BaseApi<D extends CrudDao<T>, T extends DataEntity<T>> extends BaseController{


    protected abstract CrudService<D,T> getCrudService();
    protected abstract Class<T> getEntityClass();

    @RequestMapping(value = {"list", ""})
    @ResponseBody
    public String list(T entity, HttpServletRequest request, HttpServletResponse response) {
        Page<T> page = getCrudService().findPage(new Page<T>(request, response), entity);
        return JsonMapper.toJsonString(page.getList());
    }

    @RequestMapping(value = "form")
    @ResponseBody
    public String form(String id) {
        return JsonMapper.toJsonString(getCrudService().get(id));
    }

    @RequestMapping(value = "save")
    @ResponseBody
    public String save(HttpServletRequest request,Model model) {
        String entityString = request.getParameter("entity");
        T entity = (T) JsonMapper.fromJsonString(entityString, getEntityClass());
        beanValidator(entity);
        getCrudService().save(entity);
        return "";
    }

    @RequestMapping(value = "delete")
    @ResponseBody
    public String delete(String id) {

        getCrudService().delete(getCrudService().get(id));
        return "";
    }
}
