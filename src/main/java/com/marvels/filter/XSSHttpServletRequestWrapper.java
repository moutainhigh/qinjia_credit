package com.marvels.filter;

import com.marvels.common.CommonConst;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * 替换传递过来的参数中的非法字符成合法字符，防止XSS攻击
 * @author houyl
 * @date 2019/10/21 10:38
 */
public class XSSHttpServletRequestWrapper extends HttpServletRequestWrapper{

    /**
     * 构造函数
     * @param servletRequest
     */
    public XSSHttpServletRequestWrapper(HttpServletRequest servletRequest) {
        super(servletRequest);
    }

    @Override
    public String[] getParameterValues(String parameter) {
        String[] values = super.getParameterValues(parameter);
        if (values == null) {
            return null;
        }
        int count = values.length;
        String[] encodedValues = new String[count];
        for (int i = 0; i < count; i++) {
            encodedValues[i] = cleanXSS(values[i]);
        }
        return encodedValues;
    }

    @Override
    public String getParameter(String parameter) {
        String value = super.getParameter(parameter);
        if (value == null) {
            return null;
        }
        return cleanXSS(value);
    }

    @Override
    public String getHeader(String name) {
        String value = super.getHeader(name);
        if (value == null) {
            return null;
        }
        return cleanXSS(value);
    }


    /**
     * 替换非法字符为合法字符<br>
     *
     * @param value 非法字符
     * @return 替换后的合法字符
     */
    private String cleanXSS(String value) {
        if (value != null) {
            value = value.replaceAll(CommonConst.ILLEGAL_CHAR1, CommonConst.CH_ILLEGAL_CHAR1)
                    .replaceAll(CommonConst.ILLEGAL_CHAR2, CommonConst.CH_ILLEGAL_CHAR2)
                    .replaceAll(CommonConst.ILLEGAL_CHAR3, CommonConst.CH_ILLEGAL_CHAR3)
                    .replaceAll(CommonConst.ILLEGAL_CHAR4, CommonConst.CH_ILLEGAL_CHAR4)
                    .replaceAll(CommonConst.ILLEGAL_CHAR5, CommonConst.CH_ILLEGAL_CHAR5)
                    .replaceAll(CommonConst.LT, CommonConst.LTC).replaceAll(CommonConst.GT, CommonConst.GTC)
                    .replaceAll(CommonConst.QUOT, CommonConst.QUOTC);
        }
        return value;
    }
}
