package com.sy.mobileback.web.controller;

import com.sy.mobileback.framework.jwt.annotations.JwtIgnore;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author shiyu
 * @Description
 * @create 2019-03-24 14:58
 */
@Controller
public class LoginController {

    @JwtIgnore
    @PostMapping("/login")
    @ResponseBody
    public String ajaxLogin() {
        return null;
    }

//    @JwtIgnore
    @GetMapping("/test")
    @ResponseBody
    public String test() {
        return "测试 jwt";
    }

}
