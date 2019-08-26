package com.aaa.lee.sso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2019/8/26 22:43
 * @Description
 **/
@Controller
public class LoginController {

    @RequestMapping("/")
    public String turnIndexPage() {
        return "index";
    }

    @RequestMapping("/buyIphone")
    public String turnBuyPage() {
        return "buy_iphone";
    }

}
