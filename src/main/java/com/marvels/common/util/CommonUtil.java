package com.marvels.common.util;

import com.marvels.dto.jf.JfRequestDto;
import com.marvels.dto.jf.JfResponseDto;

import java.util.ArrayList;
import java.util.List;

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

        boolean result = false;
        for(Object obj : objs) {
            if(result) {
                return true;
            }

            if(obj instanceof String) {
                String objStr = (String)obj;
                if(objStr == null || "".equals(objStr.trim())) {
                    result = true;
                }
            }else if(obj == null){
                result = true;
            }
        }

        return result;
    }
}
