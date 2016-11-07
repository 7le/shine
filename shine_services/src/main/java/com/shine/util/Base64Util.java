package com.shine.util;

import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;

/**
 * Created by hq on 2016/7/13 0013.
 */
public class Base64Util {
    public static String Base64(byte[] str) {
//        byte[] b = null;
        String s = null;
//        try {
//            b = str.getBytes("utf-8");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
        if (str != null) {
            s = new BASE64Encoder().encode(str);
        }
        return s;
    }
}
