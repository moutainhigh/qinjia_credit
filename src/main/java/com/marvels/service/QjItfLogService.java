package com.marvels.service;

/**
 * @Description: 接口日志类
 * @Author: houyl
 * @Date: 2019/10/11 上午 10:12
 */
public interface QjItfLogService {

    /**
     * 记录接口日志
     * @param itfCode 接口编码（枚举InterfaceCodeEnum）
     * @param inParam 记录入参
     * @param outParam 记录出参
     */
    void inParamsItfLog(String itfCode, Object inParam, Object outParam);
}
