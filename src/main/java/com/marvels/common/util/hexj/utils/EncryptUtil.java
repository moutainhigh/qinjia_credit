package com.marvels.common.util.hexj.utils;

/**
 * @author liuhongbin
 * @date 2016/5/19
 * @description: 加解密工具类
 **/
public class EncryptUtil {
    /**
     * MD5加密，和IOS保持一致
     * @param md
     * @return
     */
    public static String MD5(byte[] md) {
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            return null;
        }
    }

    
}
