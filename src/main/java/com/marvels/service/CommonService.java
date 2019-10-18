package com.marvels.service;

import com.marvels.dto.common.ApiLog;

/**
 * @Description: 接口日志类
 * @Author: houyl
 * @Date: 2019/10/11 上午 10:12
 */
public interface CommonService {

    /**
     * 玖富记录接口日志
     *
     * @param qjItfLog
     */
    void saveApiLog(ApiLog apiLog);
}
