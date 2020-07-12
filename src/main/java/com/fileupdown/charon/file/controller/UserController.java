package com.fileupdown.charon.file.controller;

import com.fileupdown.charon.file.entity.User;
import com.fileupdown.charon.file.service.UserService;
import com.fileupdown.charon.file.utils.Md5Utils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Logger;

/**
 * @program: FileUpDown
 * @description 用户表现层
 * @author: charon
 * @create: 2020-07-07 23:24
 **/
@Controller
@RequestMapping("user")
@Slf4j
public class UserController {

    @Resource
    UserService userService;

    /**
     * 用户登录
     * @param user 登录用户
     * @return
     */
    @PostMapping("/login")
    public String login(User user,HttpSession session){
        User userDB = userService.login(user.getUserName());
        if(StringUtils.isNotBlank(userDB.getPassWord())){
            Md5Utils md5Utils = new Md5Utils();
            try {
                if(md5Utils.checkpassword(user.getPassWord(),userDB.getPassWord())){
                    session.setAttribute("user",userDB);
                    return "redirect:/file/findAll";
                }
            } catch (NoSuchAlgorithmException e) {
                log.error(e.getMessage());
            } catch (UnsupportedEncodingException e) {
                log.error(e.getMessage());
            }
        }
        return "redirect:/index";
    }
}
