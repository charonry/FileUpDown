package com.fileupdown.charon.file.service;

import com.fileupdown.charon.file.entity.User;

/**
 * @program: FileUpDown
 * @description 用户业务逻辑层接口
 * @author: charon
 * @create: 2020-07-07 23:19
 **/
public interface UserService {
    User login(String userName);
}
