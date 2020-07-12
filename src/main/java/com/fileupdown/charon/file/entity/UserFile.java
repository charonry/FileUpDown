package com.fileupdown.charon.file.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @program: FileUpDown
 * @description 文件表
 * @author: charon
 * @create: 2020-07-09 22:18
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class UserFile {
    private int id;
    private String oldFileName;
    private String newFileName;
    private String ext;
    private String path;
    private String size;
    private String type;
    private String isImg;
    private int downcounts;
    private Date uploadTime;
    private int userId;

}
