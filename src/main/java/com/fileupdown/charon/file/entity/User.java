package com.fileupdown.charon.file.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @program: FileUpDown
 * @description 用户表
 * @author: charon
 * @create: 2020-07-07 22:54
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class User {
    private int id;
    private String userName;
    private String passWord;
}
