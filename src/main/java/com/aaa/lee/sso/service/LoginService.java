package com.aaa.lee.sso.service;

import com.aaa.lee.sso.utils.HttpClientUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2019/8/26 22:39
 * @Description
 **/
@Service
public class LoginService {

    @Value("${sso_base_url}")
    public String baseUrl;
    @Value("${sso_access_path}")
    public String accessPath;
    @Value("${sso_access_login_path}")
    public String accessLoginPath;
    @Value("${sso_login_param}")
    public String loginParam;

    public String chekLogin(String cookieValie) {
        return HttpClientUtil.doGet(baseUrl+accessPath+cookieValie);
    }

}
