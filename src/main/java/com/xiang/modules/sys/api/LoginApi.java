package com.xiang.modules.sys.api;

import com.thinkgem.jeesite.common.mapper.JsonMapper;
import com.thinkgem.jeesite.common.utils.CookieUtils;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.sys.security.FormAuthenticationFilter;
import com.thinkgem.jeesite.modules.sys.security.SystemAuthorizingRealm.Principal;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;
import com.xiang.modules.common.api.vo.ResponseJson;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;

/**
 * @author Xiang.Yu
 * @version 0.0.1
 * @date 2017/3/20
 * @description LoginApi
 */
@Controller
@RequestMapping("${apiPath}")
public class LoginApi extends BaseController {

    @RequestMapping(value = "login")
    @ResponseBody
    public String login(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
        ResponseJson json = new ResponseJson("");
        Subject currentUser = SecurityUtils.getSubject();
        //判断是否已登录
        Principal exist = UserUtils.getPrincipal();
        if (exist == null) {

            AuthenticationToken token = new FormAuthenticationFilter().createToken(request, response);
            try {
                currentUser.login(token);
            } catch (AuthenticationException e) {
                json.setSuccess(false);
            }
            exist = UserUtils.getPrincipal();
        }
        if (exist != null) {
            json.setObj(exist);
        }else {
            json.setSuccess(false);
            json.setMsg("登录失败，用户名密码有误");
        }
        return JsonMapper.toJsonString(json);
    }

    @RequestMapping(value = "logout")
    @ResponseBody
    public String logout(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
        Principal principal = UserUtils.getPrincipal();
        // 如果已经登录，则跳转到管理首页
        if (principal != null) {
            UserUtils.getSubject().logout();
        }
        return JsonMapper.toJsonString(new ResponseJson("注销成功"));
    }

}
