package com.aaa.lee.sso.interceptor;

import com.aaa.lee.sso.service.LoginService;
import com.aaa.lee.sso.utils.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2019/8/26 23:49
 * @Description
 **/
@Service
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    private LoginService loginService;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        // 1.获取cookie信息
        String cookieValue = CookieUtil.getCookieValue(httpServletRequest, "COOKIE_KEY");
        // 2.判断cookie是否为空
        if (null == cookieValue || "".equals(cookieValue)) {
            // 跳转到登录页面
            httpServletResponse.sendRedirect(loginService.baseUrl + loginService.accessLoginPath + loginService.loginParam + httpServletRequest.getRequestURL());
        } else {
            String token = loginService.chekLogin(cookieValue);
            if (null != token && !"".equals(token)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
