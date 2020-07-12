package com.fileupdown.charon.file.service;

import com.fileupdown.charon.file.entity.User;
import com.fileupdown.charon.file.entity.UserFile;

import java.util.List;

/**
 * @program: FileUpDown
 * @description 用户文件业务逻辑层接口
 * @author: charon
 * @create: 2020-07-09 22:30
 **/
public interface UserFileService {
    List<UserFile> findByUserId(int userId);

    void save(UserFile userFile);

    UserFile findById(String id);

    void update(UserFile userFile);

    void delete(String id);
}
