package com.fileupdown.charon.file.service.impl;

import com.fileupdown.charon.file.dao.UserFileDao;
import com.fileupdown.charon.file.entity.User;
import com.fileupdown.charon.file.entity.UserFile;
import com.fileupdown.charon.file.service.UserFileService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @program: FileUpDown
 * @description 用户文件逻辑层实现
 * @author: charon
 * @create: 2020-07-09 22:31
 **/
@Service
public class UserFileServiceimpl implements UserFileService {

    @Resource
    UserFileDao userFileDao;

    /**
     * 根据Id获取文件
     * @param userId
     * @return
     */
    @Override
    public List<UserFile> findByUserId(int userId) {
        return userFileDao.findByUserId(userId);
    }

    /**
     * 保存文件
     * @param userFile 文件
     */
    @Override
    public void save(UserFile userFile) {
        String isImg = userFile.getType().startsWith("image")?"是":"否";
        userFile.setIsImg(isImg);
        userFile.setDowncounts(0);
        userFile.setUploadTime(new Date());
        userFileDao.saveFile(userFile);
    }

    @Override
    public UserFile findById(String id) {
        return  userFileDao.findById(id);
    }

    @Override
    public void update(UserFile userFile) {
         userFileDao.update(userFile);
    }

    @Override
    public void delete(String id) {
        userFileDao.delete(id);
    }
}
