package com.marvels.service;

import com.marvels.dto.common.QjItfLog;

/**
 * @Description: 接口日志类
 * @Author: houyl
 * @Date: 2019/10/11 上午 10:12
 */
public interface QjItfLogService {

    /**
     * 玖富记录接口日志
     *
     * @param qjItfLog
     */
    void inOutParamsItfLog(QjItfLog qjItfLog);
}
