package com.xiang.modules.sys.api;

import com.thinkgem.jeesite.common.security.shiro.session.SessionDAO;
import com.thinkgem.jeesite.modules.sys.security.FormAuthenticationFilter;
import com.thinkgem.jeesite.modules.sys.security.SystemAuthorizingRealm.Principal;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;
import com.xiang.modules.common.api.BaseApi;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
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
        //判断是否已登录
        Principal exist = UserUtils.getPrincipal();
        if(exist==null) {
            Subject currentUser = SecurityUtils.getSubject();

            AuthenticationToken token = new FormAuthenticationFilter().createToken(request, response);
            try {
                currentUser.login(token);
            } catch (AuthenticationException e) {
                request.setAttribute("message", e);
                model.addAttribute("msg", "登录失败");
            }
            exist = UserUtils.getPrincipal();
        }
        if (exist != null) {
            model.addAttribute("token", exist);
        }
        return renderString(response,model);
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
