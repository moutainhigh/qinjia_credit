package com.marvels.service;

import com.aliyuncs.CommonResponse;
import com.marvels.dto.common.ApiLog;
import com.marvels.dto.common.SendSmsReq;
import com.marvels.dto.jf.JfRequestDto;
import com.marvels.dto.jf.JfResponseDto;

/**
 * @Description: 接口日志类
 * @Author: houyl
 * @Date: 2019/10/11 上午 10:12
 */
public interface CommonService {

    /**
     * 玖富记录接口日志
     *
     * @param apiLog
     */
    void saveApiLog(ApiLog apiLog);

    /**
     * 发送短信服务
     * @param param
     * @throws Exception
     * @return
     */
    JfResponseDto sendSms(JfRequestDto<SendSmsReq> param) throws Exception;
}
