package com.xiang.modules.sys.web;

import com.thinkgem.jeesite.common.security.shiro.session.SessionDAO;
import com.thinkgem.jeesite.modules.sys.security.FormAuthenticationFilter;
import com.thinkgem.jeesite.modules.sys.security.SystemAuthorizingRealm.Principal;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;
import com.xiang.modules.common.api.BaseApi;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Xiang.Yu
 * @version 0.0.1
 * @date 2017/3/20
 * @description LoginApi
 */
@Controller
@RequestMapping("${apiPath}")
public class LoginApi extends BaseApi{

    @Autowired
    private SessionDAO sessionDAO;

    @RequestMapping(value = "login")
    public String login(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
        Subject currentUser = SecurityUtils.getSubject();

        boolean mobile = WebUtils.isTrue(request, FormAuthenticationFilter.DEFAULT_MOBILE_PARAM);
        String username = WebUtils.getCleanParam(request, FormAuthenticationFilter.DEFAULT_USERNAME_PARAM);
        String password = WebUtils.getCleanParam(request, FormAuthenticationFilter.DEFAULT_PASSWORD_PARAM);
        boolean rememberMe = WebUtils.isTrue(request, FormAuthenticationFilter.DEFAULT_REMEMBER_ME_PARAM);
        String exception = (String) request.getAttribute(FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME);
        String message = (String) request.getAttribute(FormAuthenticationFilter.DEFAULT_MESSAGE_PARAM);

        AuthenticationToken token = new FormAuthenticationFilter().createToken(request,response);
        currentUser.login(token);
        Principal principal = UserUtils.getPrincipal();
        return renderString(response,principal);
    }


    @RequestMapping(value = "logout")
    public String logout(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
        Principal principal = UserUtils.getPrincipal();
        // 如果已经登录，则跳转到管理首页
        if(principal != null){
            UserUtils.getSubject().logout();
        }
        return "redirect:" + adminPath+"/login";
    }

}
