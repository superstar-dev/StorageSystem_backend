package com.dc.backend.util.encrypt.md5;

import java.security.MessageDigest;

import static com.dc.backend.util.encrypt.extra.EncryptionUtil.byteToHex;

public class MD5Util {
    /**
     * 对字符串进行md5加密
     *
     * @param str
     * @return
     */
    public static String encrypt(String str) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            return byteToHex(md.digest());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static void main(String[] args) {
        String content = "xyz";
        String s = encrypt(content);
        System.out.println(s);
    }

}
