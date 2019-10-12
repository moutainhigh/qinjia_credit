package com.marvels.service;

import com.marvels.common.enums.PublicEnums;

/**
 * @Description: 接口日志类
 * @Author: houyl
 * @Date: 2019/10/11 上午 10:12
 */
public interface QjItfLogService {

    /**
     * 玖富记录接口日志（异步）
     *
     * @param enums  枚举
     * @param inParam  记录入参
     * @param outParam 记录出参
     */
    void inOutParamsItfLog(PublicEnums.JfInterfaceCodeEnum enums, Object inParam, Object outParam);

    /**
     * 盛银记录接口日志（异步）
     *
     * @param enums  枚举
     * @param inParam  记录入参
     * @param outParam 记录出参
     */
    void inOutParamsItfLog(PublicEnums.SyInterfaceCodeEnum enums, Object inParam, Object outParam);
}
