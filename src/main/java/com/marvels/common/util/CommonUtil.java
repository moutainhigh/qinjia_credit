package com.marvels.common.util;

/**
 * 工具类
 * @author houyl
 * @date 2019/10/11 10:37
 */
public class CommonUtil {

    /**
     * 参数是否为空（字符串去空格）
     * @param objs 参数
     * @return 为空返回 true
     */
    public static boolean validEmpty(Object... objs) {
        if(objs == null) {
            return true;
        }

        for(Object obj : objs) {
            if(obj instanceof String) {
                String objStr = (String)obj;
                if(objStr != null && "".equals(objStr.trim())) {
                    return false;
                }
            }else {
                if(obj != null) {
                    return false;
                }
            }
        }

        return true;
    }
}
