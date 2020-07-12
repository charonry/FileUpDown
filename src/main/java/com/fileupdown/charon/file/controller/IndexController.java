package com.fileupdown.charon.file.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @program: FileUpDown
 * @description 项目启动登录进入第一个接口进入登录页面
 * @author: charon
 * @create: 2020-07-07 23:48
 **/
@Controller
public class IndexController {

    /**
     * 进入登录页面
     * @return
     */
    @GetMapping("/index")
    public String toLogin(){
        return "login";
    }
}
