package com.xiang.modules.common.api;

import com.thinkgem.jeesite.common.mapper.JsonMapper;
import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.DataEntity;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.common.web.BaseController;
import com.xiang.modules.common.api.vo.ResponseJson;
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
    public String list(HttpServletRequest request, HttpServletResponse response) throws IllegalAccessException, InstantiationException {
        String query = request.getParameter("query");
        T queryObj = (T) JsonMapper.fromJsonString(query, getEntityClass());
        if(queryObj==null){
            queryObj=getEntityClass().newInstance();
        }
        Page<T> page = getCrudService().findPage(new Page<>(request, response), queryObj);
        return success(page.getList());
    }

    @RequestMapping(value = "form")
    @ResponseBody
    public String form(String id) {
        return success(getCrudService().get(id));
    }

    @RequestMapping(value = "save")
    @ResponseBody
    public String save(HttpServletRequest request,Model model) {
        String entityString = request.getParameter("entity");
        T entity = (T) JsonMapper.fromJsonString(entityString, getEntityClass());
        beanValidator(entity);
        getCrudService().save(entity);
        return success(entity);
    }

    @RequestMapping(value = "delete")
    @ResponseBody
    public String delete(String id) {

        getCrudService().delete(getCrudService().get(id));
        return success(id);
    }

    protected String success(Object obj){
        return JsonMapper.toJsonString(new ResponseJson(obj));
    }

    protected String error(Object obj,String msg){
        return JsonMapper.toJsonString(new ResponseJson(false,obj,msg));
    }

}
