package com.fileupdown.charon.file.service.impl;

import com.fileupdown.charon.file.dao.UserDao;
import com.fileupdown.charon.file.entity.User;
import com.fileupdown.charon.file.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @program: FileUpDown
 * @description 用户逻辑层实现
 * @author: charon
 * @create: 2020-07-07 23:20
 **/
@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserDao userDao;

    /**
     * 用户登录
     * @param userName 用户名
     * @return
     */
    @Override
    public User login(String userName) {
        return userDao.login(userName);
    }
}
