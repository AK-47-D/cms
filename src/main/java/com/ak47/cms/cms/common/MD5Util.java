package com.ak47.cms.cms.common;

import org.apache.commons.codec.binary.Hex;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {

    public static String md5(String source){
        try {
            MessageDigest md  = MessageDigest.getInstance("MD5");
            byte[] md5Bytes = md.digest(source.getBytes());
            return Hex.encodeHexString(md5Bytes);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("md5加密失败");
        }
    }
}
