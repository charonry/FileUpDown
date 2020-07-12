package com.fileupdown.charon.file.dao;

import com.fileupdown.charon.file.entity.UserFile;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: FileUpDown
 * @description 文件接口
 * @author: charon
 * @create: 2020-07-09 22:23
 **/
public interface UserFileDao {
    /**
     * 根据用户Id获取文件
     * @param userId
     * @return
     */
    List<UserFile> findByUserId(@Param("userId") int userId);

    void saveFile( UserFile userFile);

    UserFile findById(@Param("id") String id);

    void update(UserFile userFile);

    void delete(@Param("id")String id);
}
