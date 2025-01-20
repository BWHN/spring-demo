package org.example.weiyuntong.xintong.util;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author: cyg
 * @Date: 2024年8月31日
 */
public class CommonUtil {

    /**
     * 3位随机数
     */
    public static String randomDigist3() {
        return String.valueOf((int) ((Math.random() * 9 + 1) * 100));
    }

    /**
     * 4位随机数
     */
    public static String randomDigist4() {
        return String.valueOf((int) ((Math.random() * 9 + 1) * 1000));
    }

    /**
     * 5位随机数
     */
    public static String randomDigist5() {
        return String.valueOf((int) ((Math.random() * 9 + 1) * 10000));
    }

    /**
     * 6位随机数
     */
    public static String randomDigist6() {
        return String.valueOf((int) ((Math.random() * 9 + 1) * 100000));
    }

    /**
     * MD5 加密
     */
    public static String encryptMD5(String source) {
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(source.getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        byte[] byteArray = messageDigest.digest();
        StringBuffer md5StrBuff = new StringBuffer();
        for (int i = 0; i < byteArray.length; i++) {
            if (Integer.toHexString(0xFF & byteArray[i]).length() == 1) {
                md5StrBuff.append("0").append(Integer.toHexString(0xFF & byteArray[i]));
            } else {
                md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));
            }
        }
        return md5StrBuff.toString();
    }


    /**
     * 对象转Map
     *
     * @param obj
     * @return
     * @throws IllegalAccessException
     */
    public static Map<String, Object> objectToMap(Object obj) {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        Class<?> clazz = obj.getClass();
        //System.out.println(clazz);
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            String fieldName = field.getName();
            Object value = null;
            try {
                value = field.get(obj);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            if (value == null) {
                value = "";
            }
            map.put(fieldName, value);
        }
        return map;
    }

    public static void main(String[] args) {

    }
}
