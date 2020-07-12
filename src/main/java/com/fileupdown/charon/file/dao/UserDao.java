package com.fileupdown.charon.file.dao;

import com.fileupdown.charon.file.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * @program: FileUpDown
 * @description 用户接口
 * @author: charon
 * @create: 2020-07-07 22:55
 **/
public interface UserDao {
    /**
     * 获取密码
     * @param userName 用户名
     * @return
     */
    User login(@Param("userName") String userName);
}
