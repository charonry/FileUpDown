package com.fileupdown.charon;


import com.fileupdown.charon.file.utils.Md5Utils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * @program: FileUpDown
 * @description
 * @author: charon
 * @create: 2020-07-07 22:48
 **/
@Slf4j
@SpringBootTest
public class Md5Test {

    @Test
    public void getMD5PassWord() throws UnsupportedEncodingException, NoSuchAlgorithmException {
        Md5Utils md5Utils = new Md5Utils();
        String admin = md5Utils.EncoderByMd5("admin");
        System.out.println(admin);
        boolean checkpassword = md5Utils.checkpassword("admin", "ISMvKXpXpadDiUoOSoAfww==");
        System.out.println(checkpassword);
    }
}
