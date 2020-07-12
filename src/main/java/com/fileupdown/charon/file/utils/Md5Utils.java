package com.fileupdown.charon.file.utils;

import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @program: FileUpDown
 * @description 用Md5对于数据库密码进行加密处理
 * @author: charon
 * @create: 2020-07-07 22:43
 **/
public class Md5Utils {

    /**
     * 用MD5进行加密
     * @param str 输入的字符串
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     */
    public String EncoderByMd5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        //确定计算方法
        MessageDigest md5=MessageDigest.getInstance("MD5");
        BASE64Encoder base64en = new BASE64Encoder();
        //加密后的字符串
        String newstr=base64en.encode(md5.digest(str.getBytes("utf-8")));
        return newstr;
    }


    /**
     * 断用户密码是否正确
     * @param inPass 用户输入的密码
     * @param truePass 正确密码
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     */
    public boolean checkpassword(String inPass,String truePass) throws NoSuchAlgorithmException, UnsupportedEncodingException{
        if(EncoderByMd5(inPass).equals(truePass)){
            return true;
        }
        else{
            return false;
        }

    }

}
